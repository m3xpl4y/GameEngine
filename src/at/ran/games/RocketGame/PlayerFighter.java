package at.ran.games.RocketGame;

import org.newdawn.slick.*;

public class PlayerFighter implements IActor{

    private int x = 370;
    private int y = 520;
    private int h,w;
    private Image playerImage;

    public PlayerFighter() throws SlickException {
       Image tmp = new Image("src/at/ran/games/RocketGame/images/xwing.png");
        this.playerImage = tmp.getScaledCopy(60,60);
    }

    @Override
    public void render(Graphics graphics) {
        playerImage.draw(this.x, this.y);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if(gameContainer.getInput().isKeyDown(Input.KEY_A))
        {
            this.x -= 4;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_D))
        {
            this.x += 4;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_S))
        {
            this.y += 4;
        }
        if(gameContainer.getInput().isKeyDown(Input.KEY_W))
        {
            this.y -= 4;
        }
    }
}
