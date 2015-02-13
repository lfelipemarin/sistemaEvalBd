/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author eaagudelr
 */
public class PreguntaPorCuestionario {

    private int codigo;
    private Cuestionario cuestionario;
    private Pregunta pregunta;
    private double porcentaje;
    private int posicionPregunta;
    
    public PreguntaPorCuestionario(){
        
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cuestionario
     */
    public Cuestionario getCuestionario() {
        return cuestionario;
    }

    /**
     * @param cuestionario the cuestionario to set
     */
    public void setCuestionario(Cuestionario cuestionario) {
        this.cuestionario = cuestionario;
    }

    /**
     * @return the pregunta
     */
    public Pregunta getPregunta() {
        return pregunta;
    }

    /**
     * @param pregunta the pregunta to set
     */
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    /**
     * @return the porcentaje
     */
    public double getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the posicionPregunta
     */
    public int getPosicionPregunta() {
        return posicionPregunta;
    }

    /**
     * @param posicionPregunta the posicionPregunta to set
     */
    public void setPosicionPregunta(int posicionPregunta) {
        this.posicionPregunta = posicionPregunta;
    }
}
