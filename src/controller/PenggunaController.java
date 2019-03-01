/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.JOptionPane;
import model.dao.PenggunaModel;
import model.pojo.Pengguna;
import model.tabel.TableModelPengguna;
import view.PenggunaView;

/**
 *
 * @author Field Engineer
 */
public class PenggunaController {

    private PenggunaView view;
    private PenggunaModel model;
    private List<Pengguna> listData;

    public PenggunaController(PenggunaView view) {
        this.view = view;
        model = new PenggunaModel();
    }

    //TODO:fungsi reset
    public void reset() {
        //membersihkan textfield
        view.getTxtAlamat().setText("");
        view.getTxtNama().setText("");
        view.getTxtPassword().setText("");
        view.getTxtTelepon().setText("");
        view.getTxtAlamat().setText("");
        //membersihkan radio button
        view.getBgJenisKelamin().clearSelection();
        //membersihkan combobox
        view.getCbJabatan().setSelectedIndex(-1);
        view.getTxtUsername().setEnabled(true);
        //setting on/off button
        view.getBtnReset().setEnabled(true);
        view.getBtnSimpan().setEnabled(true);
        view.getBtnUbah().setEnabled(false);
        view.getBtnHapus().setEnabled(false);
    }

    //      fungsi baca dari form
    public Pengguna getDataDariView() {
        Pengguna data = new Pengguna();
        //mengambil data dari text component
        data.setUsername(view.getTxtUsername().getText());
        data.setPassword(view.getTxtPassword().getText());
        data.setNama(view.getTxtNama().getText());
        data.setAlamat(view.getTxtAlamat().getText());
        data.setTelepon(view.getTxtTelepon().getText());

        //mengambil data dari combobox
        data.setJabatan(view.getCbJabatan().getSelectedItem().toString());
        //mengambil data button group radiobutton
        data.setJenkel(view.getBgJenisKelamin().getSelection().getActionCommand());
        return data;
    }

    //      fungsi simpan data
    public void simpan() {
        Pengguna data= getDataDariView();

        if (model.simpan(getDataDariView())) {
            JOptionPane.showMessageDialog(view, "berhasil simpan");
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Simpan");
        }
    }

    public void isiTabel() {
        listData = model.getSemuaData();
        TableModelPengguna table = new TableModelPengguna(listData);
        view.getTabelPengguna().setModel(table);
    }

    public void isiForm(int row) {
        //mengisi data text component
        view.getTxtUsername().setText(listData.get(row).getUsername());
        view.getTxtPassword().setText(listData.get(row).getPassword());
        view.getTxtNama().setText(listData.get(row).getNama());
        view.getTxtAlamat().setText(listData.get(row).getAlamat());
        view.getTxtTelepon().setText(listData.get(row).getTelepon());

        //mengisi data combobox
        view.getCbJabatan().setSelectedItem(listData.get(row).getJabatan());
        //mengisi data buttongroup
        String jenkel = listData.get(row).getJenkel();
        if (jenkel.equals(view.getRbPria().getActionCommand())) {
            view.getRbWanita().setEnabled(true);
        }
        //matiin txt username
        view.getTxtUsername().setEnabled(false);
        //setting on/off button
        view.getBtnReset().setEnabled(true);
        view.getBtnSimpan().setEnabled(false);
        view.getBtnUbah().setEnabled(true);
        view.getBtnHapus().setEnabled(true);

    }

    //      fungsi tampil
    public void ubah() {

        if (model.ubah(getDataDariView())) {
            JOptionPane.showMessageDialog(view, "berhasil simpan");
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Simpan");
        }
    }

    //fungsi hapus
    public void hapus() {
        String username=view.getTxtUsername().getText();
        
        if (model.hapus(view.getTxtUsername().getText())) {
            JOptionPane.showMessageDialog(view, "berhasil simpan");
        } else {
            JOptionPane.showMessageDialog(view, "Gagal Simpan");
        }
    }

}
