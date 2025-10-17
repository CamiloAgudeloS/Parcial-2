package juanCamiloAgudelo.parcial2.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import juanCamiloAgudelo.parcial2.Modelo.Inmueble;
import juanCamiloAgudelo.parcial2.repositorio.InmuebleRepository;



public class FormularioController {


    @FXML
    private TextField txtTipo;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtHabitaciones;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtPisos;

    @FXML
    private Button btnGuardar;



    private InmuebleRepository inmuebleRepository;
    private TablaController tablaController;


    @FXML
    public void initialize() {
        inmuebleRepository = InmuebleRepository.getInstancia();
    }

    public void setTablaController(TablaController tablaController) {
        this.tablaController = tablaController;
    }


    /**
     * Maneja el evento de guardar producto
     */
    @FXML
    private void onGuardarInmueble() {
        if (!validarCampos()) {
            return;
        }

        try {
            String tipo = txtTipo.getText().trim();
            String ciudad = txtCiudad.getText().trim();
            int habitaciones = Integer.parseInt(txtHabitaciones.getText().trim());
            int pisos = Integer.parseInt(txtPisos.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());




            // Crear y guardar el producto
            Inmueble nuevoInmueble = new Inmueble(tipo,ciudad,habitaciones,pisos,precio);
            inmuebleRepository.agregarInmueble(nuevoInmueble);

            mostrarAlerta("Éxito", "Producto creado correctamente", Alert.AlertType.INFORMATION);

            if (tablaController != null) {
                tablaController.refrescarTabla();
            }
            System.out.println("Guardado inmueble, total: " + inmuebleRepository.getInmuebles().size());
            limpiarCampos();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio y stock deben ser valores numéricos válidos", Alert.AlertType.ERROR);
        }
    }

    private void limpiarCampos() {
        txtTipo.clear();
        txtCiudad.clear();
        txtHabitaciones.clear();
        txtPrecio.clear();
        txtPisos.clear();
    }




    /**
     * Valida que los campos del formulario estén completos
     */
    private boolean validarCampos() {
        if (txtTipo.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El tipo es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtCiudad.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "La ciudad es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtHabitaciones.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El numero de Habitaciones  es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtPrecio.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El precio es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        if (txtPisos.getText().trim().isEmpty()) {
            mostrarAlerta("Error de validación", "El numero de Pisos es obligatorio", Alert.AlertType.WARNING);
            return false;
        }
        return true;
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

