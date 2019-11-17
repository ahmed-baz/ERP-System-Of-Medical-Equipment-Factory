package oracle.medical.app.model.bc.module;


import java.sql.SQLException;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.domain.Number;
import oracle.jbo.domain.Date;


import oracle.jbo.server.ViewObjectImpl;

import oracle.medical.app.model.bc.module.common.StoreActionsAppModuleAM;
import oracle.medical.app.model.classes.DateUtil;

// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Sun Apr 14 17:01:21 EET 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class StoreActionsAppModuleAMImpl extends ApplicationModuleImpl implements StoreActionsAppModuleAM {
    /**
     * This is the default constructor (do not remove).
     */
    public StoreActionsAppModuleAMImpl() {
    }

    /**
     * Container's getter for OresAddition1.
     * @return OresAddition1
     */
    public ViewObjectImpl getOresAddition1() {
        return (ViewObjectImpl) findViewObject("OresAddition1");
    }

    /**
     * Container's getter for OresDiscount1.
     * @return OresDiscount1
     */
    public ViewObjectImpl getOresDiscount1() {
        return (ViewObjectImpl) findViewObject("OresDiscount1");
    }

    /**
     * Container's getter for Ores1.
     * @return Ores1
     */
    public ViewObjectImpl getOres1() {
        return (ViewObjectImpl) findViewObject("Ores1");
    }

    /**
     * Container's getter for OresAddition2.
     * @return OresAddition2
     */
    public ViewObjectImpl getOresAddition2() {
        return (ViewObjectImpl) findViewObject("OresAddition2");
    }

    /**
     * Container's getter for OresDiscount2.
     * @return OresDiscount2
     */
    public ViewObjectImpl getOresDiscount2() {
        return (ViewObjectImpl) findViewObject("OresDiscount2");
    }

    /**
     * Container's getter for OreId1VuLink1.
     * @return OreId1VuLink1
     */
    public ViewLinkImpl getOreId1VuLink1() {
        return (ViewLinkImpl) findViewLink("OreId1VuLink1");
    }

    /**
     * Container's getter for OresDiscountVuLink1.
     * @return OresDiscountVuLink1
     */
    public ViewLinkImpl getOresDiscountVuLink1() {
        return (ViewLinkImpl) findViewLink("OresDiscountVuLink1");
    }

    public void deleteChild(Number oreId) {

        ViewObjectImpl OresDiscountVO = getOresDiscount1();
        ViewCriteria OresDiscountVC = OresDiscountVO.createViewCriteria();
        ViewCriteriaRow vcRow = OresDiscountVC.createViewCriteriaRow();
        vcRow.setAttribute("OreId", oreId);
        OresDiscountVC.addRow(vcRow);
        OresDiscountVO.applyViewCriteria(OresDiscountVC);
        OresDiscountVO.executeQuery();


        RowSetIterator oresIter = OresDiscountVO.createRowSetIterator(null);
        while (oresIter.hasNext()) { // User Found ok
            // Retrieve Needed Data to be put on Session Scope
            Row childRow = oresIter.next();
            childRow.remove();
            this.getDBTransaction().commit();
        }


        ViewObjectImpl OresAddVO = getOresAddition1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreId", oreId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();


        RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
        while (oresAddIter.hasNext()) { // User Found ok
            // Retrieve Needed Data to be put on Session Scope
            Row childRow = oresAddIter.next();
            childRow.remove();
            this.getDBTransaction().commit();
        }


        this.getDBTransaction().commit();
        deleteReport(oreId);
    }

    public void filterDiscountQuantity() {
        ViewObjectImpl OresDiscountVO = getOresDiscount1();
        ViewCriteria OresDiscountVC = OresDiscountVO.createViewCriteria();
        ViewCriteriaRow vcRow = OresDiscountVC.createViewCriteriaRow();
        vcRow.setAttribute("Accepted", "N");
        OresDiscountVC.addRow(vcRow);
        OresDiscountVO.applyViewCriteria(OresDiscountVC);
        OresDiscountVO.executeQuery();
    }

    public void filterAddQuantity() {
        ViewObjectImpl OresAddVO = getOresAddition1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcRow = OresAddVC.createViewCriteriaRow();
        vcRow.setAttribute("Accepted", "N");
        OresAddVC.addRow(vcRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();
    }

    /**
     * Container's getter for MainOres1.
     * @return MainOres1
     */
    public ViewObjectImpl getMainOres1() {
        return (ViewObjectImpl) findViewObject("MainOres1");
    }


    /**
     * Container's getter for AddQuantityReport1.
     * @return AddQuantityReport1
     */
    public ViewObjectImpl getAddQuantityReport1() {
        return (ViewObjectImpl) findViewObject("AddQuantityReport1");
    }

    /**
     * Container's getter for AddQuantityReportVuLink1.
     * @return AddQuantityReportVuLink1
     */
    public ViewLinkImpl getAddQuantityReportVuLink1() {
        return (ViewLinkImpl) findViewLink("AddQuantityReportVuLink1");
    }

    /**
     * Container's getter for DiscountQuantityReport1.
     * @return DiscountQuantityReport1
     */
    public ViewObjectImpl getDiscountQuantityReport1() {
        return (ViewObjectImpl) findViewObject("DiscountQuantityReport1");
    }

    /**
     * Container's getter for DiscountQuantityReportVuLink1.
     * @return DiscountQuantityReportVuLink1
     */
    public ViewLinkImpl getDiscountQuantityReportVuLink1() {
        return (ViewLinkImpl) findViewLink("DiscountQuantityReportVuLink1");
    }

    /**
     * Container's getter for AddQuantityReport2.
     * @return AddQuantityReport2
     */
    public ViewObjectImpl getAddQuantityReport2() {
        return (ViewObjectImpl) findViewObject("AddQuantityReport2");
    }

    /**
     * Container's getter for DiscountQuantityReport2.
     * @return DiscountQuantityReport2
     */
    public ViewObjectImpl getDiscountQuantityReport2() {
        return (ViewObjectImpl) findViewObject("DiscountQuantityReport2");
    }


    public void deleteReport(Number oreId) {

        ViewObjectImpl OresDiscountVO = getDiscountQuantityReport2();
        ViewCriteria OresDiscountVC = OresDiscountVO.createViewCriteria();
        ViewCriteriaRow vcRow = OresDiscountVC.createViewCriteriaRow();
        vcRow.setAttribute("OreId", oreId);
        OresDiscountVC.addRow(vcRow);
        OresDiscountVO.applyViewCriteria(OresDiscountVC);
        OresDiscountVO.executeQuery();


        RowSetIterator oresIter = OresDiscountVO.createRowSetIterator(null);
        while (oresIter.hasNext()) { // User Found ok
            // Retrieve Needed Data to be put on Session Scope
            Row childRow = oresIter.next();
            childRow.remove();
            this.getDBTransaction().commit();
        }


        ViewObjectImpl OresAddVO = getAddQuantityReport2();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreId", oreId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();


        RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
        while (oresAddIter.hasNext()) { // User Found ok
            // Retrieve Needed Data to be put on Session Scope
            Row childRow = oresAddIter.next();
            childRow.remove();
            this.getDBTransaction().commit();
        }


        this.getDBTransaction().commit();
    }


    public void filterAddReport() {
        ViewObjectImpl vo = getAddQuantityReport2();
        ViewCriteria vc = vo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("Accepted", "Y");
        vc.addRow(vcRow);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
    }

    public void filterDiscountReport() {
        ViewObjectImpl vo = getDiscountQuantityReport2();
        ViewCriteria vc = vo.createViewCriteria();
        ViewCriteriaRow vcRow = vc.createViewCriteriaRow();
        vcRow.setAttribute("Accepted", "Y");
        vc.addRow(vcRow);
        vo.applyViewCriteria(vc);
        vo.executeQuery();
    }

    public void deleteRequests(Number oreId) {

        ViewObjectImpl OresDiscountVO = getOresDiscount1();
        ViewCriteria OresDiscountVC = OresDiscountVO.createViewCriteria();
        ViewCriteriaRow vcRow = OresDiscountVC.createViewCriteriaRow();
        vcRow.setAttribute("OreId", oreId);
        OresDiscountVC.addRow(vcRow);
        OresDiscountVO.applyViewCriteria(OresDiscountVC);
        OresDiscountVO.executeQuery();


        RowSetIterator oresIter = OresDiscountVO.createRowSetIterator(null);
        while (oresIter.hasNext()) { // User Found ok
            // Retrieve Needed Data to be put on Session Scope
            Row childRow = oresIter.next();
            childRow.remove();
            this.getDBTransaction().commit();
        }


        ViewObjectImpl OresAddVO = getOresAddition1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreId", oreId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();


        RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
        while (oresAddIter.hasNext()) { // User Found ok
            // Retrieve Needed Data to be put on Session Scope
            Row childRow = oresAddIter.next();
            childRow.remove();
            this.getDBTransaction().commit();
        }
        this.getDBTransaction().commit();
    }


    public void approveAddRequests(Number requestId, Number oreId, Number quantity) {
        System.out.println("Hello World From Approve Add Request");
        ViewObjectImpl OresAddVO = getOresAddition1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreAdditionId", requestId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();
       
        if (OresAddVO.getRowCount() > 0) {
            System.out.println("Hello World From Approve Add Request Filtred");
            RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
            Row row = oresAddIter.next();
            row.setAttribute("Accepted", "Y");
            this.getDBTransaction().commit();
        }
        addQuantity(oreId, quantity);

        ViewObjectImpl OresVO = getOresAddition1();
        ViewCriteria OresVC = OresVO.createViewCriteria();
        ViewCriteriaRow vcRow = OresVC.createViewCriteriaRow();
        vcRow.setAttribute("Accepted", "N");
        OresVC.addRow(vcRow);
        OresVO.applyViewCriteria(OresVC);
        OresVO.executeQuery();
    }

    public void addQuantity(Number oreId, Number quantity) {
        System.out.println("Hello World From Approve Add Quantity");
        ViewObjectImpl OresAddVO = getMainOres1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreId", oreId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();

        
        if (OresAddVO.getRowCount() > 0) {
            System.out.println("Hello World From Approve Add Quantity Filtered");
            RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
            Row row = oresAddIter.next();
            Number mainQuantity = (Number) row.getAttribute("Quentity");
            Number newQuantity = mainQuantity.add(quantity);
            row.setAttribute("Quentity", newQuantity);
            this.getDBTransaction().commit();
        }
        this.getDBTransaction().commit();
    }


    public void approveDiscountRequests(Number requestId, Number oreId, Number quantity) {
        ViewObjectImpl OresAddVO = getOresDiscount1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreDiscountId", requestId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();
        if (discountAllowed(oreId, quantity)) {
            RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
            while (oresAddIter.hasNext()) { // User Found ok
                // Retrieve Needed Data to be put on Session Scope
                Row row = oresAddIter.next();
                row.setAttribute("Accepted", "Y");
                this.getDBTransaction().commit();
            }
            discountQuantity(oreId, quantity);
        }

        ViewObjectImpl OresVO = getOresDiscount1();
        ViewCriteria OresVC = OresVO.createViewCriteria();
        ViewCriteriaRow vcRow = OresVC.createViewCriteriaRow();
        vcRow.setAttribute("Accepted", "N");
        OresVC.addRow(vcRow);
        OresVO.applyViewCriteria(OresVC);
        OresVO.executeQuery();
    }

    public void discountQuantity(Number oreId, Number quantity) {
        ViewObjectImpl OresAddVO = getMainOres1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreId", oreId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();

        RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
        while (oresAddIter.hasNext()) {
            Row row = oresAddIter.next();
            Number mainQuantity = (Number) row.getAttribute("Quentity");
            Number criticalLimit = (Number) row.getAttribute("CriticalLimit");
            row.setAttribute("Addnew", 0);
            if (quantity.compareTo(mainQuantity.sub(criticalLimit)) <= 0) {
                Number newQuantity = mainQuantity.subtract(quantity);
                row.setAttribute("Quentity", newQuantity);
                this.getDBTransaction().commit();
            }

        }
    }

    public Boolean discountAllowed(Number oreId, Number quantity) {
        boolean allowed = false;
        ViewObjectImpl OresAddVO = getMainOres1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreId", oreId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();

        RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
        while (oresAddIter.hasNext()) {
            Row row = oresAddIter.next();
            Number mainQuantity = (Number) row.getAttribute("Quentity");
            Number criticalLimit = (Number) row.getAttribute("CriticalLimit");
            if (quantity.compareTo(mainQuantity.sub(criticalLimit)) <= 0) {
                allowed = true;
            }

        }
        return allowed;
    }

    public void returnAddNewAttrDefault(Number oreId) {
        ViewObjectImpl OresAddVO = getMainOres1();
        ViewCriteria OresAddVC = OresAddVO.createViewCriteria();
        ViewCriteriaRow vcAddRow = OresAddVC.createViewCriteriaRow();
        vcAddRow.setAttribute("OreId", oreId);
        OresAddVC.addRow(vcAddRow);
        OresAddVO.applyViewCriteria(OresAddVC);
        OresAddVO.executeQuery();

        RowSetIterator oresAddIter = OresAddVO.createRowSetIterator(null);
        while (oresAddIter.hasNext()) {
            Row row = oresAddIter.next();
            row.setAttribute("Addnew", 0);

        }
        this.getDBTransaction().commit();
    }

}

