//package breakoutgame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;



import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;





public class Paddle extends BreakoutShape{
public static final int WIDTH = 60 ;
public static final int HEIGHT=13;
public static final int START_X=200;
public static final int START_Y=480;
public static final int STEP=10;

private BreakoutPanel panel;

public Paddle(Color color, BreakoutPanel panel){
     super(new Rectangle2D.Double(START_X,Paddle.START_Y,Paddle.WIDTH,Paddle.HEIGHT),color,true);
     this.panel=panel;
 }


/*public void draw(Graphics2D g2,TexturePaint img){
	g2.setPaint(img);
	g2.draw(this);
	g2.fillRect(this.getX,this.getY,this.get.getWidth,this.getHeight);///////////////////////////
	//if(fill){g2.fill();
}*/

public void move(int dx) {
	if((getX() + dx >= 0) && (getX() + dx + WIDTH <= panel.getWidth())) move(dx,0) ;
}
public void moveRight( ) {move (STEP) ;}
public void moveLeft( ) {move (-STEP) ;}
}
