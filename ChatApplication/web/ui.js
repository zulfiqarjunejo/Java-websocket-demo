/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

let source = $('#template_message').html();
let template = Handlebars.compile(source);

$('#btn_send_message').on('click', () => {
    let message = $('#input_message').val();
    if(message !== '') {
        sendMessage(message);
    }
});

