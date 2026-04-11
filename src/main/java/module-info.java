module com.spring26.section2.group15.importer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires java.desktop;

    opens com.spring26.section2.group15.importer to javafx.fxml;
    opens com.spring26.section2.group15.importer.Arpita to javafx.fxml;
    opens com.spring26.section2.group15.importer.Shafuath to javafx.fxml;

    exports com.spring26.section2.group15.importer;
    exports com.spring26.section2.group15.importer.Arpita;
    exports com.spring26.section2.group15.importer.Shafuath;
}