/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import java.util.HashMap;

/**
 *
 * @author ancardenas
 */
public class Retail extends Eslabon{
    private HashMap<String,Producto>productos;

    public Retail(HashMap<String, Producto> productos, String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
        this.productos = productos;
    }

    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Producto> productos) {
        this.productos = productos;
    }

}
