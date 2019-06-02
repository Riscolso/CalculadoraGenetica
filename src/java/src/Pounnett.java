package src;

import java.util.ArrayList;
import java.util.Arrays;

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
        aux.add(alelo1A+""+alelo1B);
        aux.add(alelo1A+""+alelo2B);
        aux.add(alelo2A+""+alelo1B);
        aux.add(alelo2A+""+alelo2B);
        return aux;
    }
    
    /**
     * Genera una lista de combinaciones dado dos genes (como la multiplicación de binomio pues)
     * @param n Posición del gen de ambos genes de la cual se quiere la combinación.
     * @return combinación de los genes de la posición dada.
     */
    public ArrayList<String> generarCruce(ArrayList<String> a, String b){
        ArrayList<String> aux = new ArrayList<String>();
        for(String s : a){
            aux.add(s+""+b.charAt(0));
            aux.add(s+""+b.charAt(1));
        }
        return aux;
    }
    
    /**
     * Genera la combinación de los genes (Como si estuvieras multiplicando polinomios) <br>
     * n es el cantGenes
     * @return Lista con los cruces de los genes.
     */
    public ArrayList<String> generarCruce(){
        if(cantGenes == 1) return new ArrayList<>(Arrays.asList("A", "B", "a", "b"));
        ArrayList<String> a1 = new ArrayList<>(Arrays.asList("AB", "Ab", "aB", "ab"));
        if(cantGenes == 2) return a1;
        char a = 'a';
        char aux;
        for(int i=2;i<cantGenes;i++){
            aux = (char) (a+i);
            String gen = Character.toUpperCase(aux)+""+aux;
            a1 = generarCruce(a1,gen);
        }
        return a1;
    }
    
    /**
     * Devuelve una probabilidad respecto a un alelo dado tomando en cuanta si el alelo es domante o no.<br>
     * Hace uso de la funcion {@link #generarCruce(int)}
     * @param c Alelo del cual se quiere saber su probabilidad.
     * @param g El cruce de los genes
     * @return Probabilidad del Alelo de ser heredado.
     */
    float probabilidadAlelo(char c, int g){
        float j=0;
        for(String s: generarCruce(g)){
            float p=0, r=0;
            if(Character.isUpperCase(s.charAt(0)) || Character.isUpperCase(s.charAt(1))) p=1;
            if(Character.isUpperCase(c)) r=1;
            if(p+r==2) j++;
            else if(p==r) j++;
        }
        return (float)j/4;
    }
    /**
     * Devuelve una probabilidad de obtener un genotipo respecto a una combinación de genes.<br>
     * Hace uso de la función {@link #probabilidadAlelo(char) }.
     * @param s Combinación de genes
     * @return probabilidad de obtener ese genotipo.
     */
    float probabilidadGenotipo(String s){
        float p=1;
        int i=0;
        for(char c:s.toCharArray()){
            p*=probabilidadAlelo(c, i);
            i++;
        }
        return p;
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
