var promise = require('bluebird');

var options = {
  // Initialization Options
  promiseLib: promise
};

var my_json = require("./data/Monday 0.json");

var origins = my_json["origin_addresses"];
var destinations = my_json["destination_addresses"];