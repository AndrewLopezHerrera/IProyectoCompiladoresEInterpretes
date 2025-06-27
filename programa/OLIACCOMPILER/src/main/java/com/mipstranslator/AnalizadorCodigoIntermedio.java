package com.mipstranslator;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorCodigoIntermedio {

    private List<InstruccionMIPS> instrucciones;

    public AnalizadorCodigoIntermedio(List<String> lineas) {
        instrucciones = new ArrayList<>();

        for (String linea : lineas) {
            linea = linea.trim();
            if (linea.isEmpty() || linea.startsWith("#")) {
                continue; // Ignora líneas vacías o comentarios
            }

            // Detectar instrucciones tipo CALL
            if (linea.contains("= call ")) {
                instrucciones.add(new InstruccionCall(linea));
                continue;
            }

            // Otras detecciones de instrucciones específicas van aquí...

            // Si no se reconoce, puedes agregar una clase tipo InstruccionNoSoportada o simplemente ignorarla.
            instrucciones.add(new InstruccionNoSoportada(linea));
        }
    }

    public String generarCodigoMIPS() {
        StringBuilder mips = new StringBuilder();

        for (InstruccionMIPS instruccion : instrucciones) {
            mips.append(instruccion.toString()).append("\n");
        }

        return mips.toString();
    }
}
