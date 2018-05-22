function infoJuego(id) {
    Limpiar();
    var parametros = {
        "IdJuego": id
    };
    $.ajax({
        data: parametros,
        url: "ServletInfoJuego",
        type: "GET"

    }).done(function (response) {
        var juegos = response;
        document.getElementById('infojuego').style.display = 'block';
        document.getElementById('IdJuego').style.display = 'none';
        document.getElementById('IdJuego').value = juegos[0].Id;
        document.getElementById('ImagenJuego').src = '' + juegos[0].Imagen;
        document.getElementById('NombreJuego').innerHTML = '' + juegos[0].Nombre;
        document.getElementById('DesarrolladorJuego').innerHTML = 'Desarrollador: ' + juegos[0].Desarrollador;
        document.getElementById('FechaJuego').innerHTML = 'Fecha lanzamiento: ' + juegos[0].FechaLanzamiento;
        document.getElementById('PlataformaJuego').innerHTML = 'Plataforma: ' + juegos[0].Plataforma;
        document.getElementById('GeneroJuego').innerHTML = 'Genero: ' + juegos[0].Genero;
        document.getElementById('IdiomasJuego').innerHTML = 'Idiomas: ' + juegos[0].Idiomas;
        document.getElementById('DescripcionJuego').innerHTML = juegos[0].Descripcion;
        CalificacionJ(id);
    });

    getComentarios(id);
}
;