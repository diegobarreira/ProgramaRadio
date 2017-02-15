package p3ej3;

import java.time.LocalTime;

/**
 *
 * @author Fran
 */
public class ProgramaRadio {

    /* Atributos de la clase */
    private LocalTime horaEmision;
    private String titulo;
    private String locutor;
    private long minutosDuracion;

    /**
     * Constructor con parametros
     *
     * @param titulo
     * @param locutor
     * @param minutosDuracion
     * @param horaEmision
     */
    public ProgramaRadio(String titulo, String locutor, long minutosDuracion, LocalTime horaEmision) {
        this.horaEmision = horaEmision;
        this.titulo = titulo;
        this.locutor = locutor;
        this.minutosDuracion = minutosDuracion;
    }

    /* Getter & Setter*/
    public LocalTime getHoraEmision() {
        return horaEmision;
    }

    public String getTitulo() {
        return titulo;
    }


    public String getLocutor() {
        return locutor;
    }

    public long getMinutosDuracion() {
        return minutosDuracion;
    }

    /* ToString */
    @Override
    public String toString() {
        return "El programa de radio " + titulo
                + " será emitido por " + locutor
                + " durante " + minutosDuracion
                + " minutos y su emisión empezará a las " + horaEmision + "\n";
    }

}
