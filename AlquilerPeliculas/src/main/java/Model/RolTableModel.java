package Model;

import Modelo.dao.RolesDAO;
import Modelo.idao.IRolesDao;
import Modelo.vo.RolVO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RolTableModel extends AbstractTableModel {

    private List<RolVO> datos = new ArrayList<>();
    private IRolesDao rolDao;

    public RolTableModel(IRolesDao rolDAO) {
        this.rolDao = rolDAO;
    }

    public void updateModel() {
        datos = rolDao.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nombre cortp";
            case 2:
                return "Descripcion";
            default:
                return "[no]";
        }
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    public RolVO seleccionar(int r) {
        RolVO rol = datos.get(r);
        return rol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        RolVO preguntado = datos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return preguntado.getIdRol();
            case 1:
                return preguntado.getNomCorto();
            case 2:
                return preguntado.getDescripcion();
            default:
                return "";

        }
    }

}
