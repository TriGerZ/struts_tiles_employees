package com.myapp.struts.action;

import com.myapp.model.Model;
import com.myapp.model.ModelException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
import java.util.ArrayList;

public class EmployeListeAction extends GenericAction {

    @Override
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        // Default target to success
        String target = "success";

        // Teste si l'utilisateur est identifie
        HttpSession session = request.getSession();
        if (session.getAttribute("USER") == null) {

            // The user is not logged in
            target = "login";
            ActionMessages errors = new ActionMessages();

            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.login.required"));

        // Report any errors we have discovered back to
            // the original form
            if (!errors.isEmpty()) {

                saveErrors(request, errors);
            }

        }

        ArrayList employes = null;

        try {
            Model m = getModel();
            employes = m.getEmployes();
        } catch (ModelException ex) {
            target = "erreur";
            ActionMessages errors = new ActionMessages();

            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.database.error", "Erreur"));

            // Signalement des erreurs eventuelles
            if (!errors.isEmpty()) {

                saveErrors(request, errors);
            }
        }

        // Set the target to failure
        if (employes == null) {

            target = "login";
        } else {

            System.out.println("employes" + employes);
            request.setAttribute("employes", employes);
        }
        // Forward to the appropriate View
        return (mapping.findForward(target));
    }
}
