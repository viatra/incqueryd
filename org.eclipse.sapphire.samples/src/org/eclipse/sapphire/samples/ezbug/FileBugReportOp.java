/******************************************************************************
 * Copyright (c) 2013 Oracle and Accenture
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation
 *    Kamesh Sampath - [355751] General improvement of XML root binding API    
 ******************************************************************************/

package org.eclipse.sapphire.samples.ezbug;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ExecutableElement;
import org.eclipse.sapphire.ImpliedElementProperty;
import org.eclipse.sapphire.modeling.ProgressMonitor;
import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.modeling.annotations.DelegateImplementation;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Type;
import org.eclipse.sapphire.modeling.xml.annotations.XmlBinding;
import org.eclipse.sapphire.samples.ezbug.internal.FileBugReportOpMethods;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 * @author <a href="mailto:kamesh.sampath@accenture.com">Kamesh Sampath</a>
 */

@XmlBinding( path = "report" )

public interface FileBugReportOp extends ExecutableElement
{
    ElementType TYPE = new ElementType( FileBugReportOp.class );
    
    // *** BugReport ***
    
    @Type( base = BugReport.class )
    @Label( standard = "bug report" )
    @XmlBinding( path = "bug" )
    
    ImpliedElementProperty PROP_BUG_REPORT = new ImpliedElementProperty( TYPE, "BugReport" );
    
    BugReport getBugReport();
    
    // *** Method: execute ***
    
    @DelegateImplementation( FileBugReportOpMethods.class )
    
    Status execute( ProgressMonitor monitor );
    
}
