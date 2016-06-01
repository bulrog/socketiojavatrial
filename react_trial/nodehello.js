var http=require('http');
var server=http.createServer();

/*server.on('request',function(request,response){

	response.writeHead(200);
	response.write("Hello world new!");
	setTimeout(function(){
		response.write("time out!");
		response.end();
		console.log("end of time!");
	},2000);
}).listen(8080,function(){
	console.log("Listening on port 8080 with timeout")});*/

server.on('request',function(request,response){
	request.pipe(response);

}).listen(8080);

var message="this is a message!";
var options={host:'localhost',
			port: 8080,
			path: '/',
			method:'POST'
	};
var req=http.request(options,function(response){
	response.on('data',function(data) {
		console.log("this is the response:"+data);
	});
	
});

req.write(message);
req.end();

server.on('close',function() {
	console.log("this is the end!");
});

