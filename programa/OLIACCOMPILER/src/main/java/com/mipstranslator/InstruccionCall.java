/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author males
 */


public class InstruccionCall implements InstruccionMIPS {
    private final String nombreFuncion;
    private final int cantidadParametros;

   public InstruccionCall(String linea) {
        // Si hay una asignación, ignoramos todo antes del '='
        String llamada = linea.contains("=") ? linea.split("=")[1].trim() : linea.trim();

        // Verificamos que contenga "call"
        if (!llamada.startsWith("call")) {
            throw new IllegalArgumentException("Instrucción call mal formada: " + linea);
        }

        // Eliminamos "call" y tomamos solo lo que viene después
        String resto = llamada.substring(4).trim();  // elimina "call "

        // Separamos los argumentos por coma
        String[] partes = resto.split(",");

        if (partes.length < 2) {
            throw new IllegalArgumentException("Llamada a función debe tener nombre y cantidad de parámetros (nombre,parametros): " + linea);
        }

        this.nombreFuncion = partes[0].trim();  // func1
        this.cantidadParametros = Integer.parseInt(partes[1].trim());  // 2
    }



    @Override
    public String toString() {
        return """
            # Llamada a función
            jal """ + " " + nombreFuncion + "   # Jump and link (CALL)";
    }
}
