<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上傳的頁面</title>
</head>
<body>

<h1> 上傳檔案的頁面</h1>
<form action="fileUpload" method="post" enctype="multipart/form-data">
name : <input id="photoName" type="text" name="photoName" />
<br/>
file: <input type="file" name="file">
<br>
<input type="submit" value="送出">

</form>
</body>
</html>