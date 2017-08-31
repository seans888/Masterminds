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
	password: '12345'
};

var db = pgp(cn);

// add query functions