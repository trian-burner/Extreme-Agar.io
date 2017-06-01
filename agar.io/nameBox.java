import greenfoot.*;
import java.awt.Color;
 
public class nameBox extends Actor {
    static final int MAX_INPUT_LENGTH = 20;
    String text = "                   Enter a name";
    String name;
     
    public nameBox() {
        updateImage();
        text = "";
    }
    
    public nameBox(String name) {
        text = name;
        this.name = name;
        updateImage();
    }
     
    private void updateImage() {
        GreenfootImage image = new GreenfootImage(16*MAX_INPUT_LENGTH, 28);
        image.setColor(Color.BLACK);
        image.fill();
        image.setColor(Color.WHITE);
        image.fillRect(2, 2, image.getWidth()-4, 24);
        GreenfootImage chrImage = new GreenfootImage(text, 24, Color.black, null);
        image.drawImage(chrImage, 6, 14-chrImage.getHeight()/2);
        setImage(image);
    }
 
    public void act() {
        String key = Greenfoot.getKey();
        if (text.equals("                   Enter a name")) text = "";
        if (key == null) return;
        if ("enter".equals(key) && text.length() > 0) {
            int multiplayer = ((StartScreen)getWorld()).screenNum;
            Greenfoot.setWorld(new Agar(text, multiplayer));
        }
        if ("backspace".equals(key) && text.equals(name)) text = "";
        if ("backspace".equals(key) && text.length() > 0 && !text.equals("                   Enter a name")) text = text.substring(0, text.length() - 1);
        if ("space".equals(key)) key = " ";
        if (key.length() == 1 && text.length() < MAX_INPUT_LENGTH) text += key;
        if (text.length() == 0) text = "                   Enter a name";
        updateImage();
    }
}