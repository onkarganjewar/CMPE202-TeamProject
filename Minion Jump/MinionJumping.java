import greenfoot.*;

/**
 * Write a description of class MinionJumping here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinionJumping extends GState
{

    /**
     * Constructor for objects of class MinionJumping.
     * 
     */
    public MinionJumping(GameManager g)
    {
        super(g);
    }
    
    @Override
    public void die()
    {
        gm_manager.setState(GameManager.GameStates.DEAD);
        //System.out.println("Jumping is not valid in "+this.getClass().getName()+" state");
    }
   
}
