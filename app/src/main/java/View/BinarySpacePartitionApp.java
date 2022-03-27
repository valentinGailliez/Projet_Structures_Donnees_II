package View;

import java.io.File;

import Model.Figure;
import ReaderFile.ReaderFile;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class BinarySpacePartitionApp extends Application {
    public static Stage stage;
    private static Scene scene;
    private static Figure figure;
    private static String[] info;

    @Override
    public void start(Stage primaryStage) throws Exception {
        figure = null;
        stage = primaryStage;

        stage.setFullScreenExitHint("");
        stage.setMaximized(true);
        stage.setResizable(false);
        scene = new Scene(new HomePage());

        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Binary Space Partition");

        stage.show();

    }

    public static String[] openInfoPopup() {
        return info;
    }

    public static void close() {
        stage.close();
    }

    public static Figure getFigure() {
        return figure;
    }

    public static void setFigure(Figure figure) {
        BinarySpacePartitionApp.figure = figure;
    }

    public static void main(String[] args) {
        info = args;
        launch(info);
    }

    public static Scene getScene() {
        return scene;
    }

    public static void switchScene(Parent switchScene) {
        stage.getScene().setRoot(switchScene);
    }

    public static void ResetFigure() {
        figure = null;
        switchScene(new FilePage());
    }

    public static void Read() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ouvrir un fichier Texte (Txt)");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TEXT", "*.txt"));
        File reader = fileChooser.showOpenDialog(stage.getScene().getWindow());
        if (reader != null) {
            ReaderFile readerFile = new ReaderFile(reader.getAbsolutePath());
            setFigure(readerFile.getFigure());
            BinarySpacePartitionApp.switchScene(new GraphicsPage());
        } else {
            System.out.println("error"); // or something else
        }
    }
}
