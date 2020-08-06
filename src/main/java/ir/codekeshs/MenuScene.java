package ir.codekeshs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileNotFoundException;


public class MenuScene extends SceneParent {
    private final Scene scene;

    private static Button settings;
    private static Button start;

    public MenuScene() throws FileNotFoundException {
        Pane root = Helper.gamePane();
        root.setBackground(Helper.gameBG("menu_bg", 800, 600));
        scene = new Scene(root, 800, 600);
        start = Helper.gameButton("start new game", 300, 320);
        settings = Helper.gameButton("", "settings", 360, 150);
        MediaView mediaView = startSong();
        root.getChildren().addAll(start, settings, mediaView);
        handleButtons();
    }

    public static MediaView startSong() {
        Media media = new Media(new File("src/main/resources/sound/song.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        SettingsScene.setMediaPlayer(mediaPlayer);
        mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
        return new MediaView(mediaPlayer);
    }

    public Scene getScene() {
        return scene;
    }

    private static void handleButtons() {
        start.setOnAction(e -> getStage().setScene(new Category().getScene()));
        settings.setOnAction(e -> {
            Stage settings = new Stage();
            settings.initStyle(StageStyle.UTILITY);
            settings.setTitle("Settings");
            settings.initModality(Modality.APPLICATION_MODAL);
            settings.setScene(new SettingsScene().getScene());
            settings.showAndWait();
        });
    }
}
