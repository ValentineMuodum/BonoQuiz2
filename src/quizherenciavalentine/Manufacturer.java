/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author ancardenas
 */
public class Manufacturer extends Eslabon{
    private HashMap<String,Producto>productosqueproduce=new HashMap<>();
    private HashMap<String,Producto>productosrecibidos=new HashMap<>();
    public Manufacturer(String nombre, String descripcion, double latitud, double longitud) {
        super(nombre, descripcion, latitud, longitud);
        
    }
@Override
    public Eslabon EnviarProducto(String ID,String fechasalida,Eslabon m) {
   
  DistributionCenter y = (DistributionCenter) m;
    FechaDePaso f=new FechaDePaso(fechasalida,y,"Se envio el producto "+productosqueproduce.get(ID).getNombre()+" desde la manufactura "
           +this.getNombre()+ "al centro de distribucion "+y.getNombre());
    productosqueproduce.get(ID).getFechas().put(fechasalida,f); 
     
     
    /*No es necesaria esta linea
   y.getProductosrecibidos().put(ID,y.CrearProductoDC(ID,productosqueproduce.get(ID).getNombre(),fechasalida,y));
   */y.getProductosrecibidos().put(ID,productosqueproduce.get(ID));
   m=y;
    return m;
    } 
 @Override
    public Eslabon LugarDondeSeEnvio(String ID,String fecha) {
     return productosqueproduce.get(ID).getFechas().get(fecha).getLugardeproceso();
    }
   
     public Producto CrearProductoM(String ID,String Nombre,String Fecha,Manufacturer m,HashMap<String,Producto>materiausada){
      Producto p=new Producto(Nombre,ID);
      String desc="";
        for(Producto value:materiausada.values()){
         
            desc=desc+value.getNombre()+",";
                 }
        /**/
        FechaDePaso a=new FechaDePaso(Fecha, m,"Se creo el producto "+Nombre+" con identificador "+ID+ " el dia "+Fecha+" con los elementos "+desc);
        materiausada.entrySet().forEach((entry) -> {
            FechaDePaso r=new FechaDePaso(Fecha, this, "Fue usado para crear "+p.getNombre()+" con ID "+ID+" el dia "+Fecha+" en la manufactura "+this.getNombre());
            String key = entry.getKey();
            Producto value;
            value = entry.getValue();
            value.getFechas().put(Fecha, r);
           
        });
        p.setMateriaprimarequerida(materiausada);
        p.getFechas().put(Fecha, a);
      
      this.productosqueproduce.put(ID,p);
      return  p;
      
  } 

    public HashMap<String, Producto> getProductosrecibidos() {
        return productosrecibidos;
    }

    public void setProductosrecibidos(HashMap<String, Producto> productosrecibidos) {
        this.productosrecibidos = productosrecibidos;
    }
    public HashMap<String, Producto> getProductosqueproduce() {
        return productosqueproduce;
    }

    public void setProductosqueproduce(HashMap<String, Producto> productosqueproduce) {
        this.productosqueproduce = productosqueproduce;
    }
   
}
