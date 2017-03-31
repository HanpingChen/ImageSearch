<%@ page import="chen.dao.DbOperator" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="chen.mapper.ServiceMapper" %>
<%@ page import="java.util.List" %>
<%@ page import="chen.entity.ServiceBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="chen.util.Util" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>控制台</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="http://cdn.bootcss.com/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="http://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<style>
    #top p{
        size: 35px;
        margin-right: 50px;
        margin-bottom: 20px;
        padding: 20px;
        background-color: #c9e1f5;
    }
</style>
<body>

<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">控制台</a>
            <ul class="nav navbar-nav">
                <li class="active"><a href="../index.jsp">首页</a></li>
            </ul>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">设置</a></li>
                <li><a href="#">支持</a></li>
                <li><a href="#"><%= session.getAttribute("username")%></a></li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="搜索">
            </form>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li class="active"><a href="#">概要</a></li>
                <li><a href="#">服务管理</a></li>
                <li><a href="#">使用统计</a></li>
            </ul>


        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <h1 class="page-header">概况</h1>
            <div id="top">
                <p>用我们的电商识图的服务让你可以只需要一张商品的图片就把商品的信息全部获得，甚至还可以获得到同类的商品的信息，让电商更加简单，这才是琳琅满目，真正的做到一叶知秋。要做到这一点十分简单，只需要点击下载我们的sdk，并且按照说明文档来开发就可以十分简单，你就可以租用我们的服务了。</p>
            </div>


            <h2 class="sub-header">我的应用</h2>
            <div class="table-responsive">
                <%
                    //查询数据库得到当前用户已接入的服务
                    SqlSession sqlSession = DbOperator.getSession();
                    ServiceMapper mapper = sqlSession.getMapper(ServiceMapper.class);
                    List<ServiceBean> list = new ArrayList<>();
                    String email = (String) session.getAttribute("email");
                    list = mapper.selectServiceByEmail(email);

                %>
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>项目名称</th>
                        <th>clinet_id</th>
                        <th>code</th>
                        <th>状态</th>
                        <th>类别</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        // 循环获取查询出的集合
                        for (int i=0;i<list.size();i++){
                    %>
                    <tr>
                        <td><%= list.get(i).getProjectName()%></td>
                        <td><%= list.get(i).getClientId()%></td>
                        <td><%= list.get(i).getAuthorizationCode()%></td>
                        <td>正常</td>
                        <%
                            Util util = new Util();
                            String servicename = util.getPropertiesValue("servicemapper",list.get(i).getServerType()+"");
                        %>
                        <td><%=servicename%></td>
                    </tr>
                    <%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>


<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/docs.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>

</html>

