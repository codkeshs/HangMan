package ir.codekeshs.scenes;

import ir.codekeshs.Helper;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Game extends Parent {
    private final Scene scene;
    private final String answer;
    private boolean end;
    private int tryNumber;
    private final BorderPane root;
    private final HBox hBox;
    private final String url;
    private final List<String> name;

    public Game(String chosen) {
        name = new LinkedList<>(Arrays.asList(chosen.split("")));
        end = false;
        tryNumber = 0;
        root = new BorderPane();
        root.setPadding(new Insets(50));
        hBox = new HBox();
        url = "src/main/resources/game/";
        scene = new Scene(root, 800, 600);
        answer = chosen;
        addKeys();
        addBG();
        settingButtons();
    }

    public void addBG() {
        try {
            for (int i = 0; i < answer.length(); i++) {
                hBox.getChildren().add(new StackPane(new ImageView(new Image(new FileInputStream(
                        url + "orange.png")))));
            }
            root.setRight(hBox);
            hBox.setAlignment(Pos.CENTER);
            guess(scene);
        } catch (IOException ignored) {
        }
    }

    public void guess(Scene scene) {
        scene.setOnKeyPressed(e -> {
            if (!end && !e.getText().equals("")) {
                doing(e.getText());
            }
        });
    }

    public void doing(String input) {
        for (Integer i : where(input.charAt(0))) {
            if (((StackPane) (hBox.getChildren().get(i))).getChildren().size() != 2) {
                ((StackPane) (hBox.getChildren().get(i))).getChildren().add(new Label(input));
            }
        }
        deletion(input.toUpperCase());
        checkForEnd();
    }

    public List<Integer> where(char input) {
        List<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) == input || answer.charAt(i) == input + ('a' - 'A')) {
                indexes.add(i);
                name.remove(Character.toString(input));
            }
        }
        if (indexes.isEmpty()) {
            tryNumber++;
            animation(tryNumber);
        }
        return indexes;
    }

    public void checkForEnd() {
        if (name.size() == 0 || tryNumber == 5) {
            end = true;
            BorderPane pane = new BorderPane();
            String text;
            if (name.size() == 0) {
                text = "You Won!\nBe Kiram";
            } else {
                text = "You Lost!\nKose Amat";
            }
            pane.setCenter(new Label(text));
            AnimationTimer animationTimer = new AnimationTimer() {
                private final long time = System.currentTimeMillis();
                private boolean sceneSet = false;

                @Override
                public void handle(long l) {
                    if (System.currentTimeMillis() - time >= 1000 && !sceneSet) {
                        getStage().setScene(new Scene(pane, 800, 600));
                        sceneSet = true;
                    }
                    if (System.currentTimeMillis() - time >= 4000) {
                        getStage().setScene(Menu.getInstance().getScene());
                        stop();
                    }
                }
            };
            animationTimer.start();
        }
    }

    public void addKeys() {
        GridPane pane = new GridPane();
        root.setBottom(pane);
        for (int i = 0, k = 0; i < 13; i++) {
            for (int j = 0; j < 2; j++, k++) {
                Button button = new Button(Character.toString(65 + k));
                pane.add(button, i, j);
                button.setOnAction(e -> {
                    if (!end) {
                        doing(button.getText());
                    }
                });
            }
        }
        pane.setHgap(5);
        pane.setVgap(5);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(0, 0, 100, 0));
    }

    public void settingButtons() {
        BorderPane borderPane = new BorderPane();
        Button back = new Button(" Back ");
        Button settings = Helper.gameButton("", "settings", 360, 150);
        back.setOnAction(e -> getStage().setScene(Menu.getInstance().getScene()));
        settings.setOnAction(e -> Settings.getInstance().makeStage());
        borderPane.setLeft(back);
        borderPane.setRight(settings);
        root.setTop(borderPane);

    }

    private void animation(int index) {
        try {
            root.setLeft(new ImageView(new Image(new FileInputStream(
                    url + +index + ".png"), 300, 350, false, false)));
        } catch (IOException ignored) {
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

    public Scene getScene() {
        return scene;
    }
}
