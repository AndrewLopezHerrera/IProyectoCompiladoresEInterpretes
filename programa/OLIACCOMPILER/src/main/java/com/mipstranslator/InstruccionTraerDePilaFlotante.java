/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionTraerDePilaFlotante implements InstruccionMIPS {
    private String Registro;
    private String Direccion;
    
    public InstruccionTraerDePilaFlotante(String registro, String direccion){
        Registro = registro;
        Direccion = direccion;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "l.s $" + Registro + ", " + Direccion + "($fp)\n";
        return mensaje;
    }
}
