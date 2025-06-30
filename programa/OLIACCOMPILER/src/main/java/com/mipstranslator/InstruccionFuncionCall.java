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
        Integer cantidad = Integer.parseInt(cantidadParametros) + 1;
        cantidad = cantidad * 4;
        this.cantidadParametros = cantidad.toString();
    }

    @Override
    public String toString() {
        String mensaje = "";
        mensaje += "addi $sp, $sp, -" + cantidadParametros + "\n";
        mensaje += "jal " + nombreFuncion + "\n";
        mensaje += "addi $sp, $sp, " + cantidadParametros + "\n";
        mensaje += "lw $fp, -4($sp)\n";
        return mensaje;
    }
}
