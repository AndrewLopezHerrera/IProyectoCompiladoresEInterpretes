/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionIfFalseGoto implements InstruccionMIPS {
    private String Temporal;
    private String Destino;

    public InstruccionIfFalseGoto(String Temporal, String Destino) {
        this.Temporal = Temporal;
        this.Destino = Destino;
    }

    @Override
    public String toString() {
        String mensaje = "";
        mensaje += "beq $" + Temporal + ", $zero, " + Destino;
        return mensaje;
    }
}
