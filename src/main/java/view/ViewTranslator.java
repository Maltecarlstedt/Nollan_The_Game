package view;

import model.MapStates.*;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.util.HashMap;
import java.util.Map;

public enum ViewTranslator {
    ;
    private static final Map<Class<? extends MapState>, ScreenViewModel> screenViews;

    static {
        screenViews = new HashMap<>();
        screenViews.put(Chalmersplatsen.class, new ChalmersplatsenViewModel());
        screenViews.put(Dammen.class, new DammenViewModel());
        screenViews.put(DeltaP.class, new DeltaPViewModel());
        screenViews.put(Ekak.class, new EkakViewModel());
        screenViews.put(Gasquen.class, new GasquenViewModel());
        screenViews.put(Karhuset.class, new KarhusetViewModel());
        screenViews.put(Markena.class, new MarkenaViewModel());
        screenViews.put(Maskin.class, new MaskinViewModel());
        screenViews.put(Rannan.class, new RannanViewModel());
        screenViews.put(Sandladan.class, new SandladanViewModel());
    }

    public static TiledMap translateToView(MapState m) throws SlickException {
        return screenViews.get(m.getClass()).loadMap();
    }

    private static class ChalmersplatsenViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Chalmersplatsen.INSTANCE.loadMap();
        }
    }

    private static class DammenViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Dammen.INSTANCE.loadMap();
        }
    }

    private static class DeltaPViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return DeltaP.INSTANCE.loadMap();
        }
    }

    private static class EkakViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Ekak.INSTANCE.loadMap();
        }
    }

    private static class GasquenViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Gasquen.INSTANCE.loadMap();
        }
    }

    private static class KarhusetViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Karhuset.INSTANCE.loadMap();
        }
    }

    private static class MarkenaViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Markena.INSTANCE.loadMap();
        }
    }

    private static class MaskinViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Maskin.INSTANCE.loadMap();
        }
    }

    private static class RannanViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Rannan.INSTANCE.loadMap();
        }
    }

    private static class SandladanViewModel implements ScreenViewModel {
        @Override
        public TiledMap loadMap() throws SlickException {
            return Sandladan.INSTANCE.loadMap();
        }
    }
}
