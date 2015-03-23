<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


<html:html>
    <head>
        <%-- We rely on tiles-defs.xml to set the title --%>
        <title>Ex-Employees > <tiles:getAsString name="title"/></title>
        <html:base/>
    </head>
    <body>
        <tiles:insert attribute="header"/>

        <tiles:insert attribute="content"/>

        <tiles:insert attribute="footer"/>
    </body>
</html:html>
