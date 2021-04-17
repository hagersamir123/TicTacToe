package ui;

import helperclasses.Music;
import helperclasses.Result;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import minmax.Move;
import tictactoe.TicTacToe;
/**
 *
 * @author Hager Samer
 */
public class Item extends AnchorPane {

    protected final Button btnShow;
    protected final Label txtNum;
    protected final Label txtXO;
    protected final Label txtTime;
    protected final Label txtAgainst;
    protected final Label txtWinLose;

    public Item(int counter, Result result) {

        btnShow = new Button();
        txtNum = new Label();
        txtXO = new Label();
        txtTime = new Label();
        txtAgainst = new Label();
        txtWinLose = new Label();

        setId("AnchorPane");
        setMaxHeight(70.0);
        setMinHeight(70.0);
        setPrefHeight(70.0);
        setPrefWidth(750.0);
        getStylesheets().add("/resources/css/style.css");

        btnShow.setLayoutX(636.0);
        btnShow.setLayoutY(17.0);
        btnShow.setMnemonicParsing(false);
        btnShow.setPrefHeight(30.0);
        btnShow.setPrefWidth(100.0);
        btnShow.getStyleClass().add("btn");
        btnShow.setText("Show");

        txtNum.setAlignment(javafx.geometry.Pos.CENTER);
        txtNum.setLayoutX(6.0);
        txtNum.setLayoutY(20.0);
        txtNum.setPrefWidth(35.0);
        txtNum.setText("N");
        txtNum.setTextFill(javafx.scene.paint.Color.valueOf("#494b4d"));
        txtNum.setFont(new Font(21.0));

        txtXO.setAlignment(javafx.geometry.Pos.CENTER);
        txtXO.setLayoutX(68.0);
        txtXO.setLayoutY(20.0);
        txtXO.setPrefHeight(31.0);
        txtXO.setPrefWidth(35.0);
        txtXO.setText("XO");
        txtXO.setTextFill(javafx.scene.paint.Color.valueOf("#494b4d"));
        txtXO.setFont(new Font(21.0));

        txtTime.setAlignment(javafx.geometry.Pos.CENTER);
        txtTime.setLayoutX(130.0);
        txtTime.setLayoutY(20.0);
        txtTime.setPrefHeight(31.0);
        txtTime.setPrefWidth(120.0);
        txtTime.setText("Time");
        txtTime.setTextFill(javafx.scene.paint.Color.valueOf("#494b4d"));
        txtTime.setFont(new Font(21.0));

        txtAgainst.setAlignment(javafx.geometry.Pos.CENTER);
        txtAgainst.setLayoutX(275.0);
        txtAgainst.setLayoutY(20.0);
        txtAgainst.setPrefHeight(31.0);
        txtAgainst.setPrefWidth(200.0);
        txtAgainst.setText("Against");
        txtAgainst.setTextFill(javafx.scene.paint.Color.valueOf("#494b4d"));
        txtAgainst.setFont(new Font(21.0));

        txtWinLose.setAlignment(javafx.geometry.Pos.CENTER);
        txtWinLose.setLayoutX(503.0);
        txtWinLose.setLayoutY(22.0);
        txtWinLose.setPrefHeight(21.0);
        txtWinLose.setPrefWidth(105.0);
        txtWinLose.setText("Win");
        txtWinLose.setTextFill(javafx.scene.paint.Color.valueOf("#494b4d"));
        txtWinLose.setFont(new Font(21.0));

        getChildren().add(btnShow);
        getChildren().add(txtNum);
        getChildren().add(txtXO);
        getChildren().add(txtTime);
        getChildren().add(txtAgainst);
        getChildren().add(txtWinLose);

        txtNum.setText("" + counter);
        txtXO.setText(result.XO);
        txtTime.setText(result.time);
        txtAgainst.setText(result.friendName);
        txtWinLose.setText((result.isWin == null ? "Tie" : (result.isWin ? "Win" : "Lose")));

        btnShow.setOnAction((event) -> {
            new Music("btn.mp3", false);
            Stage stage = tictactoe.TicTacToe.primaryStage;
            stage.setTitle("Show result (Me VS " + result.friendName + ")");
            // Board(String player2, boolean isMyTurn, String board, Move p1PlayWith)
            Board board = new Board(result.friendName, result.isFirst, result.board, (result.XO == Move.O.toString() ? Move.O : Move.X));
            tictactoe.TicTacToe.scenes.add(this.getScene());
            stage.setScene(new Scene(board));
        });

    }
}
