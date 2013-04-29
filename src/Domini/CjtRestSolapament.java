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
public class CjtRestSolapament extends CjtRestriccions{

    private ArrayList<RestSolapament> restriccions_solapament;

    //Constructora por defecto:
    public CjtRestSolapament() {}

    //Getters y Setters
    public ArrayList<RestSolapament> getRestriccions_solapament() {
        return restriccions_solapament;
    }

    public void setRestriccions_solapament(ArrayList<RestSolapament> restriccions_solapament) {
        this.restriccions_solapament = restriccions_solapament;
    }


    /**@pre: La restricció a afeigir ha estat verificada per la clase RestSolapament
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_solapament
     *
     * @param r Es la restriccio de RestSolapament
     */
    public void afegir_rest(RestSolapament r) {
        restriccions_solapament.add(r);
    }

    /**@pre: La restricció a borrar ha estat verificada per la clase RestSolapament
     * @post: Queda borrada la restriccio a l'arraylist restriccions_solapament
     *
     * @param r Es la restriccio de RestSolapament
     */
    public boolean borrarElem(RestSolapament r) {
        return restriccions_solapament.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestSolapament r) {
        for(RestSolapament r1: this.restriccions_solapament){
                if(r1 == r) return true;
        }
        return false;
    }


}
