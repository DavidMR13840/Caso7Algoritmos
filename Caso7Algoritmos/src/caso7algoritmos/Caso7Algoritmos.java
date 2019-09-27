/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso7algoritmos;
import caso7algoritmos.GeneradorDePosibilidades;
import java.util.List;
/**
 *
 * @author David
 */
public class Caso7Algoritmos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorDePosibilidades gen = new GeneradorDePosibilidades();
        gen.obtenerProbabilidades(12);
        List<Elemento> top5letras = gen.devolverMayores(1);
        List<Elemento> top5nums = gen.devolverMayores(2);
        //Existe un 80% de probabilidad de que la respuesta se encuentre en esas 2 listas
    }
    
}
