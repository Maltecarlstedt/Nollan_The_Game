package view;

import model.MapStates.Ekak;
import model.MapStates.MapState;
import org.newdawn.slick.tiled.TiledMap;

import java.util.HashMap;
import java.util.Map;

public enum ViewTranslator {
    ;
    private static final Map<Class<? extends MapState>, ScreenViewModel> screenViews;

    static {
        screenViews = new HashMap<>();
        screenViews.put(Ekak.class, new EkakViewModel());
    }

    public static TiledMap translateToView(MapState m) {
        return screenViews.get(m.getClass()).loadMap();
    }

    private static class EkakViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() {
            return null;
        }
    }
}
