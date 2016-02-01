import greenfoot.*;

/**
 * Write a description of class MinionDead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinionDead extends GState
{
    /**
     * Constructor for objects of class MinionDead.
     * 
     */    
    public MinionDead(GameManager g)
    {
        super(g);
    } 
    
   @Override
    public void start()
    {
        gm_manager.setState(GameManager.GameStates.ONPADDLE);
        //System.out.println("Jumping is not valid in "+this.getClass().getName()+" state");
    }
}
