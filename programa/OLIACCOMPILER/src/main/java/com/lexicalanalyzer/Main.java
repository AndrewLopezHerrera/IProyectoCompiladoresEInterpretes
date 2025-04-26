package com.lexicalanalyzer;

import java.io.FileReader;
import java_cup.runtime.Symbol;

public class Main {
    public static void main(String[] args) throws Exception {
        String archivoEntrada = "test.txt";

        // Crea el analizador léxico
        MiLexer lexer = new MiLexer(new FileReader(archivoEntrada));

        // Crea el parser, pasándole el lexer
        Parser parser = new Parser(lexer);

        // Ejecuta el parser
        try {
            parser.parse();
            System.out.println("Análisis sintáctico completado exitosamente.");
        } catch (Exception e) {
            System.out.println("Se encontró un error durante el análisis.");
            e.printStackTrace();
        }
    }
}
