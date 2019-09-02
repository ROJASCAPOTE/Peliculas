package Controlador;

import Vista.FrmPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {

    public static void main(String[] args) {
        FrmPrincipal frmPrincipal = new FrmPrincipal();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frmPrincipal);
            frmPrincipal.setLocationRelativeTo(null);
            frmPrincipal.setTitle("Control de Inventario - http://www.jc-mouse.net/");
            frmPrincipal.setVisible(true);
        } catch (UnsupportedLookAndFeelException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (InstantiationException ex) {
        } catch (IllegalAccessException ex) {
        }
    }

}
