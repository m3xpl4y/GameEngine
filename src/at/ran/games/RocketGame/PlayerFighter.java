package at.ran.games.RocketGame;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PlayerFighter implements IActor{

    private Image playerImage;

    public PlayerFighter() throws SlickException {
        this.playerImage = new Image("images/xwing.png");
    }

    @Override
    public void render(Graphics graphics) {
        playerImage.draw(100, 100);
    }

    @Override
    public void update(int delta) {

    }
}
