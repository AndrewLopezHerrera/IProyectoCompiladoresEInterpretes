package com.compiler.oliaccompiler;

import com.lexicalanalyzer.MiLexer;
import com.lexicalanalyzer.parser;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.FileReader;
import java.io.File;

@Command(name = "parserapp", description = "Parser de archivos fuente", mixinStandardHelpOptions = true)
public class OLIACCOMPILER implements Runnable {

    @Option(names = {"-f", "--file"}, description = "Archivo de entrada", required = true)
    private File file;

    @Option(names = {"-o", "--output"}, description = "Archivo de salida para el código intermedio", required = false)
    private File output = new File("codigo_intermedio.txt");

    @Override
    public void run() {
        try {
            MiLexer lexer = new MiLexer(new FileReader(file));
            parser p = new parser(lexer);
            p.parse();
            if (p.error_count != 0) {
                System.out.println("\n--- Parseo finalizado ---");
                System.out.println("Cantidad de errores sintácticos detectados: " + p.error_count);
            } else if(p.error_semantic_count != 0){
                System.out.println("\n--- Análisis semántico finalizado ---");
                System.out.println("Cantidad de errores semánticos detectados: " + p.error_semantic_count);
            }else {
                System.out.println("\n--- Parseo exitoso, sin errores sintácticos ---");
                System.out.println("--- Análisis semántico exitoso ---");
                System.out.println("--- Generando código intermedio en: " + output.getPath() + " ---");
                p.escribirCodigoIntermedio("codigo_intermedio.txt");
                p.escribirCodigoIntermedio(output.getPath());// Escribir el código intermedio en el archivo especificado
            }

        }catch (Exception e) {
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
