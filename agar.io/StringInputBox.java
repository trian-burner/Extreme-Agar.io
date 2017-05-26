import greenfoot.*;
import java.awt.Color;
 
public class StringInputBox extends Actor {
    static final int MAX_INPUT_LENGTH = 20;
    String text = "Enter a name";
     
    public StringInputBox() {
        updateImage();
        text = "";
    }
     
    private void updateImage() {
        GreenfootImage image = new GreenfootImage(16*MAX_INPUT_LENGTH+32, 30);
        image.setColor(Color.BLACK);
        image.fill();
        image.setColor(Color.WHITE);
        image.fillRect(2, 2, image.getWidth()-4, 26);
        for (int i=0; i<text.length(); i++) {
            GreenfootImage chrImage = new GreenfootImage(""+text.charAt(i), 24, Color.black, null);
            image.drawImage(chrImage, 24+16*i-chrImage.getWidth()/2, 15-chrImage.getHeight()/2);
        }
        setImage(image);
    }
 
    public void act() {
        String key = Greenfoot.getKey();
        if (text.equals("Enter a name")) {
            text = "";
        }
        if (key == null) return;
        if ("enter".equals(key) && text.length() > 0) {
            System.out.println("You entered String "+text);
            text = "";
            updateImage();
            return;
        }
        if ("backspace".equals(key) && text.length() > 0) text = text.substring(0, text.length() - 1);
        if ("escape".equals(key)) text = "";
        if ("space".equals(key)) key = " ";
        if (key.length() == 1 && text.length() < MAX_INPUT_LENGTH) text += key;
        updateImage();
        if (text.length() == 0) {
            text = "Enter a name";
            updateImage();
        }
    }
}