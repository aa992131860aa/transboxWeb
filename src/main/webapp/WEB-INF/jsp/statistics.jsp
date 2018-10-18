<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">


    <title>otqc</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/tag.jsp" %>
    <!-- =============== VENDOR STYLES ===============-->
    <!-- FONT AWESOME-->
    <link rel="stylesheet" href="/resources/vendor/fontawesome/css/font-awesome.min.css">
    <!-- SIMPLE LINE ICONS-->
    <link rel="stylesheet" href="/resources/vendor/simple-line-icons/css/simple-line-icons.css">
    <!-- ANIMATE.CSS-->
    <link rel="stylesheet" href="/resources/vendor/animate.css/animate.min.css">
    <!-- WHIRL (spinners)-->
    <link rel="stylesheet" href="/resources/vendor/whirl/dist/whirl.css">

    <link rel="stylesheet" type="text/css" href="/resources/css/cityPicker.css">

    <!--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">-->
    <!-- =============== PAGE VENDOR STYLES ===============-->
    <!-- =============== BOOTSTRAP STYLES ===============-->

    <!-- CHARTIST-->
    <%--<link rel="stylesheet" href="/resources/vendor/chartist/dist/chartist.min.css">--%>
    <!-- SIMPLE LINE ICONS-->
    <link rel="stylesheet" href="/resources/vendor/simple-line-icons/css/simple-line-icons.css">


    <!-- =============== APP STYLES ===============-->
    <link rel="stylesheet" href="/resources/css/statistics.css">
    <style>
        html, body {
            width: 100%;
            margin: 0;
            padding: 0;
            overflow: auto;

        }

        label {

        }

        #nav_out_out {
            line-height: 30px;

            height: 400px;
            width: 80%;

            text-align: center;
            /*position: fixed;*/
            right: 0px;

            overflow: hidden;
            border-top: 0px solid #1b72e2;
        }

        #nav_out {
            line-height: 30px;

            height: 400px;
            width: 100%;

            text-align: center;

            overflow-x: hidden;
            overflow-y: auto;
        }

        #nav {
            line-height: 30px;
            height: 400px;
            width: 260px;

            text-align: center;

            right: 0px;

            overflow-x: hidden;
        }

        #section {
            width: 85%;
            float: left;
            text-align: center;

            margin: 0 auto;
        }

        #content {
            width: 70%;

            margin: 0 auto;
            text-align: center;
        }

        .panel panel-default {
            border-top: 2px solid #cfdbe2;
        }

        .form-control {
            border: 2px solid #cfdbe2;
        }

    </style>
</head>

<body>

