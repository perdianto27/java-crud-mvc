/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tabel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.pojo.Pengguna;

/**
 *
 * @author Field Engineer
 */
public class TableModelPengguna extends AbstractTableModel {

    List<Pengguna> list;

    String[] judul = new String[]{"Username", "Nama", "Jabatan", "Telepon"};

    public TableModelPengguna(List<Pengguna> list) {

        this.list = list;

    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return judul.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getUsername();
            case 1:
                return list.get(rowIndex).getNama();
            case 2:
                return list.get(rowIndex).getJabatan();
            case 3:
                return list.get(rowIndex).getTelepon();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int col) {
        return judul[col];
    }

}
