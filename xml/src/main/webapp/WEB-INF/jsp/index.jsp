<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html lang="zh_CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
* {
    margin: 0;
    padding: 0;
    font-family: Times New Roman;
}
.container {
    width: 800px;
    margin: 0 auto
}
table {
    width: 100%;
    border-collapse: collapse;
}
table tr {
    border-bottom: 1px solid #ddd
}
table tbody tr:hover {
    background-color: #ddd
}
table thead th, table tbody td {
    height: 30px;
    text-align: center
}
</style>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script>
$(function(){
	$.ajax({
		url: 'xml',
		type: 'get',
		dataType: 'xml',
		success: function(data){
			var beans = $(data).find('DemoBean');
			var html = '';
			for (var i = 0; i < beans.length; i++) {
				html += '<tr><td>';
				var bean = beans[i];
				var id = $(bean).find('id').text();
				html += id;
				html += '</td><td>';
				var text = $(bean).find('text').text();
				html += text;
				html += '</td><td>';
				var number = $(bean).find('number').text();
				html += number;
				html += '</td><td>';
				var date = $(bean).find('date').text();
				html += date;
				html += '</td></tr>';
			}
			$('#xml').html(html);
		}
	});
});
</script>
<title>${title }</title>
</head>
<body>
<div class="container">
	<p>${message }</p>
	<table>
	    <thead>
	        <th>id</th>
	        <th>text</th>
	        <th>number</th>
	        <th>date</th>
	    </thead>
		<tbody id="xml">
		</tbody>
	</table>
</div>
</body>
</html>