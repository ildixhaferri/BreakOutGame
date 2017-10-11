//package breakoutgame;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.*;

public class Brick extends BreakoutShape {

public static final int WIDTH = 50 ;
public static final int HEIGHT=20;
public static final int BRICK_H_GAP=10;
public static final int BRICK_V_GAP=10;

private int x,y;
public Color color;
private RectangularShape shape;
private boolean fill;

public Brick(int row,int col,Color color){
	super(new Rectangle2D.Double(BRICK_H_GAP + row*(BRICK_H_GAP + Brick.WIDTH),BRICK_V_GAP + col*(BRICK_V_GAP+Brick.HEIGHT),
	WIDTH,HEIGHT),color,true);

	x=BRICK_H_GAP+col*(BRICK_H_GAP+Brick.WIDTH);
	y=BRICK_V_GAP+row*(BRICK_V_GAP+Brick.HEIGHT);
}

private Brick(Rectangle2D rectangle,Color color){super(rectangle,color,true);}


/*public void draw(Graphics2D g2){
	g2.setPaint(color);
	g2.draw(shape);
	if(fill){g2.fill(shape);}
}*/

public Brick add(Brick other){
     Rectangle2D rectangle1=super.getBounds();
     Rectangle2D rectangle2=other.getBounds();
     rectangle1.add(rectangle2);
     return new Brick(rectangle1,super.getColor());
}
}
