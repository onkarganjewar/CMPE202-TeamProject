import greenfoot.*;

/**
 * Write a description of class GState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GState implements IGameState
{
 
    GameManager gm_manager;
  
    public GState(GameManager gm)
    {    
        gm_manager=gm;
    }
    
    public void start()
    {
        System.out.println("On paddle is not valid in "+this.getClass().getName()+" state");
    }
    
    public void doJumping()
    {
        System.out.println("Jumping is not valid in "+this.getClass().getName()+" state");
    }
    
    public void die()
    {
        System.out.println("Dead is not valid in "+this.getClass().getName()+" state");
    }
    
}
