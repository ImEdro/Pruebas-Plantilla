function infoJuego(id) {
    Limpiar();
    var parametros = {
        "IdJuego": id
    };
    $.ajax({
        data: parametros,
        url: "ServletRecomendacionJuegos",
        type: "GET"

    }).done(function (response) {
        var juegos = response;

        document.getElementById('ImagenJuegoR').src = '' + juegos[0].Imagen;
        document.getElementById('NombreJuegoR').innerHTML = '' + juegos[0].Nombre;
    });

   
}
;