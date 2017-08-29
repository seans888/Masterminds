// const express = require('express');
// const app = express();
// var pg = require('pg');
// var format = require('pg-format');
// var PGUSER = 'postgres';
// var PGDATABASE = 'postgres';
// var PGPASSWORD = 'Saddssdsdda1';

// var config = {
// 	user: PGUSER,
// 	database: PGDATABASE,
// 	password: PGPASSWORD,
// 	max: 10,
// 	idleTimeoutMillis: 30000

// }

// var pool = new pg.Pool(config);
// var myClient;

// pool.connect(function (err, client, done) {
// 	if (err) console.log(err);
// 	app.listen(3000, function () {
// 		console.log('listening on 3000')
// 	});
// 	myClient = client;
// 	var ageQuery = format('SELECT * from numbers WHERE age = %L', age);	
// 	myClient.query(ageQuery, function (err, result) {
// 		if (err) {
// 			console.log(err);
// 		}
// 		console.log(result.rows[0]);
// 	})
// })

var express = require('express');
var router = express.Router();

var hostname = '0.0.0.0';
var port = 3000;

var app = express();

var db = require('./queries');

router.get('/api/origins', db.getAllOrigins);
router.get('/api/destinations', db.getAllDestinations);
router.get('/api/jamlevel/:origin/:destination/:day/:hour', db.getJamLevel);

app.use('/', router);

app.listen(port, hostname, function() {
	console.log('connected');
})
