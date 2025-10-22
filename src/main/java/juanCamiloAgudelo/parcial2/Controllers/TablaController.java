package juanCamiloAgudelo.parcial2.Controllers;


import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import juanCamiloAgudelo.parcial2.Modelo.Inmueble;
import juanCamiloAgudelo.parcial2.repositorio.InmuebleRepository;

import java.net.URL;
import java.util.ResourceBundle;

public class TablaController implements Initializable {

    @FXML
    private TableView<Inmueble> tablaInmuebles;

    @FXML
    private TableColumn<Inmueble, String> colTipo;

    @FXML
    private TableColumn<Inmueble, String> colCiudad;

    @FXML
    private TableColumn<Inmueble, Integer> colHabitaciones;

    @FXML
    private  TableColumn<Inmueble, Integer>colPisos;

    @FXML
    private TableColumn<Inmueble,Double>colPrecio;


    private InmuebleRepository inmuebleRepository;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        inmuebleRepository = InmuebleRepository.getInstancia();

        // Configurar las columnas de la tabla
        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colHabitaciones.setCellValueFactory(new PropertyValueFactory<>("habitaciones"));
        colPisos.setCellValueFactory(new PropertyValueFactory<>("pisos"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));


        tablaInmuebles.setItems(inmuebleRepository.getInmuebles());

    }




    /**
     * Maneja el evento de click en el botón "Eliminar"
     */
    @FXML
    private void onEliminarInmueble() {
        Inmueble inmublesSelecionados = tablaInmuebles.getSelectionModel().getSelectedItem();

        if (inmublesSelecionados
                == null) {
            mostrarAlerta("Advertencia", "Por favor seleccione un inmueble para eliminar", Alert.AlertType.WARNING);
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmar eliminación");
        confirmacion.setHeaderText("¿Está seguro de eliminar el inmueble?");
        confirmacion.setContentText("Inmueble: " + inmublesSelecionados.getTipo());

        confirmacion.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                inmuebleRepository.elimarInmueble(inmublesSelecionados
                );
                mostrarAlerta("Éxito", "Inmueble eliminado correctamente", Alert.AlertType.INFORMATION);
            }
        });
    }



    /**
     * Muestra una alerta al usuario
     */
    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

}
