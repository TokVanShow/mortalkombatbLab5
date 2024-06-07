package fabrics;

import characters.Baraka;
import characters.Player;

import javax.swing.ImageIcon;

/**
 * Фабрика для создания врага Baraka.
 */
public class BarakaFabric implements EnemyFabricInterface {

    /**
     * Создает врага Baraka с заданным уровнем игрока.
     *
     * @param playerLevel уровень игрока
     * @return созданный враг Baraka
     */
    @Override
    public Player create(int playerLevel) {
        return new Baraka(playerLevel + 1, 100 + playerLevel * 5, 12 + playerLevel * 2, 1,
                new ImageIcon(getClass().getResource("/images/baraka.png")));
    }
}
