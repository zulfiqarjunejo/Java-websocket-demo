/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var socket = new WebSocket("ws://localhost:8080/ChatApplication/chat");
socket.onmessage = function (event) {
    alert('Inside onmessage');
    let context = {text: event.data};
    let html = template(context);
    $('.list-group-messages').append(html);
};

socket.onopen = function (event) {
};

sendMessage = function (text) {
    socket.send(text);
};


