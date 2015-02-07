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
public class RespuestaPreguntaPorCuestionario {

    int codigo;
    int pregunta_x_cuestionario;
    int respuesta;
    int indice;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPregunta_x_cuestionario() {
        return pregunta_x_cuestionario;
    }

    public void setPregunta_x_cuestionario(int pregunta_x_cuestionario) {
        this.pregunta_x_cuestionario = pregunta_x_cuestionario;
    }

    public int getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(int respuesta) {
        this.respuesta = respuesta;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}
