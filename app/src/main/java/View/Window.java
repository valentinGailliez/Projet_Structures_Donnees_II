package View;

import java.io.File;

import ReaderFile.ReaderFile;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Window extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	public Window() {
		super();
		// TODO Auto-generated constructor stub

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Button button = new Button();
		button.setText("Open a New Window");

		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Upload File Path");
				fileChooser.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter("TEXT", "*.txt"));
				File reader = fileChooser.showOpenDialog(primaryStage.getScene().getWindow());
				if (reader != null) {
					ReaderFile readerFile = new ReaderFile(reader.getAbsolutePath());
					System.out.println(readerFile);
				} else {
					System.out.println("error"); // or something else
				}
			}
		});

		StackPane root = new StackPane();
		root.getChildren().add(button);

		Scene scene = new Scene(root, 450, 250);

		primaryStage.setTitle("JavaFX Open a new Window (o7planning.org)");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
