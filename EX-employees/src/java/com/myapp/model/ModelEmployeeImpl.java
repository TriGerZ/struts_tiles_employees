/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import com.myapp.struts.bean.Employe;
import com.myapp.struts.formbean.EmployeForm;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Sinthu
 */
public class ModelEmployeeImpl implements Model {

    private DataSource ds;

    public DataSource getDatasource() {
        return this.ds;
    }

    public void setDatasource(DataSource ds) {
        this.ds = ds;
    }

    private Connection getConnection() throws SQLException {
        return this.getDatasource().getConnection();
    }

    @Override
    public int addEmploye(String username, String password, String name, String roleId, String phone, String email, String depId) {
        Connection conn = null;
        Statement stmt = null;
        int ok = 0;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            ok = stmt.executeUpdate("INSERT INTO employes VALUES ('" + username + "', '" + password + "', '" + name + "', " + roleId + ", '" + phone + "', '" + email + "', " + depId + ")");

            if (ok == 1) {
                System.out.println("Ajout effectué !");
            } else {
                System.out.println("Ajout non effectué !");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployeeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ok;
    }

    @Override
    public int editEmploye(String username, String password, String name, String roleId, String phone, String email, String depId) {
        Connection conn = null;
        Statement stmt = null;
        int ok = 0;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            ok = stmt.executeUpdate("UPDATE employes SET password='" + password + "', roleid=" + roleId + ", name='" + name + "', phone='" + phone + "', email='" + email + "', depid=" + depId + " WHERE username='" + username + "'");

            if (ok == 1) {
                System.out.println("Modification effectué !");
            } else {

                System.out.println("Modification non effectué !");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployeeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ok;
    }

    @Override
    public int deleteEmploye(String username) {
        Connection conn = null;
        Statement stmt = null;
        int ok = 0;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            ok = stmt.executeUpdate("DELETE FROM employes WHERE username='" + username + "'");

            if (ok == 1) {
                System.out.println("Suppression effectué !");
            } else {

                System.out.println("Suppression non effectué !");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployeeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ok;
    }

    @Override
    public ArrayList getEmployes() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList employes = null;
        Employe employe;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employes emp"
                    + " INNER JOIN roles rol ON (emp.roleid=rol.roleid)"
                    + " INNER JOIN services ser ON (emp.depid=ser.depid)");

            employes = new ArrayList();
            while (rs.next()) {
                employe = new Employe();
                employe.setUsername(rs.getString("username"));
                employe.setName(rs.getString("name"));
                employe.setRolename(rs.getString("rolename"));
                employe.setPhone(rs.getString("phone"));
                employe.setEmail(rs.getString("email"));
                employe.setRoleid((Integer) (rs.getInt("roleid")));
                employe.setDepid((Integer) (rs.getInt("depid")));
                employe.setDepartment(rs.getString("depname"));
                employes.add(employe);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployeeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return employes;
    }

    public ActionForm buildEmployeForm(String username) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        EmployeForm form = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM employes WHERE username=\'" + username + "'");
            try {
                if (rs.next()) {
                    form = new EmployeForm();
                    form.setUsername(rs.getString("username"));
                    form.setPassword(rs.getString("password"));
                    form.setDepid(rs.getString("depid"));
                    form.setRoleid(rs.getString("roleid"));
                    String name = rs.getString("name");
                    form.setName(name);
                    form.setPhone(rs.getString("phone"));
                    form.setEmail(rs.getString("email"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ModelEmployeeImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ModelEmployeeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return form;
    }
}
