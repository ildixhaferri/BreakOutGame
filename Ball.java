//package breakoutgame;


import java.awt.*;
import java.awt.geom.*;

public class Ball extends BreakoutShape {
public static final int STEP =6;
public static final int SIZE =20;
public static final int START_X=200;
public static final int START_Y=400;
private int dx = STEP;
private int dy = -STEP;
private BreakoutPanel panel;

public Ball(Color color, BreakoutPanel panel){
	super(new Ellipse2D.Double(START_X,START_Y,SIZE,SIZE),color,true);
	this.panel=panel;
}

private Ball(Color color, Ellipse2D.Double ellipse){	super(ellipse,color,true);}

public Ball getVirtualBall(){
	return new Ball(super.getColor(),new Ellipse2D.Double(getX()+dx,
	getY()+dy,SIZE,SIZE));
}

public void move(){
	if(getX()+dx<0)										dx=STEP;
	else if(getX()+getWidth()+dx > panel.getWidth())	dx=-STEP;

	if(getY()+dy < 0)									dy=STEP;
	else if(getY()+getHeight()+dy > panel.getHeight())	dy=-STEP;
	super.move(dx,dy);
}

public void goUp(){		dy=-STEP;}
public void goDown(){	dy=STEP;}
public void goLeft(){	dx=-STEP;}
public void goRight(){	dx=STEP;}

}
