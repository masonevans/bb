function loadFriendList() {
	$.get("http://localhost:9000/friends/" + userId, function(data) {
		data.forEach(
			function(element, index, array) {
				$("#friendListContainer").append("<li><a href='/user/" + element.userId + "'>" + element.name + "</a></li>");
			}
		);
	}, "json");
}



//Call this every second
//setInterval(loadFriendList, 5 * 1000);