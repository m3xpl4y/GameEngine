package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.IActor;
import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Shape;


public class Explosion implements IActor, ICollision{

    private SpriteSheet spriteSheet;
    private Animation animation;
    private float x,y;

    public Explosion() throws SlickException {
        this.spriteSheet = new SpriteSheet("src/at/ran/games/RocketGame/images/explosionSpriteSheet.png", 96,96);
        this.animation = new Animation(spriteSheet, 100);
    }


    @Override
    public void render(Graphics graphics) {
        animation.draw(x, y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        animation.update(delta);
    }
    public float setX(float x)
    {
        this.x = x;
        return this.x;
    }
    public float setY(float y)
    {
        this.y = y;
        return this.y;
    }

    @Override
    public Shape getShape() {
        return null;
    }
}
