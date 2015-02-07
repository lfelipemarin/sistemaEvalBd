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
public class Prueba {
    int codigo;
    Date fechaCreacion;
    int cuestionario;
    Date fechaAplicacion;
    int duracion;
    int grupo;
    int usuarioProgramador;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public int getCuestionario() {
        return cuestionario;
    }

    public void setCuestionario(int cuestionario) {
        this.cuestionario = cuestionario;
    }

    public Date getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(Date fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getUsuarioProgramador() {
        return usuarioProgramador;
    }

    public void setUsuarioProgramador(int usuarioProgramador) {
        this.usuarioProgramador = usuarioProgramador;
    }
}
