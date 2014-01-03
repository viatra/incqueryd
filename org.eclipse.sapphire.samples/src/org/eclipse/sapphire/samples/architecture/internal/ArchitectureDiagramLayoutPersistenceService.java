/******************************************************************************
 * Copyright (c) 2013 Oracle
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Shenxue Zhou - initial implementation and ongoing maintenance
 *    Konstantin Komissarchik - [378756] Convert ModelElementListener and ModelPropertyListener to common listener infrastructure
 *    Konstantin Komissarchik - [376245] Revert action in StructuredTextEditor does not revert diagram nodes and connections in SapphireDiagramEditor
 *    Konstantin Komissarchik - [381233] IllegalStateException in ServiceContext when modifying xml in source editor in Architecture sample
 *    Ling Hao - [383924]  Flexible diagram node shapes
 ******************************************************************************/

package org.eclipse.sapphire.samples.architecture.internal;

import static java.lang.Math.min;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.Event;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.PropertyEvent;
import org.eclipse.sapphire.samples.architecture.ArchitectureSketch;
import org.eclipse.sapphire.samples.architecture.Component;
import org.eclipse.sapphire.samples.architecture.ComponentDependency;
import org.eclipse.sapphire.samples.architecture.ConnectionBendpoint;
import org.eclipse.sapphire.ui.Bounds;
import org.eclipse.sapphire.ui.Point;
import org.eclipse.sapphire.ui.diagram.ConnectionAddEvent;
import org.eclipse.sapphire.ui.diagram.ConnectionBendpointsEvent;
import org.eclipse.sapphire.ui.diagram.ConnectionDeleteEvent;
import org.eclipse.sapphire.ui.diagram.ConnectionService;
import org.eclipse.sapphire.ui.diagram.DiagramConnectionPart;
import org.eclipse.sapphire.ui.diagram.editor.DiagramNodeBounds;
import org.eclipse.sapphire.ui.diagram.editor.DiagramNodeEvent;
import org.eclipse.sapphire.ui.diagram.editor.DiagramNodePart;
import org.eclipse.sapphire.ui.diagram.editor.DiagramPageEvent;
import org.eclipse.sapphire.ui.diagram.editor.SapphireDiagramEditorPagePart;
import org.eclipse.sapphire.ui.diagram.editor.SapphireDiagramEditorPagePart.PostAutoLayoutEvent;
import org.eclipse.sapphire.ui.diagram.editor.SapphireDiagramEditorPagePart.PreAutoLayoutEvent;
import org.eclipse.sapphire.ui.diagram.layout.ConnectionHashKey;
import org.eclipse.sapphire.ui.diagram.layout.DiagramLayoutPersistenceService;

/**
 * @author <a href="mailto:shenxue.zhou@oracle.com">Shenxue Zhou</a>
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 * @author <a href="mailto:ling.hao@oracle.com">Ling Hao</a>
 */

public class ArchitectureDiagramLayoutPersistenceService extends DiagramLayoutPersistenceService 
{
	private ArchitectureSketch architecture;
	private Listener diagramPartListener;
	private Listener connectionPartListener;
	private Listener componentListener;	
	private Listener componentDependencyListener;
	private Map<String, DiagramNodeBounds> nodeBounds;
	private Map<ConnectionHashKey, List<Point>> connectionBendPoints;
	private boolean dirty;
	private boolean autoLayout = false;
	
	@Override
    protected void init()
    {
    	super.init();    	
    	this.architecture = (ArchitectureSketch)context( SapphireDiagramEditorPagePart.class ).getLocalModelElement();
    	this.nodeBounds = new HashMap<String, DiagramNodeBounds>();
    	this.connectionBendPoints = new HashMap<ConnectionHashKey, List<Point>>();
    	this.dirty = false;    	
		this.connectionPartListener = new FilteredListener<ConnectionBendpointsEvent>() 
		{
			@Override
			protected void handleTypedEvent(ConnectionBendpointsEvent event) 
			{
				if (event.reset())
				{
			    	if (autoLayout)
			    	{
			    		addConnectionToPersistenceCache(event.part());
			    		refreshDirtyState();
			    	}
			    	else
			    	{
			    		write(event.part());
			    	}
					
				}
				else
				{
					write(event.part());
				}
			}
		};
		
    	load();
    	refreshPersistedPartsCache();
    	addDiagramPartListener();
    	addModelListeners();
    }

