/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fsm.bdudu_keskin_2221221003_bp2_p1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RootPaneContainer;
import javax.swing.table.DefaultTableModel;

/*import java.sql.PreparedStatement;
impo
rt java.sql.ResultSet;
import javax.swing.JOptionPane;


 *
 * @description proejede kullanılan fonksiyonların toplandığı class
 * @assigment proje 1 (vize + final)
 * @author B Dudu Keskin 2221221003
 * @mail beyzadudu.keskin@stu.fsm.edu.tr
 */
public class SirketDB {

    private static final String urlDB = "jdbc:mysql://127.0.0.1:3306/sirket_db?user=root&password=fsmblm";

    private static Connection conn;

    
    

    public static boolean personel_ekle(Personel np1) {

        try {
            conn = DriverManager.getConnection(urlDB);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO sirket_db.calisan_personel_bilgi "
                    + "(isim, soyisim, sifre, cinsiyet, rutbe, eposta)"
                    + "VALUES('" + np1.isim + "','" + np1.soyisim + "','" + np1.sifre + "','" + np1.cinsiyet + "','" + np1.rutbe + "','" + np1.eposta + "');";

            stmt.executeUpdate(query);
            
            //bağlantı kurdum ve queryi sqle göndererek personel ekleme işlemini yaptım 
            
            conn.close();
            return true;
            
            //işlem başarılıysa true döndürdüm
            
        } catch (SQLException ex) {
            
            //eğer bağlantı ya da ekleme işleminde sorun yaşadıysam hata verdim
            
            Logger.getLogger(SirketDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }
    
    
    
    
    
    
    
    
    public static boolean calisan_ekle(Personel np1) {

        
        
        try {
            conn = DriverManager.getConnection(urlDB);
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO sirket_db.calisan_personel_bilgi "
                    + "(isim, soyisim, sifre, cinsiyet, rutbe, eposta)"
                    + "VALUES('" + np1.isim + "','" + np1.soyisim + "','" + np1.sifre + "','" + np1.cinsiyet + "','" + np1.rutbe + "','" + np1.eposta + "');";

            stmt.executeUpdate(query);
            
            
            conn = DriverManager.getConnection(urlDB);
            Statement stmt2 = conn.createStatement();
            String query2 = "INSERT INTO sirket_db.calisan_gorev "
                    + "(isim, soyisim, eposta)"
                    + "VALUES('" + np1.isim + "','" + np1.soyisim + "','" + np1.eposta + "');";

            stmt2.executeUpdate(query2);
            
            //burada calışan hem görev alacağından hem de personel sayıldığından 2 ayrı query ile 2 farklı db tablosuna bağlantı sağlayarak ekleme işlemini gerçekleştirdim
            
            conn.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SirketDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        }
    }

    
    
    
    
    
    
    
    
    
    
    public static Personel giris(String mail, String sifre) {

        Personel newP = null;
        try {
            conn = DriverManager.getConnection(urlDB);
            Statement stmt = conn.createStatement();
            String query = "SELECT * From sirket_db.calisan_personel_bilgi WHERE eposta='" + mail + "' AND sifre='" + sifre + "'";
            
            ResultSet rs = stmt.executeQuery(query);
            
            if (rs.next()) {
                newP = new Personel();
                newP.isim = rs.getString("isim");
                newP.soyisim= rs.getString("soyisim");
                newP.sifre = rs.getString("sifre");
                newP.cinsiyet = rs.getString("cinsiyet");
                newP.rutbe = rs.getString("rutbe");
                newP.eposta = rs.getString("eposta");
            }
            
            //burada giriş yaparken email ve şifre ile veri tabanını sorguluyorum
            //eşlenen sonuç bulursam başta boş olarak oluşturduğum personeli eşlenen bilgilere göre dolduruyorum
            
            conn.close();
        } catch (SQLException ex) {

            System.out.println(" error:" + ex.getMessage());
        } return newP;
    }
    
    
    
    
    
    
    
    
    
    
    
    public static boolean emailKullanim(String email) {
        String query = "SELECT COUNT(*) FROM sirket_db.calisan_personel_bilgi WHERE eposta = ?";

        try (Connection conn = DriverManager.getConnection(urlDB);PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, email);

            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                int count = rs.getInt(1);
                return count > 0;
            }
            
            //kullanıcı kaydolurken giriş yaptığı emailin kullanımda olup olmadığını sorguluyorum
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } return false;
    }
    
    
    
    
    
    
    
    
    
    
    
