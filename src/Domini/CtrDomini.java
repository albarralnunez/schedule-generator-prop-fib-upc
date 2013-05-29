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
    public void creaAssignatura( String nomAsg, int nivell, int ht, ArrayList<Integer> intervalsT,
            int hp,ArrayList<Integer> intervalsP , int capTeo, int capPra ,
            ArrayList grups, boolean mat,boolean proj ){ 
        
            ArrayList params = new ArrayList();
            params.add(nomAsg); //nom
            params.add(nivell); // nivell
            if( mat)  params.add(1);  //material
            else params.add(0); 
            
            if (proj) params.add(1); //projecotr
            else params.add(0); 
            
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
    public void inicialitzaGenerador( ArrayList<String> aules, ArrayList<String> assig ) {

        ArrayList<String> configuracioInicial =  cper.llegirConfiguracioHoraria("configuracioHoraria-"+nomUnitat);
        
        //ArrayList<String> llistaAssignatures = cper.llistaAssigantures(nomUnitat);
        //int numAsg = llistaAssignatures.size();
        int numAssig = assig.size();
        ArrayList<Assignatura> assignatures = new ArrayList<Assignatura>(numAssig);
        for( int i = 0; i < numAssig ; ++i){
            //String nomAsg = llistaAssignatures.get(i);
            assignatures.add( montaAssignatura( assig.get(i) ) );
            String prova = "";
        }
        
        
        ArrayList<AulaLab> aLab = new ArrayList<AulaLab>();
        for(String nom : aules){
           ArrayList<String> atributs = llegirAulaLab(nom);
           if( ! atributs.isEmpty() ){
               Integer bb = Integer.parseInt(atributs.get(3));
                boolean b = (bb.equals(1));
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
               Integer bb = Integer.parseInt (atributs.get(3));
                boolean b = (bb.equals(1));
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
        //Assignatura asg = new Assignatura();
        nomAsg = nomAsg.replace("assig-"+nomUnitat+"-", "");
        nomAsg = nomAsg.replace(".txt", "");
        ArrayList<String> atributs = llegirAssignatura(nomAsg);
        String nom = atributs.get(0);      
        int nvl = Integer.parseInt(atributs.get(1));
        Integer matt = Integer.parseInt(atributs.get(2));
        Integer projj = Integer.parseInt(atributs.get(3));
        boolean mat = (matt.equals(1));
        boolean proj = (projj.equals(1));
        int numht = Integer.parseInt( atributs.get(4) );
        int numint =  Integer.parseInt( atributs.get(5) );
        ArrayList<Integer> intersT = new ArrayList<Integer>(numint); 
        int contador = numint+6;
        for( int i = 6; i < numint+6  ; ++i ){
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
        Assignatura asg = new Assignatura( nom, nvl, numht, intersT, numhp, intersP, capt, 
                capp, grupos,mat, proj);
        return asg;
    }
    
    public boolean existeixRest(String nomUnitat){
       return cper.existeixRest(nomUnitat);
    }
    
    public void montaRestriccions(String nomUnitat){
        ArrayList<String> l = this.cper.llegirRestriccions(this.nomUnitat);
        ArrayList laux;
        for(int i = 0; i < l.size();++i){
            laux = new ArrayList();
            String aux = l.get(i);
            String[] aux2 = aux.split("-");
            int id = Integer.parseInt(aux2[0].toString());
            int tipus=-1;
            String nivell = "bb";
            for(int j = 1;j< aux2.length;++j){
                if(0<id && id <3){
                    if(j ==1) tipus = 1;
                    if(j ==2) {
                        int p = Integer.parseInt(aux2[j].toString());
                        laux.add(p);
                    }
                    else {
                        laux.add(aux2[j].toString());
                    }
                }
                else if(2<id && id <5){
                    if(j ==1) tipus = 2;
                    if(j ==2 || j ==4){
                        int p = Integer.parseInt(aux2[j].toString());
                        laux.add(p);
                    }
                    else laux.add(aux2[j].toString());
                }
                else if(4<id && id <8){
                    if(j ==1) tipus = 3;
                    if(j ==2 || j ==3){
                        int p = Integer.parseInt(aux2[j].toString());
                        laux.add(p);
                    }
                    else laux.add(aux2[j].toString());
                    
                }
                else if(7<id && id <11){
                    if(j ==1) tipus = 4;
                    if(j ==2){
                        int p = Integer.parseInt(aux2[j].toString());
                        laux.add(p);
                    }
                    else laux.add(aux2[j].toString());
                }
                else if(10<id && id <14){
                    if(j ==1) tipus = 7;
                    if(j ==2 || j ==4){
                        int p = Integer.parseInt(aux2[j].toString());
                        laux.add(p);
                    }
                    else laux.add(aux2[j].toString());    
                }
                else if(id == 14){
                    if(j ==1) {
                        tipus = 5;
                        nivell = aux2[j].toString();
                    }
                    else{
                        if(nivell.equals("assignatura")){
                        laux.add(aux2[j].toString());
                        }
                        else if(nivell.equals("grup")){
                            if(j ==4 || j ==5){
                                int p = Integer.parseInt(aux2[j].toString());
                                laux.add(p);
                             }
                            else laux.add(aux2[j].toString());
                       }
                       else {id = -1; j = aux2.length;}
                   }
                }
                else if(14<id && id <18){
                    if(j ==1) tipus = 6;
                    if(j ==3){
                        int p = Integer.parseInt(aux2[j].toString());
                        laux.add(p);
                    }
                    else laux.add(aux2[j].toString());
                }
                
            }
            if(0<id && id != 14)laux.add(id);
            if(0<id && id<18)afegirRestriccio(tipus,laux);
        }
        
    }

    /**
     * 
     */
    public boolean generar( ) {
        ArrayList<String> configuracioInicial = cper.llegirConfiguracioHoraria("configuracioHoraria-"+nomUnitat);
        return cgen.generar(configuracioInicial);
        
    }
    
    
    public void imprimeixHorari() {
        
        ArrayList<String> horari = new ArrayList<String>();//////////
        
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
            
            horari.add("");
            horari.add(dia);
            horari.add("");
            
            for (int j=0; j < 24; ++j) {
                CjtElements cjt_elem = new CjtElements();
                cjt_elem = q.getElementsPosicio(dia, j);
                if (cjt_elem.isValid() && !cjt_elem.getAssignacions().isEmpty()) {
                    //Si el conjunt d elements es valid
                    
                    horari.add(j+" :");
                    
                    ArrayList<Element> assignacions;
                    assignacions = cjt_elem.getAssignacions();
                    for (Element e1 : assignacions) {
                        Aula a = new Aula();
                        Assignatura ass = new Assignatura();
                        int grupo;
                        a = e1.getAula();
                        ass = e1.getAssignatura();
                        grupo = e1.getGrupo();
                        
                        horari.add( "  "+ass.getNom()+"  "+grupo+"  "+a.getNom() );
                    }
                }
            }
        }
        ///////////////
        cper.imprimeixHorari( nomUnitat, horari);
        ////////
    }
    
    /**
     * 
     * @param qu 
     
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
            for (int j=0; j < 24; ++j) {
                CjtElements cjt_elem = new CjtElements();
                cjt_elem = q.getElementsPosicio(dia, j);
                if (cjt_elem.isValid() && !cjt_elem.getAssignacions().isEmpty()) {
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
                    }
                }
            }
        }
    }*/
    
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
            cgen.afegirRest(tipus,r);
           
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
                r.setHora((Integer)params.get(2));
                r.setDia((String)params.get(1));
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
     * @return cert si existeix un arxiu de configuracio horaria per a a questa unitat docent
     */
    public boolean existeixConfiguracioHoraria() {
        return cper.existeixConfiguracioHoraria(nomUnitat);
    }

    /**
     * 
     * @param nomh nom amb el que guardar l horari
     * @return  retorna cert si s ha pogut guardar l horari
     */
    public boolean guardaHorari( String nomh) {
        Quadricula q = cgen.getQuad();
        return cper.guardaHorari( "horari-"+nomUnitat+"-"+nomh ,q);
    }
    
    /**
     * 
     * @param nomHorari
     * @return cert si s ha pogut crregar l horari
     */
    public boolean carregarHorari( String nomHorari){
        Quadricula qua = cper.carregaHorari(nomHorari);
        int a = 0;
        if( qua == null) return false;
        cgen.setQuad(qua);
        return true;
    }
    

    /**
     * 
     * @param nomAula 
     * @param d dia
     * @param h hora
     * @return si la aula te una assignacio a la hora h del dia d, retorna dos strings
     * un per la assignatura i un altre pel grup
     */
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

    /**
     * 
     * @return llista mab tots els noms dels horaris guardats 
     */
    public ArrayList<String> carregaLlistaHoraris() {
       return cper.getLlistaHoraris( nomUnitat);
    }

    /**
     * 
     * @return el nom de la unitat docent 
     */
    public String nomUnitatDocent() {
        return this.nomUnitat;
    }
    
    /**
     * 
     * @param nomhorari horari a esborrar 
     */
    public void esborraHorari(String nomhorari) {
        cper.esborrahorari( nomhorari );
    }

    /**
     * 
     * @param d dia 
     * @param h hora
     * @param asg assignatura
     * @return retorna cert si en aquell dia i aquella hora la assignatura asg esta assignada
     */
    public boolean esUsada(int d, int h, String asg) {
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
            if(ne > 0) {
                if( asg == null || asg.equals("TOTES") ) return true;
                else {
                    for(int i = 0; i < ne; ++i){
                        String nasig = cje.getElementPosicio(i).getAssignatura().getNom();
                        if( nasig.equals(asg) )return true;
                    }
                }
            }
        }
        return false;
    }
    
    /**
     * @return llista amb els noms de totes les assignatures de l horari 
     */
    public ArrayList<String> AssignaturesUsades() {
        ArrayList<String> asgs = new ArrayList<String>();
        
        Quadricula q = cgen.getQuad();
        
        for(int d = 0; d < 7; ++d){
            for(int h = 0; h < 24; ++ h){
                
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
                for(int i = 0; i < ne; ++i){
                    String nomA = cje.getElementPosicio(i).getAssignatura().getNom();
                    if( ! asgs.contains(nomA) ) asgs.add(nomA); 
                }
            }
            
            }
        }
        
        return asgs;
    }

    /**
     * 
     * @param d dia
     * @param h hora
     * @param s assigatura
     * @return retorna una cadena amb totes les assignacions d aquella assignatura ne aquella hora i aquell dia
     */
    public String getAssignacio(int d, int h, String s) {
        
        String resultat = "";
        
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
                if( s == null || s.equals("TOTES") ) { //vull totes les assignacions
                    for(int i = 0; i < ne; ++i){
                    String nomA = cje.getElementPosicio(i).getAssignatura().getNom();
                    int grup = cje.getElementPosicio(i).getGrupo();
                    String nomAula = cje.getElementPosicio(i).getAula().getNom();
                    resultat = resultat+nomA+" "+grup+" "+nomAula+"\n";
                    }
                }
                else{   //es una assignatura en concret
                    for(int i = 0; i < ne; ++i){
                        String nomA = cje.getElementPosicio(i).getAssignatura().getNom();
                        if(nomA.equals(s)){
                            int grup = cje.getElementPosicio(i).getGrupo();
                            String nomAula = cje.getElementPosicio(i).getAula().getNom();
                            resultat = resultat+nomA+"  "+grup+" "+nomAula+"\n";
                        }
                    }
                }
            }
        
        return resultat;
    }

}