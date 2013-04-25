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
    
    public Quadricula(){
        quadricula = new CjtElements[24][7];
        for(int i=0; i < 24; ++i) {
            for (int j=0; j < 7; ++j) {  
                quadricula[i][j] = new CjtElements(); 
            }
        }
    }
    
    public void validar( int fila, int columna){
        quadricula[fila][columna].setValid(true);
    }
}
