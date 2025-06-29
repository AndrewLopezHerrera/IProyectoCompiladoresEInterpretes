/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionComparacionEntero implements InstruccionMIPS {
    private String Instruccion;
    private String Destino;
    private String TempUno;
    private String TempDos;

    public InstruccionComparacionEntero(String Instruccion, String Destino, String TempUno, String TempDos) {
        this.Instruccion = Instruccion;
        this.Destino = Destino;
        this.TempUno = TempUno;
        this.TempDos = TempDos;
    }

    @Override
    public String toString() {
        String mensaje = "";
        mensaje += Instruccion + " $" + Destino + ", $" + TempUno + ", $" + TempDos;
        return mensaje;
    }
    
    
}
