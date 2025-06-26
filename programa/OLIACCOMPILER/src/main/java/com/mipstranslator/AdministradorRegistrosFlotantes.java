/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author andre
 */
public class AdministradorRegistrosFlotantes {
    private List<Boolean> Registros;
    private Map<String, String> UsoDeRegistros;
    private int RegistroActual;
    
    public AdministradorRegistrosFlotantes(){
        UsoDeRegistros = new HashMap<>();
        Registros = new ArrayList<>();
        RegistroActual = 4;
        for(int cantidad = 0; cantidad < 6; cantidad++){
            Registros.add(false);
        }
    }
    
    public String RegistrarRegistro(String temporal){
        String registroMIPS = DarSiguienteRegistro();
        UsoDeRegistros.put(temporal, registroMIPS);
        return registroMIPS;
    }
    
    private String DarSiguienteRegistro(){
        RegistroActual++;
        if(RegistroActual > 10)
            RegistroActual = 4;
        return "f" + RegistroActual;
    }
    
    public String ObtenerRegistroMIPSActual(){
        return "f" + RegistroActual;
    }
    
    public String ObtenerRegistroMIPSDeIntermedio(String tempIntermedio){
        return UsoDeRegistros.get(tempIntermedio);
    }
}
