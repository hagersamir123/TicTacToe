/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import helperclasses.Alerts;
import helperclasses.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;

/**
 *
 * @author Hager Samer
 */
public class DBLayer {

    String url, uname, pass;
    Connection con;
    Statement st;

    public static int ID;
    public static String username;

    public DBLayer() {
        url = "jdbc:mysql://localhost:3306/xoGames";
        uname = "xoUser";
        pass = "xoUser123";
    }

    private void open() {
        try {
            con = DriverManager.getConnection(url, uname, pass);
            st = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex) {
            Alerts.showAlert(Alert.AlertType.ERROR, "Connection Failed", "Can't cnonnect with DB", "Please Check your DB connection!");
            ex.printStackTrace();
        }

    }

    public String dbLogin(String username, String password) {
        open();
        String result = null;
        try {
            ResultSet rs = st.executeQuery("SELECT ID, Name FROM user WHERE UserName='" + username + "' AND Password='" + password + "'");
            if (rs.isBeforeFirst()) {
                rs.first();

                this.ID = rs.getInt(1);
                this.username = username;

                result = rs.getString(2);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        close();
        return result;
    }

    public boolean isUsernameExist(String username) {
        open();
        boolean result = false;
        try {
            ResultSet rs = st.executeQuery("SELECT ID FROM user WHERE UserName='" + username + "'");
            if (!rs.isBeforeFirst()) {
                Alerts.showAlert(Alert.AlertType.NONE, "Username Exists", "The username is exist", "Please enter another username");
            } else {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        close();
        return result;
    }

    public List<Result> getMyLastGames(String username) {
        open();
        List<Result> myResults = new ArrayList<>();
        try {
            //select data from game table
            ResultSet result = st.executeQuery("SELECT * FROM game WHERE UserName='" + username + "' ORDER BY ID DESC LIMIT 10");
            while (result.next()) {
                // Result(int ID, String board, String time, Boolean isWin, boolean isFirst, String friendName, String XO, String username)
                myResults.add(new Result(result.getInt("ID"), result.getString("Board"), result.getString("Time"), (Boolean) result.getObject("Is_Win"), result.getBoolean("Is_frist"), result.getString("User2Name"), result.getString("XorY")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        close();
        return myResults;
    }

    public int insertUser(String name, String username, String password) {
        int ret = -1;
        open();
        try {
            ret = st.executeUpdate("INSERT INTO user (Name, UserName, Password) VALUES('" + name + "', '" + username + "', '" + password + "');");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        close();
        return ret;
    }

    public int insertGame(String username, Boolean is_win, Boolean is_frist, String user2Name, String XorO, String board, String time) {
        int ret = -1;
        open();
        try {
            ret = st.executeUpdate("INSERT INTO game (Board, Time, Is_Win, Is_frist, User2Name, XorY, UserName) VALUES('" + board + "', '" + time + "', " + is_win + "," + is_frist + ", '" + user2Name + "', '" + XorO + "', '" + username + "');");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        close();
        return ret;
    }

    public int countWin(boolean isWin, String username) {
        int count = 0;
        open();
        try {
            ResultSet rs = st.executeQuery("SELECT count(Is_Win) FROM game where Is_Win=" + isWin + " and UserName = '" + username + "'");
            rs.next();
            count = rs.getInt("count(Is_Win)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        close();
        return count;
    }

    public void close() {
        try {
            this.st.close();
            this.con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
