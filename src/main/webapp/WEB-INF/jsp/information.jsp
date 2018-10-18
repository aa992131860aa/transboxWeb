<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="common/head.jsp" %>
    <%@include file="common/tag.jsp" %>
    <style>
        html, body {
            width: 100%;
            margin: 0;
            padding: 0;
            background-color: #F8F8F8;
        }

        .container {
            margin-top: 10px;
            padding-top: 3%;

        }


    </style>
</head>

<body>

<div class="container">

    <!-- END row-->
    <!-- START panel tab-->
    <div role="tabpanel" class="panel">
        <!-- Nav tabs-->
        <ul role="tablist" class="nav nav-tabs nav-justified nav-pills">
            <li role="presentation" class="active ">
                <a href="#home" aria-controls="home" role="tab" data-toggle="tab">
                    <em class="fa fa-clock-o fa-fw"></em>文档下载</a>
            </li>
            <li role="presentation">
                <a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">
                    <em class="fa fa-money fa-fw"></em>相关链接</a>
            </li>
            <li role="presentation">
                <a href="#report" aria-controls="report" role="tab" data-toggle="tab">
                    <em class="fa fa-money fa-fw"></em>季度报告</a>
            </li>
        </ul>
        <!-- Tab panes-->
        <div class="tab-content p0">

            <div id="home" role="tabpanel" class="tab-pane active">
                <!-- START table responsive-->
                <div class="table-responsive">
                    <table class="table table-bordered table-hover table-striped">
                        <thead>
                        <tr>
                            <th>文档编号</th>
                            <th>文档名称</th>
                            <th>日期</th>
                            <th>操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${informations}" var="info">


                            <tr>
                                <td class="col-sm-2 col-xm-2">${info.fileNo}</td>
                                <td class="col-sm-6 col-xm-6">${info.fileName}</td>
                                <td class="col-sm-2 col-xm-2">${info.createTime}</td>
                                    <%--data-toggle="modal"  data-target="#myModal"--%>
                                <td class="col-sm-2 col-xm-2">
                                    <button id="check" class="btn btn-info" data-toggle="modal" data-target="#myModal"
                                            onclick="check('${info.fileUrl}')">查看
                                    </button>
                                    <button class="btn btn-danger" onclick="download('${info.fileUrl}')">下载</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>


                </div>

            </div>

            <div id="profile" role="tabpanel" class="tab-pane ">
                <!-- START list group-->
                <div class="list-group">
                    <a href="http://www.nhfpc.gov.cn/yzygj/s3585/201605/940f44e39f1e452e8e35c37593025537.shtml?from=timeline&isappinstalled=0"
                       class="list-group-item" style="color: #36BDE7" target="_blank">
                        <%--<span class="label label-purple pull-right">just now</span>--%>
                        国家卫生计生委医政医管局</a>
                    <a href="http://www.cltr.org" class="list-group-item" style="color: #36BDE7" target="_blank">
                        <%--<span class="label label-purple pull-right">just now</span>--%>
                        中国肝移植注册系统</a>
                    <a href="http://www.csrkt.org/main/index.do" class="list-group-item" style="color: #36BDE7"
                       target="_blank">
                        <%--<span class="label label-purple pull-right">just now</span>--%>
                        中国肾移植科学登录系统</a>
                    <a href="http://chtr.cotr.cn/login.jsp" class="list-group-item" style="color: #36BDE7"
                       target="_blank">
                        <%--<span class="label label-purple pull-right">just now</span>--%>
                        中国心脏脏移植注册系统</a>
                    <a href="http://clutr.cotr.cn/login.jsp" class="list-group-item" style="color: #36BDE7"
                       target="_blank">
                        <%--<span class="label label-purple pull-right">just now</span>--%>
                        中国肺移植注册系统</a>
                    <a href="https://www.cot.org.cn" class="list-group-item" style="color: #36BDE7" target="_blank">
                        <%--<span class="label label-purple pull-right">just now</span>--%>
                        中国人体器官分配与共享计算机系统</a>
                    <a href="http://www.china-organdonation.org" class="list-group-item" style="color: #36BDE7"
                       target="_blank">
                        <%--<span class="label label-purple pull-right">just now</span>--%>
                        中国红十字会中国人体捐献管理中心脏</a>


                </div>
                <!-- END list group-->
                <%--<div class="panel-footer text-right"><a href="#" class="btn btn-default btn-sm">View All Activity </a>--%>
                <%--</div>--%>
            </div>

            <div id="report" role="tabpanel" class="tab-pane ">
                <!-- START list group-->
                <div class="list-group">
                    <c:forEach items="${times}" var="times">

                        <a href="/transboxWeb/report/${times.hospital.hospitalId}/${times.hospital.hospitalName}/${times.time}/${times.name}/index"
                           class="list-group-item" style="color: #36BDE7" target="_blank">
                                <%--<span class="label label-purple pull-right">just now</span>--%>
                                ${times.hospital.hospitalName} &nbsp;&nbsp;${times.name}</a>
                    </c:forEach>


                </div>
                <!-- END list group-->
                <%--<div class="panel-footer text-right"><a href="#" class="btn btn-default btn-sm">View All Activity </a>--%>
                <%--</div>--%>
            </div>
        </div>
    </div>

    <%--<button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">开始演示模态框</button>--%>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <%--<h4 class="modal-title" id="myModalLabel"></h4>--%>
                </div>
                <div class="modal-body">

                    <iframe id="displayPdfIframe" width="100%" height="500"
                            src="<c:url value="/resources/pdfjs/web/viewer.html" />?file=<c:url value="/resources/pdf/use.pdf"/>">
                    </iframe>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>

    <!-- END panel tab-->

</div>

</body>

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/backbone.paginator/2.0.6/backbone.paginator.min.js"></script>
<!-- 可选的Bootstrap主题文件（一般不使用） -->
<%--<script src="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>--%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/resources/js/transbox.js" type="text/javascript"></script>

<script type="text/javascript">


    function check(fileUrl) {
        var name = fileUrl.split('/pdf/');

        $('iframe').attr('src', '/resources/pdfjs/web/viewer.html?file=/resources/pdf/' + name[1]);
    }

    function download(fileUrl) {

        window.open(fileUrl);
    }

    // transbox.information.init({})
</script>
</html>
