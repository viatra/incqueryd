/******************************************************************************
 * Copyright (c) 2013 Oracle and Liferay
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Shenxue Zhou - initial implementation and ongoing maintenance
 *    Gregory Amerson - [374022] SapphireGraphicalEditor init with SapphireEditor
 *    Konstantin Komissarchik - miscellaneous improvements
 ******************************************************************************/

package org.eclipse.sapphire.samples.map;

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
 * @author <a href="mailto:gregory.amerson@liferay.com">Gregory Amerson</a>
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class MapEditor extends SapphireEditor 
{
    private Map modelMap;
    private StructuredTextEditor mapSourceEditor;
    private SapphireDiagramEditor mapDiagram;
    private MasterDetailsEditorPage mapDetailsPage;
    
    @Override
    protected void createSourcePages() throws PartInitException 
    {
        this.mapSourceEditor = new StructuredTextEditor();
        this.mapSourceEditor.setEditorPart(this);
        
        int index = addPage( this.mapSourceEditor, getEditorInput() );
        setPageText( index, "map.xml" );
    }

    @Override
    protected Element createModel() 
    {
        this.modelMap = Map.TYPE.instantiate(new RootXmlResource(new XmlEditorResourceStore(this, this.mapSourceEditor)));
        return this.modelMap;
    }

    @Override
    protected void createDiagramPages() throws PartInitException
    {
		this.mapDiagram = new SapphireDiagramEditor
		(
		    this, this.modelMap, 
		    DefinitionLoader.sdef( getClass() ).page( "DiagramPage" )
		);
		
        addEditorPage( 0, this.mapDiagram );
    }
    
    @Override
    protected void createFormPages() throws PartInitException 
    {
        this.mapDetailsPage = new MasterDetailsEditorPage
        (
            this, this.modelMap,
            DefinitionLoader.sdef( getClass() ).page( "DetailsPage" )
        );
        
        addPage( 1, this.mapDetailsPage );
    }

    public Map getMap()
    {
        return this.modelMap;
    }
    
    @Override
    public void doSave( final IProgressMonitor monitor )
    {
        this.mapDiagram.doSave(monitor);
        super.doSave(monitor);        
    }
    
}
