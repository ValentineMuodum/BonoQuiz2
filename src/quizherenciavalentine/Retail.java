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

    public Retail( String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
      
    }
private Producto CrearProductoR(String Nombre,String Fecha,double precio,Retail r){
      Producto p=new Producto(Nombre,precio);
      FechaDePaso a=new FechaDePaso(Fecha, r);
      p.getFechas().put(Fecha, a);
      this.productos.put(p.getNombre(),p);
      return  p;
      
  } 
    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Producto> productos) {
        this.productos = productos;
    }
@Override
    public Eslabon LugarDeEnvio(Producto producto,String fecha) {
     return productos.get(producto.getNombre()).getFechas().get(fecha).getLugardeproceso();
    }

  
  @Override
    public void EnviarProducto(Producto producto,String fecha,Eslabon m) {
    productos.get(producto.getNombre()).getFechas().get(fecha).setFecha(fecha);
    productos.get(producto.getNombre()).getFechas().get(fecha).setLugardeproceso(m);
    
    }
}
