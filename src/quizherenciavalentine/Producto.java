package quizherenciavalentine;


import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ancardenas
 */
public class Producto {
    private String nombre;
    private double precio;
    private HashMap<String,Producto>materiaprimarequerida=new HashMap<>();
    private HashMap<String,FechaDePaso> Fechas=new HashMap<>();
    private String ID;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Producto(String nombre, double precio, String ID) {
        this.nombre = nombre;
        this.precio = precio;
        this.ID = ID;
    }

    public Producto(String nombre, String ID) {
        this.nombre = nombre;
        this.ID = ID;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public HashMap<String, Producto> getMateriaprimarequerida() {
        return materiaprimarequerida;
    }

    public void setMateriaprimarequerida(HashMap<String, Producto> materiaprimarequerida) {
        this.materiaprimarequerida = materiaprimarequerida;
    }

    public HashMap<String, FechaDePaso> getFechas() {
        return Fechas;
    }

    public void setFechas(HashMap<String, FechaDePaso> Trazabilidad) {
        this.Fechas = Trazabilidad;
    }
public HashMap<String,FechaDePaso> Trazabilidad(){
    //Aqui imprime en pantalla la ruta del producto basandose en el atributo de fechas que guarda las informaciones
    
    return this.Fechas;
}
}
