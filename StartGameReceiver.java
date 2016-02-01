import greenfoot.*;

/**
 * Write a description of class StartGameReceiver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameReceiver extends Actor implements IGameReceiver
{
    Paddle p;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public void doAction(Paddle paddle)
   {
        try
        {
            this.p = paddle;
            p.releaseBall();            
        }
        catch(Exception e){
        }
    }
}
