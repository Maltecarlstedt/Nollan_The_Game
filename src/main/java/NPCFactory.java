import org.newdawn.slick.SlickException;

public class NPCFactory {

    //public NPC npc = new NPC();

    //TODO: villkorssatser för nya objektets plats, bild etc och jämföra
    // med de redan existerande objekten?
    public NPC getNPC(String NPCType) throws SlickException {
        if(NPCType == null){
            return null;
        }
        if(NPCType.equals("Webers")){
            return new Webers();
        }



        return null;
    }

}
