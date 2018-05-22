
function recomendacionJuegos() {
    $.ajax({
        url: "ServletRecomendacionJuegos",
        type: "GET"

    }).done(function (response) {
        var inventario = response;
        $("#recomendacionesj").empty();
        for (var i in inventario) {
            $("#recomendacionesj").append(
                    '<tr>' +
                    '<td class="text-left" style="color:#000000";>' + inventario[i].Nombre + '</td>' +
                    '<td class="td-actions text-right" style="color:#000000";>' +
                    '<button type="button" rel="tooltip" title="" class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Edit Task">' +
                    '<i class="now-ui-icons ui-1_simple-add"></i>' +
                    '</button>' +
                    '<button type="button" rel="tooltip" title="" class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Remove">' +
                    '<i class="now-ui-icons ui-1_simple-remove"></i>' +
                    '</button>' +
                    '</td>' +
                    '</tr>'
                    );
        }

    }
    );

}
function recomendacionUsuarios(id) {
    var parametros = {
        "IdJuego": id
    };
    $.ajax({
        data:parametros,
        url: "ServletRecomendacionUsuarios",
        type: "GET"

    }).done(function (response) {
        var inventario = response;
        $("#recomendacionesu").empty();
        for (var i in inventario) {
            $("#recomendacionesu").append(
                    '<tr>'+
                    '<td>'+
                    '<bottom>'+
                    '<img class="avatar border-gray" src="assets/img//f.jpg" alt="...">'+
                    '</bottom>'+
                    '</td>'+
                    '<td class="text-left">'+ inventario[i].Nickname +'</td>'+
                    '<td class="td-actions text-right">'+
                    '<button onclick=" buscarperfil(\''+inventario[i].Nickname+'\')"  type="button" rel="tooltip" title="" class="btn btn-info btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Edit Task">'+
                    '<i class="now-ui-icons users_single-02"></i>'+
                    '</button>'+
                    '<button onclick=" AgregarAmigo(\''+inventario[i].Nickname+'\')" type="button" rel="tooltip" title="" class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Remove">'+
                    '<i class="now-ui-icons ui-1_email-85"></i>'+
                    '</button>'+
                    '<button type="button" rel="tooltip" title="" class="btn btn-danger btn-round btn-icon btn-icon-mini btn-neutral" data-original-title="Remove">'+
                    '<i class="now-ui-icons ui-1_simple-remove"></i>'+
                    '</button>'+
                    '</td>'+
                    '</tr>'
                    );
        }

    }
    );

}