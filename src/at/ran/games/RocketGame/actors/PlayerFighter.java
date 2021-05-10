package at.ran.games.RocketGame.actors;

import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.util.ArrayList;
import java.util.List;

public class PlayerFighter implements ICollision {

    private int playerMovementSpeed = 4;
    private int x = 370;
    private int y = 520;
    private Image playerImage;
    private Shape collisonShape;
    private List<ICollision> collisionList;
    int counter = 0;

    public PlayerFighter() throws SlickException {
       Image tmp = new Image("src/at/ran/games/RocketGame/images/xwing.png");
        this.playerImage = tmp.getScaledCopy(75,75);
        this.collisonShape = new Circle(this.x,this.y, playerImage.getWidth()/2, playerImage.getHeight()/2);
        this.collisionList = new ArrayList<ICollision>();
    }

    @Override
    public void render(Graphics graphics) {
        playerImage.draw(this.x, this.y);
        graphics.draw(this.collisonShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        for (ICollision collision: collisionList) {
            if(this.collisonShape.intersects(collision.getShape()))
            {
                counter++;
                System.out.println("Collision: " + counter);
            }
        }

        //region HOLDING UP THE PLAYER FROM GETTING OUT OF SCREEN
        if(this.x > 775)
        {
            this.x = 775; //RIGHT
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

    @Override
    public Shape getShape() {
        return collisonShape;
    }
}
