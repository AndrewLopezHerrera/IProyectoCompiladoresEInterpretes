/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author males
 */

public class TablaStrings {

    private static Map<String, String> tabla = new LinkedHashMap<>();

    public static void agregar(String etiqueta, String valor) {
        tabla.put(etiqueta, valor);
    }

    public static String generarSegmentoData() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : tabla.entrySet()) {
            sb.append(entry.getKey()).append(": .asciiz \"")
              .append(entry.getValue()).append("\"\n");
        }
        return sb.toString();
    }
    
    public static String generarSeccionData() {
        StringBuilder sb = new StringBuilder();
        sb.append(".data\n");
        for (Map.Entry<String, String> entry : tabla.entrySet()) {
            sb.append(entry.getKey())
              .append(": .asciiz \"")
              .append(entry.getValue().replace("\"", "\\\""))
              .append("\"\n");
        }
        return sb.toString();
    }
}
