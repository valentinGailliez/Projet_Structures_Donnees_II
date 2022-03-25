package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class FilePage extends Window {
    private Label chargerFichier;

    public FilePage() {
        super();
        fileButton.setDisable(true);

        this.chargerFichier = new Label();
        chargerFichier.setText("Veuillez charger un fichier txt");
        chargerFichier.setStyle("-fx-font: 24 arial;");

        HBox hboxLabel = new HBox();

        hboxLabel.setAlignment(Pos.CENTER);
        chargerFichier.setAlignment(Pos.TOP_CENTER);

        hboxLabel.getChildren().addAll(chargerFichier);

        HBox hboxButtonCharge = new HBox();
        hboxButtonCharge.setAlignment(Pos.BOTTOM_CENTER);
        Button charge = new Button();
        charge.setText("Open a New Window");
        charge.setStyle("-fx-font: 24 arial;");
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
