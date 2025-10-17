module juanCamiloAgudelo.parcial2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;

    // Permitir acceso por reflexión (FXMLLoader y PropertyValueFactory)
    opens juanCamiloAgudelo.parcial2.Controllers to javafx.fxml;
    opens juanCamiloAgudelo.parcial2.Modelo to javafx.base;
    opens juanCamiloAgudelo.parcial2.repositorio to javafx.fxml;
    opens juanCamiloAgudelo.parcial2 to javafx.fxml;

    // Exportar los paquetes principales
    exports juanCamiloAgudelo.parcial2;
    exports juanCamiloAgudelo.parcial2.Controllers;
    exports juanCamiloAgudelo.parcial2.Modelo;
    exports juanCamiloAgudelo.parcial2.repositorio;
}
