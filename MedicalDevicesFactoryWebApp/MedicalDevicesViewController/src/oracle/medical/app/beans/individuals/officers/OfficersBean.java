package oracle.medical.app.beans.individuals.officers;

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

public class OfficersBean implements Serializable {
    private RichPopup updatedOfficerpopup;
    private RichPopup savedIcon1;
    private RichSelectOneChoice officerStatus;
    private RichPopup savedIcon2;
    private UploadedFile myFile;

    public OfficersBean() {
    }

    public String cancelUpdatedOfficer() {
        // Add event code here...
        updatedOfficerpopup.cancel();
        return null;
    }

    public String saveUpdatedOfficer() {
        // Add event code here...
        if (officerStatus.getValue().equals("Y")) {
            BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
            commitOperation.execute();
            updatedOfficerpopup.cancel();
            RichPopup.PopupHints hint = new RichPopup.PopupHints();
            getSavedIcon1().show(hint);
        } else if (officerStatus.getValue().equals("N")) {
            updatedOfficerpopup.cancel();
            BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
            commitOperation.execute();
            OperationBinding filterSoldiers = bindingContainer.getOperationBinding("filterOfficers");
            filterSoldiers.execute();
            ControllerContext ccontext = ControllerContext.getInstance();
            String viewId = "Officers";
            ccontext.getCurrentViewPort().setViewId(viewId);
        } else {
            System.out.println("Step 3");
        }
        return null;
    }

    public void setUpdatedOfficerpopup(RichPopup updatedOfficerpopup) {
        this.updatedOfficerpopup = updatedOfficerpopup;
    }

    public RichPopup getUpdatedOfficerpopup() {
        return updatedOfficerpopup;
    }

    public void setSavedIcon1(RichPopup savedIcon1) {
        this.savedIcon1 = savedIcon1;
    }

    public RichPopup getSavedIcon1() {
        return savedIcon1;
    }

    public String savedNewOfficer() {
        // Add event code here...
        uploadingFile();
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        savedIcon2.show(hint);
        return null;
    }

    public void setOfficerStatus(RichSelectOneChoice officerStatus) {
        this.officerStatus = officerStatus;
    }

    public RichSelectOneChoice getOfficerStatus() {
        return officerStatus;
    }

    public void setSavedIcon2(RichPopup savedIcon2) {
        this.savedIcon2 = savedIcon2;
    }

    public RichPopup getSavedIcon2() {
        return savedIcon2;
    }

    public void setMyFile(UploadedFile myFile) {
        this.myFile = myFile;
    }

    public UploadedFile getMyFile() {
        return myFile;
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
                DCIteratorBinding commitDCBinding = (DCIteratorBinding) bindingContainer.get("NewOfficer1Iterator");
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

}
