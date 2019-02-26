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
public class DistributionCenter extends Eslabon {

    HashMap<String,Producto>Productos=new HashMap<>();
         
    public DistributionCenter(String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
    }

    public HashMap<String, Producto> getProductos() {
        return Productos;
    }

    public void setProductos(HashMap<String, Producto> Productos) {
        this.Productos = Productos;
    }

    
   @Override
    public Eslabon LugarDeEnvio(Producto producto,String fecha) {
     return Productos.get(producto.getNombre()).getFechas().get(fecha).getLugardeproceso();
    }

  
  @Override
   public void EnviarProducto(Producto producto,String FechaDeExpedicion,String fechasalida,Eslabon m) {
   
    Productos.get(producto.getNombre()).getFechas().get(FechaDeExpedicion).setFecha(fechasalida);
    Productos.get(producto.getNombre()).getFechas().get(fechasalida).setLugardeproceso(m);
    
    }
   
}
