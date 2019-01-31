/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.util.List;
import model.pojo.Pengguna;
import koneksi.Database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Field Engineer
 */
public class PenggunaModel implements MasterDAO<Pengguna> {

    final String NAMA_TABEL = "pengguna";

    final String Q_INSERT = " INSERT INTO " + NAMA_TABEL
            + "(username, password, nama, alamat, telepon, jenkel, jabatan)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";

    final String Q_UPDATE = " UPDATE " + NAMA_TABEL
            + " SET password =?, nama=?, alamat=?, telepon=?"
            + " , jenkel= ?, jabatan= ? WHERE username= ?";

    final String Q_DELETE = "DELETE FROM " + NAMA_TABEL + "WHERE username=?";
    final String Q_SELECT = "SELECT * FROM " + NAMA_TABEL;
    //TODO : fungsi simpan ke database
    //TODO : fungsi ubah ke database
    //TODO : FUNGSI HAPUS ke database
    //TODO : fungsi ambil semua data table dari database

    @Override
    public boolean simpan(Pengguna object) {
        try (Connection con = Database.KoneksiDB();
                PreparedStatement st = con.prepareStatement(Q_INSERT)) {
            // isi data statement( jangan salah urutan)
            st.setString(1, object.getUsername());
            st.setString(2, object.getPassword());
            st.setString(3, object.getNama());
            st.setString(4, object.getAlamat());
            st.setString(5, object.getTelepon());
            st.setString(6, object.getJenkel());
            st.setString(7, object.getJabatan());
            //eksekusi query
            int hasil = st.executeUpdate();
            //hasilnya
            return (hasil == 1);//true jika 1, dan false jika 0
        } catch (SQLException ex) {
            Logger.getLogger(PenggunaModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean ubah(Pengguna object) {
        try (Connection con = Database.KoneksiDB();
                PreparedStatement st = con.prepareStatement(Q_UPDATE)) {
            // isi data statement( jangan salah urutan)
            st.setString(1, object.getPassword());
            st.setString(2, object.getNama());
            st.setString(3, object.getAlamat());
            st.setString(4, object.getTelepon());
            st.setString(5, object.getJenkel());
            st.setString(6, object.getJabatan());
            st.setString(7, object.getUsername());
            //eksekusi query
            int hasil = st.executeUpdate();
            //hasilnya
            return (hasil == 1);//true jika 1, dan false jika 0
        } catch (SQLException ex) {
            Logger.getLogger(PenggunaModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public boolean hapus(String id) {
        try (Connection con = Database.KoneksiDB();
                PreparedStatement st = con.prepareStatement(Q_DELETE)) {
            // isi data statement( jangan salah urutan)
            st.setString(1, id);

            //eksekusi query
            int hasil = st.executeUpdate();
            //hasilnya
            return (hasil == 1);//true jika 1, dan false jika 0
        } catch (SQLException ex) {
            Logger.getLogger(PenggunaModel.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public List<Pengguna> getSemuaData() {
        List<Pengguna>list=null;

        try (Connection con = Database.KoneksiDB();
                PreparedStatement st = con.prepareStatement(Q_SELECT)) {
            list=new ArrayList<>();
            
            //membuat ResultSet untuk menampung hasil Select
            ResultSet rs =st.executeQuery();
            while(rs.next()){
                Pengguna data=new Pengguna();
                data.setUsername(rs.getString("username"));
                data.setPassword(rs.getString("password"));
                data.setNama(rs.getString("nama"));
                data.setTelepon(rs.getString("telepon"));
                data.setAlamat(rs.getString("alamat"));
                data.setJenkel(rs.getString("jenkel"));
                data.setJabatan(rs.getString("jabatan"));

                list.add(data); //memasukan object pengguna kedalam list.
            }
        } catch (SQLException ex) {
            Logger.getLogger(PenggunaModel.class.getName()).log(Level.SEVERE, null, ex);
        }

        return list;
    }

    @Override
    public List<Pengguna> getCariData(String key) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
