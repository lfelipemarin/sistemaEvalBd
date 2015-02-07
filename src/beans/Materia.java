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
public class Materia {

    int codigo;
    String nombre;
    int area_conocimiento;

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

    public int getArea_conocimiento() {
        return area_conocimiento;
    }

    public void setArea_conocimiento(int area_conocimiento) {
        this.area_conocimiento = area_conocimiento;
    }
}
