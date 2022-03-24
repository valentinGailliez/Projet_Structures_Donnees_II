package View;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;

public class HomePage extends StackPane {
	private Label welcomeLabel;
	private Button homeButton, fileButton, schemeButton;

	public HomePage() {
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
		homeButton.setDisable(true);
		this.welcomeLabel = new Label();
		welcomeLabel.setText("Bienvenue sur Binary Space Partition");
		welcomeLabel.setStyle("-fx-font: 24 arial;");

		fileButton.setOnAction(event -> BinarySpacePartitionApp.switchScene(new FileView()));
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
