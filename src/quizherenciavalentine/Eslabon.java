/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

import java.util.ArrayList;

/**
 *
 * @author ancardenas
 */
public abstract class  Eslabon {
    private String nombre;
    private String descripcion;
    private ArrayList direccion=new ArrayList();

    public Eslabon(String nombre, String descripcion,double latitud,double longitud) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        direccion.add(0,latitud);
        direccion.add(1,longitud);
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList getDireccion() {
        return direccion;
    }

    public void setDireccion(ArrayList direccion) {
        this.direccion = direccion;
    }

  

public abstract Eslabon LugarDondeSeEnvio(String ID,String fecha);
public abstract Eslabon EnviarProducto(String ID,String fechasalida,String FechaDeExpedicion,Eslabon m);
}
