function loadAbout() {
	$.get("http://localhost:9000/about", function(data) {
		$("#about").html("Name: " + data.name);
	}, "json");
}

function loadFriendList() {
	$("#friendList").html("Friend List");
}

function loadNewsFeed() {
	$("#newsFeed").html("News Feed");
}

loadAbout();
loadFriendList();
loadNewsFeed();