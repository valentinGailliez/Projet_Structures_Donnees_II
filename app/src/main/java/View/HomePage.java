package View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class HomePage extends Window {
	private Label welcomeLabel;

	public HomePage() {
		this.welcomeLabel = new Label();
		welcomeLabel.setText("Bienvenue sur Binary Space Partition");
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
