import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
Concrete Subject
 * 
 * @author (team 12) 
 * 
 */
public class ConcreteSubject implements ISubject
{
    //private ArrayList<IObserver> observers = new ArrayList<IObserver>();
    private IObserver observer;
    private static ConcreteSubject instance = null;
    public static ConcreteSubject getInstance() 
    {
        if(instance == null) {
            instance = new ConcreteSubject();
        }
        return instance;
    }
    public void register(IObserver obj)
    {
        observer = obj;
    }
    
    public void unregister(IObserver obj)
     {
        observer = null;
    }
        
    //method to notify observers of change
    public void notifyObservers(Board world)
    {
        //for (IObserver obj  : observers)
        //{
            observer.update(world);
        //}
    }
    
}
