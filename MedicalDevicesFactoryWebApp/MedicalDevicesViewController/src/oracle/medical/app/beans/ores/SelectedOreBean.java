package oracle.medical.app.beans.ores;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

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

public class SelectedOreBean {
    private RichPopup updatedOre;
    private RichPopup deleteMessage;
    private UploadedFile myFile;

    public SelectedOreBean() {
    }

    public String saveUpdatedOre() {
        // Add event code here...
        uploadingFile();
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();
        /* 
        OperationBinding activeOresOperation = bindingContainer.getOperationBinding("setActiveOre");
        Object result = activeOresOperation.execute();
        OperationBinding waitingOresOperation = bindingContainer.getOperationBinding("setWaitingOre");
        Object result2 = waitingOresOperation.execute(); */
        updatedOre.cancel();
        ControllerContext ccontext = ControllerContext.getInstance();
        String viewId = "Ores";
        //ccontext.getCurrentViewPort().setViewId(viewId);

        return null;
    }


    public void setUpdatedOre(RichPopup updatedOre) {
        this.updatedOre = updatedOre;
    }

    public RichPopup getUpdatedOre() {
        return updatedOre;
    }


    private void refreshPage() {

        FacesContext fctx = FacesContext.getCurrentInstance();
        String refreshpage = fctx.getViewRoot().getViewId();
        ViewHandler ViewH = fctx.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fctx, refreshpage);
        UIV.setViewId(refreshpage);
        fctx.setViewRoot(UIV);

    }

    public String cancelDeleteMessage() {
        // Add event code here...
        deleteMessage.cancel();
        return null;
    }

    public void setDeleteMessage(RichPopup deleteMessage) {
        this.deleteMessage = deleteMessage;
    }

    public RichPopup getDeleteMessage() {
        return deleteMessage;
    }

    public String confirmDeleteActionBTN() {

        // Add event code here...
        BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
        AttributeBinding oreAttribute = (AttributeBinding) bindingContainer.get("OreId");
        Number oreId = (Number) oreAttribute.getInputValue();
        System.out.println("Ore Id " + oreId);

        OperationBinding deleteChildOperation = bindingContainer.getOperationBinding("deleteChild");
        deleteChildOperation.getParamsMap().put("oreId", oreId);
        deleteChildOperation.execute();


        DCIteratorBinding DiscountOreDCBinding = (DCIteratorBinding) bindingContainer.get("OresDiscount1Iterator");
        DiscountOreDCBinding.getDataControl().commitTransaction();


        OperationBinding deleteOperation = bindingContainer.getOperationBinding("Delete");
        deleteOperation.execute();

        DCIteratorBinding mainOreDCBinding = (DCIteratorBinding) bindingContainer.get("MainOres1Iterator");
        mainOreDCBinding.getDataControl().commitTransaction();


        OperationBinding commitOperation = bindingContainer.getOperationBinding("Commit");
        commitOperation.execute();


        ControllerContext ccontext = ControllerContext.getInstance();
        String viewId = "Ores";
        ccontext.getCurrentViewPort().setViewId(viewId);


        return null;
    }

    public String cancelUpdatepopup() {
        // Add event code here...
        updatedOre.cancel();
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
    


    public String uploadingFile() {
        if (myFile != null) {

            if (myFile.getFilename().toUpperCase().endsWith(".JPG") ||
                myFile.getFilename().toUpperCase().endsWith(".PNG")) {

                //Access Attribute for update
                BindingContainer bindingContainer = BindingContext.getCurrent().getCurrentBindingsEntry();
                AttributeBinding attributeName = (AttributeBinding) bindingContainer.get("Image");
                attributeName.setInputValue(createBlobDomain(myFile));
                // Access Iterator Binding for Commit
                DCIteratorBinding commitDCBinding = (DCIteratorBinding) bindingContainer.get("MainOres1Iterator");
                commitDCBinding.getDataControl().commitTransaction();
                this.refreshPage();

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
}
