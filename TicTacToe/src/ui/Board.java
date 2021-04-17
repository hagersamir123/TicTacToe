package ui;

import animation.Animation;
import database.DBLayer;
import helperclasses.Alerts;
import helperclasses.Commands;
import helperclasses.Music;
import helperclasses.PlayingMode;
import helperclasses.User;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import minmax.Difficulty;
import minmax.MinMaxAlgo;
import minmax.Move;
import minmax.MovingInfo;
import online.Client;
import tictactoe.TicTacToe;
/**
 *
 * @author Mohamed Elsayed
 */
public class Board extends SplitPane implements EventHandler<javafx.event.ActionEvent> {

    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final RowConstraints rowConstraints;
    protected final Label lblXO1;
    protected final Label txtPlayer1;
    protected final Label txtTime;
    protected final Label lblXO2;
    protected final Label txtPlayer2;
    protected final BorderPane borderPane;
    protected final GridPane boardView;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final ColumnConstraints columnConstraints6;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final RowConstraints rowConstraints2;
    protected final Button btn00;
    protected final Button btn01;
    protected final Button btn02;
    protected final Button btn10;
    protected final Button btn11;
    protected final Button btn12;
    protected final Button btn20;
    protected final Button btn21;
    protected final Button btn22;
    protected final GridPane gridPane1;
    protected final ColumnConstraints columnConstraints7;
    protected final RowConstraints rowConstraints3;
    protected final Button btnClose;
    protected final GridPane gridPane2;
    protected final ColumnConstraints columnConstraints8;
    protected final RowConstraints rowConstraints4;
    protected final Label txtPlayer;

    public boolean isLoaded;
    public String player1, player2;
    Move p1PlayWith, p2PlayWith;
    Client client;
    boolean isMyTurn, isGameOver, isFirstMove;
    String boardState = "";
    int checkWin, numOfMoves;

    PlayingMode playingMode;
    MinMaxAlgo minMaxRoot;
    Animation animation;

    Thread timerThread, showThread;

    Move board[][] = {
        {Move.NONE, Move.NONE, Move.NONE},
        {Move.NONE, Move.NONE, Move.NONE},
        {Move.NONE, Move.NONE, Move.NONE}
    };

    private MovingInfo nextMove;

