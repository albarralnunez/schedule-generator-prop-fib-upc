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
public class CjtRestriccioAula extends CjtRestriccions{

    private ArrayList<RestriccioAula> restriccions_aula;


    public ArrayList<RestriccioAula> getRestriccions_aula() {
        return this.restriccions_aula;
    }

    public void setRestriccions_aula(ArrayList<RestriccioAula> restriccions_aula) {
        this.restriccions_aula = restriccions_aula;
    }


    /**@pre: La restricció a afeigir ha estat verificada per la clase RestGrupSesio
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_grup_sesio
     *
     * @param r Es la restriccio de RestGrupSesio
     */
    public void afegir_rest(RestriccioAula r) {
        restriccions_aula.add(r);
    }

    public boolean borrarElem(RestriccioAula r) {
        return restriccions_aula.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestriccioAula r) {
        for(RestriccioAula r1: this.restriccions_aula){
                if(r1 == r) return true;
        }
        return false;
    }


}
