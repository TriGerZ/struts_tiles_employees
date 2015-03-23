<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>


<html:html>
    <head>
        <%-- We rely on tiles-defs.xml to set the title --%>
        <title>Ex-Employees > <tiles:getAsString name="title"/></title>
        <html:base/>
    </head>
    <body>
        <table width="750" cellspacing="0" cellpadding="0" border="0">
            <tr>
                <td>
                    <!-- ============================================================ -->
                    <!-- Begin header -->
                    <tiles:insert attribute="header"/>
                    <!-- End header -->
                    <!-- ============================================================ -->
                </td>
            </tr>
            <tr>
                <td>
                    <br>
                    <table cellspacing="0" cellpadding="0" border="0" width="100%">
                        <tr valign="top">
                            <td width="35%">
                                <!-- ============================================================ -->
                                <!-- Begin leftMenu -->
                                <tiles:insert attribute="leftMenu"/>
                                <!-- End leftMenu -->
                                <!-- ============================================================ -->
                                <!-- ============================================================ -->
                            </td>
                            <td width="2%">&nbsp;</td>
                            <td width="63%">
                                <!-- ============================================================ -->
                                <!-- Begin content -->
                                <tiles:insert attribute="content"/>
                                <!-- End content -->
                                <!-- ============================================================ -->
                            </td>
                        </tr>
                    </table>
                    <br />
                </td>
            </tr>
            <tr>
                <td>
                    <!-- ============================================================ -->
                    <!-- Begin footer -->
                    <tiles:insert attribute="footer"/>
                    <!-- End footer -->
                    <!-- ============================================================ -->
                </td>
            </tr>
        </table>
    </body>
</html:html>
