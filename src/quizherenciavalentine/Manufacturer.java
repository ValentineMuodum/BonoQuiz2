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

    public Manufacturer(String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
        
    }
@Override
    public Eslabon LugarDeEnvio(Producto producto,String fecha) {
     return productosqueproduce.get(producto.getNombre()).getFechas().get(fecha).getLugardeproceso();
    }

  
  @Override
    public void EnviarProducto(Producto producto,String fecha,Eslabon m) {
    productosqueproduce.get(producto.getNombre()).getFechas().get(fecha).setFecha(fecha);
    productosqueproduce.get(producto.getNombre()).getFechas().get(fecha).setLugardeproceso(m);
     }
     private Producto CrearProductoM(String Nombre,String Fecha,Manufacturer m,HashMap<String,Producto>materiausada){
      Producto p=new Producto(Nombre);
      
      FechaDePaso a=new FechaDePaso(Fecha, m);
      p.setMateriaprimarequerida(materiausada);
      p.getFechas().put(Fecha, a);
      this.productosqueproduce.put(p.getNombre(),p);
      return  p;
      
  } 
    public HashMap<String, Producto> getProductosqueproduce() {
        return productosqueproduce;
    }

    public void setProductosqueproduce(HashMap<String, Producto> productosqueproduce) {
        this.productosqueproduce = productosqueproduce;
    }
   
}
