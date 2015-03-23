<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<html>
  <head>
    <title><bean:message key="app.title" /></title>
  </head>

  <body>
    <table width="500" border="0" cellspacing="0" cellpadding="0">
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

    <html:form action="Login.do" > 
      <table width="45%" border="0">
        <tr>
          <td><bean:message key="app.username" />:</td>
          <td><html:text property="username" /></td>
        </tr>
        <tr>
          <td><bean:message key="app.password" />:</td>
          <td><html:password property="password" /></td>
        </tr>
        <tr>
          <td colspan="2" align="center"><html:submit /></td>
        </tr>
      </table>
    </html:form> 

  </body>
</html>
