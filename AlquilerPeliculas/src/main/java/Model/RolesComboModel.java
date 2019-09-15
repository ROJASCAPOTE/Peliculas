/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Modelo.dao.StaffDAO;
import Modelo.idao.IRolesDao;
import Modelo.vo.RolVO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author ACER E5
 */
public class RolesComboModel extends DefaultComboBoxModel {

    private IRolesDao rol;
    private List<RolVO> lista;

    public RolesComboModel(IRolesDao rol) {
        this.rol = rol;
        this.lista = new ArrayList();
    }

    public void update(){
        if (rol != null) {
            lista = rol.obtenerTodos();
             
            removeAllElements();
            addElement("Seleccione......");
            for (RolVO p : lista) {
                addElement(new RolComboModelView(p));
            }
        }
    }
}
