package oracle.medical.app.beans.ores;

import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.AttributeBinding;

import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.model.UploadedFile;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputFile;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;


public class OreBean {
    private RichPopup savedIcon;
    private RichPopup updatedOrePopup;

    public OreBean() {
    }


    public void setSavedIcon(RichPopup savedIcon) {
        this.savedIcon = savedIcon;
    }

    public RichPopup getSavedIcon() {
        return savedIcon;
    }

    public String saveUpdatedOre() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding oreAttribute = (AttributeBinding) bindingContainer.get("OreId");
        AttributeBinding newRequestAttribute = (AttributeBinding) bindingContainer.get("Addnew");
        Number oreId = (Number) oreAttribute.getInputValue();
        AttributeBinding ActiveAttribute = (AttributeBinding) bindingContainer.get("Active");
        String Active = (String) ActiveAttribute.getInputValue();
        if (Active.equals("N")) {
            OperationBinding deleteRequestsOperation = bindingContainer.getOperationBinding("deleteRequests");
            deleteRequestsOperation.getParamsMap().put("oreId", oreId);
            newRequestAttribute.setInputValue(0);
            deleteRequestsOperation.execute();
        }
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setActiveOre");
        Object result = activeOresOperation.execute();
        OperationBinding waitingOresOperation = bindingContainer.getOperationBinding("setWaitingOre");
        Object result2 = waitingOresOperation.execute();
        updatedOrePopup.cancel();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        savedIcon.show(hint);

        return null;
    }

    public void setUpdatedOrePopup(RichPopup updatedOrePopup) {
        this.updatedOrePopup = updatedOrePopup;
    }

    public RichPopup getUpdatedOrePopup() {
        return updatedOrePopup;
    }


    private void refreshPage() {
        FacesContext fctx = FacesContext.getCurrentInstance();
        String refreshpage = fctx.getViewRoot().getViewId();
        ViewHandler ViewH = fctx.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fctx, refreshpage);
        UIV.setViewId(refreshpage);
        fctx.setViewRoot(UIV);

    }

    
    public String cancelUpdatepop() {
        // Add event code here...
        updatedOrePopup.cancel();
        return null;
    }
    
}
