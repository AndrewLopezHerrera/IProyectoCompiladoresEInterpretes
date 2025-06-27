/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author males
 */

public class InstruccionObtenerRetorno implements InstruccionMIPS {
    private String destino;

    public InstruccionObtenerRetorno(String destino) {
        this.destino = destino;
    }

    @Override
    public String toString() {
        return """
               # Obtener valor de retorno
               move """ + destino + ", $v0\n";
    }
}
