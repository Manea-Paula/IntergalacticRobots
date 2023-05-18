package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class PortalLevel2Tile extends Tile {
    /*!
   \brief Constructorul de initializare al clasei

   \param id Id-ul dalei util in desenarea hartii.
*/
    public PortalLevel2Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.portal2, id);
    }
}
