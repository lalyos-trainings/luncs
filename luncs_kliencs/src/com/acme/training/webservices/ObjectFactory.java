
package com.acme.training.webservices;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.acme.training.webservices package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SetBillingAddress_QNAME = new QName("http://webservices.training.acme.com/", "setBillingAddress");
    private final static QName _GetFoodsResponse_QNAME = new QName("http://webservices.training.acme.com/", "getFoodsResponse");
    private final static QName _GetFoods_QNAME = new QName("http://webservices.training.acme.com/", "getFoods");
    private final static QName _SetCustomer_QNAME = new QName("http://webservices.training.acme.com/", "setCustomer");
    private final static QName _AddFoodResponse_QNAME = new QName("http://webservices.training.acme.com/", "addFoodResponse");
    private final static QName _SetBillingAddressResponse_QNAME = new QName("http://webservices.training.acme.com/", "setBillingAddressResponse");
    private final static QName _ViewOrder_QNAME = new QName("http://webservices.training.acme.com/", "viewOrder");
    private final static QName _SetDeliveryAddressResponse_QNAME = new QName("http://webservices.training.acme.com/", "setDeliveryAddressResponse");
    private final static QName _SetCustomerResponse_QNAME = new QName("http://webservices.training.acme.com/", "setCustomerResponse");
    private final static QName _InitResponse_QNAME = new QName("http://webservices.training.acme.com/", "initResponse");
    private final static QName _SendOrder_QNAME = new QName("http://webservices.training.acme.com/", "sendOrder");
    private final static QName _AddFood_QNAME = new QName("http://webservices.training.acme.com/", "addFood");
    private final static QName _SendOrderResponse_QNAME = new QName("http://webservices.training.acme.com/", "sendOrderResponse");
    private final static QName _ViewOrderResponse_QNAME = new QName("http://webservices.training.acme.com/", "viewOrderResponse");
    private final static QName _Init_QNAME = new QName("http://webservices.training.acme.com/", "init");
    private final static QName _SetDeliveryAddress_QNAME = new QName("http://webservices.training.acme.com/", "setDeliveryAddress");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.acme.training.webservices
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetBillingAddressResponse }
     * 
     */
    public SetBillingAddressResponse createSetBillingAddressResponse() {
        return new SetBillingAddressResponse();
    }

    /**
     * Create an instance of {@link ViewOrder }
     * 
     */
    public ViewOrder createViewOrder() {
        return new ViewOrder();
    }

    /**
     * Create an instance of {@link SetCustomerResponse }
     * 
     */
    public SetCustomerResponse createSetCustomerResponse() {
        return new SetCustomerResponse();
    }

    /**
     * Create an instance of {@link GetFoodsResponse }
     * 
     */
    public GetFoodsResponse createGetFoodsResponse() {
        return new GetFoodsResponse();
    }

    /**
     * Create an instance of {@link SetDeliveryAddressResponse }
     * 
     */
    public SetDeliveryAddressResponse createSetDeliveryAddressResponse() {
        return new SetDeliveryAddressResponse();
    }

    /**
     * Create an instance of {@link SetCustomer }
     * 
     */
    public SetCustomer createSetCustomer() {
        return new SetCustomer();
    }

    /**
     * Create an instance of {@link ViewOrderResponse }
     * 
     */
    public ViewOrderResponse createViewOrderResponse() {
        return new ViewOrderResponse();
    }

    /**
     * Create an instance of {@link SetDeliveryAddress }
     * 
     */
    public SetDeliveryAddress createSetDeliveryAddress() {
        return new SetDeliveryAddress();
    }

    /**
     * Create an instance of {@link InitResponse }
     * 
     */
    public InitResponse createInitResponse() {
        return new InitResponse();
    }

    /**
     * Create an instance of {@link FoodView }
     * 
     */
    public FoodView createFoodView() {
        return new FoodView();
    }

    /**
     * Create an instance of {@link Address }
     * 
     */
    public Address createAddress() {
        return new Address();
    }

    /**
     * Create an instance of {@link AddFoodResponse }
     * 
     */
    public AddFoodResponse createAddFoodResponse() {
        return new AddFoodResponse();
    }

    /**
     * Create an instance of {@link SetBillingAddress }
     * 
     */
    public SetBillingAddress createSetBillingAddress() {
        return new SetBillingAddress();
    }

    /**
     * Create an instance of {@link Init }
     * 
     */
    public Init createInit() {
        return new Init();
    }

    /**
     * Create an instance of {@link SendOrderResponse }
     * 
     */
    public SendOrderResponse createSendOrderResponse() {
        return new SendOrderResponse();
    }

    /**
     * Create an instance of {@link GetFoods }
     * 
     */
    public GetFoods createGetFoods() {
        return new GetFoods();
    }

    /**
     * Create an instance of {@link SendOrder }
     * 
     */
    public SendOrder createSendOrder() {
        return new SendOrder();
    }

    /**
     * Create an instance of {@link AddFood }
     * 
     */
    public AddFood createAddFood() {
        return new AddFood();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetBillingAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "setBillingAddress")
    public JAXBElement<SetBillingAddress> createSetBillingAddress(SetBillingAddress value) {
        return new JAXBElement<SetBillingAddress>(_SetBillingAddress_QNAME, SetBillingAddress.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFoodsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "getFoodsResponse")
    public JAXBElement<GetFoodsResponse> createGetFoodsResponse(GetFoodsResponse value) {
        return new JAXBElement<GetFoodsResponse>(_GetFoodsResponse_QNAME, GetFoodsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFoods }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "getFoods")
    public JAXBElement<GetFoods> createGetFoods(GetFoods value) {
        return new JAXBElement<GetFoods>(_GetFoods_QNAME, GetFoods.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "setCustomer")
    public JAXBElement<SetCustomer> createSetCustomer(SetCustomer value) {
        return new JAXBElement<SetCustomer>(_SetCustomer_QNAME, SetCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFoodResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "addFoodResponse")
    public JAXBElement<AddFoodResponse> createAddFoodResponse(AddFoodResponse value) {
        return new JAXBElement<AddFoodResponse>(_AddFoodResponse_QNAME, AddFoodResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetBillingAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "setBillingAddressResponse")
    public JAXBElement<SetBillingAddressResponse> createSetBillingAddressResponse(SetBillingAddressResponse value) {
        return new JAXBElement<SetBillingAddressResponse>(_SetBillingAddressResponse_QNAME, SetBillingAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "viewOrder")
    public JAXBElement<ViewOrder> createViewOrder(ViewOrder value) {
        return new JAXBElement<ViewOrder>(_ViewOrder_QNAME, ViewOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDeliveryAddressResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "setDeliveryAddressResponse")
    public JAXBElement<SetDeliveryAddressResponse> createSetDeliveryAddressResponse(SetDeliveryAddressResponse value) {
        return new JAXBElement<SetDeliveryAddressResponse>(_SetDeliveryAddressResponse_QNAME, SetDeliveryAddressResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "setCustomerResponse")
    public JAXBElement<SetCustomerResponse> createSetCustomerResponse(SetCustomerResponse value) {
        return new JAXBElement<SetCustomerResponse>(_SetCustomerResponse_QNAME, SetCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InitResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "initResponse")
    public JAXBElement<InitResponse> createInitResponse(InitResponse value) {
        return new JAXBElement<InitResponse>(_InitResponse_QNAME, InitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "sendOrder")
    public JAXBElement<SendOrder> createSendOrder(SendOrder value) {
        return new JAXBElement<SendOrder>(_SendOrder_QNAME, SendOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFood }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "addFood")
    public JAXBElement<AddFood> createAddFood(AddFood value) {
        return new JAXBElement<AddFood>(_AddFood_QNAME, AddFood.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "sendOrderResponse")
    public JAXBElement<SendOrderResponse> createSendOrderResponse(SendOrderResponse value) {
        return new JAXBElement<SendOrderResponse>(_SendOrderResponse_QNAME, SendOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ViewOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "viewOrderResponse")
    public JAXBElement<ViewOrderResponse> createViewOrderResponse(ViewOrderResponse value) {
        return new JAXBElement<ViewOrderResponse>(_ViewOrderResponse_QNAME, ViewOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Init }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "init")
    public JAXBElement<Init> createInit(Init value) {
        return new JAXBElement<Init>(_Init_QNAME, Init.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetDeliveryAddress }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webservices.training.acme.com/", name = "setDeliveryAddress")
    public JAXBElement<SetDeliveryAddress> createSetDeliveryAddress(SetDeliveryAddress value) {
        return new JAXBElement<SetDeliveryAddress>(_SetDeliveryAddress_QNAME, SetDeliveryAddress.class, null, value);
    }

}
