$(document).ready(function () {
    inicio();
    //validarInfoPrincipal();
});

function cerrarsesion() {
    $.ajax({
        url: "ServletSesion",
        type: "Delete"

    }).done(function (response) {
        document.location.href = "index.jsp";
    });
}
;

//function validarInfoPrincipal() {
//    $.ajax({
//        url: "ServletValidarSesion",
//        type: "GET"
//
//    }).done(function (response) {
//        var str1 = "undefined";
//        var ad = str1.localeCompare(response[0].PlataformasVideojuegos);
//        var ad2 = str1.localeCompare(response[0].FechaNacimiento);
//        if (ad === 0 || ad2 === 0) {
//            ohSnap(" primero llena la encuesta para recibir sugerencias ", {color: 'blue'});
//            document.getElementById('informacionAdicional').style.display = 'block';
//        } else {
//            Limpiar();
//        }
//    });
//}
//;

function infou() {

    $.ajax({
        url: "ServletValidarSesion",
        type: "GET"

    }).done(function (response) {
        var str1 = "null";
        var ad = str1.localeCompare(response);
        if (ad === 0) {
            document.location.href = "index.html";
        } else {
            document.getElementById('nickname').innerHTML = response[0].Nickname;
            document.getElementById('nickname').value = response[0].Nickname;
            juegosFav(response[0].Nickname);
            amigos(response[0].Nickname);

        }
        connect();
    });
}
;

function juegosFav(id) {
    var parametros = {
        "IdUsuario": id
    };
    $.ajax({
        data: parametros,
        url: "ServletJuegosUsuario",
        type: "GET"

    }).done(function (response) {
        var juegos = response;
        document.getElementById('misjuegos').innerHTML = '';
        for (var i in juegos) {
            $("#misjuegos").append(
                    '<li>' +
                    '<a onclick="infoJuego(\'' + juegos[i].Id + '\')">' +
                    '<i class="now-ui-icons tech_controller-modern"></i>' +
                    '<p>' + juegos[i].Nombre + '</p>' +
                    '  </a>' +
                    '</li>'
                    );
        }
    });
}
;

function amigos(id) {
    var parametros = {
        "IdUsuario": id
    };
    $.ajax({
        data: parametros,
        url: "ServletAmigos",
        type: "GET"

    }).done(function (response) {
        var amigos = response;
        document.getElementById('misamigos').innerHTML = '';
        for (var i in amigos) {
            $("#misamigos").append(
                    '<li>' +
                    '<a onclick="Chat(\'' + amigos[i].Nickname + '\')" >' +
                    '<i class="now-ui-icons users_single-02"></i>' +
                    '<p >' + amigos[i].Nickname + '</p>' +
                    '  </a>' +
                    '</li>'
                    );
        }
    });
}
;

function Notificaciones() {
    document.getElementById('numNotifiacion').innerHTML = "0";
    document.getElementById('notifiacion').innerHTML = "";
    $.ajax({
        url: "ServletNotificacion",
        type: "GET"

    }).done(function (response) {
        var not = response;
        document.getElementById('numNotifiacion').innerHTML = "" + not.length;
        document.getElementById('notifiacion').innerHTML = "";
        for (var i in not) {
            var str1 = "undefined";
            var ad = str1.localeCompare(not[i].Solicitud);
            if (ad === 0) {
                $("#notifiacion").append(
                        '<a class="dropdown-item" href="#">' +
                        '<p>' + not[i].Notica + '</p>' +
                        ' </a>'
                        );
            } else {

                $("#notifiacion").append(
                        '<a class="dropdown-item" href="#">' +
                        '<p> ' + not[i].Solicitud + ' quiere ser tu amigo</p>' +
                        '<form>' +
                        '<button class="btn btn-outline-success my-2 my-sm-0" onclick="AceptarSolicitud(\'' + not[i].Solicitud + '\')" >Aceptar</button>' +
                        '<button class="btn btn-outline-danger my-2 my-sm-0"  onclick="BorrarNotificacion(\'' + not[i].Id + '\')">Ignorar</button>' +
                        '</form>' +
                        ' </a>'
                        );
            }

        }

    });

}

function BorrarNotificacion(id) {
    alert("borrar" + id);
    var parametros = {
        "IdNotificacion": id
    };
    $.ajax({
        data: parametros,
        url: "ServletNotificacion",
        type: "post"
    }).done(function (response) {
        Notificaciones();
        ohSnap(response, {color: 'red'});
    });
}


function AceptarSolicitud(id) {
    //aceptar la solicitud 
    var parametros = {
        "IdUsuario": id
    };
    $.ajax({
        data: parametros,
        url: "ServletAmigos",
        type: "POST"
    }).done(function (response) {
        Notificaciones();
        amigos();
        ohSnap(response, {color: 'red'});
    });
}

function Limpiar() {
    $("#noticias").empty();
    document.getElementById('vtop10').style.display = 'none';
    document.getElementById('vrecomendacionesj').style.display = 'none';
    document.getElementById('infojuego').style.display = 'none';
    document.getElementById('InfoPerfil').style.display = 'none';
    document.getElementById('InfoPerfilBuscar').style.display = 'none';
    //document.getElementById('perfil').style.display = 'none';
}

function inicio() {
    Limpiar();
    noticias();
    infou();
    Notificaciones();
    recomendacionJuegos();
    top10();
    document.getElementById('vtop10').style.display = 'block';
    document.getElementById('vrecomendacionesj').style.display = 'block';
}