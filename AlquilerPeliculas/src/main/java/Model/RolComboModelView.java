/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Modelo.vo.RolVO;

/**
 *
 * @author ACER E5
 */
public class RolComboModelView {

    private RolVO rol;

    public RolComboModelView(RolVO rol) {
        this.rol = rol;
    }

    public RolVO getProfesor() {
        return rol;
    }

    public void setProfesor(RolVO rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return rol.getNomCorto();
    }

}
