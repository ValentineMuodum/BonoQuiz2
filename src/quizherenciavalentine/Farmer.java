/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.HashMap;

/**
 *
 * @author ancardenas
 */
public class Farmer extends Eslabon{
   
 private HashMap<String,Producto>productosquecultiva=new HashMap<>();

    public Farmer( String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
    this.productosquecultiva=new HashMap<>();
    }

    public HashMap<String, Producto> getProductosquecultiva() {
        return productosquecultiva;
    }

    public void setProductosquecultiva(HashMap<String, Producto> productosquecultiva) {
        this.productosquecultiva = productosquecultiva;
    }

  public Producto CrearProductoF(String Nombre,String Fecha,Farmer f,String ID){
      Producto p=new Producto(Nombre,ID);
      FechaDePaso a=new FechaDePaso(Fecha, f);
      p.getFechas().put(Fecha, a);
      this.productosquecultiva.put(ID,p);
      return  p;
  } 
         
  @Override
    public Eslabon EnviarProducto(String ID,String fechasalida,Eslabon m) {
   
  Manufacturer y = (Manufacturer) m;
    FechaDePaso f=new FechaDePaso(fechasalida,y);
    productosquecultiva.get(ID).getFechas().put(fechasalida,f); 
     HashMap<String,Producto>A=new HashMap<>();
    
   y.getProductosrecibidos().put(ID,y.CrearProductoM(ID,productosquecultiva.get(ID).getNombre(),fechasalida,y,A));
    
   m=y;
    return m;
    } @Override
    public Eslabon LugarDondeSeEnvio(String ID,String fecha) {
     return productosquecultiva.get(ID).getFechas().get(fecha).getLugardeproceso();
    }

  
  
   

  
    
}
