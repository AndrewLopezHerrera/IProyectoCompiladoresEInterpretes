package com.compiler.oliaccompiler;

import com.lexicalanalyzer.MiLexer;
import com.lexicalanalyzer.parser;
import com.lexicalanalyzer.TablaDeSimbolos; // ✨ Agregamos import
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.FileReader;
import java.io.File;

@Command(name = "parserapp", description = "Parser de archivos fuente", mixinStandardHelpOptions = true)
public class OLIACCOMPILER implements Runnable {

    @Option(names = {"-f", "--file"}, description = "Archivo de entrada", required = true)
    private File file;

    @Override
    public void run() {
        try {
            // Crear la tabla de símbolos
            TablaDeSimbolos tablaSimbolos = new TablaDeSimbolos();

            // Crear el lexer con el archivo
            MiLexer lexer = new MiLexer(new FileReader(file));
            lexer.setTablaSimbolos(tablaSimbolos); // Enlazar tabla al lexer

            // Crear el parser
            parser p = new parser(lexer);
            p.setTablaSimbolos(tablaSimbolos); // Enlazar tabla al parser

            // Parsear
            p.parse();

            // Resultado del análisis
            if (p.error_count == 0) {
                System.out.println("\n--- Parseo exitoso, sin errores sintácticos ---");
            } else {
                System.out.println("\n--- Parseo finalizado ---");
                System.out.println("Cantidad de errores sintácticos detectados: " + p.error_count);
            }

            // Imprimir la tabla de símbolos
            tablaSimbolos.imprimir();

        } catch (Exception e) {
            System.err.println("Error durante el parseo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        OLIACCOMPILER app = new OLIACCOMPILER();
        CommandLine cmd = new CommandLine(app);
        int exitCode = cmd.execute(args);
        System.exit(exitCode);
    }
}
