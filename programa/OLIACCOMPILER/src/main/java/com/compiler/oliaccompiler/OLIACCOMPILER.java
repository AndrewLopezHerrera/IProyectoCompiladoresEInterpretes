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

    @Override
    public void run() {
        try {
            // Crear el lexer con el archivo
            MiLexer lexer = new MiLexer(new FileReader(file));

            // Crear el parser
            parser p = new parser(lexer);

            // Parsear
            p.parse();
            System.out.println("Parseo exitoso!");

        } catch (Exception e) {
            System.err.println("Error durante el parseo: " + e.getMessage()+ "\n" + e.getLocalizedMessage() + "\n" + e.toString());
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