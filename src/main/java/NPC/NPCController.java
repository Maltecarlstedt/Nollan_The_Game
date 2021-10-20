package NPC;

import model.MapModel;
import org.newdawn.slick.SlickException;

public class NPCController {
    NPCModel model;

    public NPCController() throws SlickException {
        model = new NPCModel();
    }

    public void update(MapModel mp) throws SlickException {
        setState(mp);
        chooseSprite();
    }


    public void setState(MapModel mp) {
        for (NPC npc : model.NPCs) {
            if (!mp.taskDone) {
                npc.state = 0;
            } else {
                npc.state = 1;
            }


        }
    }

    public void chooseSprite() throws SlickException {
        for (NPC npc : model.NPCs) {
            if (npc.state == 0) {
                npc.spriteSetupTask();
            } else {
                npc.spriteSetup();
            }
        }
    }
}

