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
    <script src="${path}/js/jquery-1.8.3.min.js"></script>

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
                <a href="${path}/user/safe" style="color:yellow;float: right"><input type="button" value="安全退出"
                                                                                     style="background-color: yellow"></a>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <%----%>
        <form method="post" action="${path}/file/up" enctype="multipart/form-data">
            <table border="2px" cellpadding="2px" cellspacing="0px">
                <tr style="background-color: yellow">
                    <td>文件id</td>
                    <td>原始文件名称</td>
                    <td>新文件名称</td>
                    <td>文件后缀</td>
                    <td>存储路径</td>
                    <td>大小</td>
                    <td>文件类型</td>
                    <td>是否是图片</td>
                    <td>下载次数</td>
                    <td>操作</td>
                </tr>
                <c:forEach items="${fileList}" var="p" varStatus="i">
                    <tr style="background-color: #ADBECB;height: 10px;width: auto">
                        <td>${p.id}</td>
                        <td>${p.oname}</td>
                        <td>${p.nname}</td>
                        <td>${p.z_file}</td>
                        <td>${p.path}</td>
                        <td>${p.sizes}</td>
                        <td>${p.type}</td>
                        <td>
                            <c:if test="${p.type.substring(0,5).equals('image')}">
                                <img src="${path}/upDown/${p.path}/${p.nname}" width="20px" height="20px">
                            </c:if>

                            <c:if test="${!p.type.substring(0,5).equals('image')}">
                                <span>否</span>
                            </c:if>


                        </td>
                        <td>
                            <span id="ul"> ${p.count}</span>
                        </td>
                        <td width="500px" height="20px">
                            <a href="${path}/file/down?id=${p.id}&fileName=${p.oname}" style="float: left"
                               target="_blank" onclick="onSub()">
                                <input type="button" value="下载" id="btn"> </a>&nbsp;&nbsp;
                            <script type="text/javascript">

                                function onSub() {
                                    setTimeout(function () {
                                        window.location.reload();
                                    }, 1000);
                                }
                            </script>


                                <%--）））））））））））））））））））））））））））））））））））））））））））））））0--%>
                                <%--  <input type="button" value="下载" &lt;%&ndash;class="${i.index}"&ndash;%&gt; id="btn" onclick="ooo('${p.id}')" />

                                  <script>
                                          function ooo(ss){
                                             // console.log(ss);
                                              $.post("${pageContext.request.contextPath}/file/down", {'id': ss}, function (result) {
                                                  console.log(result);
                                                  $("#ul").empty().append(result.count);
                                              }, "JSON");
                                          }
                                  </script>--%>

                            <a href="${path}/file/down?id=${p.id}&fileName=${p.oname}&openStyle=inline"
                               style="float: left">
                                <input type="button" value="在线打开"></a>&nbsp;&nbsp;
                            <a href="${path}/file/delete?id=${p.id}" style="float: left">
                                <input type="button" value="删除">
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
            <input type="file" name="bb" webkitdirectory>
            <input type="submit" value="上传">
        </form>
        <%----%>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
