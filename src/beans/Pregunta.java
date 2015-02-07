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
public class Pregunta {
    
    int codigo;
    String enunciado;
    int tipo;
    int materia;
    boolean habilitado;
    Date fecha_creacion;
    Date fecha_modificacion;
    int contexto;
    int autor;
    int grado_dificultad;
    String imagen;
    int nivel_evaluativo;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getMateria() {
        return materia;
    }

    public void setMateria(int materia) {
        this.materia = materia;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public Date getFecha_modificacion() {
        return fecha_modificacion;
    }

    public void setFecha_modificacion(Date fecha_modificacion) {
        this.fecha_modificacion = fecha_modificacion;
    }

    public int getContexto() {
        return contexto;
    }

    public void setContexto(int contexto) {
        this.contexto = contexto;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public int getGrado_dificultad() {
        return grado_dificultad;
    }

    public void setGrado_dificultad(int grado_dificultad) {
        this.grado_dificultad = grado_dificultad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getNivel_evaluativo() {
        return nivel_evaluativo;
    }

    public void setNivel_evaluativo(int nivel_evaluativo) {
        this.nivel_evaluativo = nivel_evaluativo;
    }
    
}
