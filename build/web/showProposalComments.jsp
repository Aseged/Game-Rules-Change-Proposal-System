<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : showProposalComments
    Created on : 28-Mar-2018, 00:38:38
    Author     : Aseged
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"
      xmlns:f="http://xmlns.jcp.org/jsf/core"
      xmlns:p="http://primefaces.org/ui">
    <h:head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <link rel="stylesheet" type="text/css" href="CSS/CSS.main.css"/>
        <title>IFAF Rules Change Proposals</title>
    </h:head>
    <h:body>
<div id="Header">
            
            <div id="headeContentHolder">
                <img src="img/HeaderImg.PNG" id="Headerimg" alt="Header Image"/>                
            </div>
        </div>
        <div id="Main">
            <div id="MainHeader">
                <h:form>
                    <input type="button" id="NewProposalButton" value="New Proposal" action="newProposal" Class="ControlPanelButtons"/>
                   <input type="button" id="UserControlButton" value="User Control" action="viewUsers" Class="ControlPanelButtons"/>
                </h:form>
            </div>
            <div id="Search">
                <h:form>
                    <input type="button" id="SearchButton" value="Go" action="proposalDetail" Class="confirmButtons"/>
                    <inputText id="SearchInput" value="Search"  Class="SearchInput"/>
                </h:form>
                
            </div><br></br>
        
            <sql:query var="result" dataSource="">
                SELECT * FROM proposals, comments WHERE proposals.id = comments.id
            </sql:query>
    
            <table border="1">
                <!-- column headers -->
                <tr>
                    <c:forEach var="columnName" items="${result.columnNames}">
                        <th><c:out value="${columnName}"/></th>
                    </c:forEach>
                </tr>
                <!-- column data -->
                <c:forEach var="row" items="${result.rowsByIndex}">
                    <tr>
                        <c:forEach var="column" items="${row}">
                            <td><c:out value="${column}"/></td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        
        
        
        
        
        
   </div>
   <div id="Footer"></div>
    </h:body>
</html>


