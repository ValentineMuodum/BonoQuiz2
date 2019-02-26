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
public class QuizHerenciaValentine {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // la fecha de expedicion para los productos que fueron enviados sera el momento en que el producto llego, en estos casos 
        //coincide con la fecha de salida del producto
    Farmer Granjita=new Farmer("Granjita","Granja productora",20,80);
    Manufacturer Fabrica=new Manufacturer("Fabrica1", "Fabrica de Comida Italiana", 4, 67);
    DistributionCenter centro=new DistributionCenter("Centro","Centro de distribucion",46, 43);
    Retail Tienda=new Retail("Tiendita", "Supermercado", 54,123);
    Granjita.CrearProductoF("Tomate","26/02/2019",Granjita,"123456");
    Granjita.CrearProductoF("Trigo","26/02/2019",Granjita,"1234567");
    System.out.println(Granjita.getProductosquecultiva().get("1234567").getFechas().get("26/02/2019").getLugardeproceso().getNombre());
    Granjita.EnviarProducto("123456", "29/02/2019",Fabrica);
    Granjita.EnviarProducto("1234567", "29/02/2019",  Fabrica);
    System.out.println(Granjita.LugarDondeSeEnvio("123456", "29/02/2019").getNombre());
    System.out.println(Fabrica.getProductosrecibidos().get("123456").getNombre());
    Fabrica.CrearProductoM("98765", "Pizza", "2/03/2019", Fabrica, Fabrica.getProductosrecibidos());
        
    }
    
}
