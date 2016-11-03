package util;

import controladores.interfaces.IControladorLivro;
import entidades.Livro;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Map;

public class TableModelLivro extends AbstractTableModel {

    private Map<Integer, Livro> livros;
    private ArrayList<String> colunas;

    public TableModelLivro(Map<Integer, Livro> livros) {
        this.livros = livros;
        this.colunas = new ArrayList<String>() {
            {
                add("Codigo");
                add("Titulo");
                add("Autor");
                add("Editora");
                add("Disponivel");
            }
        };
    }

    @Override
    public int getRowCount() {
        if (this.livros == null)
            return 0;
        return livros.size();
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
        if (this.livros != null) {

            Livro livro = livros.get(r);

            switch (c) {
                case 0:
                    return livro.getCodigo();
                case 1:
                    return livro.getTitulo();
                case 2:
                    return livro.getAutor();
                case 3:
                    return livro.getEditora();
                case 4:
                    return livro.estahDisponivel() ? "Sim" : "Não";
            }
        }
        return null;
    }
}
