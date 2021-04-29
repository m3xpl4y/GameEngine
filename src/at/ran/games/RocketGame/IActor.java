package at.ran.games.RocketGame;

import org.newdawn.slick.Graphics;

public interface IActor {
    void render(Graphics graphics);
    void update(int delta);
}
