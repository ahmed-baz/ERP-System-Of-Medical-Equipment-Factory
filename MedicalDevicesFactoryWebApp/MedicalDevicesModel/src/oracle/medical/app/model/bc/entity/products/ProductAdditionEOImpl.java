package oracle.medical.app.model.bc.entity.products;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sat Aug 10 04:34:58 EET 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ProductAdditionEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ProductAddId,
        ProductId,
        OrderNo,
        Date,
        Quantity,
        Accepted,
        Products;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int PRODUCTADDID = AttributesEnum.ProductAddId.index();
    public static final int PRODUCTID = AttributesEnum.ProductId.index();
    public static final int ORDERNO = AttributesEnum.OrderNo.index();
    public static final int DATE = AttributesEnum.Date.index();
    public static final int QUANTITY = AttributesEnum.Quantity.index();
    public static final int ACCEPTED = AttributesEnum.Accepted.index();
    public static final int PRODUCTS = AttributesEnum.Products.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ProductAdditionEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("oracle.medical.app.model.bc.entity.products.ProductAdditionEO");
    }


    /**
     * Gets the attribute value for ProductDiscountId, using the alias name ProductDiscountId.
     * @return the value of ProductDiscountId
     */
    public Number getProductAddId() {
        return (Number) getAttributeInternal(PRODUCTADDID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProductDiscountId.
     * @param value value to set the ProductDiscountId
     */
    public void setProductAddId(Number value) {
        setAttributeInternal(PRODUCTADDID, value);
    }

    /**
     * Gets the attribute value for ProductId, using the alias name ProductId.
     * @return the value of ProductId
     */
    public Number getProductId() {
        return (Number) getAttributeInternal(PRODUCTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for ProductId.
     * @param value value to set the ProductId
     */
    public void setProductId(Number value) {
        setAttributeInternal(PRODUCTID, value);
    }

    /**
     * Gets the attribute value for OrderNo, using the alias name OrderNo.
     * @return the value of OrderNo
     */
    public Number getOrderNo() {
        return (Number) getAttributeInternal(ORDERNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for OrderNo.
     * @param value value to set the OrderNo
     */
    public void setOrderNo(Number value) {
        setAttributeInternal(ORDERNO, value);
    }

    /**
     * Gets the attribute value for Date, using the alias name Date.
     * @return the value of Date
     */
    public Date getDate() {
        return (Date) getAttributeInternal(DATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Date.
     * @param value value to set the Date
     */
    public void setDate(Date value) {
        setAttributeInternal(DATE, value);
    }

    /**
     * Gets the attribute value for Quantity, using the alias name Quantity.
     * @return the value of Quantity
     */
    public Number getQuantity() {
        return (Number) getAttributeInternal(QUANTITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for Quantity.
     * @param value value to set the Quantity
     */
    public void setQuantity(Number value) {
        setAttributeInternal(QUANTITY, value);
    }

    /**
     * Gets the attribute value for Accepted, using the alias name Accepted.
     * @return the value of Accepted
     */
    public String getAccepted() {
        return (String) getAttributeInternal(ACCEPTED);
    }

    /**
     * Sets <code>value</code> as the attribute value for Accepted.
     * @param value value to set the Accepted
     */
    public void setAccepted(String value) {
        setAttributeInternal(ACCEPTED, value);
    }

    /**
     * @return the associated entity ProductsEOImpl.
     */
    public ProductsEOImpl getProducts() {
        return (ProductsEOImpl) getAttributeInternal(PRODUCTS);
    }

    /**
     * Sets <code>value</code> as the associated entity ProductsEOImpl.
     */
    public void setProducts(ProductsEOImpl value) {
        setAttributeInternal(PRODUCTS, value);
    }


    /**
     * @param productAddId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number productAddId) {
        return new Key(new Object[] { productAddId });
    }

    /**
     * Add attribute defaulting logic in this method.
     * @param attributeList list of attribute names/values to initialize the row
     */
    protected void create(AttributeList attributeList) {
        super.create(attributeList);
    }

    /**
     * Add entity remove logic in this method.
     */
    public void remove() {
        super.remove();
    }

    /**
     * Add locking logic here.
     */
    public void lock() {
        super.lock();
    }

    /**
     * Custom DML update/insert/delete logic here.
     * @param operation the operation type
     * @param e the transaction event
     */
    protected void doDML(int operation, TransactionEvent e) {
        if (operation == DML_INSERT) {
            SequenceImpl seq = new SequenceImpl("PRODUCT_ADDITION_SEQ", this.getDBTransaction());
            Number product_id = seq.getSequenceNumber();
            this.setProductAddId(product_id);
        }
        super.doDML(operation, e);
    }
}

