package at.ran.games.RocketGame;

import at.ran.games.RocketGame.actors.Explosion;
import at.ran.games.RocketGame.actors.Laserbeam;
import at.ran.games.RocketGame.actors.NPCEnemy;
import at.ran.games.RocketGame.actors.PlayerFighter;
import at.ran.games.RocketGame.interfaces.IActor;
import at.ran.games.RocketGame.interfaces.ICollision;
import at.ran.games.RocketGame.vo.GamePoint;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main extends BasicGame {

    private List<ICollision> actorList;
    private List<NPCEnemy> npcEnemyList;
    private List<Laserbeam> laserbeamList;
    private PlayerFighter playerFighter;
    private Sound sound;

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorList = new ArrayList<>();
        this.npcEnemyList = new ArrayList<>();
        this.laserbeamList = new ArrayList<>();
        Random rnd = new Random();
        PlayerFighter playerFighter = new PlayerFighter();
        this.playerFighter = playerFighter;
        this.actorList.add(playerFighter);

        //Enemy For-Schleife
        for (int i = 0; i <10; i++) {
            NPCEnemy npcEnemy = new NPCEnemy(rnd.nextInt(800), rnd.nextInt(600)-600, 55, 55,15, 100, 50  );
            this.npcEnemyList.add(npcEnemy);
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
                GamePoint coordinates = GameHelper.getLeftPosition(playerFighter.getX() , playerFighter.getY());
                GamePoint coordinates2 = GameHelper.getRightPosition(playerFighter.getX(), playerFighter.getY());
                Laserbeam laserbeam = new Laserbeam(coordinates);
                Laserbeam laserbeam2 = new Laserbeam(coordinates2);

                this.actorList.add(laserbeam);
                this.actorList.add(laserbeam2);

                for (NPCEnemy items: npcEnemyList) {
                    items.addCollisionLaserBeamPartner(laserbeam);
                    items.addCollisionLaserBeamPartner(laserbeam2);
                    laserbeam.addCollisionNPCLaserbeam(items);
                }
                sound.play();
            } catch (SlickException e) {
                e.printStackTrace();
            }
        }
        if(key == Input.KEY_ESCAPE)
            System.exit(0);
    }

    public Graphics renderG()
    {
        Graphics g = new Graphics();
        return g;
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
