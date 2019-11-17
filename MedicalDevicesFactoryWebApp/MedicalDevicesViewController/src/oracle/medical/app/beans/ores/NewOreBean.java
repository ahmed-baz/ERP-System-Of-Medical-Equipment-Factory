package oracle.medical.app.beans.ores;

import javax.faces.event.ValueChangeEvent;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;


import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.adf.model.binding.DCIteratorBinding;

import oracle.binding.AttributeBinding;

import oracle.jbo.domain.BlobDomain;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class NewOreBean {
    private RichPopup savedIcon;
    private UploadedFile myFile;

    public NewOreBean() {
    }

    public void setSavedIcon(RichPopup savedIcon) {
        this.savedIcon = savedIcon;
    }

    public RichPopup getSavedIcon() {
        return savedIcon;
    }

    public String newOreFilter() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setActiveOre");
        Object result = activeOresOperation.execute();
        OperationBinding waitingOresOperation = bindingContainer.getOperationBinding("setWaitingOre");
        Object result2 = waitingOresOperation.execute();
        savedIcon.cancel();

        ControllerContext ccontext = ControllerContext.getInstance();

        String viewId = "Ores";
        ccontext.getCurrentViewPort().setViewId(viewId);
        return null;
    }

    public String SaveAction() {
        // Add event code here...
        uploadingFile();
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();

        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setActiveOre");
        Object result = activeOresOperation.execute();
        OperationBinding waitingOresOperation = bindingContainer.getOperationBinding("setWaitingOre");
        Object result2 = waitingOresOperation.execute();

        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        savedIcon.show(hint);

        return null;
    }

    public String cancelSuccessfulMessage() {
        savedIcon.cancel();
        return null;
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
                DCIteratorBinding commitDCBinding = (DCIteratorBinding) bindingContainer.get("AddNweOres1Iterator");
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
