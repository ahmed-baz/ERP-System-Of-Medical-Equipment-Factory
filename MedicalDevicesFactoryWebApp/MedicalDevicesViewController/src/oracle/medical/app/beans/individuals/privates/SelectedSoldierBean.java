package oracle.medical.app.beans.individuals.privates;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class SelectedSoldierBean {
    private RichSelectOneChoice soldierStatus;
    private RichPopup savedIconpopup;
    private RichPopup editablePopup;

    public SelectedSoldierBean() {
    }

    public String saveUpdatedSoldier() {
        // Add event code here...
        System.out.println("soldier Status = " + soldierStatus.getValue());
        if (soldierStatus.getValue().equals("Y")) {
            BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
            commitOperation.execute();
            editablePopup.cancel();
            RichPopup.PopupHints hint = new RichPopup.PopupHints();
            savedIconpopup.show(hint);
        } else if (soldierStatus.getValue().equals("N")) {
            editablePopup.cancel();
            BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
            commitOperation.execute();
            OperationBinding filterSoldiers = bindingContainer.getOperationBinding("filterSoldiers");
            filterSoldiers.execute();
            ControllerContext ccontext = ControllerContext.getInstance();
            String viewId = "Soliders";
            ccontext.getCurrentViewPort().setViewId(viewId);
        } else {
            System.out.println("Step 3");
        }
        return null;

    }

    public void setSoldierStatus(RichSelectOneChoice soldierStatus) {
        this.soldierStatus = soldierStatus;
    }

    public RichSelectOneChoice getSoldierStatus() {
        return soldierStatus;
    }

    public void setSavedIconpopup(RichPopup savedIconpopup) {
        this.savedIconpopup = savedIconpopup;
    }

    public RichPopup getSavedIconpopup() {
        return savedIconpopup;
    }

    public void setEditablePopup(RichPopup editablePopup) {
        this.editablePopup = editablePopup;
    }

    public RichPopup getEditablePopup() {
        return editablePopup;
    }

    public String cancelEditpopup() {
        // Add event code here...
        editablePopup.cancel();
        return null;
    }
}
