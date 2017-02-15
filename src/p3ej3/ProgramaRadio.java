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
     * Constructor vacío
     */
    public ProgramaRadio() {
    }

    /**
     * Constructor con parametros
     *
     * @param horaEmision
     * @param titulo
     * @param locutor
     * @param minutosDuracion
     */
    public ProgramaRadio(LocalTime horaEmision, String titulo, String locutor, long minutosDuracion) {
        this.horaEmision = horaEmision;
        this.titulo = titulo;
        this.locutor = locutor;
        this.minutosDuracion = minutosDuracion;
    }

    /* Getter & Setter*/
    public LocalTime getHoraEmision() {
        return horaEmision;
    }

    public void setHoraEmision(LocalTime horaEmision) {
        this.horaEmision = horaEmision;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocutor() {
        return locutor;
    }

    public void setLocutor(String locutor) {
        this.locutor = locutor;
    }

    public long getMinutosDuracion() {
        return minutosDuracion;
    }

    public void setMinutosDuracion(long minutosDuracion) {
        this.minutosDuracion = minutosDuracion;
    }

    /* ToString */
    @Override
    public String toString() {
        return "El programa de radio " + titulo
                + " será emitido por " + locutor
                + " durante " + minutosDuracion
                + " minutos y su emisión empezará a las " + horaEmision;
    }

}
