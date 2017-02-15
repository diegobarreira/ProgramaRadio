package p3ej3;

import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fran
 */
public class P3Ej3 {

    private static final int MIN_SEGUNDOS = 60 * 60;// Minimos segundos que puede durar un programa de radio
    private static final int MAX_SEGUNDOS = 1440 * 60;// Maximos segundos que puede durar un programa de radio
    private static LocalTime inicioPrograma = LocalTime.of(00, 00);// Hora de inicio del primer programa de radio del día
    private static long duracionTotalEnSegundos = MAX_SEGUNDOS;// Cuenta atrás de los segundos que se van usando para los programas de radio

    public static void main(String[] args) {
        ArrayList<ProgramaRadio> misProgramas = new ArrayList();// Contenedor de programas de radio
        ProgramaRadio fm;// preparamos el objeto para crearlo
        boolean salir = false;// Indica cuando se dejan de introducir programas
        while (!salir) {
            String tituloPrograma = JOptionPane.showInputDialog("Introduce el nombre del programa de radio");
            String locutor = JOptionPane.showInputDialog("Introduce el nombre del Locutor");
            String duracion = "";// se descompone en horas y minutos
            LocalTime lt = null;// Hora de emisión del programa
            boolean error = false;// Empezamos sin errores
            long segundosQueDuraElPrograma = 0;// Calculamos cuantos segundos dura el programa de radio
            long hora = 0;
            long minutos = 0;
            do {
                error = false;// Reseteamos posibles errores en iteraciones anteriores
                try {
                    duracion = JOptionPane.showInputDialog("Introduce la duración del programa hh:mm");
                    String[] parts = duracion.split(":");
                    hora = Long.valueOf(parts[0]);// obtenemos las horas
                    minutos = Long.valueOf(parts[1]);// obtenemos los minutos
                } catch (NumberFormatException e) {// comprobamos que se inserte el dato como queremos
                    System.out.println("Introduce el tiempo siguiendo la estructura --> hh:mm");// comentario para el usuario
                    error = true;// hay un error
                }
                segundosQueDuraElPrograma = calcularSegundos(hora, minutos);// obtenemos los segundos que dura el programa
                duracionTotalEnSegundos -= segundosQueDuraElPrograma;// Restamos al total de segundos disponibles los segundos que hemos gastado
                if (duracionTotalEnSegundos < 0) {// si la duración total es negativa es porque un programa de radio se pisa con otro
                    System.out.println("El tiempo ha desbordado");// comentario para el usuario
                    error = true;// hay un error
                }
                if (duracionTotalEnSegundos <= MIN_SEGUNDOS) {// Si tenemos todo el tiemp ocupado dejamos de crear programas
                    salir = true;// salimos del bucle
                }
                if (segundosQueDuraElPrograma > MAX_SEGUNDOS) {// Si el tiempo supera el máximo hay error
                    System.out.println("El total de programas supera el cupo diario");//comentario para el usuario
                    error = true;// hay un error
                }
                if (segundosQueDuraElPrograma < MIN_SEGUNDOS) {// si el tiempo no supera el mínimo hay error
                    System.out.println("La hora insertada no esta permitida, inserta una hora entre 60 min y 1440 min");//comentario para el usuario
                    error = true;// hay un error
                }
                if (!error) {// Si no hay errores entonces
                    lt = inicioPrograma;//Asignamos el tiempo actual disponible a la hora de inicio del programa de radio
                    inicioPrograma = inicioPrograma.plusMinutes(hora * 60 + minutos);// actualizamos la siguiente hora de inicio
                    System.out.println("El próximo programa se emitirá a las " + inicioPrograma);// comentario para el usuario
                }
            } while (error == true);// mientras haya errores sigue pidiendo datos
            fm = new ProgramaRadio();// creamos el nuevo objeto desde el constructor vacío
            fm.setTitulo(tituloPrograma);// introducimos titulo del programa
            fm.setLocutor(locutor);// introducimos locutor
            fm.setHoraEmision(lt);// introducimos la hora la cual empezará a emitirse el programa
            fm.setMinutosDuracion(segundosQueDuraElPrograma / 60);// introducimos los segundos que dura el programa
            misProgramas.add(fm);// lo añadimos a nuestro contenedor
        }

        for (ProgramaRadio miPrograma : misProgramas) {// Recorremos el contenedor
            System.out.println(miPrograma.toString());// mostramos al usuario por consola
        }
    }

    /**
     * Horas y minutos se pasan a segundos
     *
     * @param horas
     * @param minutos
     * @return
     */
    public static long calcularSegundos(long horas, long minutos) {
        return (horas * 3600) + (minutos * 60);
    }
}
