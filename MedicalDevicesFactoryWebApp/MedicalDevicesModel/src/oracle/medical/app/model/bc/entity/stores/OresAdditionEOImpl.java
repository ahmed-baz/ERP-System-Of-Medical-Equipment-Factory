package oracle.medical.app.model.bc.entity.stores;

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
// ---    Wed May 08 19:05:42 EET 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OresAdditionEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        OreAdditionId,
        OreId,
        AdditionQuantity,
        BillNo,
        AdditionDate,
        Accepted,
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

    public static final int OREADDITIONID = AttributesEnum.OreAdditionId.index();
    public static final int OREID = AttributesEnum.OreId.index();
    public static final int ADDITIONQUANTITY = AttributesEnum.AdditionQuantity.index();
    public static final int BILLNO = AttributesEnum.BillNo.index();
    public static final int ADDITIONDATE = AttributesEnum.AdditionDate.index();
    public static final int ACCEPTED = AttributesEnum.Accepted.index();
    public static final int ORES = AttributesEnum.Ores.index();

    /**
     * This is the default constructor (do not remove).
     */
    public OresAdditionEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("oracle.medical.app.model.bc.entity.stores.OresAdditionEO");
    }

    /**
     * Gets the attribute value for OreAdditionId, using the alias name OreAdditionId.
     * @return the value of OreAdditionId
     */
    public Number getOreAdditionId() {
        return (Number) getAttributeInternal(OREADDITIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OreAdditionId.
     * @param value value to set the OreAdditionId
     */
    public void setOreAdditionId(Number value) {
        setAttributeInternal(OREADDITIONID, value);
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
     * Gets the attribute value for AdditionQuantity, using the alias name AdditionQuantity.
     * @return the value of AdditionQuantity
     */
    public Number getAdditionQuantity() {
        return (Number) getAttributeInternal(ADDITIONQUANTITY);
    }

    /**
     * Sets <code>value</code> as the attribute value for AdditionQuantity.
     * @param value value to set the AdditionQuantity
     */
    public void setAdditionQuantity(Number value) {
        setAttributeInternal(ADDITIONQUANTITY, value);
    }

    /**
     * Gets the attribute value for BillNo, using the alias name BillNo.
     * @return the value of BillNo
     */
    public Number getBillNo() {
        return (Number) getAttributeInternal(BILLNO);
    }

    /**
     * Sets <code>value</code> as the attribute value for BillNo.
     * @param value value to set the BillNo
     */
    public void setBillNo(Number value) {
        setAttributeInternal(BILLNO, value);
    }

  

    /**
     * Gets the attribute value for AdditionDate, using the alias name AdditionDate.
     * @return the value of AdditionDate
     */
    public Date getAdditionDate() {
        return (Date) getAttributeInternal(ADDITIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for AdditionDate.
     * @param value value to set the AdditionDate
     */
    public void setAdditionDate(Date value) {
        setAttributeInternal(ADDITIONDATE, value);
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
     * @return the associated entity OresEOImpl.
     */
    public OresEOImpl getOres() {
        return (OresEOImpl) getAttributeInternal(ORES);
    }

    /**
     * Sets <code>value</code> as the associated entity OresEOImpl.
     */
    public void setOres(OresEOImpl value) {
        setAttributeInternal(ORES, value);
    }


    /**
     * @param oreAdditionId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number oreAdditionId) {
        return new Key(new Object[] { oreAdditionId });
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
            SequenceImpl seq = new SequenceImpl("ORES_ADDITION_SEQ", this.getDBTransaction());
            Number ore_id = seq.getSequenceNumber();
            this.setOreAdditionId(ore_id);
        }
        super.doDML(operation, e);
    }
}
