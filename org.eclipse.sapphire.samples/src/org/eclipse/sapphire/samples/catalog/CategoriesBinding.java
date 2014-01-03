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

package org.eclipse.sapphire.samples.catalog;

import static org.eclipse.sapphire.modeling.util.MiscUtil.EMPTY_STRING;
import static org.eclipse.sapphire.modeling.xml.XmlUtil.createQualifiedName;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.xml.namespace.QName;

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.FilteredListener;
import org.eclipse.sapphire.ListPropertyBinding;
import org.eclipse.sapphire.Listener;
import org.eclipse.sapphire.Property;
import org.eclipse.sapphire.PropertyBinding;
import org.eclipse.sapphire.PropertyContentEvent;
import org.eclipse.sapphire.PropertyDef;
import org.eclipse.sapphire.Resource;
import org.eclipse.sapphire.ValuePropertyBinding;
import org.eclipse.sapphire.modeling.xml.ChildXmlResource;
import org.eclipse.sapphire.modeling.xml.StandardXmlListBindingImpl;
import org.eclipse.sapphire.modeling.xml.XmlElement;
import org.eclipse.sapphire.modeling.xml.XmlResource;
import org.eclipse.sapphire.util.IdentityHashSet;
import org.eclipse.sapphire.util.ListFactory;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public final class CategoriesBinding extends ListPropertyBinding
{
    private List<CategoryResource> cache = ListFactory.empty();
    private Listener listener;
    
    @Override
    public void init( final Property property )
    {
        super.init( property );
        
        this.listener = new FilteredListener<PropertyContentEvent>()
        {
            @Override
            protected void handleTypedEvent( final PropertyContentEvent event )
            {
                property.refresh();
                
                for( Category category : ( (Catalog) property.element() ).getCategories() )
                {
                    category.getItems().refresh();
                }
            }
        };
        
        property.element().attach( this.listener, "Items/Category" );
    }

    @Override
    public List<? extends Resource> read()
    {
        // Compute a sorted list of category names, ignoring case differences and including a null
        // at the end if uncategorized items are found.
        
        final Set<String> categories = new TreeSet<String>( CategoryNamesComparator.INSTANCE );
        
        for( Item item : ( (Catalog) property().element() ).getItems() )
        {
            categories.add( item.getCategory().text() );
        }
        
        // Compute the list of category resources, reusing existing resources when possible.
        
        final ListFactory<CategoryResource> resourcesListFactory = ListFactory.start();
        final Set<CategoryResource> reused = new IdentityHashSet<CategoryResource>();
        
        for( String category : categories )
        {
            boolean found = false;
            
            for( CategoryResource resource : this.cache )
            {
                if( CategoryNamesComparator.INSTANCE.compare( category, resource.getName() ) == 0 )
                {
                    resourcesListFactory.add( resource );
                    reused.add( resource );
                    found = true;
                    break;
                }
            }
            
            if( ! found )
            {
                resourcesListFactory.add( new CategoryResource( category ) );
            }
        }
        
        // Dispose previously created resources that were not reused.
        
        for( CategoryResource resource : this.cache )
        {
            if( ! reused.contains( resource ) )
            {
                resource.dispose();
            }
        }
        
        // Stash the computed list of resources for future use and return to the caller.
        
        final List<CategoryResource> resources = resourcesListFactory.result();
        
        this.cache = resources;
        
        return this.cache = resources;
    }

    @Override
    public ElementType type( final Resource resource )
    {
        return Category.TYPE;
    }
    
    @Override
    public void dispose()
    {
        for( CategoryResource resource : this.cache )
        {
            resource.dispose();
        }
        
        this.cache = null;
        
        property().element().detach( this.listener, "Items/Category" );
        this.listener = null;
    }

    private static final class CategoryNamesComparator implements Comparator<String>
    {
        public static CategoryNamesComparator INSTANCE = new CategoryNamesComparator();
        
        public int compare( String x, String y )
        {
            x = ( x == null ? EMPTY_STRING : x.trim() );
            y = ( y == null ? EMPTY_STRING : y.trim() );
            
            if( x.length() == 0 )
            {
                return Integer.MAX_VALUE;
            }
            else if( y.length() == 0 )
            {
                return Integer.MAX_VALUE * -1;
            }
            else
            {
                return x.compareToIgnoreCase( y );
            }
        }
    }
    
    private final class CategoryResource extends Resource
    {
        private String name;
        
        public CategoryResource( final String name )
        {
            super( CategoriesBinding.this.property().element().resource() );
            
            this.name = name;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public void setName( final String name )
        {
            this.name = name;
            
            for( Item item : ( (Category) element() ).getItems() )
            {
                item.setCategory( name );
            }
        }

        @Override
        protected PropertyBinding createBinding( final Property property )
        {
            final PropertyDef pdef = property.definition();
            
            PropertyBinding binding = null;
            
            if( pdef == Category.PROP_NAME )
            {
                binding = new ValuePropertyBinding()
                {
                    @Override
                    public String read()
                    {
                        return getName();
                    }

                    @Override
                    public void write( final String value )
                    {
                        setName( value );
                    }
                };
            }
            else if( pdef == Category.PROP_ITEMS )
            {
                binding = new StandardXmlListBindingImpl()
                {
                    @Override
                    protected void initBindingMetadata()
                    {
                        this.xmlElementNames = new QName[] { createQualifiedName( "Item", null ), createQualifiedName( "MultiVariantItem", null ) };
                        this.modelElementTypes = new ElementType[] { SingleVariantItem.TYPE, MultiVariantItem.TYPE };
                    }
                    
                    @Override
                    protected List<?> readUnderlyingList()
                    {
                        final List<?> all = super.readUnderlyingList();
                        final ListFactory<XmlElement> filtered = ListFactory.start();
                        
                        for( Object obj : all )
                        {
                            final XmlElement element = (XmlElement) obj;
                            final String category = element.getChildNodeText( "Category" );
                            
                            if( CategoryNamesComparator.INSTANCE.compare( CategoryResource.this.name, category ) == 0 )
                            {
                                filtered.add( element );
                            }
                        }
                        
                        return filtered.result();
                    }
                    
                    protected Object insertUnderlyingObject( final ElementType type,
                                                             final int position )
                    {
                        final XmlElement element = (XmlElement) super.insertUnderlyingObject( type, position );
                        
                        element.setChildNodeText( "Category", CategoryResource.this.name, true );
                        
                        return element;
                    }
                    
                    @Override
                    protected Resource resource( final Object obj )
                    {
                        return new ChildXmlResource( CategoryResource.this, (XmlElement) obj );
                    }

                    @Override
                    protected XmlElement getXmlElement( final boolean createIfNecessary )
                    {
                        return element().nearest( Catalog.class ).adapt( XmlResource.class ).getXmlElement( createIfNecessary );
                    }
                };
            }
            
            return binding;
        }
    }
    
}
