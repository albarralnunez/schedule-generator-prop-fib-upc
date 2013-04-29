/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel Albarral
 */
public class RestGrupoAula extends Restriccio {



    private String assignatura;
    private Integer grup;
    private String aula;

    /**
     *
     */
    public RestGrupoAula() {
        super(1);
    }
    
       public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }

    public Integer getGrup() {
        return grup;
    }

    public void setGrup(Integer grup) {
        this.grup = grup;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean CompleixRes(){return false;}
    
    
    /**
     *
     * @param cjtRga
     * @param cjtResAul
     * @param cjtResAssig
     * @return
     */
    public boolean esPotAfegir(CjtRestriccions cjtRga,CjtRestriccions cjtResAul,
            CjtRestriccions cjtResAssig) {
        boolean comp = true;
        for (Restriccio  res: cjtRga.getCjtRes()) {
            RestGrupoAula resdw = (RestGrupoAula) res; //Downcast
            if (resdw.getAssignatura().equals(this.assignatura) &&
                    resdw.getGrup() == this.grup) comp = false;
        } //Si ya hay una restriccion del mismo grupo obligado a estar en una aula no podria añadirse !
        for (Restriccio resa : cjtResAul.getCjtRes()) {
            RestriccioAula resAuldw = (RestriccioAula)resa; //Downcast
            if (this.aula.equals(resAuldw.getAula())) {
                for (Restriccio resb : cjtResAssig.getCjtRes()) {
                    RestAssignatura resAssdw = (RestAssignatura)resb;
                    if (this.assignatura.equals(resAssdw.getAssignatura()) &&
                            this.grup == resAssdw.getGrup()){
                        if (resAuldw.getDia() == null) {
                            if (resAssdw.getHora() == resAuldw.getHora())
                                comp = false;
                        }
                        else if (resAuldw.getHora() == -1) { //DANI ESTE -1 HABRIA QUE CAMBIARLO A "NULL" PK HE USADO Integer en vez de int!!
                            if (resAssdw.getDia().equals(resAuldw.getDia()))
                                comp = false;
                        }
                        else {
                            if (resAssdw.getHora() == resAuldw.getHora() && 
                                    resAssdw.getDia().equals(resAuldw.getDia())) {
                                comp = false;
                            }
                        }
                    }
                }
            }
        }
        return comp;
    }
    
    /**
     *
     * @param assignatura
     * @param grup
     * @param aula
     * @return
     */
     public boolean compleixRes(CjtElements el) {
         boolean b = false;
        for (Element elcjt : el.getAssignacions()) {
            if (b) break;
            if (elcjt.getAssignatura().equals(this.assignatura) &&
                    elcjt.getGrupo() == this.grup){
                b = (elcjt.getAula().equals(this.aula));
            }
            else b = true;
        }
        return b;
    }
    
    
    
}
