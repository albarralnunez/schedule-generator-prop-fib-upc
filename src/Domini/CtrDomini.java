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
    
    private CtrPersistencia cper;
    private String nomUnitat;
    private Scanner sc;
    private CtrGeneracio cgen;
    
    
    public CtrDomini( String nomU ){     
        nomUnitat = nomU;
        cper = new CtrPersistencia();
        cgen = new CtrGeneracio(nomU);
    }


   /*
    * Crea una assigatura (  un arxiu .txt amb tota la info)
    * nom de l arxiu (unitat docent)-(assignatura)-(nom assignatura)
    * 
    * ara nomes posa el nom pero tenen que posarse i validar tots
    * els parametres
    */
    public void creaAssignatura2( String nomAsg, int ht, int hp, int nivel,int capTeo,int capLab,ArrayList a ){ 
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
    
    public void creaAssignatura( String nomAsg, int nivell, int ht, ArrayList<Integer> intervalsT, int hp,
            ArrayList<Integer> intervalsP , int capTeo, int capPra ,ArrayList grups ){ 
        
            ArrayList params = new ArrayList();
            params.add(nomAsg); //nom
            params.add(nivell); // nivell
            params.add(ht); //numero d'hores de teoria
            params.add( intervalsT.size() ); //numero d intervals de teoria
            for(int i = 0; i < intervalsT.size(); ++i) params.add(intervalsT.get(i)); // intervals teoria
            params.add(hp); //numero d'hores de practica
            params.add( intervalsP.size() ); //numero d intervals de practica
            for(int i = 0; i < intervalsP.size(); ++i) params.add(intervalsP.get(i)); // intervals Practica
            params.add(capTeo); //capacitat dels grups de teoria
            params.add(capPra); // capactat grups practica
            for(int i = 0; i < grups.size(); ++i) params.add(grups.get(i));
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
     * @param nomAula
     * @return  Retorna si es pot esborrar l'aula amb nom nomAula.
     */
    public boolean esborraAula( String nomAula){         
        return(cper.esborraAula(nomUnitat+"-"+nomAula));
    }
    
    
    /**
     * fara que s'inicialitzin la quadricula, les aules i les assignatures
     */
    public void inicialitzaGenerador() {
        
        ArrayList<String> configuracioInicial =  cper.llegirConfiguracioHoraria("configuracioHoraria-"+nomUnitat);
        
        ArrayList<String> llistaAssignatures = cper.llistaAssigantures(nomUnitat);
        int numAsg = llistaAssignatures.size();
        ArrayList<Assignatura> assignatures = new ArrayList<Assignatura>(numAsg);
        for( int i = 0; i < numAsg ; ++i){
            String nomAsg = llistaAssignatures.get(i);
            assignatures.add( montaAssignatura( nomAsg ) );
            String prova = "";
        }

        ArrayList<String> auesLab = cper.llistaAulesLab(nomUnitat);
        ArrayList<AulaLab> aLab = new ArrayList<AulaLab>();
        for(String nom : auesLab){
           nom = nom.replace("aula-lab-" +nomUnitat+"-", "");
           nom = nom.replace(".txt", "");
           ArrayList<String> atributs = llegirAulaLab(nom);
           boolean b = false;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           AulaLab a = new AulaLab(nom,Integer.parseInt (atributs.get(2)),b);
           aLab.add(a);
        }
        
        ArrayList llistAules = cper.llistaAulesTeo(nomUnitat);
        ArrayList<AulaTeo> aTeo = new ArrayList<AulaTeo>();
        for (int i = 0; i < llistAules.size(); ++i) {
           Object nomO = llistAules.get(i);
           String nom = nomO.toString();
           nom = nom.replace("aula-teo-"+nomUnitat+"-", "");
           nom = nom.replace(".txt", "");
           ArrayList<String> atributs = llegirAulaTeo(nom);
           boolean b;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           else b = false;
           AulaTeo a = new AulaTeo(nom,Integer.parseInt (atributs.get(2)),b);
           aTeo.add(a);
        }
        
        cgen.inicialitzarGenerador(configuracioInicial, assignatures, aLab, aTeo);
        
        
    }
  
    
    public Assignatura montaAssignatura( String nomAsg ){
        Assignatura asg = new Assignatura();
        nomAsg = nomAsg.replace("assig-"+nomUnitat+"-", "");
        nomAsg = nomAsg.replace(".txt", "");
        ArrayList<String> atributs = llegirAssignatura(nomAsg);
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
        //for( int i = contador-contadorip+1; i < contador; ++i){
        for( int i = contador-contadorip; i < contador; ++i){
            int interval = Integer.parseInt(atributs.get(i+1));
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
    /*public Aula montaAula(String nomAula){
        Aula a = new Aula();
        if(grup%10 == 0){
           ArrayList<String> atributs = cper.llegirAulaTeo(unitatDocent+"-"+nomAula);
           boolean b;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
           else b = false;
            a = new AulaTeo(nomAula,Integer.parseInt (atributs.get(2)),b);
        }
        else{
           ArrayList<String> atributs = cper.llegirAulaLab(unitatDocent+"-"+nomAula);
           boolean b = false;
           if (Integer.parseInt (atributs.get(3)) == 1) b = true;
            a = new AulaLab(nomAula,Integer.parseInt (atributs.get(2)),b);
        }
        return a;
    }*/

    public void generar() {
        if (cgen.generar()) {
            Representador rep = new Representador();
            rep.imprimir_horario(cgen.getQuad());
        }
        else {
            System.out.print("\n    no s ha pogut generar cap hoari valid\n\n");
        }
    }
    
    public void afegirRestriccio(int tipus, ArrayList params) {
        if(tipus == 1) {
            RestGrupoAula r = new RestGrupoAula();
            r.setAssignatura((String) params.get(0));
            r.setGrup((Integer) params.get(1));
            r.setAula((String) params.get(2));
            if(r.esPotAfegir(cgen.getCjtResGA(), cgen.getCjtRestAul(), cgen.getCjtRestAss()))
                cgen.setResResGA(r);
        }
        else if(tipus == 2){
            
            //EN MIKIS LA VOL FER
            
        }
        else if(tipus == 3){
            ArrayList<Assignatura> l = cgen.getCjtAs();
            int size = l.size();
            boolean trobat = false;
            Assignatura a = new Assignatura();
            String assig = (String)params.get(0);
            for(int i = 0;i < size && !trobat;++i){
                if(l.get(i).getNom().equals(assig)) {trobat =true; a = l.get(i); ;}
            }
            if(trobat){
                int grup = (Integer) params.get(1);
                int hora = (Integer) params.get(2);
                RestAssignatura r = new RestAssignatura();
                r.setAssignatura(a);
                r.setGrup(grup);
                r.setHora(hora);
                if(r.esPotAfegir(cgen.getCjtRestAss(),cgen.getCjtRestGS())) cgen.setResRestAss(r);
           }
        }
        else if(tipus == 4){
            ArrayList<Assignatura> l = cgen.getCjtAs();
            int size = l.size();
            boolean trobat = false;
            Assignatura a = new Assignatura();
            String assig = (String)params.get(0);
            for(int i = 0;i < size && !trobat;++i){
                if(l.get(i).getNom().equals(assig)) {trobat =true; a = l.get(i); ;}
            }
            if(trobat){
                int grup = (Integer) params.get(1);
                String dia = (String) params.get(2);
                RestAssignatura r = new RestAssignatura();
                r.setAssignatura(a);
                r.setGrup(grup);
                r.setDia(dia);
                if(r.esPotAfegir(cgen.getCjtRestAss(),cgen.getCjtRestGS())) cgen.setResRestAss(r);
           }
        }
        else if(tipus == 5){
            int sizeParams = params.size();
            boolean trobat1 = false;
            boolean trobat2 = false;
            Assignatura aP = new Assignatura();
            Assignatura aS = new Assignatura();
            String assP = (String) params.get(0);
            String assS = (String) params.get(1);
            ArrayList<Assignatura> l = cgen.getCjtAs();
            int sizeAss = l.size();
            for(int i = 0;i < sizeAss && (!trobat1 || !trobat2);++i){
                if(l.get(i).getNom().equals(assP)) {trobat1 =true; aP = l.get(i); ;}
                else if(l.get(i).getNom().equals(assS)) {trobat2 =true; aS = l.get(i); ;}
            }
            if(trobat1 && trobat2){
                RestSolapament r = new RestSolapament();
                r.setAssignaturaPrincipal(aP);
                r.setAssignaturaSolapament(aS);
                if(sizeParams > 2){
                    int grupP = (Integer) params.get(2);
                    int grupS = (Integer) params.get(3);
                    r.setGrupPrincipal(grupP);
                    r.setGrupSolapament(grupS);
                }
                if(r.esPotAfegir(cgen.getCjtRestS())) cgen.setResRestS(r);
            }
        }
        else {
            String nomAula =nomUnitat+"-"+((String)params.get(0));
            ArrayList<AulaLab> llistalab = cgen.getCjtAulLab();
            ArrayList<AulaTeo> llistaTeo = cgen.getCjtAulTeo();
            int sizelab = llistalab.size();
            int sizeteo = llistaTeo.size();
            boolean trobat = false;
            Aula a = new Aula();
            for(int i = 0; i < sizelab && !trobat; ++i){
                if(llistalab.get(i).getNom().equals(nomAula)) {a = llistalab.get(i); trobat = true;}
            }
            for(int i = 0; i < sizeteo && !trobat; ++i){
                if(llistaTeo.get(i).getNom().equals(nomAula)) {a = llistaTeo.get(i); trobat = true;}
            }
            if(trobat){
                RestriccioAula r = new RestriccioAula();
                r.setAula(a);
                r.setHora((Integer)params.get(1));
                r.setDia((String)params.get(2));
                if(r.esPotAfegir(cgen.getCjtRestAul(),cgen.getCjtResGA(),cgen.getCjtRestGS())) cgen.setResRestAul(r);
                cgen.getCjtRestAul();
            }
            
        }
    }
    
    public boolean AfegirRestriccioGrupSessio( String nomA, int grup, String dia, int hora ){
        return cgen.AfegirRestriccioGrupSessio( nomA, grup, dia, hora);
    }

    private ArrayList<String> llegirAulaLab(String nom) {
        return cper.llegirAula("aula-lab-"+nomUnitat+"-"+nom);
    }

    private ArrayList<String> llegirAulaTeo(String nom) {
        return cper.llegirAula("aula-teo-"+nomUnitat+"-"+nom);
    }
}