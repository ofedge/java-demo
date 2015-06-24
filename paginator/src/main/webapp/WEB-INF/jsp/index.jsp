<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>bootstrap paginator</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/bootstrap-theme.min.css">
<script src="/js/jquery-1.11.2.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<script src="/js/bootstrap-paginator.js"></script>
<script>
$(function(){
	var loadPersons = function(page, size) {
		if (page == undefined)
			page = 0;
		if (size == undefined)
			size = 10;
		$.ajax({
			url: '/persons',
			type: 'get',
			data: {'page': page, 'size': size},
			dataType: 'json',
			success: function(data){
				options.currentPage = data.number + 1;
				options.totalPages = data.totalPages;
				var content = data.content;
				var tbody = '';
				for (var i = 0; i < content.length; i++) {
					tbody += '<tr><td>';
					tbody += content[i].id;
					tbody += '</td><td>';
					tbody += content[i].name;
					tbody += '</td><td>';
					tbody += content[i].email;
					tbody += '</td><td>';
					tbody += content[i].age;
					tbody += '</td><td>';
					tbody += content[i].gender;
					tbody += '</td><td>';
					tbody += content[i].countryId;
					tbody += '</td></tr>';
				}
				$('tbody').html(tbody);
			},
			complete: function(){
				$('#example').bootstrapPaginator(options);
			}
		});
	}
	var options = {
		bootstrapMajorVersion: 3,
		currentPage: 1,
		totalPages: 10,
		pageUrl: function(type, page, current){
			return "javascript:void(0);";
		},
		onPageClicked: function(e,originalEvent,type,page){
			loadPersons(page - 1);
		}
	}
	loadPersons();
});
</script>
</head>
<body>
  <div class="container" style="padding-top: 30px;">
    <table class="table">
      <thead>
        <tr>
          <th>id</th>
          <th>name</th>
          <th>email</th>
          <th>age</th>
          <th>gender</th>
          <th>country id</th>
        </tr>
      </thead>
      <tbody></tbody>
    </table>
    <ul id="example"></ul>
  </div>
</body>
</html>