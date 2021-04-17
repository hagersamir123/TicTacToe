package ui;

import helperclasses.Music;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ladders.BoardUI;
import tictactoe.TicTacToe;
import static tictactoe.TicTacToe.scenes;
/**
 *
 * @author Asmaa Elbanaa
 */
public class ChooseGame extends AnchorPane {

    protected final ImageView imageView;
    protected final ImageView imageView0;
    protected final Button btnTicTacToe;
    protected final Button btnSnakers;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final Button btnLogOut;
    protected final ImageView imageView1;

    private String name;

    public ChooseGame(String name) {
        this.name = name;

        imageView = new ImageView();
        imageView0 = new ImageView();
        btnTicTacToe = new Button();
        btnSnakers = new Button();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        btnLogOut = new Button();
        imageView1 = new ImageView();

        setId("AnchorPane");
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStylesheets().add("/resources/css/style.css");

        imageView.setFitHeight(250.0);
        imageView.setFitWidth(250.0);
        imageView.setLayoutX(80.0);
        imageView.setLayoutY(119.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/imgs/xo.jpeg").toExternalForm()));

        imageView0.setFitHeight(250.0);
        imageView0.setFitWidth(250.0);
        imageView0.setLayoutX(439.0);
        imageView0.setLayoutY(119.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/resources/imgs/snakerrs.jpeg").toExternalForm()));

        btnTicTacToe.setLayoutX(75.0);
        btnTicTacToe.setLayoutY(395.0);
        btnTicTacToe.setMnemonicParsing(false);
        btnTicTacToe.setPrefHeight(50.0);
        btnTicTacToe.setPrefWidth(260.0);
        btnTicTacToe.getStyleClass().add("btn");
        btnTicTacToe.setText("TIC TAC TOE");
        btnTicTacToe.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        btnTicTacToe.setFont(new Font("System Bold", 21.0));

        btnSnakers.setLayoutX(432.0);
        btnSnakers.setLayoutY(395.0);
        btnSnakers.setMnemonicParsing(false);
        btnSnakers.setPrefHeight(50.0);
        btnSnakers.setPrefWidth(260.0);
        btnSnakers.getStyleClass().add("btn");
        btnSnakers.setText("SHUTES AND LEADERS");
        btnSnakers.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        btnSnakers.setFont(new Font("System Bold", 21.0));

        gridPane.setLayoutX(10.0);
        gridPane.setLayoutY(10.0);
        gridPane.setPrefHeight(51.0);
        gridPane.setPrefWidth(785.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btnLogOut, javafx.geometry.HPos.RIGHT);
        GridPane.setValignment(btnLogOut, javafx.geometry.VPos.CENTER);
        btnLogOut.setMnemonicParsing(false);
        btnLogOut.setPrefHeight(40.0);
        btnLogOut.setPrefWidth(66.0);
        btnLogOut.getStyleClass().add("backbtn");

        imageView1.setFitHeight(32.0);
        imageView1.setFitWidth(33.0);
        imageView1.setPickOnBounds(true);
        imageView1.setPreserveRatio(true);
        imageView1.setImage(new Image(getClass().getResource("/resources/imgs/logout.png").toExternalForm()));
        btnLogOut.setGraphic(imageView1);

        getChildren().add(imageView);
        getChildren().add(imageView0);
        getChildren().add(btnTicTacToe);
        getChildren().add(btnSnakers);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(btnLogOut);
        getChildren().add(gridPane);

        setActions();
    }

    private void setActions() {
        btnTicTacToe.setOnAction((event) -> {
            new Music("btn.mp3", false);
            Stage stage = TicTacToe.primaryStage;
            stage.setTitle("Tic Tac Toe");
            MainPage mainPage = new MainPage(name);
            stage.setScene(new Scene(mainPage));
            scenes.push(this.getScene());
        });

        btnSnakers.setOnAction((event) -> {
            new Music("btn.mp3", false);
            Stage stage = TicTacToe.primaryStage;
            stage.setTitle("Ladders And Snakes");
            stage.setScene(new Scene(new BoardUI(name)));
            scenes.push(this.getScene());
        });

        btnLogOut.setOnAction((event) -> {
            new Music("logout.mp3", false);
            Login login = new Login();
            TicTacToe.primaryStage.setTitle("Login");
            tictactoe.TicTacToe.primaryStage.setScene(new Scene(login));
            tictactoe.TicTacToe.scenes.clear();
            database.DBLayer.ID = 0;
            database.DBLayer.username = null;
            if(files.ConfigFile.file.exists()){
                files.ConfigFile.file.delete();
            }
        });
    }
}
