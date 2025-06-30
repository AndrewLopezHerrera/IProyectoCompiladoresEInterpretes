/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class TablaSimbolos {
    private Map<String, LineaTabla> Variables;
    private List<InstruccionMIPS> Instrucciones;
    private String Nombre;
    private int MemoriaVariables;
    private int MemoriaParametros;
    private TablaSimbolos Padre;
    
    public TablaSimbolos(String nombre, TablaSimbolos padre){
        Variables = new HashMap<>();
        Instrucciones = new ArrayList<>();
        Nombre = nombre;
        MemoriaParametros = 0;
        MemoriaVariables = 8;
        Padre = padre;
    }
    
    public void AgregarVariable(LineaTabla linea){
        Variables.put(linea.getNombre(), linea);
        linea.setDireccionRelativa(MemoriaVariables * -1);
        MemoriaVariables += 4;
    }
    
    public void AgregarParametro(LineaTabla linea){
        Variables.put(linea.getNombre(), linea);
        linea.setDireccionRelativa(MemoriaParametros);
        MemoriaParametros += 4;
    }
    
    public String toString() {
        String mensaje = "";
        mensaje += Nombre + ":\n";
        mensaje += "move $fp, $sp\n";
        mensaje += "addi $sp, $sp, -" + MemoriaVariables + "\n";
        mensaje += "sw $ra, -4($fp)\n";
        for(InstruccionMIPS instruccion : Instrucciones){
            mensaje += instruccion.toString() + "\n";
        }
        return mensaje;
    }
    
    public void AgregarInstruccion(InstruccionMIPS instruccion){
        Instrucciones.add(instruccion);
    }
    
    public int getMemoria(){
        return MemoriaParametros;
    }
    
    public LineaTabla ObtenerVariable(String nombre){
        LineaTabla linea = Variables.get(nombre);
        return linea;
    }
}
