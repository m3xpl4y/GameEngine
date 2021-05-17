package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class NPCEnemy implements ICollision {

    private float health;
    private float strength;
    private float x, y;
    private int speed;
    private final Image NPCimage;
    private Shape collisonShape;
    private List<ICollision> collisionList;
    int counter = 0;
    private Explosion explosion;
    private int millisSinceStart = 0;
    private boolean hasStartedExplosion = false;
    private Sound sound;

    public NPCEnemy(float x, float y, float w, float h, int speed, float health, float strength) throws SlickException {
        Image tmp = new Image("src/at/ran/games/RocketGame/images/tieFighter.png");
        this.NPCimage = tmp.getScaledCopy(55, 55);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        this.strength = strength;
        this.collisonShape = new Rectangle(this.x, this.y, NPCimage.getWidth(), NPCimage.getHeight());
        this.collisionList = new ArrayList<ICollision>();
        sound = new Sound("src/at/ran/games/RocketGame/sounds/ExplosionSound2.wav");
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        if (health > 0) {
            NPCimage.draw(this.x, this.y);
        }
        if (isDead()&& millisSinceStart<1200) {

            explosion.render(graphics);
            sound.play();
        }
        //graphics.draw(this.collisonShape);
    }



    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        //region MOVEMENT
        this.y += (float) delta / speed;
        if (this.y > 600) {
            this.y = -50;
        }
        //endregion
        //region COLLISION
        if (this.health > 0) {
            this.collisonShape.setX(this.x);
            this.collisonShape.setY(this.y);
        } else {

            this.collisonShape.setY(-500);
            this.collisonShape.setX(900);
        }

        //endregion
        //region FEUER COLLISION
        for (ICollision collision : collisionList) {
            if (this.collisonShape.intersects(collision.getShape())) {
                counter++;
                this.health -= 21;
                System.out.println("Feuer Collision " + this.health);
            }
        }
        //endregion

        if (isDead() && !hasStartedExplosion){
            this.explosion = new Explosion();
            explosion.setX(this.x);
            explosion.setY(this.y);
            this.millisSinceStart=0;
            this.hasStartedExplosion = true;
        }
        millisSinceStart += delta;
    }

    private boolean isDead(){
        return getHealth()<=0?true:false;
    }

    @Override
    public Shape getShape() {
        return collisonShape;
    }

    public float getHealth() {
        return health;
    }

    public void addCollisionLaserBeamPartner(ICollision collision) {
        this.collisionList.add(collision);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

}
