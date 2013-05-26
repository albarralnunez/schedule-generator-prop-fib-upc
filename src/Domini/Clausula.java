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
    

    public ArrayList<ClausulaNom> getClausula() {
        return clausula;
    }

    //Constructora
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



    /**
    * S'afegeix l'element e a la clausula.
    * @param a, d, h son l'aula el día i l'hora.
    */

    //Métodos


    public void setClausula(ArrayList<ClausulaNom> clausula) {
        this.clausula = clausula;
    }


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

    public void setGrup(Integer id) {
        this.grup = id;
    }

    public void setAssignatura(Assignatura nom) {
        this.assignatura = nom;
    }

    public void setDuracio(Integer h) {
        this.duracio = h;
    }


    public Assignatura getAssignatura() {
        return assignatura;
    }

    public Integer getDuracio() {
        return duracio;
    }

    public Integer getGrup() {
        return grup;
    }

    public CjtRestAssignatura getCjtRestAss() {
        return cjtRestAss;
    }

    public CjtRestGrupSessio getCjtRestGS() {
        return cjtRestGS;
    }

    public CjtRestGrupoAula getCjtRestGA() {
        return cjtRestGA;
    }

    public CjtRestSolapament getCjtRestS() {
        return cjtRestS;
    }

    public CjtRestriccioAula getCjtRestAula() {
        return cjtRestAula;
    }

    public void setCjtRestAss(CjtRestAssignatura cjtRestAss) {
        this.cjtRestAss = cjtRestAss;
    }

    public void setCjtRestGS(CjtRestGrupSessio cjtRestGS) {
        this.cjtRestGS = cjtRestGS;
    }

    public void setCjtRestGA(CjtRestGrupoAula cjtRestGA) {
        this.cjtRestGA = cjtRestGA;
    }

    public void setCjtRestS(CjtRestSolapament cjtRestS) {
        this.cjtRestS = cjtRestS;
    }

    public void setCjtRestAula(CjtRestriccioAula cjtRestAula) {
        this.cjtRestAula = cjtRestAula;
    }
    
    void addClausula(ArrayList<ClausulaNom> cnaux) {
        this.clausula.addAll(cnaux);
    }
    private boolean compleixRestsAssignatura(ClausulaNom cn){
        return this.cjtRestAss.ComprovarRes(cn,this.duracio);
    }
    private boolean compleixRestsGrupSessio(ClausulaNom cn){
        return this.cjtRestGS.ComprovarRes(cn,this.duracio);
    }
    private boolean compleixRestsGrupoAula(ClausulaNom cn){
        return this.cjtRestGA.ComprovarRes(cn.getAula());
    }
    private boolean compleixRestsAula(ClausulaNom cn){
        return this.cjtRestAula.ComprovarRes(cn, this.duracio);
    }
    public boolean compleixRestsSolapament(Clausula c, ClausulaNom cn, Clausula e,int h,String dia){
        //return this.cjtRestS.ComprovarRess(this.assignatura.getNom(), this.grup, e);
        return this.cjtRestS.ComprovarRes(c, cn, e, h, dia);
    }
    private boolean compleixResDomini(ClausulaNom cn){
        if(!compleixRestsAssignatura(cn)) return false;
        else if(!compleixRestsGrupSessio(cn)) return false;
        else if(!compleixRestsGrupoAula(cn)) return false;
        else if(!compleixRestsAula(cn)) return false;
        else return true;
    }
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