package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class GraphicsPage extends Window {
    private Label welcomeLabel;

    public GraphicsPage() {
        super();

        schemeButton.setDisable(true);
        this.welcomeLabel = new Label();
        welcomeLabel.setText("Graphique");
        welcomeLabel.setStyle("-fx-font: 24 arial;");

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(getWelcomeLabel());

        this.getChildren().add(welcomeLabel);
    }

    public Label getWelcomeLabel() {
        return welcomeLabel;
    }

    public void setWelcomeLabel(Label welcomeLabel) {
        this.welcomeLabel = welcomeLabel;
    }
}
