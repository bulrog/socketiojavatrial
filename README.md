# socketiojavatrial
Trial to create socket io with java

## express trial
first need to install nodejs on your PC
go in react_trial
run:
    npm install
then run:
    nodejs expresstrial.js

Then go in browser on localhost:8080

This will open a page and show different plotting system (ploty.js seems best one)

In expresstrial.js can also see socketio listening on port 8081.
Can edit react_trial/index.html and change port of socket to 8081

When reload the page you should get a pop up showing you get connected

## java socket as server:
in react_trial/index.html put port to 8082
 Then run the SocketIOServerTrial and the index page should connect to it

## java socket io client:
After running expresstrial.js just run SocketIOTrial then it should connect to express server

#react trial
run:
/node_modules/.bin/gulp that will open a page in browser which renders a title (react component)
and below it a trial of plotting.
