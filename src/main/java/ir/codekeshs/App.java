package ir.codekeshs;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        SceneParent.setStage(stage);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("HangMan");
        stage.setScene(MenuScene.getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}