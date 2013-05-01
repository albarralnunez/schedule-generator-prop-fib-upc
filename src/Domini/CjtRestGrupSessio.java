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
public class CjtRestGrupSessio extends CjtRestriccions {

    private ArrayList<RestGrupSessio> restriccionGrupSessio;

    /**
     *
     */
    public CjtRestGrupSessio() {
        restriccionGrupSessio = new ArrayList();
    }

    /**
     *
     * @return
     */
    public ArrayList<RestGrupSessio> getRestriccions_grup_sesio() {
        return restriccionGrupSessio;
    }

    /**
     *
     * @param restriccions_grup_sesio
     */
    public void setRestriccions_grup_sesio(ArrayList<RestGrupSessio> restriccions_grup_sesio) {
        this.restriccionGrupSessio = restriccions_grup_sesio;
    }

    /**
     *
     * @return
     */
    public int size() {
        return restriccionGrupSessio.size();
    }

    /**
     *
     * @param i
     * @return
     */
    public RestGrupSessio get(int i) {
        return restriccionGrupSessio.get(i);
    }

    /**
     *
     * @param index
     */
    public void remove(int index) {
        restriccionGrupSessio.remove(index);
    }

    /**
     * @pre: La restricció a afeigir ha estat verificada per la clase
     * RestGrupSessio
     * @post: Queda afeigida la restriccio a l'arraylist restriccions_grup_sesio
     *
     * @param r Es la restriccio de RestGrupSessio
     */
    public void afegir_rest(RestGrupSessio r) {
        restriccionGrupSessio.add(r);
    }

    /**
     * @pre: La restricció a borrar ha estat verificada per la clase
     * RestGrupSessio
     * @post: Queda borrada la restriccio a l'arraylist restriccions_grup_sesio
     *
     * @param r Es la restriccio de RestGrupSessio
     */
    public boolean borrarElem(RestGrupSessio r) {
        return restriccionGrupSessio.remove(r);
    }

    /**
     * Es busca la restriccio del tipus en el conjunt de restriccions d'aquest
     * tipus y es retorna on booleà indicant el resultat
     *
     * @param r
     * @return true si hem trobat l'element o false en cas contrari.
     */
    public boolean buscarElem(RestGrupSessio r) {
        for (RestGrupSessio r1 : this.restriccionGrupSessio) {
            if (r1 == r) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param rgs
     * @return
     */
    boolean afegeixRestriccio(RestGrupSessio rgs) {
        for (int i = 0; i < restriccionGrupSessio.size(); ++i) {
            if (restriccionGrupSessio.get(i) == rgs) {
                System.out.println("igual");
                return false;
            }

        }
        afegir_rest(rgs);
        return true;
    }

    /**
     *
     * @param c
     * @param cn
     * @return
     */
    boolean ComprovarRes(Clausula c, ClausulaNom cn) {
        boolean b = true;
        for (RestGrupSessio gs : restriccionGrupSessio) {
            String dia = cn.getDia();
            int i;
            if (dia.equals("dilluns")) {
                i = 0;
            } else if (dia.equals("dimarts")) {
                i = 1;
            } else if (dia.equals("dimecres")) {
                i = 2;
            } else if (dia.equals("dijous")) {
                i = 3;
            } else if (dia.equals("divendres")) {
                i = 4;
            } else if (dia.equals("dissabte")) {
                i = 5;
            } else {
                i = 6;
            }
            if (gs.CompleixRes(c.getAssignatura().getNom(), c.getGrup(), i, cn.getHora())) {
                return true;
            } else {
                b = false;
            }
        }
        return b;
    }
}