<div class="all">


    <!-- Main section-->
    <section>
        <!-- Page content-->
        <div class="content-wrapper">


            <!-- END row-->
            <!-- START panel-->
            <div class="panel panel-default" style="position: relative">
                <div class="panel-heading"></div>
                <div class="panel-body">
                    <%--<form method="get" action="" class="form-horizontal">--%>
                    <form class="form-inline" role="form">


                        <div class="form-group col-sm-4 col-xs-4 col-md-4">
                            <label class="control-label">时间&nbsp;&nbsp;&nbsp;&nbsp;</label>

                            <input type='text' readonly class="form-control" id="startTime"
                                   placeholder="开始时间" style="width: 150px"/>

                            <input type="hidden" id="cookieUserName" value="${cookieUserName}"/>
                            &nbsp;&nbsp;&nbsp;&nbsp;

                            <input type='text' readonly class="form-control" style="width: 150px" id="endTime"
                                   placeholder="结束时间" maxlength="10"/>
                        </div>


                        <div class="form-group col-sm-2  col-xs-2 col-md-2">
                            <label class="form-label">器官&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>

                            <select role="menu" class="btn btn-default" id="organType">
                                <option class="">请选择器官
                                </option>

                                <c:forEach var="ot" items="${organType}">
                                <option class="">${ot}
                                    </c:forEach>

                                </option>
                            </select>


                        </div>


                        <div class="form-group col-sm-2  col-xs-2 col-md-2">
                            <label class="control-label">转运人&nbsp;&nbsp;</label>

                            <select role="menu" class="btn btn-default" id="transferPerson">
                                <option class="">请选择转运人
                                </option>

                                <c:forEach var="tp" items="${transferPerson}">
                                <option class="">${tp}
                                    </c:forEach>

                                </option>
                            </select>


                        </div>


                        <div class="form-group col-sm-3  col-xs-3 col-md-3">
                            <label class="control-label">来源地</label>
                            <input type="text" id="cityChoice" class="form-control" placeholder="请选择来源地">
                            <input type="hidden" id="province" value="">
                            <input type="hidden" id="city" value="">
                        </div>

                        <div class="form-group col-sm-1  col-xs-1 col-md-1">
                            <button class="btn btn-info" id="analysis">筛选分析</button>
                        </div>


                    </form>


                    <%--</form>--%>
                </div>
            </div>
            <!-- END panel-->


            <div class="row" style="">
                <div class="form-group" style="display: table;border: #01ede5 solid 0px">
                    <div class="col-md-10 col-xs-10 col-sm-10" style="display: table-cell;vertical-align: middle;;border: #233333 solid 0px">
                        <div class="panel panel-default">

                            <div class="panel-body">
                                <canvas id="temHum" height="100"></canvas>
                                <div id="region" style="height: 400px"></div>
                                <div id="transfer" style="height: 400px"></div>
                                <div id="organ" style="height: 400px"></div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-2 col-xs-2 col-sm-2">

                        <div class="panel panel-default col-md-11 col-xs-11 col-sm-11"  >
                            <div class="panel-heading">

                            </div>
                            <div class="panel-body">
                                <div>
                                    <div class="list-group">
                                        <!-- START list group item-->
                                        <div class="list-group-item">

                                            <div class="row row-table pv-lg">
                                                <div class="panel panel-default col-xs-12  text-center"
                                                     id="temperatureTemp">
                                                    <div class="sparkH"></div>
                                                    <label class="control-label text-center"
                                                           id="temperatureSpan">温湿度</label>
                                                    <div id="sparkTemperature"></div>
                                                    <div class="sparkH"></div>
                                                </div>

                                            </div>

                                        </div>
                                        <div class="list-group-item">

                                            <div class="row row-table pv-lg">
                                                <div class="panel panel-default col-xs-12  text-center"
                                                     id="regionTemp">
                                                    <div class="sparkH"></div>
                                                    <label class="control-label text-center"
                                                           id="regionSpan">区域</label>

                                                    <div id="sparkColumn"></div>
                                                    <div class="sparkH"></div>
                                                </div>

                                            </div>

                                        </div>
                                        <!-- END list group item-->
                                        <!-- START list group item-->
                                        <div class="list-group-item">

                                            <div class="row row-table pv-lg">
                                                <div class="panel panel-default col-xs-12 text-center"
                                                     id="userTemp">
                                                    <div class="sparkH"></div>
                                                    <label id="userSpan"
                                                           class="control-label text-center">转运人员</label>

                                                    <div id="sparkTransfer"></div>
                                                    <div class="sparkH"></div>
                                                </div>

                                            </div>

                                        </div>

                                        <div class="list-group-item">

                                            <div class="row row-table pv-lg">
                                                <div class="panel panel-default col-xs-12 text-center"
                                                     id="typeTemp">
                                                    <div class="sparkH"></div>
                                                    <label class="control-label text-center"
                                                           id="typeSpan">类型</label>
                                                    <div id="sparkPie" class="text-center"></div>
                                                    <div class="sparkH"></div>
                                                </div>

                                            </div>

                                        </div>


                                        <!-- END list group item-->
                                    </div>
                                </div>
                            </div>
                        </div>


                        <%--<div class="panel-footer clearfix">--%>
                        <%--</div>--%>
                    </div>
                </div>
            </div>
        </div>

    </section>


</div>
<!-- =============== VENDOR SCRIPTS ===============-->
<!-- MODERNIZR-->
<script src="/resources/vendor/modernizr/modernizr.custom.js"></script>
<!-- MATCHMEDIA POLYFILL-->
<script src="/resources/vendor/matchMedia/matchMedia.js"></script>
<!-- JQUERY-->
<script src="/resources/vendor/jquery/dist/jquery.js"></script>
<!-- BOOTSTRAP-->
<script src="/resources/vendor/bootstrap/dist/js/bootstrap.js"></script>
<!-- STORAGE API-->
<script src="/resources/vendor/jQuery-Storage-API/jquery.storageapi.js"></script>
<!-- JQUERY EASING-->
<script src="/resources/vendor/jquery.easing/js/jquery.easing.js"></script>
<!-- ANIMO-->
<script src="/resources/vendor/animo.js/animo.js"></script>
<!-- SLIMSCROLL-->
<script src="/resources/vendor/slimScroll/jquery.slimscroll.min.js"></script>
<!-- SCREENFULL-->
<script src="/resources/vendor/screenfull/dist/screenfull.js"></script>
<!-- LOCALIZE-->
<script src="/resources/vendor/jquery-localize-i18n/dist/jquery.localize.js"></script>

<!--日期选择-->
<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.js"></script>
<link href="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap-datepicker/1.7.1/locales/bootstrap-datepicker.zh-CN.min.js"></script>


<script src="https://cdn.bootcss.com/jquery-sparklines/2.1.2/jquery.sparkline.min.js"></script>

<!--chart 图表-->
<script src="https://cdn.bootcss.com/Chart.js/2.7.1/Chart.min.js"></script>

<!--选择城市-->
<script type="text/javascript" src="/resources/js/cityData.js"></script>
<script type="text/javascript" src="/resources/js/cityPicker.js"></script>


<!-- hight 图表 -->
<script src="https://cdn.bootcss.com/highcharts/6.0.5/highcharts.js"></script>

<script src="/resources/js/transbox.js" type="text/javascript"></script>

<script type="text/javascript">


    transbox.statistics.init({});

</script>
</body>

</html>