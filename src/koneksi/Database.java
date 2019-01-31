package koneksi;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class Database {
    static String driver, database, user, pass;
    
    public static Connection KoneksiDB(){
        Connection conn=null;
        try{
            driver="con.mysql.jdbc.Driver";
            database="jdbc:mysql://localhost/db_workshop";
            user="root";
            pass="";
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection(database, user, pass);
            System.out.println("Koneksi Berhasil");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage(),
                            "Pesan Gagal Koneksi", JOptionPane.INFORMATION_MESSAGE);
        }
        return conn;
        }
}

