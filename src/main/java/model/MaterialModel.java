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

    public Image scissorUf;
    private Point scissorUfLocation;

    public Image karkort;
    private Point karkortLocation;

    public Image karkortUf;
    private Point karkortUfLocation;

    public Image cardboard;
    private Point cardboardLocation;

    public Image cardboardUf;
    private Point cardboardUfLocation;

    public Image rope;
    private Point ropeLocation;

    public Image ropeUf;
    private Point ropeUfLocation;

    public Image blackColor;
    private Point blackColorLocation;

    public Image blackColorUf;
    private Point blackColorUfLocation;

    public Image turqoiseColor;
    private Point turqoiseColorLocation;

    public Image turqoiseColorUf;
    private Point turqoiseColorUfLocation;

    public Rectangle rect;

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
        initRope();
        initBlackColor();
        initTurqoiseColor();
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
        karkortLocation = new Point(300, 300);
    }

    public Point getKarkortLocation(){
        return karkortLocation;
    }

    public void initCardboard() throws SlickException {
        cardboard = new Image("data/material/cardboard.png");
        cardboardLocation = new Point(350, 350);
    }

    public Point getCardboardLocation(){
        return cardboardLocation;
    }

    public void initRope() throws SlickException {
        rope = new Image("data/material/rope.png");
        ropeLocation = new Point(400, 400);
    }

    public Point getRopeLocation(){
        return ropeLocation;
    }

    public void initBlackColor() throws SlickException {
        blackColor = new Image("data/material/black_color.png");
        blackColorLocation = new Point(450, 450);
    }

    public Point getBlackColorLocation(){
        return blackColorLocation;
    }

    public void initTurqoiseColor() throws SlickException {
        turqoiseColor = new Image("data/material/turqoise_color.png");
        turqoiseColorLocation = new Point(500, 500);
    }

    public Point getTurqoiseColorLocation(){
        return turqoiseColorLocation;
    }

    public void initScissorUf() throws SlickException {
        scissorUf = new Image("data/material/scissor_uf.png");
        scissorUfLocation = new Point(getStartX(), getStartY());
    }

    public Point getScissorUfLocation(){
        return scissorUfLocation;
    }

    public void initKarkortUf() throws SlickException {
        karkortUf = new Image("data/material/karkortet_uf.png");
        karkortUfLocation = new Point(getStartX()+50,getStartY());
    }

    public Point getKarkortUfLocation(){
        return karkortUfLocation;
    }

    public void initCardboardUf() throws SlickException {
        cardboardUf = new Image("data/material/cardboard_uf.png");
        cardboardUfLocation = new Point(getStartX()+100,getStartY());
    }

    public Point getCardboardUfLocation(){
        return cardboardUfLocation;
    }

    public void initRopeUf() throws SlickException {
        ropeUf = new Image("data/material/rope_uf.png");
        ropeUfLocation = new Point(getStartX()+150,getStartY());
    }

    public Point getRopeUfLocation(){
        return ropeUfLocation;
    }

    public void initBlackColorUf() throws SlickException {
        blackColorUf = new Image("data/material/black_color_uf.png");
        blackColorUfLocation = new Point(getStartX()+200,getStartY());
    }

    public Point getBlackColorUfLocation(){
        return blackColorUfLocation;
    }

    public void initTurqoiseColorUf() throws SlickException {
        turqoiseColorUf = new Image("data/material/turqoise_color_uf.png");
        turqoiseColorUfLocation = new Point(getStartX()+250,getStartY());
    }

    public Point getTurqoiseColorUfLocation(){
        return turqoiseColorUfLocation;
    }

    public void initRect(){
        rect = new Rectangle(700,710, 350, 70);
    }

    private int getStartX(){
       return 720;
    }
    private int getStartY(){
        return 725;
    }
}
