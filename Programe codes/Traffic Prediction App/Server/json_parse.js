var my_json = require("./response.json");

var origins = my_json["origin_addresses"];
var destinations = my_json["destination_addresses"];

for (var i = 0; i < origins.length; i++) {
	var current_origin = origins[i];
	var branch = my_json["rows"][i];
	for (var j = 0; j < destinations.length; j++) {
		var current_destination = destinations[j];
		var stem = branch["elements"][j];
		var distance = stem["distance"]["value"];
		var duration = stem["duration"]["value"];
		
		console.log("FROM: " + current_origin);
		console.log("TO: " + current_destination);
		console.log("DISTANCE: " + distance);
		console.log("DURATION: " + duration);

	}
}

