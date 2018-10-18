<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-CN">

<head>
    <%@include file="common/tag.jsp" %>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta charset="UTF-8"/>
    <title>report detail</title>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <%--<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <%--<script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>


    <!--分页-->
    <%--<link rel="stylesheet" type="text/css" href="/resources/js/page/bootstrap.min.css">--%>
    <link rel="stylesheet" type="text/css" href="/resources/js/page/bootstrap-pager.css">


</head>

<body>
<div class="all">
    <div>

        <table class="table table-bordered">
            <caption></caption>
            <thead>

            <tr>
                <th>转运单号</th>
                <th>器官段号</th>
                <th>器官类型</th>
                <th>转运人</th>
                <th>转运起始地</th>
                <th>转运目的地</th>
                <th>转运时间</th>
                <c:if test="${pageIndex==5}">
                    <c:if test="${index==1}">
                        <th>平均温度</th>
                    </c:if>
                    <c:if test="${index==2}">
                        <th>开箱次数</th>
                    </c:if>
                    <c:if test="${index==3}">
                        <th>碰撞次数</th>
                    </c:if>
                </c:if>

            </tr>
            </thead>
            <tbody>
            <c:forEach var="r" items="${reportDetails}">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.organSeg}</td>
                    <td>${r.organ}</td>
                    <td>${r.transferPerson}</td>
                    <td>${r.fromCity}</td>
                    <td>${r.toHospName}</td>
                    <td>${r.getTime}</td>
                    <c:if test="${pageIndex==5}">
                        <c:if test="${index==1}">
                            <th>${r.avgT}℃</th>
                        </c:if>
                        <c:if test="${index==2}">
                            <th>${r.open}次</th>
                        </c:if>
                        <c:if test="${index==3}">
                            <th>${r.collision}次</th>
                        </c:if>
                    </c:if>
                </tr>
            </c:forEach>
            </tbody>
        </table>


    </div>
    <div>
        <div style="float: left;margin-left: 2%;line-height: 80px">总共 ${total} 条记录,每页显示${pageSize}条记录</div>
        <div id="page-container-static-big" style="float: right;margin-right: 2%;"></div>
    </div>

    <div class="hidden">
        <input type="hidden" value="${startTime}" id="startTime">
        <input type="hidden" value="${endTime}" id="endTime">
        <input type="hidden" value="${organ}" id="organ">
        <input type="hidden" value="${hospitalId}" id="hospitalId">
        <input type="hidden" value="${page}" id="page">
        <input type="hidden" value="${pageSize}" id="pageSize">
        <input type="hidden" value="${total}" id="total">
        <input type="hidden" value="${province}" id="province">
        <input type="hidden" value="${pageIndex}" id="pageIndex">
        <input type="hidden" value="${index}" id="index">
        <input type="hidden" value="${flag}" id="flag">
        <input type="hidden" value="${method}" id="method">
        <input type="hidden" value="${trueName}" id="trueName">
        <input type="hidden" value="${boxNo}" id="boxNo">
    </div>
</div>

</body>
<%--<script  src="/resources/js/page/jquery-1.8.3.min.js"></script>--%>
<%--<script  src="/resources/js/page/bootstrap.min.js"></script>--%>
<script src="/resources/js/page/bootstrap-pager.js"></script>
<script type="text/javascript">

    $(document).ready(function () {

        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        var organ = $("#organ").val();
        var hospitalId = $("#hospitalId").val();
        var page = $("#page").val();
        var pageSize = $("#pageSize").val();
        var total = $("#total").val();
        var province = $("#province").val();
        var pageIndex = $("#pageIndex").val();
        var index = $("#index").val();
        var flag = $("#flag").val();
        var method = $("#method").val();
        var trueName = $("#trueName").val();
        var boxNo = $("#boxNo").val();

        //静态  大型图标样式
        $("#page-container-static-big").page({
            count: total,
            pageSize: pageSize,
            maxPage: 7,
            pageNum: (parseInt(page) + 1),
            theme: "normal"
        });


        $("#page-container-static-big").on("pageChanged", function (event, params) {
            console.log(params);

            $(this).data("page").refresh(params);

            if (pageIndex == 2) {

                $(window).attr('location', '/transboxWeb/report_detail/' + hospitalId + '/' + startTime + '/' + endTime + '/' + organ + '/' + (params.pageNum - 1) + '/page2');

            } else if (pageIndex == 3) {
                $(window).attr('location', '/transboxWeb/report_detail/' + hospitalId + '/' + startTime + '/' + endTime + '/' + province + '/' + total + '/' + (params.pageNum - 1) + '/page3');

            } else if (pageIndex == 4) {

            } else if (pageIndex == 5) {
                //url: '/transboxWeb/report_detail/' + param.hospitalId + '/' + param.startTime + '/' + param.endTime + '/' + param.color + '/' + param.index + '/0/page5',

                $(window).attr('location', '/transboxWeb/report_detail/' + hospitalId + '/' + startTime + '/' + endTime + '/' + flag + '/' + index + '/' + (params.pageNum - 1) + '/page5');

            } else if (pageIndex == 6) {

                $(window).attr('location', '/transboxWeb/report_detail/' + hospitalId + '/' + startTime + '/' + endTime + '/' + method + '/' + (params.pageNum - 1) + '/page6');

            }
            else if (pageIndex == 7) {
                $(window).attr('location', '/transboxWeb/report_detail/' + hospitalId + '/' + startTime + '/' + endTime + '/' + trueName + '/' + total + '/' + index + '/' + (params.pageNum - 1) + '/page7');

            }
            else if (pageIndex == 8) {

                $(window).attr('location', '/transboxWeb/report_detail/' + hospitalId + '/' + startTime + '/' + endTime + '/' + boxNo + '/' + (params.pageNum - 1) + '/page8');

            }


        })


    });
</script>
</html>
