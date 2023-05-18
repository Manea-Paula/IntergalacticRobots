package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Battery2Tile extends Tile{
    /*!
   \brief Constructorul de initializare al clasei

   \param id Id-ul dalei util in desenarea hartii.
*/
    public Battery2Tile(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.battery2, id);
    }
}
