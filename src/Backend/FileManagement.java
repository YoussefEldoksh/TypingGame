/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;


import java.awt.Image;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.channels.FileLock;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author Lenovo
 */
public class FileManagement {   
    
    
      public static ArrayList<String> loadFromFriendRequestsJsonFileForSpecificUser(String userId) {

        ArrayList<String> passages = new ArrayList<>();
        try {

            if (!Files.exists(Paths.get("passages.json")) || Files.size(Paths.get("friendrequests.json")) == 0) {
                Files.createFile(Paths.get("passages.json")); // create the file if not found
                return passages;
            }
            String json = new String(Files.readAllBytes(Paths.get("friendrequests.json")));
            JSONArray friendRequestsJson = new JSONArray(json);

            for (int i = 0; i < friendRequestsJson.length(); i++) {

                JSONObject userJson = friendRequestsJson.getJSONObject(i);
                String email = userJson.getString("email");
                String id = userJson.getString("senderid");
                String username = userJson.getString("username");
                String receiverId = userJson.getString("receiver");

            }
        } catch (IOException ex) {
            System.err.println("Error loading friend requests from JSON file: " + ex.getMessage());
        }

        System.out.println("Exiting loadFromUsersJSONfile");
        return passages;
    }
      
      
}
