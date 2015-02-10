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
public class CuestionarioVariacion {

    private int codigo;
    private Cuestionario cuestionarioPadre;
    private String fechaCreacion;
    private Usuario autor;

    public CuestionarioVariacion() {

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
     * @return the cuestionarioPadre
     */
    public Cuestionario getCuestionarioPadre() {
        return cuestionarioPadre;
    }

    /**
     * @param cuestionarioPadre the cuestionarioPadre to set
     */
    public void setCuestionarioPadre(Cuestionario cuestionarioPadre) {
        this.cuestionarioPadre = cuestionarioPadre;
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
}
