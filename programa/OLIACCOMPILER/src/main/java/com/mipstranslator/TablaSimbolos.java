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
    private int Memoria;
    private TablaSimbolos Padre;
    
    public TablaSimbolos(String nombre, TablaSimbolos padre){
        Variables = new HashMap<>();
        Instrucciones = new ArrayList<>();
        Nombre = nombre;
        Memoria = 0;
        Padre = padre;
    }
    
    public void AgregarVariable(LineaTabla linea){
        Variables.put(linea.getNombre(), linea);
        linea.setDireccionRelativa(Memoria);
        Memoria += 4;
    }
    
    public void AumentarMemoria(int memoria){
        Memoria += memoria;
    }
    
    public String toString() {
        String mensaje = "";
        mensaje += Nombre + ":\n";
        mensaje += "addi $sp, $sp, -8\n";
        mensaje += "sw $ra, 0($sp)\n";
        mensaje += "sw $fp, 4($sp)\n";
        mensaje += "move $fp, $sp\n";
        mensaje += "addi $sp, $sp, -" + Memoria + "\n";
        for(InstruccionMIPS instruccion : Instrucciones){
            mensaje += instruccion.toString();
        }
        return mensaje;
    }
    
    public void AgregarInstruccion(InstruccionMIPS instruccion){
        Instrucciones.add(instruccion);
    }
    
    public int getMemoria(){
        return Memoria;
    }
}
