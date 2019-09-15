/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.idao;

import Modelo.vo.StaffVO;

/**
 *
 * @author ACER E5
 */
public interface IStaffDAO extends DAO<StaffVO> {

    public int grtCodigo();
}
