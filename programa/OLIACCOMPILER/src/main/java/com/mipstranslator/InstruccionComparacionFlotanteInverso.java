/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionComparacionFlotanteInverso implements InstruccionMIPS {
    private String Instruccion;
    private String Destino;
    private String TempUno;
    private String TempDos;

    public InstruccionComparacionFlotanteInverso(String Instruccion, String Destino, String TempUno, String TempDos) {
        this.Instruccion = Instruccion;
        this.Destino = Destino;
        this.TempUno = TempUno;
        this.TempDos = TempDos;
    }

    @Override
    public String toString() {
        String mensaje = "";
        mensaje += Instruccion + " $" + TempUno + ", $" + TempDos + "\n";
        mensaje += "li $a0, 1\n";
        mensaje += "li $a1, 0\n";
        mensaje += "movf $" + Destino + ", $a0\n";
        mensaje += "movt $" + Destino + ", $a1\n";
        return mensaje;
    }
    
    
}
