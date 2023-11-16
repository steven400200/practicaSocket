package parcial3.ejercicio2;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {




    public static void main(String[] args) {
        ServerSocket servidor =null;
        Socket consumidor= null;
        DataInputStream entrada ;
        DataOutputStream salida;
        final int PUERTO =8081;



        try {
            servidor = new ServerSocket(8081);
            System.out.println("INICIANDO SERVIDOR");


            while(true) {
                consumidor = servidor.accept();
                System.out.println("Cliente conectado");
                entrada = new DataInputStream(consumidor.getInputStream());
                salida = new DataOutputStream(consumidor.getOutputStream());
                String mensajeNuevo = entrada.readUTF();


                Persistencia.guardarProdcutos(Vehiculo.crearVehiculo(mensajeNuevo));
                salida.writeUTF("Informacion guardada correctamente");



                consumidor.close();
                System.out.println("Cliente desconectado");

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }



}
