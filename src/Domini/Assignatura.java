/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author miquel.masriera
 */
public class Assignatura {
    String nom;
    int horesT; // hores de teoria
    int horesP; // hores de practica 
    int nivel; 
    
    public Assignatura() {
        nom = null;
        horesT = -1;
        horesP = -1;
        nivel = -1;
    }
    
    public Assignatura( String nm, int ht, int hp, int nv) {
        nom = nm;
        horesT = ht;
        horesP = hp;
        nivel = nv;
    }
    
    
}
