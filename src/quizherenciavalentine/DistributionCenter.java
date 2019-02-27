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


   private HashMap<String,Producto>productosrecibidos=new HashMap<>();
         
    public DistributionCenter(String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
    }

 

    public HashMap<String, Producto> getProductosrecibidos() {
        return productosrecibidos;
    }

    public void setProductosrecibidos(HashMap<String, Producto> productosrecibidos) {
        this.productosrecibidos = productosrecibidos;
    }

   /*No es necesario este metodo ya que esta clase solo envia lo que recibe
 public Producto CrearProductoDC(String ID,String Nombre,String Fecha,DistributionCenter DC){
      Producto p=new Producto(Nombre,ID);
      
      FechaDePaso a=new FechaDePaso(Fecha, DC);
      
      p.getFechas().put(Fecha, a);
      this.productosrecibidos.put(ID,p);
      return  p;
      
  } */
    
 @Override
    public Eslabon EnviarProducto(String ID,String fechasalida,Eslabon m) {
    Retail y = (Retail) m;
    FechaDePaso f=new FechaDePaso(fechasalida,y,"Se envio el producto al establecimiento "+y.getNombre()+" El dia "+fechasalida);
    productosrecibidos.get(ID).getFechas().put(fechasalida,f); 
     
    
   y.getProductosrecibidos().put(ID,productosrecibidos.get(ID));
   
   m=y;
    return m;
    } 
 @Override
    public Eslabon LugarDondeSeEnvio(String ID,String fecha) {
     return productosrecibidos.get(ID).getFechas().get(fecha).getLugardeproceso();
    }
}