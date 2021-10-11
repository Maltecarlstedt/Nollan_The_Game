package model;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import org.w3c.dom.css.Rect;
import org.newdawn.slick.geom.Rectangle;

import java.awt.*;
import java.util.ArrayList;

public class MaterialModel {
    public Image scissor;
    private Rectangle scissorLocation;

    public Image scissorUf;
    private Rectangle scissorUfLocation;

    public Image karkort;
    private Rectangle karkortLocation;

    public Image karkortUf;
    private Rectangle karkortUfLocation;

    public Image cardboard;
    private Rectangle cardboardLocation;

    public Image cardboardUf;
    private Rectangle cardboardUfLocation;

    public Image rope;
    private Rectangle ropeLocation;

    public Image ropeUf;
    private Rectangle ropeUfLocation;

    public Image blackColor;
    private Rectangle blackColorLocation;

    public Image blackColorUf;
    private Rectangle blackColorUfLocation;

    public Image turqoiseColor;
    private Rectangle turqoiseColorLocation;

    public Image turqoiseColorUf;
    private Rectangle turqoiseColorUfLocation;

    public Rectangle rect;

    ArrayList<Rectangle> materialsFilled = new ArrayList<>();
    ArrayList<Object> materialsUnfilled = new ArrayList<>();

    public ArrayList<Rectangle> getMaterialsFilled() {return materialsFilled;}
    public ArrayList<Object> getMaterialsUnfilled() {return materialsUnfilled;}

    public MaterialModel() throws SlickException {
        initScissorUf();
        initKarkortUf();
        initCardboardUf();
        initRopeUf();
        initBlackColorUf();
        initTurqoiseColorUf();

        initScissor();
        initRect();
        initKarkort();
        initCardboard();

        materialsFilled.add(scissorLocation);
        materialsFilled.add(karkortLocation);
        materialsFilled.add(cardboardLocation);

        materialsUnfilled.add(scissorUfLocation);
        initRope();
        initBlackColor();
        initTurqoiseColor();
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

    public Rectangle getKarkortLocation(){
        return karkortLocation;
    }

    public void initCardboard() throws SlickException {
        cardboard = new Image("data/material/cardboard.png");
        cardboardLocation = new Rectangle(350, 350,32,32);
    }

    public Rectangle getCardboardLocation(){
        return cardboardLocation;
    }

    public void initScissorUnfilled() throws SlickException {
        scissorUf = new Image("data/material/scissorUnfilled.png");
        scissorUfLocation = new Rectangle(getStartX(), getStartY(),32,32);
    }

    public Rectangle getScissorUnfilledLocation() {
        return scissorUfLocation;
    }

    public void initRope() throws SlickException {
        rope = new Image("data/material/rope.png");
        ropeLocation = new Rectangle(400, 400,32,32);
    }

    public Rectangle getRopeLocation(){
        return ropeLocation;
    }

    public void initBlackColor() throws SlickException {
        blackColor = new Image("data/material/black_color.png");
        blackColorLocation = new Rectangle(450, 450,32,32);
    }

    public Rectangle getBlackColorLocation(){
        return blackColorLocation;
    }

    public void initTurqoiseColor() throws SlickException {
        turqoiseColor = new Image("data/material/turqoise_color.png");
        turqoiseColorLocation = new Rectangle(500, 500,32,32);
    }

    public Rectangle getTurqoiseColorLocation(){
        return turqoiseColorLocation;
    }

    public void initScissorUf() throws SlickException {
        scissorUf = new Image("data/material/scissor_uf.png");
        scissorUfLocation = new Rectangle(getStartX(), getStartY(),32,32);
    }

    public Rectangle getScissorUfLocation(){
        return scissorUfLocation;
    }

    public void initKarkortUf() throws SlickException {
        karkortUf = new Image("data/material/karkortet_uf.png");
        karkortUfLocation = new Rectangle(getStartX()+50,getStartY(),32,32);
    }

    public Rectangle getKarkortUfLocation(){
        return karkortUfLocation;
    }

    public void initCardboardUf() throws SlickException {
        cardboardUf = new Image("data/material/cardboard_uf.png");
        cardboardUfLocation = new Rectangle(getStartX()+100,getStartY(),32,32);
    }

    public Rectangle getCardboardUfLocation(){
        return cardboardUfLocation;
    }

    public void initRopeUf() throws SlickException {
        ropeUf = new Image("data/material/rope_uf.png");
        ropeUfLocation = new Rectangle(getStartX()+150,getStartY(),32,32);
    }

    public Rectangle getRopeUfLocation(){
        return ropeUfLocation;
    }

    public void initBlackColorUf() throws SlickException {
        blackColorUf = new Image("data/material/black_color_uf.png");
        blackColorUfLocation = new Rectangle(getStartX()+200,getStartY(),32,32);
    }

    public Rectangle getBlackColorUfLocation(){
        return blackColorUfLocation;
    }

    public void initTurqoiseColorUf() throws SlickException {
        turqoiseColorUf = new Image("data/material/turqoise_color_uf.png");
        turqoiseColorUfLocation = new Rectangle(getStartX()+250,getStartY(),32,32);
    }

    public Rectangle getTurqoiseColorUfLocation(){
        return turqoiseColorUfLocation;
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
