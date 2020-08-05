package ir.codekeshs;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public final class Helper {

    public static Button gameButton(String s, int x, int y) {
        Button button = new Button(s);
        button.setLayoutX(x);
        button.setLayoutY(y);
        button.setStyle("-fx-font: 22 arial; -fx-base: #b6e7c9;");
        return button;
    }

    public static Button gameButton(String s, String imageName,int x,int y) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src/main/resources/button-images/" + imageName + ".png"),
                40,40,false,false);
        Button button = new Button(s, new ImageView(image));
        button.setShape(new Circle(20));
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
    }

    public static Background gameBG(String imageName, int x, int y) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("src/main/resources/backgrounds/" + imageName + ".jpg"),
                x, y, false, false);
        BackgroundImage bg = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, null);
        return new Background(bg);
    }

    public static Pane gamePane() {
        Pane root = new Pane();
        root.setStyle("-fx-border-width: 0 0 5 0;");
        return root;
    }

    public static Button getButton(int row, int column, GridPane root) {
        for (Node node : root.getChildren()) {
            if (GridPane.getRowIndex(node) == row && GridPane.getColumnIndex(node) == column) {
                return (Button) node;
            }
        }
        return null;
    }

    public static String getCat(String name) {
        List<String> cat = new ArrayList<>();
        try (
                Scanner scanner = new Scanner(new BufferedReader
                        (new FileReader("src/main/resources/file/" + name + ".txt")));
        ) {
            while (scanner.hasNext()) {
                cat.add(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cat.get(new Random().nextInt(cat.size()));
    }
}
