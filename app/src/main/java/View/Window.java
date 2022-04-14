package View;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Window extends StackPane {

    public Window() {
        Menu home = new Menu("Home");
        MenuItem closeApp = new MenuItem("Close");
        MenuItem infoApp = new MenuItem("Info");

        home.getItems().addAll(closeApp, infoApp);

        Menu file = new Menu("Scene File");
        MenuItem openFile = new MenuItem("Open a file");
        MenuItem closeFile = new MenuItem("Close the file");
        file.getItems().addAll(openFile, closeFile);

        Menu graphic = new Menu("Graphics");
        MenuItem viewGraphic = new MenuItem("View Graphic");
        graphic.getItems().addAll(viewGraphic);

        if (BinarySpacePartitionApp.getFigure() == null) {
            graphic.setDisable(true);
        } else {
            openFile.setDisable(true);
        }

        MenuBar mb = new MenuBar();

        // add menu to menubar
        mb.getMenus().addAll(home, file, graphic);

        // create a VBox
        VBox vb = new VBox(mb);
        this.getChildren().add(vb);

        closeApp.setOnAction(event -> BinarySpacePartitionApp.close());
        openFile.setOnAction(event -> BinarySpacePartitionApp.Read());
        closeFile.setOnAction(event -> BinarySpacePartitionApp.ResetFigure());
        infoApp.setOnAction(event -> BinarySpacePartitionApp.switchScene(new InfoPage()));
        viewGraphic.setOnAction(event -> BinarySpacePartitionApp.switchScene(new GraphicsPage()));
    }

}
