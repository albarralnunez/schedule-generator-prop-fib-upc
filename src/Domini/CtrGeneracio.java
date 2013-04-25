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
    
    public CtrGeneracio( String nomU ){
        nomUnitat = nomU;
        resT = new RestriccioTemps();
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
        return asg;
    }

    
    public Horari generarHorari(String a) {
        Generador g = new Generador();
        inicialitzarCjtAulesTeo();
        inicialitzarCjtAulesLab();
        inicialitzarCjtAssignatures();
        //inicialitazRestT(a);
        return g.generar(cjtAulTeo,cjtAulLab,cjtAs, resT);
    }
    
    
    
    
    
    
    
    
}
