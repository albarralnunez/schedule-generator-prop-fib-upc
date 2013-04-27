/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import Persistencia.CtrPersistencia;
import java.util.ArrayList;

/**
 *
 * @author miquel
 */
public class CtrGeneracio {
    
    private RestriccioTemps resT;
    private CjtAules cjtAulLab;
    private CjtAules cjtAulTeo;
    private CjtAssignatures cjtAs;
    private String nomUnitat;
    private CtrPersistencia cper;
    private Quadricula quad;
    
    public CtrGeneracio( String nomU ){
        
        nomUnitat = nomU;
        resT = new RestriccioTemps();
        quad = new Quadricula();
        cjtAulLab = new CjtAules();
        cjtAulTeo = new CjtAules();
        cjtAs= new CjtAssignatures();
        cper = new CtrPersistencia();
        
        
    }
    
    //TODO: Hay que depurar solo inicializar las seleccionads por user
    
    private void inicialitzarCjtAulesLab() {
        ArrayList<String> llistAules = cper.llistaAulesLab(nomUnitat);
        for(String nom : llistAules){
           nom = nom.replace("aula-lab-", "");
           nom = nom.replace(".txt", "");
           ArrayList<String> atributs = cper.llegirAulaLab(nom);
           boolean b;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           else b = false;
           AulaLab a = new AulaLab(nom,Integer.parseInt (atributs.get(2)),b);
           cjtAulLab.afegirAula(a);
        }
    }
    
    private void inicialitzarCjtAulesTeo() {
        
        ArrayList llistAules = cper.llistaAulesTeo(nomUnitat);
        for (int i = 0; i < llistAules.size(); ++i) {
           Object nomO = llistAules.get(i);
           String nom = nomO.toString();
           nom = nom.replace("aula-teo-", "");
           nom = nom.replace(".txt", "");
           ArrayList<String> atributs = cper.llegirAulaTeo(nom);
           boolean b;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           else b = false;
           AulaTeo a = new AulaTeo(nom,Integer.parseInt (atributs.get(2)),b);
           cjtAulTeo.afegirAula(a);
        }
    }
    
    
    private void inicialitzarCjtAssignatures() { //TODO Acabar esto cuando assignatura este escrito en disco
      ArrayList<String> llistAssignatures = cper.llistaAssigantures(nomUnitat);
        for(String nom : llistAssignatures){
            cjtAs.afegirAssignatura(montaAssignatura(nom)); 
        }
    }
    
    
      /**
     *  li passes el nom d'una assignatura i et retorna una instancia de la
     * assignatura que esta guardada en un txt amb aquell nom 
     * (ha d existir)
     * @param nomAsg
     * @return 
     */
    public Assignatura montaAssignatura( String nomAsg ){
        Assignatura asg = new Assignatura();
        nomAsg = nomAsg.replace("assig-", "");
        nomAsg = nomAsg.replace(".txt", "");
        ArrayList<String> atributs = cper.llegirAssignatura(nomAsg);
        String nom = atributs.get(0);      
        int nvl = Integer.parseInt(atributs.get(1));
        int numht = Integer.parseInt( atributs.get(2) );
        int numint =  Integer.parseInt( atributs.get(3) );
        ArrayList<Integer> intersT = new ArrayList<Integer>(numint); 
        int contador = numint+4;
        for( int i = 4; i < numint+4  ; ++i ){
            int interval = Integer.parseInt(atributs.get(i));
            intersT.add( interval );
        }
        int numhp = Integer.parseInt( atributs.get(contador) );
        int contadorip =  Integer.parseInt( atributs.get( ++contador) );
        contador = contador + contadorip;
        ArrayList<Integer> intersP = new ArrayList<Integer>(contadorip); 
        for( int i = contador-contadorip+1; i < contador; ++i){
            int interval = Integer.parseInt(atributs.get(i));
            intersP.add( interval );
        }
        int capt = Integer.parseInt( atributs.get( ++contador) );
        int capp = Integer.parseInt( atributs.get( ++contador) );
        
        int numGrupos = atributs.size()-contador-1;
        ArrayList<Integer> grupos = new ArrayList<Integer>( numGrupos );
        for( int i = 0; i < numGrupos; ++i ){
            int g = Integer.parseInt(atributs.get(++contador));
            grupos.add( g );
        }
        asg = new Assignatura( nom, nvl, numht, intersT, numhp, intersP, capt, capp, grupos );
        return asg;
    }

    
    public void generarHorari(ArrayList<String> a) {
        Generador g = new Generador();
        inicialitzarCjtAulesTeo();
        inicialitzarCjtAulesLab();
        inicialitzarCjtAssignatures();
        montaRestriccionsTemps(a);
        quad = g.generar(cjtAulTeo,cjtAulLab,cjtAs, resT,quad);
    }
    
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
