/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author males
 */
public class TablaTemporalesStrings {
    private static Map<String, String> tabla = new HashMap<>();

    public static void agregar(String temporal, String etiqueta) {
        tabla.put(temporal, etiqueta);
    }

    public static String obtenerEtiqueta(String temporal) {
        return tabla.get(temporal);
    }
}