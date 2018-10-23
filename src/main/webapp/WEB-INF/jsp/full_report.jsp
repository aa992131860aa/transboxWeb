<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>无标题文档</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/full/main.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/full/animate.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/full/style.reset.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/full/full.css"/>
    <link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">

    <%--<script src="https://cdn.bootcss.com/jquery/3.0.0/jquery.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/jquery-migrate/3.0.0/jquery-migrate.min.js"></script>--%>

    <script type="text/javascript" src="/resources/js/full/monitor-pub-min.js"></script>
    <script type="text/javascript" src="/resources/js/full/jquery-1.9.1.min.js"></script>

    <!-- jQuery Modal -->
    <link rel="stylesheet" type="text/css" href="/resources/js/modal/zeroModal.css"/>
    <script type="text/javascript" src="/resources/js/modal/zeroModal.min.js"></script>


    <%--<script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>--%>
    <script type="text/javascript" src="/resources/js/full/jquery-ui.min.js"></script>
    <%--<script src="https://cdn.bootcss.com/jquery-ui-bootstrap/0.5pre/assets/js/jquery-ui-1.10.0.custom.min.js"></script>--%>
    <script type="text/javascript" src="/resources/js/full/jquery.fullPage.min.js"></script>
    <%--<script src="https://cdn.bootcss.com/fullPage.js/2.9.7/jquery.fullpage.min.js"></script>--%>
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <!--图表-->

    <script type="text/javascript" src="/resources/js/highcharts.js"></script>

    <%--// Highstock--%>
    <%--<script src="https://cdn.hcharts.cn/highstock/highstock.js"></script>--%>


    <script src="http://cdn.hcharts.cn/highmaps/modules/map.js"></script>
    <%--<script type="text/javascript" src="https://img.hcharts.cn/highmaps/highmaps.js"></scr11ipt>--%>
    <script src="/resources/js/chainMap.js"></script>
    <%--<script type="text/javascript" src="https://img.hcharts.cn/highcharts/highcharts.js"></script>--%>
    <script type="text/javascript" src="https://img.hcharts.cn/highcharts/modules/variable-pie.js"></script>


    <script type="text/javascript" src="/resources/js/full/highcharts-more.js"></script>
    <%--<script type="text/javascript" src="https://data.jianshukeji.com/geochina/china.js"></script>--%>


    <!-- 鼠标-->
    <%--<script src="https://cdn.bootcss.com/jquery-mousewheel/3.1.13/jquery.mousewheel.min.js"></script>--%>

    <!-- 图标,地图-->
    <script type="text/javascript" src="/resources/js/echarts.min.js"></script>
    <script type="text/javascript" src="/resources/js/china.js"></script>

    <script>
        $(function () {
            if ($.browser.msie && $.browser.version < 10) {
                $('body').addClass('ltie10');
            }
            $.fn.fullpage({
                verticalCentered: false,
                anchors: ['page1', 'page2', 'page3', 'page4', 'page5', 'page6', 'page7', 'page8'],
                navigation: true,
                navigationTooltips: ['', '', '', '', '', '', '', '']
            });

        });
    </script>
</head>

<body style="overflow: hidden; height: 100%;">