	private void setGridVisible(boolean visible)
	{
		this.architecture.setShowGrid(visible);
	}
	
	private void setGuidesVisible(boolean visible)
	{
		this.architecture.setShowGuides(visible);
	}

	private void read(DiagramNodePart nodePart)
	{
		
		Component component = (Component)nodePart.getLocalModelElement();
		if (!component.disposed())
		{
			String nodeId = nodePart.getId();
	    	if (this.nodeBounds.containsKey(nodeId) && this.nodeBounds.get(nodeId) != null)
	    	{
	    		nodePart.setNodeBounds(this.nodeBounds.get(nodeId)); 		
	    	}
		}
	}
	
	private void write(DiagramNodePart nodePart) 
	{
		Component component = (Component)nodePart.getLocalModelElement();
		if (!component.disposed())
		{
			if (isNodeLayoutChanged(nodePart))
			{				
				this.architecture.detach(this.componentListener, "/Components/Position/*");
				writeComponentBounds(component, nodePart);
				this.architecture.attach(this.componentListener, "/Components/Position/*");
			}
			
			refreshDirtyState();
		}		
	}

	public DiagramConnectionInfo read(DiagramConnectionPart connPart)
	{
    	ConnectionHashKey key = ConnectionHashKey.createKey(connPart);
    	if (this.connectionBendPoints.containsKey(key))
    	{
    		DiagramConnectionInfo connectionInfo = new DiagramConnectionInfo(this.connectionBendPoints.get(key));
    		return connectionInfo;
    	}
    	else
    	{
    		return null;
    	}
	}
	
	private void write(DiagramConnectionPart connPart) 
	{
		ComponentDependency dependency = (ComponentDependency)connPart.getLocalModelElement();
		if (!dependency.disposed())
		{
			if (isConnectionLayoutChanged(connPart))
			{
				this.architecture.detach(this.componentDependencyListener, "/Components/Dependencies/ConnectionBendpoints/*");
				writeDependencyBendPoints(dependency, connPart);
				this.architecture.attach(this.componentDependencyListener, "/Components/Dependencies/ConnectionBendpoints/*");
			}
			
			refreshDirtyState();
		}			
	}
	
	@Override
	public void dispose()
	{
		if (this.diagramPartListener != null)
		{
		    context( SapphireDiagramEditorPagePart.class ).detach(this.diagramPartListener);
		}
		if (this.componentListener != null)
		{
			this.architecture.detach(this.componentListener, "/Components/Position/*");
		}
		if (this.componentDependencyListener != null)
		{
			this.architecture.detach(this.componentDependencyListener, "/Components/Dependencies/ConnectionBendpoints/*");
		}
	}

	private void load()
	{
	    context( SapphireDiagramEditorPagePart.class ).setGridVisible(this.architecture.isShowGrid().content());
	    context( SapphireDiagramEditorPagePart.class ).setShowGuides(this.architecture.isShowGuides().content());
		
		ElementList<Component> components = this.architecture.getComponents();
		ConnectionService connService = context( SapphireDiagramEditorPagePart.class ).service(ConnectionService.class);
		for (Component component : components)
		{
			DiagramNodePart nodePart = context( SapphireDiagramEditorPagePart.class ).getDiagramNodePart(component);
			if (nodePart != null)
			{
				DiagramNodeBounds bounds = null;
				bounds = new DiagramNodeBounds(component.getPosition().getX().content(), 
						component.getPosition().getY().content(), -1, -1,
						false, false);
				nodePart.setNodeBounds(bounds);					
				
				// load the embedded connection layout
				ElementList<ComponentDependency> dependencies = component.getDependencies();
				
				for (ComponentDependency dependency : dependencies)
				{
					DiagramConnectionPart connPart = getConnectionPart(connService, dependency);
					if (connPart != null)
					{						
						ElementList<ConnectionBendpoint> bendpoints = dependency.getConnectionBendpoints();
						if (bendpoints.size() > 0)
						{
							int index = 0;
							for (ConnectionBendpoint bendpoint : bendpoints)
							{
								connPart.addBendpoint(index++, bendpoint.getX().content(), 
										bendpoint.getY().content());
							}							
						}
					}
				}				
			}
		}
		
		// Listen on existing connection parts
		for (DiagramConnectionPart connPart : connService.list())
		{
			connPart.attach(this.connectionPartListener);
		}
		
	}
	
