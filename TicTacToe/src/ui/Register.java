package ui;

import database.DBLayer;
import files.ConfigFile;
import helperclasses.Alerts;
import helperclasses.Music;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.TicTacToe;
/**
 *
 * @author Taha
 */
public class Register extends HBox {

    protected final VBox vBox;
    protected final ImageView imageView;
    protected final Label label;
    protected final VBox vBox0;
    protected final HBox hBox;
    protected final GridPane gridPane;
    protected final ColumnConstraints columnConstraints;
    protected final RowConstraints rowConstraints;
    protected final Button btnBack;
    protected final ImageView imageView0;
    protected final HBox hBox0;
    protected final Label label0;
    protected final HBox hBox1;
    protected final TextField txtName;
    protected final HBox hBox2;
    protected final TextField txtUsername;
    protected final HBox hBox3;
    protected final PasswordField txtPassword;
    protected final HBox hBox4;
    protected final CheckBox cbRememberMe;
    protected final HBox hBox5;
    protected final Button btnRegister;

    public Register() {

        vBox = new VBox();
        imageView = new ImageView();
        label = new Label();
        vBox0 = new VBox();
        hBox = new HBox();
        gridPane = new GridPane();
        columnConstraints = new ColumnConstraints();
        rowConstraints = new RowConstraints();
        btnBack = new Button();
        imageView0 = new ImageView();
        hBox0 = new HBox();
        label0 = new Label();
        hBox1 = new HBox();
        txtName = new TextField();
        hBox2 = new HBox();
        txtUsername = new TextField();
        hBox3 = new HBox();
        txtPassword = new PasswordField();
        hBox4 = new HBox();
        cbRememberMe = new CheckBox();
        hBox5 = new HBox();
        btnRegister = new Button();

        setMaxHeight(USE_PREF_SIZE);
        setMaxWidth(USE_PREF_SIZE);
        setMinHeight(USE_PREF_SIZE);
        setMinWidth(USE_PREF_SIZE);
        setPrefHeight(600.0);
        setPrefWidth(800.0);
        getStylesheets().add("/resources/css/style.css");

        vBox.setAlignment(javafx.geometry.Pos.CENTER);
        vBox.setPrefHeight(600.0);
        vBox.setPrefWidth(350.0);
        vBox.setStyle("-fx-background-color: #27aae2;");

        imageView.setFitHeight(150.0);
        imageView.setFitWidth(200.0);
        imageView.setPickOnBounds(true);
        imageView.setPreserveRatio(true);
        imageView.setImage(new Image(getClass().getResource("/resources/imgs/icon.png").toExternalForm()));

        label.setText("Welcome to our games");
        label.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label.setFont(new Font("System Bold", 21.0));

        vBox0.setPrefHeight(600.0);
        vBox0.setPrefWidth(500.0);

        hBox.setPrefHeight(50.0);
        hBox.setPrefWidth(200.0);

        gridPane.setPrefHeight(51.0);
        gridPane.setPrefWidth(333.0);

        columnConstraints.setHgrow(javafx.scene.layout.Priority.SOMETIMES);
        columnConstraints.setMinWidth(10.0);
        columnConstraints.setPrefWidth(100.0);

        rowConstraints.setMinHeight(10.0);
        rowConstraints.setPrefHeight(30.0);
        rowConstraints.setVgrow(javafx.scene.layout.Priority.SOMETIMES);

        GridPane.setHalignment(btnBack, javafx.geometry.HPos.LEFT);
        GridPane.setValignment(btnBack, javafx.geometry.VPos.CENTER);
        btnBack.setMnemonicParsing(false);
        btnBack.setPrefHeight(40.0);
        btnBack.setPrefWidth(66.0);
        btnBack.getStyleClass().add("backbtn");
        GridPane.setMargin(btnBack, new Insets(0.0, 0.0, 0.0, 5.0));

        imageView0.setFitHeight(23.0);
        imageView0.setFitWidth(31.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);
        imageView0.setImage(new Image(getClass().getResource("/resources/imgs/back.png").toExternalForm()));
        btnBack.setGraphic(imageView0);

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        label0.setText("Sign up");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label0.setFont(new Font("System Bold", 22.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);

        txtName.setPrefHeight(50.0);
        txtName.setPrefWidth(270.0);
        txtName.setPromptText("Name");

        hBox2.setAlignment(javafx.geometry.Pos.CENTER);
        hBox2.setPrefHeight(100.0);
        hBox2.setPrefWidth(200.0);

        txtUsername.setPrefHeight(50.0);
        txtUsername.setPrefWidth(270.0);
        txtUsername.setPromptText("Username");

        hBox3.setAlignment(javafx.geometry.Pos.CENTER);
        hBox3.setPrefHeight(100.0);
        hBox3.setPrefWidth(200.0);

        txtPassword.setPrefHeight(50.0);
        txtPassword.setPrefWidth(270.0);
        txtPassword.setPromptText("Password");

        hBox4.setPrefHeight(100.0);
        hBox4.setPrefWidth(200.0);

        cbRememberMe.setMnemonicParsing(false);
        cbRememberMe.setText("Remember me");
        cbRememberMe.setFont(new Font(16.0));
        hBox4.setPadding(new Insets(0.0, 0.0, 0.0, 100.0));
        VBox.setMargin(hBox4, new Insets(0.0, 0.0, 0.0, 5.0));

        hBox5.setAlignment(javafx.geometry.Pos.CENTER);
        hBox5.setPrefHeight(100.0);
        hBox5.setPrefWidth(200.0);

        btnRegister.setMnemonicParsing(false);
        btnRegister.setPrefHeight(50.0);
        btnRegister.setPrefWidth(100.0);
        btnRegister.getStyleClass().add("btn");
        btnRegister.setText("Register");
        btnRegister.setFont(new Font(21.0));

        vBox.getChildren().add(imageView);
        vBox.getChildren().add(label);
        getChildren().add(vBox);
        gridPane.getColumnConstraints().add(columnConstraints);
        gridPane.getRowConstraints().add(rowConstraints);
        gridPane.getChildren().add(btnBack);
        hBox.getChildren().add(gridPane);
        vBox0.getChildren().add(hBox);
        hBox0.getChildren().add(label0);
        vBox0.getChildren().add(hBox0);
        hBox1.getChildren().add(txtName);
        vBox0.getChildren().add(hBox1);
        hBox2.getChildren().add(txtUsername);
        vBox0.getChildren().add(hBox2);
        hBox3.getChildren().add(txtPassword);
        vBox0.getChildren().add(hBox3);
        hBox4.getChildren().add(cbRememberMe);
        vBox0.getChildren().add(hBox4);
        hBox5.getChildren().add(btnRegister);
        vBox0.getChildren().add(hBox5);
        getChildren().add(vBox0);
        setActions();
    }

    private void setActions() {
        btnRegister.setOnAction((ActionEvent ae) -> {
            String name = txtName.getText();
            String username = txtUsername.getText();
            String password = txtPassword.getText();

            if (validation(name, username, password)) {
                DBLayer connection = new DBLayer();

                if (connection.isUsernameExist(username) == false) {
                    int retVal = connection.insertUser(name, username, password);

                    if (retVal != -1) {
                        new Music("btn.mp3", false);
                        if (cbRememberMe.isSelected()) {
                            ConfigFile configFile = new ConfigFile();
                            boolean added = configFile.write(username, password);
                            if (added) {
                                Alerts.showAlert(Alert.AlertType.CONFIRMATION, "Success", "Account added succesfully", "Your account was added succesfully");

                            } else {
                                Alerts.showAlert(Alert.AlertType.ERROR, "Failure", "Failed to add your account", "Your account doen't added");
                            }
                        } else {
                            ConfigFile.file.delete();
                        }

                        Stage myStage = tictactoe.TicTacToe.primaryStage;
                        
                        Scene myScene = new Scene(new ChooseGame(name));
                        myStage.setTitle("Main Page");
                        myStage.setScene(myScene);

                    } else {
                        new Music("wrong.mp3", false);
                        Alerts.showAlert(Alert.AlertType.ERROR, "Failure", "Failed to add your account", "Your account doen't added");
                    }
                } else {
                    new Music("wrong.mp3", false);
                    Alerts.showAlert(Alert.AlertType.WARNING, "Username Exists", "Username exists", "Please type another username");
                }
            } else {
                new Music("wrong.mp3", false);
                Alerts.showAlert(Alert.AlertType.WARNING, "Complete all fields", "Your fileds arne not completed!", "Please make sure you filled all fields and your password at least 6 characters");
            }
        });

        btnBack.setOnAction((event) -> {
            new Music("back.mp3", false);
            Login login = new Login();
            TicTacToe.primaryStage.setTitle("Login");
            tictactoe.TicTacToe.primaryStage.setScene(new Scene(login));
        });

    }

    private boolean validation(String name, String username, String password) {
        return !(name == null || name.trim().isEmpty()
                || username == null || username.trim().isEmpty()
                || password == null || password.trim().isEmpty() || password.length() < 6);
    }
}
