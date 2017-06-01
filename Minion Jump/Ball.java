import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ball game is a Minion. It jumps around and bouncing off the walls and some other objects in the world.
 * 
 * @author CMPE 202 Project Team 12
 * @version 1.0
 */
public class Ball extends Actor
{
    private int deltaX;         // x movement speed
    private int deltaY;         // y movement speed
    private int count = 2;
    private Ball ball;
    
    private boolean stuck = true;   // stuck to paddle
    //ConcreteSubject concretesubject = new ConcreteSubject();
    private ConcreteSubject concretesubject;
    GameManager gm = new GameManager();
    
    public void setDeltaX(int deltaX) {
       this.deltaX = deltaX;
    }

    public int getDeltaX() {
       return deltaX;
    }
    
    public void setDeltaY(int deltaY) {
       this.deltaY = deltaY;
    }

    public int getDeltaY() {
       return deltaY;
    }
    
    /**
     * Act. Move if we're not stuck.
     */
    public void act()
    {
        if (!stuck)
        {
            move();
            makeSmoke();
            if(((Board) getWorld()).endScreen())
            {
                verticalBounce();
            }
            else
            {
                checkOut();
            }
        }
    }
    
    /**
     * Move the ball. Then check what we've hit.
     */
    public void move()
    {
        setLocation (getX() + deltaX, getY() + deltaY);
        CollisionHandler objHandler;
        checkCollision();
        /*checkWalls();
        checkPaddle();
        checkBrick();
        checkBonus();*/
    }
    
    /**
     * Check whether we've hit one of the three walls. Reverse direction if necessary.
     */
    public void checkCollision()
    {
        //concretesubject = ConcreteSubject.getInstance();
        String collisionObject = "";
        /*
        if (getX() == 0 || getX() == getWorld().getWidth()-1){
            deltaX = -deltaX;
        }
        if (getY() == 0) {
            deltaY = -deltaY;
        }
        */
        //Ball objBall = this.getClass();
        Ball objBall = this;
        Board world = (Board)getWorld();
        
        CollisionHandler h1 = new WallCollision();
        CollisionHandler h2 = new PaddleCollision();
        CollisionHandler h3 = new BananaCollision();
        CollisionHandler h4 = new AppleCollision();
        CollisionHandler h5 = new CherryCollision();
        CollisionHandler h6 = new BonusCollision();
        
        h1.setSuccessor(h2);
        h2.setSuccessor(h3);
        h3.setSuccessor(h4);
        h4.setSuccessor(h5);
        h5.setSuccessor(h6);
        
        h1.handleCollision("wall", objBall, getWorld().getWidth()-1);
        Actor paddle = getOneIntersectingObject(Paddle.class);
        if (paddle != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("paddle", objBall);
            h1.handleCollision("paddle", objBall, paddle.getX());
        }
        
        Actor banana = getOneIntersectingObject(Banana.class);
        if (banana != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("banana", objBall);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("banana", objBall, banana.getX());
            ((Board)getWorld()).removeObject(banana);
            //((Board)getWorld()).incrementScore();
            concretesubject.notifyObservers(world);
        }
        
        Actor apple = getOneIntersectingObject(Apple.class);
        if (apple != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("banana", objBall);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("apple", objBall, apple.getX());
            ((Board)getWorld()).removeObject(apple);
            concretesubject.notifyObservers(world);
        }
        
        Actor cherry = getOneIntersectingObject(Cherries.class);
        if (cherry != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("banana", objBall);
            concretesubject = ConcreteSubject.getInstance();
            h1.handleCollision("cherry", objBall, cherry.getX());
            ((Board)getWorld()).removeObject(cherry);
            concretesubject.notifyObservers(world);
        }
        
        
        Actor bonus = getOneIntersectingObject(Bonus.class);
        if (bonus != null) {
            //deltaY = -deltaY;
            //deltaX = h1.handleCollision("bonus", objBall);
            h1.handleCollision("bonus", objBall, bonus.getX());
            ((Board) getWorld()).ballHitsBonus();
        }
    }
    
