package ir.codekeshs.scenes;

import ir.codekeshs.Helper;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Category extends Parent {
    private final Scene scene;

    public Category() {
        GridPane root = new GridPane();
        root.setBackground(Helper.gameBG("category", 800, 600));
        scene = new Scene(root, 800, 600, Color.rgb(250, 240, 240));
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        makeButtons(root);
    }

    private void makeButtons(GridPane root) {
        String url = "src/main/resources/button-images/";
        try {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    int number = i * 2 + j;
                    Button button = new Button("", new ImageView(new Image(
                            new FileInputStream(url + number + ".png"))));
                    root.add(button, i, j);
                    button.setOnAction(e -> getStage().setScene(new Game("cat").getScene()));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Scene getScene() {
        return scene;
    }
}
