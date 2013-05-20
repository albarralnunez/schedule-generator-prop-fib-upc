/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;
import java.util.ArrayList;

/**
 *
 * @author albertomarin
 */
public class CjtRestGrupoAula extends CjtRestriccions{

    private ArrayList<RestGrupoAula> restGrupoAula;
    
    //Constructora por defecto:
    public CjtRestGrupoAula() {
        restGrupoAula = new ArrayList<RestGrupoAula>();
    }
    
    //Getters y Setters

    public ArrayList<RestGrupoAula> getRestGrupoAula() {
        return restGrupoAula;
    }

    public void setRestGrupoAula(ArrayList<RestGrupoAula> rest_grupo_aula) {
        this.restGrupoAula = rest_grupo_aula;
    }

    public int size(){
         return restGrupoAula.size();
    }
    public RestGrupoAula get(int i){
      return  restGrupoAula.get(i);
    }
    public void remove(int index){
        restGrupoAula.remove(index);
    }

    /**@pre: La restricció a afeigir ha estat verificada per la clase RestGrupoAula
     * @post: Queda afeigida la restriccio a l'arraylist rest_grupo_aula
     *
     * @param r Es la restriccio de RestGrupoAula
     */
    public void afegirRest(RestGrupoAula r) {
        
        restGrupoAula.add(r);
    }

    /**@pre: La restricció a borrar ha estat verificada per la clase RestGrupoAula
     * @post: Queda borrada la restriccio a l'arraylist rest_grupo_aula
     *
     * @param r Es la restriccio de RestGrupoAula
     */
    public boolean borrarElem(RestGrupoAula r) {
        return restGrupoAula.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestGrupoAula r) {
        for(RestGrupoAula r1: this.restGrupoAula){
                if(r1 == r) return true;
        }
        return false;
    }

    boolean ComprovarRes(Clausula c, Aula au) {
        boolean b = true;
        for (RestGrupoAula rga : this.restGrupoAula) {
            if (!b) break;
            if(rga.ObtenirId() == 1)b = rga.compleixRes1(c, au);
            else if(rga.ObtenirId() == 2) b = rga.compleixRes2(c, au);
        }
        return b;
    }




}
