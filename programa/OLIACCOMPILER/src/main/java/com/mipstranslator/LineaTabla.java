/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class LineaTabla {
    private String Nombre;
    private String Tipo;
    private int DireccionRelativa;
    
    public LineaTabla(String nombre, String tipo, int direccion){
        Nombre = nombre;
        Tipo = tipo;
        DireccionRelativa = direccion;
    }

    public void setDireccionRelativa(int DireccionRelativa) {
        this.DireccionRelativa = DireccionRelativa;
    }

    public String getNombre() {
        return Nombre;
    }

    public String getTipo() {
        return Tipo;
    }

    public Integer getDireccionRelativa() {
        return DireccionRelativa;
    }
}
