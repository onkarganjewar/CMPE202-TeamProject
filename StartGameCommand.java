import greenfoot.*;

/**
 * Write a description of class StartGameCommand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartGameCommand extends Actor implements ICommand
{
    /**
     * Act - do whatever the StartGameCommand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private IGameReceiver changeGame;
    private Paddle paddle;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public StartGameCommand(IGameReceiver newGame, Paddle p)   
    {
        this.changeGame = newGame;
        this.paddle = p;
    }

    public void execute()
    {
        changeGame.doAction(paddle);
    }
}