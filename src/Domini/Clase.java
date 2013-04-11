/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

/**
 *
 * @author albertomarin
 */
public class Clase {

    private Aula aula;
    private Integer duracion;
    private Assignatura assig;


    public Clase() {
        duracion = -1;
        aula = null;
        assig = null;
    }

    public Clase(Aula aula, Integer duracion, Assignatura assig) {
        this.duracion = duracion;
        this.aula = aula;
        this.assig = assig;
    }

    public Assignatura getAssig() {
        return assig;
    }

    public Aula getAula() {
        return aula;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setAssig(Assignatura assig) {
        this.assig = assig;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }




}
