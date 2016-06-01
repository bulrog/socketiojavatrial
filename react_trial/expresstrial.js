var express=require('express');
var app=express();
var server=require('http').createServer(app);
var io=require('socket.io')(server);

io.on('connection',function(client){
	console.log("client connected");
	client.emit('messages',{hello:'world'});
});

app.use(express.static(__dirname));
app.get('/jem',function(reqest,response){
/*	response.write("hello!");
	response.end();
*/
	response.sendFile(__dirname+"/index.html");
});
app.listen(8080);
server.listen(8081);
