/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Daniel Albarral
 */
class Generador {

    private CjtRestGrupoAula cjtRgraula;
    private CjtRestAssignatura cjtRass;
    private CjtRestriccioAula cjtRula;
    private CjtRestGrupSessio cjtRestGS;
    private CjtRestSolapament cjtRestS;
    
    public Generador(CjtRestGrupoAula cjtRgraula, CjtRestAssignatura cjtRass,
            CjtRestriccioAula cjtRula,CjtRestGrupSessio cjtRestGS,
            CjtRestSolapament cjtRestS) {
        this.cjtRgraula = cjtRgraula;
        this.cjtRass = cjtRass;
        this.cjtRula = cjtRula;
        this.cjtRestGS = cjtRestGS;
        this.cjtRestS = cjtRestS;
    }
   
    public Generador() {
        cjtRgraula = new CjtRestGrupoAula();
        cjtRass = new CjtRestAssignatura();
        cjtRula = new CjtRestriccioAula();
        cjtRestGS = new CjtRestGrupSessio();
        cjtRestS = new CjtRestSolapament();
    }
    public void inicialitzarCjtRestriccions(CjtRestGrupoAula cjtResGA,
            CjtRestAssignatura cjtRestAss,CjtRestGrupSessio cjtRestGS,
            CjtRestSolapament cjtRestS,CjtRestriccioAula cjtRestAul){
     cjtRgraula = cjtResGA;
     cjtRass = cjtRestAss;
     cjtRula = cjtRestAul;
     this.cjtRestGS = cjtRestGS;
     this.cjtRestS = cjtRestS;
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
            ArrayList<AulaLab> aulesL, ArrayList<Assignatura> ass, RestriccioTemps dis
            ,Quadricula q) {
        ArrayList<Clausula> clausules = new ArrayList();
        for (int i = 0; i < ass.size(); ++i) {
            Assignatura a;
            a = ass.get(i);
            ArrayList<Integer> gup = a.getGrups();
            for (int k = 0; k < gup.size(); ++k) {
                Integer g = gup.get(k);
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
                    //Inicialitzacio del domini
                    for (Aula au : aulesPos) {
                        ArrayList<ClausulaNom> cnaux = new ArrayList<ClausulaNom>();
                        boolean doo = true;       
                        if (au.getClass().equals(AulaLab.class)) {
                            AulaLab aal = (AulaLab) au;
                             if (!aal.getMaterial() && a.necesitaMaterial())
                             doo = false;
                        }
                        if (au.getClass().equals(AulaTeo.class)) {
                            AulaTeo aat = (AulaTeo) au;
                             if (!aat.getProjector()&& a.necesitaProjector())
                             doo = false;
                        }
                        if (doo) {
                            for (int j = 0; j < 7; ++j) {
                                if (j == 0) {
                                    for (Integer d : dis.getDilluns()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dilluns");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn,q)) cnaux.add(cn);
                                    }
                                }
                                else if (j == 1) {
                                    for (Integer d : dis.getDimarts()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dimarts");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn,q)) cnaux.add(cn);
                                    }
                                }
                                else if (j == 2) {
                                    for (Integer d : dis.getDimecres()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dimecres");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn,q)) cnaux.add(cn);
                                    }
                                }
                                else if (j == 3) {
                                    for (Integer d : dis.getDijous()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dijous");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn,q)) cnaux.add(cn);
                                    }
                                }
                                else if (j == 4) {
                                    for (Integer d : dis.getDivendres()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("divendres");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn,q)) cnaux.add(cn);
                                    }
                                }
                                else if (j == 5) {
                                    for (Integer d : dis.getDissabte()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("dissabte");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn,q)) cnaux.add(cn);   
                                    }
                                }
                                else if (j == 6) {
                                    for (Integer d : dis.getDiumenge()) {
                                        ClausulaNom cn = new ClausulaNom();
                                        cn.setAula(au);
                                        cn.setDia("diumenge");
                                        cn.setHora(d);
                                        if (compleixResDomini(c,cn,q)) cnaux.add(cn);
                                    }
                                }
                            }
                            c.addClausula(cnaux);
                        }
                    }                 
                    clausules.add(c);
                }
            }
        }
        return clausules;
    }
    private boolean duracioConsecutiva(ClausulaNom cn,Clausula c, int duracio){
        ArrayList<ClausulaNom> aux = c.getClausula();
        if(aux.size() > 1) {
            int index = aux.indexOf(cn);
            if((index + (duracio - 1)) < aux.size()){
                int horaActmes1;
                int horaSeg;
                for(int i = 1; i < duracio; ++i){
                    horaActmes1 = aux.get(index).getHora()+1;
                    horaSeg = aux.get(index+1).getHora();
                    if((horaActmes1 != horaSeg) && 
                            (aux.get(index).getAula() == aux.get(index+1).getAula()))
                        return false;
                        ++index;
                }
            }
            //else return false;
        }
        return true;
        
    }
    public boolean assignacioValida(Quadricula q, Element e, String dia, int hora
            ,ClausulaNom cn,Clausula c,int duracioi) { //int i
        CjtElements elems = q.getElementsPosicio(dia, hora);//elements d aquella posicio
        // que en aquella hora nomes hi hagi un grup per aula
        if (!elems.aulaRepetida(e)) return false;
        //si es vol posar un grup de getElementsPosiciolab on hi ha un de teoria o al reves 
        if (elems.solapamentTeoriaPractica(e)) return false;
        //si es vols posar dos assignaturas del mateix nivell
        //if (!elems.solapamentNivell(e)) return false; PENDIENTE!
        //if(i==0){//per fer nomes un cop
            //if(! duracioConsecutiva(cn,c,duracio)) return false; //comprovacio de que el domini sigui seguit
        //}
        return true;
    }

    private boolean compleixResDomini(Clausula c, ClausulaNom cn, Quadricula q) {
        if( !this.cjtRestGS.ComprovarRes(c, cn)) return false;   
        if (!cjtRgraula.ComprovarRes(c, cn)) return false;
        if (!cjtRass.ComprovarRes(c,cn)) return false;
        if (!cjtRula.ComprovarRes(c,cn)) return false;
        if (!suficientHoresSegui(c,cn,q)) return false;
        if (foraLimits (c,cn)) return false;
        return true;
    }
    
    private Stack<Clausula> backUp;
    
    public boolean generar(ArrayList<AulaTeo> aulesT, ArrayList<AulaLab> aulesL,
            ArrayList<Assignatura> ass,RestriccioTemps dis, Quadricula q,
            CjtRestGrupoAula cjtResGA,CjtRestAssignatura cjtRestAss,CjtRestGrupSessio cjtRestGS,
            CjtRestSolapament cjtRestS,CjtRestriccioAula cjtRestAul ) {
        inicialitzarCjtRestriccions(cjtResGA, cjtRestAss, cjtRestGS, cjtRestS,cjtRestAul);
        ArrayList<Clausula> clau = inicialitzarClausules(aulesT, aulesL, ass, dis, q);
        backUp = new Stack<Clausula>();
        return backtracking(clau, q);
    }

    private boolean backtracking(ArrayList<Clausula> clau, Quadricula qu) {
        if (clau.isEmpty()) return true;
        else {
            Clausula c = new Clausula(clau.get(0));
            clau.remove(0);
            boolean esVal = true;
            for (int y = 0; y < c.getClausula().size(); ++y) {
                ClausulaNom cn = c.getClausula().get(y);
                Element e = new Element();
                e.setAssignatura(c.getAssignatura());
                e.setAula(cn.getAula());
                e.setGrupo(c.getGrup());
                int duracio = c.getDuracio();
                esVal = true;
                for (int i = 0; i < duracio; ++i) {
                    if (!esVal) break;
                    int hor = cn.getHora()+i;
                    String di = cn.getDia();
                    qu.afegirElement(di, hor, e);
                    if (!propagaRest(clau, cn, c,hor)) esVal = false;
                }
                if (esVal) {
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
            //clau.add(0,c);
            return false;
        }
    }

    public boolean AfegirRestriccioGrupSessio(String nomA, int grup, String dia, int hora) {
       int d;
        if ( dia.equals("dilluns") ) d = 0;
        else if ( dia.equals("dimarts") ) d = 1;
        else if ( dia.equals("dimecres") ) d = 2;
        else if ( dia.equals("dijous") ) d = 3;
        else if ( dia.equals("divendres") ) d = 4;
        else if ( dia.equals("dissabte") ) d = 5;
        else d = 6;
        RestGrupSessio rgs = new RestGrupSessio(nomA, grup, d, hora);
        return cjtRestGS.afegeixRestriccio( rgs );
    }

    private boolean suficientHoresSegui(Clausula c, ClausulaNom cn, Quadricula q) {
        
        int du = c.getDuracio();
        int h = cn.getHora();
        String di = cn.getDia();
        if (c.getDuracio()+cn.getHora() <= 23) {
            for (int i=0; i < du; ++i) {
                if (!q.getElementsPosicio(di, h+i).isValid()) return false;
            }
        }
        return true;
    }

    private boolean foraLimits(Clausula c, ClausulaNom cn) {
        return (c.getDuracio()+cn.getHora() > 23);
    }

    private boolean propagaRest(ArrayList<Clausula> clau, ClausulaNom cn, 
            Clausula c,int hor){
        Stack<Clausula> stackclau  = new Stack<Clausula>();
        int j = 0;
        for (Clausula cl : clau) {  //Recorremos todas las clausulas
            ++j;
            Clausula cla = new Clausula(cl);
            stackclau.push(cla); //guardamos la clausula por si se han de deshacer los cambios
            for (int u = 0; u < cl.getClausula().size(); ++u) {  //recorregut de totes els elements
                ClausulaNom cln = cl.getClausula().get(u);
                if (conflicte(cn,c,cl,cln,hor)) cl.borrarElem(cln); //si hay conflictos borra el elemento 
            }
            if (cl.getClausula().isEmpty()) {   //si se ha quedado sin elementos no se puede hacer
                while (!stackclau.isEmpty()) { // reestablecemos la estructura
                    --j;
                    clau.remove(j);
                    clau.add(j, stackclau.pop());
                }
                return false;
            }
        }
        return true;
    }
    
    private boolean conflicte(ClausulaNom cn, Clausula c, Clausula cl, 
            ClausulaNom cln, int hor) {
         if (solapamentTeoriaPractica (cn,c,cl,cln,hor)) return true;
         return false;
    }
    
    private boolean solapamentTeoriaPractica (ClausulaNom cn, Clausula c, Clausula cl, 
            ClausulaNom cln, int hor) {
        if (    c.getAssignatura().equals(cl.getAssignatura()) &&
                cn.getDia().equals(cln.getDia()) &&
                cn.getHora()-cl.getDuracio() <= cln.getHora() && 
                cn.getHora()+1 >= cln.getHora()&&
                c.getGrup()%10 != cl.getGrup()%10 &&
                c.getGrup()/10 == cl.getGrup()/10) return true;
                //cn.getHora() >= cln.getHora()+cl.getDuracio())&&) return true;
        return false;
    }
}