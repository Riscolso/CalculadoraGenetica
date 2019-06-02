package src;

import java.util.ArrayList;

public class Pounnett {
    int cantGenes;
    ArrayList<String> genesA = new ArrayList<String>();
    ArrayList<String> genesB = new ArrayList<String>();
    
    public ArrayList<String> generarCruce(int n){
        return genesA;
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
