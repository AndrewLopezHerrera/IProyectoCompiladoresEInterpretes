/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 * Clase que representa una instrucción de asignación de valor booleano a un temporal.
 * En este lenguaje, el valor booleano se expresa como la palabra clave "luna" para `true`
 * y "sol" para `false`. Esta instrucción traduce esa asignación a código MIPS
 * utilizando una carga inmediata (`li`) con 1 (true) o 0 (false).
 *
 * Ejemplo de código intermedio: {@code t1 = luna}
 * Resultado MIPS: {@code li $t0, 1}
 *
 * @author males
 */
public class InstruccionAsignacionBooleano implements InstruccionMIPS {

    /** Nombre del temporal al que se asigna el valor booleano */
    private String temporal;

    /** Valor booleano como cadena ("luna" o "sol") */
    private String valor;

    /**
     * Constructor que interpreta una línea de código intermedio con una asignación booleana.
     *
     * @param linea Línea del código intermedio con formato: {@code temporal = luna|sol}
     */
    public InstruccionAsignacionBooleano(String linea) {
        String[] partes = linea.split("=");
        this.temporal = partes[0].trim();
        this.valor = partes[1].trim(); // debe ser "luna" o "sol"
    }

    /**
     * Genera el código MIPS correspondiente a la asignación booleana.
     * Utiliza `li` para asignar 1 si el valor es "luna", o 0 si es "sol".
     *
     * @return Una cadena con el código MIPS generado.
     */
    @Override
    public String toString() {
        int valorNumerico = valor.equals("luna") ? 1 : 0;  // luna = true, sol = false

        String registro = AnalizadorCodigoIntermedio.registrosEnteros.RegistrarRegistro(temporal);

        return "# Asignación booleana " + temporal + " = " + valor + "\n"
             + "li $" + registro + ", " + valorNumerico;
    }
}
