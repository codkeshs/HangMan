package ir.codekeshs.scenes;

import javafx.stage.Stage;

public class Parent {
    private static Stage stage;

    public static void setStage(Stage stage) {
        Parent.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }
}
