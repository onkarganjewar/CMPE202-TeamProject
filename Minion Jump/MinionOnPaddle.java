import greenfoot.*;

/**
 * Write a description of class OnPaddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinionOnPaddle extends GState
{

    public MinionOnPaddle(GameManager g)
    {    
        super(g); 
    }
    
   
    @Override
    public void doJumping()
    {
        gm_manager.setState(GameManager.GameStates.JUMPING);
        //System.out.println("Jumping is not valid in "+this.getClass().getName()+" state");
    }
    
   
}
