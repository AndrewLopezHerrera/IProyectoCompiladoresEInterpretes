/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionRegistroTemporalFlotante implements InstruccionMIPS{
    private String RegistroEntero;
    private String RegistroFlotante;
    private String Valor;
    
    public InstruccionRegistroTemporalFlotante(String registroEntero, String registroFlotante, String valor){
        RegistroEntero = registroEntero;
        RegistroFlotante = registroFlotante;
        Valor = valor;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "li $" + RegistroEntero + ", " + Valor + "\n";
        mensaje += "mtc1 $" + RegistroEntero + ", $" + RegistroFlotante + "\n";
        return mensaje;
    }
}
