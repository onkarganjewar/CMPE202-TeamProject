import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The paddle is a trapoline in this game.
 * The Minion (ball) jumps during the game on the paddle.
 * The paddle can be controlled from the keyboard using left and right keys to catch the Minion (ball).
 * Pressing space starts a Minion (ball) jumping.
 * 
 * @author CMPE 202 Project Team 12
 * @version 1.0
 */
public class Paddle extends Actor
{
    private Ball myBall;  // used before ball gets released
    public int numBall = 1; // Displays the number of Minion ( ball). Starts on one standard
    GameManager gm = new GameManager();
    //ConcreteSubject concretesubject = new ConcreteSubject();
    //private ConcreteSubject concretesubject;
    //private Score score;
       
    /**
     * When the paddle gets created, create a ball as well.
     */
    public void addedToWorld(World world)
    {
        newBall();
    }
    
    /**
     * Act - do whatever the Paddle wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /**
         * If the left arrow is pressed, the paddle moves 9 pixels to the left .
         * If the right arrow is pressed, the paddle moves 9 pixels to the right.
         */
        if (Greenfoot.isKeyDown ("left")) 
        {
            move(-9);
        }
        if (Greenfoot.isKeyDown ("right")) 
        {
            move(9);
        }
        if (haveBall() && Greenfoot.isKeyDown ("space")) {
            ((Board)this.getWorld()).removeMessage4();
            releaseBall();
            gm.setState(GameManager.GameStates.JUMPING);
        }
        
    }
    
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
        if (myBall != null) 
        {
            myBall.move (dist);
        }
    }
    
    public void newBall()
    {
        myBall = new Ball();
        getWorld().addObject (myBall, getX(), getY()-20);
        numBall ++;
       
    }
        
    public boolean haveBall()
    {
        return myBall != null;
    }
        
    public void releaseBall()
    {
        myBall.release();
        myBall = null;
        //concretesubject = ConcreteSubject.getInstance();
        //score = new Score(concretesubject);
        //concretesubject.register(score);
    }
        
    public int getNumBalls()
    {
        return numBall;
    }
    
    /**
     * Method reduceNumBalls() decreases numBall with 1. This is necessary for the extra lives.
     */
    public void reduceNumBalls()
    {
        numBall = numBall -1;
        //concretesubject.unregister(score);
    }
    
    /**
     * Method removeBall() removes the Minion ( ball) on the paddle.
     */
    public void removeBall()
    {
        getWorld().removeObject(myBall);
        //concretesubject.unregister(score);
    }
}
