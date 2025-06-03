package com.lexicalanalyzer;
import java.util.List;

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
// Instrucciones concret as
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
     * @param operador Operador (por ejemplo, +, -, *, //).
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

class IfGotoInstr extends InstruccionIntermedia {
    private String condicion;
    private String etiqueta;

    /**
     * Constructor para la instruccion ifFalse.
     *
     * @param condicion Expresion booleana.
     * @param etiqueta  Etiqueta a saltar si la condicion es falsa.
     */
    public IfGotoInstr(String condicion, String etiqueta) {
        this.condicion = condicion;
        this.etiqueta = etiqueta;
    }

    @Override
    public String toString() {
        return "if " + condicion + " goto " + etiqueta;
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

/**
 * Representa el inicio de una funcion en el codigo intermedio.
 */
class InicioFuncionInstr extends InstruccionIntermedia {
    private String nombre;

    /**
     * Constructor de la instruccion de inicio de funcion.
     * 
     * @param nombre Nombre de la funcion
     */
    public InicioFuncionInstr(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la representacion textual de la instruccion.
     * 
     * @return Una cadena con el nombre de la funcion precedida por 'funcion'
     */
    @Override
    public String toString() {
        return "funcion " + nombre + ":";
    }
}

/**
 * Representa el fin de una funcion en el codigo intermedio.
 */
class FinFuncionInstr extends InstruccionIntermedia {
    private String nombre;

    /**
     * Constructor de la instruccion de fin de funcion.
     * 
     * @param nombre Nombre de la funcion
     */
    public FinFuncionInstr(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la representacion textual de la instruccion.
     * 
     * @return Una cadena indicando el fin de la funcion
     */
    @Override
    public String toString() {
        return "fin_funcion " + nombre;
    }
}

/**
 * Representa una llamada a una funcion en el codigo intermedio.
 */
class LlamadaFuncionInstr extends InstruccionIntermedia {
    private String nombre;
    private List<String> argumentos;
    private String destino;

    /**
     * Constructor de la instruccion de llamada a funcion.
     * 
     * @param nombre     Nombre de la funcion a llamar
     * @param argumentos Lista de argumentos que se pasan a la funcion
     * @param destino    Nombre del temporal que almacenara el resultado
     */
    public LlamadaFuncionInstr(String nombre, List<String> argumentos, String destino) {
        this.nombre = nombre;
        this.argumentos = argumentos;
        this.destino = destino;
    }

    /**
     * Devuelve la representacion textual de la instruccion.
     * 
     * @return Una cadena representando la llamada a la funcion
     */
    @Override
    public String toString() {
        return destino + " = call " + nombre + "(" + String.join(", ", argumentos) + ")";
    }
}

/**
 * Representa una instruccion de retorno en una funcion.
 */
class ReturnInstr extends InstruccionIntermedia {
    private String valor;

    /**
     * Constructor de la instruccion de retorno.
     * 
     * @param valor Valor que sera retornado por la funcion
     */
    public ReturnInstr(String valor) {
        this.valor = valor;
    }

    /**
     * Devuelve la representacion textual de la instruccion.
     * 
     * @return Una cadena con el valor a retornar
     */
    @Override
    public String toString() {
        return "return " + valor;
    }
}

class InputInstr extends InstruccionIntermedia {
    private String Instr;
    private String Registro;
    private String ID;

    /**
     * Constructor de la instruccion de retorno.
     * 
     * @param valor Valor que sera retornado por la funcion
     */
    public InputInstr(String instr, String registro, String id) {
        this.Instr = instr;
        this.Registro = registro;
        this.ID = id;
    }

    /**
     * Devuelve la representacion textual de la instruccion.
     * 
     * @return Una cadena con el valor a retornar
     */
    @Override
    public String toString() {
        String temp = GeneradorTemporales.nuevoTemporal();
        return Instr + " " + Registro + "\n" + ID + " = " + Registro;
    }
}

class OutputInstr extends InstruccionIntermedia {
    private String Instr;
    private String Registro;
    private String ID;

    /**
     * Constructor de la instruccion de retorno.
     * 
     * @param valor Valor que sera retornado por la funcion
     */
    public OutputInstr(String instr, String registro, String id) {
        this.Instr = instr;
        this.Registro = registro;
        this.ID = id;
    }

    /**
     * Devuelve la representacion textual de la instruccion.
     * 
     * @return Una cadena con el valor a retornar
     */
    @Override
    public String toString() {
        return Registro + " = " + ID + "\n" + Instr + " " + Registro;
    }
}

class ParamInstr extends InstruccionIntermedia {
    private String tipo;
    private String nombre;

    public ParamInstr(String tipo, String nombre) {
        this.tipo = tipo;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "param " + tipo + " " + nombre;
    }
}

class ArrayAsign extends InstruccionIntermedia {
    private String Indice;
    private String Nombre;
    private String Registro;

    public ArrayAsign(String nombre, String indice, String registro) {
        this.Indice = indice;
        this.Nombre = nombre;
        this.Registro = registro;
    }

    @Override
    public String toString() {
        return Nombre + "[" + Indice + "] = " + Registro;
    }
}