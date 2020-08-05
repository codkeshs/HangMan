package ir.codekeshs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;
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
        Media media = new Media(new File("src/main/resources/sound/song.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        SettingsScene.setMediaPlayer(mediaPlayer);
        MediaView mediaView = new MediaView(mediaPlayer);
        root.getChildren().addAll(start,settings,mediaView);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
        handleButtons();
    }

    public static Scene getScene() {
        return scene;
    }

    private static void setScene(Scene scene) {
        MenuScene.scene = scene;
    }

    private static void handleButtons() {
        start.setOnAction(e -> new Category().start());
        settings.setOnAction(e -> {
            Stage settings = new Stage();
            settings.setTitle("Settings");
            settings.initModality(Modality.APPLICATION_MODAL);
            settings.setScene(SettingsScene.getScene());
            settings.showAndWait();
        });
    }
}
