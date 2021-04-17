package ui;

import database.DBLayer;
import helperclasses.Alerts;
import helperclasses.Music;
import helperclasses.PlayingMode;
import helperclasses.Result;
import java.util.List;
import java.util.Random;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import online.Client;
import tictactoe.TicTacToe;

public class MainPage extends GridPane {

    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final RowConstraints rowConstraints0;
    protected final RowConstraints rowConstraints1;
    protected final Button btnBack;
    protected final ImageView imageView;
    protected final SplitPane splitPane;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints0;
    protected final ColumnConstraints columnConstraints1;
    protected final ColumnConstraints columnConstraints2;
    protected final ColumnConstraints columnConstraints3;
    protected final ColumnConstraints columnConstraints4;
    protected final ColumnConstraints columnConstraints5;
    protected final RowConstraints rowConstraints2;
    protected final ImageView imageView0;
    protected final Label txtName;
    protected final Label txtWins;
    protected final Label txtLoses;
    protected final Label label2;
    protected final Label label3;
    protected final ImageView imageView1;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints6;
    protected final ColumnConstraints columnConstraints7;
    protected final ColumnConstraints columnConstraints8;
    protected final RowConstraints rowConstraints3;
    protected final Button btnVSPC;
    protected final Button btnVSFriend;
    protected final Button btnOnline;
    protected final Button btnShowResults;
/**
 *
 * @author Asmaa Elbanaa
 */
    Parent root;
    Client client;
    String name;

