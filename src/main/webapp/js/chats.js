var ws;
function connect() {
    var username = document.getElementById("nickname").value;

    ws = new WebSocket("ws://" + document.location.host + "/ProyectoPlataformaVideoJuegos/chat/" + username);
    ws.onmessage = function (event) {
        var str1 = "nuevo amigo";
        var message = JSON.parse(event.data);
        var ad = str1.localeCompare(message.content);
        var log = document.getElementById("log");
        console.log(event.data);
        if (ad === 0) {
            Notificaciones();
        } else {
            document.getElementById("chatNomUsuario1").value = message.from;
            document.getElementById("chatNomUsuario1").innerHTML = message.from;
            document.getElementById("chatusuario1").value = message.content;
            document.getElementById("chatusuario1").innerHTML = message.content;
        }
    };
}


//'< div class = "direct-chat-info clearfix" >' +
//        '< span class = "direct-chat-img-reply-small pull-right" >' +
//        '< img alt = "message user image" src = "http://bootsnipp.com/img/avatars/bcf1c0d13e5500875fdd5a7e8ad9752ee16e7462.jpg" class = "direct-chat-img2" >' +
//        '< /span>' +
//        '< span class = "direct-chat-name pull-right" >' + message[i].from + ' < /span>' +
//        '< /div>' +
//        '< div class = "direct-chat-text" >' +
//        message[i].content +
//        '< /div>'

function send() {
    var username = document.getElementById("nickname").value;
    var content = document.getElementById("msg").value;
    var to = document.getElementById("namechat").value;
    var json = JSON.stringify({
        "to": to,
        "content": content
    });
    ws.send(json);
    document.getElementById("chatNomUsuario2").value = username;
    document.getElementById("chatNomUsuario2").innerHTML = username;
    document.getElementById("chatusuario2").value = content;
    document.getElementById("chatusuario2").innerHTML = content;
}

function sendnotificacion(to) {
    var content = "nuevo amigo";
    var json = JSON.stringify({
        "to": to,
        "content": content
    });
    ws.send(json);
}

function AgregarAmigo(id) {
    var username = document.getElementById("nickname").value;
    var parametros = {
        "IdUsuario": id
    };
    $.ajax({
        data: parametros,
        url: "ServletSolicitudAmistad",
        type: "POST"
    }).done(function (response) {
        ohSnap(response, {color: 'red'});
        sendnotificacion(username);
    });
}

function openchat() {
    $('#qnimate').addClass('popup-box-on');
}

function closechat() {
    $('#qnimate').removeClass('popup-box-on');
}
function Chat(nom) {
    document.getElementById('namechat').innerHTML = nom;
    document.getElementById('namechat').value = nom;
    openchat();
}
