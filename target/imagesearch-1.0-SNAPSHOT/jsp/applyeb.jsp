<%@ page import="chen.context.ServiceDict" %>
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

        #create{
            margin-top: 30px;
            margin-bottom: 30px;
        }

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
            margin-bottom: 30px;
        }

        #footer{
            margin-left: 60px;
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
            <a class="navbar-brand" href="#">电商识图</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">首页</a></li>
                <li><a href="#">常见问题</a></li>
                <li><a href="#">下载</a></li>

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
                <%
                    if (session.getAttribute("username") == null){
                %>
                <li><a href="./jsp/login.jsp">控制台</a></li>
                <li><a href="./jsp/login.jsp">登录</a></li>
                <%
                }
                else {
                %>
                <li><a href="./jsp/console.jsp">控制台</a></li>
                <li><a href="./jsp/console.jsp">欢迎<%= session.getAttribute("username")%></a></li>
                <li><a href="/imagesearch/logout">退出登录</a></li>
                <%
                    }
                %>

                <li><a href="./jsp/register.jsp">注册</a></li>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<img src="images/ebfirst2.png" width="100%">

<hr class="feature-divider">
<div id="service">
    <h1>电商识图，搜出商品一切信息</h1>
    <p>复杂的搜索和计算，只需要几行代码就能搞定，接入平台，一切都不再遥不可及，为你的电商事业注入新能量</p>
</div>
<hr class="feature-divider">
<!-- Button trigger modal -->
<div align="center">
    <button id="create" type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
        +创建应用
    </button>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">创建项目</h4>
            </div>
            <div class="modal-body">
                <form action="/imagesearch/add_service" method="post">
                    <div class="form-group">
                        <label for="projectname">项目名称</label>
                        <input type="text" name="projectname" class="form-control" id="projectname" placeholder="项目名称">
                        <%
                            session.setAttribute(ServiceDict.SERVER_TYPE,"1");
                            session.setAttribute(ServiceDict.USER_EMAIL,session.getAttribute(ServiceDict.USER_EMAIL));
                        %>
                    </div>


                    <button type="submit" class="btn btn-primary">完成</button>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
            </div>
        </div>
    </div>
</div>
</div>
<!-- 主要内容 -->
<div>
    <footer id="footer">
        <p>&nbsp;&nbsp;&copy; 陈汉苹 LionsChen 2017</p>
    </footer>

</div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>






