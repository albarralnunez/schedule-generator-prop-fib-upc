/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author alejandro.martinez.romero
 */
public class CjtRestriccions {
    
    //Atributs
    ArrayList<Restriccio> cjtRes;
    
    //Constructora
    
    /**
     * Crea una instancia de la classe CjtRestriccions
     */
    CjtRestriccions(){
        cjtRes = new ArrayList();
    }
    
    //Metodes
    
    /**
    * S'afegeix la restricció R del conjunt de restriccions.
    * @param R Es la restriccio que volem afegir
    */
    public void AfegirRes(Restriccio R){
        cjtRes.add(R);
    }
    
    /**
    * S'esborra la restricció R del conjunt de restriccions.
    * @param R Es la restriccio que volem eliminar
    */
    public void BorrarRes(Restriccio R){
        try{
            cjtRes.remove(R);
        }
        catch(NullPointerException ex){
            ex.getMessage();
        }
    }
    
    /**
    * Es comprova si totes les restriccions especificades per a l'habitació es compleixen.
    */
    public boolean ComprovarRes(){
        try{
            for(Restriccio R: cjtRes){
                if(!R.CompleixRes()) return false;
            }
            return true;
        }
        catch(NullPointerException ex){
            ex.getMessage();
        }
        return false;
    }
}
