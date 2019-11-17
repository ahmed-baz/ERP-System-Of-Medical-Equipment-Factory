package oracle.medical.app.beans.ores;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;

public class WaitingOreBean {
    private RichPopup savedWaitingOrePopup;

    public WaitingOreBean() {
    }


    public String confirmDeleteAction() {

        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding oreAttribute = (AttributeBinding) bindingContainer.get("OreId");
        Number oreId = (Number) oreAttribute.getInputValue();
        System.out.println("Ore Id From Waiting Bean : " + oreId);

        OperationBinding deleteChildOperation = bindingContainer.getOperationBinding("deleteReport");
        deleteChildOperation.getParamsMap().put("oreId", oreId);
        deleteChildOperation.execute();
        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        refreshPage();
        return null;
    }


    public String saveWaitingOres() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setActiveOre");
        Object result = activeOresOperation.execute();
        OperationBinding waitingOresOperation = bindingContainer.getOperationBinding("setWaitingOre");
        Object result2 = waitingOresOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        savedWaitingOrePopup.show(hint);
        return null;
    }

    public void setSavedWaitingOrePopup(RichPopup savedWaitingOrePopup) {
        this.savedWaitingOrePopup = savedWaitingOrePopup;
    }

    public RichPopup getSavedWaitingOrePopup() {
        return savedWaitingOrePopup;
    }

    public String cancelSuccessfulMessagePopup() {
        // Add event code here...
        savedWaitingOrePopup.cancel();
        return null;
    }

    private void refreshPage() {

        FacesContext fctx = FacesContext.getCurrentInstance();
        String refreshpage = fctx.getViewRoot().getViewId();
        ViewHandler ViewH = fctx.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fctx, refreshpage);
        UIV.setViewId(refreshpage);
        fctx.setViewRoot(UIV);

    }


}
