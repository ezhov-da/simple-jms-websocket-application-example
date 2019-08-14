var socket = new WebSocket("ws://127.0.0.1:8080/simple-jms-websocket-application-example/notify");
socket.onmessage = onMessage;

function onMessage(event) {
    console.log('Получение сообщения');
//    var device = JSON.parse(event.data);
    var data = event.data;
    console.log(data);
    $('#receiveJMS').html(data)
}