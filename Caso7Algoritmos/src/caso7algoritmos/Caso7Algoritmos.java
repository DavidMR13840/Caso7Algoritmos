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
        
        System.out.println("Existe un 70% de probabilidad de que la respuesta se encuentre en las siguientes 2 listas: ");
        System.out.println("Lista letras: ");
        for(int i =0; i < top5letras.size();i++)
        {
          System.out.println(top5letras.get(i)+" ");
        }
        System.out.println("Lista numeros: ");
        for(int i =0; i < top5nums.size();i++)
        {
          System.out.println(top5nums.get(i)+" ");
        }
        
    }    
}
