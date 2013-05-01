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

    private ArrayList<RestGrupSessio> restriccions_grup_sesio;

    //Constructora por defecto:
    public CjtRestGrupSessio() {
        restriccions_grup_sesio = new ArrayList();
    }

    //Getters y Setters:
    public ArrayList<RestGrupSessio> getRestriccions_grup_sesio() {
        return restriccions_grup_sesio;
    }

    public void setRestriccions_grup_sesio(ArrayList<RestGrupSessio> restriccions_grup_sesio) {
        this.restriccions_grup_sesio = restriccions_grup_sesio;
    }
    public int size(){
         return restriccions_grup_sesio.size();
    }
    public RestGrupSessio get(int i){
      return  restriccions_grup_sesio.get(i);
    }
    public void remove(int index){
        restriccions_grup_sesio.remove(index);
    }
    /**@pre: La restricció a afeigir ha estat verificada per la clase RestGrupSessio
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_grup_sesio
     *
     * @param r Es la restriccio de RestGrupSessio
     */
    public void afegir_rest(RestGrupSessio r) {
        restriccions_grup_sesio.add(r);
    }
    /**@pre: La restricció a borrar ha estat verificada per la clase RestGrupSessio
     * @post: Queda borrada la restriccio a l'arraylist restriccions_grup_sesio
     *
     * @param r Es la restriccio de RestGrupSessio
     */
    public boolean borrarElem(RestGrupSessio r) {
        return restriccions_grup_sesio.remove(r);
    }
    
    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestGrupSessio r) {
        for(RestGrupSessio r1: this.restriccions_grup_sesio){
                if(r1 == r) return true;
        }
        return false;
    }

    boolean afegeixRestriccio(RestGrupSessio rgs) {
        for( int i = 0; i < restriccions_grup_sesio.size(); ++i){
            if (restriccions_grup_sesio.get(i) == rgs ){
                System.out.println("igual");
                return false;
            }
            
        }
        afegir_rest(rgs);
        return true;
    }

    boolean ComprovarRes(Clausula c, ClausulaNom cn) {
        boolean b = true;
        for( RestGrupSessio gs : restriccions_grup_sesio){
            String dia = cn.getDia();
            int i;
            if (dia.equals("dilluns")) i = 0;
            else if (dia.equals("dimarts")) i = 1;
            else if (dia.equals("dimecres")) i = 2;
            else if (dia.equals("dijous")) i = 3;
            else if (dia.equals("divendres")) i = 4;
            else if (dia.equals("dissabte")) i = 5;
            else i = 6;
            
            if ( gs.CompleixRes( c.getAssignatura().getNom(), c.getGrup(), i, cn.getHora() )) return true;
            else b = false;
        }
        return b;
    }

}
