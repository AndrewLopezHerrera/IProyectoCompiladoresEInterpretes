/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionIfGoto implements InstruccionMIPS {
    private String Temporal;
    private String Destino;

    public InstruccionIfGoto(String Temporal, String Destino) {
        this.Temporal = Temporal;
        this.Destino = Destino;
    }

    @Override
    public String toString() {
        String mensaje = "";
        mensaje += "li $a0, 1\n";
        mensaje += "beq $" + Destino + ", $a0, " + Destino;
        return mensaje;
    }
}
