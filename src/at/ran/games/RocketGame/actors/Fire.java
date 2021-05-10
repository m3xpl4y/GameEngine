package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.IActor;
import at.ran.games.RocketGame.vo.GamePoint;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.particles.ConfigurableEmitter;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import java.io.IOException;

public class Fire implements IActor {

    private ParticleSystem fire;
    private ParticleSystem trail;
    private float x,y;


    public Fire() throws SlickException {
        try {
            fire = ParticleIO.loadConfiguredSystem("testdata/system.xml");
            trail = ParticleIO.loadConfiguredSystem("testdata/smoketrail.xml");

        } catch (IOException e) {
            throw new SlickException("Failed to load particle systems", e);
        }
    }

    @Override
    public void render(Graphics graphics) {
       ((ConfigurableEmitter) trail.getEmitter(0)).setPosition(100,200);
        trail.render();
        fire.render();
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        fire.update(delta);
        trail.update(delta);
    }
}
