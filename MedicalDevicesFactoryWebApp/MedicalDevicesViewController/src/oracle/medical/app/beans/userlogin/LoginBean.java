package oracle.medical.app.beans.userlogin;

import java.io.Serializable;

import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;

import oracle.adf.share.ADFContext;

import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.medical.app.model.classes.Users;

public class LoginBean implements Serializable {
    Users user = null;
    private String userName = null;
    private String password = null;
    private RichOutputText invalidUserText;
    private RichOutputText emptyText;

    public LoginBean() {
    }

    public String CheckLogin() {
        if (userName != null && password != null) {

            BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding loginOperation = bindingContainer.getOperationBinding("checkLogin");

            loginOperation.getParamsMap().put("email", userName);
            loginOperation.getParamsMap().put("password", password);

            Boolean checkLogin = (Boolean) loginOperation.execute();


            if (loginOperation.getErrors().isEmpty())
                if (checkLogin == true) {
                    user = (Users) ADFContext.getCurrent().getSessionScope().get("USER");
                    System.out.println("User Data on Session Bean : User Name = " + user.getUserName());
                    invalidUserText.setVisible(false);
                    emptyText.setVisible(false);
                    return "Home-BTF";
                } else {

                    invalidUserText.setVisible(true);
                    emptyText.setVisible(false);
                }
        } else {

            emptyText.setVisible(true);
            invalidUserText.setVisible(false);
        }
        return null;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setInvalidUserText(RichOutputText invalidUserText) {
        this.invalidUserText = invalidUserText;
    }

    public RichOutputText getInvalidUserText() {
        return invalidUserText;
    }

    public void setEmptyText(RichOutputText emptyText) {
        this.emptyText = emptyText;
    }

    public RichOutputText getEmptyText() {
        return emptyText;
    }

}
