import greenfoot.*;

/**
 * Write a description of class GameManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameManager
{
    IGameState onPaddleState;
    IGameState jumpingState;
    IGameState deadState;
    IGameState currentState;
    public enum GameStates
    {
        ONPADDLE,JUMPING,DEAD,
    };

    /**
     * Constructor for objects of class GameManager.
     * 
     */
    public GameManager()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       // super(600, 400, 1); 
       onPaddleState=new MinionOnPaddle(this);
       jumpingState=new MinionJumping(this);
       deadState=new MinionDead(this);
       currentState=onPaddleState;
    }
    
    public void onpaddle()
    {
        System.out.println("on the paddle");
        currentState.start();
    }
    
    public void jump()
    {
        System.out.println("on the paddle");
        currentState.doJumping();
    }
    
    public void dead()
    {
        System.out.println("on the paddle");
        currentState.die();
    }
    
    public void setState(GameStates nextState)
    {
        switch(nextState)
        {
            case ONPADDLE: currentState=onPaddleState; break;
            case JUMPING: currentState=jumpingState; break;
            case DEAD: currentState=deadState; break;
        }
    }
    
    public void showState()
    {
        System.out.println("Current State:"+currentState.getClass().getName());
    }
}
