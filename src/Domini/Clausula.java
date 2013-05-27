/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Domini;

import java.util.ArrayList;

/**
 *
 * @author Alberto Marin
 */
public class Clausula {

    
    private Assignatura assignatura;
    private Integer grup;
    private Integer duracio;
    private ArrayList<ClausulaNom> clausula;
    private CjtRestAssignatura cjtRestAss;
    private CjtRestGrupSessio cjtRestGS;
    private CjtRestGrupoAula cjtRestGA;
    private CjtRestSolapament cjtRestS;
    private CjtRestriccioAula cjtRestAula;
    
    /**
     * Obtenir el domini de la clausula
     * @return Retorna el conjunt de possibles posicions de la Clausula
     */
    public ArrayList<ClausulaNom> getClausula() {
        return clausula;
    }

    //Constructora
    /**
     * Constructora per defecte
     */
    public Clausula() {
        cjtRestAss = new CjtRestAssignatura();
        cjtRestGS = new CjtRestGrupSessio();
        cjtRestGA = new CjtRestGrupoAula();
        cjtRestS = new CjtRestSolapament();
        cjtRestAula = new CjtRestriccioAula();
        clausula = new ArrayList<ClausulaNom>();
        grup = null;
        duracio = null;
        assignatura = null;
    }
    /**
     * Creadora que copia el contingut del la clausula passada per paramatre a la nova clausula
     * @param c Clausula a copiar
     */
    public Clausula(Clausula c) {
        this.grup = new Integer (c.getGrup());
        this.duracio = new Integer(c.getDuracio());
        Assignatura as = new Assignatura();
        as.setCapacitatLab(c.getAssignatura().getCapacitatLab());
        as.setCapacitatTeo(c.getAssignatura().getCapacitatTeo());
        as.setGrupss(c.getAssignatura().getGrups());
        as.setHoresP(c.getAssignatura().getHoresP());
        as.setHoresT(c.getAssignatura().getHoresT());
        as.setMaterial(c.getAssignatura().necesitaMaterial());
        as.setNivell(c.getAssignatura().getNivell());
        as.setNom(c.getAssignatura().getNom());
        as.setProjector(c.getAssignatura().necesitaProjector());
        as.setIntervalsP(c.getAssignatura().getIntervalsP());
        as.setIntervalsT(c.getAssignatura().getIntervalsT());
        this.assignatura = as;
        this.clausula = new ArrayList<ClausulaNom> (c.getClausula());
        this.cjtRestAss = new CjtRestAssignatura(c.getCjtRestAss());
        this.cjtRestAula = new CjtRestriccioAula(c.getCjtRestAula());
        this.cjtRestGA = new CjtRestGrupoAula(c.getCjtRestGA());
        this.cjtRestGS = new CjtRestGrupSessio(c.getCjtRestGS());
        this.cjtRestS = new CjtRestSolapament(c.getCjtRestS());
        
    }
    //Métodos

    /**
     * Afegeix un conjunt de ClausulesNom a la clase
     * @param clausula Conjunt de clausules que es volen afegir
     */
    public void setClausula(ArrayList<ClausulaNom> clausula) {
        this.clausula = clausula;
    }

    /**
     * Afegeix la ClausulaNom c al conjunt de ClausulesNom de la Clausula
     * @param c ClausulaNom que es vol afegir
     */
    public void afegirElem(ClausulaNom c) {
        clausula.add(c);
    }


    /**
     * S'esborra l'element e de la clausula
     * @param a, d, h son l'aula el dia i l'hora.
     */

    public boolean borrarElem(ClausulaNom c) {
        return clausula.remove(c);
    }
    /**
     * Afegeix el numero de grup id al grup de la Clausula
     * @param id Numero de grup que es vol afegir
     */
    public void setGrup(Integer id) {
        this.grup = id;
    }
    /**
     * Afegeix una assignatura a la Clausula
     * @param nom Assignatura que es vol afegir
     */
    public void setAssignatura(Assignatura nom) {
        this.assignatura = nom;
    }
    /**
     * Afegeix una duracio a la Clausula
     * @param h La duracio que es vol afegir
     */
    public void setDuracio(Integer h) {
        this.duracio = h;
    }