    public MainPage(String name) {
        this.name = name;

        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        rowConstraints0 = new RowConstraints();
        rowConstraints1 = new RowConstraints();
        btnBack = new Button();
        imageView = new ImageView();
        splitPane = new SplitPane();
        gridPane = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        columnConstraints1 = new ColumnConstraints();
        columnConstraints2 = new ColumnConstraints();
        columnConstraints3 = new ColumnConstraints();
        columnConstraints4 = new ColumnConstraints();
        columnConstraints5 = new ColumnConstraints();
        rowConstraints2 = new RowConstraints();
        imageView0 = new ImageView();
        txtName = new Label();
        txtWins = new Label();
        txtLoses = new Label();
        label2 = new Label();
        label3 = new Label();
        imageView1 = new ImageView();
        gridPane0 = new GridPane();
        columnConstraints6 = new ColumnConstraints();
        columnConstraints7 = new ColumnConstraints();
        columnConstraints8 = new ColumnConstraints();
        rowConstraints3 = new RowConstraints();
        btnVSPC = new Button();
        btnVSFriend = new Button();
        btnOnline = new Button();
        btnShowResults = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(800.0);
        getStylesheets().add("/resources/css/style.css");
        String image = getClass().getResource("/resources/imgs/background.png").toExternalForm();
        this.setStyle("-fx-background-image: url('" + image + "'); "
                + "-fx-background-position: center center; "
                + "-fx-background-repeat: None;");

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMaxHeight(50.0);
        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPercentHeight(0.0);
        rowConstraints.setPrefHeight(50.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        rowConstraints1.setMaxHeight(150.0);
        rowConstraints1.setMinHeight(10.0);
        rowConstraints1.setPrefHeight(50.0);
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

        GridPane.setRowIndex(splitPane, 1);
        splitPane.setDividerPositions(0.5);
        splitPane.setOrientation(javafx.geometry.Orientation.VERTICAL);
        splitPane.setPrefWidth(160.0);

        gridPane.setMaxHeight(70.0);
        gridPane.setMinHeight(70.0);
        gridPane.setPrefHeight(70.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMaxWidth(100.0);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        columnConstraints1.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints1.setMinWidth(10.0);
        columnConstraints1.setPrefWidth(100.0);

        columnConstraints2.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints2.setMaxWidth(100.0);
        columnConstraints2.setMinWidth(10.0);
        columnConstraints2.setPrefWidth(100.0);

        columnConstraints3.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints3.setMaxWidth(130.0);
        columnConstraints3.setMinWidth(10.0);
        columnConstraints3.setPrefWidth(70.0);

        columnConstraints4.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints4.setMaxWidth(100.0);
        columnConstraints4.setMinWidth(10.0);
        columnConstraints4.setPrefWidth(100.0);

        columnConstraints5.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints5.setMaxWidth(130.0);
        columnConstraints5.setMinWidth(10.0);
        columnConstraints5.setPrefWidth(50.0);

        rowConstraints2.setMinHeight(10.0);
        rowConstraints2.setPrefHeight(30.0);
        rowConstraints2.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        imageView0.setFitHeight(76.0);
        imageView0.setFitWidth(86.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);

        GridPane.setColumnIndex(txtName, 1);
        GridPane.setHalignment(txtName, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(txtName, javafx.geometry.VPos.CENTER);
        txtName.setAlignment(javafx.geometry.Pos.CENTER);
        txtName.setPrefWidth(200.0);
        txtName.getStyleClass().add("txt");
        txtName.setText("Name");
        txtName.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        txtName.setFont(new Font("System Bold", 18.0));

        GridPane.setColumnIndex(txtWins, 3);
        GridPane.setHalignment(txtWins, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(txtWins, javafx.geometry.VPos.CENTER);
        txtWins.setAlignment(javafx.geometry.Pos.CENTER);
        txtWins.setPrefWidth(70.0);
        txtWins.getStyleClass().add("txt");
        txtWins.setText("10");
        txtWins.setTextAlignment(javafx.scene.text.TextAlignment.CENTER);
        txtWins.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        txtWins.setFont(new Font("System Bold", 18.0));
        GridPane.setMargin(txtWins, new Insets(0.0));

        GridPane.setColumnIndex(txtLoses, 5);
        GridPane.setHalignment(txtLoses, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(txtLoses, javafx.geometry.VPos.CENTER);
        txtLoses.setAlignment(javafx.geometry.Pos.CENTER);
        txtLoses.setPrefWidth(70.0);
        txtLoses.getStyleClass().add("txt");
        txtLoses.setText("15");
        txtLoses.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        txtLoses.setFont(new Font("System Bold", 18.0));
        GridPane.setMargin(txtLoses, new Insets(0.0));

        GridPane.setColumnIndex(label2, 2);
        GridPane.setHalignment(label2, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label2, javafx.geometry.VPos.CENTER);
        label2.setText("Wins");
        label2.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label2.setFont(new Font("System Bold", 20.0));
        label2.setOpaqueInsets(new Insets(0.0));
        GridPane.setMargin(label2, new Insets(0.0));

        GridPane.setColumnIndex(label3, 4);
        GridPane.setHalignment(label3, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(label3, javafx.geometry.VPos.CENTER);
        label3.setText("Losses");
        label3.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label3.setFont(new Font("System Bold", 20.0));
        GridPane.setMargin(label3, new Insets(0.0));

        GridPane.setHalignment(imageView1, javafx.geometry.HPos.RIGHT);
        GridPane.setValignment(imageView1, javafx.geometry.VPos.CENTER);
        imageView1.setFitHeight(40.0);
        imageView1.setFitWidth(45.0);
        imageView1.setImage(new Image(getClass().getResource("/resources/imgs/man.png").toExternalForm()));
        GridPane.setMargin(imageView1, new Insets(5.0, 0.0, 5.0, 0.0));

        columnConstraints6.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints6.setMinWidth(10.0);
        columnConstraints6.setPrefWidth(100.0);

        columnConstraints7.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints7.setMinWidth(10.0);
        columnConstraints7.setPrefWidth(100.0);

        columnConstraints8.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints8.setMinWidth(10.0);
        columnConstraints8.setPrefWidth(100.0);

        rowConstraints3.setMinHeight(10.0);
        rowConstraints3.setPrefHeight(30.0);
        rowConstraints3.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btnVSPC, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btnVSPC, javafx.geometry.VPos.CENTER);
        btnVSPC.setMnemonicParsing(false);
        btnVSPC.setPrefHeight(70.0);
        btnVSPC.setPrefWidth(140.0);
        btnVSPC.getStyleClass().add("btn");
        btnVSPC.setText("VS  COMPUTER");

        GridPane.setColumnIndex(btnVSFriend, 1);
        GridPane.setHalignment(btnVSFriend, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btnVSFriend, javafx.geometry.VPos.CENTER);
        btnVSFriend.setMnemonicParsing(false);
        btnVSFriend.setPrefHeight(70.0);
        btnVSFriend.setPrefWidth(140.0);
        btnVSFriend.getStyleClass().add("btn");
        btnVSFriend.setText("VS FRIEND");

        GridPane.setColumnIndex(btnOnline, 2);
        GridPane.setHalignment(btnOnline, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btnOnline, javafx.geometry.VPos.CENTER);
        btnOnline.setMnemonicParsing(false);
        btnOnline.setPrefHeight(70.0);
        btnOnline.setPrefWidth(140.0);
        btnOnline.getStyleClass().add("btn");
        btnOnline.setText("ONLINE");

        GridPane.setHalignment(btnShowResults, javafx.geometry.HPos.CENTER);
        GridPane.setRowIndex(btnShowResults, 2);
        GridPane.setValignment(btnShowResults, javafx.geometry.VPos.CENTER);
        btnShowResults.setMnemonicParsing(false);
        btnShowResults.setPrefHeight(50.0);
        btnShowResults.setPrefWidth(160.0);
        btnShowResults.getStyleClass().add("btn");
        btnShowResults.setText("SHOW RESULTS");
        setPadding(new Insets(10.0, 0.0, 0.0, 0.0));

        getColumnConstraints().add(columnConstraints);
        getRowConstraints().add(rowConstraints);
        getRowConstraints().add(rowConstraints0);
        getRowConstraints().add(rowConstraints1);
        getChildren().add(btnBack);
        gridPane.getColumnConstraints().add(columnConstraints0);
        gridPane.getColumnConstraints().add(columnConstraints1);
        gridPane.getColumnConstraints().add(columnConstraints2);
        gridPane.getColumnConstraints().add(columnConstraints3);
        gridPane.getColumnConstraints().add(columnConstraints4);
        gridPane.getColumnConstraints().add(columnConstraints5);
        gridPane.getRowConstraints().add(rowConstraints2);
        gridPane.getChildren().add(imageView0);
        gridPane.getChildren().add(txtName);
        gridPane.getChildren().add(txtWins);
        gridPane.getChildren().add(txtLoses);
        gridPane.getChildren().add(label2);
        gridPane.getChildren().add(label3);
        gridPane.getChildren().add(imageView1);
        splitPane.getItems().add(gridPane);
        gridPane0.getColumnConstraints().add(columnConstraints6);
        gridPane0.getColumnConstraints().add(columnConstraints7);
        gridPane0.getColumnConstraints().add(columnConstraints8);
        gridPane0.getRowConstraints().add(rowConstraints3);
        gridPane0.getChildren().add(btnVSPC);
        gridPane0.getChildren().add(btnVSFriend);
        gridPane0.getChildren().add(btnOnline);

        splitPane.getItems().add(gridPane0);
        getChildren().add(splitPane);
        getChildren().add(btnShowResults);

        splitPane.getStyleClass().add("trans");
        gridPane.getStyleClass().add("reg");

        init();
        setActions();
    }

    public void init() {
        DBLayer DB = new DBLayer();
        txtName.setText(name);
        txtWins.setText("" + DB.countWin(true, DBLayer.username));
        txtLoses.setText("" + DB.countWin(false, DBLayer.username));
    }

    private void setActions() {
        btnVSPC.setOnAction((event) -> {
            new Music("btn.mp3", false);
            Stage stage = tictactoe.TicTacToe.primaryStage;
            stage.setTitle(this.name + " VS PC");

            // Board(PlayingMode playingMode, String player1, String player2, boolean isMyTurn, Client client)
            boolean isMyTurn = (new Random().nextInt(20) < 10 ? true : false);
            root = new Board(PlayingMode.Computer, this.name, "PC", isMyTurn, null);

            stage.setScene(new Scene(root));
            TicTacToe.scenes.add(this.getScene());
        });

        btnVSFriend.setOnAction((event) -> {
            new Music("btn.mp3", false);
            String friendName = Alerts.getInput("Game Name", "What's your friend name?", "Please enter your friend name");
            if (friendName != null) {
                if (friendName.length() == 0) {
                    friendName = "Guest";
                }

                Stage stage = tictactoe.TicTacToe.primaryStage;
                stage.setTitle(this.name + " VS " + friendName);
                // Board(PlayingMode playingMode, String player1, String player2, boolean isMyTurn, Client client)
                boolean isMyTurn = (new Random().nextInt(20) < 10 ? true : false);
                root = new Board(PlayingMode.Friend, this.name, friendName, isMyTurn, null);
                stage.setScene(new Scene(root));
                TicTacToe.scenes.add(this.getScene());
            }
        });

        btnOnline.setOnAction((event) -> {
            new Music("btn.mp3", false);
            client = new Client(name);

            if (client.isConnected()) {
                Stage stage = TicTacToe.primaryStage;
                stage.setTitle(this.name + "'s Looby");
                root = new OnlineUsers(client);
                stage.setScene(new Scene(root));
                TicTacToe.scenes.add(this.getScene());
            }
        });

        btnShowResults.setOnAction((event) -> {
            new Music("btn.mp3", false);
            DBLayer DB = new DBLayer();
            List<Result> myResults = DB.getMyLastGames(DBLayer.username);
            if (myResults.size() > 0) {
                Stage stage = TicTacToe.primaryStage;
                stage.setTitle("My Results");
                root = new ShowResults(myResults);
                stage.setScene(new Scene(root));
                TicTacToe.scenes.add(this.getScene());

            } else {
                Alerts.showAlert(Alert.AlertType.INFORMATION, "No Results", "No Results", "You didn't save any results yet!");
            }
        });

        btnBack.setOnAction((event) -> {
            new Music("back.mp3", false);
            TicTacToe.primaryStage.setTitle("Choose Game");
            TicTacToe.primaryStage.setScene(TicTacToe.scenes.pop());
        });
    }

}
