/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projecte;

/**
 *
 * @author toni
 */

public abstract class Objecte {
    private int x;
    private int y;
    private int id;
    private String nom;
    
    //fer objecte nostre amb estil textura color
    //creadora buida
    Objecte() {
    }
    //creadora passant-li els 2 valors
    public Objecte(int x, int y) {
        this.x = x;
        this.y = y;
    }
    //consultar amplada o longitud
    //consultar i no mostrar!!!!!!!!!1
    public int ConsultarX() {
        return x;
    }
    public int ConsultarY() {
        return y;
    }
    //modificar valors amplada/longitud d'un objecte
    public void ModificarX(int x) {
        this.x = x;
    }
    public void ModificarY(int y) {
        this.y = y;
    }
    public void ModificarId(int id) {
        this.id = id;
    }
    public int ConsultarId() {
        return id;
    }
    public void Rotar() {
        int auxx = this.x;
        this.x = this.y;
        this.y = auxx;
    }
    public String ConsultarNom() {
        return this.nom;
    }
    public void ModificarNom(String nom) {
        this.nom = nom;
    }
}
