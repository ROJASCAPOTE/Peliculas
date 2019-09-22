/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.idao;

import Modelo.vo.CountryVO;
import javax.swing.JTable;

/**
 *
 * @author ACER E5
 */
public interface ICountryDAO extends DAO<CountryVO> {

    public int getCantidaPaises();
    public void getTableCountry(JTable country);
}
