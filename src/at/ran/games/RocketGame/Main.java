package at.ran.games.RocketGame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends BasicGame {

    private List<IActor> actorList;
    private PlayerFighter playerFighter;
    private Sound sound;

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorList = new ArrayList<>();
        PlayerFighter playerFighter = new PlayerFighter();
        this.playerFighter = playerFighter;
        this.actorList.add(playerFighter);
        Random rnd = new Random();
        for (int i = 0; i <15; i++) {
            NPCEnemy npcEnemy = new NPCEnemy(rnd.nextInt(800), rnd.nextInt(600)-600, 55, 55,6);
            this.actorList.add(npcEnemy);
            this.playerFighter.addCollisonPartner(npcEnemy);
         }
        sound = new Sound("src/at/ran/games/RocketGame/sounds/XWing-Laser.wav");
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (IActor items : this.actorList) {
            items.update(gameContainer, delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (IActor items: this.actorList) {
            items.render(graphics);
        }
    }

    @Override
    public void keyPressed(int key, char c) {
        if(key == Input.KEY_SPACE)
        {
            try {
                Laserbeam lb_left = new Laserbeam(playerFighter.getX(), playerFighter.getY());
                Laserbeam lb_right = new Laserbeam(playerFighter.getX() +68, playerFighter.getY());
                this.actorList.add(lb_left);
                this.actorList.add(lb_right);
                sound.play();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Tie Hunter"));
            container.setDisplayMode(800,600,false);
            container.setTargetFrameRate(60);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