	private void handleNodeLayoutChange(Component component)
	{
		DiagramNodePart nodePart = context( SapphireDiagramEditorPagePart.class ).getDiagramNodePart(component);
		DiagramNodeBounds nodeBounds = new DiagramNodeBounds(component.getPosition().getX().content(),
				component.getPosition().getY().content());
		nodePart.setNodeBounds(nodeBounds);
	}
	
	private void handleConnectionBendpointChange(ComponentDependency componentDependency)
	{
		ConnectionService connService = context(SapphireDiagramEditorPagePart.class).service(ConnectionService.class);
		DiagramConnectionPart connPart = getConnectionPart(connService, componentDependency);
		if (connPart != null)
		{
			List<Point> bendpoints = new ArrayList<Point>();
			for (ConnectionBendpoint bendpoint : componentDependency.getConnectionBendpoints())
			{
				bendpoints.add(new Point(bendpoint.getX().content(), bendpoint.getY().content()));
			}
			connPart.resetBendpoints(bendpoints);
		}
	}
	
	private void addNodeToPersistenceCache(DiagramNodePart nodePart)
	{
		String nodeId = nodePart.getId();
		this.nodeBounds.put(nodeId, nodePart.getNodeBounds());
	}
	
	private void addConnectionToPersistenceCache(DiagramConnectionPart connPart)
	{
		ConnectionHashKey connKey = ConnectionHashKey.createKey(connPart);
		this.connectionBendPoints.put(connKey, connPart.getBendpoints());
	}

	private void addDiagramPartListener()
	{
        this.diagramPartListener = new Listener()
        {
            @Override
            public void handle( final Event event )
            {
                if ( event instanceof DiagramNodeEvent )
                {
                	handleDiagramNodeEvent((DiagramNodeEvent)event);
                } 
                else if ( event instanceof DiagramPageEvent )
                {
                	handleDiagramPageEvent((DiagramPageEvent)event);
                }
                else if (event instanceof PreAutoLayoutEvent)
                {
                	autoLayout = true;
                }
                else if (event instanceof PostAutoLayoutEvent)
                {
                	autoLayout = false;
                }
                else if (event instanceof ConnectionAddEvent)
                {
                	handleConnectionAddEvent((ConnectionAddEvent)event);
                }
                else if (event instanceof ConnectionDeleteEvent)
                {
                	handleConnectionDeleteEvent((ConnectionDeleteEvent)event);
                }
            }
        };
        
        context( SapphireDiagramEditorPagePart.class ).attach( this.diagramPartListener );
	}
		
    private void handleDiagramNodeEvent(DiagramNodeEvent event) {
    	DiagramNodePart nodePart = (DiagramNodePart)event.getPart();
    	switch(event.getNodeEventType()) {
	    	case NodeAdd:
				read(nodePart);
	    		break;
	    	case NodeDelete:
			    refreshDirtyState();
    		break;
	    	case NodeMove:
				DiagramNodeBounds nodeBounds = nodePart.getNodeBounds();
				
				if (nodeBounds.isAutoLayout())
				{
					// need to add the node bounds to the persistence cache so that "revert" could work
					addNodeToPersistenceCache(nodePart);
					refreshDirtyState();
				}
				else if (!nodeBounds.isDefaultPosition())
				{
					write((DiagramNodePart)event.getPart());
				}
	    		break;
	    	default:
	    		break;
    	}
	}

    protected void handleConnectionAddEvent(ConnectionAddEvent event) 
    {
		DiagramConnectionPart connPart = event.part();

		connPart.attach(this.connectionPartListener);
		DiagramConnectionInfo connectionInfo = read(connPart);
		if (connectionInfo != null)
		{
			connPart.resetBendpoints(connectionInfo.getBendPoints());
		}			
	}

    protected void handleConnectionDeleteEvent(ConnectionDeleteEvent event) 
    {
    	refreshDirtyState();
	}
    
