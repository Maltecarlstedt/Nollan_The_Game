import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public enum Chalmersplatsen implements MapState {
    CHALMERSPLATSEN;
    @Override
    public void nextState(Map input, Player player){
        switch (input.getPOrientation(player)) {
            case LEFT -> input.setTiledMap(Chalmersplatsen.CHALMERSPLATSEN);
            case DOWN -> input.setTiledMap(Karhuset.KARHUSET);
        }
    }

    @Override
    public void setPosition(Player player) {
        player.setLocation(450,500);
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(("data/maps/chalmershallplatsen.tmx"));
    }
}

