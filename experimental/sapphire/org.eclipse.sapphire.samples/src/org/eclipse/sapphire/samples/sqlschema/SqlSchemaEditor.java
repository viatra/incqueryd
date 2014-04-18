/******************************************************************************
 * Copyright (c) 2013 Oracle and Liferay
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Shenxue Zhou - initial implementation and ongoing maintenance
 ******************************************************************************/

package org.eclipse.sapphire.samples.sqlschema;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.modeling.xml.RootXmlResource;
import org.eclipse.sapphire.ui.SapphireEditor;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.MasterDetailsEditorPage;
import org.eclipse.sapphire.ui.swt.gef.SapphireDiagramEditor;
import org.eclipse.sapphire.ui.swt.xml.editor.XmlEditorResourceStore;
import org.eclipse.ui.PartInitException;
import org.eclipse.wst.sse.ui.StructuredTextEditor;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 */

public class SqlSchemaEditor extends SapphireEditor 
{
    private Schema schemaModel;
    private StructuredTextEditor schemaSourceEditor;
    private SapphireDiagramEditor schemaDiagram;
    private MasterDetailsEditorPage schemaDetails;
	    
    @Override
    protected void createSourcePages() throws PartInitException 
    {
        this.schemaSourceEditor = new StructuredTextEditor();
        this.schemaSourceEditor.setEditorPart(this);
        
        int index = addPage( this.schemaSourceEditor, getEditorInput() );
        setPageText( index, "Source" );
    }

    @Override
    protected Element createModel() 
    {
        this.schemaModel = Schema.TYPE.instantiate(new RootXmlResource(new XmlEditorResourceStore(this, this.schemaSourceEditor)));
        return this.schemaModel;
    }

    @Override
    protected void createDiagramPages() throws PartInitException
    {		
        this.schemaDiagram = new SapphireDiagramEditor
		(
		    this, this.schemaModel, 
		    DefinitionLoader.sdef( getClass() ).page( "DiagramPage" )
		);
		
        addEditorPage( 0, this.schemaDiagram );
        
    }
    
    @Override
    protected void createFormPages() throws PartInitException 
    {
        this.schemaDetails = new MasterDetailsEditorPage
        (
            this, this.schemaModel,
            DefinitionLoader.sdef( getClass() ).page( "DetailsPage" )
        );
        
        addPage( 1, this.schemaDetails );
    }
    

    public Schema getSchema()
    {
        return this.schemaModel;
    }
    
    @Override
    public void doSave( final IProgressMonitor monitor )
    {
        this.schemaDiagram.doSave(monitor);
        super.doSave(monitor);        
    }
    

}
