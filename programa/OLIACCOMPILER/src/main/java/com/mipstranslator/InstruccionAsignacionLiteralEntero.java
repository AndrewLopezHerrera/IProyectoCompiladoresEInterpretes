/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionAsignacionLiteralEntero implements InstruccionMIPS{
    private String Registro;
    private String Valor;
    private final String destino;
    private final String valor;
    
    public InstruccionAsignacionLiteralEntero(String registro, String valor){
        Registro = registro;
        Valor = valor;
        this.destino = destino;
        this.valor = valor;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "li $" + Registro + ", " + Valor + "\n";
        return mensaje;
    }

    public String traducir() {
        String instruccion = "";

        if (valor.matches("^-?\\d+$")) { // Entero
            String registro = AnalizadorCodigoIntermedio.registrosEnteros.RegistrarRegistro(destino);
            instruccion += "li $" + registro + ", " + valor + "\n";
        } else if (valor.matches("^-?\\d*\\.\\d+$")) { // Flotante
            String registro = AnalizadorCodigoIntermedio.registrosFlotantes.RegistrarRegistro(destino);
            instruccion += "li.s $" + registro + ", " + valor + "\n";
        } else if (valor.matches("^'.'$")) { // Char
            char c = valor.charAt(1);
            int ascii = (int) c;
            String registro = AnalizadorCodigoIntermedio.registrosEnteros.RegistrarRegistro(destino);
            instruccion += "li $" + registro + ", " + ascii + "\n";
        } else if (valor.equals("sol") || valor.equals("luna")) { // Booleanos simulados
            int booleano = valor.equals("sol") ? 1 : 0;
            String registro = AnalizadorCodigoIntermedio.registrosEnteros.RegistrarRegistro(destino);
            instruccion += "li $" + registro + ", " + booleano + "\n";
        } else if (valor.startsWith("\"")) { // Strings
            instruccion += ".data\netiqueta_" + destino + ": .asciiz " + valor + "\n.text\n";
            AnalizadorCodigoIntermedio.registrosEnteros.RegistrarRegistro(destino);
        }

        return instruccion;
    }
}
