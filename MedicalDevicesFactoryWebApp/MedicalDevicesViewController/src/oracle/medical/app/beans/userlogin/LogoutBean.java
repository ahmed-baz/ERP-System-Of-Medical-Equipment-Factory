package oracle.medical.app.beans.userlogin;

import java.io.IOException;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import weblogic.servlet.security.ServletAuthentication;


public class LogoutBean {
    public LogoutBean() {
    }


    public void onLogoutAction(ActionEvent actionEvent) {
        // Add event code here...
        // add Weblogic 12.1 Remote-Client Library
        FacesContext fctx = FacesContext.getCurrentInstance();

        ExternalContext ectx = fctx.getExternalContext();
        HttpSession session = (HttpSession) ectx.getSession(false);
        session.invalidate();
        HttpServletRequest request = (HttpServletRequest) ectx.getRequest();
        ServletAuthentication.logout(request);
        ServletAuthentication.invalidateAll(request);
        ServletAuthentication.killCookie(request);
        try {
            //  http://127.0.0.1:7101/MedicalDevicesViewController/faces/LoginPage
            // ectx.redirect("http://127.0.0.1:7101/CleaningCompany-CompanyViewController-context-root/faces/Login");
            ectx.redirect("http://127.0.0.1:7101/MedicalDevicesViewController/faces/LoginPage");
        } catch (IOException e) {
            e.printStackTrace();
        }
        fctx.responseComplete();
    }
}
