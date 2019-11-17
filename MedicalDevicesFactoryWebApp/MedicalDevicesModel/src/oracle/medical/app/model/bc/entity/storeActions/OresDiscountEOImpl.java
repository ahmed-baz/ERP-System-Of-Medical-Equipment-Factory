package oracle.medical.app.model.bc.entity.storeActions;

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
// ---    Mon Sep 30 16:58:36 EET 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OresDiscountEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        OreDiscountId,
        OreId,
        DepartmentId,
        DiscountQuantity,
        OrderNo,
        Accepted,
        DiscountDate,
        Ores;
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
    public static final int OREDISCOUNTID = AttributesEnum.OreDiscountId.index();
    public static final int OREID = AttributesEnum.OreId.index();
    public static final int DEPARTMENTID = AttributesEnum.DepartmentId.index();
    public static final int DISCOUNTQUANTITY = AttributesEnum.DiscountQuantity.index();
    public static final int ORDERNO = AttributesEnum.OrderNo.index();
    public static final int ACCEPTED = AttributesEnum.Accepted.index();
    public static final int DISCOUNTDATE = AttributesEnum.DiscountDate.index();
    public static final int ORES = AttributesEnum.Ores.index();

    /**
     * This is the default constructor (do not remove).
     */
    public OresDiscountEOImpl() {
    }

    /**
     * Gets the attribute value for OreDiscountId, using the alias name OreDiscountId.
     * @return the value of OreDiscountId
     */
    public Number getOreDiscountId() {
        return (Number) getAttributeInternal(OREDISCOUNTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OreDiscountId.
     * @param value value to set the OreDiscountId
     */
    public void setOreDiscountId(Number value) {
        setAttributeInternal(OREDISCOUNTID, value);
    }

    /**
     * Gets the attribute value for OreId, using the alias name OreId.
     * @return the value of OreId
     */
    public Number getOreId() {
        return (Number) getAttributeInternal(OREID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OreId.
     * @param value value to set the OreId
     */
    public void setOreId(Number value) {
        setAttributeInternal(OREID, value);
    }

    /**
     * Gets the attribute value for DepartmentId, using the alias name DepartmentId.
     * @return the value of DepartmentId
     */
    public Number getDepartmentId() {
        return (Number) getAttributeInternal(DEPARTMENTID);
    }

    /**
     * Sets <code>value</code> as the attribute value for DepartmentId.
     * @param value value to set the DepartmentId
     */
    public void setDepartmentId(Number value) {
        setAttributeInternal(DEPARTMENTID, value);
    }

    /**
     * Gets the attribute value for DiscountQuantity, using the alias name DiscountQuantity.
     * @return the value of DiscountQuantity
     */
    public Number getDiscountQuantity() {
        return (Number) getAttributeInternal(DISCOUNTQUANTITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for DiscountQuantity.
     * @param value value to set the DiscountQuantity
     */
    public void setDiscountQuantity(Number value) {
        setAttributeInternal(DISCOUNTQUANTITY, value);
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
     * Gets the attribute value for DiscountDate, using the alias name DiscountDate.
     * @return the value of DiscountDate
     */
    public Date getDiscountDate() {
        return (Date) getAttributeInternal(DISCOUNTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for DiscountDate.
     * @param value value to set the DiscountDate
     */
    public void setDiscountDate(Date value) {
        setAttributeInternal(DISCOUNTDATE, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getOres() {
        return (EntityImpl) getAttributeInternal(ORES);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setOres(EntityImpl value) {
        setAttributeInternal(ORES, value);
    }

    /**
     * @param oreDiscountId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number oreDiscountId) {
        return new Key(new Object[] { oreDiscountId });
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("oracle.medical.app.model.bc.entity.storeActions.OresDiscountEO");
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
            SequenceImpl seq = new SequenceImpl("ORES_DISCOUNT_SEQ", this.getDBTransaction());
            Number ore_id = seq.getSequenceNumber();
            this.setOreDiscountId(ore_id);
        }
        super.doDML(operation, e);
    }
}

