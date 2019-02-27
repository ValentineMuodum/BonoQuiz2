/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.Clock;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ancardenas
 */
public class GestordeGuardado {
   
    File file;
    PrintStream escribir;

    public GestordeGuardado(File file) {
        this.file = file;
        try {
            this.escribir = new PrintStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GestordeGuardado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public PrintStream getEscribir() {
        return escribir;
    }

    public void setEscribir(PrintStream escribir) {
        this.escribir = escribir;
    }

    public  void GuardarTrazabilidad(Producto p){
        System.out.println("Se guardo la siguiente traza de producto en el archivo ");
              System.out.print(p.getID()+" "+p.getNombre()+" ");  
        
        escribir.print(p.getID()+" ");
        escribir.print(p.getNombre()+" ");
        p.Trazabilidad().values().stream().map((values) -> {
            escribir.print(values.getDescripcionProceso());
            return values;
        }).forEachOrdered((_item) -> {
            escribir.println();
        });
        escribir.println();
    }
}
