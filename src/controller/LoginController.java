/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import javax.swing.JOptionPane;
import model.dao.LoginModel;
import model.pojo.Pengguna;
import view.LoginView;
import view.MenuUtamaView;
/**
 *
 * @author Field Engineer
 */
public class LoginController {
    private LoginView view;
    private LoginModel model;

    public LoginController(LoginView view) {
        this.view = view;
        this.model=new LoginModel();
        
    }
    
    public void cekLoginKeDatabase(){
        String username = view.getTxtUsername().getText();
        String password = view.getTxtPassword().getText();
        
        Pengguna user=model.cekLogin(username, password);
        if(user != null){
            view.dispose();
            new MenuUtamaView(user).setVisible(true);
        }else{
        JOptionPane.showMessageDialog(view, "Gagal Login");
        }
    //tampung username dan password
    //periksa username dan password
    
    //kalau benar, masuk ke menu utama
    //kalau salah, muncul pesan gagal
    }
}
