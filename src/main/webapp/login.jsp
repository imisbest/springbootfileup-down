<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    request.setAttribute("path", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
    <title>login</title>
    <link rel="stylesheet" type="text/css"
          href="${path}/css/style.css"/>
</head>

<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <%@ page import="java.text.SimpleDateFormat" %>
                    <%@ page import="java.util.Calendar" %>
                    <% String datetime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); /*//获取系统时间*/%><%=datetime%>
                    <br/> <br/>
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                login
            </h1>
            <form action="${path}/user/login" method="post" onsubmit="return check()">
                <script type="text/javascript">                    function check() {
                    var nn = document.getElementsByClassName('inputgri');
                    for (var i = 0; i < nn.length; i++) {
                        if (!nn[i].value) {
                            alert("有空值，请检查之后在重新提交");
                            return false;
                        }
                    }                       /* var b = window.confirm("请确认提交是否提交表单");                        if (b) {*/
                    return true;                      /*  } else {                            return false;                        }*/
                }                </script>
                <table cellpadding="0" cellspacing="0" border="0"
                       class="form_table">
                    <tr>
                        <td valign="middle" align="right">
                            username:
                        </td>
                        <td valign="middle" align="left">
                            <input type="text" class="inputgri" name="username" value="qqq"/>
                        </td>
                    </tr>
                    <tr>
                        <td valign="middle" align="right">
                            password:
                        </td>
                        <td valign="middle" align="left">
                            <input type="password" class="inputgri" name="password" value="qqq"/>
                        </td>
                    </tr>
                    <tr><img src="${path}/captcha/captcha" id="captchaImg"/>
                        <div class="label-text">验证码：</div>
                        <input type="text" name="captchaCode"><br/>
                        <a href="javascript:void(0)"
                           onclick="changeCaptcha()">看不清，换一张!~</a>&nbsp;<span
                                style="color:red">${errorMsg }</span><br/>
                        <script type="text/javascript">
                            function changeCaptcha() {
                                // 根据ID获取到验证码图片对象
                                var captchaImg = document.getElementById('captchaImg');
                                captchaImg.src = '${path}/captcha/captcha?'
                                    + Math.random();
                            }
                        </script>
                    </tr>
                </table>
                <p>
                    <input type="submit" class="button" value="Submit &raquo;"/>
                    <input type="button" class="button" onclick="location.href='${path}/regist.jsp'"
                           value="Regist &raquo;"/>
                </p>
            </form>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
