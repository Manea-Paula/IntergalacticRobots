package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class FireballTile extends Tile{
    public FireballTile(int id)
    {
        super(Assets.fireball,id);
    }
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
