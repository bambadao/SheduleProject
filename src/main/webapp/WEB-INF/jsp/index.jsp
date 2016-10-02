<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Расписание ЧГУ</title>
        <link rel="stylesheet" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="webjars/bootstrap-select/1.9.4/css/bootstrap-select.css">
        <link rel="stylesheet" type="text/css" href="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.css" />
    </head>

    <body>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap-select/1.9.4/js/bootstrap-select.js"></script>
        <script type="text/javascript" src="webjars/momentjs/2.15.0/min/moment.min.js"></script>
        <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
        <header>
            <p><h1>CHSU</h1></p>
        </header>
        <main>
        <div class="container">
            <ul class="nav nav-pills nav-justified">
                <li><a data-toggle="pill" href="#group">Расписание учебных групп</a></li>
                <li><a data-toggle="pill" href="#prepod">Расписание преподавателей</a></li>
            </ul>
            <br>
            <div class="tab-content">
                <div id="group" class="tab-pane fade in active">
                    <form class="form-inline" name="index" method="post">
                        <div class="form-group">
                            <select class="selectpicker form-control" name="group" id="selectGroup" data-live-search="true" title="Выберите группу ...">
                                <c:if test="${!empty groupList}">
                                    <c:forEach items="${groupList}" var="group">
                                        <option value ="${group}">${group}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="text" name="daterange" class="form-control" id="date">
                        </div>
                        <button type="submit" class="btn btn-default">Показать</button>
                    </form>
                </div>
                <div id="prepod" class="tab-pane fade">
                    <form class="form-inline" name="index" method="post">
                        <div class="form-group">
                            <select class="selectpicker form-control" name="prepod" id="selectGroup" data-live-search="true" title="Выберите преподавателя ...">
                                <c:if test="${!empty prepodList}">
                                    <c:forEach items="${prepodList}" var="prepod">
                                        <option value ="${prepod}">${prepod}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                        </div>
                        <div class="form-group">
                            <input type="text" name="daterange" class="form-control" id="date">
                        </div>
                        <button type="submit" class="btn btn-default">Показать</button>
                    </form>
                </div>
            </div>
            
        </div>
            <c:if test="${!empty raspMap}">
                <form class="form-inline">
                    <div class="dropdown form-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>                            
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="javascript: if(window.print) window.print()">Microsoft Excel</a></li>
                            <li><a href="index/get">Adobe PDF</a></li>
                        </ul>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-default">
                            <span class="glyphicon glyphicon-print" aria-hidden="true"></span>
                        </button>
                    </div>    
                </form>
                <div>
                <table class="table table-striped">
                    <c:forEach items="${raspMap}" var="rasps">
                    <tr>
                        <th>${rasps.key}</th>
                        <th>${rasps.value[0].DNed}</th>
                    </tr>
                    <c:forEach items="${rasps.value}" var="rasp">
                        <tr>
                            <td>${rasp.vrem}</td>
                            <td>${rasp.NDis}</td>
                            <td>${rasp.dol}</td>
                            <td>${rasp.aud}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
                </table>
                </div>
        </c:if>	
        </main>
    </body>
    <script type="text/javascript">
        $(function() {
            $('input[name="daterange"]').daterangepicker({
    "locale": {
        "format": "DD.MM.YYYY",
        "separator": " - ",
        "applyLabel": "Принять",
        "cancelLabel": "Отмена",
        "fromLabel": "From",
        "toLabel": "To",
        "customRangeLabel": "Custom",
        "weekLabel": "W",
        "daysOfWeek": [
            "Вс",
            "Пн",
            "Вт",
            "Ср",
            "Чт",
            "Пт",
            "Сб"
        ],
        "monthNames": [
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "August",
            "September",
            "October",
            "November",
            "December"
        ],
        "firstDay": 1
    }});
        });
    </script>
</html>
