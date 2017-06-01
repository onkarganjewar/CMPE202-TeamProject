import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * ConcreteObserver.
 * 
 * @author (Team 12) 
 * @version (a version number or a date)
 */
public class ConcreteObserver implements IObserver
{
        protected ConcreteSubject subject;
        public  ConcreteObserver(ConcreteSubject sub)
        {
            this.subject = sub;
        }
        
        public void update(Board world)
        {
        }
}
