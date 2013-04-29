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

    private ArrayList<RestGrupoAula> rest_grupo_aula;
    
    //Constructora por defecto:
    public CjtRestGrupoAula() {}
    
    //Getters y Setters

    public ArrayList<RestGrupoAula> getRest_grupo_aula() {
        return rest_grupo_aula;
    }

    public void setRest_grupo_aula(ArrayList<RestGrupoAula> rest_grupo_aula) {
        this.rest_grupo_aula = rest_grupo_aula;
    }




    /**@pre: La restricció a afeigir ha estat verificada per la clase RestGrupoAula
     * @post: Queda afeigida la restriccio a l'arraylist rest_grupo_aula
     *
     * @param r Es la restriccio de RestGrupoAula
     */
    public void afegir_rest(RestGrupoAula r) {
        rest_grupo_aula.add(r);
    }

    /**@pre: La restricció a borrar ha estat verificada per la clase RestGrupoAula
     * @post: Queda borrada la restriccio a l'arraylist rest_grupo_aula
     *
     * @param r Es la restriccio de RestGrupoAula
     */
    public boolean borrarElem(RestGrupoAula r) {
        return rest_grupo_aula.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestGrupoAula r) {
        for(RestGrupoAula r1: this.rest_grupo_aula){
                if(r1 == r) return true;
        }
        return false;
    }




}
