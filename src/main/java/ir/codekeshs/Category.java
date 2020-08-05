package ir.codekeshs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class Category {
    private final String url;
    private String chosen;

    public Category() {
        url = "src/main/resources/categories/";
    }

    public void start() {
        Pane pane = new Pane();
        SceneParent.getStage().setScene(new Scene(pane, 800, 600, Color.rgb(250, 240, 240)));
        GridPane root = new GridPane();
        root.setHgap(10);
        root.setVgap(10);
        pane.getChildren().add(root);
        pane.setLayoutX(200);
        pane.setLayoutY(150);
        makeButtons(root);
        choose(root);
    }

    private void makeButtons(GridPane root) {
        try {
            Button animal = new Button("", new ImageView(new Image(new FileInputStream(url + "animal.png"))));
            Button countries = new Button("", new ImageView(new Image(new FileInputStream(url + "countries.png"))));
            Button sport = new Button("", new ImageView(new Image(new FileInputStream(url + "sport.png"))));
            Button things = new Button("", new ImageView(new Image(new FileInputStream(url + "things.png"))));
            root.add(animal, 0, 0);
            root.add(countries, 0, 1);
            root.add(sport, 1, 0);
            root.add(things, 1, 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void choose(GridPane root) {
        Objects.requireNonNull(Helper.getButton(0, 0, root)).setOnAction(e -> {
            System.out.println(Helper.getCat("animal"));
        });
        Objects.requireNonNull(Helper.getButton(1, 0, root)).setOnAction(e -> {
            System.out.println(Helper.getCat("country"));
        });
        Objects.requireNonNull(Helper.getButton(0, 1, root)).setOnAction(e -> {
            System.out.println(Helper.getCat("sport"));

        });
        Objects.requireNonNull(Helper.getButton(1, 1, root)).setOnAction(e -> {
            System.out.println(Helper.getCat("thing"));
        });
    }
}
