package App.controllers;

import App.models.Estudiante;
import App.models.GestionAsistencia;
import App.models.RegistroAsistencia;
import App.views.AsistenciaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AsistenciaController implements ActionListener {
    public GestionAsistencia modelo;
    public AsistenciaView vista;

    public AsistenciaController(GestionAsistencia modelo, AsistenciaView vista) {
        this.modelo = modelo;
        this.vista = vista;

        this.vista.btnGuardar.addActionListener(this);
        this.vista.btnAsistencia.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnGuardar) {
            String carnet = vista.txtCarnet.getText();
            String nombre = vista.txtNombre.getText();

            Estudiante al = new Estudiante(carnet, nombre, "Sistemas");
            boolean guardo = modelo.agregarEstudiante(al);

            if (guardo == true) {
                JOptionPane.showMessageDialog(null, "Estudiante guardado");
                vista.txtCarnet.setText("");
                vista.txtNombre.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "Error, ya existe");
            }
        }

        if (e.getSource() == vista.btnAsistencia) {
            String carnet = JOptionPane.showInputDialog("Ingrese el carnet:");
            String estado = (String) vista.cbEstado.getSelectedItem();

            boolean marco = modelo.registrarAsistencia(carnet, LocalDate.now(), estado);

            if (marco == true) {
                vista.modelo.setRowCount(0);
                for (int i = 0; i < modelo.getAsistencias().size(); i++) {
                    RegistroAsistencia r = modelo.getAsistencias().get(i);
                    vista.modelo.addRow(new Object[]{
                            r.getEstudiante().getCarnet(),
                            r.getEstudiante().getNombre(),
                            r.getFecha(),
                            r.getEstado()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el carnet");
            }
        }
    }
}