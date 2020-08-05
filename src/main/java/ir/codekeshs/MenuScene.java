package ir.codekeshs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.FileNotFoundException;


public final class MenuScene extends SceneParent {
    private static Scene scene;

    static {
        try {
            new MenuScene();
        } catch (FileNotFoundException ignored) {
        }
    }
    private static Button settings;
    private static Button start;

    private MenuScene() throws FileNotFoundException {
        Pane root = Helper.gamePane();
        root.setBackground(Helper.gameBG("menu_bg", 800, 600));
        setScene(new Scene(root, 800, 600));
        start = Helper.gameButton("start new game", 300, 320);
        settings = Helper.gameButton("","settings",360,150);
        root.getChildren().addAll(start,settings);
        handleButtons();
    }

    public static Scene getScene() {
        return scene;
    }

    private static void setScene(Scene scene) {
        MenuScene.scene = scene;
    }

    private static void handleButtons() {
        start.setOnAction(e -> {});
        settings.setOnAction(e -> new SettingsStage());
    }

}
