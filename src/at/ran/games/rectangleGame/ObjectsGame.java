package at.ran.games.rectangleGame;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ObjectsGame extends BasicGame {
    private List<Actor> actorList;

    public ObjectsGame(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
            this.actorList = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            Rectangle rectangle = new Rectangle(rnd.nextInt(800),rnd.nextInt(600), 10, "left");
            Circle circle = new Circle(rnd.nextInt(800),rnd.nextInt(600), 8);
            Eclipsen eclipsen = new Eclipsen(rnd.nextInt(800), rnd.nextInt(600), 8);
            this.actorList.add(rectangle);
            this.actorList.add(circle);
            this.actorList.add(eclipsen);
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
            AppGameContainer container = new AppGameContainer(new ObjectsGame("Aufgabe Rectangle & Co"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
