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
public class Cuestionario {
    
    int codigo;
    String nombre;
    int numero_preguntas;
    Date fecha_creacion;
    int auto;
    int cuestionario_padre;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero_preguntas() {
        return numero_preguntas;
    }

    public void setNumero_preguntas(int numero_preguntas) {
        this.numero_preguntas = numero_preguntas;
    }

    public Date getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(Date fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    public int getAuto() {
        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

    public int getCuestionario_padre() {
        return cuestionario_padre;
    }

    public void setCuestionario_padre(int cuestionario_padre) {
        this.cuestionario_padre = cuestionario_padre;
    }
    
}
