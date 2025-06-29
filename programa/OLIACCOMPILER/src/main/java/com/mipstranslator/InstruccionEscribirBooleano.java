/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionEscribirBooleano implements InstruccionMIPS{
    private String Temporal;
    private int NumeroCondicion;
    private static int Cantidad = 0;
    
    public InstruccionEscribirBooleano(String temporal){
        Temporal = temporal;
        Cantidad++;
        NumeroCondicion = Cantidad;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "beq $" + Temporal + ", $zero, print_false" + NumeroCondicion + "\n";
        mensaje += "la $a0, msg_luna\n";
        mensaje += "li $v0, 4\n";
        mensaje += "syscall\n";
        mensaje += "j end_print" + NumeroCondicion + "\n";
        mensaje += "print_false" + NumeroCondicion + ":\n";
        mensaje += "la $a0, msg_sol\n";
        mensaje += "li $v0, 4\n";
        mensaje += "syscall\n";
        mensaje += "end_print" + NumeroCondicion + "\n";
        return mensaje;
    }
}
