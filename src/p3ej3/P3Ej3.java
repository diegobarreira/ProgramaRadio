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

    public static void main(String[] args) {
        ArrayList<ProgramaRadio> misProgramas = new ArrayList<>();

        long duracion = 0;
        ProgramaRadio radioFM;

        do {
            System.out.println("El próximo programa de radio comenzará a las " + inicioPrograma);
            System.out.println("Duracion restante para la emisión " + duracionRestanteMinutos + " minutos");
            if (duracionRestanteMinutos > DURACION_MINIMA_MINUTOS) {
                String titulo = JOptionPane.showInputDialog("Inserte el Título del programa");
                String locutor = JOptionPane.showInputDialog("Inserte el nombre del locutor del programa");
                boolean repetir = false;
                do {
                    repetir = false;
                    try {
                        duracion = Long.parseLong(JOptionPane.showInputDialog("Inserte la duración en minutos"));
                        if (duracion < DURACION_MINIMA_MINUTOS) {
                            System.err.println("Debe durar más de " + DURACION_MINIMA_MINUTOS + " minutos");
                            repetir = true;
                        }
                        if (duracion > DURACION_MAXIMA_MINUTOS) {
                            System.err.println("Debe durar menos de " + DURACION_MAXIMA_MINUTOS + " minutos");
                            repetir = true;
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Debe introducir números // " + e.getMessage());
                        repetir = true;
                    }
                } while (repetir);
                duracionRestanteMinutos -= duracion;
                radioFM = new ProgramaRadio(titulo, locutor, duracion, inicioPrograma);
                inicioPrograma = inicioPrograma.plusMinutes(duracion);
                misProgramas.add(radioFM);
            } else {
                radioFM = new ProgramaRadio("Publicidad", "Sin locutor", duracionRestanteMinutos, inicioPrograma);
                misProgramas.add(radioFM);
            }
        } while (duracionRestanteMinutos > 0);

        for (ProgramaRadio radio : misProgramas) {
            System.out.println(radio);
        }
    }

}
