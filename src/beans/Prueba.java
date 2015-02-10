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
public class Prueba {

    private int codigo;
    private String fechaCreacion;
    private Cuestionario cuestionario;
    private String fechaAplicacion;
    private int duracion;
    private Grupo grupo;
    private Usuario usuarioProgramador;

    public Prueba() {

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
     * @return the fechaAplicacion
     */
    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    /**
     * @param fechaAplicacion the fechaAplicacion to set
     */
    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    /**
     * @return the duracion
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * @param duracion the duracion to set
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    /**
     * @return the grupo
     */
    public Grupo getGrupo() {
        return grupo;
    }

    /**
     * @param grupo the grupo to set
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * @return the usuarioProgramador
     */
    public Usuario getUsuarioProgramador() {
        return usuarioProgramador;
    }

    /**
     * @param usuarioProgramador the usuarioProgramador to set
     */
    public void setUsuarioProgramador(Usuario usuarioProgramador) {
        this.usuarioProgramador = usuarioProgramador;
    }
}