    private void handleDiagramPageEvent(DiagramPageEvent event) {
    	SapphireDiagramEditorPagePart diagramPart = (SapphireDiagramEditorPagePart)event.getPart();
    	switch(event.getDiagramPageEventType()) {
	    	case GridStateChange:
		    	setGridVisible(diagramPart.isGridVisible());
	    		break;
	    	case GuideStateChange:
		    	setGuidesVisible(diagramPart.isShowGuides());
	    		break;
	    	case DiagramSave:
				doSave();
	    		break;
	    	default:
	    		break;
    	}
	}

	
	private void addModelListeners()
	{
		this.componentListener = new FilteredListener<PropertyEvent>() 
		{
		    @Override
		    protected void handleTypedEvent( final PropertyEvent event )
		    {
	    		Component component = event.property().element().nearest(Component.class);
	    		if (component != null)
	    		{
	    			handleNodeLayoutChange(component);
	    		}
		    }
		};
		
		this.componentDependencyListener = new FilteredListener<PropertyEvent>()
		{
			@Override
			protected void handleTypedEvent( final PropertyEvent event )
			{
				ComponentDependency componentDependency = event.property().element().nearest(ComponentDependency.class);
				if (componentDependency != null)
				{
					handleConnectionBendpointChange(componentDependency);
				}
			}
		};
		
		this.architecture.attach(this.componentListener, "/Components/Position/*");
		this.architecture.attach(this.componentDependencyListener, "/Components/Dependencies/ConnectionBendpoints/*");
		
	}
	
	private void writeComponentBounds(Component component, DiagramNodePart node)
	{
		Bounds bounds = node.getNodeBounds();
		if (bounds.getX() != component.getPosition().getX().content())
		{
			component.getPosition().setX(bounds.getX());
		}
		if (bounds.getY() != component.getPosition().getY().content())
		{
			component.getPosition().setY(bounds.getY());
		}
	}
	
	private void writeDependencyBendPoints(ComponentDependency dependency, DiagramConnectionPart connPart)
	{
	    final ElementList<ConnectionBendpoint> bpInModelList = dependency.getConnectionBendpoints();
	    final int bpInModelSize = bpInModelList.size();
	    final List<Point> bpInPartList = connPart.getBendpoints();
	    final int bpInPartSize = bpInPartList.size();
	    
	    for( int i = 0, n = min( bpInModelSize, bpInPartSize ); i < n; i++ )
	    {
	        final ConnectionBendpoint bpInModel = bpInModelList.get( i );
	        final Point bpInPart = bpInPartList.get( i );
	        
	        if (bpInModel.getX().content() != bpInPart.getX())
	        {
	        	bpInModel.setX( bpInPart.getX() );
	        }
	        if (bpInModel.getY().content() != bpInPart.getY())
	        {
	        	bpInModel.setY( bpInPart.getY() );
	        }
	    }
	    
	    if( bpInModelSize < bpInPartSize )
	    {
	        for( int i = bpInModelSize; i < bpInPartSize; i++ )
	        {
	            final ConnectionBendpoint bpInModel = bpInModelList.insert();
	            final Point bpInPart = bpInPartList.get( i );
	            
	            bpInModel.setX( bpInPart.getX() );
	            bpInModel.setY( bpInPart.getY() );
	        }
	    }
	    else if( bpInModelSize > bpInPartSize )
	    {
	        for( int i = bpInModelSize - 1; i >= bpInPartSize; i-- )
	        {
	            bpInModelList.remove( i );
	        }
	    }
	}
		
	private void doSave()
	{
		refreshPersistedPartsCache();
		// For nodes that are placed using default node positions and connection bend points that
		// are calculated using connection router, we don't modify the corresponding model properties
		// in order to allow "revert" in source editor to work correctly.
		// So we need to do an explicit save of the node bounds and connection bend points here.
		this.architecture.detach(this.componentListener, "/Components/Position/*");
		this.architecture.detach(this.componentDependencyListener, "/Components/Dependencies/ConnectionBendpoints/*");
		
		for (DiagramNodePart nodePart : context( SapphireDiagramEditorPagePart.class ).getNodes())
		{
			Component component = (Component)nodePart.getLocalModelElement();
			if (!component.disposed())
			{
				writeComponentBounds(component, nodePart);
			}
		}
		SapphireDiagramEditorPagePart diagramPart = context( SapphireDiagramEditorPagePart.class );
		ConnectionService connService = diagramPart.service(ConnectionService.class);
		for (DiagramConnectionPart connPart : connService.list())
		{
			ComponentDependency dependency = (ComponentDependency)connPart.getLocalModelElement();
			if (!dependency.disposed())
			{
				writeDependencyBendPoints(dependency, connPart);
			}
		}
		
		this.architecture.attach(this.componentListener, "/Components/Position/*");
		this.architecture.attach(this.componentDependencyListener, "/Components/Dependencies/ConnectionBendpoints/*");
	}
	
