package mvc;

import App.controllers.AsistenciaController;
import App.models.GestionAsistencia;
import App.views.AsistenciaView;

public class Main {
    public static void main(String[] args) {
        GestionAsistencia modelo = new GestionAsistencia();

        AsistenciaView vista = new AsistenciaView();

        new AsistenciaController(modelo, vista);

        vista.setVisible(true);
    }
}