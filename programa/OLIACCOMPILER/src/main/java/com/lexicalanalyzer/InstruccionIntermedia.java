package com.lexicalanalyzer;

public abstract class InstruccionIntermedia {
    public abstract String toString();
}

// --------------------------
// Instrucciones concretas
// --------------------------

class DeclInstr extends InstruccionIntermedia {
    private String tipo;
    private String nombre;

    public DeclInstr(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return tipo + " " + nombre;
    }
}

class DeclAsigInstr extends InstruccionIntermedia {
    private String tipo;
    private String nombre;
    private String valor;

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

class AsignacionInstr extends InstruccionIntermedia {
    private String destino;
    private String valor;

    public AsignacionInstr(String destino, String valor) {
        this.destino = destino;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return destino + " = " + valor;
    }
}

class OperacionInstr extends InstruccionIntermedia {
    private String destino;
    private String op1;
    private String operador;
    private String op2;

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

class OperacionUnariaInstr extends InstruccionIntermedia {
    private String destino;
    private String operador;
    private String argumento;

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

class GeneradorTemporales {
    private static int tempCount = 0;

    public static String nuevoTemporal() {
        return "t" + (tempCount++);
    }

    public static void reset() {
        tempCount = 0;
    }
}


