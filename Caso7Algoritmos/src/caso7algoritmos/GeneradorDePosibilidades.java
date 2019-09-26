/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso7algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import caso7algoritmos.AES;
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
            probarSubSet(arrayNumeros.subList(0, 1),alfabeto.subList(0, 5)); // llama a probar, entre cuatro subsets de la lista
            probarSubSet(arrayNumeros.subList(2, 3),alfabeto.subList(6, 12));
            probarSubSet(arrayNumeros.subList(4, 5),alfabeto.subList(13, 19));
            probarSubSet(arrayNumeros.subList(6, 9),alfabeto.subList(20, 25));
            
            //reordeno la lista de letras y numeros de manera random
            Collections.shuffle(alfabeto);
            Collections.shuffle(arrayNumeros);
            i++;
        }
        
    }
    
    public void probarSubSet(List<Integer> subNumero, List<Character> subLetra){
        //calculo del porcentaje del subset por probar 
        int porcentajedePruebadelSubset = (subNumero.size() * subLetra.size())/2;   
        
        //arrays para saber si la letra ya fue elegida 
        ArrayList<String> combinacionesProbadas = new ArrayList<>(porcentajedePruebadelSubset);
        Random random = new Random();
        int pruebasRealizadas = 0;
        while(pruebasRealizadas < porcentajedePruebadelSubset){
                Integer numeroPorProbar = subNumero.get(random.nextInt(subNumero.size()));
                char letraPorProbar = subLetra.get(random.nextInt(random.nextInt(subLetra.size())));
                String pruebaActual = numeroPorProbar.toString() + letraPorProbar;
                if(!combinacionesProbadas.contains(pruebaActual)){
                    combinacionesProbadas.add(pruebaActual);
   
                    String originalString = "xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
                    boolean decryptedString = AES.tanteo('d','3',originalString);
                    
                    if(decryptedString)
                    {
                      
                    }
                    System.out.println(originalString);
                    System.out.println(decryptedString);
                    pruebasRealizadas++;
                }
        }
    }
}
