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

    public RestGrupoAula() {
        super(0);
    }
    
    public RestGrupoAula(String assignatura, Integer grupo, String aula) {
        super (0);
        this.assignatura = assignatura;
        this.grup = grupo;
        this.aula = aula;
    }
    
    public String getAssignatura() {
        return assignatura;
    }

    public void setAssignatura(String assignatura) {
        this.assignatura = assignatura;
    }

    public Integer getGrupo() {
        return grup;
    }

    public void setGrupo(Integer grupo) {
        this.grup = grupo;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }
    
    @Override
    public boolean CompleixRes(){return false;}
    
    
    public boolean esPotCrear(CjtRestriccions cjtR) {
        return true;
    }
    
    public boolean CompleixRes(String assignatura, int grup, String aula) {
        boolean comp = true;
        if (this.assignatura.equals(assignatura)  && this.grup == grup) {
            if (!this.aula.equals(aula)) comp = false;
        }
        return comp;
    }
    
    
    
}
