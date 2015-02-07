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
    int contexto;
    int autor;
    int gradoDificultad;
    String imagen;
    int nivelEvaluativo;

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

    public int getGradoDificultad() {
        return gradoDificultad;
    }

    public void setGradoDificultad(int gradoDificultad) {
        this.gradoDificultad = gradoDificultad;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getNivelEvaluativo() {
        return nivelEvaluativo;
    }

    public void setNivelEvaluativo(int nivelEvaluativo) {
        this.nivelEvaluativo = nivelEvaluativo;
    }

}