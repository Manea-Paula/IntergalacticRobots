package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class LightTile extends Tile{
    public LightTile(int id)
    {
        super(Assets.light,id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
