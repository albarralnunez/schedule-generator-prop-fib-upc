/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;
import java.util.ArrayList;

/**
 *
 * @author Alberto Marin
 */
public class CjtRestSolapament extends CjtRestriccions{

    private ArrayList<RestSolapament> restriccionsSolapament;

    //Constructora por defecto:
    public CjtRestSolapament() {
        restriccionsSolapament = new ArrayList();
    }
    public CjtRestSolapament(CjtRestSolapament cjt) {
        restriccionsSolapament = new ArrayList();
        for(int i = 0; i < cjt.size();++i){
            RestSolapament gs = cjt.get(i);
            RestSolapament rg = new RestSolapament();
            rg.setAssignaturaPrincipal(gs.getAssignaturaPrincipal());
            rg.setAssignaturaSolapament(gs.getAssignaturaSolapament());
            rg.setGrupPrincipal(gs.getGrupPrincipal());
            rg.setGrupSolapament(gs.getGrupSolapament());
            rg.AssignarId(gs.ObtenirId());
            this.restriccionsSolapament.add(rg);
        }
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
        if(esValid(r))restriccionsSolapament.add(r);
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
     boolean ComprovarRes(Clausula c, ClausulaNom cn, Clausula e,int h,String dia) {
        boolean b = true;
        for (RestSolapament rga : this.restriccionsSolapament) {
            if (!b) {
                break;
            }
            b = rga.CompleixRes(c, cn, e,h,dia);
        }
        return b;
    }
    /*boolean ComprovarRess(String a,int g,Element e){
       boolean b = true;
        for (RestSolapament rga : this.restriccionsSolapament) {
            if (!b) {
                break;
            }
            b = rga.CompleixRess(a,g, e);
        }
        return b;
        
   }*/
     private boolean esValid(RestSolapament r){
         for(RestSolapament rs : this.restriccionsSolapament){
                 boolean b =rs.getAssignaturaPrincipal().getNom().equals(r.getAssignaturaPrincipal().getNom());
                 boolean b1 = rs.getGrupPrincipal() == r.getGrupPrincipal();
                 boolean b2 = rs.getAssignaturaSolapament().getNom().equals(r.getAssignaturaSolapament().getNom());
                 boolean b3 = rs.getGrupSolapament() == r.getGrupSolapament();
                 boolean b4 = rs.getAssignaturaPrincipal().getNom().equals(r.getAssignaturaSolapament().getNom());
                 boolean b5 = rs.getGrupPrincipal() == r.getGrupSolapament();
                 boolean b6 = rs.getAssignaturaSolapament().getNom().equals(r.getAssignaturaPrincipal().getNom());
                 boolean b7 = rs.getGrupSolapament() == r.getGrupPrincipal();
                 if((b && b1 && b2 && b3)||(b4 && b5 && b6 && b7)) return false;
         }
         return true;
     }
}

