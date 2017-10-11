//package breakoutgame;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.ImageIcon;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;


public class BreakoutShape {

public Color color;
private boolean fill;
private RectangularShape shape;

public BreakoutShape(RectangularShape shape,Color color,boolean fill){
	this.shape=shape;
	this.color=color;
	this.fill=fill;
}

public boolean interesects(BreakoutShape other){return shape.intersects(other.shape.getBounds());}

public Color getColor(){return color;}

protected Rectangle getBounds(){return shape.getBounds();}

public void changeColor(Color color){this.color=color;}

/*public void draw(Graphics2D g2){
	g2.setPaint(color);
	g2.draw(shape);
	//g2.fillRect(shape.getX,shape.getY,shape.get.getWidth,shape.getHeight);///////////////////////////
	if(fill){g2.fill(shape);
	//g2.setStroke(new BasicStroke(Color.BLACK,5));
	}
}*/

/*public void draw(Graphics2D g2,ImageIcon img){
	double i=getX();double j=getY();

	g2.setPaint(color);
	g2.drawImage(img,i.intValue(),j.intValue(),null);
	//g2.fillRect(shape.getX,shape.getY,shape.get.getWidth,shape.getHeight);///////////////////////////
	if(fill){g2.fill(shape);}
}*/

public void draw(Graphics2D g2){
	g2.setPaint(color);
    //Graphics g=(Graphics)g2;
	g2.draw(shape);
	//g2.fillRect(shape.getX,shape.getY,shape.get.getWidth,shape.getHeight);///////////////////////////
	if(fill){g2.fill(shape);}
	g2.setColor(Color.black);
	g2.draw(shape);
	g2.setStroke(new BasicStroke(5));
}

public double getX(){		return shape.getX();}
public double getY(){		return shape.getY();}
public double getHeight(){	return shape.getHeight();}
public double getWidth(){	return shape.getWidth();}

public boolean below(BreakoutShape other){		return getY()>=other.getY()+other.getHeight();}

public boolean above(BreakoutShape other){		return getY()+getHeight()<=other.getY();}

public boolean leftOf(BreakoutShape other){		return getX()+getWidth()<=other.getX();}

public boolean rightOf(BreakoutShape other){	return getX() >= other.getX()+ other.getWidth();}

public void move(int dx,int dy){				shape.setFrame(getX()+dx,getY()+dy,getWidth(),getHeight());}


}
