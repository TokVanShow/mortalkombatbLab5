package fabrics;

import characters.Player;
import characters.SubZero;

import javax.swing.ImageIcon;

/**
 * Фабрика для создания врага Sub-Zero.
 */
public class SubZeroFabric implements EnemyFabricInterface {

    /**
     * Создает врага Sub-Zero с заданным уровнем игрока.
     *
     * @param playerLevel уровень игрока
     * @return созданный враг Sub-Zero
     */
    @Override
    public Player create(int playerLevel) {
        return new SubZero(playerLevel + 1, 90 + playerLevel * 5, 14 + playerLevel * 2, 1,
                new ImageIcon(getClass().getResource("/images/sub_zero.png")));
    }
}
