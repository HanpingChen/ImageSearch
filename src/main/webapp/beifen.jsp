<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>图像检索平台</title>

    <!-- Bootstrap -->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">

    <style>

        body{
            padding-top: 50px;
        }

        .carousel{
            height: 500px;
            background-color: #000;
            margin-bottom: 60px;
        }

        .carousel .item{
            height: 500px;
            background-color: #000;
        }
        .carousel image{
            width: 100%;
        }

        .carousel-caption p{
            margin-bottom: 20px;
            font-size: 20px;
            line-height: 1.8;
        }

        #summary-container .col-md-4{
            text-align: center;
            margin-bottom: 70px;
        }
        #service p{
            text-align: center;
            margin-bottom: 30px;
        }
        #service h1{
            margin-top: 30px;
            margin-bottom: 20px;
            text-align: center;
        }

        .feature-heading{
            padding-top: 60px;
            margin-bottom: 20px;
            color: #2a6496;
            font-size: 50px;
            margin-right: 20px;
        }

        .text-muted{
            margin-left: 20px;
            font-size: 20px;
        }
        .lead{
            margin-bottom: 40px;
            font-size: 23px;
        }
        #tab-content{
            margin-bottom: 60px;
        }

    </style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">图像检索平台</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#">起步</a></li>
                <li><a href="#">产品</a></li>
                <li><a href="#">关于</a></li>

                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">文档 <span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="#">java sdk文档</a></li>
                        <li role="presentation" class="divider"></li>
                        <li><a href="#">Android sdk文档</a></li>
                        <li role="presentation" class="divider"></li>
                        <li><a href="#">c# sdk文档</a></li>
                    </ul>
                </li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="./jsp/console.jsp">控制台</a></li>
                <%
                    if (session.getAttribute("username") == null){
                %>
                <li><a href="./jsp/login.jsp">登录</a></li>
                <%
                }
                else {
                %>
                <li><a href="./jsp/console.jsp">欢迎<%= session.getAttribute("username")%></a></li>
                <%
                    }
                %>

                <li><a href="./jsp/register.jsp">注册</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-example-generic" data-slide-to="1"></li>
        <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        <li data-target="#carousel-example-generic" data-slide-to="3"></li>
        <li data-target="#carousel-example-generic" data-slide-to="4"></li>

    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="images/chrome-big.jpg" alt="1 slide">
            <div class="carousel-caption">
                <h1>图像检索，检索图像</h1>
                <p>用一张图片搜索出它的同类</p>
            </div>
        </div>
        <div class="item">
            <img src="images/firefox-big.jpg" alt="2 slide">
            <div class="carousel-caption">
                <h1>图像检索，检索图像</h1>
                <p>用一张图片搜索出它的同类</p>
            </div>
        </div>
        <div class="item">
            <img src="images/safari-big.jpg" alt="3 slide">
            <div class="carousel-caption">
                <h1>图像检索，检索图像</h1>
                <p>用一张图片搜索出它的同类</p>
            </div>
        </div>
        <div class="item">
            <img src="images/opera-big.jpg" alt="4 slide">
            <div class="carousel-caption">
                <h1>图像检索，检索图像</h1>
                <p>用一张图片搜索出它的同类</p>
            </div>
        </div>
        <div class="item">
            <img src="images/ie-big.jpg" alt="5 slide">
            <div class="carousel-caption">
                <h1>图像检索，检索图像</h1>
                <p>用一张图片搜索出它的同类</p>
            </div>
        </div>
    </div>

    <!-- Controls -->
    <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left"></span>
        <span class="sr-only">上一页</span>
    </a>
    <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right"></span>
        <span class="sr-only">下一页</span>
    </a>
</div>

<!-- 主要内容 -->
<div class="container summary">

    <!-- 简介 -->
    <div class="row" id="summary-container">
        <div class="col-md-4">
            <img class="img-circle" src="images/imagesearch.jpeg" alt="chrome">

            <h2>图像检索</h2>

            <p>虽只是一张图片，我已知世界。用你的手里的图片来寻找相似的图片，找到世界的美，找到世界的规律。</p>

            <p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多 &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <img class="img-circle" src="images/data.jpeg" alt="firefox">

            <h2>精准的数据计算</h2>

            <p>hadoop和hive的计算，高效率的图片检索，算你想算，算出你要的答案。</p>

            <p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多 &raquo;</a></p>
        </div>
        <div class="col-md-4">
            <img class="img-circle" src="images/platform.png" alt="safari">

            <h2>开放平台</h2>

            <p>共享，是社会主义的本质要求，我开放，你享受，享受图形检索的乐趣</p>

            <p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多 &raquo;</a></p>
        </div>


    </div>
    <hr class="feature-divider">
    <div id = "service">

        <h1>多种服务，不同场景</h1>
        <p>图像检索有不同的运用场景，我们为尽量多的场景提供解决方案</p>
    </div>
    <hr class="feature-divider">

    <div>
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#tab-eb" role="tab" data-toggle="tab">电商识货</a></li>
            <li role="presentation"><a href="#tab-tellimg" role="tab" data-toggle="tab">智能识图</a></li>
            <li role="presentation"><a href="#tab-sort" role="tab" data-toggle="tab">图像分类</a></li>
        </ul>

        <div class = "tab-content" id="tab-content">
            <div role="tabpanel" class="tab-pane active" id="tab-eb">
                <div class="row feature">
                    <div class="col-md-7">

                        <h2 class="feature-heading">电商识货<span
                                class="text-muted">一张图片搜出所有信息</span></h2>

                        <p class="lead">电商识货 我们用一张商品的图片，虽然我们不知道该如何用文字称呼它，但是我们只需要有这张图片，那么就可以搜索出他的商品信息</p>
                    </div>
                    <div class="col-md-5">
                        <img class="feature-image img-responsive" src="images/eb.png"
                             alt="Chrome">
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="tab-tellimg">
                <div class="row feature">
                    <div class="col-md-7">

                        <h2 class="feature-heading">智能识图<span
                                class="text-muted">告诉你这图片描述的是什么</span></h2>

                        <p class="lead">当我们面多许多的图片的时候，我们只想找出其中有某个特征的图片，这个时候我们只需要把一张图片放入，就可以找出其他的与这张图片有相似特征的图片。</p>
                    </div>
                    <div class="col-md-5">
                        <img class="feature-image img-responsive" src="images/tellimg.jpeg"
                             alt="Chrome">
                    </div>
                </div>
            </div>
            <div role="tabpanel" class="tab-pane" id="tab-sort">
                <div class="row feature">
                    <div class="col-md-7">

                        <h2 class="feature-heading">图片分类<span
                                class="text-muted">整理你的大量图片</span></h2>

                        <p class="lead">我们可以定义我们的分类标准，比如有车的一类，有房子的一类，或者以颜色来分类，让我们可以更好的真理我们的大量图片</p>
                    </div>
                    <div class="col-md-5">
                        <img class="feature-image img-responsive" src="images/sort.png"
                             alt="Chrome">
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<div>
    <footer>
        <p>&copy; 陈汉苹 LionsChen 2017</p>
    </footer>

</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>






