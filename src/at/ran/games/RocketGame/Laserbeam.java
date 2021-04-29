package at.ran.games.RocketGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Laserbeam implements IActor{

    private float x,y;
    private Image laserBeam;
    private Shape collisonShape;

    public Laserbeam(float x,float y) throws SlickException {
        Image tmp = new Image("src/at/ran/games/RocketGame/images/laserbeam.png");
        this.laserBeam = tmp.getScaledCopy(15,29);
        this.x = x;
        this.y = y;
        this.collisonShape = new Rectangle(this.x,this.y +10, laserBeam.getWidth()-10, laserBeam.getHeight());
    }

    @Override
    public void render(Graphics graphics) {
        laserBeam.draw(this.x - 5, this.y + 10);
        //graphics.draw(this.collisonShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y -= 10;
        this.collisonShape.setX(this.x);
        this.collisonShape.setY(this.y);
    }
}
