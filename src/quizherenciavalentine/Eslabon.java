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
    private double[] direccion;

    public Eslabon(String nombre, String descripcion,double latitud,double longitud) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.direccion=new double[2];
       this.direccion[1]=latitud;
       this.direccion[2]=longitud;
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

    public double[] getDireccion() {
        return direccion;
    }

    public void setDireccion(double[] direccion) {
        this.direccion = direccion;
    }

public abstract Eslabon LugarDeEnvio();
public abstract void EnviarProducto();
}
