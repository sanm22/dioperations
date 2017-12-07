$(document).ready(function() {
	$('#subLoad').change(function(event) {
		var subLoad = $("select#subLoad").val();
		$.get('JsonServlet', {
			lloadName : subLoad
		}, function(response) {

			var select = $('#jobName');
			select.find('option').remove();
			$.each(response, function(index, value) {
				$('<option>').val(value).text(value).appendTo(select);
			});
		});
	});
});