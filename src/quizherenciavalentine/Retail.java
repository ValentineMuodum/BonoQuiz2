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
    private HashMap<String,Producto>productos=new HashMap<>();
    private HashMap<String,Producto>productosrecibidos=new HashMap<>();
    
    public Retail( String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
      
    }
public Producto CrearProductoR(String ID,String Nombre,String Fecha,double precio,Retail r){
      Producto p=new Producto(Nombre,precio,ID);
      FechaDePaso a=new FechaDePaso(Fecha, r);
      p.getFechas().put(Fecha, a);
      this.productos.put(ID,p);
      return  p;
      
  } 

    public HashMap<String, Producto> getProductosrecibidos() {
        return productosrecibidos;
    }

    public void setProductosrecibidos(HashMap<String, Producto> productosrecibidos) {
        this.productosrecibidos = productosrecibidos;
    }
    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Producto> productos) {
        this.productos = productos;
    }

    //Para estos dos ultimos metodos supuse que una tienda le envia a otra tienda para no perder la
    //caracteristica abstracta de la clase Eslabon
    @Override
    public Eslabon EnviarProducto(String ID,String fechasalida,Eslabon m) {
   Retail y = (Retail) m;
    FechaDePaso f=new FechaDePaso(fechasalida,y);
    productos.get(ID).getFechas().put(fechasalida,f); 
   
    
     HashMap<String,Producto>A=new HashMap<>();
    
   y.getProductosrecibidos().put(ID,y.CrearProductoR(ID,productos.get(ID).getNombre(),fechasalida,productos.get(ID).getPrecio(),y));
    m=y;
    return m;
    } 
 @Override
    public Eslabon LugarDondeSeEnvio(String ID,String fecha) {
     return productos.get(ID).getFechas().get(fecha).getLugardeproceso();
    }
   
}
