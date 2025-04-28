package com.lexicalanalyzer;

import java.io.FileReader;
import java_cup.runtime.Symbol;

public class Main {
    public static void main(String[] args) throws Exception {
        // Abrir el archivo test.txt para analizar
        FileReader archivo = new FileReader("test.txt");

        // Crear el Lexer (scanner)
        MiLexer scanner = new MiLexer(archivo);

        // Crear el Parser
        parser parserObj = new parser(scanner);

        // Ejecutar el parseo
        parserObj.parse();
        
        System.out.println("Análisis completado exitosamente.");
    }
}
