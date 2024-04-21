/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fsm.bdudu_keskin_2221221003_bp2_p1;

/**
 * @description calısan ile yöneticilerin ortak özelliklerinin tanımlandığı personel classı 
 * @assigment proje 1 (vize + final)
 * @author B Dudu Keskin 2221221003
 * @mail beyzadudu.keskin@stu.fsm.edu.tr
 */
public class Personel {
    
    public String eposta;
    public String isim;
    public String soyisim;
    public String sifre;
    public String cinsiyet;
    public String rutbe;
    
    
    public void bilgileriYazdir(){
        
        System.out.println("Adi: " + this.isim);
        System.out.println("Soyadi: " + this.soyisim);
        System.out.println("Cinsiyeti: " + this.cinsiyet);
        System.out.println("Mail adresi: " + this.eposta);
        System.out.println("Rutbesi: " + this.rutbe);
    }
    
}


