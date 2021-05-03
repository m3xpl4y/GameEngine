package at.ran.games.RocketGame;

import at.ran.games.RocketGame.interfaces.IActor;
import at.ran.games.RocketGame.interfaces.ICollision;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends BasicGame {

    private List<ICollision> actorList;
    private PlayerFighter playerFighter;
    private NPCEnemy npcEnemy;
    private Laserbeam laserbeam;
    private Sound sound;

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorList = new ArrayList<>();
        Random rnd = new Random();
        PlayerFighter playerFighter = new PlayerFighter();
        this.playerFighter = playerFighter;
        this.actorList.add(playerFighter);
        this.laserbeam = laserbeam;
        //Enemy For-Schleife
        for (int i = 0; i <15; i++) {
            NPCEnemy npcEnemy = new NPCEnemy(rnd.nextInt(800), rnd.nextInt(600)-600, 55, 55,6, 100, 50  );
            this.npcEnemy = npcEnemy;
            this.actorList.add(npcEnemy);
            this.playerFighter.addCollisionPartner(npcEnemy);
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
                Laserbeam laserbeam = new Laserbeam(playerFighter.getX(), playerFighter.getY(), 10.0f);
                this.laserbeam = laserbeam;
                this.actorList.add(laserbeam);
                this.npcEnemy.addCollisionLaserBeamPartner(laserbeam);
                sound.play();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
        if(key == Input.KEY_ESCAPE)
            System.exit(0);
    }



    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Tie Hunter"));
            container.setDisplayMode(800,600,false);
            container.setTargetFrameRate(60);
            container.setVSync(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
