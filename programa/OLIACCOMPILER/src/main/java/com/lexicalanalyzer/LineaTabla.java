package com.lexicalanalyzer;
public class LineaTabla {
    private int ID;
    private String Tipo;
    private String Nombre;
    private int Columna;
    private int Fila;
    private boolean EstaInicializado;
    private static int Cantidad = 0;
  
   
    public LineaTabla(String pTipo, String pNombre, int pColumna, int pFila,
        boolean pInicializacion){
        ID = Cantidad;
        Tipo = pTipo;
        Cantidad++;
        Nombre = pNombre;
        Columna = pColumna;
        Fila = pFila;
        EstaInicializado = pInicializacion;
    }
    
    @Override
    public String toString() {
        String mensaje = "";
        mensaje += "ID: " + ID + " | Nombre: " + Nombre + " | Tipo: " + Tipo;
        mensaje += " | Fila: " + Fila + " | Columna: " + Columna;
        mensaje += " | ¿Está inicializado?: " + EstaInicializado;
        return mensaje;
    }
  
    public int getID() {
        return ID;
    }
    
    public String getTipo() {
        return this.Tipo;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public int getColumna() {
        return this.Columna;
    }

    public int getFila() {
        return this.Fila;
    }

    public boolean getEstaInicializado() {
        return this.EstaInicializado;
    }
    
    public void setEstaInicializado(boolean pInicializacion) {
        EstaInicializado = pInicializacion;
    }
}
