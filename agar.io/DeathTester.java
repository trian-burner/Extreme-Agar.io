import greenfoot.*;

/**
 * Write a description of class DeathTester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
        
        //Virus Collision Detection
//         if(isTouching(Virus.class) && (getMass() > 40)){
//             removeTouching(Virus.class);
//             divide();
//         }
    }    
}
