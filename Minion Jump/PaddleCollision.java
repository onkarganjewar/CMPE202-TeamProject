import greenfoot.*;

/**
 * Write a description of class PaddleCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaddleCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Ball objBall, int paddleLocationX) {
        if(objectName.equals("paddle")){
            int deltaY = -1 * objBall.getDeltaY();
            objBall.setDeltaY(deltaY);
            int offset = objBall.getX() - paddleLocationX;
            int deltaX = objBall.getDeltaX() + (offset/10);
                if (deltaX > 7) {
                    objBall.setDeltaX(7);
                }
                if (deltaX < -7) {
                    objBall.setDeltaX(-7);
                }
            Greenfoot.playSound("Yahoo.wav");
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objBall, paddleLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }

}
