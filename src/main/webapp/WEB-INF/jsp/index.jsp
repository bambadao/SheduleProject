<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Расписание</title>
        <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="webjars/bootstrap-select/1.9.4/css/bootstrap-select.css">
    </head>

    <body>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap-select/1.9.4/js/bootstrap-select.js"></script>
        <div class="container">
            <ul class="nav nav-pills nav-justified">
                <li><a data-toggle="pill" href="#group">Расписание учебных групп</a></li>
                <li><a data-toggle="pill" href="#prepod">Расписание преподавателей</a></li>
            </ul>
            <br>
            <div class="tab-content">
                <div id="group" class="tab-pane fade in active">
                    <form class="form-inline">
                        <div class="form-group">
                            <select class="selectpicker form-control" id="selectGroup" data-live-search="true" title="Выберите группу ...">
                                <c:if test="${!empty groupList}">
                                    <c:forEach items="${groupList}" var="group">
                                        <option value ="${group}">${group}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="datetime" class="form-control" id="date">
                        </div>
                        <button type="submit" class="btn btn-default">Показать</button>
                    </form>
                </div>
                <div id="prepod" class="tab-pane fade">
                    <form class="form-inline">
                        <div class="form-group">
                            <select class="selectpicker form-control" id="selectGroup" data-live-search="true" title="Выберите преподавателя ...">
                                <c:if test="${!empty prepodList}">
                                    <c:forEach items="${prepodList}" var="prepod">
                                        <option value ="${prepod}">${prepod}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="datetime" class="form-control" id="date">
                        </div>
                        <button type="submit" class="btn btn-default">Показать</button>
                    </form>
                </div>
            </div>
        </div>
        
    </body>
</html>
