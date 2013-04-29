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

    //Constructora por defecto:
    public CjtRestriccioAula() {}

    //Getters y Setters:
    public ArrayList<RestriccioAula> getRestriccions_aula() {
        return this.restriccions_aula;
    }

    public void setRestriccions_aula(ArrayList<RestriccioAula> restriccions_aula) {
        this.restriccions_aula = restriccions_aula;
    }


    /**@pre: La restricció a afeigir ha estat verificada per la clase RestriccioAula
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAUla
     */
    public void afegir_rest(RestriccioAula r) {
        restriccions_aula.add(r);
    }
    /**@pre: La restricció a borrar ha estat verificada per la clase RestriccioAula
     * @post: Queda borrada la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAula
     */
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
