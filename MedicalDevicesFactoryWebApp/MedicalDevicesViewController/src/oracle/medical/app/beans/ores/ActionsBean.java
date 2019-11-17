package oracle.medical.app.beans.ores;

import java.io.Serializable;

import javax.el.ELContext;

import javax.el.ExpressionFactory;

import javax.el.MethodExpression;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;


import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

public class ActionsBean implements Serializable {
    private RichPopup savedIcon;
    private RichPopup breakLimitpopup;

    public ActionsBean() {
    }

    public void commitAdd(ActionEvent actionEvent) {
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        /* 
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setMainActiveOre");
        Object result1 = activeOresOperation.execute(); */

        OperationBinding filterAddQuantityOperation = bindingContainer.getOperationBinding("filterAddQuantity");
        Object result2 = filterAddQuantityOperation.execute();

     
        //return null;
    }


    public void commitDiscount(ActionEvent actionEvent) {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding AddnewAttribute = (AttributeBinding) bindingContainer.get("Addnew");
        AddnewAttribute.setInputValue("1");
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        /* 
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setMainActiveOre");
        Object result = activeOresOperation.execute(); */

        
        OperationBinding filterdiscountQuantityOperation = bindingContainer.getOperationBinding("filterDiscountQuantity");
        Object result2 = filterdiscountQuantityOperation.execute();
        
       // return null;
    }

    public void setSavedIcon(RichPopup savedIcon) {
        this.savedIcon = savedIcon;
    }

    public RichPopup getSavedIcon() {
        return savedIcon;
    }


    private void refreshPage() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        String refreshpage = fctx.getViewRoot().getViewId();
        ViewHandler ViewH = fctx.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fctx, refreshpage);
        UIV.setViewId(refreshpage);
        fctx.setViewRoot(UIV);

    }

    public String refreshWebPage() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setMainActiveOre");
        Object result = activeOresOperation.execute();
        refreshPage();
        savedIcon.cancel();
        return null;
    }


    public String deleteAddRequest() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        refreshPage();
        return null;
    }

    public String deleteDiscountRequest() {
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding oreIdAttribute = (AttributeBinding) bindingContainer.get("OreId");
        Number oreId = (Number) oreIdAttribute.getInputValue();
        OperationBinding returnAddNewAttrDefault = bindingContainer.getOperationBinding("returnAddNewAttrDefault");
        returnAddNewAttrDefault.getParamsMap().put("oreId", oreId);
        returnAddNewAttrDefault.execute();
        System.out.println("Ore Id Frmo Request : " + oreId);
        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        refreshPage();
        return null;
    }

    public String approveDiscountRequest() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding requestAttribute = (AttributeBinding) bindingContainer.get("OreDiscountId");
        Number requestId = (Number) requestAttribute.getInputValue();
        AttributeBinding oreIdAttribute = (AttributeBinding) bindingContainer.get("OreId");
        Number oreId = (Number) oreIdAttribute.getInputValue();
        AttributeBinding quantityAttribute = (AttributeBinding) bindingContainer.get("DiscountQuantity");
        Number quantity = (Number) quantityAttribute.getInputValue();


        OperationBinding discountAllowed = bindingContainer.getOperationBinding("discountAllowed");
        discountAllowed.getParamsMap().put("oreId", oreId);
        discountAllowed.getParamsMap().put("quantity", quantity);

        if (discountAllowed.execute().equals(true)) {
            OperationBinding approveDiscountRequests = bindingContainer.getOperationBinding("approveDiscountRequests");
            approveDiscountRequests.getParamsMap().put("requestId", requestId);
            approveDiscountRequests.getParamsMap().put("oreId", oreId);
            approveDiscountRequests.getParamsMap().put("quantity", quantity);
            approveDiscountRequests.execute();
            OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
            commitOperation.execute();
        } else {

            RichPopup.PopupHints hint = new RichPopup.PopupHints();
            breakLimitpopup.show(hint);
        }
        
        
        OperationBinding setActiveOre = bindingContainer.getOperationBinding("setActiveOre");
        setActiveOre.execute();
        
        OperationBinding filterDiscountReport = bindingContainer.getOperationBinding("filterDiscountReport");
        filterDiscountReport.execute();
        
        return null;
    }

    public String approveAddRequest() {
        
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding requestAttribute = (AttributeBinding) bindingContainer.get("OreAdditionId");
        Number requestId = (Number) requestAttribute.getInputValue();
        AttributeBinding oreIdAttribute = (AttributeBinding) bindingContainer.get("OreId");
        Number oreId = (Number) oreIdAttribute.getInputValue();
        AttributeBinding quantityAttribute = (AttributeBinding) bindingContainer.get("AdditionQuantity");
        Number quantity = (Number) quantityAttribute.getInputValue();
        OperationBinding approveAddRequests = bindingContainer.getOperationBinding("approveAddRequests");
        approveAddRequests.getParamsMap().put("requestId", requestId);
        approveAddRequests.getParamsMap().put("oreId", oreId);
        approveAddRequests.getParamsMap().put("quantity", quantity);
        approveAddRequests.execute();
        
        OperationBinding setActiveOre = bindingContainer.getOperationBinding("setActiveOre");
        setActiveOre.execute();
        
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        OperationBinding filterAddReport = bindingContainer.getOperationBinding("filterAddReport");
        filterAddReport.execute();
        
        refreshPage();
        return null;
    }

    public void FilterOres(ActionEvent actionEvent) {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setActiveOre");
        Object result = activeOresOperation.execute();
        OperationBinding waitingOresOperation = bindingContainer.getOperationBinding("setWaitingOre");
        Object result2 = waitingOresOperation.execute();
    }

    public void setBreakLimitpopup(RichPopup breakLimitpopup) {
        this.breakLimitpopup = breakLimitpopup;
    }

    public RichPopup getBreakLimitpopup() {
        return breakLimitpopup;
    }

}
