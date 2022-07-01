/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$.getJSON("Dignidad",
    function(datay){
        $("#iddignidad").append("<option value='-1'>DIGNIDAD</option>");
        $.each(datay.Dignidades, function(i,itemy){
            $("#iddignidad").append("<option value='"+itemy.id+"'>"+itemy.nombre+"</option>");
        });
    });
    
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
                $("#idcanton").html("");
                $("#idcanton").append("<option value='-1'>CANTON</option>");
                $("#idparroquia").html("");
                $("#idparroquia").append("<option value='-1'>PARROQUIA</option>");
                $("#idrecinto").html("");
                $("#idrecinto").append("<option value='-1'>RECINTO</option>");
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
                $("#idcanton").append("<option value='-1'>CANTON</option>");
                $("#idparroquia").html("");
                $("#idparroquia").append("<option value='-1'>PARROQUIA</option>");
                $("#idrecinto").html("");
                $("#idrecinto").append("<option value='-1'>RECINTO</option>");
                $.each(data2.Cantones, function(i,item2){
                    $("#idcanton").append("<option value='"+item2.id+"'>"+item2.nombre+"</option>");
                });
            });
        }else{
            $("#idcanton").html("");
            $("#idcanton").append("<option value='-1'>CANTON</option>");
            $("#idparroquia").html("");
            $("#idparroquia").append("<option value='-1'>PARROQUIA</option>");
            $("#idrecinto").html("");
            $("#idrecinto").append("<option value='-1'>RECINTO</option>");
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
                $("#idparroquia").change(function(){});
                //limpiar el option value
                $("#idparroquia").html("");
                $("#idparroquia").append("<option value='-1'>PARROQUIA</option>");
                $.each(data3.Parroquias, function(i,item3){
                    $("#idparroquia").append("<option value='"+item3.id+"'>"+item3.nombre+"</option>");
                });
                
                //Manejar cambio de id parroquia
                $(function(){
                    //evento change parececido al onchange de javascript que cambia al seleccionar el la parroquia
                    $("#idparroquia").change(function(){
                        if($("#idparroquia").val()!=-1){
                            //Observese que la respuesta viene del servlet Hijo
                            $.getJSON("Recinto" ,{
                                //evaluar el id de padres
                                id: $(this).val(),
                                ajax: 'true'
                            }
                            ,
                            function(data4){
                                //limpiar el option value
                                $("#idrecinto").html("");
                                $("#idrecinto").append("<option value='-1'>RECINTO</option>");
                                $.each(data4.Recintos, function(i,item3){
                                    $("#idrecinto").append("<option value='"+item3.id+"'>"+item3.nombre+"</option>");
                                });
                            });
                        }else{
                            $("#idrecinto").html("");
                            $("#idrecinto").append("<option value='-1'>RECINTO</option>");
                        }
                    });
                });
                //Fin manejo de cambio parroquia
            });
        }else{
            $("#idparroquia").html("");
            $("#idparroquia").append("<option value='-1'>PARROQUIA</option>");
        }
    });
});


