
function buscarperfil(id) {
    
    Limpiar();
    document.getElementById('InfoPerfilBuscar').style.display = 'block';
    var parametros = {
        "IdUsuario": id
    };
    $.ajax({
        data: parametros,
        url: "ServletUsuario",
        type: "GET"

    }).done(function (response) {
        var usuarios = response;
        document.getElementById('nickpu').innerHTML = usuarios[0].Nickname;
        document.getElementById('nickpu').value = usuarios[0].Nickname;
        document.getElementById('nombrepu').innerHTML = usuarios[0].Nombre;
        document.getElementById('generospu').innerHTML = usuarios[0].GenerosJuego;
        document.getElementById('descripcionpu').innerHTML = usuarios[0].ExperienciaVideojuegos;
    });
}
;
