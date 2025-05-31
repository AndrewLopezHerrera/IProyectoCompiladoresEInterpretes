package com.lexicalanalyzer;

/**
 * Clase que representa una linea en la tabla de simbolos.
 * Contiene informacion sobre una variable declarada, incluyendo tipo, nombre, ubicacion,
 * si esta inicializada, y un identificador unico.
 */
public class LineaTabla {
    private int ID;
    private String Tipo;
    private String Nombre;
    private int Columna;
    private int Fila;
    private boolean EstaInicializado;
    private static int Cantidad = 0;

    /**
     * Constructor para crear una nueva entrada en la tabla de simbolos.
     *
     * @param pTipo             Tipo de la variable (int, boolean, etc.).
     * @param pNombre           Nombre de la variable.
     * @param pColumna          Columna donde fue declarada.
     * @param pFila             Fila donde fue declarada.
     * @param pInicializacion   Indica si la variable esta inicializada.
     */
    public LineaTabla(String pTipo, String pNombre, int pColumna, int pFila, boolean pInicializacion) {
        ID = Cantidad;
        Tipo = pTipo;
        Cantidad++;
        Nombre = pNombre;
        Columna = pColumna;
        Fila = pFila;
        EstaInicializado = pInicializacion;
    }

    /**
     * Devuelve una representacion textual de la linea de la tabla.
     *
     * @return Informacion detallada de la variable.
     */
    @Override
    public String toString() {
        String mensaje = "";
        mensaje += "ID: " + ID + " | Nombre: " + Nombre + " | Tipo: " + Tipo;
        mensaje += " | Fila: " + Fila + " | Columna: " + Columna;
        mensaje += " | ¿Esta inicializado?: " + EstaInicializado;
        return mensaje;
    }

    /**
     * Obtiene el identificador unico de esta variable.
     *
     * @return ID unico.
     */
    public int getID() {
        return ID;
    }

    /**
     * Obtiene el tipo de la variable.
     *
     * @return Tipo de dato.
     */
    public String getTipo() {
        return this.Tipo;
    }

    /**
     * Obtiene el nombre de la variable.
     *
     * @return Nombre de la variable.
     */
    public String getNombre() {
        return this.Nombre;
    }

    /**
     * Obtiene la columna donde fue declarada la variable.
     *
     * @return Numero de columna.
     */
    public int getColumna() {
        return this.Columna;
    }

    /**
     * Obtiene la fila donde fue declarada la variable.
     *
     * @return Numero de fila.
     */
    public int getFila() {
        return this.Fila;
    }

    /**
     * Indica si la variable esta inicializada.
     *
     * @return true si esta inicializada, false en caso contrario.
     */
    public boolean getEstaInicializado() {
        return this.EstaInicializado;
    }

    /**
     * Cambia el estado de inicializacion de la variable.
     *
     * @param pInicializacion Nuevo valor de inicializacion.
     */
    public void setEstaInicializado(boolean pInicializacion) {
        EstaInicializado = pInicializacion;
    }
}
