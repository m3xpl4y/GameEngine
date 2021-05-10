package at.ran.games.RocketGame.interfaces;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface IActor {

    void render(Graphics graphics);
    void update(GameContainer gameContainer, int delta) throws SlickException;
}
