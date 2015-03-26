package com.myapp.struts.action;

import com.myapp.model.Model;
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

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DeleteEmployeAction extends GenericAction {

    @Override
    public ActionForward execute(ActionMapping mapping,
            ActionForm form,
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {

        // Cible par defaut en cas de succ�s
        String target = "success";

        // Teste si l'utilisateur est identifie
        HttpSession session = request.getSession();
        if (session.getAttribute("USER") == null) {

            // L'utilisateur n'est pas identifie
            target = "login";
            ActionMessages errors = new ActionMessages();

            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.login.required"));

        // Signaler les erreurs eventuelles
            // au formulaire originel
            if (!errors.isEmpty()) {

                saveErrors(request, errors);
            }

        }

        try {
            String username = null;
            Model m = getModel();
            username = request.getParameter("username");
            m.deleteEmploye(username);
            
        } catch (Exception e) {

            target = "error";
            ActionMessages errors = new ActionMessages();

            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.database.error", "Erreur"));

            // Signaler les erreurs eventuelles
            if (!errors.isEmpty()) {

                saveErrors(request, errors);
            }
        }
        // Transmission a la vue appropriee
        return (mapping.findForward(target));
    }
}
