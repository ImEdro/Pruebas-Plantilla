//info juegos

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
    recomendacionUsuarios(id);

    getComentarios(id);
}
;

function CalificacionJ(id) {
    
    var parametros = {
        "IdJuego": id
    };
    $.ajax({
        data: parametros,
        url: "ServletCalificacionJuego",
        type: "GET"

    }).done(function (response) {
        var juegos = response;
      
        document.getElementById('promedio').innerHTML ="Calificación: " +juegos[0];

    });

}
;
function CalificacionK() {
    var nick = $("#nickname").val();
    var cal =  $("#numeroCal").val();
    var id = $("#IdJuego").val();
    var parametros = {
        "IdJuego": id,
        "Nickname": nick,
        "Calificacion":cal
    };
    $.ajax({
        data: parametros,
        url: "ServletCalificacionJuego",
        type: "POST"

    }).done(function (response) {
        CalificacionJ(id);
      
       

    });

}
;
function ValorCal(num){
document.getElementById('numeroCal').value = num;
document.getElementById('numeroCal').innerHTML = num;
}

//comentarios
function getComentarios(id) {
    document.getElementById('nicknamecomentario').innerHTML = $("#nickname").val();

    var parametros = {
        "IdJuego": id
    };
    $.ajax({
        data: parametros,
        url: "ServletComentarios",
        type: "GET"

    }).done(function (response) {
        var com = response;

        document.getElementById('Coment').innerHTML = '';
        for (var i in com) {
            $("#Coment").append(
                    '<tr>' +
                    ' <td class="text-left">' + com[i].IdUsuario + '</td>' +
                    ' <td class="text-left">' + com[i].Coment + '</td>' +
                    ' <td class="td-actions text-right">' +
                    ' <button type="button" rel="tooltip" title="" class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Edit Task"  onclick="newLike('+com[i].Id+')">' +
                    ' <i class="now-ui-icons ui-2_like"></i>' +
                    ' </button>' +
                    ' <button type="button" rel="tooltip" title="" class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Remove" onclick="newNoLike('+com[i].Id+')">' +
                    ' <i class="now-ui-icons ui-1_simple-remove" ></i>' +
                    ' </button>' +
                    '</td>' +
                    '<td>' +
                    '<br>' +
                    '<h5 class="card-category" id="c'+com[i].Id+'1" value="-1">-1</h5>' +
                    '<h5 class="card-category" id="c'+com[i].Id+'2" value="-1">-1</h5>' +
                    '</td>'+
                    '</tr>'); 
        }
        for (var i in com) {
             CalificacionComentarios(com[i].Id);
        }
    });
}
;

function CalificacionComentarios(id) {
    var parametros = {
        "IdComentario": id
    };
    $.ajax({
        data: parametros,
        url: "ServletCalificacionComentarios",
        type: "GET"

    }).done(function (response) {
        var com = response;
        $("#c"+id+"1").empty();
        $("#c"+id+"2").empty();
        $("#c"+id+"1").append(com[0]);
        $("#c"+id+"2").append(com[1]);
    });
}
;

function newLike(id){
     var nick= $("#nickname").val();
     var parametros = {
        "NickName":nick,
        "IdComentario": id,
        "Calificacion":"1"
    };
    $.ajax({
        data: parametros,
        url: "ServletCalificacionComentarios",
        type: "POST"

    }).done(function (response) {
        var com = response;
         CalificacionComentarios(id);
    });
}
;

function newNoLike(id){
     var nick= $("#nickname").val();
     var parametros = {
        "NickName":nick,
        "IdComentario": id,
        "Calificacion":"0"
    };
    $.ajax({
        data: parametros,
        url: "ServletCalificacionComentarios",
        type: "POST"

    }).done(function (response) {
        var com = response;
         CalificacionComentarios(id);
    });
}
;

function addComentarios(idj, comentario) {
    var parametros = {
        "IdJuego": idj,
        "Comentario": comentario
    };
    $.ajax({
        data: parametros,
        url: "ServletComentarios",
        type: "POST"

    }).done(function (response) {

        var str1 = "null";
        var ad = str1.localeCompare(response);
        if (ad === 0) {
            ohSnap("error al subir ", {color: 'red'});
        } else {
            getComentarios(idj);
            document.getElementById('textComentario').value = '';
        }
    });

}
;


function obtenerJuego() {
    $.ajax({
        url: "ServletJuegos",
        type: "GET"
    }).done(function (response) {
        var com = response;
        document.getElementById('J').style.display = 'block';
        document.getElementById('SearchCondicional').style.display = 'none';
        document.getElementById('JuegoAgregar').innerHTML = '';
        $("#JuegoAgregar").append(
                '<option value="default">Seleccione Juego</option>'

                );
        for (var i in com) {
            $("#JuegoAgregar").append(
                    '<option value="' + com[i].Id + '">' + com[i].Nombre + '</option>'
                    );
        }
    });
}
;


function AgregarJuego(id) {
    var parametros = {
        "Idjuego": id
    };
    $.ajax({
        data: parametros,
        url: "ServletJuegosUsuario",
        type: "POST"
    }).done(function (response) {
        var str1 = "null";
        var ad = str1.localeCompare(response);
        document.getElementById('J').style.display = 'none';
        document.getElementById('SearchCondicional').style.display = 'block';
        if (ad === 0) {
            ohSnap(" error ", {color: 'red'});
        } else {
            infou();
        }
    });
}
;
