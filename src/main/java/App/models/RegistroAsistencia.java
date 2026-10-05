package App.models;
import java.time.LocalDate;
public class RegistroAsistencia {
    private Estudiante estudiante;
    private LocalDate fecha;
    private String estado;
    public RegistroAsistencia(Estudiante estudiante, LocalDate fecha, String estado) {
        this.estudiante = estudiante;
        this.fecha = fecha;
        this.estado = estado;
    }
    public Estudiante getEstudiante() {
        return estudiante;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}