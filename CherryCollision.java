import greenfoot.*;

/**
 * Write a description of class CherryCol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CherryCollision extends Actor implements CollisionHandler
{
     private CollisionHandler successor = null;
    public void handleCollision(String objectName, Ball objBall, int brickLocationX) {
        if(objectName.equals("cherry")){
            //System.out.println("Entered into brick check");
            int deltaY = -1 * objBall.getDeltaY();
            objBall.setDeltaY(deltaY);
            int offset = objBall.getX() - brickLocationX;
            int deltaX = objBall.getDeltaX() + (offset/10);
            if (deltaX > 7) {
                objBall.setDeltaX(7);
            }
            if (deltaX < -7) {
                objBall.setDeltaX(-7);
            }
            //((Board)getWorld()).removeObject(brick);
            //((Board)getWorld()).incrementScore();
            Greenfoot.playSound("Babanana.mp3");
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objBall, brickLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }

}
