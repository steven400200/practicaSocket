package parcial3.ejercicio2;

import java.time.LocalDate;

public class Vehiculo {

    private String idPropietario;
    private String tipoVehiculo;
    private float cantidadGasolina;
    private String fecha;


    public Vehiculo(String idPropietario,String tipoVehiculo,float cantidadGasolina){
        this.idPropietario=idPropietario;
        this.tipoVehiculo= tipoVehiculo;
        this.cantidadGasolina=cantidadGasolina;
        this.fecha=ArchivoUtil.cargarFechaSistema();

    }

    public String getIdPropietario() {
        return idPropietario;
    }

    public void setIdPropietario(String idPropietario) {
        this.idPropietario = idPropietario;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public float getCantidadGasolina() {
        return cantidadGasolina;
    }

    public void setCantidadGasolina(float cantidadGasolina) {
        this.cantidadGasolina = cantidadGasolina;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public  static Vehiculo crearVehiculo(String mensaje){
        String[] infoVehiculo = mensaje.split(" ");
        float galones=0;
        try {
            galones = Float.parseFloat(infoVehiculo[2]);
        }catch(RuntimeException e){
            System.out.println("se esta recibiendo un String");
        }
        return new  Vehiculo(infoVehiculo[0],infoVehiculo[1],galones);

    }
}
