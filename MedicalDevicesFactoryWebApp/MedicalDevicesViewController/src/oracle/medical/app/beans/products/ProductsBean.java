package oracle.medical.app.beans.products;

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

import oracle.binding.AttributeBinding;
import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.domain.BlobDomain;
import oracle.jbo.domain.Number;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class ProductsBean implements Serializable {
    private RichPopup savedIcon;
    private RichPopup updateproductpopup;
    private UploadedFile myFile;

    public ProductsBean() {
    }

    public String saveNewProduct() {
        // Add event code here...
        uploadingFile();
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();

        OperationBinding setActiveProducts = bindingContainer.getOperationBinding("setActiveProducts");
        Object activeProductsResult = setActiveProducts.execute();

        OperationBinding setWaitingProducts = bindingContainer.getOperationBinding("setWaitingProducts");
        Object waitingProductsResult = setWaitingProducts.execute();

        RichPopup.PopupHints hint = new RichPopup.PopupHints();
        savedIcon.show(hint);
        return null;
    }

    public void setSavedIcon(RichPopup savedIcon) {
        this.savedIcon = savedIcon;
    }

    public RichPopup getSavedIcon() {
        return savedIcon;
    }

    public String cancelSavedMessage() {
        // Add event code here...
        savedIcon.cancel();
        return null;
    }

    public String returnProductHome() {
        // Add event code here...
        return null;
    }

    public void setUpdateproductpopup(RichPopup updateproductpopup) {
        this.updateproductpopup = updateproductpopup;
    }

    public RichPopup getUpdateproductpopup() {
        return updateproductpopup;
    }

    public String cancelupdateproductpopup() {
        // Add event code here...
        updateproductpopup.cancel();
        return null;
    }

    public String saveupdatedproduct() {
        // Add event code here...


        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding productIdAttribute = (AttributeBinding) bindingContainer.get("ProductId");
        Number productId = (Number) productIdAttribute.getInputValue();
        AttributeBinding productStatusAttribute = (AttributeBinding) bindingContainer.get("Active");
        String productStatus = (String) productStatusAttribute.getInputValue();
        if (productStatus.equals("N")) {

            OperationBinding deleteProductRequests = bindingContainer.getOperationBinding("deleteRequests");
            deleteProductRequests.getParamsMap().put("productId", productId);
            Object deleteProductRequestsResult = deleteProductRequests.execute();
        }

        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();

        OperationBinding setActiveProducts = bindingContainer.getOperationBinding("setActiveProducts");
        Object activeProductsResult = setActiveProducts.execute();

        OperationBinding setWaitingProducts = bindingContainer.getOperationBinding("setWaitingProducts");
        Object waitingProductsResult = setWaitingProducts.execute();
        updateproductpopup.cancel();
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
                DCIteratorBinding commitDCBinding = (DCIteratorBinding) bindingContainer.get("NewProduct1Iterator");
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
}
