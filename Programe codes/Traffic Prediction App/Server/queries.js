var promise = require('bluebird');

var options = {
  // Initialization Options
  promiseLib: promise
};

var my_json = require("./data/Monday 0.json");

var origins = my_json["origin_addresses"];
var destinations = my_json["destination_addresses"];

var pgp = require('pg-promise')(options);
// var connectionString = 'postgres://localhost:5432/puppies';
const cn = {
	host: 'localhost',
	port: 5432,
	database: 'postgres',
	user: 'postgres',
	password: 'Saddssdsdda1'
};

var db = pgp(cn);

// add query functions

module.exports = {
  getAllOrigins: getAllOrigins,
  getAllDestinations: getAllDestinations,
  getJamLevel: getJamLevel
};



function getAllOrigins(req, res, next) {
	res.status(200).json(origins);
}

function getAllDestinations(req, res, next) {
	res.status(200).json(destinations);
}

function getJamLevel(req, res, next) {
	origin = decodeURI(req.params.origin).replace(/\+/g, ' ');
	destination = decodeURI(req.params.destination).replace(/\+/g, ' ');
	day = req.params.day;
	hour = req.params.hour;
	console.log(origin);
	console.log(destination);
	// console.log(req.params);
	var query = 'select distance, duration from histories where origin = \'' + origin + '\' and destination = \'' + destination + '\'' + 'and day = \'' +  day + '\' and hour = \'' + hour + '\'';
	db.any(query)
		.then (function (data) {
			res.status(200)
				.json({
					status: 'success',
					data: data
				});
		})
		.catch (function (err) {
			return next(err);
		});
}