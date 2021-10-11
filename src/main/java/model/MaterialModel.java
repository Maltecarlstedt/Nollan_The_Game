package model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;
import java.util.ArrayList;

public class MaterialModel {
    public Image scissor;
    private Rectangle scissorLocation;

    public Image scissorUnfilled;
    private Rectangle scissorUnfilledLocation;

    public Image karkort;
    private Rectangle karkortLocation;

    public Image cardboard;
    private Rectangle cardboardLocation;

    public Rectangle rect;

    ArrayList<Rectangle> materialsFilled = new ArrayList<>();
    ArrayList<Object> materialsUnfilled = new ArrayList<>();

    public ArrayList<Rectangle> getMaterialsFilled() {return materialsFilled;}
    public ArrayList<Object> getMaterialsUnfilled() {return materialsUnfilled;}

    public MaterialModel() throws SlickException {
        initScissor();
        initRect();
        initScissorUnfilled();
        initKarkort();
        initCardboard();

        materialsFilled.add(scissorLocation);
        materialsFilled.add(karkortLocation);
        materialsFilled.add(cardboardLocation);

        materialsUnfilled.add(scissorUnfilledLocation);
    }


    public void initScissor() throws SlickException {
        scissor = new Image("data/material/scissor.png");
        scissorLocation = new Rectangle(200,200,32,32);
    }

    public Rectangle getScissorLocation(){
        return scissorLocation;
    }

    public void initKarkort() throws SlickException {
        karkort = new Image("data/material/karkortet.png");
        karkortLocation = new Rectangle(getStartX()+40,getStartY(),32,32);
    }

    public Rectangle getkarkortLocation(){
        return karkortLocation;
    }

    public void initCardboard() throws SlickException {
        cardboard = new Image("data/material/cardboard.png");
        cardboardLocation = new Rectangle(getStartX()+80,getStartY(),32,32);
    }

    public Rectangle getCardboardLocation(){
        return cardboardLocation;
    }

    public void initScissorUnfilled() throws SlickException {
        scissorUnfilled = new Image("data/material/scissorUnfilled.png");
        scissorUnfilledLocation = new Rectangle(getStartX(), getStartY(),32,32);
    }

    public Rectangle getScissorUnfilledLocation(){
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
