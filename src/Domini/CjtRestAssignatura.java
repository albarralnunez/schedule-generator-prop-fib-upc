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
public class CjtRestAssignatura extends CjtRestriccions{
   
    private ArrayList<RestAssignatura> restsAssignatura;

    //Constructora por defecto:
    public CjtRestAssignatura() {
        restsAssignatura = new ArrayList();
    }

    //Getters y Setters:
    public ArrayList<RestAssignatura> getRestsAssignatura() {
        return this.restsAssignatura;
    }

    public void setRestsAssignatura(ArrayList<RestAssignatura> restsAssignatura) {
        this.restsAssignatura = restsAssignatura;
    }
    public int size(){
         return restsAssignatura.size();
    }
    public RestAssignatura get(int i){
      return  restsAssignatura.get(i);
    }
    public void remove(int index){
        restsAssignatura.remove(index);
    }

    /**@pre: La restricció a afeigir ha estat verificada per la clase RestriccioAula
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAUla
     */
    public void setRest(RestAssignatura r) {
        restsAssignatura.add(r);
    }
    /**@pre: La restricció a borrar ha estat verificada per la clase RestriccioAula
     * @post: Queda borrada la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAula
     */
    public boolean borrarElem(RestAssignatura r) {
        return restsAssignatura.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestAssignatura r) {
        for(RestAssignatura r1: this.restsAssignatura){
                if(r1.equals(r)) return true;
        }
        return false;
    }
    /**
     * 
     * @param c
     * @param cn
     * @return 
     */
    boolean ComprovarRes(Clausula c, ClausulaNom cn) {
         boolean b = true;
        for (RestAssignatura rga : this.restsAssignatura) {
            if (!b) break;
            b = rga.compleixRes(c, cn);
        }
        return b;
    }
    
}
