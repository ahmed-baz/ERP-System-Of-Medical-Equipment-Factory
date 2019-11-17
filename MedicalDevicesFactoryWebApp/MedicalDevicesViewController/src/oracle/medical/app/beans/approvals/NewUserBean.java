package oracle.medical.app.beans.approvals;

import java.io.IOException;

import javax.faces.event.ActionEvent;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

public class NewUserBean {
    public NewUserBean() {
    }


    public String encrypt(String value, int type) throws IOException {
        // type = 1 for encryption , 2 for decryption
        String result = null;
        if (type == 1) {
            result = new sun.misc.BASE64Encoder().encode(value.getBytes());
        } else {
            byte[] decode = new sun.misc.BASE64Decoder().decodeBuffer(value);
            result = new String(decode);
        }
        return result;
    }

    public void saveNewUser(ActionEvent actionEvent) {
        // Add event code here...
        String encryptPassword = null;
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding passwordAttribute = (AttributeBinding) bindingContainer.get("Password");
        String password = (String) passwordAttribute.getInputValue();
        System.out.println("password = " + password);

        try {
            encryptPassword = encrypt(password, 1);
        } catch (IOException e) {
        }
        passwordAttribute.setInputValue(encryptPassword);
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
    }
}
