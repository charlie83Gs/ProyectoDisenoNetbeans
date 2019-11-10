/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;

/**
 *
 * @author Charlie
 */
public class Payload {
    HashMap<String, Object> data;

    public Payload() {
      data = new HashMap<>();
    }
    /**
     * 
     * @param key "object"
     * @param content Classs subject of the operation
     */
    public void addContent(String key,Object content){
        data.put(key, content);
    }
    
    public Object removeContent(String key){
        return data.remove(key);
    }
    
    public Object getContent(String key){
        return data.get(key);
    }
    
    
    
}
