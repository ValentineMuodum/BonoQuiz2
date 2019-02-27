/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
      FechaDePaso a;
     a = new FechaDePaso(Fecha, f,"Se creo el producto en "+f.getNombre()+" con  ID"+ID+ "el dia "+Fecha);
      p.getFechas().put(Fecha, a);
      this.productosquecultiva.put(ID,p);
      return  p;
  } 
         
  @Override
    public Eslabon EnviarProducto(String ID,String fechasalida,Eslabon m) {
   
  Manufacturer y = (Manufacturer) m;
    FechaDePaso f=new FechaDePaso(fechasalida,y,"El producto salio de la Granja "+this.getNombre()+" el dia "+fechasalida+
             "y llego a la Manufactura "+y.getNombre());
    productosquecultiva.get(ID).getFechas().put(fechasalida,f); 
    y.getProductosrecibidos().put(ID, productosquecultiva.get(ID));
     
    return m;}
    @Override
    public Eslabon LugarDondeSeEnvio(String ID,String fecha) {
     return productosquecultiva.get(ID).getFechas().get(fecha).getLugardeproceso();
    }

  
  
   

  
    
}
