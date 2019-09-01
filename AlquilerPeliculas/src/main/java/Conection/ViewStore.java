/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Vista.*;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author ACER E5
 */
public class ViewStore implements ActionListener, MouseListener {

    private FrmPrincipal frmPrincipal;
    private FmrTienda fmrTienda = new FmrTienda();

    public ViewStore(JFrame padre) {
        this.frmPrincipal = (FrmPrincipal) padre;
    }

    public void iniciar() {
        //frmprincipal.setVisible(true); //si no se utiliza SKIN
        // Skin tipo WINDOWS
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frmPrincipal);
            SwingUtilities.updateComponentTreeUI(this.fmrTienda);
            this.frmPrincipal.setLocationRelativeTo(null);
            this.frmPrincipal.setTitle("Control de Inventario - http://www.jc-mouse.net/");
            this.frmPrincipal.setVisible(true);

        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }

        this.frmPrincipal.TIENDA.setActionCommand("TIENDA");
        this.frmPrincipal.TIENDA.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "TIENDA":
                this.fmrTienda.setLocationRelativeTo(null);
                this.fmrTienda.setTitle("TIENDA");
                this.fmrTienda.setVisible(true);
                break;

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
