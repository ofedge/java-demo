$(function(){
	index.btn();
});

var index = {
		url: '/demo',
		demo: {
			id: 0,
			text: '',
			number: 0,
			_method: '' // put 请求参数时候需要
		},
		initDemo: function(){
			index.demo.id = 0;
			index.demo.text = '';
			index.demo.number = 0;
			index._method = '';
		},
		findById: function(id){
			$.ajax({
				url: index.url + '/' + id,
				type: 'get',
				dataType: 'json',
				success: function(data){
					$('#post_id').val(data.id);
					$('#post_text').val(data.text);
					$('#post_number').val(data.number);
				}
			});
		},
		updateDemo: function(){
			$.ajax({
				url: index.url,
				type: 'post',
				data: index.demo,
				success: function(data){
					alert(data);
				},
				complete: function(){
					index.initDemo();
				}
			});
		},
		addDemo: function(){
			$.ajax({
				url: index.url,
				type: 'put',
				data: index.demo,
				success: function(data){
					$('#put_id').val(data.id);
					$('#put_text').val(data.text);
					$('#put_number').val(data.number);
				},
				complete: function(){
					index.initDemo();
				}
			});
		},
		deleteDemo: function(id){
			$.ajax({
				url: index.url + '/' + id,
				type: 'delete',
				success: function(data){
					alert(data);
				}
			});
		},
		btn: function(){
			$('#get').on('click', function(){
				var id = $('#id').val();
				index.findById(id);
			});
			
			$('#post').on('click', function(){
				index.demo.id = $('#post_id').val();
				index.demo.text = $('#post_text').val();
				index.demo.number = $('#post_number').val();
				index.demo._method = '';
				index.updateDemo();
			});
			
			$('#put').on('click', function(){
				index.demo.text = $('#put_text').val();
				index.demo.number = $('#put_number').val();
				index.demo._method = 'put';
				index.addDemo();
			});
			
			$('#delete').on('click', function(){
				var id = $('#id').val();
				index.deleteDemo(id);
			});
		}
}