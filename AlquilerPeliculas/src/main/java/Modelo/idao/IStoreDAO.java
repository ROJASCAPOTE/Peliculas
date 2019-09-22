/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.idao;

import Modelo.vo.StoreVO;

/**
 *
 * @author ACER E5
 */
public interface IStoreDAO extends DAO<StoreVO> {

    public int grtCodigoStore();
}
