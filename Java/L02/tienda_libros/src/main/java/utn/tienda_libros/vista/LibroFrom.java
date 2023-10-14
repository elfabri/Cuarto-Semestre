package utn.tienda_libros.vista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import utn.tienda_libros.modelo.Libro;
import utn.tienda_libros.servicio.LibroServicio;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

// estoy usando los mismos nombres que usa el profe btw
@Component
public class LibroFrom extends JFrame {
    LibroServicio libroServicio;
    private JLabel panel;
    private JTable tablaLibros;
    private JTextField libroTexto;
    private JTextField autorTexto;
    private JTextField precioTexto;
    private JTextField existenciasTexto;
    private JButton agregarButton;
    private JButton modificarButton;
    private JButton eliminarButton;
    private DefaultTableModel tablaModeloLibros;

    @Autowired
    public LibroFrom(LibroServicio libSer) {
        this.libroServicio = libSer;
        iniciarForma();
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(e -> agregarLibro());
        });
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

    private void agregarLibro() {
        // leer los valores del formulario
        if (libroTexto.getText().equals("")) {
            mostrarMensaje("Ingresa el nombre del libro");
            libroTexto.requestFocusInWindow();
            return;
        }

        var nombre = libroTexto.getText();
        var autor = autorTexto.getText();
        var precio = precioTexto.getText();
        var existencias = existenciasTexto.getText();

        // creamos objeto libro
        var libro = new Libro();
        libro.setNombreLibro(nombre);
        libro.setAutor(autor);
        libro.setPrecio(Double.parseDouble(precio));
        libro.setExistencias(Integer.parseInt(existencias));
    }

    private void mostrarMensaje(String msg) {
        JOptionPane.showMessageDialog(this, msg);
    }

    private void createUIComponents() {
        this.tablaModeloLibros = new DefaultTableModel(0, 5);
        String[] cabecera = {"Id", "Libro", "Autor", "Precio", "Existencias"};
        this.tablaModeloLibros.setColumnIdentifiers(cabecera);

        this.tablaLibros = new JTable(tablaModeloLibros);
        listarLibros();
    }

    private void listarLibros() {
        // limpiar tabla
        tablaModeloLibros.setRowCount(0);

        // obtener libros de la BD
        var libros = libroServicio.listarLibros();

        // iteramos cada libro
        libros.forEach((libro) -> {
            Object [] renglonLibro = {
                libro.getIdLibro(),
                libro.getNombreLibro(),
                libro.getAutor(),
                libro.getPrecio(),
                libro.getExistencias()
            };

            this.tablaModeloLibros.addRow(renglonLibro);
        });
    }
}
