package App.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AsistenciaView extends JFrame {
    public JTextField txtCarnet = new JTextField(8);
    public JTextField txtNombre = new JTextField(8);
    public JButton btnGuardar = new JButton("Guardar");

    public JComboBox<String> cbEstado = new JComboBox<>(new String[]{"Presente", "Ausente"});
    public JButton btnAsistencia = new JButton("Asistencia");

    public DefaultTableModel modelo = new DefaultTableModel(new String[]{"Carnet", "Nombre", "Fecha", "Estado"}, 0);
    public JTable tabla = new JTable(modelo);

    public AsistenciaView() {
        setTitle("Asistencias");
        setSize(550, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel arriba = new JPanel();
        arriba.add(new JLabel("Carnet:"));
        arriba.add(txtCarnet);
        arriba.add(new JLabel("Nombre:"));
        arriba.add(txtNombre);
        arriba.add(btnGuardar);

        JPanel abajo = new JPanel();
        abajo.add(new JLabel("Estado:"));
        abajo.add(cbEstado);
        abajo.add(btnAsistencia);

        add(arriba, BorderLayout.NORTH);
        add(new JScrollPane(tabla), BorderLayout.CENTER);
        add(abajo, BorderLayout.SOUTH);
    }
}