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

    private ArrayList<RestSolapament> restriccionsSolapament;

    //Constructora por defecto:
    public CjtRestSolapament() {
        restriccionsSolapament = new ArrayList();
    }

    //Getters y Setters
    public ArrayList<RestSolapament> getRestriccionsSolapament() {
        return restriccionsSolapament;
    }

    public void setRestriccionsSolapament(ArrayList<RestSolapament> restriccions_solapament) {
        this.restriccionsSolapament = restriccions_solapament;
    }
    public int size(){
         return restriccionsSolapament.size();
    }
    public RestSolapament get(int i){
      return  restriccionsSolapament.get(i);
    }
    public void remove(int index){
        restriccionsSolapament.remove(index);
    }
    /**@pre: La restricció a afeigir ha estat verificada per la clase RestSolapament
     * @post: Queda afeigida la restriccio a l'arraylist restriccionsSolapament
     *
     * @param r Es la restriccio de RestSolapament
     */
    public void afegirRest(RestSolapament r) {
        restriccionsSolapament.add(r);
    }

    /**@pre: La restricció a borrar ha estat verificada per la clase RestSolapament
     * @post: Queda borrada la restriccio a l'arraylist restriccionsSolapament
     *
     * @param r Es la restriccio de RestSolapament
     */
    public boolean borrarElem(RestSolapament r) {
        return restriccionsSolapament.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestSolapament r) {
        for(RestSolapament r1: this.restriccionsSolapament){
                if(r1 == r) return true;
        }
        return false;
    }
     /*boolean ComprovarRes(Clausula c, ClausulaNom cn, Clausula e,int h,String dia) {
        boolean b = true;
        for (RestSolapament rga : this.restriccionsSolapament) {
            if (!b) {
                break;
            }
            b = rga.CompleixRes(c, cn, e,h,dia);
        }
        return b;
    }*/
    boolean ComprovarRess(String a,int g,Element e){
       boolean b = true;
        for (RestSolapament rga : this.restriccionsSolapament) {
            if (!b) {
                break;
            }
            b = rga.CompleixRess(a,g, e);
        }
        return b;
        
   }

}
