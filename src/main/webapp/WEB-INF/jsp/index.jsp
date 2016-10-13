<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
      <div class="container-fluid hidden-xs hidden-print" style="background: #a1a1a1; margin-top: -10px; margin-left: -10px; margin-right: -10px; margin-bottom: 10px; padding-bottom: 10px;">
        <div class="row">
          <div class="col-lg-2 col-lg-offset-1" style="background: white">
            <a href="index" class="logo" title="Расписание занятий ЧГУ">
              <!--<img src="img/logo.png" alt="ЧГУ" width="160" height="48"></a>-->
              <img src="img/logo1.png" alt="ЧГУ" width="210" height="60"></a>
          </div>
          <div class="col-lg-8" style="background: red;">
            <h2 class="text-left" style="text-align: justify"><font color="white">Расписание занятий</font></h2>
          </div>
        </div>
      </div>
    </header>
    <main>
      <div class="container">
        <!-- Start name pills -->    
        <div class="row hidden-print" style="margin-bottom: 10px; padding-bottom: 10px;">
          <div class="col-lg-12">
            <ul class="nav nav-pills nav-justified">
              <li class="active"><a data-toggle="pill" href="#group">Расписание учебных групп</a></li>
              <li><a data-toggle="pill" href="#prepod">Расписание преподавателей</a></li>
            </ul>
          </div>
        </div>
        <!-- End name pills -->
        <!-- Start panels pills -->
        <div class="row hidden-print" style="margin-bottom: 10px; padding-bottom: 10px;">
            <div class="col-lg-6 col-xs-10 col-lg-offset-3">
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
                            <div class="form-group inner-addon right-addon">
                                <i class="glyphicon glyphicon-calendar"></i>
                                <input type="text" name="daterange" class="form-control" id="date" title="Выберите дату ...">
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
        <!-- End panels pills -->
        <div class="row" style="margin-bottom: 10px; padding-bottom: 10px;">
            <div class="col-lg-8 col-lg-offset-2">
                <c:if test="${!empty groupMap}">
                    <!-- Start group print/export buttons -->
                    <div class="row" style="margin-bottom: 10px; padding-bottom: 10px; background: #cccccc;">
                        <div class="col-lg-10 text-center">
                          <p><h3>Расписание группы ${group}</h3></p>
                          <p>${daterange}</p>
                        </div>
                      <div class="col-lg-2 hidden-sm-down hidden-print" style="vertical-align: middle;">
                            <form class="form-inline">
                                <div class="dropdown form-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>                            
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Microsoft Excel</a></li>
                                        <li><a href="index/getPDF?group=${group}&daterange=${daterange}" target="_blank">Adobe PDF</a></li>
                                    </ul>
                                </div>
                                <div class="form-group">
                                    <button type="button" class="btn btn-default" onClick="window.print()">
                                        <span class="glyphicon glyphicon-print" aria-hidden="true"></span>
                                    </button>
                                </div>    
                            </form>
                        </div>
                    </div>
                    <!-- End group print/export buttons -->
                    <!-- Start group rasp panels -->
                    <div class="row" style="margin-bottom: 10px; padding-bottom: 10px;">
                        <c:forEach items="${groupMap}" var="groups">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                  <h3 class="panel-title text-center">${groups.key} ${groups.value[0].DNed}</h3>
                                </div>
                                <table class="table table-striped">
                                    <tr>
                                        <th width="20%">Время</th>
                                        <th width="40%">Дисциплина</th>
                                        <th width="20%">Преподаватель</th>
                                        <th class="text-center" width="20%">Аудитория</th>
                                    </tr>
                                    <c:forEach items="${groups.value}" var="group">
                                        <tr>
                                            <td width="20%">${group.vrem}</td>
                                            <td width="40%">${group.NDis}</td>
                                            <td width="20">${group.dol}</td>
                                            <td class="text-center" width="20%">${group.aud}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- End group rasp panels -->
                </c:if>
                <c:if test="${!empty prepodMap}">
                    <!-- Start print/export buttons -->
                    <div class="row" style="margin-bottom: 10px; padding-bottom: 10px;">
                        <div class="col-lg-10 text-center">
                          <p><h3>Расписание преподавателя ${prepod}</h3></p>
                          <p>${daterange}</p>
                        </div>
                        <div class="col-lg-2 hidden-sm-down hidden-print">
                            <form class="form-inline">
                                <div class="dropdown form-group">
                                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                        <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>                            
                                    </button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">Microsoft Excel</a></li>
                                        <li><a href="index/getPDF?${prepodMap}" target="_blank">Adobe PDF</a></li>
                                    </ul>
                                </div>
                                <div class="form-group">
                                    <button type="button" class="btn btn-default" onClick="window.print()">
                                        <span class="glyphicon glyphicon-print" aria-hidden="true"></span>
                                    </button>
                                </div>    
                            </form>
                        </div>
                    </div>
                    <!-- End print/export buttons -->
                    <!-- Start prepod rasp panels -->
                    <div class="row" style="margin-bottom: 10px; padding-bottom: 10px;">
                        <c:forEach items="${prepodMap}" var="prepods">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                  <h3 class="panel-title text-center">${prepods.key} ${prepods.value[0].DNed}</h3>
                                </div>
                                <table class="table table-striped">
                                    <tr>
                                        <th width="20%">Время</th>
                                        <th width="40%">Дисциплина</th>
                                        <th width="20%">Группа</th>
                                        <th class="text-center" width="20%">Аудитория</th>
                                    </tr>
                                    <c:forEach items="${prepods.value}" var="prepod">
                                        <tr>
                                            <td width="20%">${prepod.vrem}</td>
                                            <td width="40%">${prepod.NDis}</td>
                                            <td width="20">${prepod.grp}</td>
                                            <td class="text-center" width="20%">${prepod.aud}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                            </div>
                        </c:forEach>
                    </div>
                    <!-- End prepod rasp panels -->
                </c:if>
            </div>
        </div>
      </div>
    </main>
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
</body>
</html>
