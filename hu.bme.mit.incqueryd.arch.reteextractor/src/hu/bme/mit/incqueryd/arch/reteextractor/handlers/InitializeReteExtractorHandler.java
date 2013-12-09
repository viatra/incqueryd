/*******************************************************************************
 * Copyright (c) 2010-2013, Zoltan Ujhelyi, Istvan Rath and Daniel Varro
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Istvan Rath - initial API and implementation
 *******************************************************************************/

package hu.bme.mit.incqueryd.arch.reteextractor.handlers;

import hu.bme.mit.incqueryd.arch.reteextractor.ReteExtractor;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.incquery.patternlanguage.patternLanguage.Pattern;
import org.eclipse.incquery.runtime.api.AdvancedIncQueryEngine;
import org.eclipse.incquery.runtime.exception.IncQueryException;
import org.eclipse.incquery.runtime.rete.boundary.ReteBoundary;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.ObservablePatternMatcher;
import org.eclipse.incquery.tooling.ui.queryexplorer.content.matcher.ObservablePatternMatcherRoot;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Temporary handler class to initialize the IncQuery-D Rete Layout Extractor.
 * 
 * @author Istvan Rath
 * 
 */
public class InitializeReteExtractorHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        
        ISelection selection = HandlerUtil.getActiveMenuSelection(event);
        if (selection instanceof TreeSelection) {
            ObservablePatternMatcherRoot root = getSelectedMatcherRoot(selection);
            if (root.getMatchers()!=null && root.getMatchers().size()>0)
            try {
                ObservablePatternMatcher pm = root.getMatchers().get(0);
                // String patternFqn = pl.getFullPatternNamePrefix()+"."+pl.getPatternNameFragment();
                ReteBoundary<Pattern> rb = ((AdvancedIncQueryEngine)pm.getMatcher().getEngine()).getReteEngine().getBoundary();
                // TODO do the meaningful work here
                // step 1: select target file
                SaveAsDialog sad = new SaveAsDialog(Display.getDefault().getActiveShell());
                sad.setTitle("Select target file for Rete extraction");   
                sad.setBlockOnOpen(true);
                if (Window.OK == sad.open()) {
                    ReteExtractor.extractReteToFile(rb, sad.getResult());
                }
            } catch (IncQueryException e) {
                throw new ExecutionException("Error initializing pattern matcher.", e);
            } catch (IllegalArgumentException e) {
                throw new ExecutionException("Invalid selrection", e);
            }
        }
        
        return null;
    }

    protected ObservablePatternMatcherRoot getSelectedMatcherRoot(ISelection selection) {
        Object firstElement = ((TreeSelection) selection).getFirstElement();
        if (firstElement instanceof ObservablePatternMatcherRoot) {
            return (ObservablePatternMatcherRoot) firstElement;
        } else if (firstElement instanceof ObservablePatternMatcher) {
            return ((ObservablePatternMatcher) firstElement).getParent();
        } else {
            throw new IllegalArgumentException("Selection should contain an Pattern match from the query explorer");
        }
    }


}
