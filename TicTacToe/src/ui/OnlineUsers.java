package ui;

import helperclasses.Alerts;
import helperclasses.Commands;
import helperclasses.Music;
import helperclasses.User;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.WindowEvent;
import online.Client;
import tictactoe.TicTacToe;
/**
 *
 * @author Mohamed Elsayed
 */
public class OnlineUsers extends BorderPane {

    public final ListView<User> lvUsers;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final Button btnRequest;
    protected final GridPane gridPane0;
    protected final ColumnConstraints columnConstraints0;
    protected final RowConstraints rowConstraints0;
    protected final Button btnBack;
    protected final ImageView imageView;

    Parent onlineGameBoard;
    String selectedSocket = null;

    Client client;
    String name;

    public OnlineUsers(Client client) {
        this.client = client;
        this.name = client.name;

        lvUsers = new ListView();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        btnRequest = new Button();
        gridPane0 = new GridPane();
        columnConstraints0 = new ColumnConstraints();
        rowConstraints0 = new RowConstraints();
        btnBack = new Button();
        imageView = new ImageView();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(500.0);
        setPrefWidth(350.0);
        getStylesheets().add("/resources/css/style.css");

        BorderPane.setAlignment(lvUsers, javafx.geometry.Pos.CENTER);
        lvUsers.setPrefHeight(200.0);
        lvUsers.setPrefWidth(200.0);
        BorderPane.setMargin(lvUsers, new Insets(5.0));
        setCenter(lvUsers);

        BorderPane.setAlignment(gridPane, javafx.geometry.Pos.CENTER);
        gridPane.setMinHeight(55.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btnRequest, javafx.geometry.HPos.CENTER);
        GridPane.setValignment(btnRequest, javafx.geometry.VPos.CENTER);
        btnRequest.setMnemonicParsing(false);
        btnRequest.setPrefHeight(27.0);
        btnRequest.setPrefWidth(100.0);
        btnRequest.getStyleClass().add("btn");
        btnRequest.getStylesheets().add("/resources/css/style.css");
        btnRequest.setText("Request");
        setBottom(gridPane);

        BorderPane.setAlignment(gridPane0, javafx.geometry.Pos.CENTER);
        gridPane0.setPrefHeight(50.0);
        gridPane0.setPrefWidth(214.0);

        columnConstraints0.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints0.setMinWidth(10.0);
        columnConstraints0.setPrefWidth(100.0);

        rowConstraints0.setMinHeight(10.0);
        rowConstraints0.setPrefHeight(30.0);
        rowConstraints0.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btnBack, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(btnBack, javafx.geometry.VPos.CENTER);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(40.0);
        btnBack.setPrefWidth(66.0);
        btnBack.getStyleClass().add("backbtn");
        GridPane.setMargin(btnBack, new Insets(0.0, 0.0, 0.0, 5.0));

        imageView.setFitHeight(23.0);
        imageView.setFitWidth(31.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/imgs/back.png").toExternalForm()));
        btnBack.setGraphic(imageView);
        setTop(gridPane0);

        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(btnRequest);
        gridPane0.getColumnConstraints().add(columnConstraints0);
        gridPane0.getRowConstraints().add(rowConstraints0);
        gridPane0.getChildren().add(btnBack);

        setActions();
    }

    private void setActions() {

        tictactoe.TicTacToe.primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent e) {
                if (client != null && !client.inGame) {
                    client.closeClient();
                }
            }
        });

        btnRequest.setOnAction((event) -> {
            new Music("request.mp3", false);
            // Request-Name-Source-Destination
            if (lvUsers.getSelectionModel().getSelectedItem() != null) {
                selectedSocket = ((User) lvUsers.getSelectionModel().getSelectedItem()).socket;
                client.sendMessage(Commands.REQUEST.toString() + "-" + name + "-" + selectedSocket.toString());
            } else {
                Alerts.showAlert(Alert.AlertType.CONFIRMATION, "Select", "Select a player", "Please select your player");
            }
        });

        btnBack.setOnAction((event) -> {
            new Music("back.mp3", false);
            client.inGame = false;
            if (client != null && !client.inGame) {
                client.closeClient();
            }

            MainPage mainPage = (MainPage) tictactoe.TicTacToe.scenes.peek().getRoot();
            mainPage.init();

            TicTacToe.primaryStage.setTitle("Main Page");
            TicTacToe.primaryStage.setScene(tictactoe.TicTacToe.scenes.pop());
        });

        lvUsers.setCellFactory(param -> new ListCell<User>() {
            @Override
            protected void updateItem(User item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null || item.name == null) {
                    setText(null);
                } else {
                    setText(item.name);
                }
            }
        });
    }

}
