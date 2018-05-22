

function top10() {
    $.ajax({
        url: "ServletTop",
        type: "GET"

    }).done(function (response) {
        var inventario = response;
        document.getElementById('top').innerHTML = '';
        document.getElementById('top').value = '';
        for (var i = 0; i < 5; i++) {
            $("#top").append(
                    '<tr >' +
                    '<td class="text-left" style="color:#000000";>' +
                    inventario[i].Nombre +
                    '</td>' +
                    '<td  class="text-right" style="color:#000000";>' +
                    inventario[i].Calificacion +
                    '</td>' +
                    '</tr>'

                    );
        }

    });
}
;
