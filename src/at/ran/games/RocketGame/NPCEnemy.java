package at.ran.games.RocketGame;

import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.particles.ParticleIO;
import org.newdawn.slick.particles.ParticleSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NPCEnemy implements ICollision {

    private int deaths;
    private float health;
    private float strenght;
    private float x,y;
    private int speed;
    private final Image NPCimage;
    private Shape collisonShape;
    private List<ICollision> collisionList;
    int counter = 0;


    public NPCEnemy(float x, float y, float w, float h, int speed, float health, float strength) throws SlickException {
        Image tmp = new Image("src/at/ran/games/RocketGame/images/tieFighter.png");
        this.NPCimage = tmp.getScaledCopy(55, 55);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.health = health;
        this.strenght = strength;
        this.collisonShape = new Rectangle(this.x,this.y, NPCimage.getWidth(), NPCimage.getHeight());
        this.collisionList = new ArrayList<ICollision>( );
    }

    @Override
    public void render(Graphics graphics) {
        if(health > 0) {
            NPCimage.draw(this.x, this.y);
        }
        if (health < 0) {
            deaths += 10;
        }
        //graphics.draw(this.collisonShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        //region MOVEMENT
        this.y += (float) delta/speed;
        if(this.y > 600)
        {
            this.y = -200;
        }
        //endregion

            for (ICollision collision: collisionList) {
                if(this.collisonShape.intersects(collision.getShape()))
                {
                    counter++;
                    this.health -= 6;
                    System.out.println("Feuer Collision " + this.health);
                }
            }

        //region COLLISION
        if(this.health > 0){
            this.collisonShape.setX(this.x);
            this.collisonShape.setY(this.y);
        }
        else
        {
            this.collisonShape.setY(-500);
            this.collisonShape.setX(900);
        }
        //endregion
    }

    @Override
    public Shape getShape() {
        return collisonShape;
    }


    public void addCollisionLaserBeamPartner(ICollision collision)
    {
        this.collisionList.add(collision);
    }

    public int getDeaths() {
        return deaths;
    }
}
