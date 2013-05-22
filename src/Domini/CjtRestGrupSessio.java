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
public class CjtRestGrupSessio extends CjtRestriccions{

    private ArrayList<RestGrupSessio> restriccionsGrupSesio;

    //Constructora por defecto:
    public CjtRestGrupSessio() {
        restriccionsGrupSesio = new ArrayList();
    }

    //Getters y Setters:
    public ArrayList<RestGrupSessio> getRestriccionsGrupSesio() {
        return restriccionsGrupSesio;
    }

    public void setRestriccionsGrupSesio(ArrayList<RestGrupSessio> restriccions_grup_sesio) {
        this.restriccionsGrupSesio = restriccions_grup_sesio;
    }
    public int size(){
         return restriccionsGrupSesio.size();
    }
    public RestGrupSessio get(int i){
      return  restriccionsGrupSesio.get(i);
    }
    public void remove(int index){
        restriccionsGrupSesio.remove(index);
    }
    /**@pre: La restricció a afeigir ha estat verificada per la clase RestGrupSessio
     * @post: Queda afeigida la restriccio a l'arraylist restriccionsGrupSesio
     *
     * @param r Es la restriccio de RestGrupSessio
     */
    public void afegir_rest(RestGrupSessio r) {
        restriccionsGrupSesio.add(r);
    }
    /**@pre: La restricció a borrar ha estat verificada per la clase RestGrupSessio
     * @post: Queda borrada la restriccio a l'arraylist restriccionsGrupSesio
     *
     * @param r Es la restriccio de RestGrupSessio
     */
    public boolean borrarElem(RestGrupSessio r) {
        return restriccionsGrupSesio.remove(r);
    }
    
    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestGrupSessio r) {
        for(RestGrupSessio r1: this.restriccionsGrupSesio){
                if(r1 == r) return true;
        }
        return false;
    }

    boolean afegeixRestriccio(RestGrupSessio rgs) {
        for( int i = 0; i < restriccionsGrupSesio.size(); ++i){
            if (restriccionsGrupSesio.get(i) == rgs ){
                System.out.println("igual");
                return false;
            }
            
        }
        afegir_rest(rgs);
        return true;
    }

    boolean ComprovarRes(Clausula c, ClausulaNom cn) {
        boolean b = true;
        for( RestGrupSessio gs : restriccionsGrupSesio){
            if(!b) break;
            if(gs.ObtenirId() == 3) b = gs.CompleixRes3(c,cn);
            else if(gs.ObtenirId() == 4) b= gs.CompleixRes4(c,cn);
            else if(gs.ObtenirId() == 5) b= gs.CompleixRes5(c,cn);
        }
        return b;
    }

}
