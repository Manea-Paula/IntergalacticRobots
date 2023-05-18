package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Battery3Tile extends Tile{
    /*!
   \brief Constructorul de initializare al clasei

   \param id Id-ul dalei util in desenarea hartii.
*/
    public Battery3Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.battery3, id);
    }
}
