package ir.codekeshs;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import ir.codekeshs.scenes.Parent;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private String answer;
    private boolean end;
    private int number;
    private int tryNumber;
    private final BorderPane root;
    private final HBox hBox;

    public Game() {
        end = false;
        tryNumber = 0;
        root = new BorderPane();
        hBox = new HBox();
    }

    public void start(String chosen) {
        answer = chosen;
        number = answer.length();
        Parent.getStage().setScene(new Scene(root, 800, 600));
        addKeyBut();
        try {
            for (int i = 0; i < answer.length(); i++) {
                hBox.getChildren().add(new StackPane(new ImageView(new Image(new FileInputStream(
                        "src/main/resources/game/orange.png")))));
            }
            root.setCenter(hBox);
            hBox.setAlignment(Pos.CENTER);
            guess(Parent.getStage().getScene());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void guess(Scene scene) {
        scene.setOnKeyPressed(e -> {
            if (!end) {
                doing(e.getText());
            }
        });
    }

    public void doing(String input) {
        try {
            if (where(input.charAt(0)).size() == 0) {
                tryNumber++;
            }
            for (Integer i : where(input.charAt(0))) {
                if (((StackPane) hBox.getChildren().get(i)).getChildren().size() != 2) {
                    ((StackPane) hBox.getChildren().get(i)).getChildren().add(new Label(input.toUpperCase()));
                }
            }
            deletion(input.toUpperCase());
            checkForEnd();
        } catch (StringIndexOutOfBoundsException e) {
            // for keys like alt , ctrl , shift , enter , ..
        }
    }

    public List<Integer> where(char input) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == input || answer.charAt(i) == input + ('a' - 'A')) {
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
        for (int i = 0, k = 0; i < 13; i++) {
            for (int j = 0; j < 2; j++, k++) {
                pane.add(new Button(Character.toString(65 + k)), i, j);
            }
        }
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 100, 0));
        for (Node node : pane.getChildren()) {
            ((Button) node).setOnAction(e -> {
                if (!end) {
                    doing(((Button) node).getText());
                }
            });
        }
    }

    public void deletion(String input) {
        for (Node node : ((Pane) root.getBottom()).getChildren()) {
            if (((Button) node).getText().equals(input)) {
                ((Pane) root.getBottom()).getChildren().remove(node);
                break;
            }
        }
    }
}
