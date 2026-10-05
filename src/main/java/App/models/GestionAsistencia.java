package App.models;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class GestionAsistencia {
    private List<Estudiante> estudiantes;
    private List<RegistroAsistencia> asistencias;
    public GestionAsistencia() {
        this.estudiantes = new ArrayList<>();
        this.asistencias = new ArrayList<>();
    }
    public boolean agregarEstudiante(Estudiante estudiante) {
        if (estudiante == null || buscarEstudiante(estudiante.getCarnet()) != null) {
            return false;
        }
        return estudiantes.add(estudiante);
    }

    public Estudiante buscarEstudiante(String carnet) {
        for (Estudiante e : estudiantes) {
            if (e.getCarnet().equalsIgnoreCase(carnet)) {
                return e;
            }
        }
        return null;
    }
    public boolean registrarAsistencia(String carnet, LocalDate fecha, String estado) {
        Estudiante est = buscarEstudiante(carnet);
        if (est == null) {
            return false;
        }
        for (RegistroAsistencia r : asistencias) {
            if (r.getEstudiante().getCarnet().equalsIgnoreCase(carnet) && r.getFecha().equals(fecha)) {
                r.setEstado(estado);
                return true;
            }
        }
        return asistencias.add(new RegistroAsistencia(est, fecha, estado));
    }
    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
    public List<RegistroAsistencia> getAsistencias() {
        return asistencias;
    }
}