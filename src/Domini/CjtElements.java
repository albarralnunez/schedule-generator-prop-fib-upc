/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author miquel
 */
public class CjtElements {

    private boolean valid;
    private ArrayList<Element> assignacions;

    /**
     * creadora per defecte
     */
    public CjtElements() {
        valid = false;
        assignacions = new ArrayList<Element>();
    }

    /**
     *
     * @param e element a afegir
     */
    public void afegirElement(Element e) {
        assignacions.add(e);
    }

    /**
     *
     * @return si aquell conjunt es valid per fer assignacions
     */
    public boolean isValid() {
        return valid;
    }

    /**
     *
     * @param valid boolea per validar el conjunt
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     *
     * @return
     */
    public ArrayList<Element> getAssignacions() {
        return assignacions;
    }

    /**
     *
     * @param pos
     * @return
     */
    public Element getElementPosicio(int pos) {
        return assignacions.get(pos);
    }

    /**
     *
     * @return el nombre d'elements d'aquell conjunt
     */
    public int numeroElements() {
        return assignacions.size();
    }

    /**
     *
     * comprova si l'aula de l'alement que es passa per parametre no la ocupi ja
     * un altre element del conjunt
     *
     * @param e element
     * @return cert si no es viola la restriccio de aules reetides, fals en el
     * cas que si
     */
    public boolean aulaRepetida(Element e) {
        for (int i = 0; i < assignacions.size(); ++i) {
            if (assignacions.get(i).getAula().equals(e.getAula())) { // es la mateixa aula
                if (!assignacions.get(i).equals(e)) { // i no es el maateix element
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param e
     * @return retorna si d'una assignatura en aquella hora es solapen classes
     * de teoria i pactica
     */
    public boolean solapamentTeoriaPractica(Element e) {
        boolean grupTeoria = false;
        if ((e.getGrupo() % 10) == 0) {
            grupTeoria = true;
        }
        for (int i = 0; i < assignacions.size(); ++i) {
            if (assignacions.get(i).getAssignatura().equals(e.getAssignatura())) { // no es la mateixa assignatura
                if (assignacions.get(i).getGrupo() != e.getGrupo()) { // ni el mateix element
                    int grup = assignacions.get(i).getGrupo();
                    if (grupTeoria) {
                        if (grup % 10 != 0) {
                            return true;
                        }
                    } else { // es grup de lab
                        if (grup % 10 == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /**
     *esborra l'element del conjunt
     * @param e element a esborrar
     */
    public void borrarElement(Element e) {
        assignacions.remove(e);
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean solapamentNivell(Element e) {
        for (int i = 0; i < assignacions.size(); ++i) {
            if (assignacions.get(i).getAssignatura().getNivell()
                    == e.getAssignatura().getNivell()) { // si es el mismo nivel
                if (!assignacions.get(i).equals(e)) { // y no es el mismo elemtno
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param e
     * @return
     */
    public boolean solapamentAssGrupHora(Element e) {
        return true;
    }
}
