/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Stack;

/**
 *
 * @author Daniel Albarral
 */
class Generador {

    private ArrayList<Clausula> clausules;
    
    public Generador(ArrayList<Clausula> c) {
        this.clausules = c;
    }
   
    public Generador() {
        this.clausules = new ArrayList();
    }
    
    /**
     * Retorna un subset de les aules de Laboratori amb capacitat major de x
     * @param x
     * @param a
     * @return Retorna un ArrayList d'aula, tots els elements tenen capacitat major d'x.
     */
    public ArrayList<Aula> cjtCapacitatMajorDeL (int x,ArrayList<AulaLab> a){
         ArrayList<Aula> listaRefactor= new  ArrayList<Aula>();
        for (AulaLab au: a) {
            if (au.capacitatMajorDe(x)) listaRefactor.add(au);
        }
        return listaRefactor;
    }
    
     /**
     * Retorna un subset de les aules de Teoria amb capacitat major de x
     * @param x
     * @param a
     * @return Retorna un ArrayList d'aula, tots els elements tenen capacitat major d'x.
     */
     public ArrayList<Aula> cjtCapacitatMajorDeT (int x,ArrayList<AulaTeo> a){
         ArrayList<Aula> listaRefactor= new  ArrayList<Aula>();
        for (AulaTeo au: a) {
            if (au.capacitatMajorDe(x)) listaRefactor.add(au);
        }
        return listaRefactor;
    }   
     public void inicialitzarClausules(ArrayList<Assignatura> ass){
        ArrayList<Clausula> clausules = new ArrayList();
        for (int i = 0; i < ass.size(); ++i) {
            Assignatura a;
            a = ass.get(i);
            ArrayList<Integer> gup = a.getGrups();
            for (int k = 0; k < gup.size(); ++k) {
                Integer g = gup.get(k);
                ArrayList<Integer> interval = new ArrayList<Integer>();
                //Inicialitzacio clausules amb grups de laboratori         
                if (g % 10 != 0) {  //GupsLab
                     interval = a.getIntervalsP();
                } else { //GrupsTeo
                    interval = a.getIntervalsT();
                }
                for (Integer h : interval) {
                    Clausula c = new Clausula();
                    c.setAssignatura(a);
                    c.setDuracio(h);
                    c.setGrup(g);
                    clausules.add(c);
                }
            }
        }
        this.clausules = clausules;
     }
    /**
     * Retorna el domini de totes les clausules del problema, acotat per les restriccions unearies.
     * @param aulesT
     * @param aulesL
     * @param ass
     * @param dis
     * @param q
     * @return Retorna una ArrayList de Clausula, on cada Clausula te el seu domini inicialitzat i acotat.
     */
    private void inicialitzarClausulesNom(ArrayList<AulaTeo> aulesT, 
            ArrayList<AulaLab> aulesL, RestriccioTemps dis ,Quadricula q) {
        for (int i = 0; i < this.clausules.size(); ++i) {
            Clausula c = this.clausules.get(i);
            ArrayList<ClausulaNom> l = new ArrayList();
            c.setClausula(l);
            Assignatura a = c.getAssignatura();
            ArrayList<Aula> aulesPosT = new ArrayList<Aula>();
            ArrayList<Aula> aulesPosL = new ArrayList<Aula>();
            aulesPosL = cjtCapacitatMajorDeL(a.getCapacitatLab(),aulesL);
            aulesPosT = cjtCapacitatMajorDeT(a.getCapacitatTeo(),aulesT);
            Integer g = c.getGrup();
            ArrayList<Aula> aulesPos = new ArrayList<Aula>();        
            if (g % 10 != 0) aulesPos = aulesPosL; //GrupsLAB
            else aulesPos = aulesPosT; //GrupsTeo
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
                                            if (horesiLimits(c,cn,q)) cnaux.add(cn);
                                        }
                                    }
                                    else if (j == 1) {
                                        for (Integer d : dis.getDimarts()) {
                                            ClausulaNom cn = new ClausulaNom();
                                            cn.setAula(au);
                                            cn.setDia("dimarts");
                                            cn.setHora(d);
                                            if (horesiLimits(c,cn,q)) cnaux.add(cn);
                                        }
                                    }
                                    else if (j == 2) {
                                        for (Integer d : dis.getDimecres()) {
                                            ClausulaNom cn = new ClausulaNom();
                                            cn.setAula(au);
                                            cn.setDia("dimecres");
                                            cn.setHora(d);
                                            if (horesiLimits(c,cn,q)) cnaux.add(cn);
                                        }
                                    }
                                    else if (j == 3) {
                                        for (Integer d : dis.getDijous()) {
                                            ClausulaNom cn = new ClausulaNom();
                                            cn.setAula(au);
                                            cn.setDia("dijous");
                                            cn.setHora(d);
                                            if (horesiLimits(c,cn,q)) cnaux.add(cn);
                                        }
                                    }
                                    else if (j == 4) {
                                        for (Integer d : dis.getDivendres()) {
                                            ClausulaNom cn = new ClausulaNom();
                                            cn.setAula(au);
                                            cn.setDia("divendres");
                                            cn.setHora(d);
                                            if (horesiLimits(c,cn,q)) cnaux.add(cn);
                                        }
                                    }
                                    else if (j == 5) {
                                        for (Integer d : dis.getDissabte()) {
                                            ClausulaNom cn = new ClausulaNom();
                                            cn.setAula(au);
                                            cn.setDia("dissabte");
                                            cn.setHora(d);
                                            if (horesiLimits(c,cn,q)) cnaux.add(cn);   
                                        }
                                    }
                                    else if (j == 6) {
                                        for (Integer d : dis.getDiumenge()) {
                                            ClausulaNom cn = new ClausulaNom();
                                            cn.setAula(au);
                                            cn.setDia("diumenge");
                                            cn.setHora(d);
                                            if (horesiLimits(c,cn,q)) cnaux.add(cn);
                                        }
                                    }
                                }
                                c.addClausula(cnaux);
                            }   
                    }            
                }
            }
            
  
    
    /**
     * 
     * @param cn
     * @param c
     * @param duracio
     * @return 
     */
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
        }
        return true;
        
    }

    private boolean horesiLimits(Clausula c, ClausulaNom cn, Quadricula q) {
       /* if( !this.cjtRestGS.ComprovarRes(c, cn)) return false;   
        if (!cjtRgraula.ComprovarRes(c, cn.getAula())) return false;
        if (!cjtRass.ComprovarRes(c,cn)) return false;
        if (!cjtRula.ComprovarRes(c,cn)) return false;*/
        if (!suficientHoresSegui(c,cn,q)) return false;
        if (foraLimits (c,cn)) return false;
        return true;
    }
    /* private boolean compleixResDomini(Clausula c, ClausulaNom cn,Element e) {
        if (!c.compleixRestsAssignatura(cn)) return false;   
        else if(!c.compleixRestsAula(cn)) return false;
        else if(! c.compleixRestsGrupSessio(cn)) return false;
        else if(!c.compleixRestsGrupoAula(cn)) return false;
        else if(!c.compleixRestsSolapament(e)) return false;
        return true;
    }*/
    private void reduirClausulesNom(){
        for(Clausula c : this.clausules){
            c.reduccioClausules();
        }
    }
    private Stack<ArrayList<Clausula>> backUp;
    
    public boolean generar(ArrayList<AulaTeo> aulesT, ArrayList<AulaLab> aulesL,
            ArrayList<Assignatura> ass,RestriccioTemps dis, Quadricula q) {
        //inicialitzarCjtRestriccions(cjtResGA, cjtRestAss, cjtRestGS, cjtRestS,cjtRestAul);
        inicialitzarClausulesNom(aulesT, aulesL, dis, q);
        reduirClausulesNom();
        backUp = new Stack<ArrayList<Clausula>>();  		
	long timeInMillis = System.currentTimeMillis();
        boolean b = backtracking(this.clausules, q,0);
        long timeInMillis1 = System.currentTimeMillis();
        System.out.println("-------------Time in milis-------------");
        System.out.println(timeInMillis1-timeInMillis);
        System.out.println("-------------Time in milis-------------\n");
        return b;
    }

    private boolean backtracking(ArrayList<Clausula> clau, Quadricula qu, int j) {
        if (clau.size() == j) return true;
        else {
            Clausula c = clau.get(j);
            for (ClausulaNom cn : c.getClausula()) {
                Element e = new Element();
                e.setAssignatura(c.getAssignatura());
                e.setAula(cn.getAula());
                e.setGrupo(c.getGrup());
                int duracio = c.getDuracio();
                boolean esVal = true;
                int i = 0;
                ArrayList<Clausula> auxc = new ArrayList<Clausula>();
                for (Clausula caa : clau) {
                    Clausula aux = new Clausula(caa);
                    auxc.add(aux);
                }
                while (i < duracio && esVal) {
                    int hor = cn.getHora()+i;
                    String di = cn.getDia();
                    qu.afegirElement(di, hor, e);
                    if (!propagaRest(clau, cn, c,hor,j)) esVal = false;
                    ++i;
                }
                if (esVal) return backtracking(clau, qu,j+1);
                else {
                    clau = auxc;
                    while (i >= 0){
                       int hor = cn.getHora() + i;
                       String di = cn.getDia();
                       qu.borrarElement(di, hor, e);
                       --i;
                    }
                }
            }
            return false;
        }
    }
