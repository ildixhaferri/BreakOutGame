//package breakoutgame;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import java.lang.System.*;


import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;



public class BreakoutPanel extends JPanel{
private static final long serialVersionUID = 1L;

private static final int NUM_BRICK_ROWS = 5;
private static final int NUM_BRICK_COLUMNS = 9;
private static final int SPEED = 125;	// from 1 to 1000

private javax.swing.Timer timer;
private Ball ball;
private Paddle paddle;
private Player player;
private boolean gameStarted=true;
public ArrayList <Brick> bricks ;
int i=10;
public int coll = 0;
long startTime;
long estimatedTime;
private int points=0;
private String Points;


//private BufferedImage slate;

//Image img = ImageIO.read(new File("Images/bck.jpg"));
Image img = new ImageIcon("Images/fight.gif").getImage(); 		 //get an image for the Background
Image img2 = new ImageIcon("Images/slate.png").getImage();
																//Toolkit.getDefaultToolkit().createImage("Images/bck2.jpg");
Image brick_img = Toolkit.getDefaultToolkit().createImage("Images/brick.jpg");

public void imgCover(){
	try{
BufferedImage slate = ImageIO.read(new File("Images/slate.png"));
java.awt.TexturePaint slatetp = new TexturePaint(slate, new Rectangle(0, 0, 90, 60));
}catch(Exception e){}
}



public void changeBallColor(BallColor color){
	ball.changeColor(color.color());
	repaint();
}
public BreakoutPanel() {
	ball   = new Ball(getRandomColor(),this);
	paddle = new Paddle(Color.WHITE,this);
	bricks = new ArrayList<>();
	player = new Player();
	//g.drawImage(img, 0, 0, null);
	//repaint();

	createBricks();
	imgCover();



	timer  = new javax.swing.Timer(20, new BreakoutPanel.TimeListener());

	timer.start();
    startTime = System.currentTimeMillis();
    estimatedTime=System.currentTimeMillis();
    System.out.println("StartTime is  "+startTime+"\n\n");




    System.out.println(System.currentTimeMillis());

	addKeyListener(new KeyAdapter(){
		public void keyPressed(KeyEvent e){
			if(e.getKeyCode()==KeyEvent.VK_LEFT)	paddle.moveLeft();
			if(e.getKeyCode()==KeyEvent.VK_RIGHT)	paddle.moveRight();
			repaint();
		}
	});

	setFocusable(true);

	addMouseMotionListener(new MouseMotionAdapter(){
	   boolean firstTime=true;
	   int oldX;
	   public void mouseMoved(MouseEvent e){
		   if(firstTime){
			   oldX=e.getX();
			   firstTime=false;
		   }
		   paddle.move(e.getX()-oldX);
		   oldX=e.getX();
		   repaint();
	   }
	});

} //end of Constructor


/*public void drawpaddle(Graphics2D g2,TexturePaint img){
	g2.setPaint(img);
	g2.drawImage(this );
	g2.fillRect((int)paddle.getX,paddle.getY,paddle.get.getWidth,paddle.getHeight);///////////////////////////
	//if(fill){g2.fill();
}*/

public void start(){
	gameStarted=true;
	if(timer!=null)timer.stop();
	if(!player.isAlive())
	{
		player = new Player();
		ball = new Ball(getRandomColor(),this);
		createBricks();

		timer = new javax.swing.Timer(BallSpeed.NORMAL.speed(),new BreakoutPanel.TimeListener());
		timer.start();

	}
	repaint();
}

public void resume(){	// pause the game
	if(timer==null)	return;
	timer.start();
}

private Color getRandomColor(){	// select random RGB values between 0 and 255
	Color color = new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));
	if(getBackground().equals(color))	return Color.RED;
	return color;
}

private void createBricks(){	// create bricks
	for(int row=0; row < NUM_BRICK_COLUMNS; row++){
		for(int col=coll;col < NUM_BRICK_ROWS; col++){
			bricks.add(new Brick(row,col,getRandomColor()));
		}
		System.out.println("Coll eshte " +coll);
	}
	//createBricks2();
}

public  void createBricks2(int frow,int fcol){	// create bricks
	for(int row=0; row < frow; row++){
		for(int col=0; col < fcol; col++){
			bricks.add(new Brick(row,col,getRandomColor()));

		}
	}

}




public void pause(){	// pause the game
	if(timer==null)	return;
	timer.stop();
}

