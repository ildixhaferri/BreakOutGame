
//package breakoutgame;

import java.awt.EventQueue;
import javafx.scene.paint.Color;


public class BreakoutGame {

public static void main(String[] args) {
    EventQueue.invokeLater (new Runnable ( ) {
        public void run( ) {
			BreakoutFrame frame = new BreakoutFrame ( ) ;
			//frame.add(new BreakoutPanel());
			frame.setVisible(true) ;
       }
	}) ;
}

} // end of class


