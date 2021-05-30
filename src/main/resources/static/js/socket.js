var sock = new SockJS("/ws/chat");
var stomp = webstomp.over(sock);

stomp.connect({}, function(frame){

});

// var websocket = new WebSocket("/ws/chat");
// var stomp = websocket.over(websocket);

// stomp.connect({}, function(frame)){

// }