/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.fsm.bdudu_keskin_2221221003_bp2_p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @description yoneticilerin herkesin bilgisine erişebildiği ve gerekliyse yaptığı seçimi silebildiği ya da düzenleyebildiği frame
 * @assigment proje 1 (vize + final)
 * @author B Dudu Keskin 2221221003
 * @mail beyzadudu.keskin@stu.fsm.edu.tr
 */
public class yonetici_erisim extends javax.swing.JFrame {

    
    DefaultTableModel tbl_adminEdit;
    private JTable table;
    /**
     * Creates new form yönetici_ekranı
     */
    public yonetici_erisim() {
        
        initComponents();
        
        tbl_adminEdit = new DefaultTableModel(){
            
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        
        tbl_adminEdit.setColumnIdentifiers(new Object[]{"ISIM", "SOYISIM", "CINSIYET", "RUTBE", "EPOSTA", "MAAS"});
        tbl_edit.setModel(tbl_adminEdit);
        tabloyaBilgiYazdir();
    }
    
    
    private void tabloyaBilgiYazdir() {
        
        ArrayList<Calisan> calisanlar = SirketDB.PersonelYazdir();
        tbl_adminEdit.setRowCount(0);
        for (Calisan calisan : calisanlar) {
            tbl_adminEdit.addRow(new Object[]{calisan.isim, calisan.soyisim, calisan.cinsiyet,calisan.rutbe, calisan.eposta, calisan.maas});

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

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        paneledit = new javax.swing.JPanel();
        lbl_mail = new javax.swing.JLabel();
        lbl_name = new javax.swing.JLabel();
        lbl_soyisim = new javax.swing.JLabel();
        lbl_gender = new javax.swing.JLabel();
        lbl_maas = new javax.swing.JLabel();
        txt_surname = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_salary = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        cmbx_gender = new javax.swing.JComboBox<>();
        btn_save = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_search = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_edit = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        getContentPane().add(jPanel1);

        jSplitPane1.setBackground(new java.awt.Color(255, 255, 255));
        jSplitPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BİLGİ DÜZENLEME EKRANI", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 24), new java.awt.Color(0, 0, 51))); // NOI18N
        jSplitPane1.setDividerSize(10);
        jSplitPane1.setMinimumSize(new java.awt.Dimension(600, 600));
        jSplitPane1.setPreferredSize(new java.awt.Dimension(600, 600));

        paneledit.setBackground(new java.awt.Color(0, 0, 102));
        paneledit.setMaximumSize(new java.awt.Dimension(500, 500));
        paneledit.setMinimumSize(new java.awt.Dimension(500, 500));
        paneledit.setPreferredSize(new java.awt.Dimension(500, 500));
        paneledit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_mail.setBackground(new java.awt.Color(0, 0, 0));
        lbl_mail.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_mail.setForeground(new java.awt.Color(255, 255, 255));
        lbl_mail.setText("E-Posta");
        paneledit.add(lbl_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        lbl_name.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_name.setForeground(new java.awt.Color(255, 255, 255));
        lbl_name.setText("İsim");
        paneledit.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        lbl_soyisim.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_soyisim.setForeground(new java.awt.Color(255, 255, 255));
        lbl_soyisim.setText("Soyisim");
        paneledit.add(lbl_soyisim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        lbl_gender.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_gender.setForeground(new java.awt.Color(255, 255, 255));
        lbl_gender.setText("Cinsiyet");
        lbl_gender.setToolTipText("");
        paneledit.add(lbl_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        lbl_maas.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        lbl_maas.setForeground(new java.awt.Color(255, 255, 255));
        lbl_maas.setText("Maaş");
        lbl_maas.setToolTipText("");
        paneledit.add(lbl_maas, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        txt_surname.setBackground(new java.awt.Color(255, 255, 255));
        paneledit.add(txt_surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 160, 40));

        txt_mail.setBackground(new java.awt.Color(255, 255, 255));
        txt_mail.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        txt_mail.setForeground(new java.awt.Color(0, 0, 0));
        txt_mail.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        txt_mail.setEnabled(false);
        txt_mail.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        txt_mail.setSelectionColor(new java.awt.Color(0, 0, 0));
        paneledit.add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 160, 40));

        txt_salary.setBackground(new java.awt.Color(255, 255, 255));
        paneledit.add(txt_salary, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 160, 40));

        txt_name.setBackground(new java.awt.Color(255, 255, 255));
        paneledit.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 160, 40));

        cmbx_gender.setBackground(new java.awt.Color(0, 43, 110));
        cmbx_gender.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        cmbx_gender.setForeground(new java.awt.Color(255, 255, 255));
        cmbx_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "kadın", "erkek", "diğer" }));
        paneledit.add(cmbx_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 160, 40));

        btn_save.setBackground(new java.awt.Color(204, 204, 255));
        btn_save.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        btn_save.setForeground(new java.awt.Color(0, 0, 0));
        btn_save.setText("Değişiklikleri Kaydet");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        paneledit.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, -1, 40));

        btn_delete.setBackground(new java.awt.Color(204, 204, 255));
        btn_delete.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(0, 0, 0));
        btn_delete.setText("Kişiyi Sil");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        paneledit.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 330, 110, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("E-posta giriniz:");
        paneledit.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 200, 40));

        txt_search.setBackground(new java.awt.Color(0, 43, 110));
        txt_search.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        txt_search.setForeground(new java.awt.Color(255, 255, 255));
        paneledit.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 170, 40));

        btn_search.setBackground(new java.awt.Color(204, 204, 255));
        btn_search.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btn_search.setForeground(new java.awt.Color(0, 0, 0));
        btn_search.setText("Ara");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        paneledit.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 110, 40));

        btn_refresh.setBackground(new java.awt.Color(204, 204, 255));
        btn_refresh.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        btn_refresh.setForeground(new java.awt.Color(0, 0, 0));
        btn_refresh.setText("Yenile");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });
        paneledit.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 110, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sadece işçi ve asistanları getir/ görev ver");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        paneledit.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 500, 360, -1));

        jSplitPane1.setRightComponent(paneledit);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setMaximumSize(new java.awt.Dimension(500, 500));
        jPanel3.setMinimumSize(new java.awt.Dimension(500, 500));
        jPanel3.setName(""); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 500));

        tbl_edit.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_editMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_edit);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jSplitPane1.setLeftComponent(jPanel3);

        getContentPane().add(jSplitPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed

        String arama = txt_search.getText();

        if (arama.isBlank()) {

            JOptionPane.showMessageDialog(this, "lütfen geçerli bir arama değeri giriniz");
            tabloyaBilgiYazdir();
            
        } else {

            tbl_adminEdit.setRowCount(0);
            ArrayList<Calisan> aratmaListe = SirketDB.Aratma(arama);

            for (Calisan np1 : aratmaListe) {

                tbl_adminEdit.addRow(new Object[]{np1.isim, np1.soyisim, np1.cinsiyet, np1.rutbe, np1.eposta, np1.maas});
            }

        }
    }//GEN-LAST:event_btn_searchActionPerformed

    
    
    
    
    
    
    
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // TODO add your handling code here:
        
        if (tbl_edit.getSelectedRow() == -1) {
            
            JOptionPane.showMessageDialog(rootPane, "silmek için tablodan seçim yapınız");
            return;
        }
        
        String eposta = txt_mail.getText();
        
        if (giris_ekrani.email.equals(eposta)){
            
            JOptionPane.showMessageDialog(rootPane, "kendinizi silemezsiniz!");
            
            tabloyaBilgiYazdir();
            btn_refreshActionPerformed(evt);
            
        } else if (SirketDB.kisiSil(eposta)) {
            
            JOptionPane.showMessageDialog(rootPane, "silme işlemi başarılı");
            
            tabloyaBilgiYazdir();
            btn_refreshActionPerformed(evt);

        } else {
            JOptionPane.showMessageDialog(rootPane, "silme işlemi başarısız");

        }  
    }//GEN-LAST:event_btn_deleteActionPerformed

    
    
    
    
    /*try {
            np1.maas = Double.parseDouble(salary);
            
        } catch (NumberFormatException e) {
            System.out.println("lütfen --- . -- formatına uygun bir maaş giriniz");
        }

        //np1.maas = Double.parseDouble(txt_salary.getText());
        //np1.rutbe = (String) cmbx_work.getSelectedItem().toString();
        if (SirketDB.calisanDüzenle(np1)) {
            JOptionPane.showMessageDialog(rootPane, "düzenleme başarılı");

        } else {
            JOptionPane.showMessageDialog(rootPane, "düzenleme başarısız");
        }*/
    
    
    
    
    
    
    
    
    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        
        Calisan np1 = new Calisan();

        np1.isim = txt_name.getText();
        np1.soyisim = txt_surname.getText();
        np1.cinsiyet = (String) cmbx_gender.getSelectedItem();
        np1.eposta = txt_mail.getText();
        
        String salary = txt_salary.getText();
        

        if(txt_mail.getText().isBlank())
            JOptionPane.showMessageDialog(rootPane, "düzenleme yapmak için tablodan seçim yapınız");
        
        else{

            if (salary.matches("^((\\d*[1-9]+\\d*(\\.\\d+)?)|(\\d*\\.\\d*[1-9]+\\d*))$")) {
                np1.maas = Double.parseDouble(salary);

                if (SirketDB.personelDüzenle(np1)) {
                    JOptionPane.showMessageDialog(rootPane, "düzenleme başarılı");

                    tabloyaBilgiYazdir();
                    btn_refreshActionPerformed(evt);

                } else {
                    JOptionPane.showMessageDialog(rootPane, "düzenleme başarısız");
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "Maası doğru girdiğinizden emin olunuz");
            }
        }
    }//GEN-LAST:event_btn_saveActionPerformed


    
    
    
    
    
    
    
    
    
    private void tbl_editMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_editMouseClicked
        // TODO add your handling code here:
        
        int r = tbl_edit.getSelectedRow();
        
        if(r == -1)
            return;
        
        String name = (String) tbl_edit.getValueAt(r, 0);
        txt_name.setText(name);
        
        String surname = (String) tbl_edit.getValueAt(r, 1);
        txt_surname.setText(surname);
        
        String gender = (String) tbl_edit.getValueAt(r, 2);
        cmbx_gender.setSelectedItem(gender);
        
        String email = (String) tbl_edit.getValueAt(r, 4);
        txt_mail.setText(email);
        
        double maas = (double) tbl_edit.getValueAt(r, 5);
        txt_salary.setText(Double.toString(maas));
        
        
        //String maas = (String) tbl_edit.getValueAt(r, 5);
        //txt_salary.setText(maas);
    }//GEN-LAST:event_tbl_editMouseClicked

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        
        txt_mail.setText("");
        txt_name.setText("");
        txt_salary.setText("");
        txt_search.setText("");
        txt_surname.setText("");
        cmbx_gender.setSelectedIndex(0);
        
        tabloyaBilgiYazdir();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        
        yonetici_gorev_ver pnl_gorev = new yonetici_gorev_ver();
        pnl_gorev.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    
    
    
    
    
    
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
            java.util.logging.Logger.getLogger(yonetici_erisim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(yonetici_erisim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(yonetici_erisim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(yonetici_erisim.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new yonetici_erisim().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_save;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox<String> cmbx_gender;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbl_gender;
    private javax.swing.JLabel lbl_maas;
    private javax.swing.JLabel lbl_mail;
    private javax.swing.JLabel lbl_name;
    private javax.swing.JLabel lbl_soyisim;
    private javax.swing.JPanel paneledit;
    private javax.swing.JTable tbl_edit;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_salary;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_surname;
    // End of variables declaration//GEN-END:variables
}