    public static boolean kisiSil(String email) {
        
        try {
            conn = DriverManager.getConnection(urlDB);

            String query = "DELETE FROM sirket_db.calisan_personel_bilgi WHERE eposta = ?";
            PreparedStatement q1Stmt = conn.prepareStatement(query);
            q1Stmt.setString(1, email);
            q1Stmt.executeUpdate();

            
            String query2 = "DELETE FROM sirket_db.calisan_gorev WHERE eposta = ?";
            PreparedStatement q2Stmt = conn.prepareStatement(query2);
            q2Stmt.setString(1, email);
            q2Stmt.executeUpdate();

            conn.close();
            return true;
            
            //burada kişi silme işlemini tek fonksiyona aldım
            //Yönetici tipindekiler 2. query ile güncellediğim tabloda olmasalar da calışan tipindekiler her ikisinde birden bulunmakta
            //yönetici silmek 2. tablodan boş bilgi döndüğü için hataya sebep VERMEMEKTEDİR
            //böylece fazladan fonksiyona da gerek kalmadı
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    
    
    public static boolean personelDüzenle(Calisan np1) {

        try {
            Connection conn = DriverManager.getConnection(urlDB);
            
            Statement stmt = conn.createStatement();
            String query = "UPDATE sirket_db.calisan_personel_bilgi SET "
                    + "isim='" + np1.isim
                    + "',soyisim='" + np1.soyisim
                    + "',cinsiyet='" + np1.cinsiyet
                    + "',maas='" + np1.maas
                    + "'WHERE eposta='" + np1.eposta + "';";

            stmt.executeUpdate(query);

            Statement stmt2 = conn.createStatement();
            String query2 = "UPDATE sirket_db.calisan_gorev SET "
                    + "isim='" + np1.isim
                    + "',soyisim='" + np1.soyisim
                    + "',gorev='" + np1.gorev
                    + "' WHERE eposta='" + np1.eposta + "';";

            stmt2.executeUpdate(query2);
            
            //burada yönetici tipindekiler öalışanları ve yöneticileri düzenlemektedir. 
            //2 query ve 2 statement ile 2 farklı tablodan tek fonksiyonda düzenleme işlemi gerçekleştirilmektedir
        
            conn.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SirketDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    
    
    
    
    
    
    
    public static boolean gorevDuzenle(Calisan np1) {

        try {
            Connection conn = DriverManager.getConnection(urlDB);
            
            Statement stmt = conn.createStatement();
            String query = "UPDATE sirket_db.calisan_gorev SET "
                    + "gorev='" + np1.gorev
                    + "',durum='" + np1.durum
                    + "'WHERE eposta='" + np1.eposta + "';";

            stmt.executeUpdate(query);
            conn.close();
            return true;
            
            //burada yöneticiler e posta ile çalışan aratarak çalışanlara görev atamaktadır

        } catch (SQLException ex) {
            Logger.getLogger(SirketDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static boolean calisanDüzenle(Calisan np1) {

        try {
            Connection conn = DriverManager.getConnection(urlDB);
            
            Statement stmt = conn.createStatement();
            String query = "UPDATE sirket_db.calisan_personel_bilgi SET "
                    + "isim='" + np1.isim
                    + "',soyisim='" + np1.soyisim
                    + "',cinsiyet='" + np1.cinsiyet
                    + "'WHERE eposta='" + np1.eposta + "';";

            stmt.executeUpdate(query);
            
            
            Statement stmt2 = conn.createStatement();
            String query2 = "UPDATE sirket_db.calisan_gorev SET "
                    + "isim='" + np1.isim
                    + "',soyisim='" + np1.soyisim
                    + "'WHERE eposta='" + np1.eposta + "';";
            
            //calışanların kendi bilgilerini düzenlemesini sağlayan kod
            //personelDüzenle ile aralarındaki fark çalışanlar, kendilerini düzenlerken isim soyisim ve cinsiyet harici bilgilere erişim sağlayamamaktadır,

            stmt2.executeUpdate(query2);
            conn.close();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(SirketDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    
    
    
    
    
    public static ArrayList<Calisan> PersonelYazdir() {

        ArrayList<Calisan> calisanlar = null;

        try {
            conn = DriverManager.getConnection(urlDB);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM sirket_db.calisan_personel_bilgi;";
            ResultSet rs = stmt.executeQuery(query);
            calisanlar = new ArrayList<>();

            while (rs.next()) {
                Calisan calisan = new Calisan();
                calisan.isim = rs.getString("isim");
                calisan.soyisim = rs.getString("soyisim");
                calisan.cinsiyet = rs.getString("cinsiyet");
                calisan.rutbe = rs.getString("rutbe");
                calisan.eposta = rs.getString("eposta");
                calisan.maas = rs.getDouble("maas");

                calisanlar.add(calisan);
                
                //yöneticiler için veritabanında kayıtlı herkesi (rütbe fark etmeksizin) yazdıran fonksiyon
                
            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } return calisanlar;

    }
    
    
    
    
    
    
    public static ArrayList<Calisan> calisanGorevYazdir() {

        ArrayList<Calisan> calisanlar = null;

        try {
            conn = DriverManager.getConnection(urlDB);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM sirket_db.calisan_gorev;";
            ResultSet rs = stmt.executeQuery(query);
            calisanlar = new ArrayList<>();

            while (rs.next()) {
                Calisan calisan = new Calisan();
                calisan.isim = rs.getString("isim");
                calisan.soyisim = rs.getString("soyisim");
                calisan.gorev = rs.getString("gorev");
                calisan.durum = rs.getString("durum");
                calisan.eposta = rs.getString("eposta");

                calisanlar.add(calisan);
                
                //yöneticilerin calışanların görevleriyle ilgili tüm durumu görüntülemesini sağlayan fonskiyon
                
            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } return calisanlar;

    }
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    public static ArrayList<Calisan> Aratma(String arama){
        
        
        ArrayList<Calisan> aramaListe = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(urlDB);
            Statement stmt = conn.createStatement();
            
            String query = "SELECT * FROM sirket_db.calisan_personel_bilgi WHERE eposta LIKE '%" + arama + "%'";
            
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                
                Calisan np1 = new Calisan();
                
                np1.isim = rs.getString("isim");
                np1.soyisim = rs.getString("soyisim");
                np1.cinsiyet = rs.getString("cinsiyet");
                np1.rutbe = rs.getString("rutbe");
                np1.eposta = rs.getString("eposta");
                
                aramaListe.add(np1);
                
                //epostaya bağlı aratma fonksiyonu
                
            } conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(SirketDB.class.getName()).log(Level.SEVERE, null, ex);
            
        } return aramaListe;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public static ArrayList<Calisan> GorevGoster (String bilgiGetir){
        
        
        ArrayList<Calisan> aramaListe = new ArrayList<>();

        try {
            conn = DriverManager.getConnection(urlDB);
            Statement stmt = conn.createStatement();
            
            String query = "SELECT * FROM sirket_db.calisan_gorev WHERE eposta LIKE '%" + bilgiGetir + "%'";
            
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                
                Calisan np1 = new Calisan();
                
                np1.gorev = rs.getString("gorev");
                np1.isim = rs.getString("isim");
                np1.soyisim = rs.getString("soyisim");
                np1.durum = rs.getString("durum");
                np1.eposta = rs.getString("eposta");
                
                aramaListe.add(np1);
                
                //calışanların kendi görev bilgilerini görmelerini sağlayan fonksiyon
                
            } conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(SirketDB.class.getName()).log(Level.SEVERE, null, ex);
            
        } return aramaListe;
    }
    
    
    
    
    
    
    
    
    
    public static ArrayList<Calisan> calisanBilgiYazdir() {

        ArrayList<Calisan> calisanlar = null;

        try {
            conn = DriverManager.getConnection(urlDB);
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM sirket_db.calisan_personel_bilgi;";
            ResultSet rs = stmt.executeQuery(query);
            calisanlar = new ArrayList<>();

            while (rs.next()) {
                Calisan calisan = new Calisan();
                calisan.isim = rs.getString("isim");
                calisan.soyisim = rs.getString("soyisim");
                calisan.cinsiyet = rs.getString("cinsiyet");
                calisan.eposta = rs.getString("eposta");

                calisanlar.add(calisan);
                
                //çalışanların kendi temel bilgilerini görüntülemesini sağlayan fonksiyon
                
            }
            conn.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        } return calisanlar;

    }   
    
    
    
    
    
    
    
    public static void dosyayaYazdir(JTable table, String filePath) {
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int[] selectedRows = table.getSelectedRows();
        
        //tabledan satır(ları) seçerek bir arrayde tutuyorum

        try {
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            
            for (int row : selectedRows) {
                
                for (int col = 0; col < model.getColumnCount(); col++) {
                    Object value = model.getValueAt(row, col);
                    writer.write(value.toString() + "\t"); 
                    
                    //seçilen tüm satır ve sütunlar için bilgileri tek tek yazdırıyorum

                } writer.newLine(); 

            } System.out.println("Bilgiler dosyaya yazildi.");
            writer.close();
            System.out.println("Programin calistigi dizin: " + System.getProperty("user.dir"));
            JOptionPane.showMessageDialog(table, "bilgiler yazdirildi");
            
            //işlem başarılıysa yazma işlemini kapıyorum ve başarılı olduğuna dair mesaj veriyorum
            
        } catch (IOException e) {
            e.printStackTrace();
            
            //eğer yazdırma işleminde sorun varsa hatayı yakalıyorum ve hatanın kaynağını bastırıyorum
            
        }
    }    
}
