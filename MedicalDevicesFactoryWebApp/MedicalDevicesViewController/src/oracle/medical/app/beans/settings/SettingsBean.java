package oracle.medical.app.beans.settings;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class SettingsBean {
    private RichPopup qualifcication_popup;

    public void setCamps_popup(RichPopup camps_popup) {
        this.camps_popup = camps_popup;
    }

    public RichPopup getCamps_popup() {
        return camps_popup;
    }

    public void setService_popup(RichPopup service_popup) {
        this.service_popup = service_popup;
    }

    public RichPopup getService_popup() {
        return service_popup;
    }

    public void setUniversity_popup(RichPopup university_popup) {
        this.university_popup = university_popup;
    }

    public RichPopup getUniversity_popup() {
        return university_popup;
    }

    public void setSpecilization_popup(RichPopup specilization_popup) {
        this.specilization_popup = specilization_popup;
    }

    public RichPopup getSpecilization_popup() {
        return specilization_popup;
    }

    public void setDepartments_popup(RichPopup departments_popup) {
        this.departments_popup = departments_popup;
    }

    public RichPopup getDepartments_popup() {
        return departments_popup;
    }

    public void setRawType_popup(RichPopup rawType_popup) {
        this.rawType_popup = rawType_popup;
    }

    public RichPopup getRawType_popup() {
        return rawType_popup;
    }

    public void setTask_popup(RichPopup task_popup) {
        this.task_popup = task_popup;
    }

    public RichPopup getTask_popup() {
        return task_popup;
    }
    private RichPopup camps_popup;
    private RichPopup service_popup;
    private RichPopup university_popup;
    private RichPopup specilization_popup;
    private RichPopup departments_popup;
    private RichPopup rawType_popup;
    private RichPopup task_popup;

    public SettingsBean() {
    }


    public String saveQualifcications() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        qualifcication_popup.show(hint);
        return null;
    }
    
    public String saveCamps() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        camps_popup.show(hint);
        return null;
    }
    
    public String saveDepartments() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        departments_popup.show(hint);
        return null;
    }
    
    public String saveMiliteryService() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        service_popup.show(hint);
        return null;
    }
    
    public String saveRawMaterialType() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        rawType_popup.show(hint);
        return null;
    }
    
    public String saveTasks() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        task_popup.show(hint);
        return null;
    }
    
    public String saveSpecilization() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        specilization_popup.show(hint);
        return null;
    }
    public String saveUniversity() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        university_popup.show(hint);
        return null;
    }

    public void setQualifcication_popup(RichPopup qualifcication_popup) {
        this.qualifcication_popup = qualifcication_popup;
    }

    public RichPopup getQualifcication_popup() {
        return qualifcication_popup;
    }
}
