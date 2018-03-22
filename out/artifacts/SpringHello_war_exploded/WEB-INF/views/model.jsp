<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2018/3/14
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${name}</title>
    <script src="../bootstrap-3.3.7/docs/assets/js/vendor/jquery.min.js"></script>
    <link rel="stylesheet" href="../bootstrap-3.3.7/dist/css/bootstrap.css">
</head>

<div>
<script>
    function onClickBtn() {
        $("#nameTxt").val("----1");

        $.ajax({
            url : "http://localhost:8080/hello/hello",
            type : "GET",
//            async: false,
            data:{
                name : "****",
                count : 999
            },
            contentType: "application/json; charset=utf-8",
            success: function(content){
            $("#nameTxt").val("content:" +content);
            window.location.href = encodeURI("/test?params=" + content + "&count1=" + 456789) ;


        },
            error:function (err) {

                var errText = "";
//                for(e in err)
//                {
//                    errText += e + ":" +err[e] + "\\n";
//                }
                errText += err['status'] +" > " + err['statusText'];
                $("#nameTxt").val("err:" +errText)
            }
        });
        $("#nameTxt").val("----2");
    }

</script>
    <h1>传过来的数据:${testModel.toString()}</h1>
    <div class="container">
        <div style="">userName:
            <input id="nameTxt" type="text" value="${name}" width="80%">
        </div>
        <div>password:
            <input type="text" value="${count}">
        </div>
        <input id="btn" type="button" value="提交" onclick="onClickBtn()">
        </div>
    </div>
</body>
</html>
