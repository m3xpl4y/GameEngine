package at.ran.games.rectangleGame;

import org.newdawn.slick.Graphics;

public class Circle implements Actor{

    private float x, y;
    private float speed;
    private float diameter;

    public Circle(float x, float y, float speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.diameter, this.diameter);
    }

    @Override
    public void update(int delta) {
        this.x += (float) delta/speed;
        this.diameter += 0.05;
        if(this.x > 800)
        {
            this.x = 0;
            this.diameter = 0;
        }
    }
}
