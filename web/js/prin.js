/**
 * Mueestra un elemento
 * @param String elem cadena con el nombre del elemento
 */
function mostrar(elem){
    document.getElementById(elem).style.display = 'block';
}
/**
 * Crea n cantidad de inputs respectoa un nÃºmero
 * @param int n - cantidad de inputs
 * @returns 
 */
function crearInput(){
    var n = parseInt(document.getElementById('txt1').value);
    // Crear nodo de tipo Element
    var parrafo = document.getElementById('genes')  //document.createElement("p");
    var i; //iterador
    var select;
    var optArray = [];
    var textArray = [];
    // Crear nodo de tipo select
    //Genes de A
    for(i=0;i<n;i++){
        select = document.createElement("select");
        select.name = "cb"+i;
        optArray.push(document.createElement("option"));
        // Añadimos las propiedades value y label
        optArray[3*i].setAttribute("value", ((i+10).toString(36)).toUpperCase() +  ((i+10).toString(36)).toUpperCase());
        optArray[3*i].setAttribute("label","casa");
        optArray[3*i].appendChild(document.createTextNode(((i+10).toString(36)).toUpperCase() +  ((i+10).toString(36)).toUpperCase()));
        optArray[3*i].setAttribute("selected","true");
        
        optArray.push(document.createElement("option"));
        // Añadimos las propiedades value y label
        optArray[(3*i)+1].setAttribute("value", ((i+10).toString(36)).toUpperCase() + (i+10).toString(36));
        optArray[(3*i)+1].setAttribute("label","casa");
        optArray[(3*i)+1].appendChild(document.createTextNode(((i+10).toString(36)).toUpperCase() + (i+10).toString(36)));
        
        optArray.push(document.createElement("option"));
        // Añadimos las propiedades value y label
        optArray[(3*i)+2].setAttribute("value",(i+10).toString(36) + (i+10).toString(36));
        optArray[(3*i)+2].setAttribute("label","casa");
        optArray[(3*i)+2].appendChild(document.createTextNode((i+10).toString(36) + (i+10).toString(36)));
        
        
        // Añadimos el option al select
        select.appendChild(optArray[3*i]);
        select.appendChild(optArray[(3*i)+1]);
        select.appendChild(optArray[(3*i)+2]);
        
        // Añadir el nodo Text como hijo del nodo tipo Element
        parrafo.appendChild(select);
    }
    
    parrafo.appendChild(document.createElement('br'));
    parrafo.appendChild(document.createTextNode("X"))
    parrafo.appendChild(document.createElement('br'));
    
      
    
    
    
    //Genes de B
                  
    for(i=n;i<(2*n);i++){
        select = document.createElement("select");
        select.name = "cb"+i;
        optArray.push(document.createElement("option"));
        // Añadimos las propiedades value y label
        optArray[3*i].setAttribute("value", ((i+10-n).toString(36)).toUpperCase() +  ((i+10-n).toString(36)).toUpperCase());
        optArray[3*i].setAttribute("label","casa");
        optArray[3*i].appendChild(document.createTextNode(((i+10-n).toString(36)).toUpperCase() +  ((i+10-n).toString(36)).toUpperCase()));
        optArray[3*i].setAttribute("selected","true");
        
        optArray.push(document.createElement("option"));
        // Añadimos las propiedades value y label
        optArray[(3*i)+1].setAttribute("value", ((i+10-n).toString(36)).toUpperCase() + (i+10-n).toString(36));
        optArray[(3*i)+1].setAttribute("label","casa");
        optArray[(3*i)+1].appendChild(document.createTextNode(((i+10-n).toString(36)).toUpperCase() + (i+10-n).toString(36)));
        
        optArray.push(document.createElement("option"));
        // Añadimos las propiedades value y label
        optArray[(3*i)+2].setAttribute("value",(i+10-n).toString(36) + (i+10-n).toString(36));
        optArray[(3*i)+2].setAttribute("label","casa");
        optArray[(3*i)+2].appendChild(document.createTextNode((i+10-n).toString(36) + (i+10-n).toString(36)));
        
        
        // Añadimos el option al select
        select.appendChild(optArray[3*i]);
        select.appendChild(optArray[(3*i)+1]);
        select.appendChild(optArray[(3*i)+2]);
        
        // Añadir el nodo Text como hijo del nodo tipo Element
        parrafo.appendChild(select);
    }   
                
    // Añadir el nodo Element como hijo de la pagina
    //document.getElementById('genes').appendChild(parrafo);
    //document.body.appendChild(parrafo); 
}