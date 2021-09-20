package model;

import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;


import java.awt.*;

public class JumpingBeer{

    private Point location;
    private int width;
    private int height;

    private static float gravity = 0.8f;
    private static float jumpStrength = -5;
    private static float speed = 10;

    private static int interations = 5;
    public Image jumpingBeer;

    private float posY;
    private float posX;

    private float vX = 0;
    private float vY = 0;

    private boolean canJump;

    public JumpingBeer() throws SlickException {
        jumpingBeer = new Image("data/model.beerChugging/beerImage.png");
        posY = 635;
        posX = 136;
        width = 48;
        height = 48;
    }



    public void initJumpingBeer(GameContainer gc) throws SlickException {

    }

    public void render(GameContainer gc, Graphics g) throws SlickException {

        jumpingBeer.draw(this.getPosX(),this.getPosY(), this.getWidth(), this.getHeight());


    }

    public void update(GameContainer gc, int delta) throws SlickException{
        vY += gravity;

        if(this.getPosY() > 920){
            canJump = false;
        }else{
            canJump = true;
        }

        if(gc.getInput().isKeyPressed(Input.KEY_F) && canJump){

            this.setY(this.getPosY() - 40);

            if(this.getPosY() < 935){
                vY = jumpStrength;
            }
        }
        if(this.getPosY() > 630){

        }else {
            this.setY(this.getPosY() + 0.5f +vY);
        }

    }

    public float getPosY(){
        return posY;
    }

    public float getPosX(){
        return posX;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setY(float y){
        this.posY = y;
    }




}
