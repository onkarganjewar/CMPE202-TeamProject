/**
 * Write a description of class CollisionHandler here.
 * 
 * @author CMPE 202 Project Team 12
 * @version 1.0
 */
public interface CollisionHandler
{
    public void handleCollision(String objectName, Ball objBall, int location);
    public void setSuccessor(CollisionHandler next);
}
