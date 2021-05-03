package at.ran.games.RocketGame;

import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class NPCEnemy implements ICollision {

    private float health;
    private float strenght;
    private float x,y;
    private int speed;
    private final Image NPCimage;
    private Shape collisonShape;
    private List<ICollision> collisionList;
    int counter = 0;

    public NPCEnemy(float x, float y, float w, float h, int speed, float health, float strenght) throws SlickException {
        Image tmp = new Image("src/at/ran/games/RocketGame/images/tieFighter.png");
        this.NPCimage = tmp.getScaledCopy(55, 55);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        this.strenght = strenght;
        this.collisonShape = new Rectangle(this.x,this.y, NPCimage.getWidth(), NPCimage.getHeight());
        this.collisionList = new ArrayList<ICollision>( );


    }

    @Override
    public void render(Graphics graphics) {
        NPCimage.draw(this.x,this.y);
        graphics.draw(this.collisonShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for (ICollision collision: collisionList) {
            if(this.collisonShape.intersects(collision.getShape()))
            {
                this.health--;
                System.out.println("Feuer Collision Links " + this.health);
            }
        }
        for (ICollision collision: collisionList) {
            if(this.collisonShape.intersects(collision.getShape2()))
            {
                this.counter++;
                this.health--;
                System.out.println("Feuer Collision Rechts " + this.health  + " Zähler: " + this.counter);
            }
        }
        this.y += (float) delta/speed;
        if(this.y > 600)
        {
            this.y = -200;
        }
        this.collisonShape.setX(this.x);
        this.collisonShape.setY(this.y);
    }

    @Override
    public Shape getShape() {
        return collisonShape;
    }

    @Override
    public Shape getShape2() {
        return null;
    }


    public void addCollisionLaserBeamPartner(ICollision collision)
    {
        this.collisionList.add(collision);
    }

    public float getHealth() {
        return health;
    }
}
