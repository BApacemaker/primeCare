/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

/**
 *
 * @author nel
 */
@Named(value = "imagesView")
public class imagesView implements Serializable{

    /**
     * Creates a new instance of imagesView
     */
    
    private List<String> images;
    
    public imagesView() {
    }
    
    @PostConstruct
    public void init(){
        images = new ArrayList<>();
        for(int i=1; i<=2; i++){
            images.add(i+".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
    
}
