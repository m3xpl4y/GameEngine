package at.ran.games.RocketGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Laserbeam implements IActor{

    private float x,y;
    private Image laserBeam;

    public Laserbeam(float x,float y) throws SlickException {
        Image tmp = new Image("src/at/ran/games/RocketGame/images/laserbeam.png");
        this.laserBeam = tmp.getScaledCopy(15,29);
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Graphics graphics) {
        laserBeam.draw(this.x - 5, this.y + 10);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y -= 10;
    }
}
