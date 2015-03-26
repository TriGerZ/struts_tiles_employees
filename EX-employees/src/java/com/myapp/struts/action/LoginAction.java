package com.myapp.struts.action;

import com.myapp.model.Model;
import com.myapp.model.ModelException;
import com.myapp.struts.formbean.LoginForm;
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

public class LoginAction extends GenericAction {

    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String user = null;
        // Cible par defaut en cas de succes
        String target = "success";

        // Utilisation de LoginForm pour obtenir les parametres
        // de la requete
        String username = ((LoginForm) form).getUsername();
        String password = ((LoginForm) form).getPassword();

        try {
            Model m = getModel();
            user = m.getByLoginPassword(username, password);
        } catch (ModelException ex) {
            Logger.getLogger(LoginAction.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Cible en cas d'echec
        if (user == null) {

            target = "login";
            ActionMessages errors = new ActionMessages();

            errors.add(ActionMessages.GLOBAL_MESSAGE,
                    new ActionMessage("errors.login.unknown", username));

            // Enregistrer les erreurs  trouvees dans le formulaire original
            if (!errors.isEmpty()) {

                saveErrors(request, errors);
            }
        } else {

            HttpSession session = request.getSession();
            session.setAttribute("USER", user);
        }
        // Transmission de la requete a la vue appropriee
        return (mapping.findForward(target));
    }
}
