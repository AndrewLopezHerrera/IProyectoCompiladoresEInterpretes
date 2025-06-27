/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author males
 */

public class InstruccionFuncionCall implements InstruccionMIPS {
    private String nombreFuncion;
    private String cantidadParametros;

    public InstruccionFuncionCall(String nombreFuncion, String cantidadParametros) {
        this.nombreFuncion = nombreFuncion;
        this.cantidadParametros = cantidadParametros;
    }

    @Override
    public String toString() {
        return "jal " + nombreFuncion; // MIPS usa 'jal' para llamar funciones
    }
}
