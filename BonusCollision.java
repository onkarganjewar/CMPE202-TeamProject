import greenfoot.*;

/**
 * Write a description of class BonusCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BonusCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Ball objBall, int bonusLocationX) {
        if(objectName.equals("bonus")){
            //System.out.println("Entered into bonus check");
            int deltaY = -1 * objBall.getDeltaY();
            objBall.setDeltaY(deltaY);
            int offset = objBall.getX() - bonusLocationX;
            int deltaX = objBall.getDeltaX() + (offset/10);
            if (deltaX > 7) {
                objBall.setDeltaX(7);
            }
            if (deltaX < -7) {
                objBall.setDeltaX(-7);
            }
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objBall, bonusLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
}
