package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class FileView extends StackPane {
    private Button homeButton, fileButton, schemeButton;
    private Label chargerFichier;

    public FileView() {
        super();
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
        fileButton.setDisable(true);
        this.chargerFichier = new Label();
        chargerFichier.setText("Veuillez charger un fichier txt");
        chargerFichier.setStyle("-fx-font: 24 arial;");

        homeButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new HomePage()));
        HBox hboxLabel = new HBox();

        hboxLabel.setAlignment(Pos.CENTER);
        chargerFichier.setAlignment(Pos.TOP_CENTER);

        hboxLabel.getChildren().addAll(chargerFichier);

        HBox hboxButtonCharge = new HBox();
        hboxButtonCharge.setAlignment(Pos.BOTTOM_CENTER);
        Button charge = new Button();
        charge.setText("Open a New Window");
        charge.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BinarySpacePartitionApp.Read();
            }
        });
        hboxButtonCharge.getChildren().add(charge);
        HBox.setMargin(charge, new Insets(50., 50., 50., 50.));
        this.getChildren().addAll(hboxLabel, hboxButtonCharge);
    }
}
