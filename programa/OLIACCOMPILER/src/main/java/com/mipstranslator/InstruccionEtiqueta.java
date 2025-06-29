/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionEtiqueta implements InstruccionMIPS {
    private String Nombre;

    public InstruccionEtiqueta(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        String mensaje = "";
        mensaje += Nombre + ":";
        return mensaje;
    }
    
    
}
