/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg7615_assignment_2;

import guzdial.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
/**

/**
 *
 * @author thilinaratnayake
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
        //Declarations
        ArrayList<Picture> pictures = new ArrayList<>();
        
        System.out.println("Program Start");
            
        //Pick images
        pictures = chooseFiles();
       
        //Create a canvas that is the same size as the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        Picture canvas = new Picture(screenWidth, screenHeight);
        canvas.show();
         
       //Pick a random point to plot a picture
        int pictureChoice = 0;
        while(true){
            
            //Get the height and width of the image in question
            int xMax = pictures.get(pictureChoice).getWidth();
            int yMax = pictures.get(pictureChoice).getHeight();
            
            //Pick a random point to start the new picture. Ensure that the random
            //point is within bounds of the screen + picture width.
            int xpoint = 0 + (int) (Math.random() * ((screenWidth - xMax - 0) + 1));
            int ypoint = 0 + (int) (Math.random() * ((screenHeight -yMax - 0) + 1));
            System.out.println("X  Max = " + screenWidth);
            System.out.println("Y Max = " + screenHeight);
            System.out.println("X Point is " + xpoint + ",Y Point is " + ypoint);

            
            Picture collPic = pictures.get(pictureChoice);

            for (int x = 0; x < xMax; x++) {
                for (int y = 0; y < yMax; y++) {
                    //Old Pixel
                    Pixel oldPixel = collPic.getPixel(x, y);
                    Color oldColour = oldPixel.getColor();

                    //New Pixel
                    Pixel newPixel = canvas.getPixel(xpoint + x, ypoint + y);
                    newPixel.setColor(oldColour);

                }
            }
            canvas.repaint();
            canvas.show();
            
            if (pictureChoice < pictures.size() - 1 ) {
                pictureChoice ++;
                System.out.println("End of loop: Picture choice is " + pictureChoice);
            }
            else if(pictureChoice >= (pictures.size() - 1)){
                pictureChoice = pictureChoice - (pictures.size() - 1 );
                System.out.println("End of loop: Picture choice is " + pictureChoice);
            }
        }
        
        
        
        
    }
    
    
    public static ArrayList<Picture> chooseFiles(){
        ArrayList<Picture> images = new ArrayList<>();
        //pick images
        System.out.println(images.size());
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        Component frame = null;

         // Show the dialog; wait until dialog is closed
        chooser.showOpenDialog(frame);

        // Retrieve the selected files.
        File[] files = chooser.getSelectedFiles();
        for (File file : files) {
            String filePath = file.getAbsolutePath();
            Picture picture = new Picture(filePath);
            images.add(picture);
        }
        
        return images;
    }
    
}
