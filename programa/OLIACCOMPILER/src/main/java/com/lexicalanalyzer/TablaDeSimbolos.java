package com.lexicalanalyzer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public class TablaDeSimbolos {
    private TablaDeSimbolos Padre;
    private Map<String, LineaTabla> Variables;
    private List<TablaDeSimbolos> Hijos;
    private String Nombre;
  
    public TablaDeSimbolos(TablaDeSimbolos pPadre, String pNombreTabla){
        Nombre = pNombreTabla;
        Padre = pPadre;
        Variables = new HashMap<>();
        Hijos = new ArrayList<>();
    }
    
    public boolean AgregarDato(LineaTabla pDato) {
        if(AgregarDatoAux(pDato.getNombre())){
            Variables.put(pDato.getNombre(), pDato);
            return true;
        }
        return false;
    }
    
    public void AgregarHijo(TablaDeSimbolos pHijo){
        Hijos.add(pHijo);
    }
    
    protected boolean AgregarDatoAux(String pDato) {
        if(Variables.containsKey(pDato))
            return false;
        if(Padre == null){
            return true;
        }
        return Padre.AgregarDatoAux(pDato);
    }
    
    public LineaTabla BuscarDato(String pNombre){
        if(Variables.containsKey(pNombre))
            return Variables.get(pNombre);
        if(Padre == null)
            return null;
        return Padre.BuscarDato(pNombre);
    }
    
    public boolean setInicializacionDato(String pNombre, boolean pInicializacion) {
        if(Variables.containsKey(pNombre)){
            LineaTabla linea = Variables.get(pNombre);
            linea.setEstaInicializado(pInicializacion);
            return true;
        }
        if(Padre == null)
            return false;
        return Padre.setInicializacionDato(pNombre, pInicializacion);
    }
    
    @Override
    public String toString(){
        String mensaje = "\nNombre de tabla: " + Nombre;
        Collection<LineaTabla> lineas = Variables.values();
        for (LineaTabla linea : lineas)
            mensaje += "\n" + linea.toString();
        for (TablaDeSimbolos hijo : Hijos){
            String mensajeHijo = hijo.toString();
            mensaje += "\t" + mensajeHijo.replace("\n", "\n\t");
        }
        return mensaje;
    }
    
    public TablaDeSimbolos getPadre(){
        return Padre;
    }
    
    public List<TablaDeSimbolos> getHijos(){
        return Hijos;
    }
    
    public String getNombre(){
        return Nombre;
    }
    
    public void setNombre(String pNombre){
        Nombre = pNombre;
    }
}
