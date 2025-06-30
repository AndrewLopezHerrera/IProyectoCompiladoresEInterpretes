/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionLeerEntero implements InstruccionMIPS {
    private String Temporal;
    
    public InstruccionLeerEntero(String temporal){
        Temporal = temporal;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "li $v0, 5\n";
        mensaje += "syscall\n";
        mensaje += "move $" + Temporal + ", $v0";
        return mensaje;
    }
}
