/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Konstantin Komissarchik - initial implementation
 ******************************************************************************/

package org.eclipse.sapphire.samples.po;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.modeling.xml.RootXmlResource;
import org.eclipse.sapphire.ui.SapphireEditor;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.FormEditorPage;
import org.eclipse.sapphire.ui.swt.xml.editor.XmlEditorResourceStore;
import org.eclipse.ui.PartInitException;
import org.eclipse.wst.sse.ui.StructuredTextEditor;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class PurchaseOrderEditor extends SapphireEditor
{
    private PurchaseOrder model;
    private StructuredTextEditor pageSource;
    private FormEditorPage pageGeneral;
    private FormEditorPage pageEntries;
    
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
        this.model = PurchaseOrder.TYPE.instantiate( new RootXmlResource( new XmlEditorResourceStore( this, this.pageSource ) ) );
        return this.model;
    }

    @Override
    protected void createFormPages() throws PartInitException 
    {
        this.pageGeneral = new FormEditorPage
        (
            this, this.model,
            DefinitionLoader.sdef( getClass() ).page( "GeneralPage" )
        );
        
        addPage( 0, this.pageGeneral );

        this.pageEntries = new FormEditorPage
        (
            this, this.model,
            DefinitionLoader.sdef( getClass() ).page( "EntriesPage" )
        );
        
        addPage( 1, this.pageEntries );
    }
    
}
