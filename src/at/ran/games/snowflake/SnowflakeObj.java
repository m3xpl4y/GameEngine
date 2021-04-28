package at.ran.games.snowflake;

import at.ran.games.rectangleGame.Actor;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class SnowflakeObj implements Actor {

    private Image snowflake = new Image("src/at/ran/games/snowflakePic/snowflake2.png");
    private float x,y;
    private float w,h;
    private int speed;

    public SnowflakeObj() throws SlickException {
    }

    public SnowflakeObj(float x, float y, float w, float h, int speed) throws SlickException{
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.speed = speed;
    }

    @Override
    public void render(Graphics graphics) {
        snowflake.draw(this.x, this.y, this.w, this.h);
    }

    @Override
    public void update(int delta) {
        this.y += (float) delta/speed;
        if(this.y > 600)
        {
            this.y = -200;
        }
    }
}