/*
    public boolean AfegirRestriccioGrupSessio(String nomA, int grup, String dia, int hora,int id) {
       int d;
        if ( dia.equals("dilluns") ) d = 0;
        else if ( dia.equals("dimarts") ) d = 1;
        else if ( dia.equals("dimecres") ) d = 2;
        else if ( dia.equals("dijous") ) d = 3;
        else if ( dia.equals("divendres") ) d = 4;
        else if ( dia.equals("dissabte") ) d = 5;
        else d = 6;
        return true;
    }*/

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
            Clausula c,int hor, int p){
        Stack<Clausula> stackclau  = new Stack<Clausula>();
        int j = 0;
        for (int i = p+1; i < clau.size(); ++i) {
            Clausula cl = clau.get(i);
            ++j;
            Clausula cla = new Clausula(cl);
            int u = 0;
            while ( u < cl.getClausula().size()) {
                ClausulaNom cln = cl.getClausula().get(u);
                if (conflicte(cn,c,cl,cln,hor,cn.getDia())) cl.borrarElem(cln);//si hay conflictos borra el elemento 
                else ++u;
            }
            if (cl.getClausula().isEmpty()) return false;
        }        
        return true;
    }
    
    private boolean conflicte(ClausulaNom cn, Clausula c, Clausula cl, 
            ClausulaNom cln, int hor,String dia) {
         if (solapamentTeoriaPractica (cn,c,cl,cln,hor)) return true;
         if (aulaRepetida(cn,c,cl,cln,hor)) return true;
         //if(!this.cjtRestS.ComprovarRes(cl, cln, c,hor,cn.getDia())) return true;
         if(!c.compleixRestsSolapament(cl,cln,c,hor,dia));
         //if (mateixNivell(cn,c,cl,cln,hor)) return true;
         return false;
    }
    
    private boolean solapamentTeoriaPractica (ClausulaNom cn, Clausula c, 
            Clausula cl,ClausulaNom cln, int hor) {
        if (    c.getAssignatura().equals(cl.getAssignatura()) &&
                cn.getDia().equals(cln.getDia()) &&
                hor-cl.getDuracio() < cln.getHora() && 
                hor >= cln.getHora() &&
                c.getGrup()%10 != cl.getGrup()%10 &&
                c.getGrup()/10 == cl.getGrup()/10) return true;
        return false;
    }

    private boolean aulaRepetida(ClausulaNom cn, Clausula c, Clausula cl, 
            ClausulaNom cln, int hor) {
        if (    cn.getDia().equals(cln.getDia()) &&
                hor-cl.getDuracio() < cln.getHora() && 
                hor >= cln.getHora() &&
                cn.getAula().equals(cln.getAula()) 
                ) return true;
        return false;
    }

    private boolean mateixNivell(ClausulaNom cn, Clausula c, Clausula cl, 
            ClausulaNom cln, int hor) {
                if (    cn.getDia().equals(cln.getDia()) &&
                hor-cl.getDuracio() < cln.getHora() && 
                hor >= cln.getHora() &&
                !c.getAssignatura().equals(cl.getAssignatura()) &&
                c.getAssignatura().getNivell() == cl.getAssignatura().getNivell()
                ) return true;
        return false;
    }
    
    
}