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
        <form method="POST" action="">
        <form:select path="group">
            <form:option value="-" label="--Пожалуйста выберите"/>
            <form:options items="${groupList}" itemValue="code" itemLabel="name"/>
        </form:select>
        <c:if test="${!empty groupList}">
            <table class="data">
                <c:forEach items="${groupList}" var="group">
                    <tr>
                        <td>${group}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </body>
</html>
