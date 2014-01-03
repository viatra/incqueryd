/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation and ongoing maintenance
 ******************************************************************************/

package org.eclipse.sapphire.samples.uml;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.modeling.xml.RootXmlResource;
import org.eclipse.sapphire.ui.SapphireEditor;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.swt.gef.SapphireDiagramEditor;
import org.eclipse.sapphire.ui.swt.xml.editor.XmlEditorResourceStore;
import org.eclipse.ui.PartInitException;
import org.eclipse.wst.sse.ui.StructuredTextEditor;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public class SystemStructureEditor extends SapphireEditor 
{
    private System model;
    private StructuredTextEditor sourceEditorPage;
    private SapphireDiagramEditor diagramEditorPage;
    //private MasterDetailsEditorPage schemaDetails;
	    
    @Override
    protected void createSourcePages() throws PartInitException 
    {
        this.sourceEditorPage = new StructuredTextEditor();
        this.sourceEditorPage.setEditorPart( this );
        
        int index = addPage( this.sourceEditorPage, getEditorInput() );
        setPageText( index, "Source" );
    }

    @Override
    protected Element createModel() 
    {
        this.model = System.TYPE.instantiate( new RootXmlResource( new XmlEditorResourceStore( this, this.sourceEditorPage ) ) );
        return this.model;
    }

    @Override
    protected void createDiagramPages() throws PartInitException
    {		
        this.diagramEditorPage = new SapphireDiagramEditor
		(
		    this, this.model, 
		    DefinitionLoader.sdef( getClass() ).page( "DiagramPage" )
		);
		
        addEditorPage( 0, this.diagramEditorPage );
        
    }
    
    @Override
    protected void createFormPages() throws PartInitException 
    {
        /*this.schemaDetails = new MasterDetailsEditorPage
        (
            this, this.schemaModel,
            DefinitionLoader.sdef( getClass() ).page( "DetailsPage" )
        );
        
        addPage( 1, this.schemaDetails );*/
    }
    
    @Override
    public void doSave( final IProgressMonitor monitor )
    {
        this.diagramEditorPage.doSave( monitor );
        super.doSave(monitor);        
    }
    

}
