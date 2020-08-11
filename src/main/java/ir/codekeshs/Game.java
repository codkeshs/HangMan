package ir.codekeshs;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

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
        Label label = new Label(chosen);
        root.getChildren().add(label);
        guess(SceneParent.getStage().getScene());
    }

    public void guess(Scene scene) {
        HBox hBox = new HBox();
        for (int i = 0; i < answer.length(); i++) {
            hBox.getChildren().add(new StackPane(new ImageView("file:/home/shayan/Downloads/orange.png")));
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
}
