/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;

/**
 *
 * @author Daniel Albarral
 */
class Generador {

    private Quadricula horari;
    private CjtRestGrupoAula cjtRaula;

    public Generador() {
    }

    public Generador(CjtRestGrupoAula rga) {
        this.horari = new Quadricula();
        this.cjtRaula = rga;
    }


    public ArrayList<Aula> cjtCapacitatMajorDeL (int x,ArrayList<AulaLab> a){
         ArrayList<Aula> listaRefactor= new  ArrayList<Aula>();
        for (AulaLab au: a) {
            if (au.capacitatMajorDe(x)) listaRefactor.add(au);
        }
        return listaRefactor;
    }
    
        public ArrayList<Aula> cjtCapacitatMajorDeT (int x,ArrayList<AulaTeo> a){
         ArrayList<Aula> listaRefactor= new  ArrayList<Aula>();
        for (AulaTeo au: a) {
            if (au.capacitatMajorDe(x)) listaRefactor.add(au);
        }
        return listaRefactor;
    }   
            
    private ArrayList<Clausula> inicialitzarClausules(ArrayList<AulaTeo> aulesT, 
            ArrayList<AulaLab> aulesL, ArrayList<Assignatura> ass, RestriccioTemps dis) {
        ArrayList<Clausula> clausules = new ArrayList();
        for (int i = 0; i < ass.size(); ++i) {
            Assignatura a;
            a = ass.get(i);
            ArrayList<Integer> gup = a.getGrups();
            for (int k = 0; k < gup.size(); ++k) {
                Integer g = gup.get(k);
                String nomAul;
                String dia;
                Integer hora;
                ArrayList<Integer> interval = new ArrayList<Integer>();
                ArrayList<Aula> aulesPos = new ArrayList<Aula>();
                //Inicialitzacio clausules amb grups de laboratori         
                if (g % 10 != 0) {  //GupsLab
                     aulesPos = cjtCapacitatMajorDeL(a.getCapacitatLab(),aulesL);
                     interval = a.getIntervalsP();
                } else { //GrupsTeo
                    aulesPos = cjtCapacitatMajorDeT(a.getCapacitatTeo(),aulesT);
                    interval = a.getIntervalsT();
                }
                for (Integer h : interval) {
                    Clausula c = new Clausula();
                    c.setAssignatura(a);
                    c.setDuracio(h);
                    c.setGrup(g);
                    ArrayList<ClausulaNom> cnaux = new ArrayList<ClausulaNom>();
                    //Inicialitzacio del domini
                    for (Aula au : aulesPos) {
                        boolean doo = true;//false;       
                        if (au.getClass().equals(AulaLab.class)) {
                            AulaLab aal = (AulaLab) au;/*
                             if (aal.getMaterial() && a.necesitaMaterial())
                             doo = true;*/
                        }
                        if (au.getClass().equals(AulaTeo.class)) {
                            AulaTeo aat = (AulaTeo) au;/*
                             if (aat.getProjector()&& a.necesitaProjector())
                             doo = true;*/
                        }
                        if (doo) {
                            for (int j = 0; j < 7; ++j) {
                                if (j == 0) {
                                    for (Integer d : dis.getDilluns()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dilluns");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn)) cnaux.add(cn);
                                    }
                                }
                                if (j == 1) {
                                    for (Integer d : dis.getDimarts()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dimarts");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn)) cnaux.add(cn);
                                    }
                                }
                                if (j == 2) {
                                    for (Integer d : dis.getDimecres()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dimecres");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn)) cnaux.add(cn);
                                    }
                                }
                                if (j == 3) {
                                    for (Integer d : dis.getDijous()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dijous");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn)) cnaux.add(cn);
                                    }
                                }
                                if (j == 4) {
                                    for (Integer d : dis.getDivendres()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("divendres");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn)) cnaux.add(cn);
                                    }
                                }
                                if (j == 5) {
                                    for (Integer d : dis.getDissabte()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dissabte");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn)) cnaux.add(cn);   
                                    }
                                }
                                if (j == 6) {
                                    for (Integer d : dis.getDiumenge()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("diumenge");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn)) cnaux.add(cn);
                                    }
                                }
                            }
                            c.setClausula(cnaux);
                        }
                    }                 
                    clausules.add(c);
                }
            }
        }
        return clausules;
    }

    public boolean assignacioValida(Quadricula q, Element e, String dia, int hora) {
        CjtElements elems = q.getElementsPosicio(dia, hora);//elements d aquella posicio

        if (!elems.isValid()) {
            return false; // en principio no deberia pasar ya de por si
        }
        // que en aquella hora nomes hi hagi un grup per aula
        if (!elems.aulaRepetida(e)) {
            return false;
        }
        //si es vol posar un grup de lab on hi ha un de teoria o al reves 
        if (elems.solapamentTeoriaPractica(e)) {
            return false;
        }
/*
        if (elems.solapamentNivell(e,cjtAss)){
            return false;
        }
*/
        return true;
    }

    public boolean generar(ArrayList<AulaTeo> aulesT, ArrayList<AulaLab> aulesL,
            ArrayList<Assignatura> ass,RestriccioTemps dis, Quadricula q) {
        ArrayList<Clausula> clau = inicialitzarClausules(aulesT, aulesL, ass, dis);
        return backtracking(clau, q);
    }

    private boolean backtracking(ArrayList<Clausula> clau, Quadricula qu) {
        if (clau.isEmpty()) { // Tenim una solucio
            return true;
        } else {
            Clausula c = clau.get(0);
            clau.remove(0);
            for (ClausulaNom cn : c.getClausula()) {
                Element e = new Element();
                e.setAssignatura(c.getAssignatura());
                e.setAula(cn.getAula());
                e.setGrupo(c.getGrup());
                int duracio = c.getDuracio();
                int esVal = 0;
                boolean omfg = true; //para si asignamos y sale del horario
                if (duracio+cn.getHora() > 23) omfg = false;
                for (int i = 0; i < duracio && omfg; ++i) {
                    int hor = cn.getHora()+i;
                    String di = cn.getDia();
                    qu.afegirElement(di, hor, e);
                    if (! assignacioValida(qu, e, di, hor)) ++esVal;
                }
                if (esVal == 0) {
                    boolean b = backtracking(clau, qu);
                    if (b) return true;
                    else {
                        for (int i = 0; i < duracio; ++i) {
                            int hor = cn.getHora() + i;
                            String di = cn.getDia();
                            qu.borrarElement(di, hor, e);
                        }
                    }
                } 
                else {
                    for (int i = 0; i < duracio; ++i) {
                        int hor = cn.getHora() + i;
                        String di = cn.getDia();
                        qu.borrarElement(di, hor, e);
                    }
                }
            }
            return false;
        }
    }

    private boolean compleixResDomini(Clausula c, ClausulaNom cn) {
        boolean b = cjtRaula.ComprovarRes(c, cn);
        
        
        
        return true;
    }
}
