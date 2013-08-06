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
	$("#newsFeed").html("News Feed");
}

//loadAbout();
loadFriendList();
loadNewsFeed();