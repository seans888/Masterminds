var pg = require('pg');
var format = require('pg-format');
var PGUSER = 'postgres';
var PGDATABASE = 'postgres';
var PGPASSWORD = '12345';
var age = 732;

var config = {
	user: PGUSER,
	database: PGDATABASE,
	password: PGPASSWORD,
	max: 10,
	idleTimeoutMillis: 30000

}

var json0 = require("./data/Monday 0.json");
var json1 = require("./data/Monday 1.json");
var json2 = require("./data/Monday 2.json");
var json3 = require("./data/Monday 3.json");
var json4 = require("./data/Monday 4.json");
var json5 = require("./data/Monday 5.json");
var json6 = require("./data/Monday 6.json");
var json7 = require("./data/Monday 7.json");
var json8 = require("./data/Monday 8.json");
var json9 = require("./data/Monday 9.json");