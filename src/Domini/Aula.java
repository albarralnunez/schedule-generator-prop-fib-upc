    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel Albarral
 */
public class Aula {

    private String nom;
    private int capacitat;

    /**
     * Crea un Aula.
     */
    public Aula() {
        nom = null;
        capacitat = -1;
    }//end constructor Studentwqdsae

    /**
     * Crea un Aula inicialitzada.
     */
    public Aula(String nom, int cap) {
        this.nom = nom;
        this.capacitat = cap;
    }

    /**
     * @return Retorna el nom de l'aula
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @return Retorna la capacitat d'un Aula
     */
    public int getCapacitat() {
        return capacitat;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @param capacitat
     */
    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    /**
     *
     * @param x
     * @return Retorna si l'aula te una capacitat major d'x.
     */
    public boolean capacitatMajorDe(int x) {
        return (capacitat >= x);
    }
}
