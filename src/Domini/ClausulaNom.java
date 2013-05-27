/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Daniel Albarral
 */
public class ClausulaNom {


    private Aula aula; 
    private String dia; 
    private int hora; 
    
    /**
     * Constructora per defecte
     */
    public ClausulaNom() {
    }
    /**
     * Constructora que inicialitza amb els parametres introduits
     * @param a Aula possible de una clausula
     * @param d Dia possible de una clausula
     * @param h Hora possible de una clausula
     */
    public ClausulaNom(Aula a, String d, int h) {
        this.aula = a;
        this.dia = d;
        this.hora = h;
    }
    /**
     * Obtenir la Aula 
     * @return Retorna la aula 
     */
    public Aula getAula() {
        return aula;
    }
    /**
     * Afegeix una aula 
     * @param aula Aula que es vol afegir
     */
    public void setAula(Aula aula) {
        this.aula = aula;
    }
    /**
     * Obtenir dia
     * @return Retorna el dia
     */
    public String getDia() {
        return dia;
    }
    /**
     * Afegeix un dia
     * @param dia Dia que es vol afegir
     */
    public void setDia(String dia) {
        this.dia = dia;
    }
    /**
     * Obtenir la hora
     * @return Retorna la hora
     */
    public int getHora() {
        return hora;
    }
    /**
     * Afegeix una hora
     * @param hora Hora que es vol afegir
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

   
    
}
