package com.mipstranslator;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorCodigoIntermedio {

    private List<String> Data;
    private List<TablaSimbolos> Tablas;

    public AnalizadorCodigoIntermedio(List<String> Data, List<TablaSimbolos> Tablas) {
        this.Data = Data;
        this.Tablas = Tablas;
    }

    public String generarCodigoMIPS() {
        StringBuilder mips = new StringBuilder();
        mips.append(".data").append("\n");
        for (String data : Data) {
            mips.append(data).append("\n");
        }
        mips.append(".text").append("\n");
        for (TablaSimbolos tabla : Tablas) {
            mips.append(tabla.toString()).append("\n");
        }
        return mips.toString();
    }
}
