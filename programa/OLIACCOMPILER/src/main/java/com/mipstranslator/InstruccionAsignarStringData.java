/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionAsignarStringData implements InstruccionMIPS{
    private String Nombre;
    private String Datos;
    
    public InstruccionAsignarStringData(String nombre, String datos){
        Nombre = nombre;
        Datos = datos;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += Nombre + ": .asciiz " + Datos;
        return mensaje;
    }
}
