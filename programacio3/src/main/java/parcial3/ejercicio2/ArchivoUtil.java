package parcial3.ejercicio2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class ArchivoUtil {

    public static void guardarArchivo(String ruta, String contenido, Boolean flagAnexarContenido) throws IOException {

        FileWriter fw = new FileWriter(ruta, flagAnexarContenido);
        BufferedWriter bfw = new BufferedWriter(fw);
        bfw.write(contenido);
        bfw.close();
        fw.close();

    }

    public static String cargarFechaSistema() {

        String fechaSistema = "";

        String diaN = "";
        String mesN = "";
        String añoN = "";

        Calendar cal1 = Calendar.getInstance();


        int dia = cal1.get(Calendar.DATE);
        int mes = cal1.get(Calendar.MONTH) + 1;
        int año = cal1.get(Calendar.YEAR);
        int hora = cal1.get(Calendar.HOUR);
        int minuto = cal1.get(Calendar.MINUTE);


        if (dia < 10) {
            diaN += "0" + dia;
        } else {
            diaN += "" + dia;
        }
        if (mes < 10) {
            mesN += "0" + mes;
        } else {
            mesN += "" + mes;
        }

        //		fecha_Actual+= año+"-"+mesN+"-"+ diaN;
        //		fechaSistema = año+"-"+mesN+"-"+diaN+"-"+hora+"-"+minuto;
        fechaSistema = año + "-" + mesN + "-" + diaN;
        //		horaFechaSistema = hora+"-"+minuto;
        return fechaSistema;
    }
}
