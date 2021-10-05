package Tasks.taskController;

import Tasks.taskModel.BeerChuggingModel;
import Tasks.taskView.BeerChuggingView;
import model.PlayerModel;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class BeerChuggingController {

    private BeerChuggingModel bcm;
    private BeerChuggingView bcv;

    private double speed = 3;

    private static float gravity = 0.7f;
    private static float jumpStrength = -5;

    private float vY = 0;
    private boolean upDir = true;

    private  int numberOfChugs = 0;

    private int chugIndexAnimation = 0;




    public BeerChuggingController(BeerChuggingModel bcm, BeerChuggingView bcv){
        this.bcm = bcm;
        this.bcv = bcv;
    }

    public void update(GameContainer gc, int delta) throws SlickException {
        loopGreenThingyLocation();
        beerJump(gc, delta);
        checkIntersect();
        updateChugAnimation();
        chugTimer(delta);


    }

    public void chugTimer(int delta){
        if(chugIndexAnimation >= 8){
            System.out.println("Bra hävt! Din tid blev: " + bcm.timePassed);
        }else
        // Change from ms to seconds
        bcm.timePassed += (double) delta/1000;
        // Round to two decimals.
        bcm.timePassed = (float) (Math.round(bcm.timePassed * 100.0) / 100.0);
    }

    public void loopGreenThingyLocation() {
        if (upDir) {
            if(bcm.getGreenThingyLocation().y > 326){
                bcm.setGreenThingyLocation((int) (bcm.getGreenThingyLocation().y - speed));
            }else
                upDir = false;
                speed += 0.001;
            }else{
            if(bcm.getGreenThingyLocation().y < 630){
                bcm.setGreenThingyLocation((int) (bcm.getGreenThingyLocation().y + speed));

            }else
                upDir = true;
                speed += 0.001;
        }
    }

    public int checkIntersect(){
        if(bcm.greenThingyReact.intersects(bcm.jumpingBeerRect) || bcm.greenThingyReact.contains(bcm.jumpingBeerRect)){
            numberOfChugs++;
            bcm.inside = true;
            //bcv.renderFlash(bcm);
        }else{
            bcm.inside = false;
        }
        return numberOfChugs;
    }

    // TODO: Skriv om hopp algoritmen och utnyttja delta istället.
    public void beerJump(GameContainer gc, int delta) {
        vY += gravity;
        Input input = gc.getInput();

        if(bcm.getJumpingBeerLocationY() < 370){
        }else
            if (input.isKeyPressed(Input.KEY_SPACE)) {
                bcm.setJumpingBeerLocationY(bcm.getJumpingBeerLocationY() - 25);
                vY = jumpStrength;
        }
        if(bcm.getJumpingBeerLocationY() >= 665){
        }
        else {
            bcm.setJumpingBeerLocationY((int) (bcm.getJumpingBeerLocationY() + 0.2f + vY));
        }
    }

    public void updateChugAnimation() throws SlickException {

        if(numberOfChugs > 30){
            numberOfChugs = 0;

            chugIndexAnimation++;
            if(chugIndexAnimation <= 8){
                bcm.updateChug(chugIndexAnimation);
            }else
                System.out.println();

        }

    }
}
