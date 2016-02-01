import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{ 
    
     /**
     * Act - do whatever the splashscreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        checkKey();
        // Just check the key. That's enough!
    } 
    
    /**
     * Checks whether the 'enter' button is down or not.
     */
    public void checkKey(){
        if (Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new Board());
        }
        
    }
}