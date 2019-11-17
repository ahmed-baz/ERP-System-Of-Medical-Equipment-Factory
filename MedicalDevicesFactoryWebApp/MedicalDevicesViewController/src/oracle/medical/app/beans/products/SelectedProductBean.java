package oracle.medical.app.beans.products;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import oracle.adf.controller.ControllerContext;
import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichPopup;

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class SelectedProductBean {
    private UploadedFile myFile;

    public void setDeleteProductpopup(RichPopup deleteProductpopup) {
        this.deleteProductpopup = deleteProductpopup;
    }

    public RichPopup getDeleteProductpopup() {
        return deleteProductpopup;
    }

    public void setUpdatedProductpopup(RichPopup updatedProductpopup) {
        this.updatedProductpopup = updatedProductpopup;
    }

    public RichPopup getUpdatedProductpopup() {
        return updatedProductpopup;
    }

    public void setSavedIcon(RichPopup savedIcon) {
        this.savedIcon = savedIcon;
    }

    public RichPopup getSavedIcon() {
        return savedIcon;
    }


    private RichPopup deleteProductpopup;
    private RichPopup updatedProductpopup;
    private RichPopup savedIcon;


    public String cancelUpdatepopup() {
        // Add event code here...
        updatedProductpopup.cancel();
        return null;
    }

    public String confirmDeleteActionBTN() {
        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding ProductIdAttribute = (AttributeBinding) bindingContainer.get("ProductId");
        Number ProductId = (Number) ProductIdAttribute.getInputValue();

        OperationBinding deleteChildOperation = bindingContainer.getOperationBinding("deleteChild");
        deleteChildOperation.getParamsMap().put("productId", ProductId);
        deleteChildOperation.execute();


        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();


        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();


        ControllerContext ccontext = ControllerContext.getInstance();
        String viewId = "Products";
        ccontext.getCurrentViewPort().setViewId(viewId);

        return null;
    }

    public String cancelDeleteMessage() {
        // Add event code here...
        deleteProductpopup.cancel();
        return null;
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
                DCIteratorBinding commitDCBinding = (DCIteratorBinding) bindingContainer.get("MainProducts1Iterator");
                commitDCBinding.getDataControl().commitTransaction();
                //this.refreshPage();

            } else {
                FacesMessage mesg =
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error !", "Error while uploading image file !");
                FacesContext.getCurrentInstance().addMessage(null, mesg);

            }
        }
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

    public String saveUpdatedProductBTN() {
        // Add event code here...
        uploadingFile();
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        updatedProductpopup.cancel();
        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        savedIcon.show(hint);
        return null;
    }
}
