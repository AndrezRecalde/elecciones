/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
            
$.getJSON("Provincia",
    function(data){
        $.each(data.Provincias, function(i,item){
            $("#idprovincia").append("<option value='-1'>PROVINCIA</option>");
            $("#idprovincia").append("<option value='"+item.id+"' selected>"+item.nombre+"</option>");
            
            $.getJSON("Canton" ,{
                //evaluar el id de padres
                id: 8,
                ajax: 'true'
            }
            ,
            function(datax){
                //limpiar el option value
                $("#idparroquia").html("");
                $("#idparroquia").append("<option value='-1'>PARROQUIA</option>");
                $("#idzona").html("");
                $("#idzona").append("<option value='-1'>ZONA</option>");
                $("#idjunta").html("");
                $("#idjunta").append("<option value='-1'>JUNTA</option>");
                $.each(datax.Cantones, function(i,itemx){
                    $("#idcanton").append("<option value='"+itemx.id+"'>"+itemx.nombre+"</option>");
                });
            });
        });
    });
            
$(function(){ 
    //evento change parececido al onchange de javascript que cambia al seleccionar el la provincia
    $("#idprovincia").change(function(){
        if($("#idprovincia").val()!=-1){
            //Observese que la respuesta viene del servlet Hijo
            $.getJSON("Canton" ,{
                //evaluar el id de padres
                id: $(this).val(),
                ajax: 'true'
            }
            ,
            function(data2){
                //limpiar el option value
                $("#idcanton").html("");
                $("#idcanton").append("<option value='-1'>SELECCIONE UN CANTON</option>");
                $("#idparroquia").html("");
                $("#idparroquia").append("<option value='-1'>SELECCIONE UNA PARROQUIA</option>");
                $("#idzona").html("");
                $("#idzona").append("<option value='-1'>SELECCIONE UNA ZONA</option>");
                $("#idrecinto").html("");
                $("#idrecinto").append("<option value='-1'>SELECCIONE UN RECINTO</option>");
                $("#idjunta").html("");
                $("#idjunta").append("<option value='-1'>SELECCIONE UNA JUNTA</option>");
                $.each(data2.Cantones, function(i,item2){
                    $("#idcanton").append("<option value='"+item2.id+"'>"+item2.nombre+"</option>");
                });
            });
        }else{
            $("#idcanton").html("");
            $("#idcanton").append("<option value='-1'>SELECCIONE UN CANTON</option>");
            $("#idparroquia").html("");
            $("#idparroquia").append("<option value='-1'>SELECCIONE UNA PARROQUIA</option>");
            $("#idzona").html("");
            $("#idzona").append("<option value='-1'>SELECCIONE UNA ZONA</option>");
            $("#idrecinto").html("");
            $("#idrecinto").append("<option value='-1'>SELECCIONE UN RECINTO</option>");
            $("#idjunta").html("");
            $("#idjunta").append("<option value='-1'>SELECCIONE UNA JUNTA</option>");
        }
    });
});
            
$(function(){
    //evento change parececido al onchange de javascript que cambia al seleccionar el la parroquia
    $("#idcanton").change(function(){
        if($("#idcanton").val()!=-1){
            //Observese que la respuesta viene del servlet Hijo
            $.getJSON("Parroquia" ,{
                //evaluar el id de padres
                id: $(this).val(),
                ajax: 'true'
            }
            ,
            function(data3){
                //limpiar el option value
                $("#idparroquia").html("");
                $("#idparroquia").append("<option value='-1'>SELECCIONE UNA PARROQUIA</option>");
                $("#idzona").html("");
                $("#idzona").append("<option value='-1'>SELECCIONE UNA ZONA</option>");
                $("#idrecinto").html("");
                $("#idrecinto").append("<option value='-1'>SELECCIONE UN RECINTO</option>");
                $("#idjunta").html("");
                $("#idjunta").append("<option value='-1'>SELECCIONE UNA JUNTA</option>");
                $.each(data3.Parroquias, function(i,item3){
                    $("#idparroquia").append("<option value='"+item3.id+"'>"+item3.nombre+"</option>");
                });
            });
        }else{
            $("#idparroquia").html("");
            $("#idparroquia").append("<option value='-1'>SELECCIONE UNA PARROQUIA</option>");
            $("#idzona").html("");
            $("#idzona").append("<option value='-1'>SELECCIONE UNA ZONA</option>");
            $("#idrecinto").html("");
            $("#idrecinto").append("<option value='-1'>SELECCIONE UN RECINTO</option>");
            $("#idjunta").html("");
            $("#idjunta").append("<option value='-1'>SELECCIONE UNA JUNTA</option>");
        }
    });
});
            
$(function(){
    //evento change parececido al onchange de javascript que cambia al seleccionar el la parroquia
    $("#idparroquia").change(function(){
        if($("#idparroquia").val()!=-1){
            $.getJSON("Zona" ,{
                //evaluar el id de padres
                id: $(this).val(),
                ajax: 'true'
            }
            ,
            function(data4){
                //limpiar el option value
                $("#idzona").html("");
                $("#idzona").append("<option value='-1'>SELECCIONE UNA ZONA</option>");
                $("#idrecinto").html("");
                $("#idrecinto").append("<option value='-1'>SELECCIONE UN RECINTO</option>");
                $("#idjunta").html("");
                $("#idjunta").append("<option value='-1'>SELECCIONE UNA JUNTA</option>");
                $.each(data4.Zonas, function(i,item4){
                    $("#idzona").append("<option value='"+item4.id+"'>"+item4.nombre+"</option>");
                });
            });
                    
            //De paso se cargan los recintos

            $.getJSON("Recinto" ,{
                //evaluar el id de padres
                id: $(this).val(),
                ajax: 'true'
            }
            ,
            function(data5){
                //limpiar el option value
                $.each(data5.Recintos, function(i,item5){
                    $("#idrecinto").append("<option value='"+item5.id+"'>"+item5.nombre+"</option>");
                });
            });
        }else{
            $("#idzona").html("");
            $("#idzona").append("<option value='-1'>SELECCIONE UNA ZONA</option>");
            $("#idrecinto").html("");
            $("#idrecinto").append("<option value='-1'>SELECCIONE UN RECINTO</option>");
            $("#idjunta").html("");
            $("#idjunta").append("<option value='-1'>SELECCIONE UNA JUNTA</option>");
        }
    });
});
            
            
$(function(){
    $("#idrecinto").change(function(){
        if($("#idrecinto").val()!=-1){
            $.getJSON("Junta" ,{
                //evaluar el id de padres
                id: $(this).val(),
                ajax: 'true'
            }
            ,
            function(data5){
                //limpiar el option value
                $("#idjunta").html("");
                $("#idjunta").append("<option value='-1'>SELECCIONE UNA JUNTA</option>");
                $.each(data5.Juntas, function(i,item5){
                    $("#idjunta").append("<option value='"+item5.id+"'>"+item5.nombre+"</option>");
                });
            });
        }else{
            $("#idjunta").html("");
            $("#idjunta").append("<option value='-1'>SELECCIONE UNA JUNTA</option>");
        }
    });
});
            