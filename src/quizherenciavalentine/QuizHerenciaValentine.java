/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;


import java.io.File;
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
        /* la fecha de expedicion para los productos que fueron enviados sera el momento en que el producto llego, en estos casos 
        coincide con la fecha de salida del producto en el anterior eslabon
        Solo se podran enviar productos que hayan sido creados en el eslabon siguiendo la logica del ejercicio
            Los objetos son creados de los eslabones que tienen esta funcion (Farmer y Manufacturer
         La trazabilidad esta como un atributo de cada objeto llamado Fechas donde se guarda la informacion
         de todos los procesos que ocurrieron con el producto ya sea, fabricacion, envio,etc el metodo trazabilidad solo imprime en pantalla y devuelve un hashamap 
        de fechas. Cabe decir que si se puede acceder por medio de la fecha a la descripcion del proceso,
        el eslabon y la fecha, de manera que si el cliente quiere conocer la trazabilidad solo debera acceder a su arreglo de productos
        Cada clase llevara un registro de sus objetos por lo que no se eliminaran objetos cuando se envien
         El metodo de guardar guardara como primer elemento la id del objeto, luego su nombre y luego todos los 
        procesos que atraveso, cada objeto estara separado por un espacio
        Cada producto tiene un HashMap con los productos que se usaron para su creacion 
        Para evitar conflictos de HashMap se debe especificar la fecha y hora 
        La informacion de fechas no es mostrada secuencialmente por el metodo usado para listar
        Para ver la informacion en el archivo se debe abrir el archivo "Guardar.txt" desde el apartado de archivos y no desde 
        el paquete de fuentes
        
        Cambios de ultimo minuto
        En el diagrama de clases gestor de archivos tiene una relacin de dependencia por metodo con la clase producto;
        en esta version se hace iguala el eslabon a la funcion de enviar producto respectiva
        por logica de codigo, en la version anterior funciona sin esto pero de esta manera
        es la forma correcta de hacerlo
        */
     File txt=new File("Guardar.txt");
     GestordeGuardado gestionador=new GestordeGuardado(txt);
    Farmer Granjita=new Farmer("Granjita","Granja productora",20,80);
    Manufacturer Fabrica=new Manufacturer("Fabrica1", "Fabrica de Comida Italiana", 4, 67);
    DistributionCenter centro=new DistributionCenter("Centro","Centro de distribucion",46, 43);
    Retail Tienda=new Retail("Tiendita", "Supermercado", 54,123);
    Granjita.CrearProductoF("Tomate","26/02/2019/6:30",Granjita,"123456");
    Granjita.CrearProductoF("Trigo","26/02/2019/6:40",Granjita,"1234567");
    System.out.println(Granjita.getProductosquecultiva().get("1234567").getFechas().get("26/02/2019/6:40").getLugardeproceso().getNombre());
    Fabrica=(Manufacturer) Granjita.EnviarProducto("123456", "29/02/2019",Fabrica);
    Fabrica=(Manufacturer)Granjita.EnviarProducto("1234567", "29/02/2019",  Fabrica);
    
    System.out.println(Granjita.LugarDondeSeEnvio("123456", "29/02/2019").getNombre());
    System.out.println(Fabrica.getProductosrecibidos().get("1234567").getNombre());
    Fabrica.CrearProductoM("98765", "Pizza", "2/03/2019", Fabrica, Fabrica.getProductosrecibidos());
    Fabrica.getProductosrecibidos().get("123456").Trazabilidad();
    centro=(DistributionCenter) Fabrica.EnviarProducto("98765","7/03/2019" , centro);
    
    Tienda=(Retail) centro.EnviarProducto("98765", "8/03/2019", Tienda);
    Tienda.PonerAventaProductoR("98765", "10/03/2019", 6000);
    System.out.println("");
    gestionador.GuardarTrazabilidad(Granjita.getProductosquecultiva().get("1234567"));
        System.out.println("");
    gestionador.GuardarTrazabilidad(Tienda.getProductos().get("98765"));
        Consumer Pedro=new Consumer("Pedro");
    Pedro.AdquirirProducto(Tienda, "98765","23/03/2019");
    gestionador.GuardarTrazabilidad(Pedro.getProductosaadquiridos().get("98765"));
   
    }
}
