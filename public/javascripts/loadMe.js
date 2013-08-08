function loadFriendList() {
	$.get("http://localhost:9000/friends/" + userId, function(data) {
		$("#friendListContainer").html("");
		data.forEach(
			function(element, index, array) {
				$("#friendListContainer").append("<p class='friendUser' title='" + element.email + "'>" + element.name + "</p>");
			}
		);
	}, "json");
}

function loadNewsFeed() {
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

loadFriendList();
//Call this every second
setInterval(loadFriendList, 5 * 1000);

loadNewsFeed();