/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 * Clase que representa la asignación de un string a un nombre de etiqueta o temporal,
 * incluyendo su registro en la sección `.data` y la asociación con una etiqueta.
 * Puede construirse desde un par (nombre, datos) para incluirlo directamente en .data,
 * o desde una línea de código intermedio con asignación de string.
 * 
 * Esta clase es útil tanto para declarar explícitamente un string en la sección
 * de datos como para procesar asignaciones en código intermedio.
 * 
 * Ejemplos:
 * <pre>
 * new InstruccionAsignarStringData("etiqueta1", "\"Hola mundo\"");
 * new InstruccionAsignarStringData("t1 = \"Hola\"");
 * </pre>
 * 
 * @author andre
 */
public class InstruccionAsignarStringData implements InstruccionMIPS {

    /** Nombre o etiqueta del string para .data */
    private String Nombre;

    /** Contenido del string */
    private String Datos;

    /** Temporal al que se asigna el string */
    private String temporal;

    /** Valor del string sin comillas */
    private String valor;

    /** Contador para etiquetas únicas generadas automáticamente */
    private static int contadorEtiquetas = 0;

    /** Etiqueta asociada internamente */
    private String etiqueta;

    /**
     * Constructor usado para registrar manualmente una etiqueta y su contenido en la sección .data.
     * 
     * @param nombre Nombre de la etiqueta
     * @param datos Contenido del string (debe incluir comillas si se desea)
     */
    public InstruccionAsignarStringData(String nombre, String datos) {
        this.Nombre = nombre;
        this.Datos = datos;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += Nombre + ": .asciiz " + Datos;
        return mensaje;
    }
}
