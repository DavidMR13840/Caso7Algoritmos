/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso7algoritmos;
import java.util.Comparator;

/**
 *
 * @author Sebas Villanueva
 */
class SortByContador implements Comparator<Elemento> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Elemento a, Elemento b) 
    { 
        return a.getContador() - b.getContador(); 
    } 
}
