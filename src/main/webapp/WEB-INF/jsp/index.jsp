<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <c:if test="${!empty rasps}">
            <table class="data">
                <tr>
                    <th></th>
                </tr>
                <c:forEach items="${rasps}" var="rasp">
                    <tr>
                        <td>${rasp.grp}</td>
                        <td>${rasp.aud}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
