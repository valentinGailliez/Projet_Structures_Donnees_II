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
    private Button resetFigure, charge;

    public FilePage() {
        fileButton.setDisable(true);

        if (BinarySpacePartitionApp.getFigure() == null) {
            this.chargerFichier = new Label();
            chargerFichier.setText("Veuillez charger un fichier texte (Txt)");
            chargerFichier.setStyle("-fx-font: 24 arial;");

            HBox hboxLabel = new HBox();

            hboxLabel.setAlignment(Pos.CENTER);
            chargerFichier.setAlignment(Pos.TOP_CENTER);

            hboxLabel.getChildren().addAll(chargerFichier);

            HBox hboxButtonCharge = new HBox();
            hboxButtonCharge.setAlignment(Pos.BOTTOM_CENTER);
            charge = new Button();
            charge.setText("Ouvrir un fichier");
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
        } else {
            HBox hboxButtonReset = new HBox();
            hboxButtonReset.setAlignment(Pos.BOTTOM_CENTER);
            resetFigure = new Button();
            resetFigure.setText("Reset the Figure");
            resetFigure.setStyle("-fx-font: 24 arial;");
            resetFigure.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    BinarySpacePartitionApp.ResetFigure();
                }
            });
            hboxButtonReset.getChildren().add(resetFigure);
            HBox.setMargin(resetFigure, new Insets(50., 50., 50., 50.));
            this.getChildren().addAll(hboxButtonReset);

        }
    }
}
