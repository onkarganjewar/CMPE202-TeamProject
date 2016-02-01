import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color; // Colors and stuff
import java.awt.Font; // Fonts and stuff

/**
 * Write a description of class WelcomeInstructions here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WelcomeInstructions extends World
{

    /**
     * Constructor for objects of class WelcomeInstructions.
     * 
     */
    public WelcomeInstructions()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        // super(600, 400, 1); 
         super(924, 520, 1);
        //super(700, 500, 1);
        // Adds the object, which has the 'checkKey' method to check whether the 'enter' is down or not.
        addObject(new Start(), 0, 0);
        showMessage();
        
    }
    
    /**
     * Displays some instructions and other stuff.
     */
    public void showMessage(){
        GreenfootImage bg = getBackground();
        
        bg.setFont( new Font("Comic Sans MS", Font.PLAIN, 34));
        bg.setColor(Color.BLACK);
        bg.drawString("Welcome!", 380, 200);
        bg.setFont(new Font("Arial", Font.PLAIN, 12));
        bg.drawString("Instructions:",420, 230); 
        bg.drawString("- Use the arrow keys to move the Paddle",340, 250); 
        bg.drawString("- Each time the Minion lands outside the Paddle - you lose life",280, 270); 
        //bg.drawString("- The level and the speed is increasing after each level",300, 290);
        bg.drawString("- You can see your score at the top left corner",325, 290); 
        bg.drawString("Have fun and enjoy the game!", 365, 350); 
        bg.setFont(new Font("Arial", Font.PLAIN, 22));
        bg.drawString("To start the game hit the ENTER button on your keyboard.",200, 400); 
        bg.setFont(new Font("Arial", Font.PLAIN, 10));
        //bg.drawString("Made by Antal János Monori, Dániel Salamon & Alpár András",405, 498);
        
    }
}
