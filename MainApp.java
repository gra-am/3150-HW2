package org.openjfx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.Random;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        doUI(stage);
    }

    public void doUI(Stage stage) {

        HBox textBox = new HBox(5);
        textBox.setPadding(new Insets(10));
        textBox.setAlignment(Pos.BASELINE_RIGHT);

        Button txtBtn = new Button("Convert to Bin");
        TextField txtNameField = new TextField();
        Label txtID= new Label(".txt file name:");

        textBox.getChildren().addAll(txtID, txtNameField, txtBtn);

        HBox binBox = new HBox(5);
        binBox.setPadding(new Insets(10));
        binBox.setAlignment(Pos.BASELINE_RIGHT);

        Button binBtn = new Button ("Convert to Txt");
        TextField binNameField = new TextField();
        Label binID = new Label(".bin file name:");

        binBox.getChildren().addAll(binID, binNameField, binBtn);

        AnchorPane anchor = new AnchorPane();
        anchor.getChildren().addAll(textBox, binBox);

        AnchorPane.setRightAnchor(textBox, 10d);
        AnchorPane.setBottomAnchor(textBox, 10d);

        AnchorPane.setRightAnchor(binBox, 10d);
        AnchorPane.setTopAnchor(binBox, 10d);

        Scene scene = new Scene(anchor, 400, 115);
        stage.setTitle("txt to bin");
        stage.setScene(scene);
        stage.show();

        FileConverter fc = new FileConverter();

        EventHandler<ActionEvent> txtBtnEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                //check if valid file name
                fc.txtToBin(txtNameField.getText());
            }
        };

        EventHandler<ActionEvent> binBtnEvent = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e)
            {
                //check if valid file name
                fc.binToTxt(binNameField.getText());
            }
        };

        txtBtn.setOnAction(txtBtnEvent);
        binBtn.setOnAction(binBtnEvent);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
