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

    public FechaDePaso(String fecha, Eslabon lugardeproceso) {
        this.fecha = fecha;
        this.lugardeproceso = lugardeproceso;
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
