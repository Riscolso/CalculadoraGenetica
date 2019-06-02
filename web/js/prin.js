/**
 * Mueestra un elemento
 * @param String elem cadena con el nombre del elemento
 */
function mostrar(elem){
    document.getElementById(elem).style.display = 'block';
}
/**
 * Crea n cantidad de inputs respectoa un número
 * @param int n - cantidad de inputs
 * @returns 
 */
function crearInput(n){
    // Crear nodo de tipo Element
    var parrafo = document.createElement("p");

    // Crear nodo de tipo select
    var select = document.createElement("select");
    select.id = "cb1";
    var miOption=document.createElement("option");
    // Añadimos las propiedades value y label
    miOption.setAttribute("value","1");
    miOption.setAttribute("label","casa");
    miOption.setAttribute("selected","true");
    // Añadimos el option al select
    select.appendChild(miOption);
    // Añadir el nodo Text como hijo del nodo tipo Element
    parrafo.appendChild(select);

    // Añadir el nodo Element como hijo de la pagina
    document.body.appendChild(parrafo);
}