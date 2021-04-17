/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package online;

import helperclasses.Alerts;
import helperclasses.Commands;
import helperclasses.Music;
import helperclasses.PlayingMode;
import helperclasses.User;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import tictactoe.TicTacToe;
import ui.Board;
import ui.OnlineUsers;

/**
 *
 * @author Mohamed Elsayed
 */
public class Client extends Thread {

    Socket serverSocket;
    DataInputStream dis;
    PrintStream ps;
    List<User> users;
    public boolean isConnectedWithServer = false, inGame = false;
    public String inGameWithSocket;
    public String name;
    //  Stage loobyStage = null, boardStage = null;

    public Client(String name) {
        users = new ArrayList<User>();
        this.name = name;

        try {
            serverSocket = new Socket("127.0.0.1", 2020);
            dis = new DataInputStream(serverSocket.getInputStream());
            ps = new PrintStream(serverSocket.getOutputStream());
            isConnectedWithServer = true;

            start();
            this.sendMessage(Commands.OPEN.toString() + "-" + name);
        } catch (IOException ex) {
            new Music("wrong.mp3", false);
            Alerts.showAlert(Alert.AlertType.ERROR, "Connection Problem", "Can't connect with server", "Please check your server connection and try again");
            isConnectedWithServer = false;
        }
    }

    public boolean isConnected() {
        return isConnectedWithServer;
    }

    public void sendMessage(String message) {
        ps.println(message);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void run() {
        while (true) {
            String msg = new String();
            try {
                msg = dis.readLine();

                if (msg != null && msg.length() > 0 && msg.contains("-")) {
                    List<String> info = Arrays.asList(msg.split("-"));
                    if (msg.startsWith("Socket")) {
                        // Getting all available users (online users)
                        // Socket-Name
                        if (!info.get(1).equals(Commands.NONE.toString())) {
                            User user = new User(info.get(0), info.get(1));
                            users.add(user);
                            if (!inGame) {
                                Platform.runLater(() -> {
                                    ((OnlineUsers) tictactoe.TicTacToe.primaryStage.getScene().getRoot()).lvUsers.getItems().add(user);
                                });
                            } else {
                                Platform.runLater(() -> {
                                    ((OnlineUsers) tictactoe.TicTacToe.scenes.peek().getRoot()).lvUsers.getItems().add(user);
                                });
                            }

                        } else {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Alerts.showAlert(Alert.AlertType.INFORMATION, "No Players!", "No available players!", "There is no available players to play with them!");
                                }
                            });

                            inGame = false;
                            inGameWithSocket = null;
                        }
                    } else if (msg.startsWith(Commands.CLOSE.toString())) {
                        // CLOSE-Name-Socket
                        for (int i = 0; i < users.size(); i++) {
                            if (users.get(i).socket.equals(info.get(2))) {
                                users.remove(users.get(i));
                                final int remove = i;
                                if (!inGame) {
                                    Platform.runLater(() -> {
                                        ((OnlineUsers) TicTacToe.primaryStage.getScene().getRoot()).lvUsers.getItems().remove(remove);
                                    });
                                } else {
                                    ((OnlineUsers) tictactoe.TicTacToe.scenes.peek().getRoot()).lvUsers.getItems().remove(remove);
                                }
                                break;
                            }
                        }
                    } // REQUEST-Name-Destination-Source
                    else if (msg.startsWith(Commands.REQUEST.toString())) {

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                Optional<ButtonType> result = Alerts.showYesNoAlert(Alert.AlertType.NONE, info.get(1), "Request from " + info.get(1), "Your friend " + info.get(1) + " wants to play with you!");

                                String Replay = "N";
                                boolean myTurn = (new Random().nextInt(20) < 10 ? true : false);

                                if (result.get().equals(ButtonType.YES)) {
                                    Replay = "Y";
                                    inGame = true;
                                    inGameWithSocket = info.get(3);

                                    Platform.runLater(() -> {
                                        // Board(PlayingMode playingMode, String player1, String player2, boolean isMyTurn, Client client)
                                        Board board = new Board(PlayingMode.Online, name, info.get(1), myTurn, Client.this);
                                        TicTacToe.scenes.push(TicTacToe.primaryStage.getScene());
                                        TicTacToe.primaryStage.setTitle(name + " VS " + info.get(1));
                                        TicTacToe.primaryStage.setScene(new Scene(board));
                                    });
                                }

                                // REPLAY-Name-Replay(Y/N)-MyTurn(Y/N)-Source-Destination
                                sendMessage(Commands.REPLAY.toString() + "-" + name + "-" + Replay + "-" + (myTurn ? "N" : "Y") + "-" + info.get(2) + "-" + info.get(3));
                            }
                        });

                    } else if (msg.startsWith(Commands.REPLAY.toString())) {
                        // REPLAY-Name-Replay(Y/N)-MyTurn(Y/N)-Source-Destination
                        if (info.get(2).equals("Y")) {
                            // INGAME-P1Socket-P2Socket
                            sendMessage(Commands.INGAME + "-" + info.get(4) + "-" + info.get(5));
                            inGame = true;
                            inGameWithSocket = info.get(4);

                            Platform.runLater(() -> {
                                boolean myTurn = info.get(3).equals("Y");
                                Board board = new Board(PlayingMode.Online, name, info.get(1), myTurn, Client.this);
                                TicTacToe.scenes.push(TicTacToe.primaryStage.getScene());
                                TicTacToe.primaryStage.setTitle(name + " VS " + info.get(1));
                                TicTacToe.primaryStage.setScene(new Scene(board));
                            });
                        } else {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    Alerts.showAlert(Alert.AlertType.INFORMATION, "Rejected!", "Request rejected!", "Your friend " + info.get(1) + " rejected your request!");
                                }
                            });

                            inGame = false;
                            inGameWithSocket = null;
                        }
                    } else if (msg.startsWith(Commands.PLAY.toString())) {
                        // PLAY-(Location)
                        Board board = (Board) TicTacToe.primaryStage.getScene().getRoot();
                        if (board.isLoaded) {
                            Platform.runLater(() -> {
                                board.setLocation(Integer.parseInt(info.get(1)));
                            });
                        } else {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    while (!board.isLoaded) {
                                        try {
                                            Thread.sleep(500);
                                        } catch (InterruptedException ex) {
                                            ex.printStackTrace();
                                        }
                                    }
                                    Platform.runLater(() -> {
                                        board.setLocation(Integer.parseInt(info.get(1)));
                                    });
                                }
                            }).start();
                        }

                    } else if (msg.startsWith(Commands.Withdraw.toString())) {
                        // Withdraw-name
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                ((Board) TicTacToe.primaryStage.getScene().getRoot()).withdraw();
                                inGameWithSocket = null;
                            }
                        });
                    }
                } else {
                    ps.close();
                    dis.close();
                    serverSocket.close();

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            Alerts.showAlert(Alert.AlertType.ERROR, "Server Disconnected!", "Failed to connect with server!", "Connection with server cuts you are going to leave this page!");
                            TicTacToe.primaryStage.setTitle("Main Page");
                            TicTacToe.primaryStage.setScene(TicTacToe.scenes.pop());
                        }
                    });

                    inGame = false;
                    inGameWithSocket = null;
                    break;
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void closeClient() {
        try {
            // CLOSE-Name
            sendMessage(Commands.CLOSE.toString() + "-" + name);
            Thread.sleep(10);
            sendMessage(Commands.NONE.toString());
            stop();
            ps.close();
            dis.close();
            serverSocket.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
