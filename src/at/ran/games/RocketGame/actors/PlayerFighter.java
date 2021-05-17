package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class PlayerFighter implements ICollision {

    private int playerMovementSpeed = 4;
    private int health;
    private int x = 370;
    private int y = 520;
    private Image playerImage;
    private Shape collisonShape;
    private List<ICollision> collisionList;
    private Explosion explosion;
    private int millisSinceStart = 0;
    private boolean hasStartedExplosion = false;

    public PlayerFighter(int health) throws SlickException {
       Image tmp = new Image("src/at/ran/games/RocketGame/images/xwing.png");
        this.playerImage = tmp.getScaledCopy(75,75);
        this.health = health;
        this.collisonShape = new Circle(this.x,this.y, playerImage.getWidth()/2, playerImage.getHeight()/2);
        this.collisionList = new ArrayList<ICollision>();
    }

    @Override
    public void render(Graphics graphics) {
        if(health > 0)
            playerImage.draw(this.x, this.y);
        //graphics.draw(this.collisonShape);
        if(isDead() && millisSinceStart<1200)
        {
            explosion.render(graphics);

        }


    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (ICollision collision: collisionList) {
            if(this.collisonShape.intersects(collision.getShape()))
            {
                health--;
                System.out.println("Collision: " + health);
            }
        }
        if(isDead() && !hasStartedExplosion)
        {
            this.explosion = new Explosion();
            explosion.setX(this.x);
            explosion.setY(this.y);
            this.millisSinceStart=0;
            hasStartedExplosion = true;
        }
        millisSinceStart += delta;

        //region HOLDING UP THE PLAYER FROM GETTING OUT OF SCREEN
        if(this.x > 765)
        {
            this.x = 765; //RIGHT
        }
        if(this.x < -25)
        {
            this.x = -25; //LEFT
        }
        if(this.y > 555)
        {
            this.y = 555; //BOTTOM
        }
        if(this.y < 50)
        {
            this.y = 50; //LEFT
        }
        //endregion
        //region PLAYER MOVEMENT
        if(gameContainer.getInput().isKeyDown(Input.KEY_A) || gameContainer.getInput().isKeyDown(Input.KEY_LEFT))
        {
            this.x -= playerMovementSpeed;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_D) || gameContainer.getInput().isKeyDown(Input.KEY_RIGHT))
        {
            this.x += playerMovementSpeed;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_S) || gameContainer.getInput().isKeyDown(Input.KEY_DOWN))
        {
            this.y += playerMovementSpeed;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_W) ||  gameContainer.getInput().isKeyDown(Input.KEY_UP))
        {
            this.y -= playerMovementSpeed;
        }
        //endregion
        //region PLAYER COLLISION
        this.collisonShape.setX(this.x);
        this.collisonShape.setY(this.y);
        //endregion
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void addCollisionPartner(ICollision collision)
    {
        this.collisionList.add(collision);
    }

    private boolean isDead(){
        return health <= 0?true:false;

    }

    @Override
    public Shape getShape() {
        return collisonShape;
    }
}
