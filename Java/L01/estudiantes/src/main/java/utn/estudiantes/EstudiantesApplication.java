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

            } case 2 -> {  // Buscar por id
                logger.info("Ingrese un id: ");
                int id = Integer.parseInt(c.nextLine());
                Estudiantes2022 e = eS.buscarEstudiantePorId(id);
                if (e != null) {
                    logger.info("Estudiante encontrado: " + e + nl);
                } else {
                    logger.info("Estudiante NO encontrado: " + e + nl);
                }
            } case 3 -> {  // Agregar
                logger.info("Agregar Estudiante:"+nl);
                logger.info("Nombre: ");
                String nom = c.nextLine();
                logger.info("Apellido: ");
                String ap = c.nextLine();
                logger.info("Telefono: ");
                String tel = c.nextLine();
                logger.info("Email: ");
                String em = c.nextLine();

                // Crear obj estudiante sin id
                Estudiantes2022 e = new Estudiantes2022();
                e.setNombre(nom);
                e.setApellido(ap);
                e.setTelefono(tel);
                e.setEmail(em);

                eS.guardarEstudiante(e);
                logger.info("Estudiante agregado: " + e + nl);
            }
        }
        return salir;
    }

}
