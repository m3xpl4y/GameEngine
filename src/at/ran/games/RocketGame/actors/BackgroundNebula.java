package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.IActor;
import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Shape;

public class BackgroundNebula  implements IActor, ICollision {

    private Image bgImage2;
    float x,y;
    private int speed;

    public BackgroundNebula(float x, float y, int speed) throws SlickException {
        this.x = x;
        this.y = y;
        this.speed = speed;
        bgImage2 = new Image("src/at/ran/games/RocketGame/images/bg2.png");
        bgImage2.getScaledCopy(125, 121);
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        bgImage2.draw(this.x, this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.y += (float) delta / speed;
        if(this.y > 600)
            this.y = -10;
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
