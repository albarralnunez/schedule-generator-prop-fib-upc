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
    
    boolean conteRestriccio(RestriccioAula r){
        return restriccionsAula.contains(r);
    }
    private boolean esValid(RestriccioAula r){
        for(RestriccioAula ra : this.restriccionsAula){
            if(r.ObtenirId() == ra.ObtenirId()){
                if(r.getAula().getNom().equals(ra.getAula().getNom()) && r.getHora() == ra.getHora() && r.getDia().equals(ra.getDia())) return false;
            }
        }
        return true;
    }

}
