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
    private HashMap<String,Producto>productosqueproduce=new HashMap<>();

    public Manufacturer(String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
        
    }
@Override
    public Eslabon EnviarProducto(String ID,String fechasalida,String FechaDeExpedicion,Eslabon m) {
   
    productosqueproduce.get(ID).getFechas().get(FechaDeExpedicion).setFecha(fechasalida);
    productosqueproduce.get(ID).getFechas().get(FechaDeExpedicion).setLugardeproceso(m);
     DistributionCenter y = (DistributionCenter) m;
     HashMap<String,Producto>A=new HashMap<>();
    
   y.getProductos().put(fechasalida,productosqueproduce.get(ID));
    m=y;
    return m;
    } @Override
    public Eslabon LugarDondeSeEnvio(String ID,String fecha) {
     return productosqueproduce.get(ID).getFechas().get(fecha).getLugardeproceso();
    }
   
     public Producto CrearProductoM(String ID,String Nombre,String Fecha,Manufacturer m,HashMap<String,Producto>materiausada){
      Producto p=new Producto(ID,Nombre);
      
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
