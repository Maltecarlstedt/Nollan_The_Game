package model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

public class MaterialModel {
    public Image scissor;
    private Point scissorLocation;

    public Image scissorUnfilled;
    private Point scissorUnfilledLocation;

    public Image karkort;
    private Point karkortLocation;

    public Image cardboard;
    private Point cardboardLocation;

    public Rectangle rect;

    public MaterialModel() throws SlickException {
        initScissor();
        initRect();
        initScissorUnfilled();
        initKarkort();
        initCardboard();
    }

    public void initScissor() throws SlickException {
        scissor = new Image("data/material/scissor.png");
        scissorLocation = new Point(200,200);
    }

    public Point getScissorLocation(){
        return scissorLocation;
    }

    public void initKarkort() throws SlickException {
        karkort = new Image("data/material/karkortet.png");
        karkortLocation = new Point(getStartX()+40,getStartY());
    }

    public Point getkarkortLocation(){
        return karkortLocation;
    }

    public void initCardboard() throws SlickException {
        cardboard = new Image("data/material/cardboard.png");
        cardboardLocation = new Point(getStartX()+80,getStartY());
    }

    public Point getCardboardLocation(){
        return cardboardLocation;
    }

    public void initScissorUnfilled() throws SlickException {
        scissorUnfilled = new Image("data/material/scissorUnfilled.png");
        scissorUnfilledLocation = new Point(getStartX(), getStartY());
    }

    public Point getScissorUnfilledLocation(){
        return scissorUnfilledLocation;
    }

    public void initRect(){
        rect = new Rectangle(700,710, 350, 70);
    }

    private int getStartX(){
       return 710;
    }
    private int getStartY(){
        return 725;
    }
}
