package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class GeneratePainters extends Window {
    private Label welcomeLabel;

    public GeneratePainters() {
        this.welcomeLabel = new Label();
        welcomeLabel.setText("Generer le graphique");

        welcomeLabel.setStyle("-fx-font: 24 arial;");
        welcomeLabel.setAlignment(Pos.TOP_CENTER);

        this.getChildren().add(welcomeLabel);
    }

    public Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public void setWelcomeLabel(Label welcomeLabel) {
        this.welcomeLabel = welcomeLabel;
    }
}
