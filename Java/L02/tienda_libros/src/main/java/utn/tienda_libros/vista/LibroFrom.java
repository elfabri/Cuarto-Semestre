package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import utn.tienda_libros.servicio.LibroServicio;

import javax.swing.*;

// estoy usando los mismos nombres que usa el profe btw
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JLabel panel;

    @Autowired
    public LibroFrom(LibroServicio libSer) {
        this.libroServicio = libSer;
        iniciarForma();
    }

    private void iniciarForma() {
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
    }
}
