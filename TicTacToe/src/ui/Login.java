package ui;

import database.DBLayer;
import files.ConfigFile;
import helperclasses.Alerts;
import helperclasses.Music;
import java.sql.SQLException;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import tictactoe.TicTacToe;
/**
 *
 * @author Taha 
 */
public class Login extends HBox {

    protected final VBox vBox;
    protected final ImageView imageView;
    protected final Label label;
    protected final VBox vBox0;
    protected final HBox hBox;
    protected final ImageView imageView0;
    protected final Label label0;
    protected final HBox hBox0;
    protected final TextField txtUsername;
    protected final HBox hBox1;
    protected final PasswordField txtPassword;
    protected final HBox hBox2;
    protected final CheckBox cbRememberMe;
    protected final HBox hBox3;
    protected final Button btnLogin;
    protected final Button btnRegister;

    public Login() {

        vBox = new VBox();
        imageView = new ImageView();
        label = new Label();
        vBox0 = new VBox();
        hBox = new HBox();
        imageView0 = new ImageView();
        label0 = new Label();
        hBox0 = new HBox();
        txtUsername = new TextField();
        hBox1 = new HBox();
        txtPassword = new PasswordField();
        hBox2 = new HBox();
        cbRememberMe = new CheckBox();
        hBox3 = new HBox();
        btnLogin = new Button();
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
        vBox0.setPrefWidth(450.0);
        vBox0.setStyle("-fx-background-color: #FFFFFF;");

        hBox.setAlignment(javafx.geometry.Pos.CENTER_LEFT);
        hBox.setPrefHeight(100.0);
        hBox.setPrefWidth(200.0);

        imageView0.setFitHeight(150.0);
        imageView0.setFitWidth(200.0);
        imageView0.setPickOnBounds(true);
        imageView0.setPreserveRatio(true);

        label0.setText("Sign in");
        label0.setTextFill(javafx.scene.paint.Color.valueOf("#e85f7b"));
        label0.setFont(new Font("System Bold", 21.0));

        hBox0.setAlignment(javafx.geometry.Pos.CENTER);
        hBox0.setPrefHeight(100.0);
        hBox0.setPrefWidth(200.0);

        txtUsername.setPrefHeight(50.0);
        txtUsername.setPrefWidth(270.0);
        txtUsername.setPromptText("username");
        txtUsername.setFont(new Font(21.0));

        hBox1.setAlignment(javafx.geometry.Pos.CENTER);
        hBox1.setPrefHeight(100.0);
        hBox1.setPrefWidth(200.0);

        txtPassword.setPrefHeight(50.0);
        txtPassword.setPrefWidth(270.0);
        txtPassword.setPromptText("password");
        txtPassword.setFont(new Font(21.0));

        hBox2.setPrefHeight(50.0);
        hBox2.setPrefWidth(270.0);

        cbRememberMe.setMnemonicParsing(false);
        cbRememberMe.setText("Remember me");
        cbRememberMe.setFont(new Font(16.0));
        HBox.setMargin(cbRememberMe, new Insets(0.0));
        hBox2.setPadding(new Insets(0.0, 0.0, 0.0, 80.0));

        hBox3.setAlignment(javafx.geometry.Pos.CENTER);
        hBox3.setPrefHeight(100.0);
        hBox3.setPrefWidth(200.0);

        btnLogin.setMnemonicParsing(false);
        btnLogin.setPrefHeight(50.0);
        btnLogin.setPrefWidth(100.0);
        btnLogin.getStyleClass().add("btn");
        btnLogin.setText("Log in");
        HBox.setMargin(btnLogin, new Insets(0.0, 5.0, 0.0, 0.0));

        btnRegister.setMnemonicParsing(false);
        btnRegister.setPrefHeight(50.0);
        btnRegister.setPrefWidth(100.0);
        btnRegister.getStyleClass().add("btn");
        btnRegister.setText("Sign up");
        HBox.setMargin(btnRegister, new Insets(0.0, 0.0, 0.0, 5.0));
        vBox0.setPadding(new Insets(0.0, 0.0, 0.0, 20.0));

        vBox.getChildren().add(imageView);
        vBox.getChildren().add(label);
        getChildren().add(vBox);
        hBox.getChildren().add(imageView0);
        hBox.getChildren().add(label0);
        vBox0.getChildren().add(hBox);
        hBox0.getChildren().add(txtUsername);
        vBox0.getChildren().add(hBox0);
        hBox1.getChildren().add(txtPassword);
        vBox0.getChildren().add(hBox1);
        hBox2.getChildren().add(cbRememberMe);
        vBox0.getChildren().add(hBox2);
        hBox3.getChildren().add(btnLogin);
        hBox3.getChildren().add(btnRegister);
        vBox0.getChildren().add(hBox3);
        getChildren().add(vBox0);

        setActions();
    }

    private void setActions() {
        btnLogin.setOnAction((event) -> {
            DBLayer connection = new DBLayer();

            String username, password;
            username = txtUsername.getText();
            password = txtPassword.getText();

            if (username.length() > 0 && password.length() > 0) {
                String name = connection.dbLogin(username, password);

                if (name != null) {
                    new Music("btn.mp3", false);
                    Stage myStage = tictactoe.TicTacToe.primaryStage;
                    Scene myScene = new Scene(new ChooseGame(name));
                    myStage.setTitle("Main Page");
                    myStage.setScene(myScene);
                    if (cbRememberMe.isSelected()) {
                        ConfigFile configFile = new ConfigFile();
                        configFile.write(username, password);
                    } else {
                        ConfigFile.file.delete();
                    }
                } else {
                    new Music("wrong.mp3", false);
                    Alerts.showAlert(Alert.AlertType.NONE, "Login Failed", "username or password incorrect", "Please check your username and password and try again!");
                }
            } else {
                new Music("wrong.mp3", false);
                Alerts.showAlert(Alert.AlertType.NONE, "Incomplete data", "Enter username and password", "Please enter your username and password");
            }
        });

        btnRegister.setOnAction((event) -> {
            new Music("btn.mp3", false);
            Stage myStage = tictactoe.TicTacToe.primaryStage;
            TicTacToe.primaryStage.setTitle("Register");
            Scene myScene = new Scene(new Register());
            myStage.setTitle("Register");
            myStage.setScene(myScene);
        });
    }
}
