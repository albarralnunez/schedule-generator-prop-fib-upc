/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
import java.util.ArrayList;

/**
 *
 * @author Joan Pol
 */
public class Grup {
     private int numero; // id del grupo, donde id >= 0
     private int capacidad; //Numero maximo de alumnos en el grupo, estrictamente positivo
     
     private class combinaciones {
       Aula a;
       int dia;
       int hora;
    }
    ArrayList<combinaciones> l;
     
    public Grup(){
        numero = -1;
        capacidad = -1;
        l = new ArrayList();
    }
    public Grup (int numero,int capacidad, ArrayList l){
        this.numero = numero;
        this.capacidad = capacidad;
        this.l = l;
    }
    public int GetId() {
        return numero;
   }
   public int GetCapacidad() {
        return capacidad;
   }
   public void SetId(int numero){
       this.numero = numero;
   }
   public void SetCapacitat(int capacidad){
       capacidad = capacidad;
   }
    
}
