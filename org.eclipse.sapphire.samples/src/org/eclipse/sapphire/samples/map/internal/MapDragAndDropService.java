/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Shenxue Zhou - initial implementation and ongoing maintenance
 *    Konstantin Komissarchik - miscellaneous improvements
 ******************************************************************************/

package org.eclipse.sapphire.samples.map.internal;

import static org.eclipse.sapphire.util.StringUtil.UTF8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.sapphire.LoggingService;
import org.eclipse.sapphire.Sapphire;
import org.eclipse.sapphire.samples.map.Location;
import org.eclipse.sapphire.samples.map.Map;
import org.eclipse.sapphire.ui.DragAndDropService;
import org.eclipse.sapphire.ui.Point;
import org.eclipse.sapphire.ui.diagram.editor.DiagramNodePart;
import org.eclipse.sapphire.ui.diagram.editor.SapphireDiagramEditorPagePart;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public class MapDragAndDropService extends DragAndDropService 
{
    @Override
    public boolean droppable( final DropContext context ) 
    {
        return context.object() instanceof IFile;
    }

    @Override
    public void drop( final DropContext context ) 
    {
        final IFile file = (IFile) context.object();
        final List<String> locations = new ArrayList<String>();
        
        InputStream in = null;
        
        try
        {
            in = file.getContents();
            final BufferedReader br = new BufferedReader( new InputStreamReader( in, UTF8 ) );
            
            for( String line = br.readLine(); line != null; line = br.readLine() )
            {
                line = line.trim();
                
                if( line.length() > 0 )
                {
                    locations.add( line );
                }
            }
        }
        catch( CoreException e )
        {
            Sapphire.service( LoggingService.class ).log( e );
        }
        catch( IOException e )
        {
            Sapphire.service( LoggingService.class ).log( e );
        }
        finally
        {
            if( in != null )
            {
                try
                {
                    in.close();
                }
                catch( IOException e ) {}
            }
        }
        
        if( ! locations.isEmpty() )
        {
            final SapphireDiagramEditorPagePart diagram = context( SapphireDiagramEditorPagePart.class );
            final Map map = context( Map.class );
            
            final Point initialDropPosition = context.position();
            
            int x = initialDropPosition.getX();
            int y = initialDropPosition.getY();
            
            for( String locationName : locations )
            {
                if( ! map.hasLocation( locationName ) )
                {
                    final Location location = map.getLocations().insert();
                    location.setName( locationName );
                    
                    final DiagramNodePart locationNodePart = diagram.getDiagramNodePart(location);
                    locationNodePart.setNodeBounds( x, y );
                    
                    x += 50;
                    y += 50;
                }
            }
        }
    }

}
