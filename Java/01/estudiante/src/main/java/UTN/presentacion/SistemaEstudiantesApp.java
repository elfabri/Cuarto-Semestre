package UTN.presentacion;

import UTN.conexion.Conexion;
import UTN.datos.EstudianteDao;
import UTN.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);

        var estDao = new EstudianteDao();
        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOp(consola, estDao);
            } catch (Exception e) {
                System.out.println("Ocurrió un error al ejecutar la operación: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.print("""
                *** Sis Est ***
                1. Listar
                2. Buscar
                3. Agregar
                4. Modificar
                5. Eliminar
                6. Salir

                Ingrese opción:
                """);
    }
    
    private static boolean ejecutarOp(Scanner consola, EstudianteDao estudianteDao) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion) {
            case 1 -> {
                System.out.println("Listando estudiantes...");
                var estudiantes = estudianteDao.listarEstudiantes();
                estudiantes.forEach(System.out::println);
                return salir;
            }
        }
    }
}