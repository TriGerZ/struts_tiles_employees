<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<html>
  <head>
    <title><bean:message key="app.title" /></title>
  </head>

  <body>
    <table width="500"
      border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td>&nbsp;</td>
      </tr>
      <tr> 
        <td> 
          <div align="left">
            <img src="images/logo_paris1.png">
          </div>
        </td>
      </tr>
      <tr>
        <td>&nbsp;</td>
      </tr>
    </table>

    <html:errors />

    <html:form action="/Add"  > 
      <table width="500" border="0">
        <tr>
          <td><bean:message key="app.username" />:</td>
          <td><html:text property="username" /></td>
          <td><bean:message key="app.password" />:</td>
          <td><html:text property="password" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.name" />:</td>
          <td><html:text property="name" /></td>
          <td><bean:message key="app.phone" />:</td>
          <td><html:text property="phone" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.email" />:</td>
          <td><html:text property="email" /></td>
          <td><bean:message key="app.department" />:</td>
    <td>

      <html:select property="depid" size="1">
              <html:option value="1">
          <bean:message key="app.administration" />
        </html:option>
              <html:option value="2">
          <bean:message key="app.computer" />
        </html:option>
              <html:option value="3">
          <bean:message key="app.sales" />
        </html:option>
              <html:option value="4">
          <bean:message key="app.production" />
        </html:option>
            </html:select>
          
          </td>
        </tr>
        <tr>
          <td><bean:message key="app.role" />:</td>
    <td>

      <html:select property="roleid" size="1">
              <html:option value="1">
          <bean:message key="app.manager" />
        </html:option>
              <html:option value="2">
          <bean:message key="app.employe" />
        </html:option>
            </html:select>
          
          </td>
          <td colspan="2" align="center">
      <html:submit /><html:cancel /><html:reset />
    </td>
        </tr>
      </table>
    </html:form> 

  </body>
</html>
