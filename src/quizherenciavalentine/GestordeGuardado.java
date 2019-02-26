/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;

/**
 *
 * @author ancardenas
 */
public class GestordeGuardado {
    HashMap<String,Producto>productonecesarios=new HashMap<>();
    File file;
    PrintStream escribir;

    public GestordeGuardado(HashMap<String, Producto> productonecesarios, File file, PrintStream escribir) {
        this.productonecesarios = productonecesarios;
        this.file = file;
        this.escribir = escribir;
    }

    public HashMap<String, Producto> getProductonecesarios() {
        return productonecesarios;
    }

    public void setProductonecesarios(HashMap<String, Producto> productonecesarios) {
        this.productonecesarios = productonecesarios;
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

}