<div id="superContainer" style="top: 0px;">

    <!--[if lt IE 9]>
    <a href="tips.html" id="clickMe"></a>
    <![endif]-->

    <!--顶部-->

    <!--fullPage-->
    <div class="section section1" data-anchor="page1" style="height: 755px;">
        <div class="bg"></div>
        <!--外边圆-->
        <div class="bg1_02" data-wow-delay="1s"></div>
        <!--中心圆-->
        <div class="bg1_04 fadeIn animated animated" data-wow-delay="1s"></div>
        <!--文字-->
        <div class="bg1_03 pwhile p36 wow ">
            <div style="display: table-cell;vertical-align: middle;text-align: center">${hospitalName}<br><strong
                    style="font-size: 40px">中国移植器官转运及质控</strong><br/>${title}
            </div>
        </div>
        <!--左右上下-->
        <div class="bg1_05"></div>
        <div class="bg1_06"></div>
        <div class="bg1_07"></div>
        <div class="bg1_08"></div>

        <!-- 六个圆点 -->
        <div class="bg1_11"></div>
        <div class="bg1_12"></div>
        <div class="bg1_13"></div>
        <div class="bg1_14"></div>
        <div class="bg1_15"></div>
        <div class="bg1_16"></div>
        <div class="bg1_17"></div>

        <!--<div class="bg09 wow fadeInRight animated animated" data-wow-delay="1s" ></div>-->
        <!--<div class="bg10 wow fadeInDown animated animated" data-wow-delay="0.5s"></div>-->
        <!--<div class="bg11 wow fadeInDown animated animated" data-wow-delay="1s" ></div>-->
        <!--<div class="bg13 wow fadeInLeft animated animated" data-wow-delay="1s"></div>-->
        <!--<div class="bg12 wow fadeInUp   animated animated" data-wow-delay="1.2s"><a href="javascript:;" target="_blank"></a></div>-->
        <div class="bg7_102 p18 wow pwhile fadeInUp animated animated" data-wow-delay="1s">杭州莱普晟医疗科技有限公司</div>
    </div>
    <div class="section section2" data-anchor="page2">
        <div class="bg2"></div>
        <div class="bg2_01"></div>
        <div class="bg3_02">
            <table width="100%" class="table table-bordered">
                <caption></caption>
                <thead>
                <tr>
                    <th>器官</th>
                    <th>占比</th>

                </tr>
                </thead>
                <tbody id="page2_tbody" align="center">


                </tbody>
            </table>
        </div>
        <div class="bg2_04" id="container2">


        </div>

        <div id="page2_conclude" class="bg2_04_b p18black">


        </div>

        <!--<div class="bg2_05"></div>-->
        <!--<div class="bg2_06"></div>-->
        <!--<div class="bg2_07"></div>-->

        <div class="bg2_02 p18 wow pwhile">
            <center><span class="p18">${title}</span>
                <p></p><strong
                        class="p25">器官类型比例</strong></center>
        </div>
        <div class="bg2_03"> <span
                id="page2_title">结论:</span></div>


    </div>
    <div class="section section3" data-anchor="page3">
        <div class="bg2"></div>
        <div class="bg2_01"></div>
        <div class="bg3_02">
            <table width="100%" class="table table-bordered">
                <caption></caption>
                <thead>
                <tr>
                    <th>区域</th>
                    <th>转运次数</th>

                </tr>
                </thead>
                <tbody id="page3_tbody" align="center">


                </tbody>
            </table>
        </div>
        <div class="bg3_04" id="container3"></div>
        <!--<div class="bg2_05"></div>-->
        <!--<div class="bg2_06"></div>-->
        <!--<div class="bg2_07"></div>-->

        <div id="page3_conclude" class="bg2_04_b p18black">


        </div>

        <div class="bg2_02 p18 wow pwhile fadeInDown animated animated" data-wow-delay="1s">
            <center><span class="p18">${title}</span>:<br/><strong
                    class="p25">器官来源分析</strong></center>
        </div>
        <div class="bg2_03">

            <span
                    id="page3_title">各省转运数量(次)</span></div>

    </div>
    <div class="section section4" data-anchor="page4">
        <div class="bg2"></div>
        <div class="bg2_01"></div>
        <div class="bg3_02">
            <table width="100%" class="table table-bordered">
                <caption></caption>
                <thead>
                <tr>
                    <th>转运时长(小时)</th>
                    <th>转运次数</th>

                </tr>
                </thead>
                <tbody id="page4_tbody" align="center">


                </tbody>
            </table>
        </div>
        <div class="bg4_04" id="container4"></div>
        <!--<div class="bg2_05"></div>-->
        <!--<div class="bg2_06"></div>-->
        <!--<div class="bg2_07"></div>-->

        <div class="bg2_02 p18 wow pwhile fadeInDown animated animated" data-wow-delay="1s">
            <center><span class="p18">${title}</span>:<br/><strong
                    class="p25">转运时长分析</strong></center>
        </div>
        <div class="bg2_03"> <span
                id="page4_title">转运耗时情况(小时)</span></div>

    </div>
    <div class="section section5" data-anchor="page5">
        <div class="bg2"></div>
        <div class="bg2_01"></div>
        <div class="bg3_02">
            <table width="100%" class="table table-bordered">
                <caption></caption>
                <thead>
                <tr>
                    <th>异常</th>
                    <th>异常比例(%)</th>

                </tr>
                </thead>
                <tbody id="page5_tbody" align="center">


                </tbody>
            </table>
        </div>
        <div class="bg2_04" id="container">
            <div class="bg2_04_01" id="container51"></div>
            <div class="bg2_04_03">温度</div>
            <div class="bg2_04_02">
                <div class="bg2_04_02_01" id="container52"></div>
                <div class="bg2_04_02_02" id="container53"></div>
            </div>
            <div class="bg2_04_03">
                <div class="bg2_04_03_01">开箱</div>
                <div class="bg2_04_03_02">碰撞</div>
            </div>
        </div>
        <!--<div class="bg2_05"></div>-->
        <!--<div class="bg2_06"></div>-->
        <!--<div class="bg2_07"></div>-->

        <div class="bg2_02 p18 wow pwhile fadeInDown animated animated" data-wow-delay="1s">
            <center><span class="p18">${title}</span>:<br/><strong
                    class="p25">转运异常分析</strong></center>
        </div>
        <div class="bg2_03"> <span
                id="page5_title">结论</span></div>

    </div>
    <div class="section section6" data-anchor="page6">
        <div class="bg2"></div>
        <div class="bg2_01"></div>
        <div class="bg3_02">
            <table width="100%" class="table table-bordered">
                <caption></caption>
                <thead>
                <tr>
                    <th>交通工具</th>
                    <th>转运次数</th>

                </tr>
                </thead>
                <tbody id="page6_tbody" align="center">


                </tbody>
            </table>
        </div>
        <div class="bg4_04" id="container6"></div>
        <!--<div class="bg2_05"></div>-->
        <!--<div class="bg2_06"></div>-->
        <!--<div class="bg2_07"></div>-->

        <div class="bg2_02 p18 wow pwhile fadeInDown animated animated" data-wow-delay="1s">
            <center><span class="p18">${title}</span>:<br/><strong
                    class="p25">交通工具分析</strong></center>
        </div>
        <div class="bg2_03"> <span
                id="page6_title">结论</span></div>

    </div>
    <div class="section section7" data-anchor="page7">
        <div class="bg2"></div>
        <div class="bg2_01"></div>
        <div class="bg3_02">
            <table width="100%" class="table table-bordered">
                <caption></caption>
                <thead>
                <tr>
                    <th>转运人</th>
                    <th>转运次数</th>

                </tr>
                </thead>
                <tbody id="page7_tbody" align="center">


                </tbody>
            </table>
        </div>
        <div class="bg2_04" id="">
            <div class="bg2_04_01" id="container71"></div>
            <div class="bg2_04_03" id="page7_one"></div>
            <div class="bg2_04_02">
                <div class="bg2_04_02_01" id="container72"></div>
                <div class="bg2_04_02_02" id="container73"></div>
            </div>
            <div class="bg2_04_03">
                <div class="bg2_04_03_01" id="page7_two"></div>
                <div class="bg2_04_03_02" id="page7_three"></div>
            </div>
        </div>
        <!--<div class="bg2_05"></div>-->
        <!--<div class="bg2_06"></div>-->
        <!--<div class="bg2_07"></div>-->

        <div class="bg2_02 p18 wow pwhile fadeInDown animated animated" data-wow-delay="1s">
            <center><span class="p18">${title}</span>:<br/><strong
                    class="p25">转运人员分析</strong></center>
        </div>
        <div class="bg2_03"> <span
                id="page7_title">结论</span></div>

    </div>
    <div class="section section8" data-anchor="page8">
        <div class="bg2"></div>
        <div class="bg2_01"></div>
        <div class="bg3_02">
            <table width="100%" class="table table-bordered">
                <caption></caption>
                <thead>
                <tr>
                    <th>箱子编号</th>
                    <th>转运次数</th>

                </tr>
                </thead>
                <tbody id="page8_tbody" align="center">


                </tbody>
            </table>
        </div>
        <div class="bg4_04" id="container8"></div>
        <!--<div class="bg2_05"></div>-->
        <!--<div class="bg2_06"></div>-->
        <!--<div class="bg2_07"></div>-->

        <div class="bg2_02 p18 wow pwhile fadeInDown animated animated" data-wow-delay="1s">
            <center><span class="p18">${title}</span>:<br/><strong
                    class="p25">箱子使用频率分析</strong></center>
        </div>
        <div class="bg2_03"> <span
                id="page8_title" >结论</span></div>

    </div>

