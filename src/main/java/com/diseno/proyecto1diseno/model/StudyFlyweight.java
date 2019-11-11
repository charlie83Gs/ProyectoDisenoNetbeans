/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.diseno.proyecto1diseno.model;

import java.util.HashMap;

/**
 *
 * @author Evelio
 */
public class StudyFlyweight {
    private HashMap<String, Study> studies;
    
    public void registerStudy(String pNombre, Study pStudy){
        
    }

    public StudyFlyweight() {
    }
    
    public Study getStudy(String pStudy){
        Study a = null;
        return a;
    }
}
