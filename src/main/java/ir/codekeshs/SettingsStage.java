package ir.codekeshs;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class SettingsStage {


    public SettingsStage(){
        Stage settings = new Stage();
        settings.initModality(Modality.APPLICATION_MODAL);
        settings.setTitle("Settings");
        Pane root = Helper.gamePane();
        Scene scene = new Scene(root,200,200);
        settings.setScene(scene);
        settings.showAndWait();
    }

}
