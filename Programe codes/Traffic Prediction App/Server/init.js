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
