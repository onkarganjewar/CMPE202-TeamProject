import greenfoot.*;

/**
 * Write a description of class bananaCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BananaCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Ball objBall, int bananaLocationX) {
        if(objectName.equals("banana")){
            //System.out.println("Entered into banana check");
            int deltaY = -1 * objBall.getDeltaY();
            objBall.setDeltaY(deltaY);
            int offset = objBall.getX() - bananaLocationX;
            int deltaX = objBall.getDeltaX() + (offset/10);
            if (deltaX > 7) {
                objBall.setDeltaX(7);
            }
            if (deltaX < -7) {
                objBall.setDeltaX(-7);
            }
            //((Board)getWorld()).removeObject(banana);
            //((Board)getWorld()).incrementScore();
            Greenfoot.playSound("Babanana.mp3");
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objBall, bananaLocationX);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
   
}
