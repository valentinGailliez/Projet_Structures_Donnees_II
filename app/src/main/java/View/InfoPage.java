package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextAlignment;

public class InfoPage extends Window {
    private Label infoLabel;

    public InfoPage() {
        super();
        infoButton.setDisable(true);
        this.infoLabel = new Label();
        infoLabel.setText(
                "Application développé\nDans le cadre du projet de Structures de données II par\nValentin Gailliez\nLinda Tatchou");
        infoLabel.setStyle("-fx-font: 24 arial;");
        infoLabel.setTextAlignment(TextAlignment.CENTER);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(getInfoLabel());

        this.getChildren().add(infoLabel);
    }

    public Label getInfoLabel() {
        return infoLabel;
    }

    public void setInfoLabel(Label infoLabel) {
        this.infoLabel = infoLabel;
    }
}
