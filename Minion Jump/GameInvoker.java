import greenfoot.*;

/**
 * Write a description of class GameInvoker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameInvoker extends Actor implements IGameInvoker
{
    /**
     * Act - do whatever the GameInvoker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void executeGame(ICommand cmd)
    {
        cmd.execute();   
    }
}