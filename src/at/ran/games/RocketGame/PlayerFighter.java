package at.ran.games.RocketGame;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class PlayerFighter implements IActor{

    private int x = 370;
    private int y = 520;
    private Image playerImage;
    private Shape collisonShape;

    public PlayerFighter() throws SlickException {
       Image tmp = new Image("src/at/ran/games/RocketGame/images/xwing.png");
        this.playerImage = tmp.getScaledCopy(75,75);
        this.collisonShape = new Circle(this.x,this.y, playerImage.getWidth()/2, playerImage.getHeight()/2);
    }

    @Override
    public void render(Graphics graphics) {
        playerImage.draw(this.x, this.y);
        //graphics.draw(this.collisonShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_A) || gameContainer.getInput().isKeyDown(Input.KEY_LEFT))
        {
            this.x -= 4;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_D) || gameContainer.getInput().isKeyDown(Input.KEY_RIGHT))
        {
            this.x += 4;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_S) || gameContainer.getInput().isKeyDown(Input.KEY_DOWN))
        {
            this.y += 4;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_W) ||  gameContainer.getInput().isKeyDown(Input.KEY_UP))
        {
            this.y -= 4;
        }
        this.collisonShape.setX(this.x);
        this.collisonShape.setY(this.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
