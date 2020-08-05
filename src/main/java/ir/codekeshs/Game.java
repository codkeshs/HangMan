package ir.codekeshs;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game {
    public void start(String chosen) {
        Pane pane = Helper.gamePane();
        SceneParent.getStage().setScene(new Scene(pane, 800, 600));
    }
}
