package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.IActor;
import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class BackgroundSpace implements IActor, ICollision {

    private Image bgImage1;
    float x,y;
    private int speed;

    public BackgroundSpace(float x, float y, int speed) throws SlickException {
        this.x = x;
        this.y = y;
        this.speed = speed;
        bgImage1 = new Image("src/at/ran/games/RocketGame/images/bg1.png");
        bgImage1.getScaledCopy(2f);
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        bgImage1.draw(this.x, this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.y += (float) delta / speed;
        if(this.y > 450)
            this.y = 450;
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
