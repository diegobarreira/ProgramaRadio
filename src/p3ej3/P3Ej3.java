package p3ej3;

import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class P3Ej3 {

    private static final long DURACION_MINIMA_MINUTOS = 60;
    private static final long DURACION_MAXIMA_MINUTOS = 1440;
    private static LocalTime inicioPrograma = LocalTime.of(0, 0);
    private static long duracionRestanteMinutos = 1440;

    private static enum MENSAJE {
        TITULO, LOCUTOR, TIEMPO
    }

    public static void main(String[] args) {
        ArrayList<ProgramaRadio> misProgramas = new ArrayList<>();

        long duracion = 0;
        ProgramaRadio radioFM;

        while (duracionRestanteMinutos > 0) {
            if (duracionRestanteMinutos > DURACION_MINIMA_MINUTOS) {
                String titulo = insertarDato(MENSAJE.TITULO);
                String locutor = insertarDato(MENSAJE.LOCUTOR);
                do {
                    System.out.println("Duración mínima es de 60 minutos y la máxima es de 1440");
                    duracion = Long.parseLong(insertarDato(MENSAJE.TIEMPO));
                } while (duracion < DURACION_MINIMA_MINUTOS || duracion > DURACION_MAXIMA_MINUTOS);
                duracionRestanteMinutos -= duracion;
                radioFM = new ProgramaRadio(titulo, locutor, duracion, inicioPrograma);
                inicioPrograma = inicioPrograma.plusMinutes(duracion);
                misProgramas.add(radioFM);
            } else {
                radioFM = new ProgramaRadio("Publicidad", "Sin locutor", duracionRestanteMinutos, inicioPrograma);
                misProgramas.add(radioFM);
            }
        }

        for (ProgramaRadio radio : misProgramas) {
            System.out.println(radio);
        }
    }

    public static String insertarDato(MENSAJE msj) {
        String dato = "";
        boolean error = false;
        do {
            error = false;
            if (msj.TITULO == MENSAJE.TITULO) {
                dato = JOptionPane.showInputDialog("Inserte el Título del programa");
            }
            if (msj.LOCUTOR == MENSAJE.LOCUTOR) {
                dato = JOptionPane.showInputDialog("Inserte el Locutor del programa");
            }
            try {
                if (msj.TIEMPO == MENSAJE.TIEMPO) {
                    dato = JOptionPane.showInputDialog("Inserte las horas de duración del programa");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato numérico");
                error = true;
            }
        } while (error);
        return dato;
    }
}
