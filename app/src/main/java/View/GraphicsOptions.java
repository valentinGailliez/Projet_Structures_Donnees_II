package View;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GraphicsOptions extends Window {
    private Label graphicsOptionsLabel, positionView, errorPosition;
    private TextField xPosition, yPosition;

    public GraphicsOptions() {
        this.graphicsOptionsLabel = new Label();
        graphicsOptionsLabel.setText("Generer le graphique");

        HBox title = new HBox();
        HBox view = new HBox();
        HBox error = new HBox();
        HBox position = new HBox();
        graphicsOptionsLabel.setStyle("-fx-font: 24 arial;");
        graphicsOptionsLabel.setAlignment(Pos.TOP_CENTER);
        errorPosition = new Label();
        errorPosition.setText("ATTENTION! UNIQUEMENT DES NOMBRES");
        errorPosition.setTextFill(Color.web("#FF0000"));
        errorPosition.setAlignment(Pos.BOTTOM_CENTER);
        xPosition = new TextField();
        yPosition = new TextField();
        positionView = new Label("Insérer la position de la vue");
        positionView.setStyle("-fx-font: 24 arial;");
        positionView.setAlignment(Pos.CENTER);

        xPosition.textProperty().addListener((observable, oldValue, newValue) -> {
            error.getChildren().remove(errorPosition);
            if (!checkIfNumber(newValue)) {
                error.getChildren().add(errorPosition);
            }

        });
        title.getChildren().addAll(graphicsOptionsLabel);
        view.getChildren().addAll(positionView);
        position.getChildren().addAll(xPosition, yPosition);

        VBox vbox = new VBox(title, view, error, position);
        vbox.setAlignment(Pos.CENTER);

        vbox.setPadding(new Insets(50., 0., 0., 50.));

        this.getChildren().addAll(vbox);

    }

    private boolean checkIfNumber(String text) {
        if (text.matches("[+-]?\\d*(\\.\\d+)?") || text == "") {
            return true;
        }
        return false;

    }

    public Label getGraphicsOptionsLabel() {
        return graphicsOptionsLabel;
    }

    public void setGraphicsOptionsLabel(Label graphicsOptionsLabel) {
        this.graphicsOptionsLabel = graphicsOptionsLabel;
    }
}