public void showMessage(String s,Graphics2D g2){	// display message
	Font myFont= new Font("SansSerif",Font.BOLD+Font.ITALIC,40);
	g2.setFont(myFont);
	g2.setColor(Color.red);
	Rectangle2D textBox=myFont.getStringBounds(s, g2.getFontRenderContext());
	g2.drawString(s, (int)(getWidth()/ 2- textBox.getWidth()/2),(int)
				  (getHeight()/2-textBox.getHeight()));
}



public void showPoints(String s,Graphics2D g2){	// display message
	Font myFont= new Font("Brush Script MT",Font.BOLD+Font.ITALIC,60);
	g2.setFont(myFont);
	g2.setColor(Color.white);
	Rectangle2D textBox=myFont.getStringBounds(s, g2.getFontRenderContext());
	g2.drawString(s, 400,570);
}

public void showTotal(String s,Graphics2D g2){	// display message
	Font myFont= new Font("Brush Script MT",Font.BOLD+Font.ITALIC,60);
	g2.setFont(myFont);
	g2.setColor(Color.white);
	Rectangle2D textBox=myFont.getStringBounds(s, g2.getFontRenderContext());

	g2.drawString(s, (int)(getWidth()/ 2- textBox.getWidth()/2),(int)
				  (getHeight()/2-textBox.getHeight()+85));
}



public void background(Graphics2D g) {
try {
g.drawImage(img, 0, 0, null);}
catch(Exception myException){System.out.println("Images not found");}
repaint();
}








public void paintComponent(Graphics g){

	super.paintComponent(g);

    //imgCover();
	Graphics2D g2 = (Graphics2D) g;

	background(g2);
	showPoints(Points,g2);
	if(bricks.size()< 25)
	{createBricks2(9,3);}

	if (bricks.size()==0 && gameStarted) {

		showMessage("YOU WIN ! ",g2);
		gameStarted=true;
	}
	else if (!player.isAlive()){

		showMessage("GAME OVER !", g2);
		gameStarted=false;
		showTotal("Total: "+Points,g2);
		}
	else {

		ball.draw(g2);
		paddle.draw(g2);
		for(Brick brick:bricks){
			//if(System.currentTimeMillis()- (System.currentTimeMillis()-1000)> 100)
			//brick.move(0,1);
			brick.draw(g2);

		}

	}
	if(gameStarted)player.draw(g2);
	//if(System.currentTimeMillis() > (estimatedTime + 100000)){createBricks2(9,2);}
}

public void changeBallSpeed(int speed){timer.setDelay(speed);}

// class TimeLister
class TimeListener implements ActionListener {

public void bounceBall(Ball ball,Brick brick){
	if(ball.below(brick))	ball.goDown();
	if(ball.above(brick))	ball.goUp();
	if(ball.leftOf(brick))	ball.goLeft();
	if(ball.rightOf(brick))	ball.goRight();
}



public void bounceBall(Ball ball,ArrayList<Brick> bricks){
	if(bricks.size()==0)	return;
	if(bricks.size()==1){
		bounceBall(ball,bricks.get(0));
		return;
	}
	Brick combinedBrick=bricks.get(0).add(bricks.get(1));
	bounceBall(ball,combinedBrick);
}

public void actionPerformed(ActionEvent e){
	Ball newBall = ball.getVirtualBall();
	ArrayList <Brick> bricksToBeDeleted = new ArrayList<Brick>();
	for(Brick brick:bricks){
		if(brick.interesects(newBall))	bricksToBeDeleted.add(brick); //&&(brick.color).equals(ball.color)
		//if((brick.color).equals(ball.color)
		}
	bounceBall(ball,bricksToBeDeleted);
	for(Brick brick:bricksToBeDeleted){
		bricks.remove(brick);
		points=points+100;
	}



	if(newBall.interesects(paddle)){
		ball.goUp();
		if(newBall.getX()+newBall.getWidth()/2 <paddle.getX()+paddle.getWidth()/2)		ball.goLeft();
		else																			ball.goRight();
	}
	else if(ball.getY()>paddle.getY()-paddle.getHeight()){
		ball.goUp();
		player.killPlayer();
		pause();

	}

	ball.move();
	if(coll>20) coll=0;
	coll++;
    Points=Integer.toString(points);
	repaint();
	 if(System.currentTimeMillis()- startTime > 1000){
		for(Brick brick:bricks){
		brick.move(0,3);
		}
		startTime=System.currentTimeMillis();

	//createBricks2(5,1);
		}
}


} // end class TimeLister

} // end class BreakoutPanel






