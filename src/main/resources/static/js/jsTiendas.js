
var listTiendas = [];
var contt = document.getElementById("cont_tienda");
//contTiendas();
function contTiendas()
{
    //listTiendas = JSON.parse(${Tienda});
    $("#cont_tiendas").html(listTiendas.length.toString());
}

function ListarTiendas() {
    listTiendas = JSON.parse(localStorage.getItem('Tienda'));
    //guardando el camión de comida en localstorage
    if (typeof (Storage) !== "undefined") {

        if (listTiendas == null) {
            listTiendas = [];
        }

    }

   // alert(listTiendas[0].nombre_tienda);


    contt.value = "1";
    alert(contt.value);
    //$("#cont_tiendas").html(listTiendas.length.toString());

    var html = "";

    for (var i = 0; i < listTiendas.length; i++) {
        html += '<div class="col-sm-4">' +
            '<div class="card text-center mt-5" style="width:20rem; height:23rem;";>' +
            '<div class="card-header text-white bg-dark mb-2">' +
            '<h4 class="text">' + listTiendas[i].nombre_tienda + '</h4>' +
            '</div>' +
            '<div class="card-body">' +
            '<h6 class="card-subtitle mb-3 text-muted">' + listTiendas[i].cod_tienda + '</h6>' +
            '<ul class="list-group list-group-flush">' +
            '<li class="list-group-item">' + listTiendas[i].nombre_dueño + '</li>' +
            '<li class="list-group-item">' + listTiendas[i].descripcion + '</li>' +
            '<li class="list-group-item">' + listTiendas[i].direccion + '</li>' +
            '<li class="list-group-item">' + listTiendas[i].num_tienda + '</li>' +
            '</ul>' +
            '<div class="btnCard">' +
            '<button type="button" class="btn btn-secondary btn-small" onclick="javascript:editarTienda(' + i + ')">Editar</button>' +
            '<button type="button" class="btn btn-danger btn-small" onclick="javascript:eliminarTIendaIndi(' + i + ')">Eliminar</button><br>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>';
    }

    $("#ListarTiendas").append(html);

}

function crearTienda() {


    listTiendas = JSON.parse(localStorage.getItem('tiendas'));

    if (listTiendas == null) {
        listTiendas = [];
    }

    // asignando la identificación automáticamente - siempre será max + 1
    var nextId;
    
    if(localStorage.cod_tienda){
        nextId =Number(localStorage.cod_tienda)+1;
    }else{ 
        nextId = 1;
    }
   
    localStorage.setItem("cod_tienda", nextId);

    // recuperar datos del formulario
    var tienda = new Tiendas(nextId, $("#nombre_tienda").val(), $("#nombre_dueño").val(), $("#num_tienda").val(), $("#descripcion").val(), $("#direccion").val(), $("#foto_tienda").val());

    listTiendas.push(tienda);

    var tiendaslista_Jjon = JSON.stringify(listTiendas);

    localStorage.setItem('tiendas', tiendaslista_Jjon);

    alert("Registro existoso");

   // recargar la pagina
    location.reload();

}

function editarTienda(id) {

    var tiendaEdit = listTiendas[id];

    $("#cod_tienda").val(tiendaEdit.cod_tienda);
    $("#pos_tienda").val(id);
    $("#nombre_tienda").val(tiendaEdit.nombre_tienda);
    $("#nombre_dueño").val(tiendaEdit.nombre_dueño);
    $("#num_tienda").val(tiendaEdit.num_tienda);
    $("#descripcion").val(tiendaEdit.descripcion);
    $("#direccion").val(tiendaEdit.direccion);
    $("#foto_tienda").val(tiendaEdit.foto_tienda);

    $('#cadModal').modal('show');
}


function CrearOEditarTienda() {

  if ($("#cod_tienda").val() !== "") { guardar_EditarTienda(); }
  else { crearTienda(); }

}


function guardar_EditarTienda() {

    var TiendasEdit = new Tiendas ($("#cod_tienda").val(),$("#nombre_tienda").val(), $("#nombre_dueño").val(), $("#num_tienda").val(), $("#descripcion").val(), $("#direccion").val(), $("#foto_tienda").val());

    listTiendas[$("#pos_tienda").val()] = TiendasEdit;

    var tiendaslista_Jjon = JSON.stringify(listTiendas);

    localStorage.setItem('tiendas', tiendaslista_Jjon);

    alert("Modificacion existosa");

    // reseteando valores
    $("#cod_tienda").val(null);
    $("#pos_tienda").val(null);

    //recargar pag
    location.reload();

}


function eliminarTIendaIndi(id) {
    $("#pos_delTienda").val(id);
    $('#eliminarBoton').modal('show');
}


function eliminarTienda() {

    //eliminar del local
    listTiendas.splice($("#pos_delTienda").val(), 1);

    var tiendaslista_Jjon = JSON.stringify(listTiendas);

    localStorage.setItem('tiendas', tiendaslista_Jjon);

    alert("Eliminacion exitosa");

    $("#pos_delTienda").val(null);

    //recargar pag
    location.reload();


}
