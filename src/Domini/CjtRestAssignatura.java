/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author Joan Pol Farre
 */
public class CjtRestAssignatura extends CjtRestriccions {

    private ArrayList<RestAssignatura> restsAssignatura;

    /**
     *
     */
    public CjtRestAssignatura() {
        restsAssignatura = new ArrayList();
    }
    public CjtRestAssignatura(CjtRestAssignatura cjt){
        restsAssignatura = new ArrayList();
        for(int i = 0; i < cjt.size();++i){
            RestAssignatura rga = cjt.get(i);
            RestAssignatura rg = new RestAssignatura();
            rg.setAssignatura(rga.getAssignatura());
            rg.setGrup(rga.getGrup());
            rg.setDia(rga.getDia());
            rg.setHora(rga.getHora());
            rg.AssignarId(rga.ObtenirId());
            this.restsAssignatura.add(rg);
        }
    }
    /**
     *
     * @return
     */
    public ArrayList<RestAssignatura> getRestsAssignatura() {
        return this.restsAssignatura;
    }

    /**
     *
     * @param restsAssignatura
     */
    public void setRestsAssignatura(ArrayList<RestAssignatura> restsAssignatura) {
        this.restsAssignatura = restsAssignatura;
    }

    /**
     *
     * @return
     */
    public int size() {
        return restsAssignatura.size();
    }

    /**
     *
     * @param i
     * @return
     */
    public RestAssignatura get(int i) {
        return restsAssignatura.get(i);
    }

    /**
     *
     * @param index
     */
    public void remove(int index) {
        restsAssignatura.remove(index);
    }

    /**
     * @pre: La restricció a afeigir ha estat verificada per la clase
     * RestriccioAula
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAUla
     */
    public void setRest(RestAssignatura r) {
        if(esValid(r))restsAssignatura.add(r);
    }

    /**
     * @pre: La restricció a borrar ha estat verificada per la clase
     * RestriccioAula
     * @post: Queda borrada la restriccio a l'arraylist restriccions_aula
     *
     * @param r Es la restriccio de RestriccioAula
     */
    public boolean borrarElem(RestAssignatura r) {
        return restsAssignatura.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest
     * tipus y es retorna on booleà indicant el resultat
     *
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestAssignatura r) {
        for (RestAssignatura r1 : this.restsAssignatura) {
            if (r1.equals(r)) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param c
     * @param cn
     * @return
     */
    boolean ComprovarRes(ClausulaNom cn, int duracio) {
        boolean b = true;
        for (RestAssignatura rga : this.restsAssignatura) {
            if (!b) {
                break;
            }
            if(rga.ObtenirId() == 5) b = rga.compleixRes5(cn,duracio);
            else if(rga.ObtenirId() == 6) b = rga.compleixRes6(cn);
            else if(rga.ObtenirId() == 7) b = rga.compleixRes7(cn,duracio);
            else if(rga.ObtenirId() == 8) b = rga.compleixRes8(cn);
            else if(rga.ObtenirId() == 9) b = rga.compleixRes9(cn);
            else if(rga.ObtenirId() == 10) b = rga.compleixRes10(cn);
            else if(rga.ObtenirId() == 11) b = rga.compleixRes11(cn);
            else if(rga.ObtenirId() == 12) b = rga.compleixRes12(cn);
            else if(rga.ObtenirId() == 13) b = rga.compleixRes13(cn,duracio);
        }
        return b;
    }
    private boolean esValid(RestAssignatura r){
        for(RestAssignatura ra: this.restsAssignatura){
            if(ra.ObtenirId() == r.ObtenirId()){
                if(ra.getAssignatura() == r.getAssignatura() && ra.getGrup() == r.getGrup() && ra.getHora() == r.getHora()){
                    if(ra.getDia() == null && r.getDia()== null) return false;
                    else if(ra.getDia() != null && r.getDia() != null){
                        if(ra.getDia().equals(r.getDia())) return false;
                    }
                }
            
            }
        }
        return true;
    }
}
