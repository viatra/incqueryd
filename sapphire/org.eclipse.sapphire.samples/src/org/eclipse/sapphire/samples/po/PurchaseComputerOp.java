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

import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ExecutableElement;
import org.eclipse.sapphire.Transient;
import org.eclipse.sapphire.TransientProperty;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.modeling.ProgressMonitor;
import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.DelegateImplementation;
import org.eclipse.sapphire.modeling.annotations.EnumSerialization;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.Listeners;
import org.eclipse.sapphire.modeling.annotations.PossibleValues;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

public interface PurchaseComputerOp extends ExecutableElement
{
    ElementType TYPE = new ElementType( PurchaseComputerOp.class );
    
    @Label( standard = "importance" )

    enum Importance
    {
        @Label( standard = "not important" )
        @EnumSerialization( primary = "1" )
        
        NOT_IMPORTANT,
        
        @Label( standard = "somewhat important" )
        @EnumSerialization( primary = "2" )
        
        SOMEWHAT_IMPORTANT,
        
        @Label( standard = "very important" )
        @EnumSerialization( primary = "3" )
        
        VERY_IMPORTANT
    }
    
    // *** PurchaseOrder ***
    
    @Type( base = PurchaseOrder.class )

    TransientProperty PROP_PURCHASE_ORDER = new TransientProperty( TYPE, "PurchaseOrder" );
    
    Transient<PurchaseOrder> getPurchaseOrder();
    void setPurchaseOrder( PurchaseOrder value );

    // *** PerformanceImportance ***
    
    @Type( base = Importance.class )
    @Label( standard = "performance" )
    @DefaultValue( text = "2" )
    @Listeners( PurchaseComputerOpListener.class )
    
    ValueProperty PROP_PERFORMANCE_IMPORTANCE = new ValueProperty( TYPE, "PerformanceImportance" );
    
    Value<Importance> getPerformanceImportance();
    void setPerformanceImportance( String value );
    void setPerformanceImportance( Importance value );
    
    // *** StorageImportance ***
    
    @Type( base = Importance.class )
    @Label( standard = "storage" )
    @DefaultValue( text = "2" )
    @Listeners( PurchaseComputerOpListener.class )
    
    ValueProperty PROP_STORAGE_IMPORTANCE = new ValueProperty( TYPE, "StorageImportance" );
    
    Value<Importance> getStorageImportance();
    void setStorageImportance( String value );
    void setStorageImportance( Importance value );
    
    // *** GamingImportance ***
    
    @Type( base = Importance.class )
    @Label( standard = "gaming" )
    @DefaultValue( text = "1" )
    @Listeners( PurchaseComputerOpListener.class )
    
    ValueProperty PROP_GAMING_IMPORTANCE = new ValueProperty( TYPE, "GamingImportance" );
    
    Value<Importance> getGamingImportance();
    void setGamingImportance( String value );
    void setGamingImportance( Importance value );
    
    // *** Processor ***
    
    @Label( standard = "processor" )
    
    @PossibleValues
    (
        values =
        {
            "Intel Core i7 4960X - 3.6 GHz - 6 Cores - $999",
            "Intel Core i7 4930K - 3.4 GHz - 4 Cores - $583",
            "Intel Core i5 3570S - 3.1 GHz - 4 Cores - $205",
            "Intel Core i3 3220T - 2.8 GHz - 2 Cores - $117",
        }
    )
    
    @DefaultValue
    (
        text =
        "${" +
            "PerformanceImportance == 3" + 
            "? 'Intel Core i7 4930K - 3.4 GHz - 4 Cores - $583'" +
            ": (" +
                   "PerformanceImportance == 2" +
                   "? 'Intel Core i5 3570S - 3.1 GHz - 4 Cores - $205'" +
                   ": 'Intel Core i3 3220T - 2.8 GHz - 2 Cores - $117'" +
              ")" +
        "}"
    )
    
    ValueProperty PROP_PROCESSOR = new ValueProperty( TYPE, "Processor" );
    
    Value<String> getProcessor();
    void setProcessor( String value );
    
    // *** Memory ***
    
    @Label( standard = "memory" )
    
    @PossibleValues
    (
        values =
        {
            "4 GB RAM - $46",
            "8 GB RAM - $92",
            "16 GB RAM - $185",
            "32 GB RAM - $369",
        }
    )
    
    @DefaultValue
    (
        text =
        "${" +
            "PerformanceImportance == 3" + 
            "? '16 GB RAM - $185'" +
            ": (" +
                   "PerformanceImportance == 2" +
                   "? '8 GB RAM - $92'" +
                   ": '4 GB RAM - $46'" +
              ")" +
        "}"
    )
    
    ValueProperty PROP_MEMORY = new ValueProperty( TYPE, "Memory" );
    
    Value<String> getMemory();
    void setMemory( String value );
    
    // *** Storage ***
    
    @Label( standard = "storage" )

    @PossibleValues
    (
        values =
        {
            "Corsair 512GB SSD - $379",
            "Western Digital 4TB - $279",
            "Western Digital 3TB - $129",
            "Western Digital 1TB - $89"
        }
    )
    
    @DefaultValue
    (
        text =
        "${" +
            "PerformanceImportance == 3 && StorageImportance < 3" + 
            "? 'Corsair 512GB SSD - $379'" +
            ": (" +
                   "StorageImportance == 3" +
                   "? 'Western Digital 4TB - $279'" +
                   ": (" +
                          "StorageImportance == 2" +
                          "? 'Western Digital 3TB - $129'" +
                          ": 'Western Digital 1TB - $89'" +
                     ")" +
              ")" +
        "}"
    )
    
    ValueProperty PROP_STORAGE = new ValueProperty( TYPE, "Storage" );
    
    Value<String> getStorage();
    void setStorage( String value );
    
    // *** VideoCard ***
    
    @Label( standard = "video card" )
    
    @PossibleValues
    (
        values =
        {
            "Sapphire Radeon HD 7990 6GB - $729",
            "VisionTek Radeon HD 7750 2GB - Eyefinity 6 - $232",
            "PowerColor Radeon HD 7750 2GB - $94"
        }
    )
    
    @DefaultValue
    (
        text =
        "${" +
            "GamingImportance == 3" + 
            "? 'Sapphire Radeon HD 7990 6GB - $729'" +
            ": (" +
                   "GamingImportance == 2" +
                   "? 'PowerColor Radeon HD 7750 2GB - $94'" +
                   ": null" +
              ")" +
        "}"
    )
    
    ValueProperty PROP_VIDEO_CARD = new ValueProperty( TYPE, "VideoCard" );
    
    Value<String> getVideoCard();
    void setVideoCard( String value );
    
    // *** Method: execute ***
    
    @DelegateImplementation( PurchaseComputerOpMethods.class )
    
    Status execute( ProgressMonitor monitor );

}
