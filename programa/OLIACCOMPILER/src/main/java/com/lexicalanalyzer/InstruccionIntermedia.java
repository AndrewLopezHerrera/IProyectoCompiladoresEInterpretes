package com.lexicalanalyzer;

/**
 * Clase abstracta base para todas las instrucciones intermedias generadas por el compilador.
 */
public abstract class InstruccionIntermedia {

    /**
     * Devuelve una representacion en texto de la instruccion intermedia.
     *
     * @return Cadena que representa la instruccion.
     */
    public abstract String toString();
}

// --------------------------
// Instrucciones concretas
// --------------------------

/**
 * Representa una instruccion de declaracion de variable.
 */
class DeclInstr extends InstruccionIntermedia {
    private String tipo;
    private String nombre;

    /**
     * Constructor para una declaracion simple.
     *
     * @param tipo   Tipo de dato de la variable.
     * @param nombre Nombre de la variable.
     */
    public DeclInstr(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return tipo + " " + nombre;
    }
}

/**
 * Representa una declaracion de variable con asignacion inicial.
 */
class DeclAsigInstr extends InstruccionIntermedia {
    private String tipo;
    private String nombre;
    private String valor;

    /**
     * Constructor para una declaracion con asignacion.
     *
     * @param tipo   Tipo de dato.
     * @param nombre Nombre de la variable.
     * @param valor  Valor asignado.
     */
    public DeclAsigInstr(String tipo, String nombre, String valor) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return tipo + " " + nombre + " = " + valor;
    }
}

/**
 * Representa una instruccion de asignacion simple.
 */
class AsignacionInstr extends InstruccionIntermedia {
    private String destino;
    private String valor;

    /**
     * Constructor para una asignacion.
     *
     * @param destino Variable destino.
     * @param valor   Valor a asignar.
     */
    public AsignacionInstr(String destino, String valor) {
        this.destino = destino;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return destino + " = " + valor;
    }
}

/**
 * Representa una operacion binaria con dos operandos.
 */
class OperacionInstr extends InstruccionIntermedia {
    private String destino;
    private String op1;
    private String operador;
    private String op2;

    /**
     * Constructor para una operacion binaria.
     *
     * @param destino  Variable donde se almacena el resultado.
     * @param op1      Primer operando.
     * @param operador Operador (por ejemplo, +, -, *, /).
     * @param op2      Segundo operando.
     */
    public OperacionInstr(String destino, String op1, String operador, String op2) {
        this.destino = destino;
        this.op1 = op1;
        this.operador = operador;
        this.op2 = op2;
    }

    @Override
    public String toString() {
        return destino + " = " + op1 + " " + operador + " " + op2;
    }
}

/**
 * Representa una operacion unaria como incremento o negacion.
 */
class OperacionUnariaInstr extends InstruccionIntermedia {
    private String destino;
    private String operador;
    private String argumento;

    /**
     * Constructor para una operacion unaria.
     *
     * @param destino   Variable donde se almacena el resultado.
     * @param operador  Operador unario (por ejemplo, -, !).
     * @param argumento Operando de la operacion.
     */
    public OperacionUnariaInstr(String destino, String operador, String argumento) {
        this.destino = destino;
        this.operador = operador;
        this.argumento = argumento;
    }

    @Override
    public String toString() {
        return destino + " = " + operador + argumento;
    }
}

/**
 * Generador de nombres unicos para temporales.
 */
class GeneradorTemporales {
    private static int tempCount = 0;

    /**
     * Devuelve un nombre nuevo para un temporal.
     *
     * @return Nombre de temporal (por ejemplo, t0, t1, ...).
     */
    public static String nuevoTemporal() {
        return "t" + (tempCount++);
    }

    /**
     * Reinicia el contador de temporales.
     */
    public static void reset() {
        tempCount = 0;
    }
}

/**
 * Representa una instruccion condicional de salto si la condicion es falsa.
 * Sintaxis: ifFalse cond goto etiqueta
 */
class IfFalseInstr extends InstruccionIntermedia {
    private String condicion;
    private String etiqueta;

    /**
     * Constructor para la instruccion ifFalse.
     *
     * @param condicion Expresion booleana.
     * @param etiqueta  Etiqueta a saltar si la condicion es falsa.
     */
    public IfFalseInstr(String condicion, String etiqueta) {
        this.condicion = condicion;
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "ifFalse " + condicion + " goto " + etiqueta;
    }
}

/**
 * Representa una instruccion de salto incondicional.
 * Sintaxis: goto etiqueta
 */
class GotoInstr extends InstruccionIntermedia {
    private String etiqueta;

    /**
     * Constructor para la instruccion goto.
     *
     * @param etiqueta Etiqueta destino del salto.
     */
    public GotoInstr(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "goto " + etiqueta;
    }
}

/**
 * Representa una instruccion que define una etiqueta en el codigo.
 * Sintaxis: etiqueta:
 */
class EtiquetaInstr extends InstruccionIntermedia {
    private String etiqueta;

    /**
     * Constructor para una etiqueta.
     *
     * @param etiqueta Nombre de la etiqueta.
     */
    public EtiquetaInstr(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return etiqueta + ":";
    }
}
