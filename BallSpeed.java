
//package breakoutgame;


public enum BallSpeed {
    FAST(10),
    NORMAL(20),
    SLOW(30);
    private int speed;

    BallSpeed(int speed){this.speed=speed;}
    int speed(){return speed;}

}
