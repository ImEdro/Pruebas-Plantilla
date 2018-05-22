
function iniciarsesion(correo, clave) {
    var parametros = {
        "email": correo,
        "password": clave
    };
    $.ajax({
        data: parametros,
        url: "ServletSesion",
        type: "POST"
    }).done(function (response) {
        var str1 = "ingresar";
        var ad = str1.localeCompare(response);
        if (ad === 0) {
            document.location.href = "principal.jsp";
        } else {
            ohSnap(response, {color: 'red'});
        }
    });
}

function CrearCuenta(nombre, nick, clave, correo) {
    var parametros = {
        "nombre": nombre,
        "nick": nick,
        "email": correo,
        "password": clave
    };
    alert(parametros.nombre+" "+parametros.nick+" "+parametros.email+" "+parametros.password);
    $.ajax({
        data: parametros,
        url: "ServletCrearCuenta",
        type: "POST"
    }).done(function (response) {
        var str1 = "ingresar";
        var ad = str1.localeCompare(response);
        if (ad === 0) {
            document.location.href = "principal.jsp";
        } else {
            ohSnap(response, {color: 'red'});
        }
    });
}


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
            document.getElementById('userProfile').innerHTML = '' + response[0].Nombre;
            document.getElementById('nombreId').innerHTML = 'id#' + response[0].Id;
            document.getElementById('nombreUser').innerHTML = response[0].Nombre;
            juegosFav(response[0].Id);
        }
    });
}
;

