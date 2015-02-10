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
public class Pregunta {

    private int codigo;
    private String enunciado;
    private int tipo;
    private Materia materia;
    private boolean habilitado;
    private String fechaCreacion;
    private Contexto contexto;
    private Usuario autor;
    private GradoDeDificultad gradoDificultad;
    private String imagen;
    private NivelEvaluativo nivelEvaluativo;

    public Pregunta() {

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
     * @return the enunciado
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * @param enunciado the enunciado to set
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the materia
     */
    public Materia getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    /**
     * @return the habilitado
     */
    public boolean isHabilitado() {
        return habilitado;
    }

    /**
     * @param habilitado the habilitado to set
     */
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the contexto
     */
    public Contexto getContexto() {
        return contexto;
    }

    /**
     * @param contexto the contexto to set
     */
    public void setContexto(Contexto contexto) {
        this.contexto = contexto;
    }

    /**
     * @return the autor
     */
    public Usuario getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    /**
     * @return the gradoDificultad
     */
    public GradoDeDificultad getGradoDificultad() {
        return gradoDificultad;
    }

    /**
     * @param gradoDificultad the gradoDificultad to set
     */
    public void setGradoDificultad(GradoDeDificultad gradoDificultad) {
        this.gradoDificultad = gradoDificultad;
    }

    /**
     * @return the imagen
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * @param imagen the imagen to set
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    /**
     * @return the nivelEvaluativo
     */
    public NivelEvaluativo getNivelEvaluativo() {
        return nivelEvaluativo;
    }

    /**
     * @param nivelEvaluativo the nivelEvaluativo to set
     */
    public void setNivelEvaluativo(NivelEvaluativo nivelEvaluativo) {
        this.nivelEvaluativo = nivelEvaluativo;
    }
}
