/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

function valida_Text(element)
{
    var i, buskeda = 0, buscando = document.getElementById(element);
    for (i = 0; i <= buscando.value.length; i++)
    {
        if (isNaN(buscando.value))
        {
            buskeda += 1;
        }
    }
    if (buskeda >= 1)
    {
        alert("No inserte letras");
        buscando.focus();
    } else {
        if (buscando.value < 0) {
            alert("No inserte numeros negativos.");
            buscando.focus();
        }
        if (element == "txt_total_votos") {
            calcula_Total();
        }
    }
}


function calcula_Total()
{
    var v1 = parseInt(document.getElementById("txt_votos_blanco").value);
    var v2 = parseInt(document.getElementById("txt_votos_nulos").value);
    var v3 = parseInt(document.getElementById("txt_no_votaron").value);
    var v4 = parseInt(document.getElementById("txt_total_votos").value);
    document.getElementById("txt_no_votaron").value = 350 - v4;
}

function verifica_acta(total_candidatos, num_cand_lista)
{
    document.getElementById("aceptar").disabled = true;
    var select_cuadrada = document.getElementById("txt_es_cuadrada").checked;
    var v1 = parseInt(document.getElementById("txt_votos_blanco").value);
    var v2 = parseInt(document.getElementById("txt_votos_nulos").value);
    var v3 = parseInt(document.getElementById("txt_no_votaron").value);
    var v4 = parseInt(document.getElementById("txt_total_votos").value);
    var acu = 0;

    //No vacíos
    if (document.getElementById('txt_total_votos').value == '') {
        alert('Por favor ingrese el total de huellas o firmas.');
        document.getElementById("aceptar").disabled = false;
        return;
    }
    if (document.getElementById('txt_votos_blanco').value == '') {
        alert('Por favor ingrese el total de votos en blanco.');
        document.getElementById("aceptar").disabled = false;
        return;
    }
    if (document.getElementById('txt_votos_nulos').value == '') {
        alert('Por favor ingrese el total de votos nulos.');
        document.getElementById("aceptar").disabled = false;
        return;
    }
    for (i = 1; i <= total_candidatos; i++)
    {
        if (document.getElementById(i).value == '') {
            document.getElementById(i).value='0';
        }
    }
    //Fin no vacíos

    for (i = 1; i <= total_candidatos; i++)
    {
        acu = acu + parseInt(document.getElementById(i).value);
        //Maximo de 350
        if (parseInt(document.getElementById(i).value) > 350) {
            alert('Existe un valor mayor que 350.');
            return;
        }
    }
    //Si el acta esta cuadrada.
    var cuadrada = true;
    if (num_cand_lista == 1) {
        cuadrada = (v4 - v1 - v2) == acu; //unipersonales
    } else {
        cuadrada = (acu) <= ((v4 - v1 - v2) * num_cand_lista); //pluripersonales
    }

    if (cuadrada) {
        if (select_cuadrada) {
            //Si el check esta como cuadrada.
            document.getElementById("form1").submit();
        } else {
            //Si el check esta como no cuadrada.
            alert("Marque esta acta como cuadrada!");
            //No puede superar 350

            document.getElementById("aceptar").disabled = false;
        }
    } else {
        //Si el acta no esta cuadrada.
        if (!select_cuadrada) {//Si el check esta como no cuadrado
            document.getElementById("form1").submit();
        } else {
            alert("Marque esta acta como NO cuadrada!");
            document.getElementById("aceptar").disabled = false;
        }
    }
}
