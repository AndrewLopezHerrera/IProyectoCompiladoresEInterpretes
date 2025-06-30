/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 * Clase que representa una instrucción de asignación de un literal entero
 * a un registro temporal. Se espera que esta instrucción genere el código
 * MIPS equivalente a la carga inmediata de un valor entero.
 *
 * Ejemplo de código intermedio: {@code t1 = -5}
 * Resultado esperado en MIPS: {@code li $t1, -5}
 *
 * @author andre
 */
public class InstruccionAsignacionLiteralEntero implements InstruccionMIPS {

    /** Nombre del registro temporal al que se asignará el valor entero */
    private String Registro;

    /** Valor entero como cadena, tal como aparece en el código intermedio */
    private String Valor;
    
    public InstruccionAsignacionLiteralEntero(String registro, String valor){
        Registro = registro;
        Valor = valor;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "li $" + Registro + ", " + Valor;
        return mensaje;
    }

    // Aquí puede agregarse el método toString() o generarCodigoMIPS() si corresponde
}
