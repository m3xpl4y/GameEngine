package at.ran.games.rectangleGame;

import org.newdawn.slick.Graphics;

public class Rectangle implements Actor{

    private float x,y;
    private float speed;
    private String direction;

    final private String DIRECTION_LEFT = "left";

    public Rectangle(float x, float y, float speed, String direction) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction = direction;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, 40, 40);

    }

    @Override
    public void update(int delta) {
        if(direction.equalsIgnoreCase(DIRECTION_LEFT))
        {
            this.x += (float) delta/speed;
        }
        else
        {
            this.x -= (float) delta/speed;
        }
        if(this.x > 800)
        {
            this.x = 0;
        }
        if(this.x < 0)
        {
            this.x = 800;
        }
    }



}
