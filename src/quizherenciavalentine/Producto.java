package quizherenciavalentine;


import java.util.HashMap;

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
    private HashMap<String,Producto>materiaprimarequerida;
    private HashMap<String,FechaDePaso> Fechas;

    public Producto(String nombre, double precio, HashMap<String, Producto> materiaprimarequerida, HashMap<String, FechaDePaso> Fechas) {
        this.nombre = nombre;
        this.precio = precio;
        this.materiaprimarequerida = materiaprimarequerida;
        this.Fechas = Fechas;
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
private HashMap<String,FechaDePaso> Trazabilidad(){
    //Aqui imprime en pantalla la ruta del producto basandose en el atributo de fechas que guarda las informaciones
    
          
    return this.Fechas;
}
}
