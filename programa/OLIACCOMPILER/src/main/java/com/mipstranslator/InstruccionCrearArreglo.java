/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author andre
 */
public class InstruccionCrearArreglo implements InstruccionMIPS{
    private AdministradorRegistrosEnteros Admin;
    private String Instrucciones;
    private Integer DireccionMemoria;
    private String CantidadMemoria;
    private String RegistroFinal;
    
    public InstruccionCrearArreglo(AdministradorRegistrosEnteros admin, String cantidadMemoria, String registroTresDirecciones){
        Admin = admin;
        DireccionMemoria = 0;
        CantidadMemoria = cantidadMemoria;
        Instrucciones = "";
        System.out.println("Registro tres direcciones: " + registroTresDirecciones);
        RegistroFinal = Admin.RegistrarRegistro(registroTresDirecciones);
    }
    
    public void AgregarNumero(String numero){
        String registroMIPS = Admin.RegistrarRegistro("");
        Instrucciones += "li $" + registroMIPS + ", " + numero + "\n";
        Instrucciones += "lw $" + registroMIPS + ", " + DireccionMemoria + "($s0)\n";
        DireccionMemoria += 4;
    }
    
    public String toString(){
        String mensaje = "";
        mensaje += "li $a0, " + DireccionMemoria + "\n";
        mensaje += "li $v0, 9\n";
        mensaje += "syscall\n";
        mensaje += "move $s0, $v0\n";
        mensaje += Instrucciones;
        mensaje += "move $" + RegistroFinal + ", $s0";
        return mensaje;
    }
}
