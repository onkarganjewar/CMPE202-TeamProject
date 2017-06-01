/**
 * Write a description of class ObstacleFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ObstacleFactory  
{
    
     static level1factory l1;
     static level2factory l2;
     static level3factory l3;
    public static Obstacles createObstacle(int y){
        Obstacles b = null;
        switch(y){
            case 1:
                b =  l1.getObstacle();
            break;
            
            case 2:
                b = l2.getObstacle();
            break;
            
            case 3:
                b = l3.getObstacle();
                
            default:
                break;
        }
        return b;
    
    }    
}
