package oracle.medical.app.beans.approvals;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class ApprovalsBean implements Serializable {
    private RichPopup updateUserpopup;

    public ApprovalsBean() {
    }

    public String saveUpdatedUser() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        updateUserpopup.cancel();
        return null;
    }

   

    public void setUpdateUserpopup(RichPopup updateUserpopup) {
        this.updateUserpopup = updateUserpopup;
    }

    public RichPopup getUpdateUserpopup() {
        return updateUserpopup;
    }

    public String cancelUpdatepopup() {
        // Add event code here...
        updateUserpopup.cancel();
        return null;
    }

    public String deleteUser() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        refreshPage();
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
