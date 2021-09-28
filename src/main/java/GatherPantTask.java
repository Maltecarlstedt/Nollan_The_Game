import controller.PlayerController;
import model.PlayerModel;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import view.PlayerView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class GatherPantTask extends BasicGameState implements ActionListener {

    PlayerModel playerModel;
    PlayerView playerView;
    PlayerController playerController;

    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 32;
    static final int DELAY = 75;

    private int pantGathered;
    private int pantX;
    private int pantY;

    private Timer timer;
    Random random;
    Boolean running = false;

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        random = new Random();
        newPant(); // create new pant
        running = true;
        timer = new Timer(DELAY,this);
        timer.start();
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        playerView.render(gc, g, playerModel);

        if (running) {
            g.setColor(Color.red);
            g.fillOval(pantX, pantY, UNIT_SIZE, UNIT_SIZE);
            g.setColor(Color.cyan);
            g.drawString("Score: " + pantGathered, 10,10);
        } else {
            timer.stop();
            gameOver(g);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        playerController.update(gc,delta);

    }

    @Override
    public int getID() {
        return 0;
    }

    public void newPant() {
        pantX = random.nextInt((int)(SCREEN_WIDTH/UNIT_SIZE))*UNIT_SIZE; // pant på en ruta som är 32x32
        pantY = random.nextInt((int)(SCREEN_HEIGHT/UNIT_SIZE))*UNIT_SIZE; // pant på en ruta som är 32x32
    }

    public void checkPant() {
        if ((playerModel.getPlayerLocation().x == pantX) && (playerModel.getOrientation().deltaY == pantY)) {
            pantGathered++;
            newPant();
        }
    }

    public void gameOver(Graphics g) {
        // Game over text
        g.setColor(Color.red);
        g.drawString("Game over", 1024/3,768/3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {
            checkPant();
        }
    }
}
