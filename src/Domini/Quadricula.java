/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.io.Serializable;

/**
 *
 * @author Miquel Masriera
 */
public class Quadricula implements Serializable {
    
    private CjtElements quadricula[][];
    
    /**
     * Obtenir la quadricula
     * @return Retorna la quadricula
     */
    public CjtElements[][] getQuadricula() {
        return quadricula;
    }
    
    /**
     * Afegeix un element a la quadricula
     * @param dia Dia en el que s'afagira l'element
     * @param hora Hora en que s'afegira l'element
     * @param e Element que es vol afegir
     */
    public void afegirElement(String dia, int hora, Element e) {
        int i;
        if (dia.equals("dilluns")) i = 0;
        else if (dia.equals("dimarts")) i = 1;
        else if (dia.equals("dimecres")) i = 2;
        else if (dia.equals("dijous")) i = 3;
        else if (dia.equals("divendres")) i = 4;
        else if (dia.equals("dissabte")) i = 5;
        else i = 6;
        quadricula[i][hora].afegirElement(e);
    }
  
    /**
     * Obtenir els elements de un dia i una hora
     * @param dia Dia del que volem obtenir els elements
     * @param hora Hora de la qual volem obtenir els elements
     * @return 
     */
      public CjtElements getElementsPosicio(String dia, int hora){
        int i;
        if (dia.equals("dilluns")) i = 0;
        else if (dia.equals("dimarts")) i = 1;
        else if (dia.equals("dimecres")) i = 2;
        else if (dia.equals("dijous")) i = 3;
        else if (dia.equals("divendres")) i = 4;
        else if (dia.equals("dissabte")) i = 5;
        else i = 6;
        return quadricula[i][hora];
      }
    /**
     * Borra un element de un dia i una hora
     * @param dia Dia del que volem borrar el element
     * @param hora Hora en la que volem borrar el element
     * @param e Element que volem borrar
     */
    public void borrarElement(String dia, int hora, Element e) {

        int i;
        if (dia.equals("dilluns")) i = 0;
        else if (dia.equals("dimarts")) i = 1;
        else if (dia.equals("dimecres")) i = 2;
        else if (dia.equals("dijous")) i = 3;
        else if (dia.equals("divendres")) i = 4;
        else if (dia.equals("dissabte")) i = 5;
        else i = 6;
        quadricula[i][hora].borrarElement(e);

    }
    /**
     * Constructora per defecte
     */
    public Quadricula(){
        quadricula = new CjtElements[7][24];
        for(int i=0; i < 7; ++i) {
            for (int j=0; j < 24; ++j) {  
                quadricula[i][j] = new CjtElements(); 
            }
        }
    }
    /**
     * Valida la posicio fila columna de la quadricula
     * @param fila Fila que volem validar
     * @param columna Columna que volem validar
     */
    public void validar( int fila, int columna){
        quadricula[fila][columna].setValid(true);
        
    }
    
}
