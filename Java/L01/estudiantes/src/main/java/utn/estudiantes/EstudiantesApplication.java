package utn.estudiantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import java.util.Scanner;
import utn.estudiantes.modelo.Estudiantes2022;
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
        var salir = false;
        var consola = new Scanner(System.in);
        while (!salir) {
            mostrarMenu();
            salir = ejecutarOpciones(consola);
            logger.info(nl);
        }

    }

    private void mostrarMenu() {
        logger.info(nl);
        logger.info("""
                *** Sist Est ***
                1. Listar Estudiantes
                2. Buscar
                3. Agregar
                4. Modificar
                5. Eliminar
                6. Salir

                Ingrese opción: """);
    }

    private boolean ejecutarOpciones(Scanner c){
        int opcion = Integer.parseInt(c.nextLine());
        boolean salir = false;
        switch (opcion) {
            case 1 -> {  // Listar estudiantes
                logger.info(nl+"Listado de Estudiantes:"+nl);
                List<Estudiantes2022> estudiantes = eS.listarEstudiantes();
                estudiantes.forEach((e -> logger.info(e.toString()+nl)));
            }
        }
        return salir;
    }

}
