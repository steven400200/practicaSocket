module parcial2.programacio3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens parcial2.programacio3 to javafx.fxml;
    exports parcial2.programacio3;
}