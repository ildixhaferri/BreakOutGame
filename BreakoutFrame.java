//package breakoutgame;

//import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.*;
import java.awt.event.*;
//import javafx.scene.paint.Color;



public class BreakoutFrame extends JFrame{
private static final long serialVersionUID = 1L;
public static final int HEIGHT= 650;
public static final int WIDTH = 565;
public static final int LOCATION_X=550;
public static final int LOCATION_Y=10;

private BreakoutPanel panel= new BreakoutPanel();

public BreakoutFrame(){
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	displayMenu();
	setLocation(LOCATION_X,LOCATION_Y);
	setSize(WIDTH,HEIGHT);
	add(panel);
	setResizable(true);
	setBackground(Color.BLACK);

}
public void displayMenu(){
	JMenuBar menuBar=new JMenuBar();
	menuBar.add(new GameMenu());
	menuBar.add(new ColorMenu());
	menuBar.add(new SpeedMenu());
	setJMenuBar(menuBar);
}
// class GameMenu
private class GameMenu extends JMenu{
private static final long serialVersionUID = 1L;

public GameMenu(){
	super("Game");
	JMenuItem startGameMI=new JMenuItem("Start",'s');
	startGameMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
	JMenuItem pauseMI=new JMenuItem("Pause",'p');
	pauseMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
	JMenuItem ResumeMI=new JMenuItem("Resume",'r');
	ResumeMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
	JMenuItem quitMI=new JMenuItem("Quit");

	startGameMI.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
				panel.start();
			}
		});
		pauseMI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				panel.pause();
			}
		});

		ResumeMI.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						panel.resume();
					}
		});

		quitMI.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});

		add(startGameMI);
		add(pauseMI);
		add(ResumeMI);
		add(quitMI);
	}

}

private class ColorMenu extends JMenu {
private static final long serialVersionUID = 1L;
    public ColorMenu(){
        super("    Ball Color");
        for(BallColor color:BallColor.values()){
            JMenuItem menuItem =new JMenuItem(color.name()+" Ball");
            menuItem.addActionListener(new BallColorListener(color));
            add(menuItem);
        }
    }
}

private class BallColorListener implements ActionListener {
    private BallColor color;
    public void actionPerformed(ActionEvent e){
        panel.changeBallColor(color);
    }
    public BallColorListener(BallColor color){
        this.color= color;
    }
}

private class SpeedMenu extends JMenu {
private static final long serialVersionUID = 1L;
    public SpeedMenu(){
        super("    Ball Speed");
        for(BallSpeed s:BallSpeed.values()){
            JMenuItem menuItem=new JMenuItem(s.name());
            menuItem.addActionListener(new BallSpeedListener(s.speed()));
            add(menuItem);
        }
    }
}

private class BallSpeedListener implements ActionListener {
    private int speed;
    public void actionPerformed(ActionEvent e){panel.changeBallSpeed(speed);}
    public BallSpeedListener(int speed){this.speed=speed;}
}

}