$(document).ready(function(){

    WebSocket.init();

})

function connect(){
    var socket = new SockJS("/websockethandler");
    stompClient = Stomp.over(socket);

    stompClient.connect({}, function(){
        stompClient.subscribe('/topic/roomId', function(msg){
            printMessage(JSON.parse(msg.body).sendMessage + '/' + 
            JSON.parse(msg.body).senderName);
        });

        stompClient.subscribe('/topic/out', function(msg){
            printMessage(msg.body);
        });

        stompClient.subscribe('/topic/in', function(msg){
            printMessage(msg.body);
        });

        stompClient.send('/app/in', {}, usersessionid.value + ' is in chatroom');

    });
}

function disconnect(){
    if(stompClient != null){
        stompClient.send('/app/out', {}. usersessionid.value + ' is out chatroom')
        stompClient.disconnect();
    }
}

function sendMessage(text){
    stompClient.send('/app/hello', {}, JSON.stringify({'sendMessage' : text, 'senderName': '' + usersessionid.value}));
}