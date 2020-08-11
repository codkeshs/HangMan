package ir.codekeshs;

import ir.codekeshs.scenes.Menu;
import ir.codekeshs.scenes.Parent;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Parent.setStage(stage);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("HangMan");
        stage.setScene(Menu.getInstance().getScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}