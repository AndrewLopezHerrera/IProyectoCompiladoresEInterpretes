/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionCargarEnteroArreglo implements InstruccionMIPS {
    private String Registro;
    private String Direccion;
    private String Indice;
    
    public InstruccionCargarEnteroArreglo(String registro, String direccion, String indice){
        Registro = registro;
        Direccion = direccion;
        Indice = indice;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "lw $s0, " + Direccion + "($fp)\n";
        mensaje += "sw $" + Registro + ", " + Indice + "($s0)";
        return mensaje;
    }
}
