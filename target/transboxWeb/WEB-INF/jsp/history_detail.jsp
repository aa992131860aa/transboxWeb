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

    <link rel="stylesheet" href="/resources/css/history.css">
    <link rel="stylesheet" href="/resources/css/blue.css">
    <script src="/resources/js/icheck.js"></script>
</head>

<body>
<div class="all">

    <div class="head">
        <div class="form-group">
            <div class="col-sm-2">
                <button class="btn btn-primary" type="button">箱子编号</button>
            </div>
            <c:if test="${cookieUserName=='admin'}">
                <div class="col-sm-2">
                    <button class="btn btn-primary" type="button">医院名称</button>
                </div>
            </c:if>

            <%--<div class="col-sm-2">--%>
                <%--<button class="btn btn-primary" type="button">转运时间</button>--%>
            <%--</div>--%>

            <div class="col-sm-2">
                <button class="btn btn-primary" type="button">未隐藏数据</button>
            </div>

            <div class="col-sm-2">
                <button class="btn btn-primary" type="button">合并操作</button>
            </div>

        </div>
    </div>

</div>
<div class="content" style="width: 95%;">

    <table class="table table-bordered">
        <caption></caption>
        <thead>

        <tr>
            <th width="20">

                <%--<input type="checkbox">--%>

            </th>
            <th>转运单号</th>
            <th>箱号</th>
            <th>器官段号</th>
            <th>器官类型</th>
            <th>转运人</th>
            <th>转运起始地</th>
            <th>转运目的地</th>
            <th>转运时间</th>
            <th>最大温度</th>
            <th>最小温度</th>
            <th>平均温度</th>
            <th>实际持续时间</th>
            <th>已处理持续时间</th>
            <th>开箱</th>
            <th>碰撞</th>
            <th>运行距离</th>
            <th>医院名称</th>
            <th>标识</th>


        </tr>
        </thead>
        <tbody>
        <c:forEach items="${transferInfoList}" var="t">
        <tr onclick="transbox.trClick({'id':2})">
            <td width="20"><input id="i2" type="checkbox"></td>
            <th>${t.id}</th>
            <th>${t.boxNo}</th>
            <th>${t.organSeg}</th>
            <th>${t.organ}</th>
            <th>${t.transferPerson}</th>
            <th>${t.fromCity}</th>
            <th>${t.toHospName}</th>
            <th>${t.getTime}</th>
            <th>${t.maxAvg}</th>
            <th>${t.minAvg}</th>
            <th>${t.avgT}</th>
            <th>${t.trueDurationTime}</th>
            <th>${t.trueDurationTime}</th>
            <th>${t.open}</th>
            <th>${t.collision}</th>
            <th>${t.distance}</th>
            <th>${t.hospital}</th>
            <th>${t.filterStatus}</th>
        </tr>
        </c:forEach>
        </tbody>
    </table>


</div>
<div>
    <div style="float: left;margin-left: 2%;line-height: 80px">总共 ${total} 条记录,每页显示${pageSize}条记录</div>
    <div id="page-container-static-big" style="float: right;margin-right: 2%;"></div>
</div>


</div>

</body>
<%--<script  src="/resources/js/page/jquery-1.8.3.min.js"></script>--%>
<%--<script  src="/resources/js/page/bootstrap.min.js"></script>--%>
<script src="/resources/js/page/bootstrap-pager.js"></script>
<script src="/resources/js/transbox.js"></script>
<script type="text/javascript">

    var param = {
        id:'1'
    };
    transbox.history.init(param)

    $(document).ready(function () {

        // tr 点击事件

        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%'
        });


        //静态  大型图标样式
        // $("#page-container-static-big").page({
        //     count: total,
        //     pageSize: pageSize,
        //     maxPage: 7,
        //     pageNum: (parseInt(page) + 1),
        //     theme: "normal"
        // });
        //
        //
        // $("#page-container-static-big").on("pageChanged", function (event, params) {
        //     console.log(params);
        //
        //     $(this).data("page").refresh(params);
        //
        //     if (pageIndex == 2) {
        //
        //         // $(window).attr('location', '/transboxWeb/report_detail/' + hospitalId + '/' + startTime + '/' + endTime + '/' + organ + '/' + (params.pageNum - 1) + '/page2');
        //
        //     }
        //
        //
        // })


    });
</script>
</html>
