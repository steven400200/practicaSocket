package parcial3.ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;


public class Cliente {


    public static void main(String[] args) {


        final int Puerto = 8081;
        DataInputStream entrada;
        DataOutputStream salida;
        JOptionPane.showMessageDialog(null, "¿desea cargar gasolina?\n");


        try {
            Socket consumidor = new Socket("localhost", Puerto);
            entrada = new DataInputStream(consumidor.getInputStream());
            salida = new DataOutputStream(consumidor.getOutputStream());

            salida.writeUTF(InformacionCliente());
            String mensaje = entrada.readUTF();
            System.out.println("Mensaje del servidor:  "+mensaje);
            consumidor.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static String InformacionCliente() {
        boolean bandera = true;
        boolean bandera2 = true;
        float cantidadGasolina = 0;
        String tipoVehiculo = "";

        String idPropietario = JOptionPane.showInputDialog("Ingrese el Id del propietario: ");
        while (bandera) {
            tipoVehiculo = JOptionPane.showInputDialog("Ingrese el tipo de vehiculo: \n-Camioneta\n-carro\n-motocicleta\n-camion\n-bus");
            if (tipoVehiculo.equalsIgnoreCase("camioneta") || tipoVehiculo.equalsIgnoreCase("carro") ||
                    tipoVehiculo.equalsIgnoreCase("motocicleta") || tipoVehiculo.equalsIgnoreCase("camion") ||
                    tipoVehiculo.equalsIgnoreCase("bus")) {
                bandera = false;
            }

        }

        while (bandera2) {
            try {
                cantidadGasolina = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de gasolina en galones: "));
                if (cantidadGasolina != 0) {
                    bandera2 = false;
                }
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, "La cantidad de galones debe ser un numero entero o debe ser diferente de cero ");
            }
        }
        String tipoVehiculoFinal = tipoVehiculo.toUpperCase();
        return (idPropietario + " " + tipoVehiculoFinal + " " + cantidadGasolina);
    }
}
