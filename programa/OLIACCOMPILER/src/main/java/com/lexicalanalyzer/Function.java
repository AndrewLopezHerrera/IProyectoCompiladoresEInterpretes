package com.lexicalanalyzer;

public class Function extends LineaTabla{
    private String Arguments;
    
    public Function(String pTipo, String pNombre, int pColumna, int pFila,
        boolean pInicializacion){
        super(pTipo, pNombre, pColumna, pFila, pInicializacion);
        Arguments = "";
    }
    
    @Override
    public String toString() {
        String mensaje = super.toString();
        mensaje += " | Argumentos: " + Arguments;
        return mensaje;
    }
    
    public void setArguments(String pArgs){
        Arguments = pArgs;
    }
    
    public String getArguments(){
        return Arguments;
    }
}
