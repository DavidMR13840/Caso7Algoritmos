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
import caso7algoritmos.Elemento;

/**
 *
 * @author David
 */
public class GeneradorDePosibilidades {
    private final ArrayList<Character> alfabeto;
    private final ArrayList<Character> arrayNumeros;
    private ArrayList<Elemento> probabilidadLetras;
    private ArrayList<Elemento> probabilidadNumeros;
    private ArrayList<Character> alfabetoAuxiliar;
    private ArrayList<Integer> numerosAuxiliar; 
    
    public GeneradorDePosibilidades(){
      this.alfabeto = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
      this.arrayNumeros = new ArrayList<>(Arrays.asList('0','1','2','3','4','5','6','7','8','9'));
      this.alfabetoAuxiliar = new ArrayList<>(Arrays.asList('a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'));
      this.numerosAuxiliar = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
      this.probabilidadLetras = new ArrayList<>(26);
      this.probabilidadNumeros = new ArrayList<>(10);
      for(int i = 0; i< 26; i++)
      {
        Elemento aInsertar = new Elemento(alfabeto.get(i));
        this.probabilidadLetras.add(aInsertar);
      }
      
      for(int i = 0; i< 10; i++)
      {
        Elemento aInsertar = new Elemento(arrayNumeros.get(i));
        this.probabilidadNumeros.add(aInsertar);
      }
    }
    
    
    public void  obtenerProbabilidades(int intentos){
        int i = 0;
        while(i < intentos){
            probarSubSet(numerosAuxiliar.subList(0, 2),alfabetoAuxiliar.subList(0, 6)); // llama a probar, entre cuatro subsets de la lista
            probarSubSet(numerosAuxiliar.subList(2, 4),alfabetoAuxiliar.subList(6, 12));
            probarSubSet(numerosAuxiliar.subList(4, 6),alfabetoAuxiliar.subList(12, 18));
            probarSubSet(numerosAuxiliar.subList(6, 10),alfabetoAuxiliar.subList(18, 26));
            
            //reordeno la lista de letras y numeros de manera random
            Collections.shuffle(alfabetoAuxiliar);
            Collections.shuffle(numerosAuxiliar);
            i++;
        }
        
        int p = 0;

        
    }
    
    public List<Elemento> devolverMayores(int num)
    {
      switch(num)
      {
        case 1:
          Collections.sort(this.probabilidadLetras, new SortByContador());
          List<Elemento> top5letras = probabilidadLetras.subList(21, 26);
          return top5letras;
        case 2:
          Collections.sort(this.probabilidadNumeros, new SortByContador());
          List<Elemento> top5nums = probabilidadNumeros.subList(8, 10);
          return top5nums;
      }
      return null;
    }
    
    public void probarSubSet(List<Integer> subNumero, List<Character> subLetra){
        //calculo del porcentaje del subset por probar 
        int porcentajedePruebadelSubset = (subNumero.size() * subLetra.size())/2;   
        
        //arrays para saber si la letra ya fue elegida 
        ArrayList<String> combinacionesProbadas = new ArrayList<>(porcentajedePruebadelSubset);
        Random random = new Random();
        int pruebasRealizadas = 0;//variable para llevar el control de pruebas realizadas
        boolean banderaLLaveCorrecta = false;
        while(pruebasRealizadas < porcentajedePruebadelSubset){
            //seleccion aleatoria de un numero y letra
                int indiceNumeros = random.nextInt(subNumero.size());
                int indiceLetras = random.nextInt(subLetra.size());
                Integer numeroPorProbar = subNumero.get(indiceNumeros);
                char letraPorProbar = subLetra.get(indiceLetras);
                String pruebaActual = letraPorProbar + numeroPorProbar.toString() ;
                if(!combinacionesProbadas.contains(pruebaActual)){//si no es una combinacion de letra y numero ya probada, la prueba
                    combinacionesProbadas.add(pruebaActual);
                    
                    String originalString = "xZwM7BWIpSjYyGFr9rhpEa+cYVtACW7yQKmyN6OYSCv0ZEg9jWbc6lKzzCxRSSIvOvlimQZBMZOYnOwiA9yy3YU8zk4abFSItoW6Wj0ufQ0=";
                    boolean decryptedString = AES.tanteo(letraPorProbar,numeroPorProbar.toString().charAt(0),originalString);
                    
                    if(decryptedString)
                    {
                      
                      banderaLLaveCorrecta = true;
                    }
                    
                    pruebasRealizadas++;
                }
                if (banderaLLaveCorrecta) {
                    for(Character c : subLetra){
                         int indice = alfabeto.indexOf(c);
                         Elemento probabilidadActual = probabilidadLetras.get(indice);
                         probabilidadActual.actualizarContador();
                      }
                      for(Integer n : subNumero){
                          int indice = arrayNumeros.indexOf(n);
                          Elemento probabilidadActual = probabilidadNumeros.get(n);
                          probabilidadActual.actualizarContador();
                      }
                }
            }
        }
    }

