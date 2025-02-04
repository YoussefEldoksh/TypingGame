/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Lenovo
 */
public class DataBase {
    
    
    
    private ArrayList<Passages> passages = new ArrayList<>();
    private ArrayList<Passages> passages1 = new ArrayList<>();
    private ArrayList<Passages> passages2 = new ArrayList<>();
    private ArrayList<Passages> passages3 = new ArrayList<>();
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
        
        
        for (Passages passage : passages) {
            if(passage.getLevel().equals("1"))
            {
                passages1.add(passage);
            }
            if(passage.getLevel().equals("2"))
            {
                passages2.add(passage);
            }
            if(passage.getLevel().equals("3"))
            {
                passages3.add(passage);
                        
            }
            
        }
    }

    public ArrayList<Passages> getPassages1() {
        return passages1;
    }

    public ArrayList<Passages> getPassages2() {
        return passages2;
    }

    public ArrayList<Passages> getPassages3() {
        return passages3;
    }

  
}
