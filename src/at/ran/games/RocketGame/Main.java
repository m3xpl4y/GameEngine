package at.ran.games.RocketGame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends BasicGame {

    private List<IActor> actorList;

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorList = new ArrayList<>();
        PlayerFighter playerFighter = new PlayerFighter();
        this.actorList.add(playerFighter);
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
