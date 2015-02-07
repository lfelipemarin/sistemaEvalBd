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
    int preguntaPorCuestionario;
    int respuesta;
    int indice;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getPreguntaPorCuestionario() {
        return preguntaPorCuestionario;
    }

    public void setPreguntaPorCuestionario(int preguntaPorCuestionario) {
        this.preguntaPorCuestionario = preguntaPorCuestionario;
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
