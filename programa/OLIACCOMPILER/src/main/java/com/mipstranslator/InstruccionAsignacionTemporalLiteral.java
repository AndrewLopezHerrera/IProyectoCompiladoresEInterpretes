/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mipstranslator;

/**
 * Clase que representa una instrucción de asignación entre temporales o de un
 * literal (entero o flotante) a un temporal, generando su correspondiente
 * representación en código MIPS.
 *
 * Esta clase cubre los siguientes tipos de asignaciones:
 * - Literal entero: {@code t1 = 5}
 * - Literal flotante: {@code t2 = 3.14}
 * - Copia entre temporales: {@code t3 = t1}
 * 
 * @author males
 */
public class InstruccionAsignacionTemporalLiteral implements InstruccionMIPS {

    /** Nombre del temporal de destino */
    private final String destino;

    /** Valor de origen, puede ser literal o temporal */
    private final String fuente;

    /**
     * Constructor que interpreta la línea de código intermedio.
     *
     * @param linea línea con formato de asignación: {@code tX = valor}
     */
    public InstruccionAsignacionTemporalLiteral(String linea) {
        String[] partes = linea.split("=");
        this.destino = partes[0].trim();
        this.fuente = partes[1].trim();
    }

    /**
     * Genera el código MIPS correspondiente a la asignación literal o entre temporales.
     *
     * @return una cadena con el código MIPS generado
     */
    @Override
    public String toString() {
        StringBuilder mips = new StringBuilder();

        // Verificar si la fuente es un literal entero
        if (fuente.matches("^-?\\d+$")) {
            String reg = AnalizadorCodigoIntermedio.registrosEnteros.RegistrarRegistro(destino);
            mips.append("# Asignación literal entera\n");
            mips.append("li $").append(reg).append(", ").append(fuente).append("\n");
        }

        // Verificar si es un literal flotante
        else if (fuente.matches("^-?\\d*\\.\\d+$")) {
            String regEnt = AnalizadorCodigoIntermedio.registrosEnteros.RegistrarRegistro(destino + "_int");
            String regFloat = AnalizadorCodigoIntermedio.registrosFlotantes.RegistrarRegistro(destino);
            mips.append("# Asignación literal flotante\n");
            mips.append("li $").append(regEnt).append(", ").append(fuente).append("\n");
            mips.append("mtc1 $").append(regEnt).append(", $f").append(regFloat).append("\n");
        }

        // Verificar si es una copia de otro temporal
        else if (fuente.matches("^t\\d+$")) {
            if (AnalizadorCodigoIntermedio.registrosEnteros.VerificarExistenciaRegistro(fuente)) {
                String regSrc = AnalizadorCodigoIntermedio.registrosEnteros.ObtenerRegistroMIPSDeIntermedio(fuente);
                String regDest = AnalizadorCodigoIntermedio.registrosEnteros.RegistrarRegistro(destino);
                mips.append("# Asignación entre temporales enteros\n");
                mips.append("move $").append(regDest).append(", $").append(regSrc).append("\n");
            } else if (AnalizadorCodigoIntermedio.registrosFlotantes.VerificarExistenciaRegistro(fuente)) {
                String regSrc = AnalizadorCodigoIntermedio.registrosFlotantes.ObtenerRegistroMIPSDeIntermedio(fuente);
                String regDest = AnalizadorCodigoIntermedio.registrosFlotantes.RegistrarRegistro(destino);
                mips.append("# Asignación entre temporales flotantes\n");
                mips.append("mov.s $f").append(regDest).append(", $f").append(regSrc).append("\n");
            } else {
                mips.append("# ERROR: Fuente no registrada ").append(fuente).append("\n");
            }
        } else {
            mips.append("# Instrucción no reconocida: ").append(destino).append(" = ").append(fuente).append("\n");
        }

        return mips.toString();
    }
}
