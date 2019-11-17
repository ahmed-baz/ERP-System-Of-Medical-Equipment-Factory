package oracle.medical.app.beans.regions;

import java.io.Serializable;

import oracle.adf.controller.TaskFlowId;

public class RegionBean implements Serializable {
    private String taskFlowId = "/WEB-INF/Task-Flows/MainHome-BTF.xml#MainHome-BTF";

    public RegionBean() {
    }

    public TaskFlowId getDynamicTaskFlowId() {
        return TaskFlowId.parse(taskFlowId);
    }

    public void setDynamicTaskFlowId(String taskFlowId) {
        this.taskFlowId = taskFlowId;
    }

    public String adminTasksBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Admin-Tasks/Admin-Tasks-BTF.xml#Admin-Tasks-BTF");
        return null;
    }

    public String mainHomeBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/MainHome-BTF.xml#MainHome-BTF");
        return null;
    }

    public String approvalsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Approvals/Approvals-BTF.xml#Approvals-BTF");
        return null;
    }

    public String faxesBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Faxes/Faxes-BTF.xml#Faxes-BTF");
        return null;
    }

    public String officeBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Office/Office-BTF.xml#Office-BTF");
        return null;
    }

    public String settingsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Settings/Settings-BTF.xml#Settings-BTF");
        return null;
    }

    public String storeBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Store/Store-BTF.xml#Store-BTF");
        return null;
    }

    public String uaerProfileBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Uaer-Profile/Uaer-Profile-BTF.xml#Uaer-Profile-BTF");
        return null;
    }

    public String oresBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Store/Ores-BTF.xml#Ores-BTF");
        return null;
    }


    public String waitingOresBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Store/Waiting-Ores-BTF.xml#Waiting-Ores-BTF");
        return null;
    }

    public String addRequestsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/StoreActions/Add-Requests-BTF.xml#Add-Requests-BTF");
        return null;
    }

    public String discountRequestsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/StoreActions/Discount-Requests-BTF.xml#Discount-Requests-BTF");
        return null;
    }

    public String reportBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Reports/Report-BTF.xml#Report-BTF");
        return null;
    }

    public String discountQuantityReportBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Reports/Discount-Quantity-Report-BTF.xml#Discount-Quantity-Report-BTF");
        return null;
    }

    public String addQuantityReportBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Reports/Add-Quantity-Report-BTF.xml#Add-Quantity-Report-BTF");
        return null;
    }

    public String productsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Products/Products-BTF.xml#Products-BTF");
        return null;
    }

    public String waitingProductsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Products/Waiting-Products-BTF.xml#Waiting-Products-BTF");
        return null;
    }

    public String officersBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Office/Officers-BTF.xml#Officers-BTF");
        return null;
    }

    public String sergeantsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Office/Sergeants-BTF.xml#Sergeants-BTF");
        return null;
    }

    public String solidersBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Office/Soliders-BTF.xml#Soliders-BTF");
        return null;
    }

    public String civilianBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Office/Workers-BTF.xml#Civilian-BTF");
        return null;
    }

    public String productsAddRequestsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Products/Products-Add-Requests-BTF.xml#Products-Add-Requests-BTF");
        return null;
    }

    public String productsDiscountRequestsBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Products/Products-Discount-Requests-BTF.xml#Products-Discount-Requests-BTF");
        return null;
    }

    public String productDiscountReportBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Products/Product-Discount-Report-BTF.xml#Product-Discount-Report-BTF");
        return null;
    }

    public String productAddReportBTF() {
        setDynamicTaskFlowId("/WEB-INF/Task-Flows/Products/Product-Add-Report-BTF.xml#Product-Add-Report-BTF");
        return null;
    }
}
