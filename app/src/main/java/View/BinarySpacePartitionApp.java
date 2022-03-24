package View;

import java.io.File;

import ReaderFile.ReaderFile;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BinarySpacePartitionApp extends Application {
    private static Stage stage;
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        stage.setFullScreenExitHint("");

        scene = new Scene(new HomePage());

        primaryStage.setScene(scene);

        primaryStage.setMinWidth(1080.);
        primaryStage.setMinHeight(720.);
        primaryStage.setTitle("Binary Space Partition");

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static Scene getScene() {
        return scene;
    }

    public static void switchScene(Parent switchScene) {
        stage.getScene().setRoot(switchScene);
    }

    public static void Read() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Upload File Path");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TEXT", "*.txt"));
        File reader = fileChooser.showOpenDialog(stage.getScene().getWindow());
        if (reader != null) {
            ReaderFile readerFile = new ReaderFile(reader.getAbsolutePath());
            System.out.println(readerFile);
        } else {
            System.out.println("error"); // or something else
        }
    }
}
