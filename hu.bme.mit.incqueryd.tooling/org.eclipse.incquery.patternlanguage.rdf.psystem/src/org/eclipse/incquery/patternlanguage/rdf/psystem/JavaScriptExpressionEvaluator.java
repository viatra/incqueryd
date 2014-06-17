package org.eclipse.incquery.patternlanguage.rdf.psystem;

import static com.google.common.collect.ImmutableSet.copyOf;
import static com.google.common.collect.Sets.intersection;

import java.util.Set;

import org.eclipse.incquery.runtime.matchers.psystem.IExpressionEvaluator;
import org.eclipse.incquery.runtime.matchers.psystem.IValueProvider;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.NodeVisitor;

import com.google.common.collect.Sets;

public class JavaScriptExpressionEvaluator implements IExpressionEvaluator {

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
		// Not used here
		return null;
	}

	public Iterable<String> getInputParameterNames() {
		return inputParameterNames;
	}

	public String getShortDescription() {
		return expression;
	}

}