    /**
     * Obtenir la assignatura de la Clausula
     * @return Retorna la assignatura de la Clausula
     */
    public Assignatura getAssignatura() {
        return assignatura;
    }
    /**
     * Obtenir la duracio de la Clausula
     * @return Retorna la duracio de la Clausula
     */
    public Integer getDuracio() {
        return duracio;
    }
    /**
     * Obtenir el grup de la Clausula
     * @return Retorna el grup de la Clausula
     */
    public Integer getGrup() {
        return grup;
    }
    /**
     * Obtenir les restriccions del tipus Assignatura de la Clausula
     * @return Retorna tot el conjunt de restriccions del tipus Assignatura
     */
    public CjtRestAssignatura getCjtRestAss() {
        return cjtRestAss;
    }
    /**
     * Obtenir les restriccions del tipus GrupSessio de la Clausula
     * @return Retorna tot el conjunt de restriccions del tipus GrupSessio
     */
    public CjtRestGrupSessio getCjtRestGS() {
        return cjtRestGS;
    }
    /**
     * Obtenir les restriccions del tipus GrupoAula de la Clausula
     * @return Retorna tot el conjunt de restriccions del tipus GrupoAula
     */
    public CjtRestGrupoAula getCjtRestGA() {
        return cjtRestGA;
    }
    /**
     * Obtenir les restriccions del tipus Solapament de la Clausula
     * @return Retorna tot el conjunt de restriccions del tipus Solapament
     */
    public CjtRestSolapament getCjtRestS() {
        return cjtRestS;
    }
    /**
     * Obtenir les restriccions del tipus Aula de la Clausula
     * @return Retorna tot el conjunt de restriccions del tipus Aula
     */
    public CjtRestriccioAula getCjtRestAula() {
        return cjtRestAula;
    }
    /**
     * 
     * @param cjtRestAss 
     */
    //public void setCjtRestAss(CjtRestAssignatura cjtRestAss) {
    //    this.cjtRestAss = cjtRestAss;
    //}
    /**
     * 
     * @param cjtRestGS 
     */
    //public void setCjtRestGS(CjtRestGrupSessio cjtRestGS) {
        //this.cjtRestGS = cjtRestGS;
    //}
    /**
     * 
     * @param cjtRestGA 
     */
    /*public void setCjtRestGA(CjtRestGrupoAula cjtRestGA) {
        this.cjtRestGA = cjtRestGA;
    }*/
    /**
     * 
     * @param cjtRestS 
     */
    /*public void setCjtRestS(CjtRestSolapament cjtRestS) {
        this.cjtRestS = cjtRestS;
    }*/
    /**
     * 
     * @param cjtRestAula 
     */
    /*public void setCjtRestAula(CjtRestriccioAula cjtRestAula) {
        this.cjtRestAula = cjtRestAula;
    }*/
    /**
     * 
     * @param cnaux 
     */
    void addClausula(ArrayList<ClausulaNom> cnaux) {
        this.clausula.addAll(cnaux);
    }
    /**
     * Comprova si la ClausulaNom cn compleix totes les restriccions del tipus Assignatura
     * @param cn ClausulaNom que es vol comprovar
     * @return Retorna un boolean indicant si compleix totes les restriccions d'aquest tipus
     */
    private boolean compleixRestsAssignatura(ClausulaNom cn){
        return this.cjtRestAss.ComprovarRes(cn,this.duracio);
    }
    /**
     * Comprova si la ClausulaNom cn compleix totes les restriccions del tipus GrupSessio
     * @param cn ClausulaNom que es vol comprovar
     * @return Retorna un boolean indicant si compleix totes les restriccions d'aquest tipus
     */
    private boolean compleixRestsGrupSessio(ClausulaNom cn){
        return this.cjtRestGS.ComprovarRes(cn,this.duracio);
    }
    /**
     * Comprova si la ClausulaNom cn compleix totes les restriccions del tipus GrupoAula
     * @param cn ClausulaNom que es vol comprovar
     * @return Retorna un boolean indicant si compleix totes les restriccions d'aquest tipus
     */
    private boolean compleixRestsGrupoAula(ClausulaNom cn){
        return this.cjtRestGA.ComprovarRes(cn.getAula());
    }
    /**
     * Comprova si la ClausulaNom cn compleix totes les restriccions de Aula
     * @param cn ClausulaNom que es vol comprovar
     * @return Retorna un boolean que indica si compleix o no totes les restriccions
     */
    private boolean compleixRestsAula(ClausulaNom cn){
        return this.cjtRestAula.ComprovarRes(cn, this.duracio);
    }
    /**
     * Comprova si es compleixen les restriccions de Solapament de la Clausula c, es a dir, si la Clausula C pot posar-se amb les altres Clausules que hi han en un dia i una  hora de la quadricula
     * @param c Clausula que es vol comprovar si es pot afegir
     * @param cn ClausulaNom de la Clausula c
     * @param e Element amb el que es comprova
     * @param h Hora en la que es vol afegir la Clausula c
     * @param dia Dia en el que es vol afegir la Clausula c
     * @return Retorna un boolean indicant si es pot afegir la Clausula C en aquell dia i aquella hora
     */
    public boolean compleixRestsSolapament(Clausula c, ClausulaNom cn, Clausula e,int h,String dia){
        //return this.cjtRestS.ComprovarRess(this.assignatura.getNom(), this.grup, e);
        return this.cjtRestS.ComprovarRes(c, cn, e, h, dia);
    }
    /**
     * Comprova si la ClausulaNom cn compleix totes les restriccions de la Clausula
     * @param cn ClausulaNom que es vol comprovar
     * @return Retorna un boolean, indica si compleix totes les restriccion de la Clausula
     */
    private boolean compleixResDomini(ClausulaNom cn){
        if(!compleixRestsAssignatura(cn)) return false;
        else if(!compleixRestsGrupSessio(cn)) return false;
        else if(!compleixRestsGrupoAula(cn)) return false;
        else if(!compleixRestsAula(cn)) return false;
        else return true;
    }
    /**
     * Redueix les ClausulesNom a partir dels conjunts de restriccions de la clausula
     */
    public void reduccioClausules(){
        ArrayList<ClausulaNom> aux = new ArrayList();
        for(ClausulaNom cn: this.clausula){
            if(compleixResDomini(cn)) {
                aux.add(cn);
            }
        }
        this.clausula = aux;
    }

}