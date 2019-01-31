/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import koneksi.Database;
import model.pojo.Pengguna;

public class LoginModel {
    public Pengguna cekLogin (String Username, String Password){
        String query="SELECT *FROM pengguna WHERE username=? AND password=?";
        try (Connection con = Database.KoneksiDB();
            PreparedStatement st= con.prepareStatement(query);){
           
            st.setString(1, Username);
            st.setString(2, Password);
            
            ResultSet rs=st.executeQuery();
            if (rs.next()){
                Pengguna user=new Pengguna();
                
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNama(rs.getString("nama"));
                user.setJabatan(rs.getString("jabatan"));
                user.setJenkel(rs.getString("jenkel"));
                user.setAlamat(rs.getString("alamat"));
                user.setTelepon(rs.getString("telepon"));
                return user;
            }
        //TODO: Bikin Query
        
        //TODO: Buka Koneksinya
        
        //TODO: Bikin statementnya
        
        //TODO: Masukin Querynya kedalam statement
        
        //TODO: Kalau datanya ada, tampung ke model Pengguna
        //      Kalau ga ada,biarin aja, balikin nilai NULL
        

            
    //kalau engga, balikin nilai NULL,atau gagal login
    
  
    }   catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
          }
}