package fabrics;

import characters.Player;
import characters.SonyaBlade;

import javax.swing.ImageIcon;

/**
 * Фабрика для создания врага Sonya Blade.
 */
public class SonyaBladeFabric implements EnemyFabricInterface {

    /**
     * Создает врага Sonya Blade с заданным уровнем игрока.
     *
     * @param playerLevel уровень игрока
     * @return созданный враг Sonya Blade
     */
    @Override
    public Player create(int playerLevel) {
        return new SonyaBlade(playerLevel + 1, 80 + playerLevel * 5, 15 + playerLevel * 2, 1,
                new ImageIcon(getClass().getResource("/images/sonya_blade.png")));
    }
}
