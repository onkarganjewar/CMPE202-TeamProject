import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The game board. The board had a paddle that can move.
 * 
 * @author CMPE 202 Project Team 12
 * @version 1.0
 */
public class Board extends World
{
    private String[] backgroundImages = {"level0.jpg","level1.jpg","level2.jpg","level3.jpg","level4.jpg"};
    private int score = 0;
    private int level = 0;
    
    private Message message1 = null;
    private Message message2 = null;
    private Message message3 = null;
    private Message message4 = null;
    private Message message5 = null;
    private Message message6 = null;
    private Message message7 = null;
    private Message message8 = null;
    private Message message9 = null;
    
    CommandActor clientCmd;
    ObstacleFactory b;
    Obstacles ob;
    private Paddle paddle; 
    private Banana Banana;
    private Bonus bonus;
    private Trap trap;
    private Ball ball;
    private Life life1;
    private Life life2;
    private Life life3;
    private ConcreteSubject concretesubject;
    private Score scores;
    //private WallCollision wallCollision;
    
    /**
     * Constructor of the Board class.
     * Everything in the constructor is executed when the world is created.
     */
    public Board()
    {    
        // Construct a new world. Width, Height and cellSize
        super(924, 520, 1);
        setPaintOrder ( Ball.class, Smoke.class );
        
        paddle = new Paddle();
        addObject ( paddle, getWidth() / 2, getHeight() - 40);
       
        message1 = new Message("Score: " + score);
        addObject(message1, 125, 30);
        
        message2 = new Message("Level: " + level);
        addObject(message2,125, 60);
        
        message3 = new Message("Lives:");
        addObject(message3, 850, 30);
        
        message4 = new Message("Press space to jump...");
        addObject(message4, 480, 60);
                
        
        life1 = new Life();
        addObject(life1, 825,25);
        
        life2 = new Life();
        addObject(life2, 860,25);
        
        life3 = new Life();
        addObject(life3, 895,25);
        
        clientCmd = new CommandActor(paddle);
        addObject(clientCmd,0,0);
        
        concretesubject = ConcreteSubject.getInstance();
        scores = new Score(concretesubject);
        concretesubject.register(scores);
        //wallCollision = new WallCollision(); 
        //addObject(wallCollision, 0, 0);        
        
        upgradeLevel();          
    }
    /*
    public void setScore (int x) {
       this.score = x;
    }

    public int getScore() {
       return this.score;
    }*/
    
    /**
     * The upgrade level() method checks if the score is a multiple of 10 .
     * If that is the case it will create a new level .
     * Level four is not a real level , but the final screen .
     */
    public void upgradeLevel()
    {
        if (score%10==0)
        {
            // Initial value of level is 0.
            level++;
            checkBackground();
            message2.setText("Level: " + level);
            
                if(level == 1)
                {
                    message6 = new Message("Collect all bananas!");
                    
                    addObject(message6,480, 30); 
                  
                    for (int k = 0; k < 10; k++)
                    {
                        ob = b.createObstacle(1);
                        addObstacles(ob);
                    }
                }
                if(level == 2)
                {
                    removeObject(message6);
                    message7 = new Message("Don't get too friendly!");
                    addObject(message7,480, 30);
                    
                    
                  for (int k = 0; k < 10; k++)
                    {
                        ob = b.createObstacle(2);
                   
                        addObstacles(ob);
                    }
                   
                    //increaseBallSpeed();
                    
                    //trap = new Trap();
                    //addObject(trap,490, 100);
                    Greenfoot.playSound("Steal_the_Moon.mp3");
                }
                if(level == 3)
                {
                    removeObject(message7);
                    message8 = new Message("Seems easy...right?");
                    addObject(message8,480, 30); 
                    
                  for (int k = 0; k < 10; k++)
                    {
                        ob = b.createObstacle(3);
                   
                        addObstacles(ob);
                    }
                    trap = new Trap();
                    addObject(trap,490, 100);
                    addBonus();
                    //increaseBallSpeed();
                 //   Greenfoot.playSound("Try_This.mp3");
                                    }
                if(level == 4)
                {
                    removeObject(message8);
                    removeMessage4();
                    paddle.removeBall();
                    removeObject(paddle);  
                    ConcreteSubject concretesubject = ConcreteSubject.getInstance();
                    concretesubject.unregister(scores);
                    removeTraps();
                    removeBonus();
                    removeBananas();
                    
                    message9 = new Message("CONGRATULATIONS!");
                    addObject(message9,480, 30); 
                    
                   // Greenfoot.playSound("Banana_song.mp3");
                }
                                        
        }
    }
    
