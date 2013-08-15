function loadFriendList() {
	$.get("http://localhost:9000/friends/" + userId, function(data) {
		$("#friendListContainer").html("");
		data.forEach(
			function(element, index, array) {
				$("#friendListContainer").append(
					"<p class='friendUser' title='" + element.email + "'>" + 
						"<a href='/user/" + element.userId + "'>" + element.name + "</a>" +
					"</p>");
			}
		);
	}, "json");
}



//Call this every second
//setInterval(loadFriendList, 5 * 1000);