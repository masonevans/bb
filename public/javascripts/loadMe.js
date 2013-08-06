function loadAbout() {
	/*$.get("http://localhost:9000/about", function(data) {
		$("#about").html("Name: " + data.name);
	}, "json");*/
}

function loadFriendList() {
	$.get("http://localhost:9000/friends", function(data) {
		$("#friendList").html("");
		data.forEach(
			function(element, index, array) {
				$("#friendList").append("<p class='friendUser'>" + element.name + "</p>");
			}
		);
	}, "json");
}

function loadNewsFeed() {
	$.get("http://localhost:9000/news", function(data) {
		$("#newsFeed").html("");
		data.forEach(
			function(element, index, array) {
				$("#newsFeed").append("<div class='newsItemContainer'>" + "<p class='newsItem'>" + element.message + "</p>" + "<p class='newsItemCreatedDate'>" + element.createdDate + "</p></div>")
			}
		);
	}, "json");
}

//loadAbout();
loadFriendList();
loadNewsFeed();