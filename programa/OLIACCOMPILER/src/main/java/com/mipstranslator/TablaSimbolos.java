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
        MemoriaParametros = 8;
        MemoriaVariables = 0;
        Padre = padre;
    }
    
    public void AgregarVariable(LineaTabla linea){
        Variables.put(linea.getNombre(), linea);
        linea.setDireccionRelativa(MemoriaParametros * -1);
        MemoriaParametros += 4;
    }
    
    public void AgregarParametro(LineaTabla linea){
        Variables.put(linea.getNombre(), linea);
        linea.setDireccionRelativa(MemoriaVariables);
        MemoriaVariables += 4;
    }
    
    public String toString() {
        String mensaje = "";
        mensaje += "move $fp, $sp\n";
        mensaje += Nombre + ":\n";
        mensaje += "addi $sp, $sp, -" + MemoriaParametros + "\n";
        mensaje += "sw $ra, -4($sp)\n";
        for(InstruccionMIPS instruccion : Instrucciones){
            mensaje += instruccion.toString();
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
