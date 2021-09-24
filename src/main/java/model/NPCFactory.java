package model;

public class NPCFactory {

    //public NPC npc = new NPC();

    //TODO: villkorssatser för nya objektets plats, bild etc och jämföra
    // med de redan existerande objekten?
    public NPC getNPC(String NPCType){
        if(NPCType == null){
            return null;
        }
        if(NPCType.equals("DNOLLK")){
            //return new DNollK(villkor);
        }

        return null;
    }

}
