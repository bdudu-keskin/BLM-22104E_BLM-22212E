/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fsm.bdudu_keskin_2221221003_bp2_p1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton; 

/**
 *
 * @description çalışanın kendi temel bilgilerini ve görev durumu takip edebileceği frame
                çalışsan mevcut görevi ve görev durumuna göre mola veya yeni görev talebinde bulunabilir
 * @assigment proje 1 (vize + final)
 * @author B Dudu Keskin 2221221003
 * @mail beyzadudu.keskin@stu.fsm.edu.tr
 */
public class calisan_bilgi_goruntuleme extends javax.swing.JFrame {

    
    
    /**
     * giriş yapan çalışanın mailine göre kullanıcıyı verş tabanında aratarak bilgilerini labellara yazdırıyorum
     * görev veya mola talebi: eğer çalışan yeni eklenmişse görevi yoktur, sadece görev talebinde bulunabilir.
     * eğer çalışanın mevcut bir görevi varsa görevi tamamlandı işaretlemeden mola veya yeni görev talebinde bulunamaz
     * eğer çalışan moladaysa sadece görev talebinde bulunabilir
     * eğer çalışan görev talebinde bulunmuşsa yönetici çalışana görev verene kadar yeni talepte bulunamaz
     * 
     */
    public calisan_bilgi_goruntuleme() {
        initComponents();
        
        lbl_email.setText(giris_ekrani.email);
        lbl_eposta.setText(giris_ekrani.email );
        
        String arama = giris_ekrani.email;

        ArrayList<Calisan> aratmaListe = SirketDB.Aratma(arama);

        for (Calisan np1 : aratmaListe) {

            lbl_cinsiyet.setText(np1.cinsiyet);
            lbl_isim.setText(np1.isim);
            lbl_soyisim.setText(np1.soyisim);
            lbl_maas.setText(np1.maas + "");
        }

        aratmaListe = SirketDB.GorevGoster(arama);

        for (Calisan np1 : aratmaListe) {

            lbl_gorev.setText(np1.gorev);

        }
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btngrp_talep = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        lbl_name = new javax.swing.JLabel();
        lbl_surname = new javax.swing.JLabel();
        lbl_mail = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        lbl_salary = new javax.swing.JLabel();
        lbl_cinsiyet = new javax.swing.JLabel();
        lbl_isim = new javax.swing.JLabel();
        lbl_soyisim = new javax.swing.JLabel();
        lbl_email = new javax.swing.JLabel();
        lbl_maas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_info = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbl_gorev = new javax.swing.JLabel();
        check_gorev = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        rbtn_mola = new javax.swing.JRadioButton();
        rbtn_gorev = new javax.swing.JRadioButton();
        lbl_eposta = new javax.swing.JLabel();
        btn_ilet = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_cıkıs = new javax.swing.JMenu();

        jTabbedPane2.setBackground(new java.awt.Color(204, 204, 255));
        jTabbedPane2.setForeground(new java.awt.Color(204, 204, 255));

        jLabel3.setText("jLabel3");

        jLabel5.setText("jLabel5");

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setForeground(new java.awt.Color(0, 0, 102));
        jPanel2.setMaximumSize(new java.awt.Dimension(700, 400));
        jPanel2.setMinimumSize(new java.awt.Dimension(700, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_name.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name.setText("İsim");
        jPanel2.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbl_surname.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_surname.setForeground(new java.awt.Color(255, 255, 255));
        lbl_surname.setText("Soyisim");
        jPanel2.add(lbl_surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        lbl_mail.setBackground(new java.awt.Color(0, 0, 0));
        lbl_mail.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_mail.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mail.setText("E-Posta");
        jPanel2.add(lbl_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        lbl_gender.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_gender.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gender.setText("Cinsiyet");
        lbl_gender.setToolTipText("");
        jPanel2.add(lbl_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 100, 40));

        lbl_salary.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_salary.setForeground(new java.awt.Color(255, 255, 255));
        lbl_salary.setText("Maaş");
        lbl_salary.setToolTipText("");
        jPanel2.add(lbl_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 80, -1));

        lbl_cinsiyet.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cinsiyet.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_cinsiyet.setForeground(new java.awt.Color(255, 255, 255));
        lbl_cinsiyet.setText("cinsiyet");
        jPanel2.add(lbl_cinsiyet, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 160, 40));

        lbl_isim.setBackground(new java.awt.Color(255, 255, 255));
        lbl_isim.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_isim.setForeground(new java.awt.Color(255, 255, 255));
        lbl_isim.setText("isim");
        jPanel2.add(lbl_isim, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 160, 40));

        lbl_soyisim.setBackground(new java.awt.Color(255, 255, 255));
        lbl_soyisim.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_soyisim.setForeground(new java.awt.Color(255, 255, 255));
        lbl_soyisim.setText("soyisim");
        jPanel2.add(lbl_soyisim, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 160, 40));

