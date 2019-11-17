package oracle.medical.app.beans.users;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.model.BindingContext;

import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class UserProfileBean implements Serializable {
    private String oldpassword = null;
    private String newpassword1 = null;
    private String newpassword2 = null;
    private RichOutputText invalidPassword;
    private RichOutputText shortPassword;
    private RichOutputText differentPassword;
    private RichPopup savedIcon;
    private RichInputText oldpasswordIText;
    private RichButton showBTN;
    private RichButton hideBTN;
    private RichInputText newPass1IText;
    private RichInputText newPass2IText;
    private UploadedFile myFile;
    private RichPopup newImagepopup;

    public UserProfileBean() {
    }


    public void setOldpassword(String oldpassword) {
        this.oldpassword = oldpassword;
    }

    public String getOldpassword() {
        return oldpassword;
    }

    public void setNewpassword1(String newpassword1) {
        this.newpassword1 = newpassword1;
    }

    public String getNewpassword1() {
        return newpassword1;
    }

    public void setNewpassword2(String newpassword2) {
        this.newpassword2 = newpassword2;
    }

    public String getNewpassword2() {
        return newpassword2;
    }

    public void setInvalidPassword(RichOutputText invalidPassword) {
        this.invalidPassword = invalidPassword;
    }

    public RichOutputText getInvalidPassword() {
        return invalidPassword;
    }

    public void setShortPassword(RichOutputText shortPassword) {
        this.shortPassword = shortPassword;
    }

    public RichOutputText getShortPassword() {
        return shortPassword;
    }

    public void setDifferentPassword(RichOutputText differentPassword) {
        this.differentPassword = differentPassword;
    }

    public RichOutputText getDifferentPassword() {
        return differentPassword;
    }

    public String changePasswordAction() {
        if (oldpassword != null && newpassword1 != null && newpassword2 != null) {

            BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
            AttributeBinding PasswordAttribute = (AttributeBinding) bindingContainer.get("Password");
            String userPassword = (String) PasswordAttribute.getInputValue();
            String userOldPassword = null;
            try {
                userOldPassword = encrypt(oldpassword, 1);
            } catch (IOException e) {
            }

            if (userPassword.equals(userOldPassword)) {
                if (newpassword1.equals(newpassword2)) {
                    if (newpassword1.length() >= 8) {
                        //changePassword
                        try {
                            PasswordAttribute.setInputValue(encrypt(newpassword1, 1));
                        } catch (IOException e) {
                        }
                        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
                        commitOperation.execute();
                        RichPopup.PopupHints hint = new RichPopup.PopupHints();
                        savedIcon.show(hint);
                        oldpasswordIText.setValue(null);
                        newPass1IText.setValue(null);
                        newPass2IText.setValue(null);

                    } else {

                        shortPassword.setVisible(true);
                        invalidPassword.setVisible(false);
                        differentPassword.setVisible(false);
                    }
                } else {
                    shortPassword.setVisible(false);
                    invalidPassword.setVisible(false);
                    differentPassword.setVisible(true);
                }

            } else {

                shortPassword.setVisible(false);
                invalidPassword.setVisible(true);
                differentPassword.setVisible(false);
            }


        }


        return null;
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

    public void setSavedIcon(RichPopup savedIcon) {
        this.savedIcon = savedIcon;
    }

    public RichPopup getSavedIcon() {
        return savedIcon;
    }

    public String showPassword() {
        // Add event code here...
        oldpasswordIText.setSecret(false);
        hideBTN.setVisible(true);
        showBTN.setVisible(false);
        return null;
    }

    public void setOldpasswordIText(RichInputText oldpasswordIText) {
        this.oldpasswordIText = oldpasswordIText;
    }

    public RichInputText getOldpasswordIText() {
        return oldpasswordIText;
    }

    public String hidePassword() {
        // Add event code here...
        oldpasswordIText.setSecret(true);
        hideBTN.setVisible(false);
        showBTN.setVisible(true);   
        return null;
    }

    public void setShowBTN(RichButton showBTN) {
        this.showBTN = showBTN;
    }

    public RichButton getShowBTN() {
        return showBTN;
    }

    public void setHideBTN(RichButton hideBTN) {
        this.hideBTN = hideBTN;
    }

    public RichButton getHideBTN() {
        return hideBTN;
    }

    public void setNewPass1IText(RichInputText newPass1IText) {
        this.newPass1IText = newPass1IText;
    }

    public RichInputText getNewPass1IText() {
        return newPass1IText;
    }

    public void setNewPass2IText(RichInputText newPass2IText) {
        this.newPass2IText = newPass2IText;
    }

    public RichInputText getNewPass2IText() {
        return newPass2IText;
    }

    public void setMyFile(UploadedFile myFile) {
        this.myFile = myFile;
    }

    public UploadedFile getMyFile() {
        return myFile;
    }
    
    
    private BlobDomain createBlobDomain(UploadedFile file) {

        InputStream in = null;
        BlobDomain blobDomain = null;
        OutputStream out = null;

        try {
            in = file.getInputStream();

            blobDomain = new BlobDomain();
            out = blobDomain.getBinaryOutputStream();
            byte[] buffer = new byte[8192];
            int bytesRead = 0;

            while ((bytesRead = in.read(buffer, 0, 8192)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.fillInStackTrace();
        }

        return blobDomain;
    }
    
    public String uploadingFile() {
        if (myFile != null) {

            if (myFile.getFilename().toUpperCase().endsWith(".JPG") ||
                myFile.getFilename().toUpperCase().endsWith(".PNG")) {

                //Access Attribute for update
                BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
                AttributeBinding attributeName = (AttributeBinding) bindingContainer.get("Image");
                attributeName.setInputValue(createBlobDomain(myFile));
                // Access Iterator Binding for Commit
                // BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
                DCIteratorBinding commitDCBinding = (DCIteratorBinding) bindingContainer.get("UserProfile1Iterator");
                commitDCBinding.getDataControl().commitTransaction();
                //this.refreshPage();

            } else {
                FacesMessage mesg =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !", "Error while uploading image file !");
                FacesContext.getCurrentInstance().addMessage(null, mesg);

            }
        }
        return null;
    }

    public String uploadNewImage() {
        // Add event code here...
        uploadingFile();
        refreshPage();
        newImagepopup.cancel();
        return null;
    }

    public String cancelNewImagepopup() {
        // Add event code here...
        newImagepopup.cancel();
        return null;
    }

    public void setNewImagepopup(RichPopup newImagepopup) {
        this.newImagepopup = newImagepopup;
    }

    public RichPopup getNewImagepopup() {
        return newImagepopup;
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
