import greenfoot.*;

/**
 * Write a description of class WallCollision here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WallCollision extends Actor implements CollisionHandler
{
    private CollisionHandler successor = null;
    public void handleCollision(String objectName, Ball objBall, int location) {
        if(objectName.equals("wall")){
            //System.out.println("Entered into wall check" + objBall.getX() + " " + objBall.getY() + " " + objBall.getDeltaX());
            if (objBall.getX() == 0 || objBall.getX() == location){
            //if (objBall.getX() == 0 || objBall.getX() == 1){
                int deltaX = (-1 * objBall.getDeltaX());
                objBall.setDeltaX(deltaX);
            }
            if (objBall.getY() == 0) {
                int deltaY = (-1 * objBall.getDeltaY());
                objBall.setDeltaY(deltaY);
            }
        }
        else {
            if(successor != null) {
                successor.handleCollision(objectName, objBall, location);
            }    
        }
    }
    public void setSuccessor(CollisionHandler next) {
        this.successor = next;
    }
}