    // <editor-fold defaultstate="collapsed" desc="Init UI Components">
    private Board() {

        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        lblXO1 = new Label();
        txtPlayer1 = new Label();
        txtTime = new Label();
        lblXO2 = new Label();
        txtPlayer2 = new Label();
        borderPane = new BorderPane();
        boardView = new GridPane();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        columnConstraints6 = new ColumnConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        rowConstraints2 = new RowConstraints();
        btn00 = new Button();
        btn01 = new Button();
        btn02 = new Button();
        btn10 = new Button();
        btn11 = new Button();
        btn12 = new Button();
        btn20 = new Button();
        btn21 = new Button();
        btn22 = new Button();
        gridPane1 = new GridPane();
        columnConstraints7 = new ColumnConstraints();
        rowConstraints3 = new RowConstraints();
        btnClose = new Button();
        gridPane2 = new GridPane();
        columnConstraints8 = new ColumnConstraints();
        rowConstraints4 = new RowConstraints();
        txtPlayer = new Label();

        setDividerPositions(0.14338235294117646);
        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setOrientation(javafx.geometry.Orientation.VERTICAL);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStylesheets().add("/resources/css/style.css");

        gridPane.setMaxHeight(70.0);
        gridPane.setMinHeight(70.0);
        gridPane.setPrefHeight(70.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMaxWidth(60.0);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(60.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(220.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(220.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(240.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(60.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(60.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(220.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(220.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(lblXO1, javafx.geometry.HPos.RIGHT);
        GridPane.setValignment(lblXO1, javafx.geometry.VPos.CENTER);
        lblXO1.setAlignment(javafx.geometry.Pos.CENTER);
        lblXO1.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        lblXO1.setId("x_lable");
        lblXO1.setPrefHeight(32.0);
        lblXO1.setPrefWidth(38.0);
        lblXO1.setText("X");
        lblXO1.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblXO1.setTextFill(javafx.scene.paint.Color.valueOf("#ff262d"));
        lblXO1.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        lblXO1.setWrapText(true);
        lblXO1.setFont(new Font(45.0));
        GridPane.setMargin(lblXO1, new Insets(0.0, 0.0, 0.0, 20.0));
        lblXO1.setPadding(new Insets(0.0, 7.0, 0.0, 0.0));

        GridPane.setColumnIndex(txtPlayer1, 1);
        GridPane.setHalignment(txtPlayer1, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(txtPlayer1, javafx.geometry.VPos.CENTER);
        txtPlayer1.setAlignment(javafx.geometry.Pos.CENTER);
        txtPlayer1.setPrefHeight(35.0);
        txtPlayer1.setPrefWidth(200.0);
        txtPlayer1.getStyleClass().add("txt");
        txtPlayer1.setText("Player 1");
        txtPlayer1.setFont(new Font("System Bold", 20.0));

        GridPane.setColumnIndex(txtTime, 2);
        GridPane.setHalignment(txtTime, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(txtTime, javafx.geometry.VPos.CENTER);
        txtTime.setAlignment(javafx.geometry.Pos.CENTER);
        txtTime.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        txtTime.setPrefHeight(35.0);
        txtTime.setPrefWidth(200.0);
        txtTime.getStyleClass().add("txt");
        txtTime.setText("00:00");
        txtTime.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        txtTime.setFont(new Font("System Bold", 20.0));

        GridPane.setColumnIndex(lblXO2, 3);
        GridPane.setHalignment(lblXO2, javafx.geometry.HPos.RIGHT);
        GridPane.setValignment(lblXO2, javafx.geometry.VPos.CENTER);
        lblXO2.setAlignment(javafx.geometry.Pos.CENTER);
        lblXO2.setContentDisplay(javafx.scene.control.ContentDisplay.CENTER);
        lblXO2.setId("o_lable");
        lblXO2.setPrefHeight(32.0);
        lblXO2.setPrefWidth(38.0);
        lblXO2.setText("O");
        lblXO2.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        lblXO2.setTextFill(javafx.scene.paint.Color.valueOf("#11ee39"));
        lblXO2.setTextOverrun(javafx.scene.control.OverrunStyle.WORD_ELLIPSIS);
        lblXO2.setWrapText(true);
        lblXO2.setFont(new Font(45.0));
        GridPane.setMargin(lblXO2, new Insets(0.0, 7.0, 0.0, 0.0));

        GridPane.setColumnIndex(txtPlayer2, 4);
        txtPlayer2.setAlignment(javafx.geometry.Pos.CENTER);
        txtPlayer2.setLayoutX(69.0);
        txtPlayer2.setLayoutY(24.0);
        txtPlayer2.setPrefHeight(35.0);
        txtPlayer2.setPrefWidth(200.0);
        txtPlayer2.getStyleClass().add("txt");
        txtPlayer2.setText("Player 2");
        txtPlayer2.setFont(new Font("System Bold", 20.0));

        borderPane.setPrefHeight(200.0);
        borderPane.setPrefWidth(200.0);
        borderPane.setStyle("-fx-background-color: #27aae2;");

        BorderPane.setAlignment(boardView, javafx.geometry.Pos.CENTER);
        boardView.setAlignment(javafx.geometry.Pos.CENTER);
        boardView.setMaxHeight(340.0);
        boardView.setMaxWidth(344.0);
        boardView.setMinHeight(200.0);
        boardView.setMinWidth(200.0);
        boardView.setPrefHeight(340.0);
        boardView.setPrefWidth(344.0);
        boardView.getStyleClass().add("board");

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(100.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(100.0);

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(100.0);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(30.0);
        rowConstraints1.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btn00, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btn00, javafx.geometry.VPos.CENTER);
        btn00.setAlignment(javafx.geometry.Pos.CENTER);
        btn00.setId("1");
        btn00.setMinHeight(USE_PREF_SIZE);
        btn00.setMinWidth(USE_PREF_SIZE);
        btn00.setMnemonicParsing(false);
        btn00.setPrefHeight(90.0);
        btn00.setPrefWidth(90.0);
        btn00.getStyleClass().add("btn");
        btn00.setTextFill(javafx.scene.paint.Color.valueOf("#b71212"));
        btn00.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        btn00.setFont(new Font(18.0));
        GridPane.setMargin(btn00, new Insets(0.0));

        GridPane.setColumnIndex(btn01, 1);
        GridPane.setHalignment(btn01, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btn01, javafx.geometry.VPos.CENTER);
        btn01.setAlignment(javafx.geometry.Pos.CENTER);
        btn01.setId("2");
        btn01.setMinHeight(USE_PREF_SIZE);
        btn01.setMinWidth(USE_PREF_SIZE);
        btn01.setMnemonicParsing(false);
        btn01.setPrefHeight(90.0);
        btn01.setPrefWidth(90.0);
        btn01.getStyleClass().add("btn");
        btn01.setTextFill(javafx.scene.paint.Color.valueOf("#b71212"));
        btn01.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        btn01.setFont(new Font(18.0));
        GridPane.setMargin(btn01, new Insets(0.0));

        GridPane.setColumnIndex(btn02, 2);
        GridPane.setHalignment(btn02, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btn02, javafx.geometry.VPos.CENTER);
        btn02.setId("3");
        btn02.setMinHeight(USE_PREF_SIZE);
        btn02.setMinWidth(USE_PREF_SIZE);
        btn02.setMnemonicParsing(false);
        btn02.setPrefHeight(90.0);
        btn02.setPrefWidth(90.0);
        btn02.getStyleClass().add("btn");
        btn02.setTextFill(javafx.scene.paint.Color.valueOf("#b71212"));
        btn02.setFont(new Font(18.0));
        GridPane.setMargin(btn02, new Insets(0.0));

        GridPane.setHalignment(btn10, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btn10, 1);
        GridPane.setValignment(btn10, javafx.geometry.VPos.CENTER);
        btn10.setId("4");
        btn10.setMinHeight(USE_PREF_SIZE);
        btn10.setMinWidth(USE_PREF_SIZE);
        btn10.setMnemonicParsing(false);
        btn10.setPrefHeight(90.0);
        btn10.setPrefWidth(90.0);
        btn10.getStyleClass().add("btn");
        btn10.setTextFill(javafx.scene.paint.Color.valueOf("#b71212"));
        btn10.setFont(new Font(18.0));
        GridPane.setMargin(btn10, new Insets(0.0));

        GridPane.setColumnIndex(btn11, 1);
        GridPane.setHalignment(btn11, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btn11, 1);
        GridPane.setValignment(btn11, javafx.geometry.VPos.CENTER);
        btn11.setId("5");
        btn11.setMinHeight(USE_PREF_SIZE);
        btn11.setMinWidth(USE_PREF_SIZE);
        btn11.setMnemonicParsing(false);
        btn11.setPrefHeight(90.0);
        btn11.setPrefWidth(90.0);
        btn11.getStyleClass().add("btn");
        btn11.setTextFill(javafx.scene.paint.Color.valueOf("#f8f40d"));
        btn11.setFont(new Font(18.0));
        GridPane.setMargin(btn11, new Insets(0.0));

        GridPane.setColumnIndex(btn12, 2);
        GridPane.setHalignment(btn12, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btn12, 1);
        GridPane.setValignment(btn12, javafx.geometry.VPos.CENTER);
        btn12.setId("6");
        btn12.setMinHeight(USE_PREF_SIZE);
        btn12.setMinWidth(USE_PREF_SIZE);
        btn12.setMnemonicParsing(false);
        btn12.setPrefHeight(90.0);
        btn12.setPrefWidth(90.0);
        btn12.getStyleClass().add("btn");
        btn12.setTextFill(javafx.scene.paint.Color.valueOf("#b71212"));
        btn12.setFont(new Font(18.0));
        GridPane.setMargin(btn12, new Insets(0.0));

        GridPane.setHalignment(btn20, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btn20, 2);
        GridPane.setValignment(btn20, javafx.geometry.VPos.CENTER);
        btn20.setId("7");
        btn20.setMinHeight(USE_PREF_SIZE);
        btn20.setMinWidth(USE_PREF_SIZE);
        btn20.setMnemonicParsing(false);
        btn20.setPrefHeight(90.0);
        btn20.setPrefWidth(90.0);
        btn20.getStyleClass().add("btn");
        btn20.setTextFill(javafx.scene.paint.Color.valueOf("#f8f40d"));
        btn20.setFont(new Font(18.0));
        GridPane.setMargin(btn20, new Insets(0.0));

        GridPane.setColumnIndex(btn21, 1);
        GridPane.setHalignment(btn21, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btn21, 2);
        GridPane.setValignment(btn21, javafx.geometry.VPos.CENTER);
        btn21.setId("8");
        btn21.setMinHeight(USE_PREF_SIZE);
        btn21.setMinWidth(USE_PREF_SIZE);
        btn21.setMnemonicParsing(false);
        btn21.setPrefHeight(90.0);
        btn21.setPrefWidth(90.0);
        btn21.getStyleClass().add("btn");
        btn21.setTextFill(javafx.scene.paint.Color.valueOf("#b71212"));
        btn21.setFont(new Font(18.0));
        GridPane.setMargin(btn21, new Insets(0.0));

        GridPane.setColumnIndex(btn22, 2);
        GridPane.setHalignment(btn22, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btn22, 2);
        GridPane.setValignment(btn22, javafx.geometry.VPos.CENTER);
        btn22.setAlignment(javafx.geometry.Pos.CENTER);
        btn22.setId("9");
        btn22.setMinHeight(USE_PREF_SIZE);
        btn22.setMinWidth(USE_PREF_SIZE);
        btn22.setMnemonicParsing(false);
        btn22.setPrefHeight(90.0);
        btn22.setPrefWidth(90.0);
        btn22.getStyleClass().add("btn");
        btn22.setTextFill(javafx.scene.paint.Color.valueOf("#b71212"));
        btn22.setTextOverrun(javafx.scene.control.OverrunStyle.CLIP);
        btn22.setFont(new Font(18.0));
        GridPane.setMargin(btn22, new Insets(0.0));
        boardView.setOpaqueInsets(new Insets(0.0));
        BorderPane.setMargin(boardView, new Insets(0.0));
        boardView.setPadding(new Insets(10.0));
        borderPane.setCenter(boardView);

        BorderPane.setAlignment(gridPane1, javafx.geometry.Pos.CENTER);
        gridPane1.setPrefHeight(60.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPrefWidth(100.0);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btnClose, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btnClose, javafx.geometry.VPos.TOP);
        btnClose.setMnemonicParsing(false);
        btnClose.setPrefHeight(45.0);
        btnClose.setPrefWidth(120.0);
        btnClose.getStyleClass().add("obtndanger");
        btnClose.setText("Close");
        borderPane.setBottom(gridPane1);

        BorderPane.setAlignment(gridPane2, javafx.geometry.Pos.CENTER);
        gridPane2.setPrefHeight(60.0);

        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMinWidth(10.0);
        columnConstraints8.setPrefWidth(100.0);

        rowConstraints4.setMinHeight(10.0);
        rowConstraints4.setPrefHeight(30.0);
        rowConstraints4.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(txtPlayer, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(txtPlayer, javafx.geometry.VPos.CENTER);
        txtPlayer.setAlignment(javafx.geometry.Pos.CENTER);
        txtPlayer.setPrefHeight(35.0);
        txtPlayer.setPrefWidth(200.0);
        txtPlayer.getStyleClass().add("txtplayer");
        txtPlayer.setText("Player 1");
        txtPlayer.setFont(new Font("System Bold", 20.0));
        borderPane.setTop(gridPane2);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(lblXO1);
        gridPane.getChildren().add(txtPlayer1);
        gridPane.getChildren().add(txtTime);
        gridPane.getChildren().add(lblXO2);
        gridPane.getChildren().add(txtPlayer2);
        getItems().add(gridPane);
        boardView.getColumnConstraints().add(columnConstraints4);
        boardView.getColumnConstraints().add(columnConstraints5);
        boardView.getColumnConstraints().add(columnConstraints6);
        boardView.getRowConstraints().add(rowConstraints0);
        boardView.getRowConstraints().add(rowConstraints1);
        boardView.getRowConstraints().add(rowConstraints2);
        boardView.getChildren().add(btn00);
        boardView.getChildren().add(btn01);
        boardView.getChildren().add(btn02);
        boardView.getChildren().add(btn10);
        boardView.getChildren().add(btn11);
        boardView.getChildren().add(btn12);
        boardView.getChildren().add(btn20);
        boardView.getChildren().add(btn21);
        boardView.getChildren().add(btn22);
        gridPane1.getColumnConstraints().add(columnConstraints7);
        gridPane1.getRowConstraints().add(rowConstraints3);
        gridPane1.getChildren().add(btnClose);
        gridPane2.getColumnConstraints().add(columnConstraints8);
        gridPane2.getRowConstraints().add(rowConstraints4);
        gridPane2.getChildren().add(txtPlayer);
        getItems().add(borderPane);
    }
    // </editor-fold>

    public Board(PlayingMode playingMode, String player1, String player2, boolean isMyTurn, Client client) {
        this();
        this.playingMode = playingMode;
        this.player1 = player1;
        this.player2 = player2;
        this.isMyTurn = isMyTurn;
        this.client = client;
        this.txtPlayer1.setText(player1);
        this.txtPlayer2.setText(player2);
        this.txtPlayer.setText(player1);

        if (playingMode == PlayingMode.Computer) {
            chooseXO();
            startAlgorithm();
        } else {
            Platform.runLater(() -> {
                chooseXO();
            });
        }

        setEvents();

    }

    public Board(String player2, boolean isMyTurn, String board, Move p1PlayWith) {
        this();
        this.playingMode = PlayingMode.Show;
        this.player1 = "You";
        this.player2 = player2;
        this.isMyTurn = isMyTurn;
        String[] moves = board.split("-");
        this.p1PlayWith = p1PlayWith;
        this.p2PlayWith = (p1PlayWith == Move.X ? Move.O : Move.X);
        this.txtPlayer1.setText(player1);
        this.txtPlayer2.setText(player2);

        boardView.setDisable(true);

        showThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (String move : moves) {
                    try {
                        Platform.runLater(() -> {
                            setLocation(Integer.parseInt(move));
                        });
                        Thread.sleep(700);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                isGameOver = true;
            }
        });
        showThread.start();

        btnClose.setOnAction((event) -> {
            new Music("back.mp3", false);
            if (timerThread != null) {
                timerThread.stop();
            }
            showThread.stop();
            if (client != null) {
                TicTacToe.primaryStage.setTitle(player1 + "'s Looby");
            } else {
                TicTacToe.primaryStage.setTitle("Main Page");
            }
            tictactoe.TicTacToe.primaryStage.setScene(tictactoe.TicTacToe.scenes.pop());
        });

        switchStyle();
    }

    private void startAlgorithm() {

        nextMove = new MovingInfo(-1, -1, 0);

        Difficulty difficulty = Difficulty.Normal;
        List<ButtonType> buttons = new ArrayList<ButtonType>();

        ButtonType easy = new ButtonType("Easy");
        ButtonType normal = new ButtonType("Normal");
        ButtonType hard = new ButtonType("Hard");

        buttons.add(easy);
        buttons.add(normal);
        buttons.add(hard);

        Optional<ButtonType> result = Alerts.showMultiOpsAlert(buttons, "Difficulty", "Choose PC difficulty", "Please Choose PC difficulty");
        if (result.get() == hard) {
            difficulty = Difficulty.Hard;
        } else if (result.get() == normal) {
            difficulty = Difficulty.Normal;
        } else if (result.get() == easy) {
            difficulty = Difficulty.Easy;
        }

        if (!isMyTurn) {
            // MinMaxAlgo(Move board[][], Move player, Difficulty difficulty, boolean isMax, MinMaxAlgo parent, MovingInfo currentMoveInfo)
            minMaxRoot = new MinMaxAlgo(board, p2PlayWith, difficulty, true, null, nextMove);
        } else {
            minMaxRoot = new MinMaxAlgo(board, p1PlayWith, difficulty, false, null, nextMove);
        }
        // switchStyle();

        if (!isMyTurn) {
            setLocation(getPCMove());
        }
    }

    private void chooseXO() {
        List<ButtonType> buttons = new ArrayList<ButtonType>();

        ButtonType X = new ButtonType("X");
        ButtonType O = new ButtonType("O");
        buttons.add(X);
        buttons.add(O);
        Optional<ButtonType> result = Alerts.showMultiOpsAlert(buttons, "Choose X/O", "Choose Your (X/O)", "Please Choose Your X/O");

        if (result.get() == X) {
            p1PlayWith = Move.X;
            p2PlayWith = Move.O;
        } else if (result.get() == O) {
            p1PlayWith = Move.O;
            p2PlayWith = Move.X;
            lblXO1.setTextFill(javafx.scene.paint.Color.valueOf("#11ee39"));
            lblXO2.setTextFill(javafx.scene.paint.Color.valueOf("#ff262d"));
        }

        lblXO1.setText(p1PlayWith.toString());
        lblXO2.setText(p2PlayWith.toString());
        switchStyle();
        isLoaded = true;
    }

    private void setEvents() {

        this.btn00.setOnAction(this);
        this.btn01.setOnAction(this);
        this.btn02.setOnAction(this);
        this.btn10.setOnAction(this);
        this.btn11.setOnAction(this);
        this.btn12.setOnAction(this);
        this.btn20.setOnAction(this);
        this.btn21.setOnAction(this);
        this.btn22.setOnAction(this);

        tictactoe.TicTacToe.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                if (timerThread != null) {
                    timerThread.stop();
                }
                if (client != null) {
                    Platform.runLater(() -> {
                        if (!isGameOver) {
                            client.sendMessage(Commands.Withdraw.toString() + "-" + player1);
                        }

                        isGameOver = true;
                        client.closeClient();
                    });
                }
            }
        });

        btnClose.setOnAction((event) -> {
            if (!isGameOver) {
                Optional<ButtonType> result = Alerts.showYesNoAlert(Alert.AlertType.WARNING, "Close", "You didn't complete the game yet do you want to close this window?", "Please select youe Chooise?");

                if (result.get() == ButtonType.YES) {
                    new Music("back.mp3", false);
                    if (timerThread != null) {
                        timerThread.stop();
                    }
                    if (client != null) {
                        client.sendMessage(Commands.Withdraw.toString() + "-" + player1);
                        /*Stage stage = TicTacToe.primaryStage;
                        stage.setTitle(player1 + "'s Looby");
                        stage.setScene(new Scene(new OnlineUsers(client)));
                        client.inGame = false;
                        client.sendMessage(Commands.OPEN.toString() + "-" + player1);
                         */
                        client.inGame = false;
                    }

                    MainPage mainPage = (MainPage) tictactoe.TicTacToe.scenes.peek().getRoot();
                    mainPage.init();
                    TicTacToe.primaryStage.setTitle("Main Page");
                    TicTacToe.primaryStage.setScene(tictactoe.TicTacToe.scenes.pop());
                }
            } else {
                new Music("back.mp3", false);
                if (client != null) {
                    client.inGame = false;
                    client.sendMessage(Commands.OUTGAME.toString() + "-" + player1);
                    TicTacToe.primaryStage.setTitle(player1 + "'s Looby");
                } else {
                    MainPage mainPage = (MainPage) tictactoe.TicTacToe.scenes.peek().getRoot();
                    mainPage.init();
                    TicTacToe.primaryStage.setTitle("Main Page");
                }
                TicTacToe.primaryStage.setScene(tictactoe.TicTacToe.scenes.pop());
            }
        });
    }

    @Override
    public void handle(javafx.event.ActionEvent event) {
        Button btnClicked = (Button) event.getSource();
        if (!btnClicked.isDisabled() && ((playingMode == PlayingMode.Computer && isMyTurn)
                || (playingMode == PlayingMode.Friend)
                || (playingMode == PlayingMode.Online && isMyTurn))) {

            String soundFile = "o.mp3";
            if (isMyTurn) {
                if (p1PlayWith == Move.O) {
                    soundFile = "o.mp3";
                } else {
                    soundFile = "x.mp3";
                }
            } else {
                if (p2PlayWith == Move.O) {
                    soundFile = "o.mp3";
                } else {
                    soundFile = "x.mp3";
                }
            }

            new Music(soundFile, false);

            int location = Integer.valueOf(btnClicked.getId());

            if (playingMode == PlayingMode.Computer) {
                setLocation(location);
                if (!isGameOver) {
                    location = getPCMove();
                }
            } else if (playingMode == PlayingMode.Online) {
                client.sendMessage(Commands.PLAY.toString() + "-" + Integer.valueOf(btnClicked.getId()));
            }

            if (!isGameOver) {
                setLocation(location);
            }
        } else {

        }
    }

    public void setLocation(int location) {
        Button btnClicked = btn00;
        Move nextMove = (isMyTurn ? p1PlayWith : p2PlayWith);

        if (numOfMoves == 0) {
            startTimer();
        }

        switch (location) {
            case 1:
                btnClicked = btn00;
                board[0][0] = nextMove;
                break;
            case 2:
                btnClicked = btn01;
                board[0][1] = nextMove;
                break;
            case 3:
                btnClicked = btn02;
                board[0][2] = nextMove;
                break;
            case 4:
                btnClicked = btn10;
                board[1][0] = nextMove;
                break;
            case 5:
                btnClicked = btn11;
                board[1][1] = nextMove;
                break;
            case 6:
                btnClicked = btn12;
                board[1][2] = nextMove;
                break;
            case 7:
                btnClicked = btn20;
                board[2][0] = nextMove;
                break;
            case 8:
                btnClicked = btn21;
                board[2][1] = nextMove;
                break;
            case 9:
                btnClicked = btn22;
                board[2][2] = nextMove;
                break;
        }

        btnClicked.setText(nextMove.toString());
        btnClicked.setDisable(true);

        if (++numOfMoves == 9) {
            isGameOver = true;
        }
        boardState += location + "-";

        checkWin = MinMaxAlgo.evaluate(board);

        String congMsg = "";

        if (checkWin != 0) {
            isGameOver = true;
            boardView.setDisable(true);
            txtPlayer.setText(txtPlayer.getText() + " Wins");
            if (isMyTurn) {
                congMsg = "Congratulations You Win :)";
            } else {
                congMsg = "Sorry but " + player2 + " Wins :(";
            }
        } else if (isGameOver) {
            congMsg = "Tie - There is no Winners!";
            txtPlayer.setText("No Winners!");
        }

        if (isGameOver && playingMode != PlayingMode.Show) {
            Optional<ButtonType> result = Alerts.showYesNoAlert(Alert.AlertType.NONE, "Save State", "Do you want to save", "Do you want to save this board");
            if (result.get() == ButtonType.YES) {
                DBLayer DB = new DBLayer();
                //int ID, String username, Boolean is_win, Boolean is_frist, String user2Name, String XorO, String board, String time
                DB.insertGame(DBLayer.username, (checkWin == 0 ? null : (checkWin > 0 && isMyTurn ? true : false)), isFirstMove, player2, p1PlayWith.toString(), boardState, txtTime.getText());
            }

            animation = new Animation(congMsg);

            Stage stage = new Stage();
            Scene scene = new Scene(animation);
            stage.setTitle(congMsg);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(tictactoe.TicTacToe.primaryStage);
            stage.showAndWait();

            if (animation.isPlayAgain) {
                boolean isMyTurn = (new Random().nextInt(20) < 10 ? true : false);
                Stage nextStage = tictactoe.TicTacToe.primaryStage;
                Parent root;
                if (playingMode == PlayingMode.Computer) {
                    nextStage.setTitle(this.player1 + " VS PC");
                    root = new Board(PlayingMode.Computer, this.player1, "PC", isMyTurn, null);
                    nextStage.setScene(new Scene(root));
                } else if (playingMode == PlayingMode.Friend) {
                    String friendName = Alerts.getInput("Game Name", "What's your friend name?", "Please enter your friend name");
                    if (friendName != null) {
                        if (friendName.length() == 0) {
                            friendName = "Guest";
                        }

                        nextStage.setTitle(this.player1 + " VS " + friendName);
                        root = new Board(PlayingMode.Friend, this.player1, friendName, isMyTurn, null);
                        nextStage.setScene(new Scene(root));
                    }
                } else if (playingMode == PlayingMode.Online) {
                    OnlineUsers onlineUsers = (OnlineUsers) TicTacToe.scenes.peek().getRoot();
                    if (onlineUsers.lvUsers.getSelectionModel().getSelectedItem() != null) {
                        String selectedSocket = ((User) onlineUsers.lvUsers.getSelectionModel().getSelectedItem()).socket;
                        client.sendMessage(Commands.REQUEST.toString() + "-" + player1 + "-" + selectedSocket.toString());
                    } else {
                        Alerts.showAlert(Alert.AlertType.CONFIRMATION, "Disconnect", "Your friend disconnected", "Your friend might be disconnected or playing another game");
                    }
                }
            }

        }

        if (!isGameOver) {
            isMyTurn = !isMyTurn;
            switchStyle();
        }

    }

    public void withdraw() {
        isGameOver = true;
        boardView.setDisable(true);
        Alerts.showAlert(Alert.AlertType.INFORMATION, "You win", "Congratulations you win!", player2 + " withdrawen");
    }

    private int getPCMove() {
        minMaxRoot = minMaxRoot.findNextMove(minMaxRoot, board);
        nextMove = minMaxRoot.moveInfo;
        return getDecimalLoc(nextMove);
    }

    private int getDecimalLoc(MovingInfo location) {
        if (location.locX == 0) {
            return location.locY + 1;
        } else if (location.locX == 1) {
            return location.locY + 4;
        } else {
            return location.locY + 7;
        }
    }

    private void startTimer() {
        LocalDateTime startTimer = LocalDateTime.of(1, 1, 1, 0, 0, 0);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("mm:ss");
        timerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int addSecond = 1;
                while (true && !isGameOver) {
                    LocalDateTime elipsed = startTimer.plusSeconds(addSecond++);
                    Platform.runLater(() -> {
                        txtTime.setText(dtf.format(elipsed));
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        timerThread.start();
    }

    private void switchStyle() {
        String oldStyle = "", newStyle = "";

        if (isMyTurn) {
            txtPlayer.setText(player1);
        } else {
            txtPlayer.setText(player2);
        }

        if ((p1PlayWith == Move.X && isMyTurn) || (p2PlayWith == Move.X && !isMyTurn)) {
            oldStyle = "obtn";
            newStyle = "xbtn";
        } else if ((p1PlayWith == Move.O && isMyTurn) || (p2PlayWith == Move.O && !isMyTurn)) {
            oldStyle = "xbtn";
            newStyle = "obtn";
        }

        btn00.getStyleClass().remove(oldStyle);
        btn01.getStyleClass().remove(oldStyle);
        btn02.getStyleClass().remove(oldStyle);
        btn10.getStyleClass().remove(oldStyle);
        btn11.getStyleClass().remove(oldStyle);
        btn12.getStyleClass().remove(oldStyle);
        btn20.getStyleClass().remove(oldStyle);
        btn21.getStyleClass().remove(oldStyle);
        btn22.getStyleClass().remove(oldStyle);

        btn00.getStyleClass().add(newStyle);
        btn01.getStyleClass().add(newStyle);
        btn02.getStyleClass().add(newStyle);
        btn10.getStyleClass().add(newStyle);
        btn11.getStyleClass().add(newStyle);
        btn12.getStyleClass().add(newStyle);
        btn20.getStyleClass().add(newStyle);
        btn21.getStyleClass().add(newStyle);
        btn22.getStyleClass().add(newStyle);
    }

}
