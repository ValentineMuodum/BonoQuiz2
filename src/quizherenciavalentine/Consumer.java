/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import java.util.HashMap;

/**
 *
 * @author Valentine Chimezie
 */
public class Consumer {
    private String Nombre;
    private HashMap<String,Producto>productosaadquiridos=new HashMap<>();
    public Consumer(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public HashMap<String, Producto> getProductosaadquiridos() {
        return productosaadquiridos;
    }

    public void setProductosaadquiridos(HashMap<String, Producto> productosaadquiridos) {
        this.productosaadquiridos = productosaadquiridos;
    }

 public void AdquirirProducto(Retail m,String ID,String Fecha){
     FechaDePaso f=new FechaDePaso(Fecha, m, " Fue adquirido por el cliente "+this.Nombre+" el dia "+Fecha+" en la tienda "+m.getNombre());
     m.getProductos().get(ID).getFechas().put(Fecha, f);
     productosaadquiridos.put(ID, m.getProductos().get(ID));
      
 }
}
