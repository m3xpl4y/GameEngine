package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.ICollision;
import at.ran.games.RocketGame.vo.GamePoint;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import java.util.ArrayList;
import java.util.List;


public class Laserbeam implements ICollision {

    private int health = 1;
    private float x,y;
    private final Image laserBeam;
    private Shape collisonShape;
    private List<ICollision> collisionList;

    public Laserbeam(GamePoint coordinates) throws SlickException {
        Image tmp = new Image("src/at/ran/games/RocketGame/images/laserbeam.png");
        this.laserBeam = tmp.getScaledCopy(15,29);
        this.x = coordinates.getX();
        this.y = coordinates.getY();
        this.collisonShape = new Rectangle(this.x,this.y, laserBeam.getWidth()-10, laserBeam.getHeight());
        this.collisionList = new ArrayList<ICollision>( );
    }



    @Override
    public void render(Graphics graphics) {
        if(health > 0) {
            laserBeam.draw(this.x - 5, this.y + 10);
        }
        graphics.draw(this.collisonShape);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for(ICollision collision : collisionList)
        {
            if (this.collisonShape.intersects(collision.getShape()))
            {
                this.health--;
            }
        }
        this.y -= 10;

        if(health > 0)
        {
            this.collisonShape.setX(this.x);
            this.collisonShape.setY(this.y);
        }
        else{
            this.collisonShape.setX(-600);
            this.collisonShape.setY(1000);
        }
    }

    @Override
    public Shape getShape() {
        return collisonShape;
    }

    public void addCollisionNPCLaserbeam(ICollision collision)
    {
        this.collisionList.add(collision);
    }
}
