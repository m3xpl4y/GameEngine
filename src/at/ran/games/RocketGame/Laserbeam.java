package at.ran.games.RocketGame;

import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class Laserbeam implements ICollision {

    private float weaponStrength;
    private float xL,yL, xR, yR;
    private final Image laserBeamL;
    private final Image laserBeamR;
    private Shape collisonShape;
    private Shape collisonShape2;


    public Laserbeam(float x,float y, float weaponStrength) throws SlickException {
        Image tmp = new Image("src/at/ran/games/RocketGame/images/laserbeam.png");
        this.laserBeamL = tmp.getScaledCopy(15,29);
        this.laserBeamR = tmp.getScaledCopy(15,29);
        this.xL = x;
        this.yL = y;
        this.xR = x;
        this.yR = y;
        this.weaponStrength = weaponStrength;
        this.collisonShape = new Rectangle(this.xL,this.yL +10, laserBeamL.getWidth()-10, laserBeamL.getHeight());
        this.collisonShape2 = new Rectangle(this.xR +61,this.yR +10, laserBeamR.getWidth() -10, laserBeamR.getHeight());
    }

    @Override
    public void render(Graphics graphics) {
        laserBeamL.draw(this.xL - 5, this.yL + 10);
        laserBeamR.draw(this.xR +61, this.yR + 10);
//        graphics.draw(this.collisonShape);
//        graphics.draw(this.collisonShape2);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.yL -= 10;
        this.yR -= 10;
        this.collisonShape.setX(this.xL);
        this.collisonShape.setY(this.yL);
        this.collisonShape2.setX(this.xR + 68);
        this.collisonShape2.setY(this.yR + 5);
    }

    @Override
    public Shape getShape() {
        return collisonShape;
    }

    @Override
    public Shape getShape2() {
        return collisonShape2;
    }

    public float getWeaponStrength() {
        return weaponStrength;
    }
}
