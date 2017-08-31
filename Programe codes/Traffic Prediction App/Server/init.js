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
var json10 = require("./data/Monday 10.json");
var json11 = require("./data/Monday 11.json");
var json12 = require("./data/Monday 12.json");
var json13 = require("./data/Monday 13.json");
var json14 = require("./data/Monday 14.json");
var json15 = require("./data/Monday 15.json");
var json16 = require("./data/Monday 16.json");
var json17 = require("./data/Monday 17.json");
var json18 = require("./data/Monday 18.json");
var json19 = require("./data/Monday 19.json");
var json20 = require("./data/Monday 20.json");
var json21 = require("./data/Monday 1.json");
var json22 = require("./data/Monday 2.json");
var json23 = require("./data/Monday 3.json");

var my_json = json1;

var jsons = [json0, json1, json2, json3, json4, json5, json6, json7, json8, json9, json10, json11, json12, json13, json14, json15, json16, json17, json18, json19, json20, json21, json22, json23];
