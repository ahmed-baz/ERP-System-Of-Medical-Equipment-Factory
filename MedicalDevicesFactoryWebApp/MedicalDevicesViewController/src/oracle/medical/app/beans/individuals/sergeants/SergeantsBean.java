package oracle.medical.app.beans.individuals.sergeants;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class SergeantsBean implements Serializable {
    private RichPopup savedIcon;
    private RichSelectOneChoice sergeantStatus;
    private RichPopup editablePopup;
    private RichPopup savedIconpopup;
    private UploadedFile myFile;

    public SergeantsBean() {
    }

    public void setSavedIcon(RichPopup savedIcon) {
        this.savedIcon = savedIcon;
    }

    public RichPopup getSavedIcon() {
        return savedIcon;
    }

    public String savedNewSergeant() {
        // Add event code here...
        uploadingFile();
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        savedIcon.show(hint);
        return null;
    }

    public String saveUpdatedSergeant() {
        // Add event code here...
        if (sergeantStatus.getValue().equals("Y")) {
            BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
            commitOperation.execute();
            editablePopup.cancel();
            RichPopup.PopupHints hint = new RichPopup.PopupHints();
            savedIconpopup.show(hint);
        } else if (sergeantStatus.getValue().equals("N")) {
            editablePopup.cancel();
            BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
            commitOperation.execute();
            OperationBinding filterSoldiers = bindingContainer.getOperationBinding("filterSergeants");
            filterSoldiers.execute();
            ControllerContext ccontext = ControllerContext.getInstance();
            String viewId = "Sergeant";
            ccontext.getCurrentViewPort().setViewId(viewId);
        } else {
            System.out.println("Step 3");
        }
        return null;
    }

    public void setSergeantStatus(RichSelectOneChoice sergeantStatus) {
        this.sergeantStatus = sergeantStatus;
    }

    public RichSelectOneChoice getSergeantStatus() {
        return sergeantStatus;
    }

    public void setEditablePopup(RichPopup editablePopup) {
        this.editablePopup = editablePopup;
    }

    public RichPopup getEditablePopup() {
        return editablePopup;
    }

    public String cancelEditablePopup() {
        // Add event code here...
        editablePopup.cancel();
        return null;
    }

    public void setSavedIconpopup(RichPopup savedIconpopup) {
        this.savedIconpopup = savedIconpopup;
    }

    public RichPopup getSavedIconpopup() {
        return savedIconpopup;
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
                DCIteratorBinding commitDCBinding = (DCIteratorBinding) bindingContainer.get("NewSergeant1Iterator");
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

}
