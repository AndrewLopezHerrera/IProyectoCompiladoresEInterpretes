/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionEscribirString {
    private String Temporal;
    
    public InstruccionEscribirString(String temporal){
        Temporal = temporal;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "move $a0, $" + Temporal + "\n";
        mensaje += "li $v0, 4\n";
        mensaje += "syscall\n";
        return mensaje;
    }
}
