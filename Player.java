//package breakoutgame;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Player {

public static int INITIAL_NUM_LIVES = 3 ;
public static int IMAGE_DISTANCE = 20 ;
public static int IMAGE_Y_POSITION = 500;
public static int IMAGE_H_GAP =2;
private int numLives ;

public Player(){this.numLives=INITIAL_NUM_LIVES;}

public void killPlayer(){	numLives--;}

public boolean isAlive(){	return(numLives>0);}

public void draw(Graphics2D g2){
    try{
        Image image=new ImageIcon("Images/runman3a.gif").getImage();  		// Image image=ImageIO.read(new File("Images/3dman.png"));
        for(int x=0;x<numLives;x++){g2.drawImage(image,x *(image.getWidth(null)-30),IMAGE_Y_POSITION,null);}
    }catch(Exception myException){System.out.println("Images not found");}
}

}
