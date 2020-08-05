package ir.codekeshs;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.MediaPlayer;


public final class SettingsScene extends SceneParent {
    private static Scene scene;
    static {
        try {
            new SettingsScene();
        } catch (Exception ignored) {
        }
    }
    private static MediaPlayer mediaPlayer;

    private SettingsScene(){
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        root.setStyle("-fx-border-width: 0 0 5 0;");
        Label label = new Label("Volume: ");
        Slider slider = new Slider(0, 1, 0.5);
        setScene(new Scene(root,200,200));
        root.setLeft(label);
        root.setCenter(slider);
        BorderPane.setAlignment(slider, Pos.CENTER);
        slider.valueProperty().addListener((ov, old_val, new_val) -> mediaPlayer.setVolume(new_val.doubleValue()));
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        SettingsScene.mediaPlayer = mediaPlayer;
    }

    public static Scene getScene() {
        return scene;
    }

    private void setScene(Scene scene) {
        SettingsScene.scene = scene;
    }
}
