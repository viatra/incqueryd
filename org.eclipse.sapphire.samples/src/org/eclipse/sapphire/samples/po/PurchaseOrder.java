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

package org.eclipse.sapphire.samples.po;

import java.math.BigDecimal;
import java.util.Date;

import org.eclipse.sapphire.Element;
import org.eclipse.sapphire.ElementHandle;
import org.eclipse.sapphire.ElementList;
import org.eclipse.sapphire.ElementProperty;
import org.eclipse.sapphire.ElementType;
import org.eclipse.sapphire.ImpliedElementProperty;
import org.eclipse.sapphire.ListProperty;
import org.eclipse.sapphire.Serialization;
import org.eclipse.sapphire.Since;
import org.eclipse.sapphire.Validation;
import org.eclipse.sapphire.Value;
import org.eclipse.sapphire.ValueProperty;
import org.eclipse.sapphire.Version;
import org.eclipse.sapphire.VersionCompatibilityTarget;
import org.eclipse.sapphire.modeling.annotations.CountConstraint;
import org.eclipse.sapphire.modeling.annotations.DefaultValue;
import org.eclipse.sapphire.modeling.annotations.Derived;
import org.eclipse.sapphire.modeling.annotations.Label;
import org.eclipse.sapphire.modeling.annotations.NumericRange;
import org.eclipse.sapphire.modeling.annotations.Required;
import org.eclipse.sapphire.modeling.annotations.Service;
import org.eclipse.sapphire.modeling.annotations.Type;

/**
 * @author <a href="mailto:konstantin.komissarchik@oracle.com">Konstantin Komissarchik</a>
 */

@Service( impl = PurchaseOrderResourceConversionService.class )
@VersionCompatibilityTarget( version = "${ Version }", versioned = "Purchase Order" )

public interface PurchaseOrder extends Element
{
    ElementType TYPE = new ElementType( PurchaseOrder.class );
    
    // *** Version ***
    
    @Type( base = Version.class )
    @DefaultValue( text = "2.0" )

    ValueProperty PROP_VERSION = new ValueProperty( TYPE, "Version" );
    
    Value<Version> getVersion();
    void setVersion( String value );
    void setVersion( Version value );
    
    // *** Id ***
    
    @Label( standard = "ID" )
    @Required
    
    ValueProperty PROP_ID = new ValueProperty( TYPE, "Id" );
    
    Value<String> getId();
    void setId( String value );
    
    // *** Customer ***
    
    @Label( standard = "customer" )
    @Required
    
    ValueProperty PROP_CUSTOMER = new ValueProperty( TYPE, "Customer" );
    
    Value<String> getCustomer();
    void setCustomer( String value );
    
    // *** InitialQuoteDate ***
    
    @Type( base = Date.class )
    @Label( standard = "initial quote date" )
    @Serialization( primary = "yyyy-MM-dd", alternative = "MM/dd/yyyy" )
    @Since( "1.5" )

    ValueProperty PROP_INITIAL_QUOTE_DATE = new ValueProperty( TYPE, "InitialQuoteDate" );
    
    Value<Date> getInitialQuoteDate();
    void setInitialQuoteDate( String value );
    void setInitialQuoteDate( Date value );
    
    // *** OrderDate ***
    
    @Type( base = Date.class )
    @Label( standard = "order date" )
    @Serialization( primary = "yyyy-MM-dd", alternative = "MM/dd/yyyy" )

    ValueProperty PROP_ORDER_DATE = new ValueProperty( TYPE, "OrderDate" );
    
    Value<Date> getOrderDate();
    void setOrderDate( String value );
    void setOrderDate( Date value );
    
    // *** FulfillmentDate ***
    
    @Type( base = Date.class )
    @Label( standard = "fulfillment date" )
    @Serialization( primary = "yyyy-MM-dd", alternative = "MM/dd/yyyy" )
    @Since( "2.0" )

    ValueProperty PROP_FULFILLMENT_DATE = new ValueProperty( TYPE, "FulfillmentDate" );
    
    Value<Date> getFulfillmentDate();
    void setFulfillmentDate( String value );
    void setFulfillmentDate( Date value );
    
    // *** BillingInformation ***
    
    @Type( base = BillingInformation.class )
    @Label( standard = "billing information" )
    
    ImpliedElementProperty PROP_BILLING_INFORMATION = new ImpliedElementProperty( TYPE, "BillingInformation" );
    
    BillingInformation getBillingInformation();
    
    // *** ShippingInformation ***
    
    @Type( base = ShippingInformation.class )
    @Label( standard = "shipping information" )
    @Since( "2.0" )
    
    ImpliedElementProperty PROP_SHIPPING_INFORMATION = new ImpliedElementProperty( TYPE, "ShippingInformation" );
    
    ShippingInformation getShippingInformation();
    
    // *** Payment ***
    
    @Type( base = Payment.class, possible = { CreditCardPayment.class, CheckPayment.class, CashPayment.class } )
    @Label( standard = "payment" )
    @Since( "1.5" )
    
    ElementProperty PROP_PAYMENT = new ElementProperty( TYPE, "Payment" );
    
    ElementHandle<Payment> getPayment();
    
    // *** Entries ***
    
    @Type( base = PurchaseOrderEntry.class )
    @Label( standard = "entries" )
    @CountConstraint( min = 1 )
    
    ListProperty PROP_ENTRIES = new ListProperty( TYPE, "Entries" );
    
    ElementList<PurchaseOrderEntry> getEntries();
    
    // *** Subtotal ***
    
    @Type( base = BigDecimal.class )
    @Label( standard = "subtotal" )
    @Derived( text = "${ Sum( Entries, 'Total' ) }" )
    
    ValueProperty PROP_SUBTOTAL = new ValueProperty( TYPE, "Subtotal" );
    
    Value<BigDecimal> getSubtotal();
    
    // *** Discount ***
    
    @Type( base = BigDecimal.class )
    @Label( standard = "discount" )
    @DefaultValue( text = "0.00" )
    
    @Validation
    (
        rule = "${ Scale( Discount, 2 ) <= Scale( Subtotal, 2 ) + Scale( Delivery, 2 ) }",
        message = "Discount must not exceed subtotal plus delivery charge"
    )
    
    ValueProperty PROP_DISCOUNT = new ValueProperty( TYPE, "Discount" );
    
    Value<BigDecimal> getDiscount();
    void setDiscount( String value );
    void setDiscount( BigDecimal value );
    
    // *** Delivery ***
    
    @Type( base = BigDecimal.class )
    @Label( standard = "delivery" )
    @DefaultValue( text = "0.00" )
    @NumericRange( min = "0" )
    
    ValueProperty PROP_DELIVERY = new ValueProperty( TYPE, "Delivery" );
    
    Value<BigDecimal> getDelivery();
    void setDelivery( String value );
    void setDelivery( BigDecimal value );
    
    // *** Total ***
    
    @Type( base = BigDecimal.class )
    @Label( standard = "total" )
    @Derived( text = "${ Scale( Subtotal, 2 ) - Scale( Discount, 2 ) + Scale( Delivery, 2 ) }" )
    
    ValueProperty PROP_TOTAL = new ValueProperty( TYPE, "Total" );
    
    Value<BigDecimal> getTotal();
    
}
