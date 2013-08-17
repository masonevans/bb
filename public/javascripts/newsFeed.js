function loadNewsFeed(url) {
	var i=0;
	$.get(url, function(data) {
		var currentDiv;
		data.forEach(
			function(element, index, array) {
				if(i%3 == 0) {
					$("#newsFeedContainer").append("<div class='row-fluid'>");
				}
				$("#newsFeedContainer .row-fluid:last").append(
					"<div class='span4'>" + 
						"<h2>" + element.message + "</h2>" +
						"<p>" + element.createdDate + "</p>" +
					"</div>"
				);
				i++;
			}
		);
	}, "json");
}