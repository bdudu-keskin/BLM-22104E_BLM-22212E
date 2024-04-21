/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fsm.bdudu_keskin_2221221003_bp2_p1;

/**
 * @description personelden extend alan çalışsanın tanımlandığı class
 * @assigment proje 1 (vize + final)
 * @author B Dudu Keskin 2221221003
 * @mail beyzadudu.keskin@stu.fsm.edu.tr
 */
public class Calisan extends Personel{
    
    public double maas;
    public String gorev;
    public String durum;
    
    @Override
    public void bilgileriYazdir(){
        
        System.out.println("Maasi: " + this.maas);
        System.out.println("Gorevi: " + this.gorev);
        System.out.println("Gorev durumu: " + this.durum);
    }
}
