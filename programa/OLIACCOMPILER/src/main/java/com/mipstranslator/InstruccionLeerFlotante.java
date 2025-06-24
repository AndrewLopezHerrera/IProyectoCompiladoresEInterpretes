/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionLeerFlotante {
    private String Temporal;
    
    public InstruccionLeerFlotante(String temporal){
        Temporal = temporal;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "li $v0, 6\n";
        mensaje += "syscall\n";
        mensaje += "move $" + Temporal + ", $v0\n";
        return mensaje;
    }
}
