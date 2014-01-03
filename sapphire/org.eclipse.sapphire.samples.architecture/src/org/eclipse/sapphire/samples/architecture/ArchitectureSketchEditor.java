/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation
 *    Shenxue Zhou - handle external file input
 *    Gregory Amerson - [374022] - SapphireGraphicalEditor init with SapphireEditor
 ******************************************************************************/

package org.eclipse.sapphire.samples.architecture;

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
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class ArchitectureSketchEditor extends SapphireEditor
{
    private ArchitectureSketch architectureModel;
    private StructuredTextEditor pageSource;
    private SapphireDiagramEditor pageDiagram;
    private MasterDetailsEditorPage pageDetails;
    
    @Override
    protected void createSourcePages() throws PartInitException 
    {
        this.pageSource = new StructuredTextEditor();
        this.pageSource.setEditorPart( this );
        
        int index = addPage( this.pageSource, getEditorInput() );
        setPageText( index, "Source" );
    }

    @Override
    protected Element createModel() 
    {
        this.architectureModel = ArchitectureSketch.TYPE.instantiate( new RootXmlResource( new XmlEditorResourceStore( this, this.pageSource ) ) );
        return this.architectureModel;
    }

    @Override
    protected void createDiagramPages() throws PartInitException
    {
		this.pageDiagram = new SapphireDiagramEditor
		(
		    this, this.architectureModel, 
		    DefinitionLoader.sdef( getClass() ).page( "DiagramPage" )
		);
		
        addEditorPage( 0, this.pageDiagram );
    }
    
    @Override
    protected void createFormPages() throws PartInitException 
    {
        this.pageDetails = new MasterDetailsEditorPage
        (
            this, this.architectureModel,
            DefinitionLoader.sdef( getClass() ).page( "DetailsPage" )
        );
        
        addPage( 1, this.pageDetails );
    }

    @Override
    public void doSave( final IProgressMonitor monitor )
    {
        this.pageDiagram.doSave( monitor );
        super.doSave( monitor );        
    }
    
}
