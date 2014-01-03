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

package org.eclipse.sapphire.samples.calendar.integrated;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Path;
import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.LocalizableText;
import org.eclipse.sapphire.Text;
import org.eclipse.sapphire.modeling.CorruptedResourceExceptionInterceptor;
import org.eclipse.sapphire.modeling.xml.RootXmlResource;
import org.eclipse.sapphire.samples.calendar.ICalendar;
import org.eclipse.sapphire.samples.calendar.integrated.internal.CalendarResource;
import org.eclipse.sapphire.samples.contacts.ContactRepository;
import org.eclipse.sapphire.ui.CorruptedResourceExceptionInterceptorImpl;
import org.eclipse.sapphire.ui.SapphireEditor;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.forms.swt.MasterDetailsEditorPage;
import org.eclipse.sapphire.ui.swt.xml.editor.XmlEditorResourceStore;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.wst.sse.ui.StructuredTextEditor;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class CalendarEditor extends SapphireEditor
{
    @Text( "Contacts" )
    private static LocalizableText contactsPageName;
    
    static
    {
        LocalizableText.init( CalendarEditor.class );
    }

    private StructuredTextEditor calendarSourceEditor;
    private StructuredTextEditor contactsSourceEditor;
    
    private ICalendar modelCalendar;
    private org.eclipse.sapphire.samples.calendar.integrated.ICalendar modelCalendarIntegrated;
    private ContactRepository modelContacts;
    
    private MasterDetailsEditorPage calendarDesignPage;
    private MasterDetailsEditorPage contactsDesignPage;

    @Override
    protected void createSourcePages()

        throws PartInitException
        
    {
        this.calendarSourceEditor = new StructuredTextEditor();
        this.calendarSourceEditor.setEditorPart(this);
        
        final FileEditorInput rootEditorInput = (FileEditorInput) getEditorInput();
        
        int index = addPage( this.calendarSourceEditor, rootEditorInput );
        setPageText( index, "calendar.xml" );

        this.contactsSourceEditor = new StructuredTextEditor();
        this.contactsSourceEditor.setEditorPart(this);
        
        final IFile contactsFile = rootEditorInput.getFile().getParent().getFile( new Path( "contacts.xml" ) );
        
        index = addPage( this.contactsSourceEditor, new FileEditorInput( contactsFile ) );
        setPageText( index, "contacts.xml" );
    }
    
    @Override
    protected Element createModel()
    {
        this.modelCalendar = ICalendar.TYPE.instantiate( new RootXmlResource( new XmlEditorResourceStore( this, this.calendarSourceEditor ) ) );
        this.modelContacts = ContactRepository.TYPE.instantiate( new RootXmlResource( new XmlEditorResourceStore( this, this.contactsSourceEditor ) ) );
        this.modelCalendarIntegrated = org.eclipse.sapphire.samples.calendar.integrated.ICalendar.TYPE.instantiate( new CalendarResource( this.modelCalendar, this.modelContacts ) );
        
        return this.modelCalendarIntegrated;
    }
    
    @Override
    protected void adaptModel( final Element model )
    {
        final CorruptedResourceExceptionInterceptor interceptor 
            = new CorruptedResourceExceptionInterceptorImpl( getEditorSite().getShell() );
        
        this.modelCalendar.resource().setCorruptedResourceExceptionInterceptor( interceptor );
        this.modelContacts.resource().setCorruptedResourceExceptionInterceptor( interceptor );
    }
    
    @Override
    protected final void createFormPages() throws PartInitException
    {
        this.calendarDesignPage = new MasterDetailsEditorPage
        (
            this, this.modelCalendarIntegrated,
            DefinitionLoader.sdef( getClass() ).page()
        );
        
        addPage( 0, this.calendarDesignPage );

        this.contactsDesignPage = new MasterDetailsEditorPage
        (
            this, this.modelContacts,
            DefinitionLoader.context( ContactRepository.class ).sdef( "ContactRepositoryEditor" ).page(),
            contactsPageName.text()
        );
        
        addPage( 1, this.contactsDesignPage );
    }

    @Override
    public IContentOutlinePage getContentOutline( final Object page )
    {
        if( page == this.calendarSourceEditor )
        {
            return (IContentOutlinePage) this.calendarSourceEditor.getAdapter( IContentOutlinePage.class );
        }
        else if( page == this.contactsSourceEditor )
        {
            return (IContentOutlinePage) this.contactsSourceEditor.getAdapter( IContentOutlinePage.class );
        }
        
        return super.getContentOutline( page );
    }
    
    public ICalendar getCalendar()
    {
        return this.modelCalendar;
    }
    
    public org.eclipse.sapphire.samples.calendar.integrated.ICalendar getCalendarIntegrated()
    {
        return this.modelCalendarIntegrated;
    }
    
    public ContactRepository getContactRepository()
    {
        return this.modelContacts;
    }
    
}
