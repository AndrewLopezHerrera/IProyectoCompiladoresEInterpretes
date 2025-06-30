/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionComparacionFlotante implements InstruccionMIPS {
    private static int contador = 0;

    private String instruccion;
    private String destino;
    private String tempUno;
    private String tempDos;
    private int id;

    public InstruccionComparacionFlotante(String instruccion, String destino, String tempUno, String tempDos) {
        this.instruccion = instruccion;
        this.destino = destino;
        this.tempUno = tempUno;
        this.tempDos = tempDos;
        this.id = contador++; // para etiquetas únicas
    }

    @Override
    public String toString() {
        String etiquetaVerdadera = "etiqueta_true_cmp_" + id;
        String etiquetaFinal = "etiqueta_fin_cmp_" + id;

        String mensaje = "";
        mensaje += instruccion + " $" + tempUno + ", $" + tempDos + "\n";
        mensaje += "bc1t " + etiquetaVerdadera + "\n";
        mensaje += "li $" + destino + ", 0\n";
        mensaje += "j " + etiquetaFinal + "\n";
        mensaje += etiquetaVerdadera + ":\n";
        mensaje += "li $" + destino + ", 1\n";
        mensaje += etiquetaFinal + ":";

        return mensaje;
    }
}

