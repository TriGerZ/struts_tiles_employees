/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts.action;
import org.apache.struts.action.Action;
import com.myapp.model.Model;

/**
 *
 * @author Sinthu
 */
public class GenericAction extends Action {
    
    private Model model=null;
    
  public void setModel (Model m) {
      this.model=m;
  }
  
  public Model getModel () {
     return  this.model;
     
  }
    
}
