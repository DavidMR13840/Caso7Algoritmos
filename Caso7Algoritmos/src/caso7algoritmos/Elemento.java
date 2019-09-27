/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caso7algoritmos;

/**
 *
 * @author Sebas Villanueva
 */
public class Elemento {
  private char Simbolo;
  private int contador;
  
  Elemento(char s)
  {
    this.Simbolo = s;
    this.contador = 0;
  }
  
  public void actualizarContador()
  {
    this.contador++;
  }
  
  public int getContador()
  {
    return this.contador;
  }
  
  public String toString()
  {
    return Character.toString(Simbolo);
  }
}
