package src;

import java.util.ArrayList;

public class Pounnett {
    int cantGenes;
    ArrayList<String> genesA = new ArrayList<String>();
    ArrayList<String> genesB = new ArrayList<String>();
    
    /**
     * Genera una lista de combinaciones del cuadro de Punnett dado un número de gen
     * @param n Posición del gen de ambos genes de la cual se quiere la combinación.
     * @return combinación de los genes de la posición dada.
     */
    public ArrayList<String> generarCruce(int n){
        ArrayList<String> aux = new ArrayList<String>();
        char alelo1A = genesA.get(n).charAt(0);
        char alelo2A = genesA.get(n).charAt(1);
        char alelo1B = genesB.get(n).charAt(0);
        char alelo2B = genesB.get(n).charAt(1);
        aux.add(alelo1A+alelo1B+"");
        aux.add(alelo1A+alelo2B+"");
        aux.add(alelo2A+alelo1B+"");
        aux.add(alelo2A+alelo2B+"");
        return aux;
    }
    
    public ArrayList<String> generarCruce(){
        return genesA;
    }
    
    float probabilidadAlelo(char c){
        return (float)1.2;
    }
    
    float probabilidadGenotipo(String s){
        return (float)1.2;
    }

    public int getCantGenes() {
        return cantGenes;
    }

    public void setCantGenes(int cantGenes) {
        this.cantGenes = cantGenes;
    }

    public ArrayList<String> getGenesA() {
        return genesA;
    }

    public void setGenesA(ArrayList<String> genesA) {
        this.genesA = genesA;
    }

    public ArrayList<String> getGenesB() {
        return genesB;
    }

    public void setGenesB(ArrayList<String> genesB) {
        this.genesB = genesB;
    }
    
    
}
