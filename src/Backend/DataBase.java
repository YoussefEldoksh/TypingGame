/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class DataBase {
    
    
    
    private Map<String, String> passages;
    private static DataBase instance = null;
  
    
    private DataBase() {
        loadPassages();
        
    }
    
    
    public static DataBase getInstance()
    {
        if(instance == null)
        {
            instance = new DataBase();
        }
        
        return instance;
    }
    
    public void loadPassages()
    {
        passages = FileManagement.loadFromPassageJsonFile();
    }

    public Map<String, String> getPassages() {
        return passages;
    }
    
    
}
