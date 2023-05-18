package PaooGame.Tiles;

import PaooGame.Graphics.Assets;

public class Light1 extends Tile{
    /*!
    \brief Constructorul de initializare al clasei

    \param id Id-ul dalei util in desenarea hartii.
 */
    public Light1(int id)
    {
        /// Apel al constructorului clasei de baza
        super(Assets.light1, id);
    }

    /*! \fn public boolean IsSolid()
        \brief Suprascrie metoda IsSolid() din clasa de baza in sensul ca va fi luat in calcul in caz de coliziune.
     */
    @Override
    public boolean IsSolid()
    {
        return true;
    }
}
