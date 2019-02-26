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


    public Farmer( String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
   
    }

    public HashMap<String, Producto> getProductosquecultiva() {
        return productosquecultiva;
    }

    public void setProductosquecultiva(HashMap<String, Producto> productosquecultiva) {
        this.productosquecultiva = productosquecultiva;
    }

  private Producto CrearProductoF(String Nombre,String Fecha,Farmer f){
      Producto p=new Producto(Nombre);
      
      FechaDePaso a=new FechaDePaso(Fecha, f);
      p.getFechas().put(Fecha, a);
      this.productosquecultiva.put(p.getNombre(),p);
      return  p;
  } 
          @Override
    public Eslabon LugarDeEnvio(Producto producto,String fecha) {
     return productosquecultiva.get(producto.getNombre()).getFechas().get(fecha).getLugardeproceso();
    }

  
  @Override
    public void EnviarProducto(Producto producto,String fecha,Eslabon m) {
   
    productosquecultiva.get(producto.getNombre()).getFechas().get(fecha).setFecha(fecha);
    productosquecultiva.get(producto.getNombre()).getFechas().get(fecha).setLugardeproceso(m);
    
    }
   

  
    
}
