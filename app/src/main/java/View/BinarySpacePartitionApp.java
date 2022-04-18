package View;

import java.io.File;

import BSP.BinarySpacePartitionTree;
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
    public static Figure figure;
    protected static String fileDirectory;
    protected static BinarySpacePartitionTree bsp;

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
        launch(args);
    }

    public static Scene getScene() {
        return scene;
    }

    public static void switchScene(Parent switchScene) {
        stage.getScene().setRoot(switchScene);
    }

    public static void ResetFigure() {
        figure = null;
        switchScene(new HomePage());
    }

    public static void Read() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Ouvrir un fichier Texte (Txt)");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("TEXT", "*.txt"));
        File reader = fileChooser.showOpenDialog(stage.getScene().getWindow());
        if (reader != null) {
            //Methode de construction pas fonctionnelle
            //Boucle probable du à la récursivité
            bsp = new BinarySpacePartitionTree(reader.getAbsolutePath());
            BinarySpacePartitionApp.switchScene(new GraphicsOptions());
        } else {
            System.out.println("error"); // or something else
        }
    }

    public String getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(String fileDirectory) {
        fileDirectory = fileDirectory;
    }
}
