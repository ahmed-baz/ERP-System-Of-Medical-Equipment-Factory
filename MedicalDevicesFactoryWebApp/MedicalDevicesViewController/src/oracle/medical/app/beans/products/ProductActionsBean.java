
package oracle.medical.app.beans.products;

import java.io.Serializable;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.Number;

public class ProductActionsBean implements Serializable {
    private RichPopup savedIcon;
    private RichPopup breakLimitpopup;

    public ProductActionsBean() {
    }
    private RichPopup savedpopup;

    public void setSavedpopup(RichPopup savedpopup) {
        this.savedpopup = savedpopup;
    }

    public RichPopup getSavedpopup() {
        return savedpopup;
    }


    private void refreshPage() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        String refreshpage = fctx.getViewRoot().getViewId();
        ViewHandler ViewH = fctx.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fctx, refreshpage);
        UIV.setViewId(refreshpage);
        fctx.setViewRoot(UIV);

    }

    public String saveWaintingProducts() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        OperationBinding setActiveProducts = bindingContainer.getOperationBinding("setActiveProducts");
        Object activeProductsResult = setActiveProducts.execute();

        OperationBinding setWaitingProducts = bindingContainer.getOperationBinding("setWaitingProducts");
        Object waitingProductsResult = setWaitingProducts.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        savedpopup.show(hint);
        return null;
    }

    public String cancelSavedPopup() {
        // Add event code here...
        savedpopup.cancel();
        return null;
    }

    public void discountQuantityAction(ActionEvent actionEvent) {

        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding AddnewAttribute = (AttributeBinding) bindingContainer.get("Addnew");
        AddnewAttribute.setInputValue("1");
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        /* 
        OperationBinding setActiveProducts = bindingContainer.getOperationBinding("setActiveProducts");
        Object activeProductsResult = setActiveProducts.execute();
         */

        //  return null;
    }


    public void addQuantityAction(ActionEvent actionEvent) {
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        /* 
        OperationBinding activeProductsOperation = bindingContainer.getOperationBinding("setActiveProducts");
        Object result = activeProductsOperation.execute(); */

        OperationBinding nonAcceptedAddRequests = bindingContainer.getOperationBinding("nonAcceptedAddRequests");
        Object result1 = nonAcceptedAddRequests.execute();

        //return null;
    }


    public void setSavedIcon(RichPopup savedIcon) {
        this.savedIcon = savedIcon;
    }

    public RichPopup getSavedIcon() {
        return savedIcon;
    }

    public String approveAddRequest() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding requestAttribute = (AttributeBinding) bindingContainer.get("ProductAddId");
        Number requestId = (Number) requestAttribute.getInputValue();
        AttributeBinding productIdAttribute = (AttributeBinding) bindingContainer.get("ProductId");
        Number ProductId = (Number) productIdAttribute.getInputValue();
        AttributeBinding quantityAttribute = (AttributeBinding) bindingContainer.get("Quantity");
        Number quantity = (Number) quantityAttribute.getInputValue();
        OperationBinding approveAddRequests = bindingContainer.getOperationBinding("approveAddRequests");
        approveAddRequests.getParamsMap().put("requestId", requestId);
        approveAddRequests.getParamsMap().put("productId", ProductId);
        approveAddRequests.getParamsMap().put("quantity", quantity);
        approveAddRequests.execute();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        OperationBinding nonAcceptedAddRequests = bindingContainer.getOperationBinding("nonAcceptedAddRequests");
        Object result1 = nonAcceptedAddRequests.execute();

        OperationBinding activeProductsOperation = bindingContainer.getOperationBinding("setActiveProducts");
        Object result2 = activeProductsOperation.execute();
        OperationBinding filterAddQuantity = bindingContainer.getOperationBinding("filterAddQuantity");
        filterAddQuantity.execute();
        refreshPage();
        return null;
    }

    public String deleteAddRequest() {
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        refreshPage();
        return null;
    }

    public String approveDiscountRequest() {
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding requestAttribute = (AttributeBinding) bindingContainer.get("ProductDiscountId");
        Number requestId = (Number) requestAttribute.getInputValue();
        AttributeBinding productIdAttribute = (AttributeBinding) bindingContainer.get("ProductId");
        Number productId = (Number) productIdAttribute.getInputValue();
        AttributeBinding quantityAttribute = (AttributeBinding) bindingContainer.get("Quantity");
        Number quantity = (Number) quantityAttribute.getInputValue();
        AttributeBinding TotalQuantityAttribute = (AttributeBinding) bindingContainer.get("TotalQuantity");
        Number totalQuantity = (Number) TotalQuantityAttribute.getInputValue();
        

        OperationBinding discountAllowed = bindingContainer.getOperationBinding("discountAllowed");
        discountAllowed.getParamsMap().put("productId", productId);
        discountAllowed.getParamsMap().put("quantity", quantity);


        if (discountAllowed.execute().equals(true)) {
            OperationBinding approveDiscountRequests = bindingContainer.getOperationBinding("approveDiscountRequests");
            approveDiscountRequests.getParamsMap().put("requestId", requestId);
            approveDiscountRequests.getParamsMap().put("productId", productId);
            approveDiscountRequests.getParamsMap().put("quantity", quantity);
            approveDiscountRequests.execute();

            OperationBinding nonAcceptedDiscountRequests =
                bindingContainer.getOperationBinding("nonAcceptedDiscountRequests");
            Object result1 = nonAcceptedDiscountRequests.execute();

            OperationBinding activeProductsOperation = bindingContainer.getOperationBinding("setActiveProducts");
            Object result2 = activeProductsOperation.execute();
            

            OperationBinding filterDiscountQuantity = bindingContainer.getOperationBinding("filterDiscountQuantity");
            filterDiscountQuantity.execute();
            
            OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
            commitOperation.execute();
        } else {

            RichPopup.PopupHints hint = new RichPopup.PopupHints();
            breakLimitpopup.show(hint);
        }

        return null;
    }

    public void setBreakLimitpopup(RichPopup breakLimitpopup) {
        this.breakLimitpopup = breakLimitpopup;
    }

    public RichPopup getBreakLimitpopup() {
        return breakLimitpopup;
    }

    public String deleteDiscountRequest() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding productIdAttribute = (AttributeBinding) bindingContainer.get("ProductId");
        Number oreId = (Number) productIdAttribute.getInputValue();
        OperationBinding returnAddNewAttrDefault = bindingContainer.getOperationBinding("returnAddNewAttrDefault");
        returnAddNewAttrDefault.getParamsMap().put("productId", oreId);
        returnAddNewAttrDefault.execute();
        
        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        
        OperationBinding activeProductsOperation = bindingContainer.getOperationBinding("setActiveProducts");
        Object result2 = activeProductsOperation.execute();
        
        refreshPage();
        return null;
    }

    public String displayAddRequestpopup() {
        // Add event code here...
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding CreateInsertOperation = bindingContainer.getOperationBinding("CreateInsert1");
        CreateInsertOperation.execute();
        return null;
    }

    public String displayDiscountRequestpopup() {
        // Add event code here...
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding CreateInsertOperation = bindingContainer.getOperationBinding("CreateInsert");
        CreateInsertOperation.execute();
        return null;
    }

    public String confirmDeleteAction() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        /*      AttributeBinding productIdAttribute = (AttributeBinding) bindingContainer.get("OreId");
        Number productId = (Number) productIdAttribute.getInputValue(); */
        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        
        DCIteratorBinding productDCBinding = (DCIteratorBinding) bindingContainer.get("WaitingProducts1Iterator");
        productDCBinding.getDataControl().commitTransaction();
        refreshPage();
        return null;
    }
}
