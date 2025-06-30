/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class CargarDeArreglo implements InstruccionMIPS {
    private String DireccionRelativa;
    private String Indice;
    private String Valor;

    public CargarDeArreglo(String DireccionRelativa, String Indice, String Valor) {
        this.DireccionRelativa = DireccionRelativa;
        this.Indice = Indice;
        this.Valor = Valor;
    }

    @Override
    public String toString() {
        String mensaje = "";
        mensaje += "lw $a0, " + DireccionRelativa + "($fp)\n";
        mensaje += "add $" + Indice + ", $" + Indice + ", $a0\n";
        mensaje += "lw $" + Valor + ", 0($" + Indice + ")";
        return mensaje;
    }
    
    
}
