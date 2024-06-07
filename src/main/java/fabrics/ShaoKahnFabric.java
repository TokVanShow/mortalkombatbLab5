package fabrics;

import characters.Player;
import characters.ShaoKahn;

import javax.swing.ImageIcon;

/**
 * Фабрика для создания врага Shao Kahn.
 */
public class ShaoKahnFabric implements EnemyFabricInterface {

    /**
     * Создает врага Shao Kahn с заданным уровнем игрока.
     *
     * @param playerLevel уровень игрока
     * @return созданный враг Shao Kahn
     */
    @Override
    public Player create(int playerLevel) {
        return new ShaoKahn(playerLevel + 1, 150 + playerLevel * 5, 20 + playerLevel * 2, 1,
                new ImageIcon(getClass().getResource("/images/shao_kahn.png")));
    }
}
