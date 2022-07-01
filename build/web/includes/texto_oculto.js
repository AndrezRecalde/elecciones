/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/*************Texto Oculto DQ******************/

function hiddenText(iid,value,classname)
{
document.getElementById(iid).value=value;
document.getElementById(iid).className=classname;
}
function displayText(iid,value,classname)
{
if(document.getElementById(iid).value =="")
{
document.getElementById(iid).value=value;
document.getElementById(iid).className=classname;
}
}