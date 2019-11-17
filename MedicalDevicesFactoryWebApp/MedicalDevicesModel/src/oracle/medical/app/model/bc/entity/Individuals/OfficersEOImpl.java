package oracle.medical.app.model.bc.entity.Individuals;

import oracle.jbo.AttributeList;
import oracle.jbo.Key;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.EntityDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.TransactionEvent;

import oracle.sql.ROWID;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Sep 13 11:11:07 EET 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class OfficersEOImpl extends EntityImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        OfficerId,
        FullName,
        MilitaryNumber,
        Ssn,
        BirthDate,
        RecruitmentDate,
        JoinDate,
        TerminationDate,
        CityId,
        Address,
        PhoneNumber,
        Image,
        QualificationId,
        SpecializationId,
        MilitaryRankId,
        MilitaryRankType,
        MilitaryServiceId,
        MaritalStatusId,
        UniversityId,
        Active,
        City,
        MaritalStatus,
        MilitaryService,
        MilitaryRanks,
        Universities,
        Specialization,
        Qualification;
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


    public static final int OFFICERID = AttributesEnum.OfficerId.index();
    public static final int FULLNAME = AttributesEnum.FullName.index();
    public static final int MILITARYNUMBER = AttributesEnum.MilitaryNumber.index();
    public static final int SSN = AttributesEnum.Ssn.index();
    public static final int BIRTHDATE = AttributesEnum.BirthDate.index();
    public static final int RECRUITMENTDATE = AttributesEnum.RecruitmentDate.index();
    public static final int JOINDATE = AttributesEnum.JoinDate.index();
    public static final int TERMINATIONDATE = AttributesEnum.TerminationDate.index();
    public static final int CITYID = AttributesEnum.CityId.index();
    public static final int ADDRESS = AttributesEnum.Address.index();
    public static final int PHONENUMBER = AttributesEnum.PhoneNumber.index();
    public static final int IMAGE = AttributesEnum.Image.index();
    public static final int QUALIFICATIONID = AttributesEnum.QualificationId.index();
    public static final int SPECIALIZATIONID = AttributesEnum.SpecializationId.index();
    public static final int MILITARYRANKID = AttributesEnum.MilitaryRankId.index();
    public static final int MILITARYRANKTYPE = AttributesEnum.MilitaryRankType.index();
    public static final int MILITARYSERVICEID = AttributesEnum.MilitaryServiceId.index();
    public static final int MARITALSTATUSID = AttributesEnum.MaritalStatusId.index();
    public static final int UNIVERSITYID = AttributesEnum.UniversityId.index();
    public static final int ACTIVE = AttributesEnum.Active.index();
    public static final int CITY = AttributesEnum.City.index();
    public static final int MARITALSTATUS = AttributesEnum.MaritalStatus.index();
    public static final int MILITARYSERVICE = AttributesEnum.MilitaryService.index();
    public static final int MILITARYRANKS = AttributesEnum.MilitaryRanks.index();
    public static final int UNIVERSITIES = AttributesEnum.Universities.index();
    public static final int SPECIALIZATION = AttributesEnum.Specialization.index();
    public static final int QUALIFICATION = AttributesEnum.Qualification.index();

    /**
     * This is the default constructor (do not remove).
     */
    public OfficersEOImpl() {
    }

    /**
     * @return the definition object for this instance class.
     */
    public static synchronized EntityDefImpl getDefinitionObject() {
        return EntityDefImpl.findDefObject("oracle.medical.app.model.bc.entity.Individuals.OfficersEO");
    }


    /**
     * Gets the attribute value for OfficerId, using the alias name OfficerId.
     * @return the value of OfficerId
     */
    public Number getOfficerId() {
        return (Number) getAttributeInternal(OFFICERID);
    }

    /**
     * Sets <code>value</code> as the attribute value for OfficerId.
     * @param value value to set the OfficerId
     */
    public void setOfficerId(Number value) {
        setAttributeInternal(OFFICERID, value);
    }

    /**
     * Gets the attribute value for FullName, using the alias name FullName.
     * @return the value of FullName
     */
    public String getFullName() {
        return (String) getAttributeInternal(FULLNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for FullName.
     * @param value value to set the FullName
     */
    public void setFullName(String value) {
        setAttributeInternal(FULLNAME, value);
    }

    /**
     * Gets the attribute value for MilitaryNumber, using the alias name MilitaryNumber.
     * @return the value of MilitaryNumber
     */
    public Number getMilitaryNumber() {
        return (Number) getAttributeInternal(MILITARYNUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for MilitaryNumber.
     * @param value value to set the MilitaryNumber
     */
    public void setMilitaryNumber(Number value) {
        setAttributeInternal(MILITARYNUMBER, value);
    }

    /**
     * Gets the attribute value for Ssn, using the alias name Ssn.
     * @return the value of Ssn
     */
    public Number getSsn() {
        return (Number) getAttributeInternal(SSN);
    }

    /**
     * Sets <code>value</code> as the attribute value for Ssn.
     * @param value value to set the Ssn
     */
    public void setSsn(Number value) {
        setAttributeInternal(SSN, value);
    }

    /**
     * Gets the attribute value for BirthDate, using the alias name BirthDate.
     * @return the value of BirthDate
     */
    public Date getBirthDate() {
        return (Date) getAttributeInternal(BIRTHDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for BirthDate.
     * @param value value to set the BirthDate
     */
    public void setBirthDate(Date value) {
        setAttributeInternal(BIRTHDATE, value);
    }

    /**
     * Gets the attribute value for RecruitmentDate, using the alias name RecruitmentDate.
     * @return the value of RecruitmentDate
     */
    public Date getRecruitmentDate() {
        return (Date) getAttributeInternal(RECRUITMENTDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for RecruitmentDate.
     * @param value value to set the RecruitmentDate
     */
    public void setRecruitmentDate(Date value) {
        setAttributeInternal(RECRUITMENTDATE, value);
    }

    /**
     * Gets the attribute value for JoinDate, using the alias name JoinDate.
     * @return the value of JoinDate
     */
    public Date getJoinDate() {
        return (Date) getAttributeInternal(JOINDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for JoinDate.
     * @param value value to set the JoinDate
     */
    public void setJoinDate(Date value) {
        setAttributeInternal(JOINDATE, value);
    }

    /**
     * Gets the attribute value for TerminationDate, using the alias name TerminationDate.
     * @return the value of TerminationDate
     */
    public Date getTerminationDate() {
        return (Date) getAttributeInternal(TERMINATIONDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for TerminationDate.
     * @param value value to set the TerminationDate
     */
    public void setTerminationDate(Date value) {
        setAttributeInternal(TERMINATIONDATE, value);
    }

    /**
     * Gets the attribute value for CityId, using the alias name CityId.
     * @return the value of CityId
     */
    public Number getCityId() {
        return (Number) getAttributeInternal(CITYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for CityId.
     * @param value value to set the CityId
     */
    public void setCityId(Number value) {
        setAttributeInternal(CITYID, value);
    }

    /**
     * Gets the attribute value for Address, using the alias name Address.
     * @return the value of Address
     */
    public String getAddress() {
        return (String) getAttributeInternal(ADDRESS);
    }

    /**
     * Sets <code>value</code> as the attribute value for Address.
     * @param value value to set the Address
     */
    public void setAddress(String value) {
        setAttributeInternal(ADDRESS, value);
    }

    /**
     * Gets the attribute value for PhoneNumber, using the alias name PhoneNumber.
     * @return the value of PhoneNumber
     */
    public String getPhoneNumber() {
        return (String) getAttributeInternal(PHONENUMBER);
    }

    /**
     * Sets <code>value</code> as the attribute value for PhoneNumber.
     * @param value value to set the PhoneNumber
     */
    public void setPhoneNumber(String value) {
        setAttributeInternal(PHONENUMBER, value);
    }

    /**
     * Gets the attribute value for Image, using the alias name Image.
     * @return the value of Image
     */
    public BlobDomain getImage() {
        return (BlobDomain) getAttributeInternal(IMAGE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Image.
     * @param value value to set the Image
     */
    public void setImage(BlobDomain value) {
        setAttributeInternal(IMAGE, value);
    }

    /**
     * Gets the attribute value for QualificationId, using the alias name QualificationId.
     * @return the value of QualificationId
     */
    public Number getQualificationId() {
        return (Number) getAttributeInternal(QUALIFICATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for QualificationId.
     * @param value value to set the QualificationId
     */
    public void setQualificationId(Number value) {
        setAttributeInternal(QUALIFICATIONID, value);
    }

    /**
     * Gets the attribute value for SpecializationId, using the alias name SpecializationId.
     * @return the value of SpecializationId
     */
    public Number getSpecializationId() {
        return (Number) getAttributeInternal(SPECIALIZATIONID);
    }

    /**
     * Sets <code>value</code> as the attribute value for SpecializationId.
     * @param value value to set the SpecializationId
     */
    public void setSpecializationId(Number value) {
        setAttributeInternal(SPECIALIZATIONID, value);
    }

    /**
     * Gets the attribute value for MilitaryRankId, using the alias name MilitaryRankId.
     * @return the value of MilitaryRankId
     */
    public Number getMilitaryRankId() {
        return (Number) getAttributeInternal(MILITARYRANKID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MilitaryRankId.
     * @param value value to set the MilitaryRankId
     */
    public void setMilitaryRankId(Number value) {
        setAttributeInternal(MILITARYRANKID, value);
    }

    /**
     * Gets the attribute value for MilitaryServiceId, using the alias name MilitaryServiceId.
     * @return the value of MilitaryServiceId
     */
    public Number getMilitaryServiceId() {
        return (Number) getAttributeInternal(MILITARYSERVICEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MilitaryServiceId.
     * @param value value to set the MilitaryServiceId
     */
    public void setMilitaryServiceId(Number value) {
        setAttributeInternal(MILITARYSERVICEID, value);
    }

    /**
     * Gets the attribute value for MaritalStatusId, using the alias name MaritalStatusId.
     * @return the value of MaritalStatusId
     */
    public Number getMaritalStatusId() {
        return (Number) getAttributeInternal(MARITALSTATUSID);
    }

    /**
     * Sets <code>value</code> as the attribute value for MaritalStatusId.
     * @param value value to set the MaritalStatusId
     */
    public void setMaritalStatusId(Number value) {
        setAttributeInternal(MARITALSTATUSID, value);
    }

    /**
     * Gets the attribute value for UniversityId, using the alias name UniversityId.
     * @return the value of UniversityId
     */
    public Number getUniversityId() {
        return (Number) getAttributeInternal(UNIVERSITYID);
    }

    /**
     * Sets <code>value</code> as the attribute value for UniversityId.
     * @param value value to set the UniversityId
     */
    public void setUniversityId(Number value) {
        setAttributeInternal(UNIVERSITYID, value);
    }

    /**
     * Gets the attribute value for Active, using the alias name Active.
     * @return the value of Active
     */
    public String getActive() {
        return (String) getAttributeInternal(ACTIVE);
    }

    /**
     * Sets <code>value</code> as the attribute value for Active.
     * @param value value to set the Active
     */
    public void setActive(String value) {
        setAttributeInternal(ACTIVE, value);
    }


    /**
     * Gets the attribute value for MilitaryRankType, using the alias name MilitaryRankType.
     * @return the value of MilitaryRankType
     */
    public Number getMilitaryRankType() {
        return (Number) getAttributeInternal(MILITARYRANKTYPE);
    }

    /**
     * Sets <code>value</code> as the attribute value for MilitaryRankType.
     * @param value value to set the MilitaryRankType
     */
    public void setMilitaryRankType(Number value) {
        setAttributeInternal(MILITARYRANKTYPE, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getCity() {
        return (EntityImpl) getAttributeInternal(CITY);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setCity(EntityImpl value) {
        setAttributeInternal(CITY, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getMaritalStatus() {
        return (EntityImpl) getAttributeInternal(MARITALSTATUS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setMaritalStatus(EntityImpl value) {
        setAttributeInternal(MARITALSTATUS, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getMilitaryService() {
        return (EntityImpl) getAttributeInternal(MILITARYSERVICE);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setMilitaryService(EntityImpl value) {
        setAttributeInternal(MILITARYSERVICE, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getMilitaryRanks() {
        return (EntityImpl) getAttributeInternal(MILITARYRANKS);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setMilitaryRanks(EntityImpl value) {
        setAttributeInternal(MILITARYRANKS, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getUniversities() {
        return (EntityImpl) getAttributeInternal(UNIVERSITIES);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setUniversities(EntityImpl value) {
        setAttributeInternal(UNIVERSITIES, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getSpecialization() {
        return (EntityImpl) getAttributeInternal(SPECIALIZATION);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setSpecialization(EntityImpl value) {
        setAttributeInternal(SPECIALIZATION, value);
    }

    /**
     * @return the associated entity oracle.jbo.server.EntityImpl.
     */
    public EntityImpl getQualification() {
        return (EntityImpl) getAttributeInternal(QUALIFICATION);
    }

    /**
     * Sets <code>value</code> as the associated entity oracle.jbo.server.EntityImpl.
     */
    public void setQualification(EntityImpl value) {
        setAttributeInternal(QUALIFICATION, value);
    }


    /**
     * @param officerId key constituent

     * @return a Key object based on given key constituents.
     */
    public static Key createPrimaryKey(Number officerId) {
        return new Key(new Object[] { officerId });
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
            SequenceImpl seq = new SequenceImpl("OFFICERS_SEQ", this.getDBTransaction());
            Number officer_id = seq.getSequenceNumber();
            this.setOfficerId(officer_id);
        }
        super.doDML(operation, e);
    }
}
