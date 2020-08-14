package ir.codekeshs;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

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

    public static Button gameButton(String s, String imageName, int x, int y) {
        Image image = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/button-images/" + imageName + ".png"),
                    40, 40, false, false);
        } catch (FileNotFoundException ignored) {
        }
        Button button = new Button(s, new ImageView(image));
        button.setShape(new Circle(20));
        button.setLayoutX(x);
        button.setLayoutY(y);
        return button;
    }

    public static Text gameText(String s, int size, int x, int y, Paint paint) {
        Text text = new Text(s);
        text.setX(x);
        text.setY(y);
        text.setFill(paint);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, size));
        return text;
    }

    public static Background gameBG(String imageName, int x, int y) {
        Image image = null;
        try {
            image = new Image(new FileInputStream("src/main/resources/backgrounds/" + imageName + ".jpg"),
                    x, y, false, false);
        } catch (FileNotFoundException ignored) {
        }
        assert image != null;
        BackgroundImage bg = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT, null);
        return new Background(bg);
    }

    public static Pane gamePane() {
        Pane root = new Pane();
        root.setStyle("-fx-border-width: 0 0 5 0;");
        return root;
    }

    public static String getCat(int name) {
        List<String> cat = new ArrayList<>();
        try (Scanner scanner = new Scanner(new BufferedReader(
                new FileReader("src/main/resources/file/" + name + ".txt")))) {
            while (scanner.hasNextLine()) {
                cat.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cat.get(new Random().nextInt(cat.size()));
    }

}