        lbl_email.setBackground(new java.awt.Color(255, 255, 255));
        lbl_email.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_email.setForeground(new java.awt.Color(255, 255, 255));
        lbl_email.setText("e mail");
        jPanel2.add(lbl_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 190, 40));

        lbl_maas.setBackground(new java.awt.Color(255, 255, 255));
        lbl_maas.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_maas.setForeground(new java.awt.Color(255, 255, 255));
        lbl_maas.setText("maas");
        jPanel2.add(lbl_maas, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 60, 170, 50));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("bilgi değişikliğinde bulun");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, 230, 50));

        btn_info.setBackground(new java.awt.Color(204, 204, 255));
        btn_info.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_info.setForeground(new java.awt.Color(0, 0, 0));
        btn_info.setText("değişiklik yap");
        btn_info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_infoActionPerformed(evt);
            }
        });
        jPanel2.add(btn_info, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 140, 40));

        jTabbedPane1.addTab("bilgi ekranı", jPanel2);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(700, 400));
        jPanel1.setMinimumSize(new java.awt.Dimension(700, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(700, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_gorev.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_gorev.setForeground(new java.awt.Color(0, 0, 102));
        lbl_gorev.setText("görev");
        jPanel1.add(lbl_gorev, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 210, 50));

        check_gorev.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        check_gorev.setForeground(new java.awt.Color(0, 0, 102));
        check_gorev.setText("Tamamlandı");
        jPanel1.add(check_gorev, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("Mevcut göreviniz:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, 210, 50));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setText("Görev durumunuz:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 210, 50));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setText("Mola ya da görev talebinde bulununuz");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 340, 50));

        btngrp_talep.add(rbtn_mola);
        rbtn_mola.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        rbtn_mola.setForeground(new java.awt.Color(0, 0, 102));
        rbtn_mola.setText("Mola");
        rbtn_mola.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_molaActionPerformed(evt);
            }
        });
        jPanel1.add(rbtn_mola, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, -1, -1));

        btngrp_talep.add(rbtn_gorev);
        rbtn_gorev.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        rbtn_gorev.setForeground(new java.awt.Color(0, 0, 102));
        rbtn_gorev.setText("Görev");
        jPanel1.add(rbtn_gorev, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 250, -1, -1));

        lbl_eposta.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lbl_eposta.setForeground(new java.awt.Color(0, 0, 102));
        lbl_eposta.setText("email:");
        jPanel1.add(lbl_eposta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 190, 50));

        btn_ilet.setBackground(new java.awt.Color(0, 0, 102));
        btn_ilet.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btn_ilet.setForeground(new java.awt.Color(255, 255, 255));
        btn_ilet.setText("İlet");
        btn_ilet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iletActionPerformed(evt);
            }
        });
        jPanel1.add(btn_ilet, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 140, 40));

        jTabbedPane1.addTab("görev ekranı", jPanel1);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 400));
        jTabbedPane1.getAccessibleContext().setAccessibleName("bilgi ekranı");

        menu_cıkıs.setText("çıkış yap");
        menu_cıkıs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_cıkısMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_cıkıs);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_infoActionPerformed
        // TODO add your handling code here:
        
        calisan_bilgi_degisim frm = new calisan_bilgi_degisim();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_infoActionPerformed

    private void rbtn_molaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_molaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtn_molaActionPerformed

    private void btn_iletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iletActionPerformed
        // TODO add your handling code here:
        
        
        Calisan np1 = new Calisan();
        
        np1.eposta = giris_ekrani.email;
        
        
        
        if (lbl_gorev.getText().equals("yok")){
 
            if(check_gorev.isSelected())
                JOptionPane.showMessageDialog(rootPane, "hata, göreviniz yok. tamamlandı olarak işaretleyemezsiniz");
            
            else if(rbtn_mola.isSelected())
                JOptionPane.showMessageDialog(rootPane, "hata, göreviniz yok. mola isteyemezsiniz");
            
            else if(rbtn_gorev.isSelected()){
                
                JOptionPane.showMessageDialog(rootPane, " gorev talebi başarıyla gonderildi");
                lbl_gorev.setText("bulunmamakta");
                np1.gorev = "bulunmamakta";
                np1.durum = "talep gönderildi";
                SirketDB.gorevDuzenle(np1);
            }
            
            
        } else if (lbl_gorev.getText().equals("bulunmamakta"))
            JOptionPane.showMessageDialog(rootPane, "gorev talebine cevap gelmedi, işlem gerçekleştiremezsiniz");
        
        
        else if (lbl_gorev.getText().equals("moladasiniz")) {

            if (rbtn_mola.isSelected())
                JOptionPane.showMessageDialog(rootPane, "moladasiniz, mola talebi gönderemezsiniz");
            
            else if(check_gorev.isSelected())
                JOptionPane.showMessageDialog(rootPane, "moladasiniz, sadece görev alabilirsiniz");
            
            else{
                
                JOptionPane.showMessageDialog(rootPane, "gorev talebi başarıyla gönderildi");
                lbl_gorev.setText("bulunmamakta");
                np1.gorev = "bulunmamakta";
                np1.durum = "talep gönderildi";
                SirketDB.gorevDuzenle(np1);
            }
           
            
        } else if (lbl_gorev.getText().equals("tasarım") || lbl_gorev.getText().equals("yorumlama") || lbl_gorev.getText().equals("revize")){
            
            if(check_gorev.isSelected()){
       
                if (!rbtn_gorev.isSelected() && !rbtn_mola.isSelected())
                    JOptionPane.showMessageDialog(rootPane, "mola veya gorev talebinde bulununuz");

                else if (rbtn_gorev.isSelected()) {

                    JOptionPane.showMessageDialog(rootPane, "gorev talebi başarıyla gönderildi");
                    lbl_gorev.setText("bulunmamakta");
                    np1.gorev = "bulunmamakta";
                    np1.durum = "talep gönderildi";
                    SirketDB.gorevDuzenle(np1);
                    
                } else {
                    
                    JOptionPane.showMessageDialog(rootPane, "mola talebi başarıyla gönderildi");
                    lbl_gorev.setText("moladasiniz");
                    np1.gorev = "moladasiniz";
                    np1.durum = "moladasiniz";
                    SirketDB.gorevDuzenle(np1);
                }
                
                
            } else if(rbtn_gorev.isSelected() || rbtn_mola.isSelected()){
                JOptionPane.showMessageDialog(rootPane, "once gorevinizi bitirmelisiniz");
                
            } else
                JOptionPane.showMessageDialog(rootPane, "hatali işlem");
        }        
    }//GEN-LAST:event_btn_iletActionPerformed

    
    
    
    
    
    
    
    
    
    private void menu_cıkısMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_cıkısMouseClicked
        // TODO add your handling code here:
        
        giris_ekrani giris = new giris_ekrani();
        giris.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_menu_cıkısMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(calisan_bilgi_goruntuleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(calisan_bilgi_goruntuleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(calisan_bilgi_goruntuleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(calisan_bilgi_goruntuleme.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new calisan_bilgi_goruntuleme().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ilet;
    private javax.swing.JButton btn_info;
    private javax.swing.ButtonGroup btngrp_talep;
    private javax.swing.JCheckBox check_gorev;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lbl_cinsiyet;
    private javax.swing.JLabel lbl_email;
    private javax.swing.JLabel lbl_eposta;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_gorev;
    private javax.swing.JLabel lbl_isim;
    private javax.swing.JLabel lbl_maas;
    private javax.swing.JLabel lbl_mail;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_salary;
    private javax.swing.JLabel lbl_soyisim;
    private javax.swing.JLabel lbl_surname;
    private javax.swing.JMenu menu_cıkıs;
    private javax.swing.JRadioButton rbtn_gorev;
    private javax.swing.JRadioButton rbtn_mola;
    // End of variables declaration//GEN-END:variables
}