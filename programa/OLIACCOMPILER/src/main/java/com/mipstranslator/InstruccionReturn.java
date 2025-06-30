/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 *
 * @author males
 */

public class InstruccionReturn implements InstruccionMIPS {
    private final String valor;

    public InstruccionReturn(String linea) {
        this.valor = linea.trim().substring(7).trim(); // Quita "return "
    }

    @Override
    public String toString() {
        StringBuilder mips = new StringBuilder();

        AdministradorRegistrosEnteros registros = AnalizadorCodigoIntermedio.registrosEnteros;

        // Verificar si el valor de retorno ya tiene un registro MIPS
        String registro;
        if (registros.VerificarExistenciaRegistro(valor)) {
            registro = registros.ObtenerRegistroMIPSDeIntermedio(valor);
        } else {
            // Registrar uno nuevo si no existe
            registro = registros.RegistrarRegistro(valor);
            mips.append("# [WARN] Registro para ").append(valor).append(" fue asignado automáticamente a $").append(registro).append("\n");
        }

        // Generar el código MIPS
        mips.append("# Return valor\n");
        mips.append("move $v0, $").append(registro).append("\n");

        return mips.toString();
    }
}
