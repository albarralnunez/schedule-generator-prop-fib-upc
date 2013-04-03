/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini
;

/**
 *
 * @author alex
 */
public class Restriccio {
    
        //Atributs
        int id;
        boolean compleix;
        
        //Constructora
	
	/**
        * Crea una instancia de la classe Restriccio.
        * @param ID Es l'identificador associat a la restriccoi que acabem de crear. 
        */
	public Restriccio(int ID){
		id = ID;
	}
        //Metodes
        
        /**
        * Retorna l'identificador de la restriccio
        */
        public int ObtenirId(){
            return id;
        }
        
        /**
        * S'assigna un identificador a una restriccio.
        * @param ID Es l'identificador que volem assignar a la restriccio
        */
        public void AssignarId(int ID){
            id = ID;
        }
        
        /**
        * Retorna el boolea que indica si es compleix o no la restriccio.
        */
        public boolean Compleix(){
            return compleix;
        }
        
        /**
        * Funcio que cada restriccio especifica implementa per a saber si es compleix.
        */
        public void CompleixRes(){
        }
}
