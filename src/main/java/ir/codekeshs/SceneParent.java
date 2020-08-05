package ir.codekeshs;

import javafx.stage.Stage;

public class SceneParent {
    private static Stage stage;
    private static String url;

    public static void setStage(Stage stage) {
        SceneParent.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }
}
