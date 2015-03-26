/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.model;

import java.util.ArrayList;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author Sinthu
 */
public interface Model {

    public ArrayList getEmployes() throws ModelException;

    public int addEmploye(String username, String password, String name, String idRole, String phone, String email, String idDep) throws ModelException;

    public int editEmploye(String username, String password, String name, String idRole, String phone, String email, String idDep) throws ModelException;

    public int deleteEmploye(String username) throws ModelException;

    public ActionForm buildEmployeForm(String username) throws ModelException;

}
