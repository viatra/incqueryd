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

package org.eclipse.sapphire.samples.sqlschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.sapphire.ui.def.DefinitionLoader;
import org.eclipse.sapphire.ui.diagram.DiagramConnectionPart;
import org.eclipse.sapphire.ui.diagram.StandardConnectionService;
import org.eclipse.sapphire.ui.diagram.editor.DiagramNodePart;
import org.eclipse.sapphire.ui.forms.swt.SapphireWizard;
import org.eclipse.swt.widgets.Display;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class SqlSchemaConnectionService extends StandardConnectionService
{
    @Override
    public DiagramConnectionPart connect( final DiagramNodePart node1, final DiagramNodePart node2, final String connectionType )
    {
        final DiagramConnectionPart fkConnectionPart = super.connect( node1, node2, connectionType );
        final ForeignKey fk = (ForeignKey) fkConnectionPart.getLocalModelElement();
        
        final Table referencedTable = fk.getReferencedTable().resolve();
        
        if( referencedTable != null )
        {
            for( final Column column : referencedTable.getColumns() )
            {
                if( column.getIsPrimaryKey().content() )
                {
                    fk.getColumnAssociations().insert().setReferencedColumn( column.getName().content() );
                }
            }
        }
        
        if( ! fk.getColumnAssociations().isEmpty() )
        {
            // Make an intelligent guess on local columns by looking for a prefix naming pattern.
            
            final Table table = (Table) fk.parent().element();
            final List<String> prefixes = new ArrayList<String>();
            final String firstReferencedColumnName = fk.getColumnAssociations().get( 0 ).getReferencedColumn().content();
            
            for( final Column column : table.getColumns() )
            {
                final String localColumnName = column.getName().content();
                
                if( localColumnName != null && localColumnName.endsWith( firstReferencedColumnName ) )
                {
                    prefixes.add( localColumnName.substring( 0, localColumnName.length() - firstReferencedColumnName.length() ) );
                }
            }
            
            for( final String prefix : prefixes )
            {
                boolean match = true;
                
                for( final ForeignKey.ColumnAssociation association : fk.getColumnAssociations() )
                {
                    final Column candidateLocalColumn = find( table.getColumns(), prefix + association.getReferencedColumn().content() );
                    
                    if( candidateLocalColumn == null || ! equal( candidateLocalColumn.getType().content(), association.getReferencedColumn().resolve().getType().content() ) )
                    {
                        match = false;
                        break;
                    }
                }
                
                if( match )
                {
                    for( final ForeignKey.ColumnAssociation association : fk.getColumnAssociations() )
                    {
                        association.setLocalColumn( prefix + association.getReferencedColumn().content() );
                    }
                    
                    break;
                }
            }
        }
        
        final SapphireWizard<ForeignKey> wizard = new SapphireWizard<ForeignKey>( fk, DefinitionLoader.sdef( SqlSchemaEditor.class ).wizard( "DefineForeignKeyWizard" ) )
        {
            @Override
            public boolean performCancel()
            {
                fkConnectionPart.remove();
                return true;
            }
        };
        
        final WizardDialog dialog = new WizardDialog( Display.getDefault().getActiveShell(), wizard );
        
        dialog.open();
        
        return ( fk.disposed() ? null : fkConnectionPart );
    }
    
    private static Column find( final List<Column> columns, final String name )
    {
        for( final Column column : columns )
        {
            final String n = column.getName().content();
            
            if( n != null && n.equals( name ) )
            {
                return column;
            }
        }
        
        return null;
    }
    
    public static final boolean equal( final Object a, final Object b )
    {
        if( a == b )
        {
            return true;
        }
        else if( a != null && b != null )
        {
            return a.equals( b );
        }

        return false;
    }
    
}
