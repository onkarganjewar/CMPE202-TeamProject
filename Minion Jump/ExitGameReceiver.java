import greenfoot.*;

/**
 * Write a description of class ExitGameReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ExitGameReceiver extends Actor implements IGameReceiver
{
    /**
     * Act - do whatever the ExitGameReceiver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doAction(Paddle paddle)
    {
      //System.out.println("Stop Game");
      //System.exit(0);
      Greenfoot.setWorld(new WelcomeInstructions());
      //Greenfoot.stop();
    }
}
