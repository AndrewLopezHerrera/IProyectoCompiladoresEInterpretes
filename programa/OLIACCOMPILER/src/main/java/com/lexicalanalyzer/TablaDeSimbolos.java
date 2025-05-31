package com.lexicalanalyzer;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

/**
 * Representa una tabla de símbolos para un bloque de código (como funciones,
 * condicionales, ciclos, etc.). Gestiona la información sobre variables declaradas,
 * su inicialización, ámbito jerárquico (padre-hijo), y las instrucciones intermedias
 * generadas dentro del bloque.
 */
public class TablaDeSimbolos {

    /** Referencia a la tabla de símbolos padre (ámbito superior). */
    private TablaDeSimbolos Padre;

    /** Variables declaradas en el ámbito actual. */
    private Map<String, LineaTabla> Variables;

    /** Tablas hijas anidadas (bloques internos). */
    private List<TablaDeSimbolos> Hijos;

    /** Instrucciones intermedias generadas dentro de este bloque. */
    private List<InstruccionIntermedia> instrucciones = new ArrayList<>();

    /** Nombre identificador de la tabla de símbolos. */
    private String Nombre;

    /**
     * Crea una nueva tabla de símbolos.
     *
     * @param pPadre       Tabla de símbolos del ámbito superior (puede ser null).
     * @param pNombreTabla Nombre identificador de esta tabla.
     */
    public TablaDeSimbolos(TablaDeSimbolos pPadre, String pNombreTabla) {
        Nombre = pNombreTabla;
        Padre = pPadre;
        Variables = new HashMap<>();
        Hijos = new ArrayList<>();
    }

    /**
     * Intenta agregar un identificador a la tabla. Rechaza duplicados en el mismo
     * o en un ámbito superior.
     *
     * @param pDato Objeto que representa el identificador.
     * @return {@code true} si se agregó con éxito, {@code false} si ya existe.
     */
    public boolean AgregarDato(LineaTabla pDato) {
        if (AgregarDatoAux(pDato.getNombre())) {
            Variables.put(pDato.getNombre(), pDato);
            return true;
        }
        return false;
    }

    /**
     * Agrega una tabla hija (subámbito).
     *
     * @param pHijo Tabla de símbolos hija.
     */
    public void AgregarHijo(TablaDeSimbolos pHijo) {
        Hijos.add(pHijo);
    }

    /**
     * Verifica recursivamente si ya existe un identificador en este o en un ámbito superior.
     *
     * @param pDato Nombre del identificador.
     * @return {@code true} si no existe aún, {@code false} si está repetido.
     */
    protected boolean AgregarDatoAux(String pDato) {
        if (Variables.containsKey(pDato))
            return false;
        if (Padre == null)
            return true;
        return Padre.AgregarDatoAux(pDato);
    }

    /**
     * Busca un identificador en el ámbito actual o superior.
     *
     * @param pNombre Nombre del identificador.
     * @return Objeto {@code LineaTabla} si se encuentra; de lo contrario {@code null}.
     */
    public LineaTabla BuscarDato(String pNombre) {
        if (Variables.containsKey(pNombre))
            return Variables.get(pNombre);
        if (Padre == null)
            return null;
        return Padre.BuscarDato(pNombre);
    }

    /**
     * Marca un identificador como inicializado en el ámbito correspondiente.
     *
     * @param pNombre           Nombre del identificador.
     * @param pInicializacion  {@code true} si fue inicializado.
     * @return {@code true} si se actualizó correctamente, {@code false} si no existe.
     */
    public boolean setInicializacionDato(String pNombre, boolean pInicializacion) {
        if (Variables.containsKey(pNombre)) {
            LineaTabla linea = Variables.get(pNombre);
            linea.setEstaInicializado(pInicializacion);
            return true;
        }
        if (Padre == null)
            return false;
        return Padre.setInicializacionDato(pNombre, pInicializacion);
    }

    /**
     * Retorna una representación en texto de esta tabla de símbolos, incluyendo sus hijos.
     *
     * @return String con el contenido de la tabla y subtablas.
     */
    @Override
    public String toString() {
        String mensaje = "\nNombre de tabla: " + Nombre;
        Collection<LineaTabla> lineas = Variables.values();
        for (LineaTabla linea : lineas)
            mensaje += "\n" + linea.toString();
        for (TablaDeSimbolos hijo : Hijos) {
            String mensajeHijo = hijo.toString();
            mensaje += "\t" + mensajeHijo.replace("\n", "\n\t");
        }
        return mensaje;
    }

    /**
     * Obtiene la tabla de símbolos padre.
     *
     * @return Tabla de símbolos del ámbito superior.
     */
    public TablaDeSimbolos getPadre() {
        return Padre;
    }

    /**
     * Devuelve las tablas hijas (subámbitos).
     *
     * @return Lista de tablas hijas.
     */
    public List<TablaDeSimbolos> getHijos() {
        return Hijos;
    }

    /**
     * Obtiene el nombre de la tabla de símbolos.
     *
     * @return Nombre asignado.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Asigna un nuevo nombre a esta tabla.
     *
     * @param pNombre Nuevo nombre.
     */
    public void setNombre(String pNombre) {
        Nombre = pNombre;
    }

    /**
     * Agrega una instrucción intermedia al bloque actual.
     *
     * @param instr Instrucción a registrar.
     */
    public void agregarInstruccion(InstruccionIntermedia instr) {
        instrucciones.add(instr);
    }

    /**
     * Obtiene todas las instrucciones intermedias del bloque.
     *
     * @return Lista de instrucciones intermedias.
     */
    public List<InstruccionIntermedia> getInstrucciones() {
        return instrucciones;
    }
}
