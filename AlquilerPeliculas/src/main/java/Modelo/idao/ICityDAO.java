/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.idao;

import Modelo.vo.CityVO;
import javax.swing.JTable;

/**
 *
 * @author ACER E5
 */
public interface ICityDAO extends DAO<CityVO> {

    public Object[][] getTableCity();

    public int getCantidadCity();
}
