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
public class AreaDeConocimientoDePregunta {

    private AreaDeConocimiento area_conocimiento;
    private Pregunta pregunta;

    public AreaDeConocimientoDePregunta() {

    }

    /**
     * @return the area_conocimiento
     */
    public AreaDeConocimiento getArea_conocimiento() {
        return area_conocimiento;
    }

    /**
     * @param area_conocimiento the area_conocimiento to set
     */
    public void setArea_conocimiento(AreaDeConocimiento area_conocimiento) {
        this.area_conocimiento = area_conocimiento;
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
}
