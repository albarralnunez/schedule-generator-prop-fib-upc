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
public class Representador {

    private Quadricula horari;

    //Creadora por defecto:
    public Representador() {}

    //Getters y Setters

    /**
     * @pre: -
     * @post: Retora la Quadrícula horari
     */
    public Quadricula getHorari() {
        return horari;
    }

    /**
    * @pre: horari es una Quadrícula vàlida.
    * @param horari es una Quadricula.
    * @post: L'horari de l'objecte implicit passa a èsser horari.
    */
    public void setHorari(Quadricula horari) {
        this.horari = horari;
    }


    //Cada casilla de la Quadricula es un conjunto de elementos.

    //Mètodos:

    public void imprimir_horario(Quadricula q) {
    /* DEBE IMPRIMIR:
     *
     * DIA : DILLUNS
     * 00:
     * 01:
     *      XC g20 A1
     *      BD g10 A2
     * 02:
     *      XC g20 A1
     *      BD g10 A2
     * 10: ...
     */
        for(int i=0; i < 7; ++i) {
            String dia;
            if (i == 0) dia = "dilluns";
            else if (i == 1) dia = "dimarts";
            else if (i == 2) dia = "dimecres";
            else if (i == 3) dia = "dijous";
            else if (i == 4) dia = "divendres";
            else if (i == 5) dia = "dissabte";
            else dia = "diumenge";

            System.out.println("DIA: "+ dia); //DIA: DILLUNS
            for (int j=0; j < 24; ++j) {
                System.out.println(" "+j+": ");

                //Para cada conjunto de elementos de una posicion...

                CjtElements cjt_elem = new CjtElements();
                cjt_elem = q.getElementsPosicio(dia, j);
                if (cjt_elem.isValid()) { //Si el conjunto de elementos es valido
                    ArrayList<Element> assignacions;
                    assignacions = cjt_elem.getAssignacions();
                    for (Element e1 : assignacions) {
                        //Para cada elemento del conjunto de elementos de esta posicion...
                        Aula a = new Aula();
                        Assignatura ass = new Assignatura();
                        int grupo;
                        a = e1.getAula();
                        ass = e1.getAssignatura();
                        grupo = e1.getGrupo();
                        System.out.println("     "+ass.getNom()+", "+grupo+", "+a.getNom());
                    }
                }
            }
        }
    }

}
