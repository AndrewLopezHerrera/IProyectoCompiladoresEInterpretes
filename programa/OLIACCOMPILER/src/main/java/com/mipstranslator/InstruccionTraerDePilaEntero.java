/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionTraerDePilaEntero implements InstruccionMIPS{
    private String Registro;
    private String Direccion;
    
    public InstruccionTraerDePilaEntero(String registro, String direccion){
        Registro = registro;
        Direccion = direccion;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "lw $" + Registro + ", " + Direccion + "($fp)";
        return mensaje;
    }
}
