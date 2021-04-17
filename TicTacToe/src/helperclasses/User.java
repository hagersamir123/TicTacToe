/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helperclasses;

/**
 *
 * @author Mohamed Elsayed
 */
public class User {
    public int ID;
    public String socket;
    public String name;
    public String username;
    public String password;
    
    public User(int ID, String name){
        this.ID = ID;
        this.name = name;
    }

    public User(String socket, String name) {
        this.socket = socket;
        this.name = name;
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
