package ui;

import helperclasses.Music;
import helperclasses.Result;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import tictactoe.TicTacToe;
/**
 *
 * @author Hager Samer
 */
public class ShowResults extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button btnBack;
    protected final ImageView imageView;
    protected final AnchorPane anchorPane;
    protected final Label label;
    protected final Label label0;
    protected final Label label1;
    protected final Label label2;
    protected final Label label3;
    protected final Label label4;
    protected final ListView lvResults;

    public ShowResults(List<Result> myResults) {

        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        btnBack = new Button();
        imageView = new ImageView();
        anchorPane = new AnchorPane();
        label = new Label();
        label0 = new Label();
        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        lvResults = new ListView();
        getStylesheets().add("/resources/css/style.css");

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(550.0);
        setPrefWidth(780.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(50.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMaxHeight(60.0);
        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(40.0);
        btnBack.setPrefWidth(66.0);
        btnBack.getStyleClass().add("backbtn");

        imageView.setFitHeight(23.0);
        imageView.setFitWidth(31.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/imgs/back.png").toExternalForm()));
        btnBack.setGraphic(imageView);
        GridPane.setMargin(btnBack, new Insets(0.0, 0.0, 0.0, 5.0));

        GridPane.setHalignment(anchorPane, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(anchorPane, 1);
        GridPane.setValignment(anchorPane, javafx.geometry.VPos.CENTER);
        anchorPane.setId("AnchorPane");
        anchorPane.setMaxHeight(70.0);
        anchorPane.setPrefHeight(60.0);
        anchorPane.setPrefWidth(750.0);
        anchorPane.getStylesheets().add("/resources/css/style.css");

        label.setAlignment(javafx.geometry.Pos.CENTER);
        label.setLayoutX(14.0);
        label.setLayoutY(17.0);
        label.setPrefWidth(35.0);
        label.setText("N");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label.setFont(new Font("System Bold", 21.0));

        label0.setAlignment(javafx.geometry.Pos.CENTER);
        label0.setLayoutX(76.0);
        label0.setLayoutY(17.0);
        label0.setPrefHeight(31.0);
        label0.setPrefWidth(35.0);
        label0.setText("X/O");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label0.setFont(new Font("System Bold", 18.0));

        label1.setAlignment(javafx.geometry.Pos.CENTER);
        label1.setLayoutX(137.0);
        label1.setLayoutY(17.0);
        label1.setPrefHeight(31.0);
        label1.setPrefWidth(120.0);
        label1.setText("Time");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label1.setFont(new Font("System Bold", 18.0));

        label2.setAlignment(javafx.geometry.Pos.CENTER);
        label2.setLayoutX(281.0);
        label2.setLayoutY(17.0);
        label2.setPrefHeight(31.0);
        label2.setPrefWidth(200.0);
        label2.setText("Against");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label2.setFont(new Font("System Bold", 18.0));

        label3.setAlignment(javafx.geometry.Pos.CENTER);
        label3.setLayoutX(506.0);
        label3.setLayoutY(19.0);
        label3.setPrefHeight(21.0);
        label3.setPrefWidth(105.0);
        label3.setText("Result");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label3.setFont(new Font("System Bold", 18.0));

        label4.setAlignment(javafx.geometry.Pos.CENTER);
        label4.setLayoutX(647.0);
        label4.setLayoutY(19.0);
        label4.setPrefHeight(21.0);
        label4.setPrefWidth(105.0);
        label4.setText("Show");
        label4.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label4.setFont(new Font("System Bold", 18.0));

        GridPane.setRowIndex(lvResults, 2);
        lvResults.setPrefHeight(300.0);
        lvResults.setPrefWidth(770.0);
        GridPane.setMargin(lvResults, new Insets(10.0, 0.0, 0.0, 0.0));

        getColumnConstraints().add(columnConstraints);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getChildren().add(btnBack);
        anchorPane.getChildren().add(label);
        anchorPane.getChildren().add(label0);
        anchorPane.getChildren().add(label1);
        anchorPane.getChildren().add(label2);
        anchorPane.getChildren().add(label3);
        anchorPane.getChildren().add(label4);
        getChildren().add(anchorPane);
        getChildren().add(lvResults);

        int counter = 1;
        for (Result result : myResults) {
            this.lvResults.getItems().add(new Item(counter, result));
            counter++;
        }

        btnBack.setOnAction((event) -> {
            new Music("back.mp3", false);
            TicTacToe.primaryStage.setTitle("Main Page");
            tictactoe.TicTacToe.primaryStage.setScene(tictactoe.TicTacToe.scenes.pop());
        });
    }
}