    private boolean isNodeLayoutChanged(DiagramNodePart nodePart)
    {
		DiagramNodeBounds newBounds = nodePart.getNodeBounds();
		boolean changed = false;
		String nodeId = (nodePart).getId();
		if (this.nodeBounds.containsKey(nodeId))
		{
			DiagramNodeBounds oldBounds = this.nodeBounds.get(nodeId);
			if (!newBounds.equals(oldBounds))
			{
				changed = true;
			}
		}
		else
		{
			changed = true;
		}
    	return changed;
    }
	
    private boolean isConnectionLayoutChanged(DiagramConnectionPart connPart)
    {
		// Detect whether the connection bendpoints have been changed.
    	List<Point> bendpoints = connPart.getBendpoints();
		ConnectionHashKey key = ConnectionHashKey.createKey(connPart);
		boolean changed = false;
		if (this.connectionBendPoints.containsKey(key))
		{		
			List<Point> oldBendpoints = this.connectionBendPoints.get(key);
	    	if (bendpoints.size() != oldBendpoints.size())
	    	{
	    		changed = true;
	    	}
	    	else
	    	{
				for (int i = 0; i < bendpoints.size(); i++)
				{
					Point newPt = bendpoints.get(i);
					Point oldPt = oldBendpoints.get(i);
					if (newPt.getX() != oldPt.getX() || newPt.getY() != oldPt.getY())
					{
						changed = true;
						break;
					}
				}    		
	    	}
			
			if (!bendpoints.equals(oldBendpoints))
			{
				changed = true;
			}
		}
		else
		{
			changed = true;
		}
    	return changed;
    }
    
    private boolean isDiagramLayoutChanged()
    {
    	boolean changed = false;
    	if (!context(SapphireDiagramEditorPagePart.class).disposed())
    	{
	    	ConnectionService connService = context(SapphireDiagramEditorPagePart.class).service(ConnectionService.class);
			for (DiagramNodePart nodePart : context( SapphireDiagramEditorPagePart.class ).getNodes())
			{
				if (!nodePart.getLocalModelElement().disposed() && isNodeLayoutChanged(nodePart))
				{
					changed = true;
					break;
				}
			}
			for (DiagramConnectionPart connPart : connService.list())
			{
				if (!connPart.getLocalModelElement().disposed() && isConnectionLayoutChanged(connPart))
				{
					changed = true;
					break;
				}
			}
    	}		
    	return changed;
    }
    
    @Override
    public boolean dirty()
    {
        return this.dirty;
    }

    private void refreshDirtyState()
    {
        final boolean after = isDiagramLayoutChanged();
        
        if( this.dirty != after )
        {
            final boolean before = this.dirty;
            this.dirty = after;
            
            broadcast( new DirtyStateEvent( this, before, after ) );
        }
    }
	
	private void refreshPersistedPartsCache()
	{
		this.nodeBounds.clear();
		this.connectionBendPoints.clear();
		ConnectionService connService = context(SapphireDiagramEditorPagePart.class).service(ConnectionService.class);		
		for (DiagramConnectionPart connPart : connService.list())
		{
			addConnectionToPersistenceCache(connPart);
		}
		for (DiagramNodePart nodePart : context( SapphireDiagramEditorPagePart.class ).getNodes())
		{
			addNodeToPersistenceCache(nodePart);
		}		
	}
	
	private DiagramConnectionPart getConnectionPart(ConnectionService connService, Element element)	
	{
		for (DiagramConnectionPart connPart : connService.list())
		{
			if (connPart.getLocalModelElement() == element)
			{
				return connPart;
			}
		}
		return null;
	}
}
