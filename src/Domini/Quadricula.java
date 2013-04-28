/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author miquel
 */
public class Quadricula {
    
    private CjtElements quadricula[][];

    public CjtElements[][] getQuadricula() {
        return quadricula;
    }
    
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
    
    public Quadricula(){
        quadricula = new CjtElements[7][24];
        for(int i=0; i < 7; ++i) {
            for (int j=0; j < 24; ++j) {  
                quadricula[i][j] = new CjtElements(); 
            }
        }
    }
    
    public void validar( int fila, int columna){
        quadricula[fila][columna].setValid(true);
        
    }
    
    
}
