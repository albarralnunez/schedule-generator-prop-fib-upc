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
public class CjtRestriccioAula extends CjtRestriccions{

    private  ArrayList<RestriccioAula> restriccionsAula;

    //Constructora por defecto:
    public CjtRestriccioAula() {
        restriccionsAula = new ArrayList<RestriccioAula>();
    }
    public CjtRestriccioAula(CjtRestriccioAula cjt) {
        restriccionsAula = new ArrayList<RestriccioAula>();
        for(int i = 0; i < cjt.size();++i){
            RestriccioAula ga = cjt.get(i);
            RestriccioAula rg = new RestriccioAula();
            rg.setAula(ga.getAula());
            rg.setDia(ga.getDia());
            rg.setHora(ga.getHora());
            rg.AssignarId(ga.ObtenirId());
            this.restriccionsAula.add(rg);
        }
    }
    //Getters y Setters:
    public ArrayList<RestriccioAula> getRestriccionsAula() {
        return this.restriccionsAula;
    }
    /**
     * 
     * @param restriccions_aula 
     */
    public void setRestriccions_aula(ArrayList<RestriccioAula> restriccions_aula) {
        this.restriccionsAula = restriccions_aula;
    }
    /**
     * 
     * @return 
     */
    public int size(){
         return restriccionsAula.size();
    }
    /**
     * 
     * @param i
     * @return 
     */
    public RestriccioAula get(int i){
      return  restriccionsAula.get(i);
    }
    /**
     * 
     * @param index 
     */
    public void remove(int index){
        restriccionsAula.remove(index);
    }
    /**@pre: La restricció a afeigir ha estat verificada per la clase RestriccioAula
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAUla
     */
    public void afegir_rest(RestriccioAula r) {
        if(esValid(r))restriccionsAula.add(r);
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
    /**
     * Comprova per a cada restriccio del conjunt si la ClausulaNom compleix totes les restriccions
     * @param cn 
     * @param duracio Duracio de la Clausula que conte la ClausulaNom cn
     * @return Retorna un boolean que indica si compleix totes les restriccions 
     */
    boolean ComprovarRes(ClausulaNom cn,int duracio) {
        boolean b = true;
        for (RestriccioAula rga : this.restriccionsAula) {
            if (!b) break;
            if(rga.ObtenirId() == 15) b = rga.compleixRes15(cn,duracio);
            else if(rga.ObtenirId() == 16) b = rga.compleixRes16(cn);
            else if(rga.ObtenirId() == 17) b = rga.compleixRes17(cn,duracio);
        }
        return b; 
    }
    /**
     * 
     * @param r
     * @return 
     */
    boolean conteRestriccio(RestriccioAula r){
        return restriccionsAula.contains(r);
    }
    /**
     * Comprova si la RestriccioAula r, que es vol afegir, està ja en el conjunt de restriccions
     * @param r RestriccioAula que es vol comprovar 
     * @return Retorna un boolean que indica si es valida la insercio de la restriccio 
     */
    private boolean esValid(RestriccioAula r){
        for(RestriccioAula ra : this.restriccionsAula){
            if(r.ObtenirId() == ra.ObtenirId()){
                if(r.getAula().getNom().equals(ra.getAula().getNom()) && r.getHora() == ra.getHora() && r.getDia().equals(ra.getDia())) return false;
            }
        }
        return true;
    }

}
