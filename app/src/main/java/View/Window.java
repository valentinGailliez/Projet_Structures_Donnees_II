package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class Window extends StackPane {
    protected Button homeButton, fileButton, schemeButton, infoButton;

    public Window() {
        homeButton = new Button();
        homeButton.setText("Menu Principal");
        fileButton = new Button();
        fileButton.setText("Fichier");
        schemeButton = new Button();
        schemeButton.setText("Visionner le BSP");
        infoButton = new Button();
        infoButton.setText("Info");

        homeButton.setMaxWidth(Double.MAX_VALUE);
        fileButton.setMaxWidth(Double.MAX_VALUE);
        schemeButton.setMaxWidth(Double.MAX_VALUE);

        HBox hboxButton = new HBox();
        hboxButton.setAlignment(Pos.TOP_LEFT);
        HBox.setHgrow(homeButton, Priority.ALWAYS);
        HBox.setHgrow(fileButton, Priority.ALWAYS);
        HBox.setHgrow(schemeButton, Priority.ALWAYS);
        HBox.setHgrow(infoButton, Priority.ALWAYS);

        hboxButton.getChildren().add(homeButton);
        hboxButton.getChildren().add(fileButton);
        hboxButton.getChildren().add(schemeButton);
        hboxButton.getChildren().add(infoButton);

        this.getChildren().addAll(hboxButton);
        fileButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new FilePage()));
        homeButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new HomePage()));
        schemeButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new GraphicsPage()));
        infoButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new InfoPage()));
    }
}
