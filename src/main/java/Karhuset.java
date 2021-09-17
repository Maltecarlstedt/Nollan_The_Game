import org.newdawn.slick.*;
import org.newdawn.slick.tiled.TiledMap;

public enum Karhuset implements MapState {
    KARHUSET;
    @Override
    public void nextState(Map input, Player player){
        switch (input.getPOrientation(player)) {
            case LEFT:
                input.setTiledMap(Karhuset.KARHUSET);
                break;
            case DOWN:
                input.setTiledMap(Chalmersplatsen.CHALMERSPLATSEN);
                break;
        }
    }

    @Override
    public void setPosition(Player player) {
        player.setLocation(150,200);
    }

    @Override
    public TiledMap loadMap() throws SlickException {
        return new TiledMap(("data/maps/karhuset.tmx"));

    }
}
