module com.course.contents.coursecontents {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.course.contents.coursecontents to javafx.fxml;
    exports com.course.contents.coursecontents;
}