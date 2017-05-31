import greenfoot.*;

/**
 * Used for testing and debugging "death" in the game
 * 
 * @author Wayde Gilliam, Brian Turner, Cecilia Martin, Ethan Harris) 
 */
public class DeathTester extends ScrollActor
{
    /**
     * Act - do whatever the DeathTester wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Cell cell = (Cell)getOneIntersectingObject(Cell.class);
        if(cell != null){
            cell.death();
        }
    }    
}
