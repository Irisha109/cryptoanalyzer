module com.javarush.panova.cryptoanalyzerfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.string.similarity;


    opens com.javarush.panova.cryptoanalyzerfx to javafx.fxml;
    exports com.javarush.panova.cryptoanalyzerfx;
    exports com.javarush.panova.cryptoanalyzerfx.controller;
    opens com.javarush.panova.cryptoanalyzerfx.controller to javafx.fxml;
}