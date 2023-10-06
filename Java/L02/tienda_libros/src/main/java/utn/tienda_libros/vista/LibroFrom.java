package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utn.tienda_libros.servicio.LibroServicio;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.*;

// estoy usando los mismos nombres que usa el profe btw
@Component
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

        // dimensiones de pantalla
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension pantalla = tk.getScreenSize();

        // posicion
        int x = (pantalla.width - getWidth()/2);
        int y = (pantalla.height - getHeight()/2);
        setLocation(x, y);
    }
}
