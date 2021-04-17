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
<form action="${path}/api/upload" enctype="multipart/form-data" method="post">
    <input id="file" type="file" name="files" multiple webkitdirectory/>
    <input type="submit" value="上传文件夹"/>
</form>
</body>
</html>
