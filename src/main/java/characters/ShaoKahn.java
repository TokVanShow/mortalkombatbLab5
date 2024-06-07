package characters;

import javax.swing.ImageIcon;

/**
 * Класс, представляющий босса Shao Kahn.
 */
public class ShaoKahn extends Player {

    /**
     * Конструктор для создания босса Shao Kahn.
     *
     * @param level   уровень босса
     * @param health  здоровье босса
     * @param damage  урон босса
     * @param attack  атака босса
     * @param icon    иконка босса
     */
    public ShaoKahn(int level, int health, int damage, int attack, ImageIcon icon) {
        super(level, health, damage, attack, icon);
    }

    /**
     * Возвращает имя босса.
     *
     * @return имя босса "Shao Kahn (boss)"
     */
    @Override
    public String getName() {
        return "Shao Kahn (boss)";
    }
}
