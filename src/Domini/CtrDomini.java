/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import Persistencia.CtrPersistencia;
import java.util.ArrayList;

/**
 *
 * @author Miquel Masriera
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
    public void inicialitzarClausules(){
         cgen.inicialitzarClausules();
    }
    public void inicialitzarClausulesNom(){
        cgen.inicialitzarClausulesNom();
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
    public ArrayList<String> llistaAssignatures(){
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
    public void inicialitzaGenerador( ArrayList<String> aules ) {
        
        
        ArrayList<String> configuracioInicial =  cper.llegirConfiguracioHoraria("configuracioHoraria-"+nomUnitat);
        
        ArrayList<String> llistaAssignatures = cper.llistaAssigantures(nomUnitat);
        int numAsg = llistaAssignatures.size();
        ArrayList<Assignatura> assignatures = new ArrayList<Assignatura>(numAsg);
        for( int i = 0; i < numAsg ; ++i){
            String nomAsg = llistaAssignatures.get(i);
            assignatures.add( montaAssignatura( nomAsg ) );
            String prova = "";
        }
        
        
        ArrayList<AulaLab> aLab = new ArrayList<AulaLab>();
        for(String nom : aules){
           ArrayList<String> atributs = llegirAulaLab(nom);
           if( ! atributs.isEmpty() ){
                boolean b = false;
                if (Integer.parseInt (atributs.get(3)) == 1) b = true;
                AulaLab a = new AulaLab(nom,Integer.parseInt (atributs.get(2)),b);
                aLab.add(a);
           }
        }
        
        ArrayList<AulaTeo> aTeo = new ArrayList<AulaTeo>();
        for (int i = 0; i < aules.size(); ++i) {
           Object nomO = aules.get(i);
           String nom = nomO.toString();
           ArrayList<String> atributs = llegirAulaTeo(nom);
           if( ! atributs.isEmpty()){
                boolean b = false;
                if (Integer.parseInt (atributs.get(3)) == 1) b = true;
                AulaTeo a = new AulaTeo(nom,Integer.parseInt (atributs.get(2)),b);
                aTeo.add(a);
           }
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
        ArrayList<String> configuracioInicial = cper.llegirConfiguracioHoraria("configuracioHoraria-"+nomUnitat);
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
    
    
    public void imprimeixHorari( Quadricula qu) {
        
        Quadricula q = qu;
        
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
            r.setId((Integer) params.get(3));
            boolean b = cgen.afegirRest(tipus,r);
            cgen.setResResGA(r);
        }
        else if(tipus == 2){
            RestGrupSessio r = new RestGrupSessio();
            r.setAssignatura((String) params.get(0));
            r.setGrup((Integer) params.get(1));
            r.setDia((String) params.get(2));
            r.setHora((Integer) params.get(3));
            r.AssignarId((Integer) params.get(4));
            cgen.afegirRest(tipus,r);
            
        }
        else if(tipus == 3){
            ArrayList<Assignatura> l = cgen.getCjtAs();
            int size = l.size();
            boolean trobat = false;
            Assignatura a = new Assignatura();
            String assig = (String)params.get(0);
            for(int i = 0;i < size && !trobat;++i){
                if(l.get(i).getNom().equals(assig)) {trobat =true; a = l.get(i);}
            }
            if(trobat){
                int grup = (Integer) params.get(1);
                int hora = (Integer) params.get(2);
                int id = (Integer) params.get(3);
                RestAssignatura r = new RestAssignatura();
                r.setAssignatura(a);
                r.setGrup(grup);
                r.setHora(hora);
                r.setId(id);
                cgen.afegirRest(tipus, r);
           }
        }
        else if(tipus == 4){
            ArrayList<Assignatura> l = cgen.getCjtAs();
            int size = l.size();
            boolean trobat = false;
            Assignatura a = new Assignatura();
            String assig = (String)params.get(0);
            for(int i = 0;i < size && !trobat;++i){
                if(l.get(i).getNom().equals(assig)) {trobat =true; a = l.get(i);}
            }
            if(trobat){
                int grup = (Integer) params.get(1);
                String dia = (String) params.get(2);
                int id = (Integer) params.get(3);
                RestAssignatura r = new RestAssignatura();
                r.setAssignatura(a);
                r.setGrup(grup);
                r.setDia(dia);
                r.setId(id);
                cgen.afegirRest(tipus, r);
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
                if(l.get(i).getNom().equals(assP)) {trobat1 =true; aP = l.get(i);}
                else if(l.get(i).getNom().equals(assS)) {trobat2 =true; aS = l.get(i);}
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
                cgen.afegirRest(tipus, r);
            }
        }
        else if(tipus == 6) {
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
                r.setId((Integer) params.get(3));
                
                cgen.afegirRest(tipus, r);
            }
            
        }
        else if(tipus == 7){
            ArrayList<Assignatura> l = cgen.getCjtAs();
            int size = l.size();
            boolean trobat = false;
            Assignatura a = new Assignatura();
            String assig = (String)params.get(0);
            for(int i = 0;i < size && !trobat;++i){
                if(l.get(i).getNom().equals(assig)) {trobat =true; a = l.get(i);}
            }
            if(trobat){
                int grup = (Integer) params.get(1);
                String dia = (String) params.get(2);
                int hora = (Integer) params.get(3);
                int id = (Integer) params.get(4);
                RestAssignatura r = new RestAssignatura();
                r.setAssignatura(a);
                r.setGrup(grup);
                r.setDia(dia);
                r.setHora(hora);
                r.setId(id);
                cgen.afegirRest(tipus, r);
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
    public boolean AfegirRestriccioGrupSessio( String nomA, int grup, String dia, int hora,int id ){
        return cgen.AfegirRestriccioGrupSessio( nomA, grup, dia, hora,id);
    }
    /**
     * 
     * @param nom
     * @return 
     */
    public ArrayList<String> llegirAulaLab(String nom) {
        return cper.llegirAula("aula-lab-"+nomUnitat+"-"+nom);
    }
    /**
     * 
     * @param nom
     * @return 
     */
    public ArrayList<String> llegirAulaTeo(String nom) {
        return cper.llegirAula("aula-teo-"+nomUnitat+"-"+nom);
    }
    /**
     * 
     * @param tipus
     * @return 
     */
    public ArrayList<String> llistaRest(int tipus){
        ArrayList<String> l = new ArrayList();
        if(0<tipus && tipus <3){
            CjtRestGrupoAula cjt= cgen.getCjtResGA();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestGrupoAula a = cjt.get(i);
                if(tipus == a.getId()){
                    l.add(a.getAssignatura()+"-"+a.getGrup()+"-"+a.getAula());
                    Integer j = i;
                    l.add(j.toString());
                }
            }
        }
        else if(2<tipus && tipus<6 ){
            CjtRestGrupSessio cjt = cgen.getCjtRestGS();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestGrupSessio r = cjt.get(i);
                if(tipus == r.ObtenirId()){
                    l.add(r.getAssignatura()+"-"+r.getGrup()+"-"+r.getDiaString()+"-"+r.getHora());
                    Integer j = i;
                    l.add(j.toString());
                }
            }
        }
        else if(5<tipus && tipus <9){
            CjtRestAssignatura cjt = cgen.getCjtRestAss();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestAssignatura r = cjt.get(i);
                if(r.getHora()!= -1){
                    if(tipus == r.getId()){
                        l.add(r.getAssignatura().getNom()+"-"+r.getGrup()+"-"+r.getHora());
                        Integer j = i;
                        l.add(j.toString());
                    }
                }
            }
        }
        else if(8<tipus && tipus < 12){
            CjtRestAssignatura cjt = cgen.getCjtRestAss();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestAssignatura r = cjt.get(i);
                if(r.getDia() != null){
                    if(tipus == r.getId()){
                        l.add(r.getAssignatura().getNom()+"-"+r.getGrup()+"-"+r.getDia());
                        Integer j = i;
                        l.add(j.toString());
                    }
                }
            }
        }
        else if(11<tipus && tipus < 15){
            CjtRestAssignatura cjt = cgen.getCjtRestAss();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestAssignatura r = cjt.get(i);
                if(r.getDia() != null){
                    if(tipus == r.getId()){
                        l.add(r.getAssignatura().getNom()+"-"+r.getGrup()+"-"+r.getDia()+"-"+r.getHora());
                        Integer j = i;
                        l.add(j.toString());
                    }
                }
            }
        }
        else if(tipus == 15){
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
        else if (15<tipus && tipus<19) {
            CjtRestriccioAula cjt = cgen.getCjtRestAul();
            int size = cjt.size();
            for(int i = 0; i < size; ++i){
                RestriccioAula r = cjt.get(i);
                if(tipus == r.getId()) {
                    l.add(r.getAula().getNom()+"-"+r.getDia()+"-"+r.getHora());
                    Integer j = i;
                    l.add(j.toString());
                }
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
                    rGS.setDia((String)params.get(3));
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
            case 7:
                    RestAssignatura rA3;
                    rA3 = cgen.getCjtRestAss().get(((Integer)params.get(0)));
                    Assignatura aaa = new Assignatura();
                    String aass = (String)params.get(1);
                    boolean trobatt = false;
                    for(int i = 0;i < cgen.getCjtAs().size() && !trobatt; ++i){
                        if(cgen.getCjtAs().get(i).getNom().equals(aass)) {aaa = cgen.getCjtAs().get(i); trobatt = true;}
                    }
                    if(trobatt){
                        rA3.setAssignatura(aaa);
                        rA3.setGrup((Integer)params.get(2));
                        rA3.setDia((String)params.get(3));
                        rA3.setHora((Integer) params.get(4));
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
            case 1: case 2:
                    cgen.getCjtResGA().remove(numRest);
                    break;
            case 3: case 4: case 5:
                    cgen.getCjtRestGS().remove(numRest);
                    break;
            case 6: case 7: case 8:
                    cgen.getCjtRestAss().remove(numRest);
                    break;
            case 9: case 10: case 11:
                    cgen.getCjtRestAss().remove(numRest);
                    break;
            case 12: case 13: case 14:
                    cgen.getCjtRestAss().remove(numRest);
                    break;    
            case 15: 
                    cgen.getCjtRestS().remove(numRest);
                    break;
            case 16: case 17: case 18:
                    cgen.getCjtRestAul().remove(numRest);
                    break;
       }
        
    }

    public boolean existeixConfiguracioHoraria() {
        return cper.existeixConfiguracioHoraria(nomUnitat);
    }

    public boolean guardaHorari( String nomh) {
        Quadricula q = cgen.getQuad();
        return cper.guardaHorari( "horari-"+nomUnitat+"-"+nomh ,q);
    }
    
    public boolean carregarHorari( String nomHorari){
        if( ! cper.existeixHorari(  "horari-"+nomUnitat+"-"+nomHorari ) ) 
            return false;
        
        cper.carregaHorari("horari-"+nomUnitat+"-"+nomHorari);
        return true;
    }
    
    public boolean aulaAssignadaALes(String aula, int dia, int h, String asg, int grp){
        
        Quadricula q = cgen.getQuad();
        String d = "dilluns";
        if ( dia == 1) d = "dimarts";
        else if (dia == 2) d = "dimecres";
        else if (dia == 3) d = "dijous";
        else if (dia == 4) d = "divendres";
        else if (dia == 5) d = "dissabte";
        else if (dia == 6) d = "diumenge";
        CjtElements cje = q.getElementsPosicio(d, h);

        if ( cje.isValid() ){
            int nume = cje.numeroElements();
            for( int i = 0; 0 < nume ; ++i){
                if( cje.getElementPosicio(i).getAula().getNom().equals(aula) ){
                    asg = cje.getElementPosicio(i).getAssignatura().getNom();
                    grp = cje.getElementPosicio(i).getGrupo();
                    
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<String> aulaAssignadaALes(String nomAula, int d, int h) {
        ArrayList<String> resultat = new ArrayList<String>();
        
        Quadricula q = cgen.getQuad();
        String dia = "dilluns";
        if ( d == 1) dia = "dimarts";
        else if (d == 2) dia = "dimecres";
        else if (d == 3) dia = "dijous";
        else if (d == 4) dia = "divendres";
        else if (d == 5) dia = "dissabte";
        else if (d == 6) dia = "diumenge";
        
        CjtElements cje = q.getElementsPosicio(dia, h);
        if( cje.isValid() ){
            int ne = cje.numeroElements();
            for( int i = 0; i < ne; ++i){
                String na = cje.getElementPosicio(i).getAula().getNom();
                if( na.equals(nomAula)){
                    resultat.add("S");
                    String asg = cje.getElementPosicio(i).getAssignatura().getNom();
                    String grp = String.valueOf(cje.getElementPosicio(i).getGrupo());
                    resultat.add(asg);
                    resultat.add(grp);
                }
            }
        }
        else resultat.add("BUIDA");
        
        return resultat;
    }

}