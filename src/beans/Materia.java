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

    private int codigo;
    private String nombre;
    private AreaDeConocimiento areaConocimiento;

    public Materia() {

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the areaConocimiento
     */
    public AreaDeConocimiento getAreaConocimiento() {
        return areaConocimiento;
    }

    /**
     * @param areaConocimiento the areaConocimiento to set
     */
    public void setAreaConocimiento(AreaDeConocimiento areaConocimiento) {
        this.areaConocimiento = areaConocimiento;
    }

}
