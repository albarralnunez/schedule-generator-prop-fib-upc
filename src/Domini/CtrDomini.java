/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import Persistencia.CtrPersistencia;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author miquelmasrieraquevedo
 */
public class CtrDomini {
    
    CtrPersistencia cper;
    String nomUnitat;
    Scanner sc;
    
    public CtrDomini( String nomU ){
       
        nomUnitat = nomU;
        cper = new CtrPersistencia(); 
    }


   /*
    * Crea una assigatura (  un arxiu .txt amb tota la info)
    * nom de l arxiu (unitat docent)-(assignatura)-(nom assignatura)
    * 
    * ara nomes posa el nom pero tenen que posarse i validar tots
    * els parametres
    */
    public void creaAssignatura( String nomAsg, int ht, int hp, int nivel,int capTeo,int capLab,ArrayList a ){ 
            ArrayList params = new ArrayList();
            params.add(nomAsg);
            params.add(ht);
            params.add(hp);
            params.add(nivel);
            params.add(capTeo);
            params.add(capLab);
            for(int i = 0; i < a.size(); ++i) params.add(a.get(i));
            cper.creaAssignatura(nomUnitat+"-"+nomAsg , params);
    }
   
    /**
     * 
     * @param nomAsg
     * @return 
     */
    public boolean esborraAssignatura( String nomAsg){         
        String nom = nomUnitat+"-"+nomAsg;
        return( cper.esborraAssignatura(nom) );
        
    }
    /**
     * 
     * @return 
     */
    public ArrayList llistaAssignatures(){
        return cper.llistaAssigantures(nomUnitat);
    }

    public boolean existeixAssignatura(String nomAsg) {
        return cper.existeixAssignatura(nomUnitat+"-"+nomAsg);
    }

    public void printAssig( String nomaAsg){ //TODO: Toda la informaicon!
        ArrayList<String> atributs = cper.llegirAssignatura(nomUnitat+"-"+nomaAsg);
        String n = atributs.get(0);
        int nt = Integer.parseInt(atributs.get(1));
        int np = Integer.parseInt(atributs.get(2));
        int nv = Integer.parseInt(atributs.get(3));
        System.out.println("els valors actuals de "+n+" son \n hteoria="+nt+"\n hpractica="+np+"\n nivel="+nv);
        //Assignatura a = new Assignatura( atributs.get(0), nt, np, nv );
    }
    
    public ArrayList<String> llegirAssignatura( String nomAsg){
        return cper.llegirAssignatura(nomUnitat+"-"+nomAsg);
    }
    
    /**
     * Crea un Aula
     * @param nomAula
     * @param capacitat
     * @param teoria, si l'aula es de teoria el valor de teoria = 1, else = 0.
     * @param boo, if (teoria == 1) boo = Si te de projector else Si te de material.
     */
    public void creaAula(String nomAula,  int capacitat, int teoria, int boo){ 
            ArrayList params = new ArrayList();
            params.add(teoria);
            params.add(nomAula);
            params.add(capacitat);
            params.add(boo);
            if (teoria == 1) cper.creaAulaTeo(nomUnitat+"-"+nomAula , params);
            else cper.creaAulaLab(nomUnitat+"-"+nomAula , params);
    }
    /**
     * TODO:TEMPORAL!
     * Escriu un Aula per terminal  
     * @param nomAula 
     */
    public void printAula( String nomAula){
        ArrayList<String> atributs = cper.llegirAula(nomUnitat+"-"+nomAula);
        int t = Integer.parseInt(atributs.get(0));
        String n = atributs.get (1);
        int c = Integer.parseInt (atributs.get(2));
        int b = Integer.parseInt (atributs.get(3));
        if (t == 1) System.out.println("\nl'aula es de teoria");
        else System.out.println("\nl'aula es de laboratori");
        System.out.println("els valors actuals de "+n+" son \n capacitat="+c);
        if (t==1 && b==1) System.out.println(" te projector\n");
        if (t==1 && b==0) System.out.println(" no te projector\n");
        if (t==0 && b==1) System.out.println(" te material\n");
        if (t==0 && b==0) System.out.println(" no te material\n");
    }
    
    /**
     * 
     * @return Retorna una llista de totes les aules dispobibles.
     */
    public ArrayList llistaAules(){
        return cper.llistaAules(nomUnitat);
    }
    
     /**
     * 
     * @return Retorna una llista de totes les aules dispobibles.
     */
    public ArrayList llistaAulesTeo(){
        return cper.llistaAulesTeo(nomUnitat);
    }
    
    /**
     * 
     * @return Retorna una llista de totes les aules dispobibles.
     */
    public ArrayList llistaAulesLab(){
        return cper.llistaAulesLab(nomUnitat);
    }
    
    /**
     * 
     * @param nomAula
     * @return Llegeix l'aula amb nom nomAula.
     */
    public ArrayList<String> llegirAula( String nomAula){
        return cper.llegirAula(nomUnitat+"-"+nomAula);
    }
    
    /**
     * 
     * @param nomAula
     * @return Retorna si existeix l'aula amb nom nomAula
     */
    public boolean existeixAula(String nomAula) {
        return cper.existeixAula(nomUnitat+"-"+nomAula);
    }

    /**
     * 
     * @param nomAula
     * @return  Retorna si es pot esborrar l'aula amb nom nomAula.
     */
    public boolean esborraAula( String nomAula){         
        return(cper.esborraAula(nomUnitat+"-"+nomAula));
    }

    public CjtAules inicialitzarCjtAulesTeo() {
        CjtAules aulesTeo = new CjtAules();
        ArrayList<String> llistAules = llistaAulesTeo(); 
        for(String nom : llistAules){
           ArrayList<String> atributs = cper.llegirAula(nomUnitat+"-"+nom);
           boolean b;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           else b = false;
           AulaTeo a = new AulaTeo(nom,Integer.parseInt (atributs.get(2)),b);
           aulesTeo.afegirAula(a);
        }
        return aulesTeo;
    }
    
    public CjtAules inicialitzarCjtAulesLab() {
        CjtAules aulesLab = new CjtAules();
        ArrayList<String> llistAules = llistaAulesLab();
        for(String nom : llistAules){
           ArrayList<String> atributs = cper.llegirAula(nomUnitat+"-"+nom);
           boolean b;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           else b = false;
           AulaLab a = new AulaLab(nom,Integer.parseInt (atributs.get(2)),b);
           aulesLab.afegirAula(a);
        }
        return aulesLab;
    }
    
    public CjtAssignatures inicialitzarCjtAssignatures() { //TODO Acabar esto cuando assignatura este escrito en disco
        CjtAssignatures assignatures = new CjtAssignatures();
        ArrayList<String> llistAssignatures = llistaAssignatures();
        for(String nom : llistAssignatures){
            ArrayList<String> atributs = cper.llegirAssignatura(nomUnitat+"-"+nom);
            //Assignatura a = new Assignatura(nom, int ht, int hp, int nv,int capTeo, int capLab,ArrayList<Grupo> grupos)
            //assignatures.afegirAssignatura(a);
        }
        return assignatures;
    }
    
    public Horari generarHorari() {
        Generador g = new Generador();
        CjtAules aulesTeo = inicialitzarCjtAulesTeo();
        CjtAules aulesLab = inicialitzarCjtAulesLab();
        CjtAssignatures assignatures = inicialitzarCjtAssignatures();
        return g.generar(aulesTeo,aulesLab,assignatures);
    }
}
