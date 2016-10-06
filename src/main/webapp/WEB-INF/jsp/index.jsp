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
        <link rel="stylesheet" href="css/datepicker.min.css">
        <link rel="stylesheet" href="css/style.css"
    </head>

    <body>
        <script type="text/javascript" src="webjars/jquery/3.1.0/jquery.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="webjars/bootstrap-select/1.9.4/js/bootstrap-select.js"></script>
        <script type="text/javascript" src="webjars/momentjs/2.15.0/min/moment.min.js"></script>
        <script type="text/javascript" src="//cdn.jsdelivr.net/bootstrap.daterangepicker/2/daterangepicker.js"></script>
        <script src="js/datepicker.min.js" type="text/javascript" ></script>
        <header>
            <div class="container">
                <a href="index" class="logo" title="Расписание занятий ЧГУ"> 
                    <img src="img/logo.png" alt="ЧГУ" width="160" height="48">
                </a> 
                <h2 class="text-center">Расписание занятий</h2>
            </div>
        </header>
        <main>
          <div class="container">
            <div class="row">
            <ul class="nav nav-pills nav-justified">
                <li><a data-toggle="pill" href="#group">Расписание учебных групп</a></li>
                <li><a data-toggle="pill" href="#prepod">Расписание преподавателей</a></li>
            </ul>
            <div class="tab-content">
              <div id="group" class="tab-pane fade in active" style="margin-top: 10px">
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
                        <div class="form-group inner-addon right-addon">
                            <i class="glyphicon glyphicon-calendar"></i>
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
                        <div class="form-group inner-addon right-addon">
                            <i class="glyphicon glyphicon-calendar"></i>
                            <input type="text" name="daterange" class="datepicker-here form-control" id="date">
                        </div>
                        <button type="submit" class="btn btn-default">Показать</button>
                    </form>
                </div>
            </div>
          </div> 
        </div>
        <div class="container">
            <div class="row">
            <article class="col-lg-12">
            <c:if test="${!empty raspMap}">
                <form class="form-inline">
                    <div class="dropdown form-group">
                        <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                            <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>                            
                        </button>
                        <ul class="dropdown-menu">
                            <li><a href="#">Microsoft Excel</a></li>
                            <li><a href="index/get?${raspMap}" target="_blank">Adobe PDF</a></li>
                        </ul>
                    </div>
                    <div class="form-group">
                        <button type="button" class="btn btn-default" onClick="window.print()">
                            <span class="glyphicon glyphicon-print" aria-hidden="true"></span>
                        </button>
                    </div>    
                </form>
            </div>
                        <div class="clearfix"></div>
            <div class="row">
                <div>
                <table class="table table-striped">
                    <c:forEach items="${raspMap}" var="rasps">
                    <tr>
                        <th>${rasps.key}</th>
                        <th>${rasps.value[0].DNed}</th>
                    </tr>
                    <c:forEach items="${rasps.value}" var="rasp">
                        <tr>
                          <td width="20%">${rasp.vrem}</td>
                          <td width="40%">${rasp.NDis}</td>
                            <td width="20">${rasp.dol}</td>
                            <td width="20%">${rasp.aud}</td>
                        </tr>
                    </c:forEach>
                </c:forEach>
                </table>
                </div>
            </c:if>
            </article>
            </div>
        </div>
        </main>
        <footer>
            <div class="container navbar navbar-inner  navbar-fixed-bottom">
                <p>
                    &copy; Череповецкий государственный университет,
                    <a href="http://www.chsu.ru/">www.chsu.ru</a>
                </p>
                <p>
                    О любых ошибках и неточностях в расписании сообщайте, пожалуйста, по адресу <a href="mailto:main@chsu.ru">main@chsu.ru</a>
                </p>
            </div>
        </footer>
    </body>
<script type="text/javascript">
    $(function() {
            $('input[name="daterange"]').datepicker({
                range: true,
                toggleSelected: false,
                multipleDatesSeparator: " - ",
                autoClose: true
            });
        });
</script>

</html>
