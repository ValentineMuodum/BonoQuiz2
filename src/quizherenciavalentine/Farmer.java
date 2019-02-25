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
public class Farmer extends Eslabon{
    private HashMap<String,Producto>productosquecultiva;

    @Override
    public Eslabon LugarDeEnvio(Producto producto) {
        
        return this.productosquecultiva.get(producto.getNombre()).getFechas();
    }

  
    @Override
    public void EnviarProducto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Farmer(HashMap<String, Producto> productosquecultiva, String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
        this.productosquecultiva = productosquecultiva;
    }

    public HashMap<String, Producto> getProductosquecultiva() {
        return productosquecultiva;
    }

    public void setProductosquecultiva(HashMap<String, Producto> productosquecultiva) {
        this.productosquecultiva = productosquecultiva;
    }
    
}
