package ir.codekeshs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private String answer;
    private boolean end;
    private int number;
    private int tryNumber;
    private BorderPane root;

    public Game() {
        end = false;
        tryNumber = 0;
        root = new BorderPane();
    }

    public void start(String chosen) {
        answer = chosen;
        number = answer.length();
        SceneParent.getStage().setScene(new Scene(root, 800, 600));
        addKeyBut();
        try {
            guess(SceneParent.getStage().getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guess(Scene scene) throws IOException {
        HBox hBox = new HBox();
        for (int i = 0; i < answer.length(); i++) {
            hBox.getChildren().add(new StackPane(new ImageView(new Image(new FileInputStream(
                    "src/main/resources/game/orange.png")))));
        }
        root.setCenter(hBox);
        hBox.setAlignment(Pos.CENTER);
        scene.setOnKeyPressed(e -> {
            checkForEnd();
            if (!end) {
                tryNumber++;
                String input = e.getText();
                for (Integer i : where(input.charAt(0))) {
                    ((StackPane) (hBox.getChildren().get(i))).getChildren().add(new Label(input));
                }
            }
        });
    }

    public List<Integer> where(char input) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == input) {
                indexes.add(i);
                number--;
            }
        }
        return indexes;
    }

    public void checkForEnd() {
//        System.out.println("Number " + number + "\t Try number " + tryNum);
        if (number == 0 || tryNumber == 5) {
            end = true;
        }
    }

    public void addKeyBut() {
        GridPane pane = new GridPane();
        root.setBottom(pane);
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 2; j++) {
                pane.add(new Button(Character.toString(65 + i + j)), i, j);
            }
        }
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0,0,100,0));
    }
}















