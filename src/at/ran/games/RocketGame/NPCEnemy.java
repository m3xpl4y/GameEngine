package at.ran.games.RocketGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class NPCEnemy implements IActor{

    private float x,y;
    private int speed;
    private Image NPCimage;
    private Shape collisonShape;


    public NPCEnemy(float x, float y, float w, float h, int speed) throws SlickException {
        Image tmp = new Image("src/at/ran/games/RocketGame/images/tieFighter.png");
        this.NPCimage = tmp.getScaledCopy(55, 55);
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.collisonShape = new Rectangle(this.x,this.y, NPCimage.getWidth(), NPCimage.getHeight());
    }

    @Override
    public void render(Graphics graphics) {
        NPCimage.draw(this.x,this.y);
        //graphics.draw(this.collisonShape);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        this.y += (float) delta/speed;
        if(this.y > 600)
        {
            this.y = -200;
        }
        this.collisonShape.setX(this.x);
        this.collisonShape.setY(this.y);
    }
}
