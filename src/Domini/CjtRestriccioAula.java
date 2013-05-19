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

    private  ArrayList<RestriccioAula> restriccionsAula;

    //Constructora por defecto:
    public CjtRestriccioAula() {
        restriccionsAula = new ArrayList<RestriccioAula>();
    }

    //Getters y Setters:
    public ArrayList<RestriccioAula> getRestriccionsAula() {
        return this.restriccionsAula;
    }

    public void setRestriccions_aula(ArrayList<RestriccioAula> restriccions_aula) {
        this.restriccionsAula = restriccions_aula;
    }
    public int size(){
         return restriccionsAula.size();
    }
    public RestriccioAula get(int i){
      return  restriccionsAula.get(i);
    }
    public void remove(int index){
        restriccionsAula.remove(index);
    }
    /**@pre: La restricció a afeigir ha estat verificada per la clase RestriccioAula
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAUla
     */
    public void afegir_rest(RestriccioAula r) {
        restriccionsAula.add(r);
    }
    /**@pre: La restricció a borrar ha estat verificada per la clase RestriccioAula
     * @post: Queda borrada la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAula
     */
    public boolean borrarElem(RestriccioAula r) {
        return restriccionsAula.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestriccioAula r) {
        for(RestriccioAula r1: this.restriccionsAula){
                if(r1 == r) return true;
        }
        return false;
    }

    boolean ComprovarRes(Clausula c, ClausulaNom cn) {
        boolean b = true;
        for (RestriccioAula rga : this.restriccionsAula) {
            if (!b) break;
            if(rga.ObtenirId() == 13) b = rga.compleixRes13(c, cn);
            else if(rga.ObtenirId() == 14) b = rga.compleixRes14(c, cn);
            else if(rga.ObtenirId() == 15) b = rga.compleixRes15(c, cn);
        }
        return b; 
    }
    
    boolean conteRestriccio(RestriccioAula r){
        return restriccionsAula.contains(r);
    }


}
