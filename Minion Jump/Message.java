import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Font;
import java.awt.Color;
/**
 * The Message class contains all the information needed to display text in the world.
 * 
 * @author CMPE 202 Project Team 12
 * @version 1.0
 */
public class Message  extends Actor
{
    /**
     * Act - do whatever the Message wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }
    
    /** holds the text of the message */
    private String text;
    
    /** the width of the message area */
    private int width = 220;
    
    /** the height of the message area */
    private int height = 30;

        /** 
     * Constructor that takes the text to display
     */
    public Message(String theText)
    {
        text = theText;
        updateImage();
    }
    
    /**
     * Constructor that takes the text to display, width and the height
     * @param theText   the text to use
     * @param theWidth  the width to use
     * @param theHeight the height to use
     */
    public Message(String theText, int theWidth, int theHeight)
    {
        text = theText;
        width = theWidth;
        height = theHeight;
        updateImage();
    }
    
    ////////////////// methods ///////////////////////
    
    /**
     * Method to change the text in this message
     * @param theText the new text to usee
     */
    public void setText(String theText)
    { 
        text = theText;
        updateImage();
    }
    
    /**
     * Method to create and set the image for this message
     * Invoke this method when the text, width, and/or height changes
     */
    private void updateImage()
    {
        Font font = new Font("Helvetica",Font.BOLD,20);
        GreenfootImage image = new GreenfootImage(width,height);
        image.setFont(font);
        image.clear();
        image.setColor(Color.BLUE);
        image.drawString(text, 5, height / 2);
        setImage(image);
    }  
}
