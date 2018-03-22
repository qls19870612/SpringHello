<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2018/3/8
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Test</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <script src="bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js"></script>
    <link rel="stylesheet" href="bootstrap-3.3.7/dist/css/bootstrap.css">
</head>

<style>
</style>
<body>


    <div class="container">
        <div class="jumbotron">
            <h1>我的第一个 Bootstrap 页面</h1>
            <p>重置窗口大小，查看响应式效果！${msg}</p>
        </div>
        <div class="row">
            <div class="col-sm-4">
                <h3>Column 1</h3>
                <p>学的不仅是技术，更是梦想${test1}</p>
                <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
            </div>
            <div class="col-sm-4">
                <h3>Column 2</h3>
                <p>学的不仅是技术，更是梦想！${test1}</p>
                <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
            </div>
            <div class="col-sm-4">
                <h3>Column 3</h3>
                <p>学的不仅是技术，更是梦想！</p>
                <p><span class="glyphicon glyphicon-user" ></span><small>再牛逼的梦想,也抵不住你傻逼似的坚持！</small></p>
            </div>
        </div>
    </div>

</body>
</html>
