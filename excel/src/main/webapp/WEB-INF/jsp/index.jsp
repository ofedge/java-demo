<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <title>excel</title>
  </head>
  <body>
    <form action="submit" method="post" enctype="multipart/form-data">
        <p>file: <input type="file" name="file" accept="application/vnd.ms-excel, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" /></p>
        <p><input type="submit" value="submit" /></p>
    </form>
    <p>${list }</p>
  </body>
</html>
