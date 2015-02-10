
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
public class Respuesta {

    private int codigo;
    private String texto;
    private boolean correcta;
    private Pregunta pregunta;

    public Respuesta() {

    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta p) {
        this.pregunta = p;
    }
    String imagen;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
