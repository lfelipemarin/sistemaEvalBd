/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Date;

/**
 *
 * @author eaagudelr
 */
public class CuestionarioVariacion {

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCuestionarioPadre() {
        return cuestionarioPadre;
    }

    public void setCuestionarioPadre(int cuestionarioPadre) {
        this.cuestionarioPadre = cuestionarioPadre;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }
    
    int codigo;
    int cuestionarioPadre;
    Date fechaCreacion;
    int autor;
}
