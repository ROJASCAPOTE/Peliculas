package Controlador;

import Modelo.Connection.ConnectionBD;
import Modelo.dao.MYSQLDaoManager;
import Vista.FrmPrincipal;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal {

    public static void main(String[] args) {
        ConnectionBD conn = ConnectionBD.getInstance();
        MYSQLDaoManager manager = new MYSQLDaoManager(conn);
        FrmPrincipal frmPrincipal = new FrmPrincipal(manager);

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(frmPrincipal);
            frmPrincipal.setLocationRelativeTo(null);
            frmPrincipal.setTitle("Control de Inventario-peliculas");
            frmPrincipal.setVisible(true);
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
        }
    }

}
