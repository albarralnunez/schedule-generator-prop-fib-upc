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
public class CtrGeneracio {
    
    private RestriccioTemps resT;
    private ArrayList<AulaLab> cjtAulLab;
    private ArrayList<AulaTeo> cjtAulTeo;
    private ArrayList<Assignatura> cjtAs;
    private String nomUnitat;
    private Quadricula quad;
    private Generador gen;
    
    
    /**
     *
     * @param nomU
     */
    public CtrGeneracio( String nomU ){
        nomUnitat = nomU;
        resT = new RestriccioTemps();
        quad = new Quadricula();
        cjtAulLab = new ArrayList<AulaLab>();
        cjtAulTeo = new ArrayList<AulaTeo>();
        cjtAs= new ArrayList<Assignatura>();
        gen = new Generador();
       // cper = new CtrPersistencia();
        
        
    }

    public void inicialitzarGenerador(ArrayList<String> confHoraria, ArrayList<Assignatura> assignatures, ArrayList<AulaLab> aulesL, 
       ArrayList<AulaTeo> aulesT ){
       montaRestriccionsTemps(confHoraria); // inicalitza rest de temps + quadricula
       
       this.cjtAs = assignatures;
       this.cjtAulLab = aulesL;
       this.cjtAulTeo = aulesT;
    }
    
    public boolean generar() {
        return gen.generar(cjtAulTeo, cjtAulLab, cjtAs, resT, quad);
    }
    /**
     *
     * @param conf
     */
    public void montaRestriccionsTemps( ArrayList<String> conf ){
        ArrayList<Integer> dl = new ArrayList<Integer>();
        ArrayList<Integer> dm = new ArrayList<Integer>();
        ArrayList<Integer> dc = new ArrayList<Integer>();
        ArrayList<Integer> dj = new ArrayList<Integer>();
        ArrayList<Integer> dv = new ArrayList<Integer>();
        ArrayList<Integer> ds = new ArrayList<Integer>();
        ArrayList<Integer> dg = new ArrayList<Integer>();
        String dia = null;
        for( int fila = 0; fila < conf.size(); ++fila ){
            
            String linia = conf.get(fila);
            
            if( linia.contains("dilluns") || linia.contains("dimarts") || linia.contains("dimecres")
            || linia.contains("dijous") || linia.contains("divendres") || linia.contains("dissabte") 
            || linia.contains("diumenge") ) {
                dia = linia;
            } 
            else{
                int hora = Integer.parseInt( linia );
                if( dia.contains("dilluns") ){
                    dl.add(hora);
                    quad.validar(0, hora);
                }
                else if( dia.contains("dimarts") ) {
                    dm.add(hora);
                    quad.validar(1, hora);
                }
                else if( dia.contains("dimecres") ) {
                    dc.add(hora);
                    quad.validar(2, hora);
                }
                else if( dia.contains("dijous") ) {
                    dj.add(hora);
                    quad.validar(3, hora);
                }
                else if( dia.contains("divendres") ) {
                    dv.add(hora);
                    quad.validar(4, hora);
                }
                else if( dia.contains("dissabte") ) {
                    ds.add(hora);
                    quad.validar(5, hora);
                }
                else if ( dia.contains("diumenge")) {
                    dg.add(hora);
                    quad.validar(6, hora);
                }
            }
        }
       resT.setDilluns(dl);
       resT.setDimarts(dm);
       resT.setDimecres(dc);
       resT.setDijous(dj);
       resT.setDivendres(dv);
       resT.setDissabte(ds);
       resT.setDiumenge(dg);
    }
    

    
}
