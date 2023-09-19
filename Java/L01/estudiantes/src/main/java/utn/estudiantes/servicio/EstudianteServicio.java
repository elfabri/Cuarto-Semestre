package utn.estudiantes.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utn.estudiantes.modelo.Estudiante2022;
import utn.estudiantes.repositorio.EstudianteRepositorio;

import java.util.List;

@Service
public class EstudianteServicio implements IEstudianteServicio {
    @Autowired
    private EstudianteRepositorio eR;

    @Override
    public List<Estudiante2022> listarEstudiantes() {
        List<Estudiante2022> e = eR.findAll();
        return e;
    }

    @Override
    public Estudiante2022 buscarEstudiantePorId(Integer idEstudiante) {
        Estudiante2022 e = eR.findById(idEstudiante).orElse(null);
        return e;
    }

    @Override
    public void guardarEstudiante(Estudiante2022 estudiante) {
        eR.save(estudiante);
    }

    @Override
    public void eliminarEstudiante(Estudiante2022 estudiante) {
        eR.delete(estudiante);
    }
}
