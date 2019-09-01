/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conection;

import Vista.FmrTienda;
import Vista.FrmPrincipal;

/**
 *
 * @author ACER E5
 */
public class Start {
    public static void main(String[] args) {
        new ViewStore(new FrmPrincipal() ).iniciar();
    }
}
