package com.myapp.struts.action;

import com.myapp.model.Model;
import com.myapp.model.ModelException;
import com.myapp.struts.formbean.EmployeForm;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddEmployeAction extends GenericAction {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        
        // Cible par defaut en cas de succes
        String target = "success";

        // teste l'identification de l'utilisateur ?
        HttpSession session = request.getSession();
        if (session.getAttribute("USER") == null) {

            // L'utilisateur n'est pas identifie
            target = "login";
            ActionMessages errors = new ActionMessages();

            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.login.required"));

            // Renvoyer les erreurs au formulaire originel
            if (!errors.isEmpty()) {

                saveErrors(request, errors);
            }
            // Transmission a la vue appropriee
            return (mapping.findForward(target));
        }

        if (isCancelled(request)) {
            // Annulation. Retour a la liste des employes
            return (mapping.findForward(target));
        }

        String username = null;
        String password = null;
        String name = null;
        String idRole = null;
        String phone = null;
        String email = null;
        String idDep = null;
        int req = 0;

        if (form != null) {

            EmployeForm employeForm = (EmployeForm) form;

            username = employeForm.getUsername();
            password = employeForm.getPassword();
            name = employeForm.getName();
            idRole = employeForm.getRoleid();
            phone = employeForm.getPhone();
            email = employeForm.getEmail();
            idDep = employeForm.getDepid();

            try {
                Model m = getModel();
                req = m.addEmploye(username, password, name, idRole, phone, email, idDep);
            } catch (ModelException ex) {
                Logger.getLogger(AddEmployeAction.class.getName()).log(Level.SEVERE, null, ex);
                req = 0;
            }

        }

        // Cible en cas d'échec
        if (req == 0) {

            System.err.println("Setting target to error");
            target = "error";
            ActionMessages errors = new ActionMessages();

            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.database.error", "Erreur"));

            // Signalement des erreurs eventuelles
            if (!errors.isEmpty()) {

                saveErrors(request, errors);
            }

        }
        // Transmission a la vue appropriee
        return (mapping.findForward(target));

    }
}
