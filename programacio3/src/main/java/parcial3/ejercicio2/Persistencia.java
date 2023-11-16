package parcial3.ejercicio2;

import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    final static String RUTA_ARCHIVO_PRODUCTOS="src/main/java/parcial3/ejercicio2/resources/tanqueo.txt";


    public static void guardarProdcutos(Vehiculo vehiculo) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";

            contenido+= vehiculo.getIdPropietario()+"--"+vehiculo.getTipoVehiculo()+"--"+vehiculo.getCantidadGasolina()
                    +"--"+vehiculo.getFecha()+"\n";

        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_PRODUCTOS, contenido, true);
    }
}
