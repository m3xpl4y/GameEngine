package at.ran.games.rectangleGame;

import org.newdawn.slick.Graphics;

public class Eclipsen implements Actor{

    private float x,y;
    private float speed;

    public Eclipsen(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y,80, 50);
    }

    @Override
    public void update(int delta) {
        this.x += (float) delta/speed;
        this.y += (float) delta/speed;
        if(this.x > 800 && this.y > 600)
        {
            this.x = 0;
            this.y = 0;
        }
    }
}
