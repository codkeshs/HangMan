package ir.codekeshs;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.FileNotFoundException;


public class App extends Application {

    @Override
    public void start(Stage stage) throws FileNotFoundException {
        SceneParent.setStage(stage);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("HangMan");
        stage.setScene(new MenuScene().getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}