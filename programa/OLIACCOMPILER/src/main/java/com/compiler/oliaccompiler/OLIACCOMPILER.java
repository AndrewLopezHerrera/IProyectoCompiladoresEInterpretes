package com.compiler.oliaccompiler;

import com.lexicalanalyzer.MiLexer;
import com.lexicalanalyzer.parser;// ✨ Agregamos import
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

            // Crear el lexer con el archivo
            MiLexer lexer = new MiLexer(new FileReader(file));

            // Crear el parser
            parser p = new parser(lexer);

            // Parsear
            p.parse();

            // Mostrar resultado del parseo
            if (p.error_count == 0) {
                System.out.println("\n--- Parseo exitoso, sin errores sintácticos ---");
            } else {
                System.out.println("\n--- Parseo finalizado ---");
                System.out.println("Cantidad de errores sintácticos detectados: " + p.error_count);
            }

            p.printTables();

        } catch (Exception e) {
            System.err.println("Error durante el parseo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Crear el objeto de la clase principal
        OLIACCOMPILER app = new OLIACCOMPILER();
        
        // Crear el objeto de CommandLine
        CommandLine cmd = new CommandLine(app);
        
        // Parsear los argumentos y ejecutar
        int exitCode = cmd.execute(args);
        
        // Salir con el código de estado adecuado
        System.exit(exitCode);
    }
}
