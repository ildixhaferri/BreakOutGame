
//package breakoutgame;

import java.awt.Color;

public enum BallColor {
    Red(Color.RED),
    Blue(Color.BLUE),
    Green(Color.GREEN);
    private Color color;

    BallColor(Color color){
        this.color=color;
    }
    Color color(){return color;}


}
