/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class GuardarEnArreglo implements InstruccionMIPS {
    private String DireccionRelativa;
    private String Indice;
    private String Valor;

    public GuardarEnArreglo(String DireccionRelativa, String Indice, String Valor) {
        this.DireccionRelativa = DireccionRelativa;
        this.Indice = Indice;
        this.Valor = Valor;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "lw $s0, $" + DireccionRelativa + "($fp)\n";
        mensaje += "sw $" + Valor + ", " + Indice + "($s0)";
        return mensaje;
    }
}
