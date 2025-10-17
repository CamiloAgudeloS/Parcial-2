package juanCamiloAgudelo.parcial2.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class InmobiliariaController implements Initializable {

    @FXML
    private Button btnRegistrar,btnMostrar;
    @FXML
    private StackPane containerForm;
    private VBox registrarView,mostrarView;
    private FormularioController formularioController;
    private TablaController tablaController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Cargar Formulario
            FXMLLoader loaderForm = new FXMLLoader(getClass().getResource("/juanCamiloAgudelo/Views/FormularioInmueble.fxml"));
            registrarView = loaderForm.load();
            formularioController = loaderForm.getController();

            // Cargar Tabla
            FXMLLoader loaderTabla = new FXMLLoader(getClass().getResource("/juanCamiloAgudelo/Views/Tabla.fxml"));
            mostrarView = loaderTabla.load();
            tablaController = loaderTabla.getController();

            // Conectar controladores
            formularioController.setTablaController(tablaController);

            // Agregar vistas al StackPane
            containerForm.getChildren().addAll(registrarView, mostrarView);
            registrarView.setVisible(true);
            mostrarView.setVisible(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void onActionEvent(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnRegistrar)) {
            registrarView.setVisible(true);
            mostrarView.setVisible(false);
        } else if (evt.equals(btnMostrar)) {
            registrarView.setVisible(false);
            mostrarView.setVisible(true);

            tablaController.refrescarTabla();
        }
    }
}
