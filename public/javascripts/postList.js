function loadPostList() {
	$.get("http://localhost:9000/news/" + userId, function(data) {
		$("#newsFeedContainer").html("");
		data.forEach(
			function(element, index, array) {
				$("#newsFeedContainer").append(
					"<div class='newsItemContainer'>" + 
						"<p class='newsItem'>" + element.message + "</p>" + 
						"<p class='newsItemCreatedDate'>" + element.createdDate + "</p>" + 
					"</div>"
				);
			}
		);
	}, "json");
}