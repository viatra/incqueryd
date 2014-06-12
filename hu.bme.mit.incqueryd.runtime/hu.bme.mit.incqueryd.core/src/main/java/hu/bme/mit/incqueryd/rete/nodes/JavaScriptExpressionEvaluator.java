package hu.bme.mit.incqueryd.rete.nodes;

import static com.google.common.collect.ImmutableSet.copyOf;
import static org.elasticsearch.common.collect.Sets.intersection;

import java.io.Serializable;
import java.util.Set;

import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NodeVisitor;

import com.google.common.collect.Sets;

public class JavaScriptExpressionEvaluator implements IExpressionEvaluator, Serializable {

	private static final long serialVersionUID = 3223013804728828212L;

	private final String expression;

	private final Set<String> inputParameterNames;

	public JavaScriptExpressionEvaluator(final String expression, final Set<String> allVariableNames) {
		this.expression = expression;
		final Parser parser = new Parser();
		final AstRoot astRoot = parser.parse(expression, "", 0);
		Set<String> referencedVariableNames = getAllNames(astRoot);
		inputParameterNames = copyOf(intersection(referencedVariableNames, allVariableNames));
	}

	private Set<String> getAllNames(final AstRoot astRoot) {
		final Set<String> result = Sets.newHashSet();
		astRoot.visit(new NodeVisitor() {
			@Override
			public boolean visit(AstNode node) {
				if (node instanceof Name) {
					result.add(node.getString());
				}
				return true;
			}
		});
		return result;
	}

	public Object evaluateExpression(final IValueProvider provider) throws Exception {
		// Creates and enters a Context. The Context stores information
		// about the execution environment of a script.
		final Context cx = Context.enter();
		try {
			// Initialize the standard objects (Object, Function, etc.)
			// This must be done before scripts can be executed. Returns
			// a scope object that we use in later calls.
			final Scriptable scope = cx.initStandardObjects();
			for (String parameterName : inputParameterNames) {
				scope.put(parameterName, scope, provider.getValue(parameterName));
			}
			// Now evaluate the string we've colected.
			final Object result = cx.evaluateString(scope, expression, "<cmd>", 1, null);
			return (boolean) result;
		} finally {
			Context.exit();
		}
	}

	public Iterable<String> getInputParameterNames() {
		return this.inputParameterNames;
	}

	public String getShortDescription() {
		return this.expression;
	}

}
