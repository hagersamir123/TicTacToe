/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import database.DBLayer;
import helperclasses.FileAttributes;
import helperclasses.User;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Taha
 */
public class ConfigFile {

    public static final File file = new File(FileAttributes.Login.toString() + ".config");
    private final CaesarEncryption caeser;
    private final Properties props;
    private FileWriter writer;
    private FileReader reader;

    public ConfigFile() {
        caeser = new CaesarEncryption();
        props = new Properties();
    }

    public boolean write(String username, String password) {
        try {
            props.setProperty(caeser.Encode(FileAttributes.UserName.toString()), caeser.Encode(username));
            props.setProperty(caeser.Encode(FileAttributes.Password.toString()), caeser.Encode(password));
            writer = new FileWriter(file, false);
            props.store(writer, null);
            writer.close();
            return true;
        } catch (FileNotFoundException ex) {
            // file does not exist
            ex.printStackTrace();
        } catch (IOException ex) {
            // I/O error
            ex.printStackTrace();
        }
        return false;
    }

    public User readAndLogin() {
        File configFile = ConfigFile.file;
        try {
            reader = new FileReader(configFile);
            props.load(reader);
            String user = props.getProperty(caeser.Encode(FileAttributes.UserName.toString()));
            String pass = props.getProperty(caeser.Encode(FileAttributes.Password.toString()));
            reader.close();

            user = caeser.Decode(user);
            pass = caeser.Decode(pass);

            if (!user.isEmpty() && !pass.isEmpty()) {
                String name;
                DBLayer DB = new DBLayer();
                name = DB.dbLogin(user, pass);
                if (name != null) {
                    return new User(name, user, pass);
                }

                return null;
            } else {
                return null;
            }
        } catch (FileNotFoundException ex) {
            // file does not exist
            ex.printStackTrace();
        } catch (IOException ex) {
            // I/O error
            ex.printStackTrace();
        }
        return null;
    }
}
