package ir.ac.kntu;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class JavaFxApplication extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) {
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Weird Game");
        Pane pane = new Pane();
        Scene scene= new Scene(pane,800,600);
        stage.setScene(scene);
        stage.show();
    }

}