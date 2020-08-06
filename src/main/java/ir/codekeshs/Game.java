package ir.codekeshs;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game {
    private String answer;

    public void start(String chosen) {
        answer = chosen;
        Pane pane = Helper.gamePane();
        SceneParent.getStage().setScene(new Scene(pane, 800, 600));
    }
}
