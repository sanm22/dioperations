$(document).ready(function() {
	$('#load1').change(function(event) {
		var load1 = $("select#load1").val();
		$.get('JsonServlet', {
			loadName : load1
		}, function(response) {

			var select = $('#subLoad');
			select.find('option').remove();
			$.each(response, function(index, value) {
				$('<option>').val(value).text(value).appendTo(select);
			});
		});
	});
	
});