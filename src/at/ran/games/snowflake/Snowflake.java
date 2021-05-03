package at.ran.games.snowflake;

import at.ran.games.rectangleGame.Actor;
import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snowflake extends BasicGame {
    private List<Actor> actorList;

    public Snowflake(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.actorList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 25; i++) {
            SnowflakeObj snowFront = new SnowflakeObj(rnd.nextInt(800), rnd.nextInt(600) -600, 35, 35, 8 );
            SnowflakeObj snowMiddle = new SnowflakeObj(rnd.nextInt(800), rnd.nextInt(600)-600, 18, 18, 14 );
            SnowflakeObj snowBack = new SnowflakeObj(rnd.nextInt(800), rnd.nextInt(600)-600, 10, 10, 17 );
            this.actorList.add(snowFront);
            this.actorList.add(snowMiddle);
            this.actorList.add(snowBack);
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        for (Actor items: this.actorList) {
            items.update(delta);
        }
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        for (Actor items: this.actorList) {
            items.render(graphics);
        }
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Snowflake("Snowflake by Max"));
            container.setDisplayMode(800,600,false);
            container.setVSync(true);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
