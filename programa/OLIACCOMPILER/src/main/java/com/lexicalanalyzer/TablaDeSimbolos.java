package com.lexicalanalyzer;

import java.util.ArrayList;
import java.util.List;

public class TablaDeSimbolos {

    // Cada entrada puede tener tipo de token y valor
    private static class Entrada {
        int tipoToken;
        String valor;

        Entrada(int tipoToken, String valor) {
            this.tipoToken = tipoToken;
            this.valor = valor;
        }
    }

    private final List<Entrada> simbolos = new ArrayList<>();

    // Método para agregar tokens
    public void agregar(int tipoToken, String valor) {
        simbolos.add(new Entrada(tipoToken, valor));
    }

    // Método para mostrar todos los tokens almacenados
    public void mostrar() {
        for (Entrada entrada : simbolos) {
            System.out.println("Token: " + entrada.tipoToken + ", Valor: " + entrada.valor);
        }
    }
}
