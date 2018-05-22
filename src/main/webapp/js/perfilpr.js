
function actualizarPerfil() {
    infoPerfilpr();
    cuadrito();
}

function infoPerfilpr() {
    Limpiar();
    document.getElementById('InfoPerfil').style.display = 'block';
    var id = document.getElementById('nickname').value;
    alert(id);
    var parametros = {
        "IdUsuario": id
    };
    $.ajax({
        data: parametros,
        url: "ServletUsuario",
        type: "GET"

    }).done(function (response) {
        var usuarios = response;
        document.getElementById('Nicknamepr').value = usuarios[0].Nickname;
        document.getElementById('Nombrepr').value = usuarios[0].Nombre;
        document.getElementById('Correopr').value = usuarios[0].Email;
        document.getElementById('Paispr').value = usuarios[0].Pais;
        document.getElementById('Fechapr').value = usuarios[0].FechaNacimiento;
        document.getElementById('Generospr').value = usuarios[0].GenerosJuego;
        document.getElementById('Horaspr').value = usuarios[0].HorasPromedioJuego;
        document.getElementById('Diaspr').value = usuarios[0].DiasJuego;
        document.getElementById('Idiomapr').value = usuarios[0].Idiomas;
        document.getElementById('Acercapr').value = usuarios[0].ExperienciaVideojuegos;


    });


}
;
function cuadrito() {
    var id = document.getElementById('nickname').value;
    var parametros = {
        "IdUsuario": id
    };
    $.ajax({
        data: parametros,
        url: "ServletUsuario",
        type: "GET"

    }).done(function (response) {
        var usuarios = response;
        document.getElementById('nickc').innerHTML = usuarios[0].Nickname;
        document.getElementById('nombrec').innerHTML = usuarios[0].Nombre;
        document.getElementById('generosc').innerHTML = usuarios[0].GenerosJuego;
        document.getElementById('descripcionc').innerHTML = usuarios[0].ExperienciaVideojuegos;
    });


}
;


function GuardarCambiosPerfil() {

    var parametros = {
        "IdUsuario": document.getElementById('Nicknamepr').value,
        "Nombre": document.getElementById('Nombrepr').value,
        "FechaNacimiento": "2017-03-01",
        "ExperienciaVideojuegos": document.getElementById('Acercapr').value,
        "HorasPromedioJuego": document.getElementById('Horaspr').value,
        "PlataformasVideojuegos":  "pc",
        "Idiomas": document.getElementById('Idiomapr').value,
        "DiasJuego": document.getElementById('Diaspr').value,
        "HorarioJuego": document.getElementById('Horaspr').value,
        "GenerosJuego": document.getElementById('Generospr').value
    };
    $.ajax({
        data: parametros,
        url: "ServletDatosAdicionalesUsuario",
        type: "POST"

    }).done(function (response) {
        alert(response);
       actualizarPerfil();
    });
}
;