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
 public Producto CrearProductoDC(String ID,String Nombre,String Fecha,DistributionCenter DC){
      Producto p=new Producto(Nombre,ID);
      
      FechaDePaso a=new FechaDePaso(Fecha, DC);
      
      p.getFechas().put(Fecha, a);
      this.Productos.put(ID,p);
      return  p;
      
  } 
    
 @Override
    public Eslabon EnviarProducto(String ID,String fechasalida,String FechaDeExpedicion,Eslabon m) {
   
    Productos.get(ID).getFechas().get(FechaDeExpedicion).setFecha(fechasalida);
    Productos.get(ID).getFechas().get(FechaDeExpedicion).setLugardeproceso(m);
     Retail y = (Retail) m;
     HashMap<String,Producto>A=new HashMap<>();
    
   y.getProductos().put(ID,y.CrearProductoR(ID,Productos.get(ID).getNombre(),fechasalida,0,y));
    m=y;
    return m;
    } 
 @Override
    public Eslabon LugarDondeSeEnvio(String ID,String fecha) {
     return Productos.get(ID).getFechas().get(fecha).getLugardeproceso();
    }
}