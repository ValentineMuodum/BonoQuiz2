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
public class Manufacturer extends Eslabon{
    private HashMap<String,Producto>productosqueproduce;

    public Manufacturer(HashMap<String, Producto> productosqueproduce, String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
        this.productosqueproduce = productosqueproduce;
    }

    public HashMap<String, Producto> getProductosqueproduce() {
        return productosqueproduce;
    }

    public void setProductosqueproduce(HashMap<String, Producto> productosqueproduce) {
        this.productosqueproduce = productosqueproduce;
    }
   
}
