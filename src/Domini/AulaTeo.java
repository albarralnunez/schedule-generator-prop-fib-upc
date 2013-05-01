/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel
 */
public class AulaTeo extends Aula {

    private boolean projector;

    /**
     *
     * @param nom nom de l'aula
     * @param cap capacitat
     * @param projector si te projector o no
     */
    public AulaTeo(String nom, int cap, boolean projector) {
        super(nom, cap);
        this.projector = projector;
    }

    /**
     *
     */
    public AulaTeo() {
        super();
        this.projector = false; //La creadora por defecto pone projector a false;
    }

    /**
     *
     * @return Retorna si l'aula te projector.
     */
    public boolean getProjector() {
        return projector;
    }

    /**
     *
     * @param projector.
     */
    public void setProjector(boolean projector) {
        this.projector = projector;
    }
}
