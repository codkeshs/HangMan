package ir.codekeshs.scenes;

import ir.codekeshs.Helper;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.File;

public class Menu extends Parent {
    private final Scene scene;
    private final static Menu instance = new Menu();
    private static Button settings;
    private static Button start;

    private Menu() {
        Pane root = Helper.gamePane();
        root.setBackground(Helper.gameBG("menu", 800, 600));
        scene = new Scene(root, 800, 600);
        start = Helper.gameButton("start new game", 300, 320);
        settings = Helper.gameButton("", "settings", 360, 150);
//        MediaView mediaView = startSong();
        root.getChildren().addAll(start, settings);
        handleButtons();
    }

    public static MediaView startSong() {
        Media media = new Media(new File("src/main/resources/audio/song.mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        Settings.setMediaPlayer(mediaPlayer);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();
        mediaPlayer.setVolume(0.5);
        return new MediaView(mediaPlayer);
    }

    public static Menu getInstance(){
        return instance;
    }

    public Scene getScene() {
        return scene;
    }

    private static void handleButtons() {
        start.setOnAction(e -> getStage().setScene(new Category().getScene()));
        settings.setOnAction(e -> Settings.getInstance().makeStage());
    }
}
