/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.fsm.beyzadudu_keskin_2221221003_bp2_project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**

 * @author Asus
 * 
 * Burası programın main hesabıdır.
 */
public class BeyzaDudu_Keskin_2221221003_bp2_project {

    public static JFrame LoginFrame; //programı başlatır başlatmaz giriş yap ekranı çıkıyor

    public static void main(String[] args) {
        
        try {
            BDuduKeskinData.dosyayi_oku();
        } catch (IOException ex) {
            Logger.getLogger(BeyzaDudu_Keskin_2221221003_bp2_project.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        BDuduKeskinGiris new_frm = new BDuduKeskinGiris();
        LoginFrame = new_frm;
        new_frm.setVisible(true);

    }
}
