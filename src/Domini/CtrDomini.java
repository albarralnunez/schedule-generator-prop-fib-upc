/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import Persistencia.CtrPersistencia;
import java.util.ArrayList;

/**
 *
 * @author miquelmasrieraquevedo
 */
public class CtrDomini {
    
    private CtrPersistencia cper;
    private String nomUnitat;
    private CtrGeneracio cgen;
    
    /**
     * 
     * @param nomU 
     */
    public CtrDomini( String nomU ){     
        nomUnitat = nomU;
        cper = new CtrPersistencia();
        cgen = new CtrGeneracio(nomU);
    }


    /**
     * 
     * @param nomAsg
     * @param nivell
     * @param ht
     * @param intervalsT
     * @param hp
     * @param intervalsP
     * @param capTeo
     * @param capPra
     * @param grups 
     */
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
    /**
     * 
     * @param nomAsg
     * @return 
     */
    public boolean existeixAssignatura(String nomAsg) {
        return cper.existeixAssignatura(nomUnitat+"-"+nomAsg);
    }
    /**
     * 
     * @param nomaAsg 
     */
    public ArrayList<String> mostraParametresAssignatura( String nomaAsg){ //TODO: Toda la informaicon!
        return cper.llegirAssignatura(nomUnitat+"-"+nomaAsg);
    }
    /**
     * 
     * @param nomAsg
     * @return 
     */
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
    }*/
    
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
    
     public ArrayList<String> llegeixConfiguracioHoraria(){
         return cper.llegirConfiguracioHoraria("configuracioHoraria-"+nomUnitat);
    }
     
    public void escriuConfigurcioHoraria( ArrayList conf ){
        cper.escriuConfiguracioHoraria(conf, nomUnitat);
    }
  
    /**
     * 
     * @param nomAsg
     * @return 
     */
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

    /**
     * 
     */
    public boolean generar( ) {
        ArrayList<String> configuracioInicial = 
                cper.llegirConfiguracioHoraria("configuracioHoraria-"+nomUnitat);
        return cgen.generar(configuracioInicial);
    }
    
    
    public void imprimeixHorari() {
        
        Quadricula q = cgen.getQuad();
        
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
                CjtElements cjt_elem = new CjtElements();
                cjt_elem = q.getElementsPosicio(dia, j);
                if (cjt_elem.isValid() && !cjt_elem.getAssignacions().isEmpty()) {
                    System.out.println(" "+j+": ");
                    //Si el conjunto de elementos es valido
                    ArrayList<Element> assignacions;
                    assignacions = cjt_elem.getAssignacions();
                    for (Element e1 : assignacions) {
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
    /**
     * 
     * @param tipus
     * @param params 
     */
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
            String nomAula =/*nomUnitat+"-"+*/((String)params.get(0));
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
            }
            
        }
    }
    /**
     * 
     * @param nomA
     * @param grup
     * @param dia
     * @param hora
     * @return 
     */
    public boolean AfegirRestriccioGrupSessio( String nomA, int grup, String dia, int hora ){
        return cgen.AfegirRestriccioGrupSessio( nomA, grup, dia, hora);
    }
    /**
     * 
     * @param nom
     * @return 
     */
    private ArrayList<String> llegirAulaLab(String nom) {
        return cper.llegirAula("aula-lab-"+nomUnitat+"-"+nom);
    }
    /**
     * 
     * @param nom
     * @return 
     */
    private ArrayList<String> llegirAulaTeo(String nom) {
        return cper.llegirAula("aula-teo-"+nomUnitat+"-"+nom);
    }
    /**
     * 
     * @param tipus
     * @return 
     */
    public ArrayList<String> llistaRest(int tipus){
        ArrayList<String> l = new ArrayList();
        if(tipus == 1){
            CjtRestGrupoAula cjt= cgen.getCjtResGA();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestGrupoAula a = cjt.get(i);
                l.add(a.getAssignatura()+"-"+a.getGrup()+"-"+a.getAula());
            }
        }
        else if(tipus == 2){
            CjtRestGrupSessio cjt = cgen.getCjtRestGS();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestGrupSessio r = cjt.get(i);
                l.add(r.getAssignatura()+"-"+r.getGrup()+"-"+r.getDia()+"-"+r.getHora());
            }
        }
        else if(tipus == 3){
            CjtRestAssignatura cjt = cgen.getCjtRestAss();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestAssignatura r = cjt.get(i);
                if(r.getHora()!= -1){
                    l.add(r.getAssignatura().getNom()+"-"+r.getGrup()+"-"+r.getHora());
                    Integer j = i;
                    l.add(j.toString());
                }
            }
        }
        else if(tipus == 4){
            CjtRestAssignatura cjt = cgen.getCjtRestAss();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestAssignatura r = cjt.get(i);
                if(r.getDia() != null){
                    l.add(r.getAssignatura().getNom()+"-"+r.getGrup()+"-"+r.getDia());
                    Integer j = i;
                    l.add(j.toString());
                }
            }
        }
        else if(tipus == 5){
            CjtRestSolapament cjt = cgen.getCjtRestS();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestSolapament r = cjt.get(i);
                if(r.getGrupPrincipal() == -1 && r.getGrupSolapament() == -1){
                    l.add(r.getAssignaturaPrincipal().getNom()+"-"+r.getAssignaturaSolapament().getNom());
                }
                else{
                    l.add(r.getAssignaturaPrincipal().getNom()+"-"+r.getGrupPrincipal()+"-"+r.getAssignaturaSolapament().getNom()+"-"+r.getGrupSolapament());
                }
            }
        }
        else {
            CjtRestriccioAula cjt = cgen.getCjtRestAul();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestriccioAula r = cjt.get(i);
                l.add(r.getAula().getNom()+"-"+r.getDia()+"-"+r.getHora());
            }
        }
        return l;
    }
    
    /**
     * 
     * @param tipus
     * @param params 
     */
    public void modificarRest(int tipus,ArrayList params){
        switch (tipus) {
            case 1: 
                    RestGrupoAula r; 
                    r = cgen.getCjtResGA().get((Integer)params.get(0));
                    r.setAssignatura((String)params.get(1));
                    r.setGrup((Integer)params.get(2));
                    r.setAula((String)params.get(3));
                    break;
            case 2:  
                    RestGrupSessio rGS; 
                    rGS = cgen.getCjtRestGS().get((Integer)params.get(0));
                    rGS.setAssignatura((String)params.get(1));
                    rGS.setGrup((Integer)params.get(2));
                    rGS.setDia((Integer)params.get(3));
                    rGS.setHora((Integer)params.get(4));
                     break;
            case 3:  
                    RestAssignatura rA;
                    rA = cgen.getCjtRestAss().get(((Integer)params.get(0)));
                    Assignatura a = new Assignatura();
                    String ass = (String)params.get(1);
                    boolean trobat = false;
                    for(int i = 0;i < cgen.getCjtAs().size() && !trobat; ++i){
                        if(cgen.getCjtAs().get(i).getNom().equals(ass)) {a = cgen.getCjtAs().get(i); trobat = true;}
                    }
                    if(trobat){
                        rA.setAssignatura(a);
                        rA.setGrup((Integer)params.get(2));
                        rA.setHora((Integer)params.get(3));
                    }    
                     break;
            case 4:  
                    RestAssignatura rA2;
                    rA2 = cgen.getCjtRestAss().get(((Integer)params.get(0)));
                    Assignatura aa = new Assignatura();
                    String asss = (String)params.get(1);
                    boolean trobat1 = false;
                    for(int i = 0;i < cgen.getCjtAs().size() && !trobat1; ++i){
                        if(cgen.getCjtAs().get(i).getNom().equals(asss)) {aa = cgen.getCjtAs().get(i); trobat1 = true;}
                    }
                    if(trobat1){
                        rA2.setAssignatura(aa);
                        rA2.setGrup((Integer)params.get(2));
                        rA2.setDia((String)params.get(3));
                    }    
                     break;
            case 5:  
                    RestSolapament rs;
                    rs = cgen.getCjtRestS().get((Integer)params.get(0));
                    boolean trobat2 = false;
                    boolean trobat3 = false;
                    String as1 = (String)params.get(1);
                    String as2 = (String)params.get(3);
                    Assignatura a1 = new Assignatura();
                    Assignatura a2 = new Assignatura();
                    for(int i = 0;i < cgen.getCjtAs().size() && (!trobat2 || !trobat3); ++i){
                        if(cgen.getCjtAs().get(i).getNom().equals(as1)) {a1 = cgen.getCjtAs().get(i); trobat2 = true;}
                        else if(cgen.getCjtAs().get(i).getNom().equals(as2)) {a2 = cgen.getCjtAs().get(i); trobat3 = true;}
                    }
                    if(trobat2 && trobat3){
                     rs.setAssignaturaPrincipal(a1);
                     rs.setAssignaturaSolapament(a2);
                     rs.setGrupPrincipal((Integer)params.get(2));
                     rs.setGrupSolapament((Integer)params.get(4));
                    }
                     break;
            case 6:  
                    RestriccioAula rAul;
                    rAul = cgen.getCjtRestAul().get((Integer)params.get(0));
                    Aula aul = new Aula();
                    String Aul = (String)params.get(1);
                    boolean trobat4 = false;
                    for(int i = 0; i < cgen.getCjtAulLab().size() && !trobat4;++i){
                        if(cgen.getCjtAulLab().get(i).getNom().equals(Aul)) {aul = cgen.getCjtAulLab().get(i); trobat4 = true;}
                    } 
                    for(int i = 0; i < cgen.getCjtAulTeo().size() && !trobat4;++i){
                        if(cgen.getCjtAulTeo().get(i).getNom().equals(Aul)) {aul = cgen.getCjtAulTeo().get(i); trobat4=true;}
                    }
                    if(trobat4){
                        rAul.setAula(aul);
                        rAul.setDia((String)params.get(2));
                        rAul.setHora((Integer)params.get(3));
                    }
                    break;
        }
    }
    
    /**
     * 
     * @param tipus
     * @param numRest 
     */
    public void esborraRest(int tipus,int numRest){
        switch (tipus){
            case 1:
                    cgen.getCjtResGA().remove(numRest);
                    break;
            case 2:
                    cgen.getCjtRestGS().remove(numRest);
                    break;
            case 3:
                    cgen.getCjtRestAss().remove(numRest);
                    break;
            case 4:
                    cgen.getCjtRestAss().remove(numRest);
                    break;
            case 5: 
                    cgen.getCjtRestS().remove(numRest);
                    break;
            case 6:
                    cgen.getCjtRestAul().remove(numRest);
                    break;
       }
        
    }
}