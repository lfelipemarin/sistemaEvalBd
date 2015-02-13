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
public class RespuestaPorPreguntaPorCuestionario {

    private int codigo;
    private PreguntaPorCuestionario preguntaPorCuestionario;
    private Respuesta respuesta;
    private int posicionRespuesta;
    
    public RespuestaPorPreguntaPorCuestionario(){
        
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
     * @return the preguntaPorCuestionario
     */
    public PreguntaPorCuestionario getPreguntaPorCuestionario() {
        return preguntaPorCuestionario;
    }

    /**
     * @param preguntaPorCuestionario the preguntaPorCuestionario to set
     */
    public void setPreguntaPorCuestionario(PreguntaPorCuestionario preguntaPorCuestionario) {
        this.preguntaPorCuestionario = preguntaPorCuestionario;
    }

    /**
     * @return the respuesta
     */
    public Respuesta getRespuesta() {
        return respuesta;
    }

    /**
     * @param respuesta the respuesta to set
     */
    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    /**
     * @return the posicionRespuesta
     */
    public int getPosicionRespuesta() {
        return posicionRespuesta;
    }

    /**
     * @param posicionRespuesta the posicionRespuesta to set
     */
    public void setPosicionRespuesta(int posicionRespuesta) {
        this.posicionRespuesta = posicionRespuesta;
    }

}
