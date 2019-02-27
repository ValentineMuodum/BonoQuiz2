/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quizherenciavalentine;

/**
 *
 * @author ancardenas
 */
public class FechaDePaso {
  private String fecha;
private Eslabon lugardeproceso; 
private String DescripcionProceso;
    public FechaDePaso(String fecha, Eslabon lugardeproceso,String Descripcion) {
        this.fecha = fecha;
        this.lugardeproceso = lugardeproceso;
        this.DescripcionProceso=Descripcion;
    }

    public String getDescripcionProceso() {
        return DescripcionProceso;
    }

    public void setDescripcionProceso(String DescripcionProceso) {
        this.DescripcionProceso = DescripcionProceso;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Eslabon getLugardeproceso() {
        return lugardeproceso;
    }

    public void setLugardeproceso(Eslabon lugardeproceso) {
        this.lugardeproceso = lugardeproceso;
    }

}
