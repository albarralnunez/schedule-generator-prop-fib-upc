/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Joan Pol
 */
public class Grup {
     private int numero; // id del grupo, donde id >= 0
     private int capacitat; //Numero maximo de alumnos en el grupo, estrictamente positivo
     
    public Grup(){
        numero = -1;
        capacitat = -1;
    }
    public Grup (int numero,int capacidad){
        this.numero = numero;
        this.capacitat = capacidad;
    }
    public int getId() {
        return numero;
   }
   public int getCapacidad() {
        return capacitat;
   }
   public void setId(int numero){
       this.numero = numero;
   }
   public void setCapacitat(int capacidad){
       this.capacitat = capacidad;
   }
    
}
