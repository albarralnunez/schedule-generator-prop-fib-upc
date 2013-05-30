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
public class CjtRestGrupoAula extends CjtRestriccions{

    private ArrayList<RestGrupoAula> restGrupoAula;
    
    //Constructora por defecto:
    public CjtRestGrupoAula() {
        restGrupoAula = new ArrayList<RestGrupoAula>();
    }
    public CjtRestGrupoAula(CjtRestGrupoAula cjt) {
        restGrupoAula = new ArrayList<RestGrupoAula>();
        for(int i = 0; i < cjt.size();++i){
            RestGrupoAula gs = cjt.get(i);
            RestGrupoAula rg = new RestGrupoAula();
            rg.setAssignatura(gs.getAssignatura());
            rg.setGrup(gs.getGrup());
            rg.setAula(gs.getAula());
            rg.AssignarId(gs.ObtenirId());
            this.restGrupoAula.add(rg);
        }
    }
    //Getters y Setters

    public ArrayList<RestGrupoAula> getRestGrupoAula() {
        return restGrupoAula;
    }
    /**
     * 
     * @param rest_grupo_aula 
     */
    public void setRestGrupoAula(ArrayList<RestGrupoAula> rest_grupo_aula) {
        this.restGrupoAula = rest_grupo_aula;
    }
    /**
     * 
     * @return 
     */
    public int size(){
         return restGrupoAula.size();
    }
    /**
     * 
     * @param i
     * @return 
     */
    public RestGrupoAula get(int i){
      return  restGrupoAula.get(i);
    }
    /**
     * 
     * @param index 
     */
    public void remove(int index){
        restGrupoAula.remove(index);
    }

    /**@pre: La restricció a afeigir ha estat verificada per la clase RestGrupoAula
     * @post: Queda afeigida la restriccio a l'arraylist rest_grupo_aula
     *
     * @param r Es la restriccio de RestGrupoAula
     */
    public void afegirRest(RestGrupoAula r) {
       if(esValid(r)) restGrupoAula.add(r);
    }

    /**@pre: La restricció a borrar ha estat verificada per la clase RestGrupoAula
     * @post: Queda borrada la restriccio a l'arraylist rest_grupo_aula
     *
     * @param r Es la restriccio de RestGrupoAula
     */
    public boolean borrarElem(RestGrupoAula r) {
        return restGrupoAula.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest tipus y es retorna on booleà indicant el resultat
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestGrupoAula r) {
        for(RestGrupoAula r1: this.restGrupoAula){
                if(r1 == r) return true;
        }
        return false;
    }
    /**
     * Comprova si la Aula de una ClausulaNom compleix les restriccions
     * @param au
     * @return Retorna un boolean indican si compleix totes les restriccions
     */
    boolean ComprovarRes(Aula au) {
        boolean b = true;
        for (RestGrupoAula rga : this.restGrupoAula) {
            if (!b) break;
            if(rga.ObtenirId() == 1)b = rga.compleixRes1(au);
            else if(rga.ObtenirId() == 2) b = rga.compleixRes2(au);
        }
        return b;
    }
    /**
     * Comprova si la restriccio r, que es vol afegir, existeix en el conjunt
     * @param r 
     * @return Retorna un boolean que indica si es pot fer la insercio
     */
    private boolean esValid(RestGrupoAula r){
        for(RestGrupoAula rga: this.restGrupoAula){
            if(rga.ObtenirId() == r.ObtenirId()){
                if(rga.getAssignatura().equals(r.getAssignatura()) && rga.getGrup().equals(r.getGrup()) && rga.getAula().equals(r.getAula())) return false;
            }
        }
        return true;
    }

}
