$(document).ready(function() {
	$('#load11').change(function(event) {
		var load11 = $("select#load11").val();
		$.get('NewEntryServlet', {
			loadName : load11
		}, function(response) {

			var select = $('#subLoad1');
			select.find('option').remove();
			$.each(response, function(index, value) {
				$('<option>').val(value).text(value).appendTo(select);
			});
		});
	});
	
});