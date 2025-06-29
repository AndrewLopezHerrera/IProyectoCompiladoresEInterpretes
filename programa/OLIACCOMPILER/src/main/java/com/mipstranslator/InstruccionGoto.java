/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionGoto implements InstruccionMIPS{
    private String Destino;

    public InstruccionGoto(String Destino) {
        this.Destino = Destino;
    }

    @Override
    public String toString() {
        String mensaje = "";
        mensaje += "j " + Destino;
        return mensaje;
    }
    
    
}
