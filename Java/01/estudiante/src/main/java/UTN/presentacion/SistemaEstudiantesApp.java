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
        System.out.println("""
                *** Sis Est ***
                
                
                """;)
    }
}