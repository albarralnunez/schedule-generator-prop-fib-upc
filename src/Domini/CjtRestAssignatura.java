/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author Joan Pol
 */
public class CjtRestAssignatura extends CjtRestriccions {

    private ArrayList<RestAssignatura> restsAssignatura;

    /**
     *
     */
    public CjtRestAssignatura() {
        restsAssignatura = new ArrayList();
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
        restsAssignatura.add(r);
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
    boolean ComprovarRes(Clausula c, ClausulaNom cn) {
        boolean b = true;
        for (RestAssignatura rga : this.restsAssignatura) {
            if (!b) {
                break;
            }
            if(rga.ObtenirId() == 6) b = rga.compleixRes6(c, cn);
            else if(rga.ObtenirId() == 7) b = rga.compleixRes7(c, cn);
            else if(rga.ObtenirId() == 8) b = rga.compleixRes8(c, cn);
            else if(rga.ObtenirId() == 9) b = rga.compleixRes9(c, cn);
            else if(rga.ObtenirId() == 10) b = rga.compleixRes10(c, cn);
            else if(rga.ObtenirId() == 11) b = rga.compleixRes11(c, cn);
            else if(rga.ObtenirId() == 12) b = rga.compleixRes12(c, cn);
            else if(rga.ObtenirId() == 13) b = rga.compleixRes13(c, cn);
            else if(rga.ObtenirId() == 14) b = rga.compleixRes14(c, cn);
        }
        return b;
    }
}
