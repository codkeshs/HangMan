package ir.codekeshs.scenes;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Settings extends Parent {
    private final static Settings instance = new Settings();
    private final Scene scene;
    private static MediaPlayer mediaPlayer;

    private Settings() {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setStyle("-fx-border-width: 0 0 5 0;");
        Label label = new Label("Volume: ");
        Slider slider = new Slider(0, 1, 0.5);
        scene = new Scene(root, 200, 200);
        root.setLeft(label);
        root.setCenter(slider);
        BorderPane.setAlignment(slider, Pos.CENTER);
        BorderPane.setAlignment(label, Pos.CENTER);
        slider.valueProperty().addListener((ov, old_val, new_val) -> mediaPlayer.setVolume(new_val.doubleValue()));
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        Settings.mediaPlayer = mediaPlayer;
    }

    public Scene getScene() {
        return scene;
    }

    public static Settings getInstance(){
        return instance;
    }

    public void makeStage(){
        Stage settings = new Stage();
        settings.initStyle(StageStyle.UTILITY);
        settings.setTitle("Settings");
        settings.initModality(Modality.APPLICATION_MODAL);
        settings.setScene(scene);
        settings.showAndWait();
    }
}
