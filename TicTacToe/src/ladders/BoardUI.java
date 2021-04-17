package ladders;

import animation.Animation;
import helperclasses.Alerts;
import helperclasses.Music;
import helperclasses.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BoardUI extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final ColumnConstraints columnConstraints6;
    protected final ColumnConstraints columnConstraints7;
    protected final ColumnConstraints columnConstraints8;
    protected final ColumnConstraints columnConstraints9;
    protected final ColumnConstraints columnConstraints10;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final RowConstraints rowConstraints3;
    protected final RowConstraints rowConstraints4;
    protected final RowConstraints rowConstraints5;
    protected final RowConstraints rowConstraints6;
    protected final RowConstraints rowConstraints7;
    protected final RowConstraints rowConstraints8;
    protected final RowConstraints rowConstraints9;
    protected final ImageView imageView;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints11;
    protected final RowConstraints rowConstraints10;
    protected final RowConstraints rowConstraints11;
    protected final RowConstraints rowConstraints12;
    protected final GridPane gridPane1;
    protected final ColumnConstraints columnConstraints12;
    protected final RowConstraints rowConstraints13;
    protected final RowConstraints rowConstraints14;
    protected final RowConstraints rowConstraints15;
    protected final Label lblPlayer2;
    protected final Label label1;
    protected final Label lblPlayer1;
    protected final GridPane gridPane2;
    protected final ColumnConstraints columnConstraints13;
    protected final RowConstraints rowConstraints16;
    protected final RowConstraints rowConstraints17;
    protected final Button btnBack;
    protected final Button btnRestart;
    protected final Button btnRoll;
    protected final ImageView imageView0;
    protected final Circle player1Circle;
    protected final Circle player2Circle;

    protected final Label playerName;

    private int[][] board;
    private List<Position[]> ladders;
    private List<Position[]> snakes;
    private List<Position> steps;
    private String name;

    public BoardUI(String name) {
        this.name = name;
        board = new int[10][10];
        ladders = new ArrayList<>();
        snakes = new ArrayList<>();
        steps = new ArrayList<>();

        ladders.add(new Position[]{new Position(7, 0), new Position(3, 2)});
        ladders.add(new Position[]{new Position(6, 3), new Position(3, 5)});
        ladders.add(new Position[]{new Position(9, 4), new Position(7, 5)});
        ladders.add(new Position[]{new Position(5, 8), new Position(1, 4)});

        snakes.add(new Position[]{new Position(0, 4), new Position(4, 0)});
        snakes.add(new Position[]{new Position(3, 3), new Position(7, 7)});
        snakes.add(new Position[]{new Position(4, 6), new Position(8, 2)});
        snakes.add(new Position[]{new Position(5, 6), new Position(8, 8)});
        snakes.add(new Position[]{new Position(0, 7), new Position(2, 9)});

        player1Circle = new Circle(30, Color.RED);
        player2Circle = new Circle(30, Color.YELLOW);
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        gridPane = new GridPane();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();
        columnConstraints8 = new ColumnConstraints();
        columnConstraints9 = new ColumnConstraints();
        columnConstraints10 = new ColumnConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        rowConstraints3 = new RowConstraints();
        rowConstraints4 = new RowConstraints();
        rowConstraints5 = new RowConstraints();
        rowConstraints6 = new RowConstraints();
        rowConstraints7 = new RowConstraints();
        rowConstraints8 = new RowConstraints();
        rowConstraints9 = new RowConstraints();
        imageView = new ImageView();
        gridPane0 = new GridPane();
        columnConstraints11 = new ColumnConstraints();
        rowConstraints10 = new RowConstraints();
        rowConstraints11 = new RowConstraints();
        rowConstraints12 = new RowConstraints();
        gridPane1 = new GridPane();
        columnConstraints12 = new ColumnConstraints();
        rowConstraints13 = new RowConstraints();
        rowConstraints14 = new RowConstraints();
        rowConstraints15 = new RowConstraints();
        lblPlayer2 = new Label();
        label1 = new Label();
        playerName = new Label();
        lblPlayer1 = new Label();
        gridPane2 = new GridPane();
        columnConstraints13 = new ColumnConstraints();
        rowConstraints16 = new RowConstraints();
        rowConstraints17 = new RowConstraints();
        btnBack = new Button();
        btnRestart = new Button();
        btnRoll = new Button();
        imageView0 = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(700.0);
        setPrefWidth(1000.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(200.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(200.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMaxWidth(80.0);
        columnConstraints1.setMinWidth(80.0);
        columnConstraints1.setPrefWidth(80.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(80.0);
        columnConstraints2.setMinWidth(80.0);
        columnConstraints2.setPrefWidth(80.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(80.0);
        columnConstraints3.setMinWidth(80.0);
        columnConstraints3.setPrefWidth(80.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(80.0);
        columnConstraints4.setMinWidth(80.0);
        columnConstraints4.setPrefWidth(80.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(80.0);
        columnConstraints5.setMinWidth(80.0);
        columnConstraints5.setPrefWidth(80.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMaxWidth(80.0);
        columnConstraints6.setMinWidth(80.0);
        columnConstraints6.setPrefWidth(80.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMaxWidth(80.0);
        columnConstraints7.setMinWidth(80.0);
        columnConstraints7.setPrefWidth(80.0);

        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMaxWidth(80.0);
        columnConstraints8.setMinWidth(80.0);
        columnConstraints8.setPrefWidth(80.0);

        columnConstraints9.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints9.setMaxWidth(80.0);
        columnConstraints9.setMinWidth(80.0);
        columnConstraints9.setPrefWidth(80.0);

        columnConstraints10.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints10.setMaxWidth(80.0);
        columnConstraints10.setMinWidth(80.0);
        columnConstraints10.setPrefWidth(80.0);

        rowConstraints0.setMaxHeight(70.0);
        rowConstraints0.setMinHeight(70.0);
        rowConstraints0.setPrefHeight(70.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(70.0);
        rowConstraints1.setMinHeight(70.0);
        rowConstraints1.setPrefHeight(70.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMaxHeight(70.0);
        rowConstraints2.setMinHeight(70.0);
        rowConstraints2.setPrefHeight(70.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints3.setMaxHeight(70.0);
        rowConstraints3.setMinHeight(70.0);
        rowConstraints3.setPrefHeight(70.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints4.setMaxHeight(70.0);
        rowConstraints4.setMinHeight(70.0);
        rowConstraints4.setPrefHeight(70.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints5.setMaxHeight(70.0);
        rowConstraints5.setMinHeight(70.0);
        rowConstraints5.setPrefHeight(70.0);
        rowConstraints5.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints6.setMaxHeight(70.0);
        rowConstraints6.setMinHeight(70.0);
        rowConstraints6.setPrefHeight(70.0);
        rowConstraints6.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints7.setMaxHeight(70.0);
        rowConstraints7.setMinHeight(70.0);
        rowConstraints7.setPrefHeight(70.0);
        rowConstraints7.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints8.setMaxHeight(70.0);
        rowConstraints8.setMinHeight(70.0);
        rowConstraints8.setPrefHeight(70.0);
        rowConstraints8.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints9.setMaxHeight(70.0);
        rowConstraints9.setMinHeight(70.0);
        rowConstraints9.setPrefHeight(70.0);
        rowConstraints9.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setColumnSpan(imageView, 10);
        GridPane.setHalignment(imageView, javafx.geometry.HPos.CENTER);
        GridPane.setRowSpan(imageView, 10);
        GridPane.setValignment(imageView, javafx.geometry.VPos.CENTER);
        imageView.setFitHeight(700.0);
        imageView.setFitWidth(800.0);
        imageView.setPickOnBounds(true);
        imageView.setImage(new Image(getClass().getResource("/resources/imgs/board.png").toExternalForm()));

        GridPane.setHalignment(player1Circle, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(player1Circle, javafx.geometry.VPos.CENTER);
        GridPane.setHalignment(player2Circle, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(player2Circle, javafx.geometry.VPos.CENTER);

        GridPane.setColumnIndex(gridPane0, 1);

        columnConstraints11.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints11.setMinWidth(10.0);
        columnConstraints11.setPrefWidth(100.0);

        rowConstraints10.setMinHeight(10.0);
        rowConstraints10.setPrefHeight(30.0);
        rowConstraints10.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints11.setMinHeight(10.0);
        rowConstraints11.setPrefHeight(30.0);
        rowConstraints11.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints12.setMinHeight(10.0);
        rowConstraints12.setPrefHeight(30.0);
        rowConstraints12.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        columnConstraints12.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints12.setMinWidth(10.0);
        columnConstraints12.setPrefWidth(100.0);

        rowConstraints13.setMinHeight(10.0);
        rowConstraints13.setPrefHeight(30.0);
        rowConstraints13.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints14.setMinHeight(10.0);
        rowConstraints14.setPrefHeight(30.0);
        rowConstraints14.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints15.setMinHeight(10.0);
        rowConstraints15.setPrefHeight(30.0);
        rowConstraints15.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(lblPlayer2, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(lblPlayer2, 2);
        GridPane.setValignment(lblPlayer2, javafx.geometry.VPos.CENTER);
        lblPlayer2.setAlignment(javafx.geometry.Pos.CENTER);
        lblPlayer2.setPrefHeight(87.0);
        lblPlayer2.setPrefWidth(185.0);
        lblPlayer2.setText("SNAKES");
        lblPlayer2.setTextFill(javafx.scene.paint.Color.valueOf("#1ba1c6"));
        lblPlayer2.setFont(new Font("System Bold", 25.0));

        GridPane.setHalignment(label1, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(label1, 1);
        GridPane.setValignment(label1, javafx.geometry.VPos.CENTER);
        label1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        label1.setPrefHeight(64.0);
        label1.setPrefWidth(69.0);
        label1.setText("VS");
        label1.setTextFill(javafx.scene.paint.Color.valueOf("#dd2121"));
        label1.setFont(new Font("System Bold", 48.0));

        GridPane.setHalignment(playerName, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(playerName, 9);
        GridPane.setColumnIndex(playerName, 0);
        GridPane.setValignment(playerName, javafx.geometry.VPos.CENTER);

        playerName.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        playerName.setAlignment(Pos.CENTER);
        playerName.setPrefHeight(80.0);
        playerName.setPrefWidth(80.0);
        playerName.setTextFill(javafx.scene.paint.Color.valueOf("#000"));
        playerName.setFont(new Font("System Bold", 12.0));

        GridPane.setHalignment(lblPlayer1, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(lblPlayer1, javafx.geometry.VPos.CENTER);
        lblPlayer1.setAlignment(javafx.geometry.Pos.CENTER);
        lblPlayer1.setPrefHeight(87.0);
        lblPlayer1.setPrefWidth(185.0);
        lblPlayer1.setText("LADDERS");
        lblPlayer1.setTextFill(javafx.scene.paint.Color.valueOf("#1ba1c6"));
        lblPlayer1.setFont(new Font("System Bold", 25.0));

        GridPane.setRowIndex(gridPane2, 2);

        columnConstraints13.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints13.setMinWidth(10.0);
        columnConstraints13.setPrefWidth(100.0);

        rowConstraints16.setMinHeight(10.0);
        rowConstraints16.setPrefHeight(30.0);
        rowConstraints16.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints17.setMinHeight(10.0);
        rowConstraints17.setPrefHeight(30.0);
        rowConstraints17.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btnBack, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btnBack, 1);
        GridPane.setValignment(btnBack, javafx.geometry.VPos.CENTER);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(55.0);
        btnBack.setPrefWidth(120.0);
        btnBack.setStyle("-fx-background-color: #ff3300;");
        btnBack.setText("Back");
        btnBack.setFont(new Font("System Bold", 24.0));

        GridPane.setHalignment(btnRestart, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btnRestart, javafx.geometry.VPos.CENTER);
        btnRestart.setMnemonicParsing(false);
        btnRestart.setPrefHeight(55.0);
        btnRestart.setPrefWidth(120.0);
        btnRestart.setStyle("-fx-background-color: #33ff33;");
        btnRestart.setText("Restart");
        btnRestart.setFont(new Font("System Bold", 24.0));

        GridPane.setHalignment(btnRoll, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btnRoll, 1);
        GridPane.setValignment(btnRoll, javafx.geometry.VPos.CENTER);
        btnRoll.setMaxHeight(100.0);
        btnRoll.setMaxWidth(100.0);
        btnRoll.setMinHeight(100.0);
        btnRoll.setMinWidth(100.0);
        btnRoll.setMnemonicParsing(false);
        btnRoll.setPrefHeight(100.0);
        btnRoll.setPrefWidth(100.0);
        btnRoll.setFont(new Font("System Bold", 24.0));

        imageView0.setFitHeight(100.0);
        imageView0.setFitWidth(100.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/resources/imgs/dice1.png").toExternalForm()));
        btnRoll.setGraphic(imageView0);

        getColumnConstraints().add(columnConstraints);
        getColumnConstraints().add(columnConstraints0);
        getRowConstraints().add(rowConstraints);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getColumnConstraints().add(columnConstraints5);
        gridPane.getColumnConstraints().add(columnConstraints6);
        gridPane.getColumnConstraints().add(columnConstraints7);
        gridPane.getColumnConstraints().add(columnConstraints8);
        gridPane.getColumnConstraints().add(columnConstraints9);
        gridPane.getColumnConstraints().add(columnConstraints10);
        gridPane.getRowConstraints().add(rowConstraints0);
        gridPane.getRowConstraints().add(rowConstraints1);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getRowConstraints().add(rowConstraints3);
        gridPane.getRowConstraints().add(rowConstraints4);
        gridPane.getRowConstraints().add(rowConstraints5);
        gridPane.getRowConstraints().add(rowConstraints6);
        gridPane.getRowConstraints().add(rowConstraints7);
        gridPane.getRowConstraints().add(rowConstraints8);
        gridPane.getRowConstraints().add(rowConstraints9);
        gridPane.getChildren().add(imageView);
        getChildren().add(gridPane);
        gridPane0.getColumnConstraints().add(columnConstraints11);
        gridPane0.getRowConstraints().add(rowConstraints10);
        gridPane0.getRowConstraints().add(rowConstraints11);
        gridPane0.getRowConstraints().add(rowConstraints12);
        gridPane1.getColumnConstraints().add(columnConstraints12);
        gridPane1.getRowConstraints().add(rowConstraints13);
        gridPane1.getRowConstraints().add(rowConstraints14);
        gridPane1.getRowConstraints().add(rowConstraints15);
        gridPane1.getChildren().add(lblPlayer2);
        gridPane1.getChildren().add(label1);
        gridPane1.getChildren().add(lblPlayer1);
        gridPane0.getChildren().add(gridPane1);
        gridPane2.getColumnConstraints().add(columnConstraints13);
        gridPane2.getRowConstraints().add(rowConstraints16);
        gridPane2.getRowConstraints().add(rowConstraints17);
        gridPane2.getChildren().add(btnBack);
        gridPane2.getChildren().add(btnRestart);
        gridPane0.getChildren().add(gridPane2);
        gridPane0.getChildren().add(btnRoll);
        gridPane.getChildren().add(player1Circle);
        gridPane.getChildren().add(player2Circle);
        gridPane.getChildren().add(playerName);
        getChildren().add(gridPane0);
        lblPlayer1.setText(name);
        lblPlayer2.setText("My Friend");
        init();
    }

    Position positionPlayer1, positionPlayer2;
    private boolean isMyTurn = true;

    Thread showStepsTh;
    Music music;

    private void init() {
        tictactoe.TicTacToe.mybackgroundMusic.pauseMusic();
        music = new Music("laddersbackground.mp3", true);
        positionPlayer1 = new Position();
        positionPlayer2 = new Position();

        GridPane.setRowIndex(player1Circle, 9);
        GridPane.setColumnIndex(player1Circle, 0);

        GridPane.setRowIndex(player2Circle, 9);
        GridPane.setColumnIndex(player2Circle, 0);

        GridPane.setRowIndex(playerName, 9);
        GridPane.setColumnIndex(playerName, 0);
        playerName.setText(lblPlayer1.getText());

        btnRoll.setOnAction((event) -> {
            int num = new Random().nextInt(6);

            changeLocation(num + 1);
        });

        btnRestart.setOnAction((event) -> {
            reset();
        });

        btnBack.setOnAction((event) -> {
            music.stopMusic();
            tictactoe.TicTacToe.mybackgroundMusic.resumeMusic();
            new Music("back.mp3", false);
            tictactoe.TicTacToe.primaryStage.setTitle("Choose game");
            tictactoe.TicTacToe.primaryStage.setScene(tictactoe.TicTacToe.scenes.pop());
        });

        Platform.runLater(() -> {
            String friendName = Alerts.getInput("Game Name", "What's your friend name?", "Please enter your friend name");

            if (friendName == null || friendName.length() == 0) {
                friendName = "Guest";
            }
            lblPlayer1.setText(name);
            lblPlayer2.setText(friendName);
        });
    }

    private void reset() {
        new Music("reset.mp3", false);
        imageView0.setImage(new Image(getClass().getResource("/resources/imgs/dice1.png").toExternalForm()));
        if (showStepsTh != null) {
            showStepsTh.stop();
        }
        steps.clear();
        positionPlayer1.locX = 9;
        positionPlayer1.locY = 0;
        positionPlayer2.locX = 9;
        positionPlayer2.locY = 0;
        GridPane.setRowIndex(player1Circle, 9);
        GridPane.setColumnIndex(player1Circle, 0);
        GridPane.setRowIndex(player2Circle, 9);
        GridPane.setColumnIndex(player2Circle, 0);
        GridPane.setRowIndex(playerName, 9);
        GridPane.setColumnIndex(playerName, 0);
        playerName.setText(lblPlayer1.getText());
        btnRoll.setDisable(false);
    }

    private void changeLocation(int locstion) {
        imageView0.setImage(new Image(getClass().getResource("/resources/imgs/dice" + locstion + ".png").toExternalForm()));
        int nextStep = 0, row, col;

        if (isMyTurn) {
            playerName.setText(lblPlayer1.getText());
            row = positionPlayer1.locX;
            col = positionPlayer1.locY;
        } else {
            playerName.setText(lblPlayer2.getText());
            row = positionPlayer2.locX;
            col = positionPlayer2.locY;
        }

        steps.clear();

        for (; row >= 0 && nextStep != locstion; row--) {
            if (row % 2 == 0) {
                for (; col >= 0; col--) {
                    if (nextStep == locstion) {
                        row++;
                        break;
                    } else {
                        steps.add(new Position(row, col));
                    }
                    nextStep++;
                }
                if (col == -1) {
                    col++;
                }
            } else {
                for (; col < 10; col++) {
                    if (nextStep == locstion) {
                        row++;
                        break;
                    } else {
                        steps.add(new Position(row, col));
                    }
                    nextStep++;
                }
                if (col == 10) {
                    col--;
                }
            }
        }

        if (row == -1) {
            row = 0;
        }

        for (Position[] ladder : ladders) {
            if (ladder[0].locX == row && ladder[0].locY == col) {
                row = ladder[1].locX;
                col = ladder[1].locY;
            }
        }

        for (Position[] snake : snakes) {
            if (snake[0].locX == row && snake[0].locY == col) {
                row = snake[1].locX;
                col = snake[1].locY;
            }
        }

        btnRoll.setDisable(true);
        if (isMyTurn) {
            positionPlayer1.locX = row;
            positionPlayer1.locY = col;
        } else {
            positionPlayer2.locX = row;
            positionPlayer2.locY = col;
        }

        steps.add(new Position(row, col));

        showStepsTh = new Thread(new Runnable() {
            @Override
            public void run() {
                for (Position step : steps) {
                    if (isMyTurn) {
                        GridPane.setRowIndex(player1Circle, step.locX);
                        GridPane.setColumnIndex(player1Circle, step.locY);
                    } else {
                        GridPane.setRowIndex(player2Circle, step.locX);
                        GridPane.setColumnIndex(player2Circle, step.locY);
                    }
                    GridPane.setRowIndex(playerName, step.locX);
                    GridPane.setColumnIndex(playerName, step.locY);

                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BoardUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                btnRoll.setDisable(false);

                isMyTurn = !isMyTurn;

                if (isMyTurn) {
                    GridPane.setRowIndex(playerName, positionPlayer1.locX);
                    GridPane.setColumnIndex(playerName, positionPlayer1.locY);
                    Platform.runLater(() -> {
                        playerName.setText(lblPlayer1.getText());
                    });

                } else {
                    GridPane.setRowIndex(playerName, positionPlayer2.locX);
                    GridPane.setColumnIndex(playerName, positionPlayer2.locY);
                    Platform.runLater(() -> {
                        playerName.setText(lblPlayer2.getText());
                    });
                }

                if (steps.get(steps.size() - 1).locX == 0 && steps.get(steps.size() - 1).locY == 0) {
                    Platform.runLater(() -> {
                        String congMsg = "Congratulations " + (isMyTurn ? lblPlayer1.getText() : lblPlayer2.getText()) + " Wins :)";
                        Animation animation = new Animation(congMsg);

                        Stage stage = new Stage();
                        Scene scene = new Scene(animation);
                        stage.setTitle(congMsg);
                        stage.setScene(scene);
                        stage.setResizable(false);
                        stage.initModality(Modality.WINDOW_MODAL);
                        stage.initOwner(tictactoe.TicTacToe.primaryStage);
                        stage.showAndWait();

                        if (animation.isPlayAgain) {
                            reset();
                        }
                    });

                    btnRoll.setDisable(true);
                }
            }
        });
        showStepsTh.start();

        // GridPane.setRowIndex(label, row);
        // GridPane.setColumnIndex(label, col);
    }

}
