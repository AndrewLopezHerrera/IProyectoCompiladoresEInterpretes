package com.lexicalanalyzer;

import java.util.*;

public class TablaDeSimbolos {

    private static class Entrada {
        String lexema;
        String tipoToken;

        Entrada(String lexema, String tipoToken) {
            this.lexema = lexema;
            this.tipoToken = tipoToken;
        }

        @Override
        public String toString() {
            return String.format("%-15s | %-15s", lexema, tipoToken);
        }
    }

    private static class Ambito {
        Map<String, Entrada> tabla = new LinkedHashMap<>();
        Ambito anterior;

        Ambito(Ambito anterior) {
            this.anterior = anterior;
        }

        Entrada buscar(String lexema) {
            Entrada entrada = tabla.get(lexema);
            if (entrada != null) return entrada;
            if (anterior != null) return anterior.buscar(lexema);
            return null;
        }
    }

    private Ambito actual;

    public TablaDeSimbolos() {
        this.actual = new Ambito(null); // ámbito global
    }

    public void abrirAmbito() {
        actual = new Ambito(actual);
    }

    public void cerrarAmbito() {
        if (actual != null) {
            actual = actual.anterior;
        }
    }

    public void agregar(int token, String lexema) {
        String nombreToken = obtenerNombreToken(token);
        if (!actual.tabla.containsKey(lexema)) {
            actual.tabla.put(lexema, new Entrada(lexema, nombreToken));
        }
    }

    public void insertar(String nombre, String tipo) {
        if (!actual.tabla.containsKey(nombre)) {
            actual.tabla.put(nombre, new Entrada(nombre, tipo));
        }
    }


    private String obtenerNombreToken(int token) {
        try {
            for (java.lang.reflect.Field field : Class.forName("com.lexicalanalyzer.sym").getFields()) {
                if (field.getType() == int.class && field.getInt(null) == token) {
                    return field.getName();
                }
            }
        } catch (Exception e) {
            return "TOKEN_" + token;
        }
        return "TOKEN_" + token;
    }

    public void imprimir() {
        System.out.println("\n--- Tabla de Símbolos ---");
        Ambito temp = actual;
        int nivel = 0;
        while (temp != null) {
            System.out.println("Ambito nivel " + nivel + ":");
            for (Entrada entrada : temp.tabla.values()) {
                System.out.println(entrada);
            }
            temp = temp.anterior;
            nivel++;
        }
    }
}
