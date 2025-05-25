package com.lexicalanalyzer;

import java.util.*;

public class TablaDeSimbolos {

    private static class Entrada {
        String lexema;
        String tipoToken;
        String tipoDeclarado; // ← nuevo campo

        Entrada(String lexema, String tipoToken, String tipoDeclarado) {
            this.lexema = lexema;
            this.tipoToken = tipoToken;
            this.tipoDeclarado = tipoDeclarado;
        }

        @Override
        public String toString() {
            return String.format("%-15s | %-15s | %-15s", lexema, tipoToken, tipoDeclarado);
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
        agregar(token, lexema, null); // delegar con tipoDato nulo
    }

    public void agregar(int token, String lexema, String tipoDato) {
        String nombreToken = obtenerNombreToken(token);
        if (!actual.tabla.containsKey(lexema)) {
            actual.tabla.put(lexema, new Entrada(lexema, nombreToken, tipoDato));
        }
    }


    public void insertar(String lexema, int token) {
        insertar(lexema, token, "-");
    }

    public void insertar(String lexema, int token, String tipoDeclarado) {
        String tipoToken = obtenerNombreToken(token);
        if (!actual.tabla.containsKey(lexema)) {
            actual.tabla.put(lexema, new Entrada(lexema, tipoToken, tipoDeclarado));
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