package oracle.medical.app.beans.admintasks;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class AdminTaskBean implements Serializable {
    public AdminTaskBean() {
    }


    public void FilterWaitingOres(ActionEvent actionEvent) {
        // Add event code here...

        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();

        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setActiveOre");
        Object result = activeOresOperation.execute();
        OperationBinding waitingOresOperation = bindingContainer.getOperationBinding("setWaitingOre");
        Object result2 = waitingOresOperation.execute();
        
    }
    
    public void FilterDiscountQuantity(ActionEvent actionEvent) {
        // Add event code here...

        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("filterDiscountQuantity");
        Object result = activeOresOperation.execute();
        
    }
    
    public void FilterAddQuantity(ActionEvent actionEvent) {
        // Add event code here...

        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("filterAddQuantity");
        Object result = activeOresOperation.execute();
        
    }
}
