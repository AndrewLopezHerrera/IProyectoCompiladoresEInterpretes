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
    
    public InstruccionAsignacionLiteralEntero(String registro, String valor){
        Registro = registro;
        Valor = valor;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "li $" + Registro + ", " + Valor;
        return mensaje;
    }
}