    /**
     * The checkBackground() method sets the proper background as per current level.
     * 
     */
    public void checkBackground()
    {
           this.setBackground(backgroundImages[level%backgroundImages.length]);
    }
    
    /**
     * The endScreen () method indicates whether we are in level 4 or not . The method is called the Ball class .
     */
    public boolean endScreen()
    {
        if(level == 4)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
    
    /**
     * De methode incrementScore() verhoogt de score met 1. 
     * Vervolgens worden de methode upgradeLevel() en addTrap() aangeroepen om te zien of deze moeten worden uitgevoerd.
     */
    public void incrementScore()
    {
        score ++;
        message1.setText("Score: " + score);
        upgradeLevel();
        //addTrap();
    }
    
    /**
     * The ballIsOut () method tells you what to do if it is determined that the Minion (ball) is not in the world where it should be.
     */
    public void ballIsOut()
    {
       // Greenfoot.playSound("Hohoho.mp3");
        if (paddle.getNumBalls() > 3)
        {
            removeObject(life3);
            removeObject(message6);
            removeObject(message7);
            removeObject(message8);
            
            message5 = new Message("GAME OVER");
            addObject(message5,510, 30);
            ConcreteSubject concretesubject = ConcreteSubject.getInstance();
            concretesubject.unregister(scores);
        }
        else
        {
            if(paddle.getNumBalls()==2)
            {
                removeObject(life1);
            }
            if(paddle.getNumBalls()==3)
            {
                removeObject(life2);
            }
            
            paddle.newBall();
            message4 = new Message("Press space to jump...");
            addObject(message4,480, 60);
        }
               
    }
        
    /**
     * The addBanana () method adds 10 bananas ( Bananas ) to anywhere on the screen ( within limits ).
     */
    public void addObstacles(Obstacles o)
    
    {
        Obstacles temp;
        temp = o;
        
        

          int x = Greenfoot.getRandomNumber(814)+50;
            int y = Greenfoot.getRandomNumber(250)+70;
            addObject (temp, x , y);
        
            
    }
    
    public void addTrap()
    {
        if (score == Greenfoot.getRandomNumber(10) + 20)
        {
            trap = new Trap();
            int x = Greenfoot.getRandomNumber(814)+50;
            int y = Greenfoot.getRandomNumber(250)+70;
            addObject (trap, x , y);
        }
    
    }
    
    /**
     * The method addBonus () place anywhere a bunch of bananas for an extra life .
     * But only if the player has only one life at the start of level 2 or 3 (see upgrade level ()) 
     */
    public void addBonus()
    {
        if(paddle.getNumBalls()==4)
        {
            bonus = new Bonus();
            int x = Greenfoot.getRandomNumber(814)+50;
            int y = Greenfoot.getRandomNumber(250)+70;
            addObject (bonus, x , y);
        }
    }
    
    /**
     * If the Minion (ball) touches the bunch of bananas (bonus) the player gets an extra life.
     */
    public void ballHitsBonus()
    {
          removeObject(bonus);
          paddle.reduceNumBalls();
          addObject(life2, 860, 25);
         // Greenfoot.playSound("Babanana.mp3");
          
    }
    
    /*public void increaseBallSpeed()
    {
        ((Ball)(getObjects(Ball.class).get(0))).incrementSpeed();
    }*/
    
    /**
     * This method removes message4 ( "Press space to jump ...").
     * This is called the Paddle class .
     */
    public void removeMessage4()
    {
        this.removeObject(message4);
    }
    
    /**
     * The traps remove() method removes all Evil Minions (traps) present in the world.
     */
    public void removeTraps()
    {
        removeObjects(getObjects(Trap.class));
    }
    
    /**
     * The bonus remove() method removes all banana bunches (bonus) present in the world.
     */
    public void removeBonus()
    {
        removeObjects(getObjects(Bonus.class));
    }
    
    /**
     * The Bananas remove() method removes all bananas(Bananas) present in the world .
     */
    public void removeBananas()
    {
        removeObjects(getObjects(Banana.class));
    }
}
 