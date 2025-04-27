package com.lexicalanalyzer;

import java.io.FileReader;
import java.io.IOException;
import java_cup.runtime.Symbol;

public class Main {
    public static void main(String[] args) {
        try {
            // Abrir el archivo de prueba
            FileReader archivo = new FileReader("test.txt");

            // Crea el analizador léxico
            MiLexer scanner = new MiLexer(archivo);

            // Crea el analizador sintáctico
            parser parserObj = new parser(scanner);

            // Intenta hacer el análisis sintáctico
            Symbol resultado = parserObj.parse();

            System.out.println("Análisis sintáctico completado exitosamente.");

        } catch (IOException e) {
            System.err.println("Error de entrada/salida: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Se encontró un error durante el análisis sintáctico.");
            //e.printStackTrace();
        }
    }
}


