<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>restful test</title>
<style type="text/css">
* {
	font-size: 16px;
	margin: 5px;
}
</style>
<script src="jquery-1.11.2.min.js"></script>
<script src="index.js"></script>
</head>
<body>
	<input type="number" id="id" placeholder="id" />
	<input type="button" id="get" value="查询" />
	<input type="button" id="delete" value="删除" />
	<br />
	<input type="text" id="post_id" placeholder="id" disabled="disabled" />
	<input type="text" id="post_text" placeholder="text" />
	<input type="number" id="post_number" placeholder="number" />
	<input type="button" id="post" value="修改" />
	<br />
	<input type="text" id="put_id" placeholder="id" disabled="disabled" />
	<input type="text" id="put_text" placeholder="text" />
	<input type="number" id="put_number" placeholder="number" />
	<input type="button" id="put" value="新增" />
	<br />
</body>
</html>