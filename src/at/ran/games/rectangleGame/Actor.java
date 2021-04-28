package at.ran.games.rectangleGame;

import org.newdawn.slick.Graphics;

public interface Actor {
    void render(Graphics graphics);
    void update(int delta);
}
