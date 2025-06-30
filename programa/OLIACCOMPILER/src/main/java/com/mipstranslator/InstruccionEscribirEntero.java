/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionEscribirEntero implements InstruccionMIPS{
    private String Temporal;
    
    public InstruccionEscribirEntero(String temporal){
        Temporal = temporal;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "move $a0, $" + Temporal + "\n";
        mensaje += "li $v0, 1\n";
        mensaje += "syscall";
        return mensaje;
    }
}
