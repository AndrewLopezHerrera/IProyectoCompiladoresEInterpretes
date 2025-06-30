/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionRetornoFlotante implements InstruccionMIPS{
    private String Temporal;

    public InstruccionRetornoFlotante(String Temporal) {
        this.Temporal = Temporal;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "mov.s $f0, $" + Temporal + "\n";
        mensaje += "lw $ra, -4($fp)\n";
        mensaje += "move $sp, $fp\n";
        mensaje += "jr $ra";
        return mensaje;
    }
}
