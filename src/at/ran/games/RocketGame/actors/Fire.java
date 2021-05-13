package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.IActor;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;
import org.newdawn.slick.particles.effects.FireEmitter;

import java.io.IOException;

public class Fire implements IActor {

    private ParticleSystem fire;
    private ParticleSystem trail;
    private float x,y;


    public Fire(float x, float y) throws SlickException {

        try {
            this.x = x;
            this.y = y;
            fire = ParticleIO.loadConfiguredSystem("testdata/system.xml");
            trail = ParticleIO.loadConfiguredSystem("testdata/smoketrail.xml");
            fire.addEmitter(new FireEmitter((int)x,(int)y, 20));

        } catch (IOException e) {
            throw new SlickException("Failed to load particle systems", e);
        }
    }

    @Override
    public void render(Graphics graphics) {
       ((ConfigurableEmitter) trail.getEmitter(0)).setPosition(x,y, true);
        trail.render();
        fire.render();
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        fire.update(delta);
        trail.update(delta);
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
