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
public class Evaluacion {

    private int codigo;
    private Prueba prueba;
    private Usuario estudiante;
    private double calificacion;
    
    public Evaluacion(){        
    }

    public double getValorAprobacion() {
        return valorAprobacion;
    }

    public void setValorAprobacion(double valorAprobacion) {
        this.valorAprobacion = valorAprobacion;
    }
    double valorAprobacion;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Prueba getPrueba() {
        return prueba;
    }

    public void setPrueba(Prueba prueba) {
        this.prueba = prueba;
    }

    public Usuario getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Usuario estudiante) {
        this.estudiante = estudiante;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    
}
