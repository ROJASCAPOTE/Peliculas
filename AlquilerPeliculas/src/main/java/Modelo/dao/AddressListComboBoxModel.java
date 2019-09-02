/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.dao;

import Modelo.vo.AddressVO;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;

/**
 *
 * @author ACER E5
 */
public class AddressListComboBoxModel extends AbstractListModel implements ComboBoxModel {

    private Object selectedItem;
    private ArrayList<AddressVO> addressList;

    public AddressListComboBoxModel(ArrayList<AddressVO> addressList) {
        this.addressList = addressList;
    }

    @Override
    public int getSize() {
        return addressList.size();
    }

    @Override
    public Object getElementAt(int i) {
        return addressList.get(i);
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    @Override
    public void setSelectedItem(Object newValue) {
        selectedItem = newValue;
    }

}
