/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import files.ConfigFile;
import helperclasses.Music;
import ui.Login;
import helperclasses.User;
import java.awt.Toolkit;
import java.util.Random;
import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import ui.ChooseGame;
import ui.MainPage;

/**
 *
 * @author Mohamed Elsayed
 */
public class TicTacToe extends Application {

    public static Stage primaryStage;
    public static Stack<Scene> scenes;
    public static Music mybackgroundMusic;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        Image myIcon = new Image("/resources/imgs/icon.png");
        primaryStage.getIcons().add(myIcon);
        scenes = new Stack<>();
        Parent root = null;

        if (ConfigFile.file.exists()) {
            ConfigFile configFile = new ConfigFile();
            User user = configFile.readAndLogin();

            if (user != null) {
                root = new ChooseGame(user.name);
                primaryStage.setTitle(user.name);
            } else {
                root = new Login();
                primaryStage.setTitle("Login");
            }

        } else {
            root = new Login();
            primaryStage.setTitle("Login");
        }

        Scene scene = new Scene(root);

        primaryStage.setResizable(false);
        primaryStage.setScene(scene);

        mybackgroundMusic = new Music("background" + new Random().nextInt(3) + ".mp3", true);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
