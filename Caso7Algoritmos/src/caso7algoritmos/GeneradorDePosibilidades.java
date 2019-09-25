/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso7algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author David
 */
public class GeneradorDePosibilidades {
    private ArrayList<Character> alfabeto;
    private ArrayList<Integer> arrayNumeros;
    private ArrayList<Integer> probabilidadLetras;
    private ArrayList<Integer> probabilidadNumeros;
    
    public GeneradorDePosibilidades(){
      this.alfabeto = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
      this.arrayNumeros = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
      this.probabilidadLetras = new ArrayList<>(alfabeto.size());
      this.probabilidadNumeros = new ArrayList<>(arrayNumeros.size());
    }
    
    public void  obtenerProbabilidades(int intentos){
        int i = 0;
        while(i < intentos){
            probarSubSet(arrayNumeros.subList(0, 1),alfabeto.subList(0, 5));
            probarSubSet(arrayNumeros.subList(0, 1),alfabeto.subList(0, 5));
            probarSubSet(arrayNumeros.subList(0, 1),alfabeto.subList(0, 5));
            probarSubSet(arrayNumeros.subList(0, 1),alfabeto.subList(0, 5));
            i++;
        }
        
    }
    
    public void probarSubSet(List<Integer> subNumero, List<Character> subLetra){
        
    }
}
