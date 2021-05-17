package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.IActor;
import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class BackgroundPlanet implements IActor, ICollision {
    private Image bgImage3;
    float x,y;
    private int speed;

    public BackgroundPlanet(float x, float y, int speed) throws SlickException {
        this.x = x;
        this.y = y;
        this.speed = speed;
        bgImage3 = new Image("src/at/ran/games/RocketGame/images/bg3.png");
        bgImage3.getScaledCopy(200,150);
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        bgImage3.draw(this.x, this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.y += (float) delta / speed;
        if(this.y > 600)
            this.y = -100;
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
