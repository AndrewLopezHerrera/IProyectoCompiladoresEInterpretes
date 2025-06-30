/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionParametroSalidaFlotante implements InstruccionMIPS{
    private String Temporal;
    private String DireccionRelativa;
            
    public InstruccionParametroSalidaFlotante(String numeroString, String temporalMIPS){
        Temporal = temporalMIPS;
        Integer numero = Integer.parseInt(numeroString);
        numero = numero * -4;
        DireccionRelativa = numero.toString();
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "s.s $" + Temporal + ", " + DireccionRelativa + "($sp)";
        return mensaje;
    }
}
