import greenfoot.*;
import java.util.ArrayList;

public abstract class ScrollWorld extends World
{
    private final int width, height, cellSize;
    private final ArrayList<ScrollActor> objects;
    private final ArrayList<ScrollActor> camFollowers;
    private final int fullWidth, fullHeight;
    
    private int camX, camY, camDir;
    
    private final GreenfootImage bigBackground, back;
    private int scrollPosX, scrollPosY;
    
    public ScrollWorld(int width, int height, int cellSize, int fullWidth, int fullHeight)
    {
        super(width, height, cellSize, false);
        this.back = getBackground();
        this.width = back.getWidth();
        this.height = back.getHeight();
        this.cellSize = cellSize;
        this.fullWidth = fullWidth;
        this.fullHeight = fullHeight;
        if (fullWidth <= 0){
            throw new IllegalArgumentException("The width of the big space ("+fullWidth
            +") can't be smaller then the width of the world ("+width+")");
        }
        if (fullHeight <= 0){
            throw new IllegalArgumentException("The height of the big space ("+fullHeight
            +") can't be smaller then the height of the world ("+height+")");
        }
        objects = new ArrayList<ScrollActor>();
        camFollowers = new ArrayList<ScrollActor>();
        
        camX = getWidth() /2;
        camY = getHeight() /2;
        camDir = 0;
        
        scrollPosX = 0;
        scrollPosY = 0;
        
        bigBackground = new GreenfootImage(width+width, height+height);
        setNewBackground(back);
    }
}