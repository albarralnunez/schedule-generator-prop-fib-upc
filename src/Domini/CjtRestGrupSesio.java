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
public class CjtRestGrupSesio extends CjtRestriccions{

    private ArrayList<RestGrupSesio> restriccions_grup_sesio;

    //Constructora por defecto:
    public CjtRestGrupSesio() {
        restriccions_grup_sesio = new ArrayList();
    }

    //Getters y Setters:
    public ArrayList<RestGrupSesio> getRestriccions_grup_sesio() {
        return restriccions_grup_sesio;
    }

    public void setRestriccions_grup_sesio(ArrayList<RestGrupSesio> restriccions_grup_sesio) {
        this.restriccions_grup_sesio = restriccions_grup_sesio;
    }

    /**@pre: La restricció a afeigir ha estat verificada per la clase RestGrupSesio
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_grup_sesio
     *
     * @param r Es la restriccio de RestGrupSesio
     */
    public void afegir_rest(RestGrupSesio r) {
        restriccions_grup_sesio.add(r);
    }
    /**@pre: La restricció a borrar ha estat verificada per la clase RestGrupSesio
     * @post: Queda borrada la restriccio a l'arraylist restriccions_grup_sesio
     *
     * @param r Es la restriccio de RestGrupSesio
     */
    public boolean borrarElem(RestGrupSesio r) {
        return restriccions_grup_sesio.remove(r);
    }
    
    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestGrupSesio r) {
        for(RestGrupSesio r1: this.restriccions_grup_sesio){
                if(r1 == r) return true;
        }
        return false;
    }

}
