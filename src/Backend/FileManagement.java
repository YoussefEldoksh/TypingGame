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
import org.json.JSONObject;
import org.json.JSONArray;
import java.nio.channels.FileLock;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;

/**
 *
 * @author Lenovo
 */
public class FileManagement {   
    
    
      public static HashMap<String,String> loadFromPassageJsonFile () {

        HashMap<String,String> passages = new HashMap<>();
        try {

            if (!Files.exists(Paths.get("passages.json")) || Files.size(Paths.get("passages.json")) == 0) {
                Files.createFile(Paths.get("passages.json")); // create the file if not found
                return passages;
            }
            
            String json = new String(Files.readAllBytes(Paths.get("passages.json")));
            JSONArray passagesJson = new JSONArray(json);

            for (int i = 0; i < passagesJson.length(); i++) {

                JSONObject userJson = passagesJson.getJSONObject(i);
                System.out.println(userJson);
                String passage = userJson.getString("passage");
                passages.put("passage"+(i+1), passage);
            }
        } catch (IOException ex) {
            System.err.println("Error loading passages from JSON file: " + ex.getMessage());
        }

        System.out.println("Exiting loadFromUsersJSONfile");
        return passages;
    }
      
      
}
