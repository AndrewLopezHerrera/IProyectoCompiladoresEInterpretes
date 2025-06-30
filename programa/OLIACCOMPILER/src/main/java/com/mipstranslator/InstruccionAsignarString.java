/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

import java.util.Map;

/**
 * Clase que representa una instrucción de asignación de un valor string a un temporal
 * en código intermedio. Se encarga de registrar el string para que luego
 * sea incluido en la sección `.data` del código MIPS y genera el código necesario
 * para su uso.
 * 
 * Esta clase asocia el temporal con una etiqueta única y registra el valor
 * del string en una tabla para su posterior impresión o uso.
 *
 * Ejemplo de línea válida:
 * <pre>
 * t1 = "Hola mundo"
 * </pre>
 * 
 * @author males
 */
public class InstruccionAsignarString implements InstruccionMIPS {

    /** Nombre del temporal al que se le asigna el string */
    private String temporal;

    /** Valor del string (sin comillas) */
    private String valor;

    /** Contador estático para generar etiquetas únicas */
    private static int contadorEtiquetas = 0;

    /** Etiqueta asociada al string en la sección .data */
    private String etiqueta;

    /**
     * Constructor que recibe la línea de código intermedio y procesa la asignación.
     * 
     * @param linea línea del tipo {@code t1 = "texto"}
     */
    public InstruccionAsignarString(String linea) {
        String[] partes = linea.split("=");
        this.temporal = partes[0].trim();
        this.valor = partes[1].trim().replace("\"", ""); // elimina las comillas

        this.etiqueta = "str_" + (contadorEtiquetas++);
        TablaStrings.agregar(etiqueta, valor); // guarda el string en .data
    }

    /**
     * Genera un comentario descriptivo sobre la asignación y guarda la asociación
     * del temporal con la etiqueta de string.
     * 
     * @return comentario en formato MIPS explicando la asignación
     */
    @Override
    public String toString() {
        // Asocia el temporal con la etiqueta para futuras referencias
        TablaTemporalesStrings.agregar(temporal, etiqueta);

        return "# Asignación de string a " + temporal + "\n"
             + "# Guardado en etiqueta: " + etiqueta + "\n";
    }

    /**
     * Retorna la etiqueta generada para el string.
     * 
     * @return nombre de la etiqueta en la sección .data
     */
    public String getEtiqueta() {
        return etiqueta;
    }

    /**
     * Genera el código MIPS necesario para imprimir el string asignado
     * usando un syscall.
     * 
     * @return código MIPS que carga y muestra el string
     */
    public String generarCodigoMIPS() {
        StringBuilder sb = new StringBuilder();
        sb.append("# Asignación de string\n");

        sb.append("la $a0, ").append(etiqueta).append("\n");
        sb.append("li $v0, 4\n");
        sb.append("syscall\n");

        return sb.toString();
    }
}
