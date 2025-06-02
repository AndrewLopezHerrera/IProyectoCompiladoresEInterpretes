package com.lexicalanalyzer;

public class EtiquetaEstructura {
    private String EtiquetaInicio;
    private String EtiquetaIntermedio;
    private String EtiquetaFinal;
    public EtiquetaEstructura(String pInicio, String pIntermedio, String pFinal){
        EtiquetaInicio = pInicio;
        EtiquetaIntermedio = pIntermedio;
        EtiquetaFinal = pFinal;
    }

    public String getEtiquetaInicio() {
        return EtiquetaInicio;
    }

    public String getEtiquetaIntermedio() {
        return EtiquetaIntermedio;
    }

    public String getEtiquetaFinal() {
        return EtiquetaFinal;
    }
}
