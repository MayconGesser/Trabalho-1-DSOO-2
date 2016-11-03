package util;

import entidades.Usuario;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Map;

public class TableModelUsuario extends AbstractTableModel {

    private Map<Integer, Usuario> usuarios;
    private ArrayList<String> colunas;

    public TableModelUsuario(Map<Integer, Usuario> usuarios) {
        this.usuarios = usuarios;
        this.colunas = new ArrayList<String>() {
            {
                add("Codigo");
                add("Nome");
                add("CPF");
                add("Telefone");
            }
        };
    }

    @Override
    public int getRowCount() {
        if (this.usuarios == null)
            return 0;
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public String getColumnName(int i) {
        return colunas.get(i);
    }

    @Override
    public Object getValueAt(int r, int c) {
        if (this.usuarios != null) {
            Usuario usuario = usuarios.get(r);

            switch (c) {
                case 0:
                    return usuario.getCodigo();
                case 1:
                    return usuario.getNome();
                case 2:
                    return usuario.getCPF();
                case 3:
                    return usuario.getTelefone();
            }
        }
        return null;
    }
}
