$(document).ready(function () {
    noticias();
});
function noticias() {
    $.ajax({
        url: "ServletNoticia",
        type: "GET"

    }).done(function (response) {
        var inventario = response;
        $("#noticias1").show();
        $("#noticias").show();
        $("#noticias").empty();
        for (var i in inventario) {
            $("#noticias").append(
                    '<div class="col-lg-4" >' +
                    '<div class="card card-chart" >'+
                    '<div class="card-header" >'+
                                    '<h5 class="card-category">Noticia</h5>'+
                                    '<h4  class="card-title" style="color:#000000";>'+ inventario[i].Titulo +'</h4>'+
                                    '  <div class="dropdown" >'+
                                        '<div class="dropdown-menu dropdown-menu-right" >'+
                                            '<a class="dropdown-item" href="#">Action</a>'+
                                            '<a class="dropdown-item" href="#">Another action</a>'+
                                            '<a class="dropdown-item" href="#">Something else here</a>'+
                                            '<a class="dropdown-item text-danger" href="#">Remove Data</a>'+
                                        '</div>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="card-body" width="1000" height="1000">'+
                                '<p align="justify" style="color:#000000";><span>' + inventario[i].Texto + '</span></p>' +
                                
                                    '<div class="chart-area">'+
                                        '<center>'+
                                        '<img src="' + inventario[i].Imagen + '"width="90%" height="100%" >'+
                                        '</center>'+
                                    '</div>'+
                                '</div>'+
                                '<div class="card-footer">'+
                                    '<div class="stats">'+
                                        '<i class="now-ui-icons arrows-1_refresh-69"></i> Just Updated'+
                                    '</div>'+
                                '</div>'
                    );
        }
    });
}