/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;
//TODO: se ha de programar todo.
import java.util.ArrayList;

/**
 *
 * @author Daniel Albarral
 */
class CjtAssignatures {
    
   private ArrayList<Assignatura> cjtAssignatures;
    
   
    public CjtAssignatures(){ 
        cjtAssignatures = new ArrayList<Assignatura>();
    }
    
    public ArrayList<Assignatura> getCjtAssignatures() {
        return this.cjtAssignatures;
    }

    public void afegirAssignatures(  ArrayList<Assignatura> assigs){
       cjtAssignatures = assigs;
    }
    

    public boolean esborrarAssignatures( /*Aula aula*/ ArrayList<Assignatura> assigs) {
        if(assigs.isEmpty()) return false;
        else{
            int size = assigs.size();
            for(int i = 0; i < size; ++i) cjtAssignatures.remove(assigs.get(i));
            return true;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void afegirAssignatura( /*AulaLab a*/Assignatura a) {
        cjtAssignatures.add(a);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ArrayList<Assignatura> getAssignatures(){
        return cjtAssignatures;
    }
}