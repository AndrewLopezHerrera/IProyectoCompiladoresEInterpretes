/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionCargarDireccionMemoria implements InstruccionMIPS {
    private String Registro;
    private String Valor;
    
    public InstruccionCargarDireccionMemoria(String registro, String valor){
        Registro = registro;
        Valor = valor;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "la $" + Registro + ", " + Valor + "\n";
        return mensaje;
    }
}
