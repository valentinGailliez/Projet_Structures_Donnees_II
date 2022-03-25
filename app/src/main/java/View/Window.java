package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class Window extends StackPane {
    protected Button homeButton, fileButton, schemeButton;

    public Window() {
        homeButton = new Button();
        homeButton.setText("Menu Principal");
        fileButton = new Button();
        fileButton.setText("Fichier");
        schemeButton = new Button();
        schemeButton.setText("Visionner le BSP");

        homeButton.setMaxWidth(Double.MAX_VALUE);
        fileButton.setMaxWidth(Double.MAX_VALUE);
        schemeButton.setMaxWidth(Double.MAX_VALUE);

        HBox hboxButton = new HBox();
        hboxButton.setAlignment(Pos.TOP_LEFT);
        HBox.setHgrow(homeButton, Priority.ALWAYS);
        HBox.setHgrow(fileButton, Priority.ALWAYS);
        HBox.setHgrow(schemeButton, Priority.ALWAYS);

        hboxButton.getChildren().add(homeButton);
        hboxButton.getChildren().add(fileButton);
        hboxButton.getChildren().add(schemeButton);

        this.getChildren().addAll(hboxButton);
        fileButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new FileView()));
        homeButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new HomePage()));

        schemeButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new GraphicsPage()));
    }
}
