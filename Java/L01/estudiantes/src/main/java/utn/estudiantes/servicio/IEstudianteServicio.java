package utn.estudiantes.servicio;

import java.util.List;
import utn.estudiantes.modelo.Estudiante2022;

public interface IEstudianteServicio {
    public List<Estudiante2022> listarEstudiantes();

    public Estudiante2022 buscarEstudiantePorId(Integer idEstudiante);
    public void guardarEstudiante(Estudiante2022 estudiante);
    public void eliminarEstudiante(Estudiante2022 estudiante);

}