</div>
</div>
<script>
    $(function () {
        var ie6 = window.ActiveXObject && !window.XMLHttpRequest;
        var Slider = function () {

            function slideTo(idx) {

            }

            var timer;

            function startAutoPlay() {
                stop();
                // timer = setTimeout(Slider.slideNext, 5000);
            }

            function stop() {
                timer && clearTimeout(timer);
            }

            return {
                slideTo: slideTo,
                slidePrev: function () {

                    if (current == 0) return;
                    slideTo(current - 1);
                },
                slideNext: function () {

                    slideTo(current + 1);
                },
                startAutoPlay: startAutoPlay,
                stop: stop
            }
        }();

        if (!ie6) {
            Slider.startAutoPlay();
        }


        $('.section3').on('mousemove', function (e) {

            var offsetX = e.clientX / window.innerWidth - 0.5,
                offsetY = e.clientY / window.innerHeight - 0.5;
            $('.section3 .layer2').css('left', -10 - 40 * offsetX).css('top', -10 - 40 * offsetY);
            $('.section3 .layer3').css('left', 10 + 40 * offsetX).css('top', 50 + 20 * offsetY);
            $('.section3 .layer4').css('left', 10 + 60 * offsetX).css('top', 140 + 30 * offsetY);
        });

        $('.section4').on('mousemove', function (e) {
            var offsetX = e.clientX / window.innerWidth - 0.5,
                offsetY = e.clientY / window.innerHeight - 0.5;
            $('.section4 .layer2').css('left', 80 - 20 * offsetX).css('top', 30 - 20 * offsetY);
        });


        $('.section5').on('mousemove', function (e) {
            var offsetX = e.clientX / window.innerWidth - 0.5,
                offsetY = e.clientY / window.innerHeight - 0.5;
            $('.section5 .layer2').css('left', 50 - 40 * offsetX).css('top', 10 - 40 * offsetY);
        });

        $('.section7').on('mousemove', function (e) {
            var offsetX = e.clientX / window.innerWidth - 0.5,
                offsetY = e.clientY / window.innerHeight - 0.5;
            $('.section7 .layer2').css('left', -18 - 40 * offsetX).css('top', 25 - 40 * offsetY);
            $('.section7 .layer3').css('left', -18 + 40 * offsetX).css('top', 75 + 40 * offsetY);
        });

    })

</script>
<div id="fullPage-nav" class="right" style="color: rgb(0, 0, 0); margin-top: -100px;">
    <ul>
    </ul>
</div>
</body>
<script src="/resources/js/transbox.js" type="text/javascript"></script>
<script type="text/javascript">


    $(function () {
        var hospitalId = '<%=request.getAttribute("hospitalId")%>';
        var startTime = '<%=request.getAttribute("startTime")%>';
        var endTime = '<%=request.getAttribute("endTime")%>';


        transbox.report.init({
            hospitalId: hospitalId,
            startTime: startTime,
            endTime: endTime
        });
    });

</script>
</html>
