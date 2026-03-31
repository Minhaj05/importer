module com.spring26.section2.group15.importer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.spring26.section2.group15.importer to javafx.fxml;
    exports com.spring26.section2.group15.importer;
}