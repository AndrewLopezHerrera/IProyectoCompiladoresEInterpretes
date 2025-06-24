/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionEscribirFlotante implements InstruccionMIPS{
    private String Temporal;
    
    public InstruccionEscribirFlotante(String temporal){
        Temporal = temporal;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "move $a0, $" + Temporal + "\n";
        mensaje += "li $v0, 2\n";
        mensaje += "syscall\n";
        return mensaje;
    }
}
