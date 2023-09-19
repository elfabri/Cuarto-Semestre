package utn.estudiantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import utn.estudiantes.modelo.Estudiante2022;
import utn.estudiantes.servicio.EstudianteServicio;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

    @Autowired
    private EstudianteServicio eS;
    private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

    String nl = System.lineSeparator();

	public static void main(String[] args) {
        logger.info("Iniciando app");

		SpringApplication.run(EstudiantesApplication.class, args);
        logger.info("App finalizada");
	}

    @Override
    public void run(String... args) throws Exception {
        logger.info(nl + "Ejecutando run de spring" + nl);

    }

}
