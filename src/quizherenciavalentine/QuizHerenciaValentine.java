/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import com.sun.org.apache.xalan.internal.xsltc.cmdline.getopt.GetOpt;
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
        // TODO code application logic here
    Farmer Granjita=new Farmer("Granjita","Granja productora",20,80);
    Manufacturer Fabrica=new Manufacturer("Fabrica1", "Fabrica de Comida Italiana", 4, 67);
    DistributionCenter Centro=new DistributionCenter("Centro", "Distribuidora Local",45,104);
    Retail Tienda=new Retail("Tienda","Tienda de cadena" ,0, 0);
    //La feccha de expedicion funciona como una id en vez de usar un serial
    Granjita.CrearProductoF("Tomate", "26/02/2019", Granjita);
    Granjita.CrearProductoF("Trigo", "26/02/2019", Granjita);
    Granjita.EnviarProducto(Granjita.getProductosquecultiva().get("Trigo"),"26/02/2019", "27/02/2019", Fabrica);
    Granjita.EnviarProducto(Granjita.getProductosquecultiva().get("Tomate"), "26/02/2019","27/02/2019", Fabrica);
        HashMap<String,Producto>x = new HashMap<>();
        x.put(Granjita.getProductosquecultiva().get("Tomate").getNombre(),Granjita.getProductosquecultiva().get("Tomate"));
        x.put(Granjita.getProductosquecultiva().get("Trigo").getNombre(),Granjita.getProductosquecultiva().get("Trigo"));
   
        Fabrica.CrearProductoM("Pan", "28/02/2019", Fabrica, x);
        System.out.println(Fabrica.getProductosqueproduce().get("Pan").getMateriaprimarequerida().get("Trigo").getNombre());
    }
    
}
