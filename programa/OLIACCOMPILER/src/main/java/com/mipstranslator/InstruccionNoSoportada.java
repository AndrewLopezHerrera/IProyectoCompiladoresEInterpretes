/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author males
 */
public class InstruccionNoSoportada implements InstruccionMIPS {
    private final String linea;

    public InstruccionNoSoportada(String linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "# instrucción no implementada: " + linea;
    }
}
