<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Home</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <!-- css -->
    <link href="/resources/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="/resources/simple-line-icons/css/simple-line-icons.css">
    <link href="/resources/css/fancybox/jquery.fancybox.css" rel="stylesheet">
    <link href="/resources/css/flexslider.css" rel="stylesheet"/>
    <link href="/resources/css/style.css" rel="stylesheet"/>

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

</head>
<body>
<div id="wrapper" class="home-page">
    <!-- start header -->
    <header>
        <div class="navbar navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <%--<a class="navbar-brand" href=""><img src="/resources/img/logo.png"   alt="logo"/></a>--%>

                </div>
                <div class="navbar-collapse collapse ">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#">首页</a></li>
                        <li><a href="#">关于我们</a></li>
                        <li><a href="#">服务</a></li>
                        <li><a href="#">简介</a></li>
                        <li><a href="#">价格</a></li>
                        <li><a href="#">联系</a></li>
                    </ul>
                </div>
            </div>
        </div>


        <div class="navbar-wrapper">
            <div class="container-fluid">
                <nav class="navbar navbar-fixed-top">
                    <div class="container">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                                    data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                                <span class="sr-only">Toggle navigation</span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="#"><img src="/resources/img/logo.png" alt="莱普晟医疗" style="display: inline"> <span class="text-center" style="size: 4em;color: #009944;">莱普晟医疗</span></a>

                        </div>
                        <div id="navbar" class="navbar-collapse collapse">

                            <ul class="nav navbar-nav">
                                <li class="active"><a href="#">首页</a></li>
                                <li><a href="#">关于我们</a></li>
                                <li class=" dropdown"><a href="#" class="dropdown-toggle active" data-toggle="dropdown"
                                                         role="button" aria-haspopup="true" aria-expanded="false">服务
                                    <span class="caret"></span></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="#">低端箱服务</a></li>
                                        <li><a href="#">高端修复仪服务</a></li>

                                    </ul>
                                </li>

                                <li><a href="#">简介</a></li>
                                <li><a href="#">价格</a></li>
                                <li><a href="#">联系</a></li>
                            </ul>


                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
        </div>

    </header>
    <!-- end header -->
    <section id="banner">

        <!-- Slider -->
        <div id="main-slider" class="flexslider">
            <ul class="slides">
                <li>
                    <img src="/resources/img/slides/1.jpg" alt=""/>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="flex-caption">
                                    <h3>Biotechnology</h3>
                                    <p>Doloribus omnis minus temporibus perferendis ipsa architecto.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
                <li>
                    <img src="/resources/img/slides/2.jpg" alt=""/>
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="flex-caption">
                                    <h3>Active Pharma</h3>
                                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elitincidunt.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </li>
            </ul>
        </div>

        <!-- end slider -->

    </section>
    <section class="callaction">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div><h1>我们的产品</h1>杭州莱普晟医疗科技有限公司 (Hangzhou Life Perfusor Medical Technology Co., Ltd)
                        是国内领先的自主研发移植器官保护，保存，修复，及转运的先进医疗器械公司。公司以海归团队为主，致力成为移植器官灌注保存、复苏领域国内标杆，全球领先的解决方案提供商。开启器官保护新模式，开辟新的医疗行业领域。
                        公司系列产品以关键硬件产品为核心，数字化为翼，具有扎实的品牌竞争力，开启国内器官保护领域新航标，对提升国家器官移植技术，改善国计民生需求有重要意义。
                    </div>

                </div>
            </div>
        </div>
    </section>


    <section id="content">


        <div class="container">
            <div class="row">
                <div class="skill-home">
                    <div class="skill-home-solid clearfix">
                        <div class="col-md-3 text-center">
                            <div class="box-content">
                                <span class="icons c1"><i class="icon-diamond icons"></i></span>
                                <div class="box-area">
                                    <h3>多器官保护灌流溶液
                                    </h3>
                                    <ul>
                                    <li>多器官保护及灌流溶液multi-organ Preservation Perfusion Solution</li>
                                    <li>专利保护配方,专为转运及灌注研发</li>
                                    <li>精准优化流体力学参数</li>
                                    <li>改进多种温度贮存能力</li>
                                    <li>卓越的器官保存效果</li>
                                    <li>联合国内数个顶级团队共同研发,提升行业民族品牌竞争力</li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 text-center">
                            <div class="box-content">
                                <span class="icons c2"><i class="icon-settings icons"></i></span>
                                <div class="box-area">
                                    <h3>移动智能器官灌流系统</h3>
                                  <ul>
                                    <li>一体化器官灌流、转运设备，温度、压力、流速等核心参数同步智能调节</li>
                                    <li>内置电源支持转运期间不间断灌流，配套无菌转运耗材，简化操作，可选单路、多路灌流</li>
                                    <li>内置电源支持转运期间不间断灌流，配套无菌转运耗材，简化操作，可选单路、多路灌流</li>

                                  </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 text-center">
                            <div class="box-content">
                                <span class="icons c3"><i class="icon-note icons"></i></span>
                                <div class="box-area">
                                    <h3>智能医疗器官转运箱
                                    </h3>
                                    <ul>
                                        <li>国内首款专业移植器官医疗转运箱</li>
                                        <li>24小时以上0-4°C精准保温范围</li>
                                        <li>工业级三防及医疗级抗菌材质完美结合</li>
                                        <li>内嵌 LIFE TRACKER远程监控模块</li>
                                        <li>强大互联网平台运维支持,实时精准定位,转运位置,参数监控及推送</li>
                                        <li>配套一体化专用耗材,确保无菌</li>
                                        <li>多尺寸,多规格适应多场景</li>

                                    </ul>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 text-center">
                            <div class="box-content">
                                <span class="icons c4"><i class="icon-people icons"></i></span>
                                <div class="box-area">
                                    <h3>数字化器官转运监测平台
                                    </h3>

                                    <ul>
                                        <li>数字化转运监测平台</li>
                                        <li>对接国家器官移植注册及分配系统数据库</li>
                                        <li>未来国家级器官转运监测平台</li>

                                    </ul>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


        </div>
    </section>
    <section class="features">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div><h2>我们的特色</h2>
                        围绕国家重点研发计划，在创新驱动发展战略前提下，利用公司-高校-医工联合优势，推进科技成果临床转化。公司研发建立的控制性灌流保存与复苏技术装置体系，及开发的专用灌流液，将实现对临床移植器官的机器精准化控制性灌流保存及实时修复。对合理有效的利用边缘器官及提高供器官质量，最终造福广大移植等待患者具有重要意义
                    </div>
                    <br/>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="features-item">
                        <div class="features">
                            <div class="icon">
                                <i class="icon-map icons"></i>
                            </div>
                            <div class="features-content">
                                <h3>领导者</h3>
                                <p>成为全球器官保护与修复领域行业领导者,以先进技术增续病患生命;</p>
                            </div>
                        </div>
                        <div class="features">
                            <div class="icon">
                                <i class="icon-envelope-open icons"></i>
                            </div>
                            <div class="features-content">
                                <h3>战略构想</h3>
                                <p>在器官移植手术已基本达到世界先进水平的基础上,增加器官质量监
                                    控和修复技术这一利器,并以先进的数字信息化技术为翼,使我国器官移植技术
                                    国际领先。</p>
                            </div>
                        </div>
                        <div class="features">
                            <div class="icon">
                                <i class="icon-badge icons"></i>
                            </div>
                            <div class="features-content">
                                <h3>支持</h3>
                                <p>在推动国家器官灌流保护政策、制定行业标准、承担企业社会责任等
                                    方面持续推进,最终器官移植事业的发展,引领行业进步。</p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <img class="img-responsive" src="/resources/img/img1.png" alt="">
                </div>
            </div>
        </div>
    </section>

    <section class="aboutUs" style="display: none">
        <div class="container">
            <div class="row">
                <div class="col-md-6"><img src="/resources/img/img2.png" class="img-center" alt=""/></div>
                <div class="col-md-6">
                    <div><h2>Our Team</h2>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores quae porro consequatur
                            aliquam, incidunt eius magni provident, doloribus omnis minus temporibus perferendis
                            nesciunt quam repellendus nulla nemo ipsum odit corrupti consequuntur possimus, vero
                            mollitia velit ad consectetur. Alias, laborum excepturi nihil autem nemo numquam, ipsa
                            architecto non, magni consequuntur quam.</p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolores quae porro consequatur
                            aliquam, incidunt eius magni provident, doloribus omnis minus temporibus perferendis
                            nesciunt quam repellendus nulla nemo ipsum odit corrupti consequuntur possimus, vero
                            mollitia velit ad consectetur. Alias, laborum excepturi nihil autem nemo numquam, ipsa
                            architecto non, magni consequuntur quam.</p>
                    </div>
                    <br/>
                </div>
            </div>

        </div>
    </section>

    <footer>
        <div class="container" style="display: none">
            <div class="row">
                <div class="col-lg-3">
                    <div class="widget">
                        <h5 class="widgetheading">Our Contact</h5>
                        <address>
                            <strong>BioTex company Inc</strong><br>
                            JC Main Road, Near Silnile tower<br>
                            Pin-21542 NewYork US.
                        </address>
                        <p>
                            <i class="icon-phone"></i> (123) 456-789 - 1255-12584 <br>
                            <i class="icon-envelope-alt"></i> email@domainname.com
                        </p>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="widget">
                        <h5 class="widgetheading">Quick Links</h5>
                        <ul class="link-list">
                            <li><a href="#">Latest Events</a></li>
                            <li><a href="#">Terms and conditions</a></li>
                            <li><a href="#">Privacy policy</a></li>
                            <li><a href="#">Career</a></li>
                            <li><a href="#">Contact us</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="widget">
                        <h5 class="widgetheading">Latest posts</h5>
                        <ul class="link-list">
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></li>
                            <li><a href="#">Pellentesque et pulvinar enim. Quisque at tempor ligula</a></li>
                            <li><a href="#">Natus error sit voluptatem accusantium doloremque</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-3">
                    <div class="widget">
                        <h5 class="widgetheading">Recent News</h5>
                        <ul class="link-list">
                            <li><a href="#">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</a></li>
                            <li><a href="#">Pellentesque et pulvinar enim. Quisque at tempor ligula</a></li>
                            <li><a href="#">Natus error sit voluptatem accusantium doloremque</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
        <div id="sub-footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6">
                        <div class="copyright">
                            <p>
                                Copyright &copy; 2018.杭州莱普晟医疗科技有限公司

                            </p>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <ul class="social-network">
                            <li><a href="#" data-placement="top" title="Facebook"><i class="fa fa-facebook"></i></a>
                            </li>
                            <li><a href="#" data-placement="top" title="Twitter"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#" data-placement="top" title="Linkedin"><i class="fa fa-linkedin"></i></a>
                            </li>
                            <li><a href="#" data-placement="top" title="Pinterest"><i class="fa fa-pinterest"></i></a>
                            </li>
                            <li><a href="#" data-placement="top" title="Google plus"><i
                                    class="fa fa-google-plus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </footer>
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/resources/js/jquery.js"></script>
<script src="/resources/js/jquery.easing.1.3.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery.fancybox.pack.js"></script>
<script src="/resources/js/jquery.fancybox-media.js"></script>
<script src="/resources/js/portfolio/jquery.quicksand.js"></script>
<script src="/resources/js/portfolio/setting.js"></script>
<script src="/resources/js/jquery.flexslider.js"></script>
<script src="/resources/js/animate.js"></script>
<script src="/resources/js/custom.js"></script>
</body>
</html>