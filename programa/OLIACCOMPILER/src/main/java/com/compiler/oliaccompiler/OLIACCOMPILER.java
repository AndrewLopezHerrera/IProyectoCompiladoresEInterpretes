package com.compiler.oliaccompiler;

import com.lexicalanalyzer.MiLexer;
import com.lexicalanalyzer.parser;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.FileReader;
import java.io.BufferedReader;
import java.io.StringReader;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;

@Command(name = "parserapp", description = "Parser de archivos fuente", mixinStandardHelpOptions = true)
public class OLIACCOMPILER implements Callable<Integer> {

    @Option(names = {"-f", "--file"}, description = "Archivo de entrada", required = true)
    private File file;

    @Override
    public Integer call() {
        try {
            // Leemos el archivo
            BufferedReader br = new BufferedReader(new FileReader(file));
            
            // Crear el lexer con el archivo
            MiLexer lexer = new MiLexer(new StringReader(readFile(br)));

            // Crear el parser
            parser p = new parser(lexer);

            // Parsear
            p.parse();
            System.out.println("Parseo exitoso!");

            return 0; // OK
        } catch (Exception e) {
            System.err.println("Error durante el parseo: " + e.getMessage());
            return 1; // Error
        }
    }

    private String readFile(BufferedReader br) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CommandLine cmd = new CommandLine(new OLIACCOMPILER());
        cmd.parseWithHandler(new CommandLine.RunLast(), args);
    }
}

