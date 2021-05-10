package at.ran.games.RocketGame;

import at.ran.games.RocketGame.vo.GamePoint;

public class GameHelper {
    public static GamePoint getLeftPosition(float x, float y){
        GamePoint gp = new GamePoint(x, y);
        return gp;
    }
    public static  GamePoint getRightPosition(float x, float y)
    {
        GamePoint gp = new GamePoint(x+68, y);
        return gp;
    }
}
