/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase encargada de registrar y administrar los literales de tipo string
 * que se utilizarán en la sección `.data` del código MIPS.
 * Cada string único se asocia con una etiqueta única (por ejemplo, msg0, msg1, ...).
 * 
 * Esta clase también puede generar el contenido completo de la sección `.data`
 * con los strings declarados.
 * 
 * @author males
 */
public class AdministradorStrings {
    /** Mapa que asocia un string literal con su etiqueta en la sección .data */
    private Map<String, String> stringsDeclarados = new HashMap<>();
    
    /** Contador utilizado para generar etiquetas únicas (msg0, msg1, ...) */
    private int contador = 0;

    /**
     * Registra un nuevo string literal si no ha sido registrado anteriormente.
     * Devuelve la etiqueta asociada al string, ya sea existente o recién creada.
     *
     * @param valor El valor del string literal (sin comillas).
     * @return La etiqueta asociada a ese string (por ejemplo, "msg0").
     */
    public String registrarString(String valor) {
        if (!stringsDeclarados.containsKey(valor)) {
            String etiqueta = "msg" + contador++;
            stringsDeclarados.put(valor, etiqueta);
        }
        return stringsDeclarados.get(valor);
    }

    /**
     * Genera la sección `.data` en formato MIPS que contiene todas
     * las declaraciones de strings registrados como `.asciiz`.
     *
     * @return Cadena con el contenido de la sección .data en MIPS.
     */
    public String generarSeccionData() {
        StringBuilder data = new StringBuilder();
        for (Map.Entry<String, String> entry : stringsDeclarados.entrySet()) {
            data.append(entry.getValue())
                .append(": .asciiz ")
                .append("\"").append(entry.getKey()).append("\"\n");
        }
        return data.toString();
    }
}