    /**
     * Check whether we're out (bottom of screen).
     */
    public void checkOut()
    {
        Actor trap = getOneIntersectingObject(Trap.class);
        // This condition checks for both intersection with Trap object and Minion paddle. 
        if (getY() == getWorld().getHeight()-1 || trap != null) 
        {
            ((Board) getWorld()).ballIsOut();
            getWorld().removeObject(this);
            gm.setState(GameManager.GameStates.DEAD);
        }
    }
    
    /**
     * The vertical bounce () method ensures that the Minion ( ball) continues to bounce around.
     */
    public void verticalBounce()
    {
        if (getY() == 0) 
        {
            deltaY = 7;
            deltaX = Greenfoot.getRandomNumber(20) - 10;
        }
        if (getY() == getWorld().getHeight()-1)
        {
            deltaY = -7;
            deltaX = Greenfoot.getRandomNumber(20) - 10;
        }
    }
    /*
    public void checkPaddle()
    {
        Actor paddle = getOneIntersectingObject(Paddle.class);
        if (paddle != null) {
            deltaY = -deltaY;
            int offset = getX() - paddle.getX();
            deltaX = deltaX + (offset/10);
                if (deltaX > 7) {
                    deltaX = 7;
                }
                if (deltaX < -7) {
                    deltaX = -7;
                }
            Greenfoot.playSound("Yahoo.wav");
        }            
    }
    */
    /**
      * The checkBrick() method checks if the Minion ( ball) collided with a banana (brick).
      * If this is the case, remove the banana (brick), increase the score, release the Minion (ball) away again.
      * The Minion (ball) starts singing the word BANANA. */
   /* 
   public void checkBrick()
    {
        Actor brick = getOneIntersectingObject(Brick.class);
        if (brick !=null)
        {
            deltaY = -deltaY;
            int offset = getX() - brick.getX();
            deltaX = deltaX + (offset/10);
                if (deltaX > 7) {
                    deltaX = 7;
                }
                    if (deltaX < -7) {
                        deltaX = -7;
                    }
                        
            ((Board)getWorld()).removeObject(brick);
            ((Board)getWorld()).incrementScore();
            Greenfoot.playSound("Babanana.mp3");
        }
    }
    */
    /**
     * The check bonus () method checks if the Minion ( ball) collides with a bunch of bananas (bonus) .
     * If so, is bouncing the Minion ( ball) away again.
     * Then the ball hits bonus () method output from the Board class .
     */
    /*
    public void checkBonus()
    {
        Actor bonus = getOneIntersectingObject(Bonus.class);
        if (bonus !=null)
        {
            deltaY = -deltaY;
            int offset = getX() - bonus.getX();
            deltaX = deltaX + (offset/10);
                if (deltaX > 7) {
                    deltaX = 7;
                }
                    if (deltaX < -7) {
                        deltaX = -7;
                    }
            ((Board) getWorld()).ballHitsBonus();            
          
        }
    }
    */
    /**
     * Move the ball a given distance sideways.
     */
    public void move(int dist)
    {
        setLocation (getX() + dist, getY());
    }

    /**
     * Put out a puff of smoke (only on every second call).
     */
    public void makeSmoke()
    {
        count--;
        if (count == 0) {
            getWorld().addObject ( new Smoke(), getX(), getY());
            count = 2;
        }
    }
    
    /**
     * Release the ball from the paddle.
     */
    public void release()
    {
        deltaX = Greenfoot.getRandomNumber(11) - 5;
        while(deltaX == 0)
            deltaX = Greenfoot.getRandomNumber(11) - 5;
            //deltaX = 2;
        deltaY = -5;
        stuck = false;
        Greenfoot.playSound("Yahoo.wav");      
    }
    
    /**
     * The incrementSpeed() method increments the speed of the Minion ( ball). 
     */
    /*public void incrementSpeed()
    {
        deltaX = deltaX - 2;
        deltaY = deltaY - 2;
    }*/
  
}